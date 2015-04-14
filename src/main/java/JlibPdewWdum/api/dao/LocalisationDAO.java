package JlibPdewWdum.api.dao;

import JlibPdewWdum.api.model.LocalisationModel;
import JlibPdewWdum.api.model.RoomModel;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * Created by daolf on 03/04/15.
 */
public class LocalisationDAO extends DAO<LocalisationModel>{
    @Override
    public boolean create(LocalisationModel obj) {
        DatabaseManager.updateRequest("INSERT INTO Localisation VALUES ("
                + obj.getId() + ",'"
                + obj.getIntitule() +  "');");
        return true;
    }

    public boolean create(String intitule) {
        DatabaseManager.updateRequest("INSERT INTO Localisation (intituleLocalisation) VALUES ('"
                + intitule + "');");
        return true;
    }

    @Override
    public boolean delete(LocalisationModel obj) {
        DatabaseManager.updateRequest("DELETE FROM Localisation WHERE idLocalisation = "
                + obj.getId() + ";");
        return true;
    }

    @Override
    public boolean update(LocalisationModel obj) {
        return false;
    }

    @Override
    public LocalisationModel find(int id) {
        ResultSet rs = DatabaseManager.readRequest("SELECT * FROM Localisation WHERE idLocalisation = " + id + ";");
        LocalisationModel tmp = null;
        ResultSetMetaData rm = null;
        try {
            rm = rs.getMetaData();
            rs.next();
            tmp = new LocalisationModel(rs.getInt(1), rs.getString(2));
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tmp;
    }

    public LocalisationModel findByName(String name) {
        ResultSet rs = DatabaseManager.readRequest("SELECT * FROM Localisation WHERE intituleLocalisation = '" + name + "';");
        LocalisationModel tmp = null;
        ResultSetMetaData rm = null;
        try {
            rm = rs.getMetaData();
            rs.next();
            tmp = new LocalisationModel(rs.getInt(1), rs.getString(2));
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tmp;
    }
}
