package JlibPdewWdum.api.model;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class CinemaModelTest extends TestCase {

    private CinemaModel c;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        c = new CinemaModel(1, "LIDO", "2 rue de pezenas");
    }

    @Test
    public void testGetterSetter() {
        assertEquals("Test getId", 1, c.getId());
        assertEquals("Test getTitle", "LIDO", c.getTitle());
        assertEquals("Test getAdress", "2 rue de pezenas", c.getAdress());
        c.setId(2);
        c.setTitle("GAUMONT");
        c.setAdress("LABEGE");
        assertEquals("Test setId", 2, c.getId());
        assertEquals("Test setTitle", "GAUMONT", c.getTitle());
        assertEquals("Test setAdress", "LABEGE", c.getAdress());
    }
}