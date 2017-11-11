package com.indigo.KRE_ART.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Subscription {
    private int id;
    private Person person;
    private int type;
    private Double payment;
    private Date datestarted;
    private Date dateexpiration;

    public Subscription() {
    }

    public Subscription(int id, Person person, int type, Double payment, Date datestarted, Date dateexpiration) {
        this.id = id;
        this.person = person;
        this.type = type;
        this.payment = payment;
        this.datestarted = datestarted;
        this.dateexpiration = dateexpiration;
    }

    public int getId() {
        return id;
    }

    public Subscription setId(int id) {
        this.id = id;
        return this;
    }

    public Person getPerson() {
        return person;
    }

    public Subscription setPerson(Person person) {
        this.person = person;
        return this;
    }

    public int getType() {
        return type;
    }

    public Subscription setType(int type) {
        this.type = type;
        return this;
    }

    public Double getPayment() {
        return payment;
    }

    public Subscription setPayment(Double payment) {
        this.payment = payment;
        return this;
    }

    public Date getDatestarted() {
        return datestarted;
    }

    public Subscription setDatestarted(Date datestarted) {
        this.datestarted = datestarted;
        return this;
    }

    public Date getDateexpiration() {
        return dateexpiration;
    }

    public Subscription setDateexpiration(Date dateexpiration) {
        this.dateexpiration = dateexpiration;
        return this;
    }

    public static Subscription from(ResultSet rs, PersonsEntity personsEntity) {
        Subscription subscription = new Subscription();
        try {
            return subscription.setId(rs.getInt("subscription_id"))
                    .setPerson(personsEntity.findById(rs.getInt("person_id")))
                    .setType(rs.getInt("subscription_type"))
                    .setPayment(rs.getDouble("subscription_payment"))
                    .setDatestarted(rs.getDate("subscription_datestarted"))
                    .setDateexpiration(rs.getDate("subscription_dateexpiration"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
