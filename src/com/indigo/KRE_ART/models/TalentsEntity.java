package com.indigo.KRE_ART.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TalentsEntity extends BaseEntity {
    public TalentsEntity(){
        super();
        setTableName("talents");
    }

    public List<Talent> findByCriteria(String criteria, PersonsEntity personsEntity){
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<Talent> talents = new ArrayList<>();
            while(rs.next())
                talents.add(Talent.from(rs, personsEntity));

            return talents;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Talent> findAll(PersonsEntity personsEntity){
        return findByCriteria("", personsEntity);
    }

    public Talent findById(int id, PersonsEntity personsEntity){
        return findByCriteria(
                String.format("WHERE image_id = %d", id), personsEntity).get(0);
    }

    public Talent findByPerson(Person person, PersonsEntity personsEntity){
        return findByCriteria(
                String.format("WHERE person_id = %d", person.getId()), personsEntity).get(0);
    }

    public boolean create(Talent talent) {
        return executeUpdate(String.format(
                "INSERT INTO %s(talent_id,person_id,talent_category) VALUES(%d, %d, '%s')",
                getTableName(),talent.getId(),talent.getPerson().getId(),talent.getCategory()));
    }

    public boolean create(int id, Person person, String category) {
        return create(new Talent(id,person,category));
    }

    public boolean update(int id, Person person, String category) {
        return executeUpdate(String.format(
                "UPDATE %s SET person_id = %d, talent_category = '%s' WHERE talent_id = %d",
                getTableName(), person.getId(), category, id));
    }

    public boolean update(Talent talent) {
        return update(talent.getId(),talent.getPerson(),talent.getCategory());
    }

    public boolean erase(int id) {
        return executeUpdate(String.format("DELETE FROM %s WHERE talent_id = %d",
                getTableName(), id));
    }

    public boolean erase(Talent talent) {
        return executeUpdate(String.format("DELETE FROM %s WHERE talent_id = %d",
                getTableName(), talent.getId()));
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
