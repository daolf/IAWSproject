package JlibPdewWdum.soap;

import JlibPdewWdum.api.dao.RoomMovieDAO;
import JlibPdewWdum.api.model.MovieModel;
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
        response.room = new ArrayList<RoomsResponse.Room>();
        MovieModel movieModel = null;

        response.setIdOmdb(request.getIdOmdb());
        String id = request.getIdOmdb();
        try {
            movieModel = MovieSDK.getMovieFromID(id);
        } catch (Exception e) {
        }
        if (movieModel != null) {
            RoomMovieDAO roomMovieDAO = new RoomMovieDAO();
            ArrayList<RoomMovieModel> associations = roomMovieDAO.findByMovie(id);
            if (associations != null) {
                RoomsResponse.Room room = null;
                for (RoomMovieModel association : associations) {
                    room = new RoomsResponse.Room();
                    room.setIdRoom(Integer.toString(association.getRoom().getIdRoom()));
                    if (association.getLocalisation() != null)
                        room.setLocalisation(association.getLocalisation().getIntitule());
                    if (association.getTechno() != null)
                        room.setTechno(association.getTechno().getIntitule());
                    response.room.add(room);
                }
            }
        }
        return response;
    }
}
