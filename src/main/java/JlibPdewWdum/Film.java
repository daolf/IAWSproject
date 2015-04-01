package JlibPdewWdum;

import JlibPdewWdum.Tools.OmdbClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by daolf on 28/03/15.
 */
@Path("film")
public class Film {


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getId(
            @QueryParam("t") String t,
            @QueryParam("y") int y) {

            //y not defined
            if (y == -1) {
                return OmdbClient.get(t);
            }
            else {
                return OmdbClient.get(y, t);
            }
    }
}
