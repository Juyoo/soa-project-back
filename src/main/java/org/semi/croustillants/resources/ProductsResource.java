package org.semi.croustillants.resources;

import org.semi.croustillants.model.Product;
import org.semi.croustillants.services.delegator.provider.ProviderProductService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by raymo on 07/02/2017.
 */
@RestController
@RequestMapping(value = "/products")
public class ProductsResource {

    private final ProviderProductService productService;

    @Inject
    public ProductsResource(final ProviderProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = GET, produces = APPLICATION_JSON)
    public List<Product> getProducts() {
        return productService.findAll();
    }

}
