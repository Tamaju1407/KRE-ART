package com.indigo.KRE_ART.models;


import java.sql.ResultSet;
import java.sql.SQLException;

public class Image {
    private int id;
    private Person person;
    private String url;
    private int rate;

    public Image() {
    }

    public Image(int id, Person person, String url, int rate) {
        this.id = id;
        this.person = person;
        this.url = url;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public Image setId(int id) {
        this.id = id;
        return this;
    }

    public Person getPerson() {
        return person;
    }

    public Image setPerson(Person person) {
        this.person = person;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Image setUrl(String url) {
        this.url = url;
        return this;
    }

    public int getRate() {
        return rate;
    }

    public Image setRate(int rate) {
        this.rate = rate;
        return this;
    }

    public static Image from(ResultSet rs, PersonsEntity personsEntity) {
        try {
            return new Image(
                    rs.getInt("image_id"),
                    personsEntity.findById(rs.getInt("person_id")),
                    rs.getString("image_url"),
                    rs.getInt("image_rate"));
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
