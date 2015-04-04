package JlibPdewWdum.api.core;

import JlibPdewWdum.api.model.MovieModel;
import JlibPdewWdum.api.sdkomdb.MovieSDK;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * Created by daolf on 28/03/15.
 */
@Path("/")
public class MovieController {

    @Path("movie")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getMovie(
            @QueryParam("id") String id) {
        System.out.println("---------");
        MovieModel myMovie = MovieSDK.getMovieFromID(id);
        ObjectMapper mapper = new ObjectMapper();
        String s = null;
        if (myMovie == null) {
            s = "{ error: bad id}";
        }
        else {
            try {
                s = mapper.writeValueAsString(myMovie);
            } catch (JsonGenerationException e) {
                e.printStackTrace();
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("---------");
        return s;
    }

    @Path("movies")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMovies(
            @QueryParam("id") @DefaultValue("") String id,
            @QueryParam("t")  @DefaultValue("") String title,
            @QueryParam("y")  @DefaultValue("0") int year) {



        return "YOLO2";
    }
}
