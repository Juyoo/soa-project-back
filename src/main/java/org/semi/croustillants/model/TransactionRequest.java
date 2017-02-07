package org.semi.croustillants.model;

import org.semi.croustillants.model.isheep.Shipping;

/**
 * Created by raymo on 05/02/2017.
 */
public class TransactionRequest {

    private Client client;
    private Cart cart;
    private Shipping.Name recipientName;
    private Shipping.Address recipientAddress;

    public TransactionRequest() {
    }

    public Client getClient() {
        return client;
    }

    public Cart getCart() {
        return cart;
    }

    public Shipping.Name getRecipientName() {
        return recipientName;
    }

    public Shipping.Address getRecipientAddress() {
        return recipientAddress;
    }
}
