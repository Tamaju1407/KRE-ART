package com.indigo.KRE_ART.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImagesEntity extends BaseEntity {
    public ImagesEntity(){
        super();
        setTableName("images");
    }

    public List<Image> findByCriteria(String criteria, PersonsEntity personsEntity){
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<Image> images = new ArrayList<>();
            while(rs.next())
                images.add(Image.from(rs, personsEntity));

            return images;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Image> findAll(PersonsEntity personsEntity){
        return findByCriteria("", personsEntity);
    }

    public Image findById(int id, PersonsEntity personsEntity){
        return findByCriteria(
                String.format("WHERE image_id = %d", id), personsEntity).get(0);
    }

    public List<Image> findByPerson(Person person, PersonsEntity personsEntity){
        return findByCriteria(
                String.format("WHERE person_id = %d", person.getId()), personsEntity);
    }

    public int getMaxId() {
        String sql = "SELECT MAX(image_id) AS max_id FROM images";
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

    public boolean create(Image image) {
        return executeUpdate(String.format(
                "INSERT INTO %s(image_id,person_id,image_url,image_rate) VALUES(%d, %d, '%s',%d)",
                getTableName(),image.getId(),image.getPerson().getId(),image.getUrl(),image.getRate()));
    }

    public boolean create(int id, Person person, String url, int rate) {
        return create(new Image(id,person,url,rate));
    }

    public boolean update(int id, Person person, String url, int rate) {
        return executeUpdate(String.format(
                "UPDATE %s SET person_id = %d, image_url = '%s', image_rate = %d WHERE image_id = %d",
                getTableName(), person.getId(), url, rate, id));
    }

    public boolean update(Image image) {
        return update(image.getId(),image.getPerson(),image.getUrl(),image.getRate());
    }

    public boolean erase(int id) {
        return executeUpdate(String.format("DELETE FROM %s WHERE image_id = %d",
                getTableName(), id));
    }

    public boolean erase(Image image) {
        return executeUpdate(String.format("DELETE FROM %s WHERE image_id = %d",
                getTableName(), image.getId()));
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
