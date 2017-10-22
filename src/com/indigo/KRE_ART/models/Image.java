package com.indigo.KRE_ART.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Image {
    private int id,qual;
    private Talent talent;
    private String url,coments;

    public Image(int id, int qual, Talent talent, String url, String coments) {
        this.id = id;
        this.qual = qual;
        this.talent = talent;
        this.url = url;
        this.coments = coments;
    }

    public int getId() {
        return id;
    }

    public Image setId(int id) {
        this.id = id;
        return this;
    }

    public int getQual() {
        return qual;
    }

    public Image setQual(int qual) {
        this.qual = qual;
        return this;
    }

    public Talent getTalent() {
        return talent;
    }

    public Image setTalent(Talent talent) {
        this.talent = talent;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Image setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getComents() {
        return coments;
    }

    public Image setComents(String coments) {
        this.coments = coments;
        return this;
    }

    public static Image from(ResultSet rs) {
        try {
            return new Image(
                    rs.getInt("image_id"),
                    rs.getInt("image_qual"),
                    rs.getTalent(TalentsEntity.findById(rs.getInt("talent_id"))),
                    rs.getString("image_url"),
                    rs.getString("image_coments"));
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
