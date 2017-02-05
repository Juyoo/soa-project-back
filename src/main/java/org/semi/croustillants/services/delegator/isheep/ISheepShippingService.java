package org.semi.croustillants.services.delegator.isheep;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.semi.croustillants.IntegrationApplication;
import org.semi.croustillants.exception.RestISheepServiceException;
import org.semi.croustillants.model.isheep.Shipping;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;

import static org.semi.croustillants.IntegrationApplication.*;
import static org.semi.croustillants.IntegrationApplication.I_SHEEP_TOKEN;

/**
 * Created by raymo on 05/02/2017.
 */
@Service
public class ISheepShippingService {

    private final ObjectMapper mapper;

    @Inject
    public ISheepShippingService(final ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public Shipping createShipping(final Shipping shipping) {
        try {
            final RestOperations restTemplate = new RestTemplate();
            return restTemplate.postForObject(SHIPPING_BASE_URL + "/shipping", prepareEntity(shipping), Shipping.class);
        }catch (final Throwable t) {
            throw new RestISheepServiceException("Error occured on isheep service job when creating shipping: " + t.getMessage(), t);
        }
    }

    private HttpEntity<String> prepareEntity(final Shipping object) throws JsonProcessingException {
        final HttpHeaders headers = new HttpHeaders();
        headers.set("X-Authorization", I_SHEEP_TOKEN);
        headers.setContentType(MediaType.APPLICATION_JSON);

        final String json = mapper.writeValueAsString(object);
        return new HttpEntity<>(json, headers);
    }

}
