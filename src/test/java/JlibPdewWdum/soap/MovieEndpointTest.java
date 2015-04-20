package JlibPdewWdum.soap;

import JlibPdewWdum.api.dao.DatabaseManager;
import junit.framework.TestCase;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.Test;
import org.springframework.boot.SpringApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by droit on 20/04/15.
 */
public class MovieEndpointTest extends TestCase {
    private RoomsResponse roomsResponse;
    private MovieEndpoint movieEndpoint;
    private RoomsRequest roomsRequestOK;
    private RoomsRequest roomsRequestKO;

    public void setUp() throws Exception {
        super.setUp();
        // dbb init
        DatabaseManager.env = DatabaseManager.Environment.TEST;
        Connection c = null;
        String aSQLScriptFilePath1 = "database/createBDD.sql";
        String aSQLScriptFilePath2 = "database/addContent.sql";

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database/test.db");

            ScriptRunner sr = new ScriptRunner(c);

            Reader readerCreate = new BufferedReader(
                    new FileReader(aSQLScriptFilePath1));
            Reader readerContent = new BufferedReader(
                    new FileReader(aSQLScriptFilePath2));

            // Execute script
            sr.runScript(readerCreate);
            sr.runScript(readerContent);

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

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
    public void testgetRoomsNotNull() {
        // good response
        roomsResponse = movieEndpoint.getRooms(roomsRequestOK);
        assertNotNull("Test request not null (answer)", roomsResponse);
    }

    @Test
    public void testgetRoomsId() {
        // good response
        roomsResponse = movieEndpoint.getRooms(roomsRequestOK);
        assertEquals("Test good id", roomsResponse.getIdOmdb(), roomsRequestOK.getIdOmdb());
    }

    @Test
    public void testgetRoomsSize() {
        // good response
        roomsResponse = movieEndpoint.getRooms(roomsRequestOK);
        assertEquals("Test room of roomsResponse size", roomsResponse.room.size(), 1);
    }

    @Test
    public void testgetRoomsLocalisation() {
        // good response
        roomsResponse = movieEndpoint.getRooms(roomsRequestOK);
        for (RoomsResponse.Room room : roomsResponse.room) {
            assertEquals("Test room localisation ", room.getLocalisation(), "VF");
        }
    }
    @Test
    public void testgetRoomsTechno() {
        // good response
        roomsResponse = movieEndpoint.getRooms(roomsRequestOK);
        for (RoomsResponse.Room room : roomsResponse.room) {
            assertEquals("Test room technologie ", room.getTechno(), "LEOTECHNOLOGIES");
        }
    }

    @Test
    public void testgetRooms() {
        // bad response
        roomsResponse = movieEndpoint.getRooms(roomsRequestKO);
        assertNull("Test request is null ", roomsResponse);
    }

    //TODO limits cases ?
}