package com.indigo.KRE_ART.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Coment {
    private int id;
    private Person personsend;
    private Image image;
    private String message;
    private int rate;

    public Coment() {
    }

    public Coment(int id, Person personsend, Image image, String message, int rate) {
        this.id = id;
        this.personsend = personsend;
        this.image = image;
        this.message = message;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public Coment setId(int id) {
        this.id = id;
        return this;
    }

    public Person getPersonsend() {
        return personsend;
    }

    public Coment setPersonsend(Person personsend) {
        this.personsend = personsend;
        return this;
    }

    public Image getImage() {
        return image;
    }

    public Coment setImage(Image image) {
        this.image = image;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Coment setMessage(String message) {
        this.message = message;
        return this;
    }

    public int getRate() {
        return rate;
    }

    public Coment setRate(int rate) {
        this.rate = rate;
        return this;
    }

    public static Coment from(ResultSet rs, PersonsEntity personsEntity, ImagesEntity imagesEntity) {
        Coment coment = new Coment();
        try {
            return coment.setId(rs.getInt("coment_id"))
                    .setPersonsend(personsEntity.findById(rs.getInt("personsend_id")))
                    .setImage(imagesEntity.findById(rs.getInt("image_id"), personsEntity))
                    .setMessage(rs.getString("coment_message"))
                    .setRate(rs.getInt("coment_rate"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
