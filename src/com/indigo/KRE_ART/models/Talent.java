package com.indigo.KRE_ART.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Talent {
    private int id;
    private Person person;
    private String category;

    public Talent() {
    }

    public Talent(int id, Person person, String category) {
        this.id = id;
        this.person = person;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public Talent setId(int id) {
        this.id = id;
        return this;
    }

    public Person getPerson() {
        return person;
    }

    public Talent setPerson(Person person) {
        this.person = person;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public Talent setCategory(String category) {
        this.category = category;
        return this;
    }

    public static Talent from(ResultSet rs, PersonsEntity personsEntity) {
        try {
            return new Talent(
                    rs.getInt("talent_id"),
                    personsEntity.findById(rs.getInt("person_id")),
                    rs.getString("talent_category"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
