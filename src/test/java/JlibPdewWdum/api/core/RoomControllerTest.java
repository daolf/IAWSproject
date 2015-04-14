package JlibPdewWdum.api.core;


import JlibPdewWdum.api.dao.DatabaseManager;
import JlibPdewWdum.api.dao.RoomMovieDAO;
import JlibPdewWdum.api.model.RoomMovieModel;
import com.sun.jersey.api.representation.Form;
import junit.framework.Assert;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;


public class RoomControllerTest extends JerseyTest {

    public void setUp() throws Exception {
        super.setUp();
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
    }


    @Override
    protected Application configure() {
        return new ResourceConfig(RoomController.class);
    }

    @Test
    public void testGetRooms() {
        String roomsVOTest = target("/rooms").queryParam("loc", "VO").request().get(String.class);
        String roomsVOOriginal = "[{\"room\":{\"idRoom\":1,\"idCinema\":2,\"nbPlaceRoom\":100},\"movie\":\"tt0103854\",\"nbPlaceUsed\":7,\"date\":1427478108000,\"localisation\":{\"id\":1,\"intitule\":\"VO\"},\"techno\":{\"id\":2,\"intitule\":\"IMAX\"}}]";

        String roomsErrorTest = target("/rooms").queryParam("loc", "VOUZBEKISTAN").request().get(String.class);
        String roomsErrorOriginal = "{ \"error\": \"no association found\"}";

        String roomsIMAXTest = target("/rooms").queryParam("tech", "IMAX").request().get(String.class);
        String roomsIMAXOriginal = "[{\"room\":{\"idRoom\":4,\"idCinema\":2,\"nbPlaceRoom\":402},\"movie\":\"tt2322441\",\"nbPlaceUsed\":1,\"date\":1348172976000,\"localisation\":{\"id\":2,\"intitule\":\"VF\"},\"techno\":{\"id\":2,\"intitule\":\"IMAX\"}},{\"room\":{\"idRoom\":1,\"idCinema\":2,\"nbPlaceRoom\":100},\"movie\":\"tt0103854\",\"nbPlaceUsed\":7,\"date\":1427478108000,\"localisation\":{\"id\":1,\"intitule\":\"VO\"},\"techno\":{\"id\":2,\"intitule\":\"IMAX\"}}]";

        String roomsWrongParamTest = target("/rooms").queryParam("localocaloca", "VO").request().get(String.class);
        String roomsWrongParamOriginal = "{ \"error\": \"no association found\"}";

        try {
            JSONAssert.assertEquals(roomsVOOriginal, roomsVOTest, false);
            JSONAssert.assertEquals(roomsErrorTest, roomsErrorOriginal, false);
            JSONAssert.assertEquals(roomsIMAXTest, roomsIMAXOriginal, false);
            JSONAssert.assertEquals(roomsWrongParamTest, roomsWrongParamOriginal, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPostMovie() {
        RoomMovieDAO dao = new RoomMovieDAO();

        // add Bambi to Room 1
        Form form = new Form();
        form.add("id", "tt0034492");
        target("/room").path("1").path("movie").request().post(Entity.form(form));
        RoomMovieModel newAssociation = dao.find(1, "tt0034492");
        Assert.assertFalse(newAssociation == null);

        // add Se7en to Room 2
/*        form = new Form();
        form.add("id", "tt0114369");
        form.add("loc", "VO");
        form.add("tech", "IMAX");
        target("/room").path("2").path("movie").request().post(Entity.form(form));
*/

    }
}