package com.indigo.KRE_ART.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HeadhuntersEntity extends BaseEntity {
    public HeadhuntersEntity(){
        super();
        setTableName("headhunters");
    }

    public List<Headhunter> findByCriteria(String criteria, PersonsEntity personsEntity){
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<Headhunter> headhunters = new ArrayList<>();
            while(rs.next())
                headhunters.add(Headhunter.from(rs, personsEntity));

            return headhunters;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Headhunter> findAll(PersonsEntity personsEntity){
        return findByCriteria("", personsEntity);
    }

    public Headhunter findById(int id, PersonsEntity personsEntity){
        return findByCriteria(
                String.format("WHERE image_id = %d", id), personsEntity).get(0);
    }

    public Headhunter findByPerson(Person person, PersonsEntity personsEntity){
        return findByCriteria(
                String.format("WHERE person_id = %d", person.getId()), personsEntity).get(0);
    }

    public boolean create(Headhunter headhunter) {
        return executeUpdate(String.format(
                "INSERT INTO %s(headhunter_id,person_id,headhunter_category,headhunter_organization) VALUES(%d, %d, '%s','%s')",
                getTableName(),headhunter.getId(),headhunter.getPerson().getId(),headhunter.getCategory(),headhunter.getOrganization()));
    }

    public boolean create(int id, Person person, String category, String organization) {
        return create(new Headhunter(id,person,category, organization));
    }

    public boolean update(int id, Person person, String category, String organization) {
        return executeUpdate(String.format(
                "UPDATE %s SET headhunter_id = %d, headhunter_category = '%s', headhunter_organization = '%s' WHERE headhunter_id = %d",
                getTableName(), person.getId(), category, organization, id));
    }

    public boolean update(Headhunter headhunter) {
        return update(headhunter.getId(),headhunter.getPerson(),headhunter.getCategory(),headhunter.getOrganization());
    }

    public boolean erase(int id) {
        return executeUpdate(String.format("DELETE FROM %s WHERE headhunter_id = %d",
                getTableName(), id));
    }

    public boolean erase(Headhunter headhunter) {
        return executeUpdate(String.format("DELETE FROM %s WHERE headhunter_id = %d",
                getTableName(), headhunter.getId()));
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
