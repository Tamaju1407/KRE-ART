package com.indigo.KRE_ART.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Person {
    private int id;
    private String name;
    private String password;
    private int dni;
    private int cellphone;
    private String location;
    private String email;
    private String profile;
    private String description;
    private int rate;
    private int type;

    public Person() {
    }

    public Person(int id, String name, String password, int dni, int cellphone, String location, String email, String profile, String description, int rate, int type) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.dni = dni;
        this.cellphone = cellphone;
        this.location = location;
        this.email = email;
        this.profile = profile;
        this.description = description;
        this.rate = rate;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public Person setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public int getDni() {
        return dni;
    }

    public Person setDni(int dni) {
        this.dni = dni;
        return this;
    }

    public int getCellphone() {
        return cellphone;
    }

    public Person setCellphone(int cellphone) {
        this.cellphone = cellphone;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public Person setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Person setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getProfile() {
        return profile;
    }

    public Person setProfile(String profile) {
        this.profile = profile;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Person setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getRate() {
        return rate;
    }

    public Person setRate(int rate) {
        this.rate = rate;
        return this;
    }

    public int getType() {
        return type;
    }

    public Person setType(int type) {
        this.type = type;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Person setPassword(String password) {
        this.password = password;
        return this;
    }

    public static Person from(ResultSet rs) {
        try {
            return new Person(rs.getInt("person_id"),
                    rs.getString("person_name"),
                    rs.getString("person_password"),
                    rs.getInt("person_dni"),
                    rs.getInt("person_cellphone"),
                    rs.getString("person_location"),
                    rs.getString("person_email"),
                    rs.getString("person_profile"),
                    rs.getString("person_description"),
                    rs.getInt("person_rate"),
                    rs.getInt("person_type"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
