package JlibPdewWdum.api.model;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.Instant;

public class RoomMovieModelTest extends TestCase {
    private RoomMovieModel rvm;
    private RoomModel rm;
    private MovieModel mm;
    private LocalisationModel lm;
    private TechnoModel tm;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        rm = new RoomModel(1, 1, 10);
        mm = new MovieModel("tt00", "HARRY", 1990);
        lm = new LocalisationModel(1, "VO");
        tm = new TechnoModel(1, "IMAX");
        rvm = new RoomMovieModel(rm, mm.getIdOmdb(), "707875200", lm, tm);
    }

    @Test
    public void testGetterSetter() {
        assertEquals("Test getRoom", rm, rvm.getRoom());
        assertEquals("Test getMovie", mm.getIdOmdb(), rvm.getMovie());
        assertEquals("Test getNbPlaceUsed", 0, rvm.getNbPlaceUsed());
        assertEquals("Test getDate", (Timestamp.from(Instant.ofEpochSecond(707875200))).toString()
                , rvm.getDate().toString());
        assertEquals("Test getLocalication", lm, rvm.getLocalisation());
        assertEquals("Test getTechno", tm, rvm.getTechno());

        RoomModel rm2 = new RoomModel(2, 2, 10);
        MovieModel mm2 = new MovieModel("tt", "RRY", 1990);
        LocalisationModel lm2 = new LocalisationModel(2, "VOST");
        TechnoModel tm2 = new TechnoModel(2, "3D");
        rvm.setRoom(rm2);
        assertEquals("Test setRoom", rm2, rvm.getRoom());
        rvm.setMovie(mm2.getIdOmdb());
        assertEquals("Test setMovie", mm2.getIdOmdb(), rvm.getMovie());
        rvm.setDate("707875200");
        assertEquals("Test setDate", "1992-06-07 02:00:00.0", (Timestamp.from(Instant.ofEpochSecond(707875200))).toString());
        rvm.setLocalisation(lm2);
        assertEquals("Test setLocalication", lm2, rvm.getLocalisation());
        rvm.setTechno(tm2);
        assertEquals("Test setTechno", tm2, rvm.getTechno());
        rvm.setNbPlaceUsed(5);
        assertEquals("Test setNbPlaceUsed", 5, rvm.getNbPlaceUsed());
    }
}