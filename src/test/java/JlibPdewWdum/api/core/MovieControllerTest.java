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
        assertEquals("Test erreur","{ error: bad id}", error);

        final String movie = target("/movie").queryParam("id","tt0178145").request().get(String.class);
        assertEquals("Test id=tt0178145","{\"title\":\"Joan of Arc\",\"idOmdb\":\"tt0178145\",\"year\":1999}",movie);
    }
}