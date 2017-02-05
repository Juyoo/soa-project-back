package org.semi.croustillants.model.provider;

/**
 * Created by raymo on 05/02/2017.
 */
public class ProviderClient {

    private String id;
    private String firstname;
    private String lastname;
    private final String billingAdress = null;
    private final String deliveryAdresses = null;

    public ProviderClient() {
    }

    public ProviderClient(final String id, final String firstname, final String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getBillingAdress() {
        return billingAdress;
    }

    public String getDeliveryAdresses() {
        return deliveryAdresses;
    }
}
