package org.semi.croustillants.model.provider;

import org.semi.croustillants.model.Cart;

/**
 * Created by raymo on 05/02/2017.
 */
public class BillForm {

    private String clientId;
    private Cart cart;

    public BillForm() {
    }

    public BillForm(final String clientId, final Cart cart) {
        this.clientId = clientId;
        this.cart = cart;
    }

    public String getClientId() {
        return clientId;
    }

    public Cart getCart() {
        return cart;
    }
}
