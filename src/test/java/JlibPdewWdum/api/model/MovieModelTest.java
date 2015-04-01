package JlibPdewWdum.api.model;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class MovieModelTest extends TestCase {

    MovieModel modelmovie;

    @org.junit.Before
    @Test
    public void setUp() throws  Exception {
        modelmovie = new MovieModel("tt0078346","Superman",1978);
        System.out.println("Model movie created in setUp");
    }

    @org.junit.Test
    public void setUpGetterIdOmdb() throws  Exception {
        Assert.assertEquals("tt0078346", modelmovie.getIdOmdb());
    }

    @org.junit.Test
    public void setUpGetterTitle() throws  Exception {
        Assert.assertEquals("Superman", modelmovie.getTitle());
    }

    @org.junit.Test
    public void setUpGetterYear() throws  Exception {
        Assert.assertEquals(1978, modelmovie.getYear());
    }

    @org.junit.Test
    public void testConstructor1() throws  Exception {
        MovieModel modelmovie1;
        modelmovie1 = new MovieModel("tt0078346",1978);
        Assert.assertEquals(1978, modelmovie1.getYear());
        Assert.assertEquals("tt0078346", modelmovie1.getIdOmdb());
    }

    @org.junit.Test
    public void testConstructor2() throws  Exception {
        MovieModel modelmovie2;
        modelmovie2 = new MovieModel("tt0078346","Superman");
        Assert.assertEquals("Superman", modelmovie2.getTitle());
        Assert.assertEquals("tt0078346", modelmovie2.getIdOmdb());
    }

    @org.junit.Test
    public void setUpSetterIdOmdb() throws  Exception {
        modelmovie.setIdOmdb("terry42");
        Assert.assertEquals("terry42", modelmovie.getIdOmdb());
    }

    @org.junit.Test
    public void setUpSetterTitle() throws  Exception {
        modelmovie.setTitle("ChatNoir");
        Assert.assertEquals("ChatNoir",modelmovie.getTitle());
    }

    @org.junit.Test
    public void setUpSetterYear() throws  Exception {
        modelmovie.setYear(2015);
        Assert.assertEquals(2015, modelmovie.getYear());
    }
}