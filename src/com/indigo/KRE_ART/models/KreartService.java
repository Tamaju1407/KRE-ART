package com.indigo.KRE_ART.models;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class KreartService {
    private Connection connection;
    private KreartDataStore dataStore;

    public KreartService() {
        try {
            InitialContext context = new InitialContext();
            dataStore = new KreartDataStore();
            connection = ((DataSource) context
                    .lookup("jdbc/MySQLDataSource"))
                    .getConnection();
            dataStore.setConnection(connection);
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {this.connection = connection; }

    public KreartDataStore getDataStore() { return dataStore; }

    public void setDataStore(KreartDataStore dataStore) { this.dataStore = dataStore; }

    public List<Person> findAllPersons() { return dataStore.findAllPersons(); }

    public List<Talent> findAllTalents() { return dataStore.findAllTalent(); }

    public List<Headhunter> findAllHeadHunters() { return dataStore.findAllHeadHunters(); }

    public List<Coment> findAllComents() { return dataStore.findAllComents(); }

    public List<Match> findAllMatches() { return dataStore.findAllMatches(); }

    public List<Image> findAllImages() { return dataStore.findAllImages(); }

    public List<Subscription> findAllSubscriptions() { return  dataStore.findAllSubscriptions(); }

    public Person findPersonById(int id) { return dataStore.findPersonById(id); }

    public Talent findTalentById(int id) { return dataStore.findTalentById(id); }

    public Headhunter findHeadHunterById(int id) { return dataStore.findHeadHunterById(id); }

    public Coment findComentById(int id) { return dataStore.findComentById(id); }

    public Match findMatchById(int id) { return dataStore.findMatchById(id); }

    public Image findImageById(int id) { return dataStore.findImageById(id); }

    public Subscription findSubscriptionById(int id) {
        return dataStore.findSubscriptionById(id);
    }

    public Boolean createPerson(int id, String name, int dni, int cellphone, String location, String email, String profile, String description, int rate, int type){
        return dataStore.createPerson(id,name,dni,cellphone,location,email,profile,description,rate,type);
    }

    public Boolean createPerson(Person person){
        return dataStore.createPerson(person.getId(),person.getName(),person.getDni(),person.getCellphone(),person.getLocation(),person.getEmail(),person.getProfile(),person.getDescription(),person.getRate(),person.getType());
    }

    public Boolean updatePerson(int id, String name, int dni, int cellphone, String location, String email, String profile, String description, int rate, int type){
        return dataStore.updatePerson(id,name,dni,cellphone,location,email,profile,description,rate,type);
    }

    public Boolean updatePerson(Person person){
        return dataStore.updatePerson(person.getId(),person.getName(),person.getDni(),person.getCellphone(),person.getLocation(),person.getEmail(),person.getProfile(),person.getDescription(),person.getRate(),person.getType());
    }

    public Boolean erasePerson(int id){
        return dataStore.erasePerson(id);
    }

    public Boolean erasePerson(Person person){
        return dataStore.erasePerson(person.getId());
    }


    public Boolean createTalent(int id, Person person, String category){
        return dataStore.createTalent(id, person, category);
    }

    public Boolean createTalent(Talent talent){
        return dataStore.createTalent(talent.getId(), talent.getPerson(), talent.getCategory());
}

    public boolean updateTalent (int id, Person person, String category){
        return dataStore.updateTalent(id, person, category);
    }

    public boolean updateTalent (Talent talent){
        return dataStore.updateTalent(talent.getId(), talent.getPerson(), talent.getCategory());
    }

    public boolean eraseTalent (int id){
        return dataStore.eraseTalent(id);
    }

    public boolean eraseTalent (Talent talent){
        return  dataStore.eraseTalent(talent.getId());
    }

    public boolean createHeadHunter(int id, Person person, String category, String organization){
        return dataStore.createHeadHunter(id, person, category, organization);
    }

    public boolean createHeadHunter(Headhunter headhunter){
        return dataStore.createHeadHunter(headhunter.getId(), headhunter.getPerson(), headhunter.getCategory(), headhunter.getOrganization());
    }

    public boolean updateHeadHunter(int id, Person person, String category, String organization){
        return dataStore.updateHeadHunter(id, person, category, organization);
    }

    public boolean updateHeadHunter(Headhunter headhunter){
        return dataStore.updateHeadHunter(headhunter.getId(), headhunter.getPerson(), headhunter.getCategory(), headhunter.getOrganization());
    }

    public boolean eraseHeadHunter(int id){
        return dataStore.eraseHeadHunter(id);
    }

    public boolean eraseHeadHunter(Headhunter headhunter){
        return dataStore.eraseHeadHunter(headhunter.getId());
    }

    public boolean createComent(int id, Person personsend, Image image, String message, int rate){
        return dataStore.createComent(id, personsend, image, message, rate);
    }

    public boolean createComent(Coment coment){
        return dataStore.createComent(coment.getId(), coment.getPersonsend(), coment.getImage(), coment.getMessage(), coment.getRate());
    }

    public boolean updateComent(int id, Person personsend, Image image, String message, int rate){
        return dataStore.updateComent(id, personsend, image, message, rate);
    }

    public boolean updateComent(Coment coment){
        return dataStore.updateComent(coment.getId(), coment.getPersonsend(), coment.getImage(), coment.getMessage(), coment.getRate());
    }

    public boolean eraseComent(int id){
        return dataStore.eraseComent(id);
    }

    public boolean eraseComent(Coment coment){
        return dataStore.eraseComent(coment.getId());
    }

    public boolean createMatch(int id, Person personsend, Person personrecive, String message, int rate){
        return dataStore.createMatch(id,personsend,personrecive,message,rate);
    }

    public boolean createMatch(Match match){
        return dataStore.createMatch(match.getId(),match.getPersonsend(),match.getPersonrecive(),match.getMessage(),match.getRate());
    }

    public boolean updateMatch(int id, Person personsend, Person personrecive, String message, int rate){
        return dataStore.updateMatch(id,personsend,personrecive,message,rate);
    }

    public boolean updateMatch(Match match){
        return dataStore.updateMatch(match.getId(),match.getPersonsend(),match.getPersonrecive(),match.getMessage(),match.getRate());
    }

    public boolean eraseMatch(int id){
        return dataStore.eraseMatch(id);
    }

    public boolean eraseMatch(Match match){
        return dataStore.eraseMatch(match.getId());
    }

    public boolean createImage(int id, Person person, String url, int rate){
        return dataStore.createImage(id,person,url,rate);
    }

    public boolean createImage(Image image){
        return dataStore.createImage(image.getId(),image.getPerson(),image.getUrl(),image.getRate());
    }

    public boolean updateImage(int id, Person person, String url, int rate){
        return dataStore.updateImage(id,person,url,rate);
    }

    public boolean updateImage(Image image){
        return dataStore.updateImage(image.getId(),image.getPerson(),image.getUrl(),image.getRate());
    }

    public boolean eraseImage(int id){
        return dataStore.eraseImage(id);
    }

    public boolean eraseImage(Image image){
        return dataStore.eraseImage(image.getId());
    }

    public boolean createSubscription(int id, Person person, int type, Double payment, Date datestarted, Date dateexpiration){
        return dataStore.createSubscription(id,person,type,payment,datestarted,dateexpiration);
    }

    public boolean createSubscription(Subscription subscription){
        return dataStore.createSubscription(subscription.getId(),subscription.getPerson(),subscription.getType(),subscription.getPayment(),subscription.getDatestarted(),subscription.getDateexpiration());
    }

    public boolean updateSubscription(int id, Person person, int type, Double payment, Date datestarted, Date dateexpiration){
        return dataStore.updateSubscription(id,person,type,payment,datestarted,dateexpiration);
    }

    public boolean updateSubscription(Subscription subscription){
        return dataStore.updateSubscription(subscription.getId(),subscription.getPerson(),subscription.getType(),subscription.getPayment(),subscription.getDatestarted(),subscription.getDateexpiration());
    }

    public boolean eraseSubscription(int id){
        return dataStore.eraseSubscription(id);
    }

    public boolean eraseSubscription(Subscription subscription){
        return dataStore.eraseSubscription(subscription.getId());
    }
}
