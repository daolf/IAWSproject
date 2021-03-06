package JlibPdewWdum.api.dao;

import JlibPdewWdum.api.model.TechnoModel;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * Created by daolf on 03/04/15.
 */
public class TechnoDAO extends DAO<TechnoModel> {
    @Override
    public boolean create(TechnoModel obj) {
        DatabaseManager.updateRequest("INSERT INTO Techno VALUES ("
                + obj.getId() + ",'"
                + obj.getIntitule() + "');");
        return true;
    }

    public boolean create(String intitule) {
        DatabaseManager.updateRequest("INSERT INTO Techno (intituleTechno) VALUES ('"
                + intitule + "');");
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
        }
        return tmp;
    }

    public TechnoModel findByIntitule(String intitule) {
        ResultSet rs = DatabaseManager.readRequest("SELECT * FROM Techno WHERE intituleTechno = '" + intitule + "';");
        TechnoModel tmp = null;
        ResultSetMetaData rm = null;
        try {
            rm = rs.getMetaData();
            rs.next();
            tmp = new TechnoModel(rs.getInt(1), rs.getString(2));
            rs.close();
        } catch (SQLException e) {
        }
        return tmp;
    }
}
