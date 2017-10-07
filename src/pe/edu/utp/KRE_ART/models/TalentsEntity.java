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
