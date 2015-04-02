package JlibPdewWdum.api.model;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class TechnoModelTest extends TestCase {

    private TechnoModel techno;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        techno = new TechnoModel(1,"IMAX");
    }

    @Test
    public void testGetSet(){
        assertEquals("Test getId",1,TechnoModel.getId());
        assertEquals("Test getIntitule","IMAX",TechnoModel.getIntitule());
        techno.setId(2);
        techno.setIntitule("3D");
        assertEquals("Test setId",2,TechnoModel.getId());
        assertEquals("Test setIntitule","3D",TechnoModel.getIntitule());
    }
}