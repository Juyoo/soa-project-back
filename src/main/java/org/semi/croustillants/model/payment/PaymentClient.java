package org.semi.croustillants.model.payment;

/**
 * Created by raymo on 04/02/2017.
 */
public class PaymentClient {

    private Long id;
    private String fname;
    private String name;
    private String login;
    private String pwd;
    private String token;
    private Float solde;

    public PaymentClient() {
    }

    public PaymentClient(final Long id, final String fname, final String name, final String login, final String pwd, final String token, final Float solde) {
        this.id = id;
        this.fname = fname;
        this.name = name;
        this.login = login;
        this.pwd = pwd;
        this.token = token;
        this.solde = solde;
    }

    public Long getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPwd() {
        return pwd;
    }

    public String getToken() {
        return token;
    }

    public Float getSolde() {
        return solde;
    }


    public void setPwd(final String pwd) {
        this.pwd = pwd;
    }
}
