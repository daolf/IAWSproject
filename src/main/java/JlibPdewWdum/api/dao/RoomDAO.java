package JlibPdewWdum.api.dao;

import JlibPdewWdum.api.model.RoomModel;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * Created by jlibert on 01/04/2015.
 */
public class RoomDAO extends DAO<RoomModel> {


    @Override
    public boolean create(RoomModel obj) {
        DatabaseManager.updateRequest("INSERT INTO Room VALUES ("
                                       + obj.getIdRoom() + ","
                                       + obj.getIdCinema() + ","
                                       + obj.getNbPlaceRoom() + ");");
        return true;
    }

    @Override
    public boolean delete(RoomModel obj) {
        DatabaseManager.updateRequest("DELETE FROM Room WHERE idRoom = "
                                       + obj.getIdRoom() + ";");
        return true;
    }

    @Override
    public boolean update(RoomModel obj) {
        return true;
    }

    @Override
    public RoomModel find(int id) {
        ResultSet rs = DatabaseManager.readRequest("SELECT * FROM Room WHERE idRoom = " + id + ";");
        RoomModel tmp = null;
        ResultSetMetaData rm = null;
        try {
            rm = rs.getMetaData();
            rs.next();
            tmp = new RoomModel(rs.getInt(1), rs.getInt(2),
                                rs.getInt(3));
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tmp;
    }
}
