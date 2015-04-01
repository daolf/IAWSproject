package JlibPdewWdum.api.dao;

import JlibPdewWdum.api.model.RoomModel;

import java.sql.Connection;

/**
 * Created by jlibert on 01/04/2015.
 */
public class RoomDAO extends DAO<RoomModel>{


    @Override
    public boolean create(RoomModel obj) {
        DatabaseManager dbm = new DatabaseManager();
        dbm.writeRequest("INSERT INTO Room VALUES (" + obj.getIdRoom() + "," + obj.getIdCinema() + "," + obj.getNbPlaceRoom() + ");");
        return false;
    }

    @Override
    public boolean delete(RoomModel obj) {
        DatabaseManager dbm = new DatabaseManager();
        dbm.deleteRequest("DELETE FROM Room WHERE idRoom = "+obj.getIdRoom()+";");
        return false;
    }

    @Override
    public boolean update(RoomModel obj) {
        return false;
    }

    @Override
    public RoomModel find(int id) {
        DatabaseManager dbm = new DatabaseManager();
        dbm.readRequest("SELECT * FROM Room WHERE idRoom = "+obj.getIdRoom()+";");
        return null;
    }
}
