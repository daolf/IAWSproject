package JlibPdewWdum.api.core;


import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import javax.ws.rs.core.Application;

public class MovieControllerTest extends JerseyTest {

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
            JSONAssert.assertEquals("[{\"id\": \"/movie/tt1448019\"}, {\"id\": \"/movie/tt0295588\"}]", movies, true);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}