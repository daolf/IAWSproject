package JlibPdewWdum.api.core;

import JlibPdewWdum.api.sdkomdb.MovieSDK;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by daolf on 28/03/15.
 */
@Path("film")
public class MovieController {


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getId(
            @QueryParam("t") String t,
            @QueryParam("y") int y) {


        return null;
    }
}
