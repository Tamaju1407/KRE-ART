package pe.edu.utp.KRE_ART.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HeadhuntersEntity extends BaseEntity {
    public HeadhuntersEntity(){
        super();
        setTableName("hhunter");
    }

    public List<Headhunter> findAll(){
        return findByCriteria("");
    }

    public Headhunter findById(int id){
        return findByCriteria(
                String.format("WHERE hhunter_id = %d", id)).get(0);
    }

    public Headhunter findByDni(int dni){
        return findByCriteria(
                String.format("WHERE hhunter_dni = %d", dni)).get(0);
    }

    public Headhunter findByCellphone(int cellphone){
        return findByCriteria(
                String.format("WHERE hhunter_cellphone = %d", cellphone)).get(0);
    }

    public Headhunter findByName(String name) {
        return findByCriteria(
                String.format("WHERE hhunter_name = '%s'", name)).get(0);
    }

    public Headhunter findByAddress(String address){
        return findByCriteria(
                String.format("WHERE hhunter_address = '%s'", address)).get(0);
    }

    public Headhunter findByMail(String mail){
        return findByCriteria(
                String.format("WHERE hhunter_mail = '%s'", mail)).get(0);
    }

    public List<Headhunter> findByCriteria(String criteria){
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<Headhunter> hhunters = new ArrayList<>();
            while(rs.next())
                hhunters.add(Headhunter.from(rs));

            return hhunters;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean create(Headhunter headhunter) {
        return executeUpdate(String.format(
                "INSERT INTO %s(hhunter_id,hhunter_dni,hhunter_cellphone,hhunter_name,hhunter_address,hhunter_mail,hhunter_description) VALUES(%d, %d, %d, '%s', '%s', '%s', '%s')",
                getTableName(),headhunter.getId(),headhunter.getDni(),headhunter.getCellphone(),headhunter.getName(),headhunter.getAddress(),headhunter.getMail(),headhunter.getDescription()));
    }

    public boolean create(int id,int dni,int cellphone,String name,String address, String mail, String description) {
        return create(new Headhunter(id,dni,cellphone,name,address,mail,description));
    }

    public boolean update(int id, int dni, int cellphone, String name, String address, String mail, String description) {
        return executeUpdate(String.format(
                "UPDATE %s SET hhunter_dni = %d, hhunter_cellphone = %d, hhunter_name = '%s', hhunter_address = '%s', hhunter_mail = '%s', hhunter_description = '%s' WHERE hhunter_id = %d",
                getTableName(), dni, cellphone, name, address, mail, description, id));
    }

    public boolean update(Headhunter headhunter) {
        return update(headhunter.getId(), headhunter.getDni(), headhunter.getCellphone(), headhunter.getName(), headhunter.getAddress(), headhunter. getMail(), headhunter.getDescription());
    }

    public boolean erase(int id) {
        return executeUpdate(String.format("DELETE FROM %s WHERE hhunter_id = %d",
                getTableName(), id));
    }

    public boolean erase(Headhunter headhunter) {
        return executeUpdate(String.format("DELETE FROM %s WHERE hhunter_id = %d",
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
