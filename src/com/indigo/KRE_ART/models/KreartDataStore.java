package com.indigo.KRE_ART.models;

import java.sql.Connection;
import java.util.Date;
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

    public Subscription findSubscriptionById(int id){
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

    public int getMaxIdPerson() { return connection == null ? null: getPersonsEntity().getMaxId();}

    public int getMaxIdComent() { return connection == null ? null: getComentsEntity().getMaxId();}

    public int getMaxIdMatch() { return connection == null ? null: getMatchesEntity().getMaxId();}

    public int getMaxIdImage() { return connection == null ? null: getImagesEntity().getMaxId();}

    public int getMaxIdSubscripton() { return connection == null ? null: getSubscriptionsEntity().getMaxId();}

    public Boolean createPerson(int id, String name, String password, int dni, int cellphone, String location, String email, String profile, String description, int rate, int type){
        return connection == null ? false : getPersonsEntity().create(id,name,password,dni,cellphone,location,email,profile,description,rate,type);
    }

    public Boolean createPerson(Person person){
        return connection == null ? false : getPersonsEntity().create(person.getId(),person.getName(),person.getPassword(),person.getDni(),person.getCellphone(),person.getLocation(),person.getEmail(),person.getProfile(),person.getDescription(),person.getRate(),person.getType());
    }

    public Boolean updatePerson(int id, String name, String password, int dni, int cellphone, String location, String email, String profile, String description, int rate, int type){
        return connection == null ? false : getPersonsEntity().update(id,name,password,dni,cellphone,location,email,profile,description,rate,type);
    }

    public Boolean updatePerson(Person person){
        return connection == null ? false : getPersonsEntity().update(person.getId(),person.getName(),person.getPassword(),person.getDni(),person.getCellphone(),person.getLocation(),person.getEmail(),person.getProfile(),person.getDescription(),person.getRate(),person.getType());
    }

    public Boolean erasePerson(int id){
        return connection == null ? false : getPersonsEntity().erase(id);
    }

    public Boolean erasePerson(Person person){
        return connection == null ? false : getPersonsEntity().erase(person.getId());
    }

    public Boolean createTalent(int id, Person person, String category){
        return connection == null ? false : getTalentsEntity().create(id, person, category);
    }

    public Boolean createTalent(Talent talent){
        return connection == null ? false : getTalentsEntity().create(talent.getId(), talent.getPerson(), talent.getCategory());
    }

    public boolean updateTalent (int id, Person person, String category){
        return connection == null ? false : getTalentsEntity().update(id, person, category);
    }

    public boolean updateTalent (Talent talent){
        return connection == null ? false : getTalentsEntity().update(talent.getId(), talent.getPerson(), talent.getCategory());
    }

    public boolean eraseTalent (int id){
        return  connection == null ? false : getTalentsEntity().erase(id);
    }

    public boolean eraseTalent (Talent talent){
        return  connection == null ? false : getTalentsEntity().erase(talent.getId());
    }

    public boolean createHeadHunter(int id, Person person, String category, String organization){
        return connection == null ? false : getHeadhuntersEntity().create(id, person, category, organization);
    }

    public boolean createHeadHunter(Headhunter headhunter){
        return connection == null ? false : getHeadhuntersEntity().create(headhunter.getId(), headhunter.getPerson(), headhunter.getCategory(), headhunter.getOrganization());
    }

    public boolean updateHeadHunter(int id, Person person, String category, String organization){
        return connection == null ? false : getHeadhuntersEntity().update(id, person, category, organization);
    }

    public boolean updateHeadHunter(Headhunter headhunter){
        return connection == null ? false : getHeadhuntersEntity().update(headhunter.getId(), headhunter.getPerson(), headhunter.getCategory(), headhunter.getOrganization());
    }

    public boolean eraseHeadHunter(int id){
        return connection == null ? false : getHeadhuntersEntity().erase(id);
    }

    public boolean eraseHeadHunter(Headhunter headhunter){
        return connection == null ? false : getHeadhuntersEntity().erase(headhunter.getId());
    }

    public boolean createComent(int id, Person personsend, Image image, String message, int rate){
        return connection == null ? false : getComentsEntity().create(id, personsend, image, message, rate);
    }

    public boolean createComent(Coment coment){
        return connection == null ? false : getComentsEntity().create(coment.getId(), coment.getPersonsend(), coment.getImage(), coment.getMessage(), coment.getRate());
    }

    public boolean updateComent(int id, Person personsend, Image image, String message, int rate){
        return connection == null ? false : getComentsEntity().update(id, personsend, image, message, rate);
    }

    public boolean updateComent(Coment coment){
        return connection == null ? false : getComentsEntity().update(coment.getId(), coment.getPersonsend(), coment.getImage(), coment.getMessage(), coment.getRate());
    }

    public boolean eraseComent(int id){
        return connection == null ? false : getComentsEntity().erase(id);
    }

    public boolean eraseComent(Coment coment){
        return connection == null ? false : getComentsEntity().erase(coment.getId());
    }

    public boolean createMatch(int id, Person personsend, Person personrecive, String message, int rate){
        return connection == null ? false : getMatchesEntity().create(id,personsend,personrecive,message,rate);
    }

    public boolean createMatch(Match match){
        return connection == null ? false : getMatchesEntity().create(match.getId(),match.getPersonsend(),match.getPersonrecive(),match.getMessage(),match.getRate());
    }

    public boolean updateMatch(int id, Person personsend, Person personrecive, String message, int rate){
        return connection == null ? false : getMatchesEntity().update(id,personsend,personrecive,message,rate);
    }

    public boolean updateMatch(Match match){
        return connection == null ? false : getMatchesEntity().update(match.getId(),match.getPersonsend(),match.getPersonrecive(),match.getMessage(),match.getRate());
    }

    public boolean eraseMatch(int id){
        return connection == null ? false : getMatchesEntity().erase(id);
    }

    public boolean eraseMatch(Match match){
        return connection == null ? false : getMatchesEntity().erase(match.getId());
    }

    public boolean createImage(int id, Person person, String url, int rate){
        return connection == null ? false : getImagesEntity().create(id,person,url,rate);
    }

    public boolean createImage(Image image){
        return connection == null ? false : getImagesEntity().create(image.getId(),image.getPerson(),image.getUrl(),image.getRate());
    }

    public boolean updateImage(int id, Person person, String url, int rate){
        return connection == null ? false : getImagesEntity().update(id,person,url,rate);
    }

    public boolean updateImage(Image image){
        return connection == null ? false : getImagesEntity().update(image.getId(),image.getPerson(),image.getUrl(),image.getRate());
    }

    public boolean eraseImage(int id){
        return connection == null ? false : getImagesEntity().erase(id);
    }

    public boolean eraseImage(Image image){
        return connection == null ? false : getImagesEntity().erase(image.getId());
    }

    public boolean createSubscription(int id, Person person, int type, Double payment, Date datestarted, Date dateexpiration){
        return connection == null ? false : getSubscriptionsEntity().create(id,person,type,payment,datestarted,dateexpiration);
    }

    public boolean createSubscription(Subscription subscription){
        return connection == null ? false : getSubscriptionsEntity().create(subscription.getId(),subscription.getPerson(),subscription.getType(),subscription.getPayment(),subscription.getDatestarted(),subscription.getDateexpiration());
    }

    public boolean updateSubscription(int id, Person person, int type, Double payment, Date datestarted, Date dateexpiration){
        return connection == null ? false : getSubscriptionsEntity().update(id,person,type,payment,datestarted,dateexpiration);
    }

    public boolean updateSubscription(Subscription subscription){
        return connection == null ? false : getSubscriptionsEntity().update(subscription.getId(),subscription.getPerson(),subscription.getType(),subscription.getPayment(),subscription.getDatestarted(),subscription.getDateexpiration());
    }

    public boolean eraseSubscription(int id){
        return connection == null ? false : getSubscriptionsEntity().erase(id);
    }

    public boolean eraseSubscription(Subscription subscription){
        return connection == null ? false : getSubscriptionsEntity().erase(subscription.getId());
    }

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
