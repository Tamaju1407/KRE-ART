package com.indigo.KRE_ART.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Headhunter {
    private int id;
    private Person person;
    private String category;
    private String organization;

    public Headhunter() {
    }

    public Headhunter(int id, Person person, String category, String organization) {
        this.id = id;
        this.person = person;
        this.category = category;
        this.organization = organization;
    }

    public int getId() {
        return id;
    }

    public Headhunter setId(int id) {
        this.id = id;
        return this;
    }

    public Person getPerson() {
        return person;
    }

    public Headhunter setPerson(Person person) {
        this.person = person;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public Headhunter setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getOrganization() {
        return organization;
    }

    public Headhunter setOrganization(String organization) {
        this.organization = organization;
        return this;
    }

    public static Headhunter from(ResultSet rs, PersonsEntity personsEntity) {
        try {
            return new Headhunter(
                    rs.getInt("headhunter_id"),
                    personsEntity.findById(rs.getInt("person_id")),
                    rs.getString("headdunter_category"),
                    rs.getString("headhunter_organization"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
