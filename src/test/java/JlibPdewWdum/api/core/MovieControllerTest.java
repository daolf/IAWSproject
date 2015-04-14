package JlibPdewWdum.api.core;


import JlibPdewWdum.api.dao.DatabaseManager;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import javax.ws.rs.core.Application;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;

public class MovieControllerTest extends JerseyTest {

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
        return new ResourceConfig(MovieController.class);
    }

    @Test
    public void testGetMovie() {
        final String error = target("/movie").path("1").request().get(String.class);
        final String movie = target("/movie").path("tt0178145").request().get(String.class);

        try {
            JSONAssert.assertEquals("{ \"error\": \"bad id\"}", error, false);
            JSONAssert.assertEquals("{\"title\":\"Joan of Arc\",\"year\":1999,\"idOmdb\":\"tt0178145\"}", movie, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void testGetMovies() {
        final String errorBadParam = target("/movies").queryParam("y", "2000").request().get(String.class);
        final String errorBadYear = target("/movies").queryParam("y", "200").queryParam("t", "harry").request().get(String.class);
        final String movies = target("/movies").queryParam("y", "2000").queryParam("t", "bibi").request().get(String.class);
        try {
            JSONAssert.assertEquals("{\"error\" : \"bad parameter, missing title\"}", errorBadParam, false);
            JSONAssert.assertEquals("{\"error\": \"bad values\"}", errorBadYear, false);
            JSONAssert.assertEquals("[{\"id\": \"/movie/tt1448019\"}, {\"id\": \"/movie/tt0295588\"}]", movies, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void testGetRoomsFromMovie() {
        // Wrong movie (or movie not on theater)
        final String errorWrongMovie = target("/movie").path("0X000").path("rooms").request().get(String.class);
        final String errorWrongMovieContract = "{\"error\" : \"There is no room playing this movie, sorry !\"}";

        // tt0499549 -> Avatar in rooms: 1, 2 & 3
        final String goodMovieWithRooms = target("/movie").path("tt0499549").path("rooms").request().get(String.class);
        final String goodMovieWithRoomsContract = "[{\"room\": \"/room/1\"}, {\"room\": \"/room/2\"}, {\"room\": \"/room/3\"}]";

        try {
            JSONAssert.assertEquals(errorWrongMovie, errorWrongMovieContract, false);
            JSONAssert.assertEquals(goodMovieWithRooms, goodMovieWithRoomsContract, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}