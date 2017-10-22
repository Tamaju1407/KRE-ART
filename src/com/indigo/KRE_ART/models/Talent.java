package com.indigo.KRE_ART.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Talent {
    private int id,dni,cellphone;
    private String name,address,mail,description;

    public Talent(int id, int dni, int cellphone, String name, String address, String mail, String description) {
        this.id = id;
        this.dni = dni;
        this.cellphone = cellphone;
        this.name = name;
        this.address = address;
        this.mail = mail;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public Talent setId(int id) {
        this.id = id;
        return this;
    }

    public int getDni() {
        return dni;
    }

    public Talent setDni(int dni) {
        this.dni = dni;
        return this;
    }

    public int getCellphone() {
        return cellphone;
    }

    public Talent setCellphone(int cellphone) {
        this.cellphone = cellphone;
        return this;
    }

    public String getName() {
        return name;
    }

    public Talent setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Talent setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getMail() {
        return mail;
    }

    public Talent setMail(String mail) {
        this.mail = mail;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Talent setDescription(String description) {
        this.description = description;
        return this;
    }

    public static Talent from(ResultSet rs) {
        try {
            return new Talent(
                    rs.getInt("talent_id"),
                    rs.getInt("talent_dni"),
                    rs.getInt("talent_cellphone"),
                    rs.getString("talent_name"),
                    rs.getString("talent_address"),
                    rs.getString("talent_mail"),
                    rs.getString("talent_description"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
