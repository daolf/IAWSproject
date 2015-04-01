package JlibPdewWdum.api.model;

import junit.framework.TestCase;
import org.junit.Before;

public class RoomModelTest extends TestCase {


    public RoomModel r;
    @Before
    public void setup() {
        r = new RoomModel(1,2,10);
    }

    public void testGetter() {
        assertEquals("getIdRoom",1,r.getIdRoom());
        assertEquals("getIdCinema",2,r.getIdCinema());
        assertEquals("getNbPlaceRoom",10,r.getIdRomm());
    }

    public void testSetter(){
        r.setIdRoom(5);
        assertEquals("Setter idRoom",5,r.getIdRoom());
        r.setIdCinema(10);
        assertEquals("Setter idCinema",10,r.setIdCinema());
    }

}