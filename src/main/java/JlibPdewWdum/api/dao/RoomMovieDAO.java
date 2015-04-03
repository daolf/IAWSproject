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
        return false;
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
