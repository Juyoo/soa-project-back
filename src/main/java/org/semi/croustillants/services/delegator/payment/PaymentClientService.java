package org.semi.croustillants.services.delegator.payment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.semi.croustillants.model.payment.PaymentClient;
import org.semi.croustillants.exception.RestPaymentServiceException;
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
public class PaymentClientService {

    private final ObjectMapper mapper;

    @Inject
    public PaymentClientService(final ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public PaymentClient registerClient(final PaymentClient client) {
        try {
            final RestOperations restTemplate = new RestTemplate();
            restTemplate.postForEntity(PAYMENT_BASE_URL + "/client/add", prepareEntity(client), String.class);

            final String token = restTemplate.getForObject(PAYMENT_BASE_URL + "/login=" + client.getLogin() + "-password=" + client.getPwd(), PaymentClientService.TokenHolder[].class)[0].getToken();

            final PaymentClient registeredClient = restTemplate.getForObject(PAYMENT_BASE_URL + "/client/token=" + token, PaymentClient[].class)[0];
            registeredClient.setPwd(client.getPwd());
            return registeredClient;
        } catch (Throwable t) {
            throw new RestPaymentServiceException("Error occured on payment service job when creating client: " + t.getMessage(), t);
        }
    }

    private HttpEntity<String> prepareEntity(final PaymentClient object) throws JsonProcessingException {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        final String json = mapper.writeValueAsString(object);
        return new HttpEntity<>(json, headers);
    }

    static class TokenHolder {
        private String token;

        public TokenHolder() {
        }

        public String getToken() {
            return token;
        }
    }

}
