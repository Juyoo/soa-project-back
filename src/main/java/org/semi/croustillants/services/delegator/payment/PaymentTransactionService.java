package org.semi.croustillants.services.delegator.payment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.semi.croustillants.exception.RestPaymentServiceException;
import org.semi.croustillants.model.Client;
import org.semi.croustillants.model.Transaction;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;

import static org.semi.croustillants.IntegrationApplication.PAYMENT_BASE_URL;

/**
 * Created by raymo on 05/02/2017.
 */
@Service
public class PaymentTransactionService {

    private final ObjectMapper mapper;

    @Inject
    public PaymentTransactionService(final ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public Transaction createTransaction(final Transaction transaction, final Client client) {
        try {
            final RestOperations restTemplate = new RestTemplate();
            final IdHolder[] idHolders = restTemplate.postForObject(PAYMENT_BASE_URL + "/transac/add/token=" + client.getPaymentServiceToken(), prepareEntity(transaction), IdHolder[].class);
            final Long lastTransactionId = idHolders[idHolders.length - 1].getId();

            restTemplate.postForEntity(PAYMENT_BASE_URL + "/transac/valid/token=" + client.getPaymentServiceToken(), prepareEntity(transaction), String.class);

            transaction.setId(lastTransactionId);
            return transaction;
        } catch (final Throwable t) {
            throw new RestPaymentServiceException("Error occured on payment service job when creating transaction: " + t.getMessage(), t);
        }
    }


    private HttpEntity<String> prepareEntity(final Transaction object) throws JsonProcessingException {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String json = mapper.writeValueAsString(object);
        // Remove the shipping attribute from JSON.... what a fucking hugly way to handle this....
        json = json.replaceAll(",\"shipping\":(null|\\{.*?})}", "}");
        return new HttpEntity<>(json, headers);
    }

    public static class IdHolder {

        private Long id;

        public IdHolder() {
            this.id = id;
        }

        public Long getId() {
            return id;
        }
    }

}
