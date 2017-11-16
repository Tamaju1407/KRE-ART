package com.indigo.KRE_ART.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubscriptionsEntity extends BaseEntity {
    public SubscriptionsEntity(){
        super();
        setTableName("subscriptions");
    }

    public List<Subscription> findByCriteria(String criteria, PersonsEntity personsEntity){
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<Subscription> subscriptions = new ArrayList<>();
            while(rs.next())
                subscriptions.add(Subscription.from(rs, personsEntity));

            return subscriptions;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Subscription> findAll(PersonsEntity personsEntity){
        return findByCriteria("", personsEntity);
    }

    public Subscription findById(int id, PersonsEntity personsEntity){
        return findByCriteria(
                String.format("WHERE match_id = %d", id), personsEntity).get(0);
    }

    public Subscription findByPerson(int id, PersonsEntity personsEntity){
        return findByCriteria(String.format("WHERE person_id = %d", id), personsEntity).get(0);
    }

    public int getMaxId() {
        String sql = "SELECT MAX(subscription_id) AS max_id FROM subscriptions";
        try {
            ResultSet resultSet = getConnection()
                    .createStatement()
                    .executeQuery(sql);
            return resultSet.next() ?
                    resultSet.getInt("max_id") : 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean create(Subscription subscription) {
        return executeUpdate(String.format(
                "INSERT INTO %s(subscription_id,person_id,subscription_type,subscription_payment,subscription_datestarted,subscription_dateexpiration) VALUES(%d, %d, %d, %d, %d, %d)",
                getTableName(),subscription.getId(),subscription.getPerson().getId(),subscription.getType(),subscription.getPayment(),subscription.getDatestarted(),subscription.getDateexpiration()));
    }

    public boolean create(int id, Person person, int type, Double payment, Date datestarted, Date dateexpiration) {
        return create(new Subscription(id,person,type,payment,datestarted,dateexpiration));
    }

    public boolean update(int id, Person person, int type, Double payment, Date datestarted, Date dateexpiration) {
        return executeUpdate(String.format(
                "UPDATE %s SET person_id = %d, subscription_type = %d, subscription_payment = %d, subscription_datestarted = %d, subscription_dateexpiration = %d WHERE subscription_id = %d",
                getTableName(), person.getId(), type, payment, datestarted, dateexpiration, id));
    }

    public boolean update(Subscription subscription) {
        return update(subscription.getId(),subscription.getPerson(),subscription.getType(),subscription.getPayment(),subscription.getDatestarted(),subscription.getDateexpiration());
    }

    public boolean erase(int id) {
        return executeUpdate(String.format("DELETE FROM %s WHERE subscription_id = %d",
                getTableName(), id));
    }

    public boolean erase(Subscription subscription) {
        return executeUpdate(String.format("DELETE FROM %s WHERE subscription_id = %d",
                getTableName(), subscription.getId()));
    }


    public boolean executeUpdate(String sql) {
        try {
            int result = getConnection()
                    .createStatement()
                    .executeUpdate(sql);
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
