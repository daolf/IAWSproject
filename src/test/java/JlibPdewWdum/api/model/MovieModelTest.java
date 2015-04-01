package JlibPdewWdum.api.model;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class MovieModelTest extends TestCase {

    MovieModel modelmovie;

    @org.junit.Before
    public void setUp() throws  Exception {
        modelmovie = new MovieModel("tt0078346","Superman",1978);
        //Assert.assertEquals(11, player.getThrow(0));
    }

    @org.junit.Before
    public void setUp1() throws  Exception {
        modelmovie = new MovieModel("tt0078346","Superman",1978);
    }

    @org.junit.Before
    public void setUp2() throws  Exception {
        modelmovie = new MovieModel("tt0078346","Superman",1978);
    }
}