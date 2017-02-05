package org.semi.croustillants.services.delegator.provider;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.semi.croustillants.IntegrationApplication;
import org.semi.croustillants.exception.RestProviderServiceException;
import org.semi.croustillants.model.Client;
import org.semi.croustillants.model.Transaction;
import org.semi.croustillants.model.provider.BillForm;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;

import static org.semi.croustillants.IntegrationApplication.PROVIDER_BASE_URL;

/**
 * Created by raymo on 05/02/2017.
 */
@Service
public class ProviderBillService {

    private final ObjectMapper mapper;

    @Inject
    public ProviderBillService(final ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public void createBill(final BillForm billForm) {
        try {
            final RestTemplate restTemplate = new RestTemplate();
            final ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(PROVIDER_BASE_URL + "/bills", prepareEntity(billForm), String.class);
            String dd = stringResponseEntity.getBody();


        } catch (final Throwable t) {
            throw new RestProviderServiceException("Error occured on provider service job when creating client: " + t.getMessage(), t);
        }
    }

    private HttpEntity<String> prepareEntity(final BillForm billForm) throws JsonProcessingException {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        final String json = mapper.writeValueAsString(billForm);
        return new HttpEntity<>(json, headers);
    }

}
