package JlibPdewWdum.api.core;

import JlibPdewWdum.api.dao.RoomMovieDAO;
import JlibPdewWdum.api.model.RoomMovieModel;
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
    ){
        System.out.println("---------");
        RoomMovieDAO myDAO = new RoomMovieDAO();
        ObjectMapper mapper = new ObjectMapper();
        String s = null;
        ArrayList<RoomMovieModel> myRoomMovies = new ArrayList<RoomMovieModel>();

        if(loc.length() == 0 && tech.length() == 0 && nb == -1) {
            s = "{ \"error\" : \"bad parameter}\"";
        }
        else {
            myRoomMovies = myDAO.findByTechLocNb(tech,loc,nb);
        }

        if(myRoomMovies.size() == 0){ s = "{ \"error\": \"no association found\"}";}
        else {
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
        System.out.println("Result : "+s);
        System.out.println("---------");
        return s;
    }

    @POST
    @Path("room/{idRoom}/movie")
    public void postMovie (@PathParam("idRoom") String idRoom)
    {
        int i =9;
    }
}
