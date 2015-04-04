package JlibPdewWdum.api.core;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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


        return null;
    }
}
