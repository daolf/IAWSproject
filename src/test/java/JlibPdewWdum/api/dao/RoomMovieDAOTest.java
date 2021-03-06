package JlibPdewWdum.api.dao;

import JlibPdewWdum.api.model.*;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

public class RoomMovieDAOTest extends TestCase {
    private RoomMovieDAO myDAO;
    private MovieModel m1;
    private MovieModel m2;
    private MovieModel m3;
    private RoomModel r1;
    private RoomModel r2;
    private RoomModel r3;
    private RoomMovieModel rm1;
    private RoomMovieModel rm2;
    private RoomMovieModel rm3;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        DatabaseUtils.initDB(DatabaseManager.Environment.TEST, true);

        m1 = new MovieModel("tt0086250", "Scarface");
        m2 = new MovieModel("tt0453451", "Mr. Bean's Holiday");
        m3 = new MovieModel("tt0108648", "Zelda", 1993);

        r1 = new RoomModel(1, 2, 100);
        r2 = new RoomModel(5, 2, 9);
        r3 = new RoomModel(9, 1, 11);

        rm1 = new RoomMovieModel(r1, m1.getIdOmdb(), "");

        //le 3/4/2015 à 3:05:52
        rm2 = new RoomMovieModel(r2, m2.getIdOmdb(), "1428023152");
        rm3 = new RoomMovieModel(r3, m3.getIdOmdb(), "",
                new LocalisationModel(3, "VOSTFR"),
                new TechnoModel(1, "3D"));

        myDAO = new RoomMovieDAO();

    }


    public void testCreate() {
        myDAO.create(rm1);
        RoomMovieModel tmp = myDAO.find(rm1.getRoom().getIdRoom(),
                rm1.getMovie());

        RoomModel tmpRoom = tmp.getRoom();
        String tmpMovie = tmp.getMovie();

        assertEquals("Test création 1, check room", r1.getIdRoom(), tmpRoom.getIdRoom());
        assertEquals("Test création 1, check movie", m1.getIdOmdb(), tmpMovie);

        myDAO.create(rm3);
        tmp = myDAO.find(rm3.getRoom().getIdRoom(), rm3.getMovie());

        tmpRoom = tmp.getRoom();
        tmpMovie = tmp.getMovie();
        TechnoModel tmpTechno = tmp.getTechno();
        LocalisationModel tmpLocalisation = tmp.getLocalisation();

        assertEquals("Test création 3, check room", r3.getIdRoom(), tmpRoom.getIdRoom());
        assertEquals("Test création 3, check movie", m3.getIdOmdb(), tmpMovie);
        assertEquals("Test création 3, check techno", rm3.getTechno().getId(), tmpTechno.getId());
        assertEquals("Test création 3, check localisation", rm3.getLocalisation().getId(),
                tmpLocalisation.getId());

    }

    public void testDelete() {
        myDAO.create(rm2);
        myDAO.delete(rm2);
        assertEquals("Test deletion", null,
                myDAO.find(rm2.getRoom().getIdRoom(), rm2.getMovie()));
    }

    public void testFind() {
        myDAO.create(rm3);
        RoomMovieModel tmp = myDAO.find(r3.getIdRoom(), m3.getIdOmdb());
        assertEquals("Test find - check id movie", rm3.getMovie(),
                tmp.getMovie());
        assertEquals("Test find - check id room", rm3.getRoom().getIdRoom(),
                tmp.getRoom().getIdRoom());
    }

    public void testFindByParam() {
        myDAO.create(rm3);

        ArrayList<RoomMovieModel> tmp = myDAO.findByTechLocNb("IMAX", "VO", 100);
        assertEquals("Test taille liste", 1, tmp.size());
        ArrayList<RoomMovieModel> tmp2 = myDAO.findByTechLocNb("IMAaX", "VO", 100);
        assertEquals("Test taille liste", 0, tmp2.size());
        ArrayList<RoomMovieModel> tmp3 = new ArrayList<RoomMovieModel>();
        tmp3 = myDAO.findByLoc("VF");
        assertEquals("Test VF", 4, tmp3.size());
        tmp3 = myDAO.findByTech("IMAX");
        assertEquals("Test IMAX", 2, tmp3.size());

    }

    @Test
    public void testFindByMovie() throws Exception {

        myDAO.create(rm3);
        ArrayList<RoomMovieModel> tmp = myDAO.findByMovie(rm3.getMovie());
        assertEquals("Test find - check list size", 1, tmp.size());
        assertEquals("Test find - check id movie", "tt0108648", tmp.get(0).getMovie());
        assertEquals("Test find - check localisation", 3, tmp.get(0).getLocalisation().getId());
        assertEquals("Test find - check localisation", "VOSTFR", tmp.get(0).getLocalisation().getIntitule());
        assertEquals("Test find - check techno", 1, tmp.get(0).getTechno().getId());
        assertEquals("Test find - check techno", "3D", tmp.get(0).getTechno().getIntitule());

        ArrayList<RoomMovieModel> tmp1 = myDAO.findByMovie("tt1111111");
        assertEquals("Test no movie", 0, tmp1.size());
    }
}