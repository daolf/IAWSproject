package JlibPdewWdum.soap;

import JlibPdewWdum.api.dao.RoomMovieDAO;
import JlibPdewWdum.api.model.MovieModel;
import JlibPdewWdum.api.model.RoomModel;
import JlibPdewWdum.api.model.RoomMovieModel;
import JlibPdewWdum.api.sdkomdb.MovieSDK;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;

/**
 *
 *
 */

@Endpoint
public class MovieEndpoint {
    private static final String NAMESPACE_URI = "http://JlibPdewWdum/soap";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "RoomsRequest")
    @ResponsePayload
    public RoomsResponse getRooms(@RequestPayload RoomsRequest request) {
        RoomsResponse response = new RoomsResponse();
        MovieModel movieModel = null;

        response.setIdOmdb(request.getIdOmdb());
        String id = request.getIdOmdb();
        try {
            movieModel = MovieSDK.getMovieFromID(id);
        } catch (Exception e) {}
        if (movieModel != null) {
            RoomMovieDAO roomMovieDAO = new RoomMovieDAO();
            ArrayList<RoomMovieModel> associations = roomMovieDAO.findByMovie(id);
            if (associations != null) {
                    RoomsResponse.Room room = new RoomsResponse.Room();
                    for (RoomMovieModel association : associations) {
                        room.setIdRoom(Integer.toString(association.getRoom().getIdRoom()));
                        room.setLocalisation((association.getLocalisation()).toString());
                        room.setTechno((association.getTechno()).toString());
                        response.room.add(room);
                    }
                }
            }
        return response;
    }
}
