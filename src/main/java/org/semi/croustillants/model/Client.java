package org.semi.croustillants.model;

import org.semi.croustillants.model.payment.PaymentClient;
import org.semi.croustillants.model.provider.ProviderClient;

/**
 * Created by raymo on 05/02/2017.
 */
public class Client {

    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String paymentServiceToken;
    private String providerServiceId;

    public Client() {
    }

    public Client(final PaymentClient paymentClient, final ProviderClient providerClient) {
        this.login = paymentClient.getLogin();
        this.password = paymentClient.getPwd();
        this.firstName = paymentClient.getFname();
        this.lastName = paymentClient.getName();
        this.paymentServiceToken = paymentClient.getToken();
        this.providerServiceId = providerClient.getId();
    }

    public Client(final String login, final String password, final String firstName, final String lastName, final String paymentServiceToken, final String providerServiceId) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.paymentServiceToken = paymentServiceToken;
        this.providerServiceId = providerServiceId;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPaymentServiceToken() {
        return paymentServiceToken;
    }

    public String getProviderServiceId() {
        return providerServiceId;
    }



}
