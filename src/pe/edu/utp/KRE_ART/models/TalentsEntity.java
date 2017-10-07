package pe.edu.utp.KRE_ART.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TalentsEntity extends BaseEntity {
    public TalentsEntity(){
        super();
        setTableName("talents");
    }

    public List<Talent> findAll(){
        return findByCriteria("");
    }

    public Talent findById(int id){
        return findByCriteria(
                String.format("WHERE talent_id = %d", id)).get(0);
    }

    public Talent findByDni(int dni){
        return findByCriteria(
                String.format("WHERE talent_dni = %d", dni)).get(0);
    }

    public Talent findByCellphone(int cellphone){
        return findByCriteria(
                String.format("WHERE talent_cellphone = %d", cellphone)).get(0);
    }

    public Talent findByName(String name) {
        return findByCriteria(
                String.format("WHERE talent_name = '%s'", name)).get(0);
    }

    public Talent findByAddress(String address){
        return findByCriteria(
                String.format("WHERE talent_address = '%s'", address)).get(0);
    }

    public Talent findByMail(String mail){
        return findByCriteria(
                String.format("WHERE talent_mail = '%s'", mail)).get(0);
    }

    public List<Talent> findByCriteria(String criteria){
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<Talent> talents = new ArrayList<>();
            while(rs.next())
                talents.add(Talent.from(rs));

            return talents;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean create(Talent talent) {
        return executeUpdate(String.format(
                "INSERT INTO %s(talent_id,talent_dni,talent_cellphone,talent_name,talent_address,talent_mail,talent_description) VALUES(%d, '%s')",
                getTableName(),talent.getId(),talent.getDni(),talent.getCellphone(),talent.getName(),talent.getAddress(),talent.getMail(),talent.getDescription(),talent.getName()));
    }

    public boolean create(int id,int dni,int cellphone,String name,String address, String mail, String description) {
        return create(new Talent(id,dni,cellphone,name,address,mail,description));
    }

    public boolean update(int id, String name) {
        return executeUpdate(String.format(
                "UPDATE %s SET region_name = '%s' WHERE region_id = %d", getTableName(), name, id));
    }

    public boolean update(Talent talent) {
        return update(talent.getId(), talent.getName());
    }

    public boolean erase(int id) {
        return executeUpdate(String.format("DELETE FROM %s WHERE region_id = %d",
                getTableName(), id));
    }

    public boolean erase(Talent talent) {
        return executeUpdate(String.format("DELETE FROM %s WHERE region_id = %d",
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
