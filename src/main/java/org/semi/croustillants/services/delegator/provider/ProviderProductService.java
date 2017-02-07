package org.semi.croustillants.services.delegator.provider;

import org.semi.croustillants.exception.RestProviderServiceException;
import org.semi.croustillants.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.semi.croustillants.IntegrationApplication.PROVIDER_BASE_URL;

/**
 * Created by raymo on 07/02/2017.
 */
@Service
public class ProviderProductService {

    public List<Product> findAll() {
        try {
            final RestOperations restTemplate = new RestTemplate();

            return Arrays.asList(restTemplate.getForObject(PROVIDER_BASE_URL + "/products", Product[].class));
        } catch (final Throwable t) {
            throw new RestProviderServiceException("Error occured on provider service job when requesting products: " + t.getMessage(), t);
        }
    }

}
