package com.indigo.KRE_ART.models;

public class PersonAll {
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
    private int talentid;
    private String category;

    public PersonAll(int id, String name, String password, int dni, int cellphone, String location, String email, String profile, String description, int rate, int type, int talentid, String category) {
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
        this.talentid = talentid;
        this.category = category;
    }

    public PersonAll() {
    }

    public int getId() {
        return id;
    }

    public PersonAll setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PersonAll setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public PersonAll setPassword(String password) {
        this.password = password;
        return this;
    }

    public int getDni() {
        return dni;
    }

    public PersonAll setDni(int dni) {
        this.dni = dni;
        return this;
    }

    public int getCellphone() {
        return cellphone;
    }

    public PersonAll setCellphone(int cellphone) {
        this.cellphone = cellphone;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public PersonAll setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PersonAll setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getProfile() {
        return profile;
    }

    public PersonAll setProfile(String profile) {
        this.profile = profile;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PersonAll setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getRate() {
        return rate;
    }

    public PersonAll setRate(int rate) {
        this.rate = rate;
        return this;
    }

    public int getType() {
        return type;
    }

    public PersonAll setType(int type) {
        this.type = type;
        return this;
    }

    public int getTalentid() {
        return talentid;
    }

    public PersonAll setTalentid(int talentid) {
        this.talentid = talentid;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public PersonAll setCategory(String category) {
        this.category = category;
        return this;
    }
}
