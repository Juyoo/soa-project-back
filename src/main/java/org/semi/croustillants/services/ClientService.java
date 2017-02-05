package org.semi.croustillants.services;

import org.semi.croustillants.model.Client;
import org.semi.croustillants.model.payment.PaymentClient;
import org.semi.croustillants.model.provider.ProviderClient;
import org.semi.croustillants.services.delegator.payment.PaymentClientService;
import org.semi.croustillants.services.delegator.provider.ProviderClientService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by raymo on 04/02/2017.
 */
@Service
public class ClientService {

    private final PaymentClientService paymentClientService;
    private final ProviderClientService providerClientService;

    @Inject
    public ClientService(final PaymentClientService paymentClientService, final ProviderClientService providerClientService) {
        this.paymentClientService = paymentClientService;
        this.providerClientService = providerClientService;
    }

    public Client registerClient(final Client client) {
        final PaymentClient paymentClient = paymentClientService.registerClient(
                new PaymentClient(null, client.getFirstName(), client.getLastName(), client.getLogin(), client.getPassword(), null, null)
        );

        final ProviderClient providerClient = providerClientService.registerClient(
                new ProviderClient(null, client.getFirstName(), client.getLastName())
        );

        return new Client(paymentClient, providerClient);
    }

}
