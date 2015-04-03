package JlibPdewWdum.api.dao;

import JlibPdewWdum.api.model.MovieModel;
import JlibPdewWdum.api.model.RoomModel;
import JlibPdewWdum.api.model.RoomMovieModel;

/**
 * Created by jlibert on 03/04/2015.
 */
public class RoomMovieDAO extends DAO<RoomMovieModel> {
    @Override
    public boolean create(RoomMovieModel obj) {
        String columnRequest = "(idRoom, idMovie, nbPlaceUsed, date" +
                (obj.getLocalisation() != null ? ", idLocalisation" : "")+
                (obj.getTechno() != null ? ", idTechno" : "") + ")";
        String request = "INSERT INTO RoomMovieAssociation" + columnRequest +
                "VALUES ("
                + obj.getRoom().getIdRoom() + ","
                + "'" +obj.getMovie().getIdOmdb() + "'" + ","
                + obj.getNbPlaceUsed() + ","
                + obj.getDate().toInstant().getEpochSecond()
                + (obj.getLocalisation() != null ? ","+ obj.getTechno().getId() : "")
                + (obj.getTechno() != null ? ","+obj.getLocalisation().getId() : "")
                + ");";


        DatabaseManager.updateRequest(request);
        return true;

    }

    @Override
    public boolean delete(RoomMovieModel obj) {
        return false;
    }

    @Override
    public boolean update(RoomMovieModel obj) {
        return false;
    }

    @Override
    public RoomMovieModel find(int id) {
        return null;
    }

    public RoomMovieModel find(RoomModel room, MovieModel movie) {
        return null;
    }
}
