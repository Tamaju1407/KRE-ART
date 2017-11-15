package com.indigo.KRE_ART.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Match {
    private int id;
    private Person personsend;
    private Person personrecive;
    private String message;
    private int rate;

    public Match() {
    }

    public Match(int id, Person personsend, Person personrecive, String message, int rate) {
        this.id = id;
        this.personsend = personsend;
        this.personrecive = personrecive;
        this.message = message;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public Match setId(int id) {
        this.id = id;
        return this;
    }

    public Person getPersonsend() {
        return personsend;
    }

    public Match setPersonsend(Person personsend) {
        this.personsend = personsend;
        return this;
    }

    public Person getPersonrecive() {
        return personrecive;
    }

    public Match setPersonrecive(Person personrecive) {
        this.personrecive = personrecive;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Match setMessage(String message) {
        this.message = message;
        return this;
    }

    public int getRate() {
        return rate;
    }

    public Match setRate(int rate) {
        this.rate = rate;
        return this;
    }

    public static Match from(ResultSet rs, PersonsEntity personsEntity) {
        Match match= new Match();
        try {
            return match.setId(rs.getInt("match_id"))
                    .setPersonsend(personsEntity.findById(rs.getInt("personsend_id")))
                    .setPersonrecive(personsEntity.findById(rs.getInt("personrecive_id")))
                    .setMessage(rs.getString("match_message"))
                    .setRate(rs.getInt("match_rate"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
