package com.indigo.KRE_ART.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatchesEntity extends BaseEntity{
    public MatchesEntity(){
        super();
        setTableName("matches");
    }

    public List<Match> findByCriteria(String criteria, PersonsEntity personsEntity){
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<Match> matches = new ArrayList<>();
            while(rs.next())
                matches.add(Match.from(rs, personsEntity));

            return matches;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Match> findAll(PersonsEntity personsEntity){
        return findByCriteria("", personsEntity);
    }

    public Match findById(int id, PersonsEntity personsEntity){
        return findByCriteria(
                String.format("WHERE match_id = %d", id), personsEntity).get(0);
    }

    public List<Match> findAllBySend(Person person, PersonsEntity personsEntity){
        return findByCriteria(String.format("WHERE personsend_id = %d", person.getId()), personsEntity);
    }

    public List<Match> findAllByRecive(Person person, PersonsEntity personsEntity){
        return findByCriteria(String.format("WHERE personrecive_id = %d", person.getId()), personsEntity);
    }

    public int getMaxId() {
        String sql = "SELECT MAX(match_id) AS max_id FROM matches";
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

    public boolean create(Match match) {
        return executeUpdate(String.format(
                "INSERT INTO %s(match_id,personsend_id,personrecive_id,match_message,match_rate) VALUES(%d, %d, %d, %d, '%s',%d)",
                getTableName(),match.getId(),match.getPersonsend().getId(),match.getPersonrecive().getId(),match.getMessage(),match.getRate()));
    }

    public boolean create(int id, Person personsend, Person personrecive, String message, int rate) {
        return create(new Match(id,personsend,personrecive,message,rate));
    }

    public boolean update(int id, Person personsend, Person personrecive, String message, int rate) {
        return executeUpdate(String.format(
                "UPDATE %s SET personsend_id = %d, personrecive_id = %d, match_message = '%s', match_rate = %d WHERE coment_id = %d",
                getTableName(), personsend.getId(), personrecive.getId(), message, rate, id));
    }

    public boolean update(Match match) {
        return update(match.getId(),match.getPersonsend(),match.getPersonrecive(),match.getMessage(),match.getRate());
    }

    public boolean erase(int id) {
        return executeUpdate(String.format("DELETE FROM %s WHERE match_id = %d",
                getTableName(), id));
    }

    public boolean erase(Match match) {
        return executeUpdate(String.format("DELETE FROM %s WHERE match_id = %d",
                getTableName(), match.getId()));
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
