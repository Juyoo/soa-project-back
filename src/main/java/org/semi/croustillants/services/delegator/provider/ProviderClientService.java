package org.semi.croustillants.services.delegator.provider;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.semi.croustillants.exception.RestProviderServiceException;
import org.semi.croustillants.model.provider.ProviderClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;

import static org.semi.croustillants.IntegrationApplication.PROVIDER_BASE_URL;

/**
 * Created by raymo on 05/02/2017.
 */
@Service
public class ProviderClientService {

    private final ObjectMapper mapper;

    @Inject
    public ProviderClientService(final ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public ProviderClient registerClient(final ProviderClient client) {
        try {
            final RestOperations restTemplate = new RestTemplate();
            return restTemplate.postForObject(PROVIDER_BASE_URL + "/clients", prepareEntity(client), ProviderClient.class);
        } catch (final Throwable t) {
            throw new RestProviderServiceException("Error occured on provider service job when creating client: " + t.getMessage(), t);
        }
    }

    private HttpEntity<String> prepareEntity(final ProviderClient object) throws JsonProcessingException {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        final String json = mapper.writeValueAsString(object);
        return new HttpEntity<>(json, headers);
    }


}
