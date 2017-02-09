package org.semi.croustillants.services;

import org.semi.croustillants.model.TransactionRequest;
import org.semi.croustillants.model.Transaction;
import org.semi.croustillants.model.isheep.Shipping;
import org.semi.croustillants.model.provider.BillForm;
import org.semi.croustillants.services.delegator.isheep.ISheepShippingService;
import org.semi.croustillants.services.delegator.payment.PaymentTransactionService;
import org.semi.croustillants.services.delegator.provider.ProviderBillService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Date;

/**
 * Created by raymo on 05/02/2017.
 */
@Service
public class TransactionService {

    private final PaymentTransactionService paymentTransactionService;
    private final ProviderBillService providerBillService;
    private final ISheepShippingService iSheepShippingService;

    @Inject
    public TransactionService(final PaymentTransactionService paymentTransactionService, final ProviderBillService providerBillService, final ISheepShippingService iSheepShippingService) {
        this.paymentTransactionService = paymentTransactionService;
        this.providerBillService = providerBillService;
        this.iSheepShippingService = iSheepShippingService;
    }

    public Transaction placeOrder(final TransactionRequest transactionRequest) {
        final BillForm billForm = new BillForm(transactionRequest.getClient().getProviderServiceId(), transactionRequest.getCart());
        providerBillService.createBill(billForm);


        Shipping shipping = createShippingFromRequest(transactionRequest);
        shipping = iSheepShippingService.createShipping(shipping);

        final Integer cartPrice = transactionRequest.getCart().getProductWithQties().stream().mapToInt(pwq -> pwq.getProduct().getPrice() * pwq.getQuantity()).sum();
        final Float totalPrice = cartPrice + shipping.getPrice();

        Transaction transaction = new Transaction(
                null, transactionRequest.getClient().getPaymentServiceId(), new Date(), totalPrice, true, "", transactionRequest.getClient().getPaymentServiceToken(), 0
        );
        transaction = paymentTransactionService.createTransaction(transaction, transactionRequest.getClient());

        transaction.setShipping(shipping);
        return transaction;
    }


    public Price estimateShipping(final TransactionRequest transactionRequest) {
        return new Price(iSheepShippingService.estimate(createShippingFromRequest(transactionRequest)));
    }

    private Shipping createShippingFromRequest(final TransactionRequest transactionRequest) {
        final Shipping.Parcel parcel = new Shipping.Parcel(32f, 32f, 32f, 60f);

        return new Shipping(
                new Shipping.Name(
                        transactionRequest.getClient().getFirstName(),
                        transactionRequest.getClient().getLastName()
                ),
                transactionRequest.getRecipientAddress(),
                parcel
        );
    }

    public static class Price {
        private final Float price;

        public Price(final Float price) {
            this.price = price;
        }

        public Float getPrice() {
            return price;
        }
    }

}
