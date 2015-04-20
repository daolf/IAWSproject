package JlibPdewWdum.soap;

import JlibPdewWdum.api.dao.DatabaseManager;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.boot.SpringApplication;

/**
 * Created by droit on 20/04/15.
 */
public class MovieEndpointTest extends TestCase {
    private RoomsResponse roomsResponse;
    private MovieEndpoint movieEndpoint;
    private RoomsRequest roomsRequestOK;
    private RoomsRequest roomsRequestKO;

    public void setUp() throws Exception {
        String[] args = {""};
        Application.main(args);
        //create request
        roomsResponse = new RoomsResponse();
        movieEndpoint = new MovieEndpoint();
        roomsRequestOK = new RoomsRequest();
        roomsRequestKO = new RoomsRequest();
        // existing id
        roomsRequestOK.setIdOmdb("tt2294629");
        // none existing id
        roomsRequestKO.setIdOmdb("tt1111111");
    }

    @Test
    public void testgetRooms() {
        // good response
        roomsResponse = movieEndpoint.getRooms(roomsRequestOK);
        assertNotNull("Test request not null (answer)", roomsResponse);
        assertEquals("Test good id", roomsResponse.getIdOmdb(), roomsRequestOK.getIdOmdb());
        assertEquals("Test room of roomsResponse size", roomsResponse.room.size(), 1);
        for (RoomsResponse.Room room : roomsResponse.room) {
            assertEquals("Test room localisation ", room.getLocalisation(), "VF");
            assertEquals("Test room technologie ", room.getTechno(), "LEOTECHNOLOGIES");
        }

        // bad response
        roomsResponse = movieEndpoint.getRooms(roomsRequestKO);
        assertNull("Test request is null ", roomsResponse);


    }
}