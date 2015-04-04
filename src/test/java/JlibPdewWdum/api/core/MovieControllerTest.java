package JlibPdewWdum.api.core;


import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;

import static junit.framework.Assert.*;

public class MovieControllerTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(MovieController.class);
    }

    @Test
    public void testGetMovie() {
        final String error = target("/movie").queryParam("id","t").request().get(String.class);
        assertEquals("Test erreur","{ \"error\": \"bad id\"}", error);

        final String movie = target("/movie").queryParam("id","tt0178145").request().get(String.class);
        assertEquals("{\"title\":\"Joan of Arc\",\"year\":1999,\"idOmdb\":\"tt0178145\"}",movie);
    }


    @Test
    public void testGetMovies(){
        final String errorBadParam =  target("/movies").queryParam("y","2000").request().get(String.class);
        final String errorBadYear = target("/movies").queryParam("y","200").queryParam("t", "harry").request().get(String.class);
        assertEquals("Test without title","{ \"error\" : \"bad parameter, missing title}\"",errorBadParam);
        assertEquals("Test year = 200","{ \"error\": \"bad values\"}",errorBadYear);

        final String movies = target("/movies").queryParam("y","2000").queryParam("t", "bibi").request().get(String.class);
        assertEquals("Test year = 2000 , title = bibi","[{\"title\":\"Bibi &amp; Rolli - Durch dick und dünn\",\"idOmdb\":\"tt1448019\",\"year\":2000},{\"title\":\"Schwester Bibi\",\"idOmdb\":\"tt0295588\",\"year\":2000}]",movies);

    }
}