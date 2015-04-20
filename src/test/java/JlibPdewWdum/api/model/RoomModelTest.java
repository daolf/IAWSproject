package JlibPdewWdum.api.model;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class RoomModelTest extends TestCase {


    public RoomModel r;

    @Before
    public void setUp() {
        r = new RoomModel(1, 2, 10);
    }

    @Test
    public void testGetter() {
        assertEquals("getIdRoom", 1, r.getIdRoom());
        assertEquals("getIdCinema", 2, r.getIdCinema());
        assertEquals("getNbPlaceRoom", 10, r.getNbPlaceRoom());
    }

    @Test
    public void testSetter() {
        r.setIdRoom(5);
        assertEquals("Setter idRoom", 5, r.getIdRoom());
        r.setIdCinema(10);
        assertEquals("Setter idCinema", 10, r.getIdCinema());
        r.setNbPlaceRoom(100);
        assertEquals("Setter nbPlaceRoom", 100, r.getNbPlaceRoom());

    }

}