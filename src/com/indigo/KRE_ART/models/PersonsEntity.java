package com.indigo.KRE_ART.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonsEntity extends BaseEntity {
    public PersonsEntity(){
        super();
        setTableName("persons");
    }

    public List<Person> findByCriteria(String criteria){
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<Person> persons = new ArrayList<>();
            while(rs.next())
                persons.add(Person.from(rs));

            return persons;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Person> findByCategory(String category){
        return findByCriteria(String.format("WHERE person_category = '%s'", category));
    }

    public Person findById(int id){
        return findByCriteria(
                String.format("WHERE person_id = %d", id)).get(0);
    }

    public Person findByName(String name) {
        return findByCriteria(
                String.format("WHERE person_name = '%s'", name)).get(0);
    }

    public Person findByEmail(String email){
        return findByCriteria(
                String.format("WHERE person_mail = '%s'", email)).get(0);
    }

    public List<Person> findAll(){
        return findByCriteria("");
    }

    public int getMaxId() {
        String sql = "SELECT MAX(person_id) AS max_id FROM persons";
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

    public boolean create(Person person) {
        return executeUpdate(String.format(
                "INSERT INTO %s(person_id,person_name,person_password,person_dni,person_cellphone,person_location,person_email,person_profile,person_description,person_rate,person_type) VALUES(%d, '%s', '%s', %d, %d, '%s', '%s', '%s', '%s', %d, %d)",
                getTableName(),person.getId(),person.getName(),person.getPassword(),person.getDni(),person.getCellphone(),person.getLocation(),person.getEmail(),person.getProfile(),person.getDescription(),person.getRate(),person.getType()));
    }

    public boolean create(int id, String name, String password, int dni, int cellphone, String location, String email, String profile, String description, int rate, int type) {
        return create(new Person(id,name,password,dni,cellphone,location,email,profile,description,rate,type));
    }

    public boolean update(int id, String name, String password, int dni, int cellphone, String location, String email, String profile, String description, int rate, int type) {
        return executeUpdate(String.format(
                "UPDATE %s SET person_name = '%s', person_password = '%s', person_dni = %d, person_cellphone = %d, person_location = '%s', person_email = '%s',person_profile = '%s', person_description = '%s', person_rate = %d, person_type = %d WHERE person_id = %d",
                getTableName(), name, password, dni, cellphone, location, email, profile, description, rate, type, id));
    }

    public boolean update(Person person) {
        return update(person.getId(),person.getName(),person.getPassword(),person.getDni(),person.getCellphone(),person.getLocation(),person.getEmail(),person.getProfile(),person.getDescription(),person.getRate(),person.getType());
    }

    public boolean erase(int id) {
        return executeUpdate(String.format("DELETE FROM %s WHERE person_id = %d",
                getTableName(), id));
    }

    public boolean erase(Person person) {
        return executeUpdate(String.format("DELETE FROM %s WHERE person_id = %d",
                getTableName(), person.getId()));
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
