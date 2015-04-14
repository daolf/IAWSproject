package JlibPdewWdum.api.core;

import JlibPdewWdum.api.dao.RoomDAO;
import JlibPdewWdum.api.dao.RoomMovieDAO;
import JlibPdewWdum.api.model.MovieModel;
import JlibPdewWdum.api.model.RoomModel;
import JlibPdewWdum.api.model.RoomMovieModel;
import JlibPdewWdum.api.sdkomdb.MovieSDK;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by jlibert on 01/04/2015.
 */
@Path("/")
public class RoomController {

    @Path("rooms")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getRooms(
            @QueryParam("loc") @DefaultValue("") String loc,
            @QueryParam("tech") @DefaultValue("") String tech,
            @QueryParam("nb") @DefaultValue("-1") int nb
    ) {
        System.out.println("---------");
        RoomMovieDAO myDAO = new RoomMovieDAO();
        ObjectMapper mapper = new ObjectMapper();
        String s = null;
        ArrayList<RoomMovieModel> myRoomMovies = new ArrayList<RoomMovieModel>();

        if (loc.length() == 0 && tech.length() == 0 && nb == -1) {
            s = "{ \"error\" : \"bad parameter}\"";
        } else {
            myRoomMovies = myDAO.findByTechLocNb(tech, loc, nb);
        }

        if (myRoomMovies.size() == 0) {
            s = "{ \"error\": \"no association found\"}";
        } else {
            try {
                s = mapper.writeValueAsString(myRoomMovies);
            } catch (JsonGenerationException e) {
                e.printStackTrace();
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Result : " + s);
        System.out.println("---------");
        return s;
    }

    @POST
    @Path("room/{idRoom}/movie")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String postMovie(@PathParam("idRoom") @DefaultValue("") String idRoom,
                            @FormParam("id") @DefaultValue("") String idMovie,
                            @FormParam("loc") @DefaultValue("") String loc,
                            @FormParam("date") @DefaultValue("") String date,
                            @FormParam("tech") @DefaultValue("") String tech) {

        RoomDAO roomDAO = new RoomDAO();
        RoomModel room = roomDAO.find(Integer.valueOf(idRoom));

        // CHECK ROOM EXISTENCE
        if (room == null)
            return "Error: This room doesn't exists.";

        // CHECK IDMOVIE EXISTENCE
        if (idMovie.length() == 0 || idMovie == null) {
            return "Error: Movie ID MISSING.";
        } else { // CHECK IF THIS MOVIE EXIST
            MovieModel movieModel = MovieSDK.getMovieFromID(idMovie);
            if(movieModel == null)
                return "Error: This movie doesn't exists";
        }

        RoomMovieModel roomMovieModel = new RoomMovieModel(room, idMovie, date);
        RoomMovieDAO dao = new RoomMovieDAO();
        dao.create(roomMovieModel);
        return "OKAY";
    }
}
