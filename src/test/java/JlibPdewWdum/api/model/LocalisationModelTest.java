package JlibPdewWdum.api.model;

import junit.framework.TestCase;
import org.junit.Before;

public class LocalisationModelTest extends TestCase {

    private LocalisationModel l;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        l = new LocalisationModel(1,"VOSTFR");
    }

    public void testGetterSetter(){
        assertEquals("test getId",1,l.getId());
        assertEquals("test getIntitule","VOSTFR",l.getIntitule());
        l.setId(2);
        l.setIntitule("VO");
        assertEquals("test setId",2,l.getId());
        assertEquals("test setIntitule","VO",l.getIntitule());
    }
}