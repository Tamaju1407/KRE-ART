package com.indigo.KRE_ART.models;

import java.sql.Connection;
import java.util.List;

public class KreartDataStore {
    private Connection connection;
    private PersonsEntity personsEntity;
    private TalentsEntity talentsEntity;
    private HeadhuntersEntity headhuntersEntity;
    private ComentsEntity comentsEntity;
    private MatchesEntity matchesEntity;
    private ImagesEntity imagesEntity;
    private SubscriptionsEntity subscriptionsEntity;

    public KreartDataStore() {
    }

    public KreartDataStore (Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Person findPersonById(int id){
        if(connection == null) return null;
        return getPersonsEntity().findById(id);
    }

    public Talent findTalentById(int id){
        if (connection == null) return null;
        return getTalentsEntity().findById(id, getPersonsEntity());
    }

    public Headhunter findHeadHunterById(int id){
        if(connection == null) return null;
        return getHeadhuntersEntity().findById(id, getPersonsEntity());
    }

    public Coment findComentById(int id){
        if (connection == null) return null;
        return getComentsEntity().findById(id, getPersonsEntity(), getImagesEntity());
    }

    public Match findMatchById(int id){
        if (connection == null) return null;
        return getMatchesEntity().findById(id, getPersonsEntity());
    }

    public Image findImageById(int id){
        if (connection == null) return null;
        return getImagesEntity().findById(id, getPersonsEntity());
    }

    public Subscription findSubscription(int id){
        if (connection == null) return null;
        return getSubscriptionsEntity().findById(id, getPersonsEntity());
    }

    public List<Person> findAllPersons() { return connection == null ? null: getPersonsEntity().findAll();}

    public List<Talent> findAllTalent() { return connection == null ? null: getTalentsEntity().findAll(getPersonsEntity());}

    public List<Headhunter> findAllHeadHunters() { return connection == null ? null: getHeadhuntersEntity().findAll(getPersonsEntity());}

    public List<Coment> findAllComents() { return connection == null ? null: getComentsEntity().findAll(getPersonsEntity(),getImagesEntity());}

    public List<Match> findAllMatches() { return connection == null ? null: getMatchesEntity().findAll(getPersonsEntity());}

    public List<Image> findAllImages() { return connection == null ? null: getImagesEntity().findAll(getPersonsEntity());}

    public List<Subscription> findAllSubscriptions() { return connection == null ? null: getSubscriptionsEntity().findAll(getPersonsEntity());}



    private PersonsEntity getPersonsEntity(){
        if(personsEntity == null){
            personsEntity = new PersonsEntity();
            personsEntity.setConnection(connection);
        }
        return personsEntity;
    }

    private TalentsEntity getTalentsEntity(){
        if(talentsEntity == null){
            talentsEntity = new TalentsEntity();
            talentsEntity.setConnection(connection);
        }
        return talentsEntity;
    }

    private HeadhuntersEntity getHeadhuntersEntity(){
        if(headhuntersEntity == null){
            headhuntersEntity = new HeadhuntersEntity();
            headhuntersEntity.setConnection(connection);
        }
        return headhuntersEntity;
    }

    private ComentsEntity getComentsEntity(){
        if(comentsEntity == null){
            comentsEntity = new ComentsEntity();
            comentsEntity.setConnection(connection);
        }
        return comentsEntity;
    }

    private MatchesEntity getMatchesEntity(){
        if(matchesEntity == null){
            matchesEntity = new MatchesEntity();
            matchesEntity.setConnection(connection);
        }
        return matchesEntity;
    }

    private ImagesEntity getImagesEntity(){
        if(imagesEntity == null){
            imagesEntity = new ImagesEntity();
            imagesEntity.setConnection(connection);
        }
        return imagesEntity;
    }

    private SubscriptionsEntity getSubscriptionsEntity(){
        if(subscriptionsEntity == null){
            subscriptionsEntity = new SubscriptionsEntity();
            subscriptionsEntity.setConnection(connection);
        }
        return subscriptionsEntity;
    }
}
