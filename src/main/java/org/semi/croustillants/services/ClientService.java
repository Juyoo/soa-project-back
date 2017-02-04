package org.semi.croustillants.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.semi.croustillants.model.payment.PaymentClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;

import java.util.List;

import static org.semi.croustillants.IntegrationApplication.PAYMENT_BASE_URL;

/**
 * Created by raymo on 04/02/2017.
 */
@Service
public class ClientService {

    private final ObjectMapper mapper;

    @Inject
    public ClientService(final ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public PaymentClient registerClient(final PaymentClient client) throws JsonProcessingException {
        final RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<String> registerResponse = restTemplate.postForEntity(PAYMENT_BASE_URL + "/client/add", prepareEntity(client), String.class);

        final String token = restTemplate.getForObject(PAYMENT_BASE_URL + "/login=" + client.getLogin() + "-password=" + client.getPwd(), TokenHolder[].class)[0].getToken();

        return restTemplate.getForObject(PAYMENT_BASE_URL + "/client/token=" + token, PaymentClient[].class)[0];
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
