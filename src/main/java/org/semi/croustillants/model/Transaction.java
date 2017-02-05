package org.semi.croustillants.model;

import org.semi.croustillants.model.isheep.Shipping;

import java.util.Date;

/**
 * Created by raymo on 05/02/2017.
 */
public class Transaction {

    private Long id;
    private Long id_client;
    private Date date_transac;
    private Float valeur;
    private boolean type_transac;
    private String commentaire;
    private String token;
    private Integer etat;
    private Shipping shipping;

    public Transaction() {
    }

    public Transaction(Long id, Long id_client, Date date_transac, Float valeur, boolean type_transac, String commentaire, String token, Integer etat) {
        this.id = id;
        this.id_client = id_client;
        this.date_transac = date_transac;
        this.valeur = valeur;
        this.type_transac = type_transac;
        this.commentaire = commentaire;
        this.token = token;
        this.etat = etat;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getId_client() {
        return id_client;
    }

    public Date getDate_transac() {
        return date_transac;
    }

    public Float getValeur() {
        return valeur;
    }

    public boolean isType_transac() {
        return type_transac;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public String getToken() {
        return token;
    }

    public Integer getEtat() {
        return etat;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(final Shipping shipping) {
        this.shipping = shipping;
    }
}
