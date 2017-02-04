package org.semi.croustillants.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.semi.croustillants.model.payment.PaymentClient;
import org.semi.croustillants.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

import static javax.ws.rs.core.MediaType.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by raymo on 04/02/2017.
 */
@RestController
@RequestMapping(value = "/client")
public class ClientResource {

    private final ClientService clientService;

    @Inject
    public ClientResource(final ClientService clientService) {
        this.clientService = clientService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/register", method = POST, produces = APPLICATION_JSON, consumes = APPLICATION_JSON)
    public PaymentClient register(@RequestBody final PaymentClient client) throws JsonProcessingException {
        return clientService.registerClient(client);
    }

}
