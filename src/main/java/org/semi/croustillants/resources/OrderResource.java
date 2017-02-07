package org.semi.croustillants.resources;

import org.semi.croustillants.model.TransactionRequest;
import org.semi.croustillants.model.Transaction;
import org.semi.croustillants.services.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created by raymo on 05/02/2017.
 */
@RestController
@RequestMapping(value = "/order")
public class OrderResource {

    private final TransactionService transactionService;

    @Inject
    public OrderResource(final TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, produces = APPLICATION_JSON, consumes = APPLICATION_JSON)
    public Transaction createTransaction(@RequestBody final TransactionRequest transactionRequest) {

        Transaction transaction = transactionService.placeOrder(transactionRequest);
        return transaction;
    }


}
