package JlibPdewWdum.api.dao;

import JlibPdewWdum.api.model.TechnoModel;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * Created by daolf on 03/04/15.
 */
public class TechnoDAO extends DAO<TechnoModel>{
    @Override
    public boolean create(TechnoModel obj) {
        DatabaseManager.updateRequest("INSERT INTO Techno VALUES ("
                + obj.getId() + ",'"
                + obj.getIntitule() +  "');");
        return true;
    }

    @Override
    public boolean delete(TechnoModel obj) {
        DatabaseManager.updateRequest("DELETE FROM Techno WHERE idTechno = "
                + obj.getId() + ";");
        return true;
    }

    @Override
    public boolean update(TechnoModel obj) {
        return false;
    }

    @Override
    public TechnoModel find(int id) {
        ResultSet rs = DatabaseManager.readRequest("SELECT * FROM Techno WHERE idTechno = " + id + ";");
        TechnoModel tmp = null;
        ResultSetMetaData rm = null;
        try {
            rm = rs.getMetaData();
            rs.next();
            tmp = new TechnoModel(rs.getInt(1), rs.getString(2));
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tmp;
    }
}
