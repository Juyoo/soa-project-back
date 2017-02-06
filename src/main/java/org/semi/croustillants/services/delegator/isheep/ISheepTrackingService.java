package org.semi.croustillants.services.delegator.isheep;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.semi.croustillants.exception.RestISheepServiceException;
import org.semi.croustillants.model.isheep.Shipping;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;

import static org.semi.croustillants.IntegrationApplication.I_SHEEP_TOKEN;
import static org.semi.croustillants.IntegrationApplication.SHIPPING_BASE_URL;

/**
 * Created by raymo on 06/02/2017.
 */
@Service
public class ISheepTrackingService {


    private final ObjectMapper mapper;

    @Inject
    public ISheepTrackingService(final ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public Shipping.Tracking trackingStatus(final String shippingId) {
        try {
            final RestOperations restTemplate = new RestTemplate();
            return restTemplate.exchange(
                    SHIPPING_BASE_URL + "/shipping-" + shippingId,
                    HttpMethod.GET,
                    prepareEntity(),
                    Shipping.Tracking.class
            ).getBody();
        }catch (final Throwable t) {
            throw new RestISheepServiceException("Error occured on isheep service job when creating shipping: " + t.getMessage(), t);
        }
    }

    private HttpEntity<String> prepareEntity() throws JsonProcessingException {
        final HttpHeaders headers = new HttpHeaders();
        headers.set("X-Authorization", I_SHEEP_TOKEN);

        return new HttpEntity<>(headers);
    }

}
