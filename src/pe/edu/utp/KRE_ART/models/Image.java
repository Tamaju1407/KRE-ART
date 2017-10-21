package pe.edu.utp.KRE_ART.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Image {
    private int id,dni,cellphone;
    private String name,address,mail,description;

    public Image(int id, int dni, int cellphone, String name, String address, String mail, String description) {
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

    public Image setId(int id) {
        this.id = id;
        return this;
    }

    public int getDni() {
        return dni;
    }

    public Image setDni(int dni) {
        this.dni = dni;
        return this;
    }

    public int getCellphone() {
        return cellphone;
    }

    public Image setCellphone(int cellphone) {
        this.cellphone = cellphone;
        return this;
    }

    public String getName() {
        return name;
    }

    public Image setName(String name) {
        this.name = name;
        return this;
    }

    public Image getAddress() {
        return address;
    }

    public Image setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getMail() {
        return mail;
    }

    public Image setMail(String mail) {
        this.mail = mail;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Image setDescription(String description) {
        this.description = description;
        return this;
    }

    public static Image from(ResultSet rs) {
        try {
            return new Image(
                    rs.getInt("hhunter_id"),
                    rs.getInt("hhunter_dni"),
                    rs.getInt("hhunter_cellphone"),
                    rs.getString("hhunter_name"),
                    rs.getString("hhunter_address"),
                    rs.getString("hhunter_mail"),
                    rs.getString("hhunter_description"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
