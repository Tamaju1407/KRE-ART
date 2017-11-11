package com.indigo.KRE_ART.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComentsEntity extends BaseEntity {
    public ComentsEntity(){
        super();
        setTableName("coments");
    }

    public List<Coment> findByCriteria(String criteria, PersonsEntity personsEntity, ImagesEntity imagesEntity){
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<Coment> coments = new ArrayList<>();
            while(rs.next())
                coments.add(Coment.from(rs, personsEntity, imagesEntity));

            return coments;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Coment> findAll(PersonsEntity personsEntity, ImagesEntity imagesEntity){
        return findByCriteria("", personsEntity, imagesEntity);
    }

    public Coment findById(int id, PersonsEntity personsEntity, ImagesEntity imagesEntity){
        return findByCriteria(
                String.format("WHERE coment_id = %d", id), personsEntity, imagesEntity).get(0);
    }

    public List<Coment> findAllBySend(Person person, PersonsEntity personsEntity, ImagesEntity imagesEntity){
        return findByCriteria(String.format("WHERE personsend_id = %d", person.getId()), personsEntity, imagesEntity);
    }

    public List<Coment> findAllByImage(Image image, PersonsEntity personsEntity, ImagesEntity imagesEntity){
        return findByCriteria(String.format("WHERE image_id = %d", image.getId()), personsEntity, imagesEntity);
    }

    public boolean create(Coment coment) {
        return executeUpdate(String.format(
                "INSERT INTO %s(coment_id,personsend_id,image_id,coment_message,coment_rate) VALUES(%d, %d, %d, %d, '%s', %d)",
                getTableName(),coment.getId(),coment.getPersonsend().getId(),coment.getImage().getId(),coment.getMessage(),coment.getRate()));
    }

    public boolean create(int id, Person personsend, Image image, String message, int rate) {
        return create(new Coment(id,personsend,image,message,rate));
    }

    public boolean update(int id, Person personsend, Image image, String message, int rate) {
        return executeUpdate(String.format(
                "UPDATE %s SET personsend_id = %d, image_id = %d, coment_message = '%s', coment_rate = %d WHERE coment_id = %d",
                getTableName(), personsend.getId(), image.getId(), message, rate, id));
    }

    public boolean update(Coment coment) {
        return update(coment.getId(),coment.getPersonsend(),coment.getImage(),coment.getMessage(),coment.getRate());
    }

    public boolean erase(int id) {
        return executeUpdate(String.format("DELETE FROM %s WHERE coment_id = %d",
                getTableName(), id));
    }

    public boolean erase(Coment coment) {
        return executeUpdate(String.format("DELETE FROM %s WHERE coment_id = %d",
                getTableName(), coment.getId()));
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
