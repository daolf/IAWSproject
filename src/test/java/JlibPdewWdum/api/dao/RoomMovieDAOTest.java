package JlibPdewWdum.api.dao;

import JlibPdewWdum.api.model.*;
import junit.framework.TestCase;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;

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
        DatabaseManager.env = DatabaseManager.Environment.TEST;
        Connection c = null;
        String aSQLScriptFilePath1 = "database/createBDD.sql";
        String aSQLScriptFilePath2 = "database/addContent.sql";

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database/test.db");

            ScriptRunner sr = new ScriptRunner(c);

            Reader readerCreate = new BufferedReader(
                    new FileReader(aSQLScriptFilePath1));
            Reader readerContent = new BufferedReader(
                    new FileReader(aSQLScriptFilePath2));

            // Execute script
            sr.runScript(readerCreate);
            sr.runScript(readerContent);

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        m1 = new MovieModel("tt0086250", "Scarface");
        m2 = new MovieModel("tt0453451", "Mr. Bean's Holiday");
        m3 = new MovieModel("tt0108648", "Zelda", 1993);

        r1 = new RoomModel(1, 2, 100);
        r2 = new RoomModel(5, 2, 9);
        r3 = new RoomModel(9, 1, 11);

        rm1 = new RoomMovieModel(r1, m1, "");

        //le 3/4/2015 à 3:05:52
        rm2 = new RoomMovieModel(r2, m2, "1428023152");
        rm3 = new RoomMovieModel(r3, m3, "",
                new LocalisationModel(3, "VOSTFR"),
                new TechnoModel(1, "3D"));

        myDAO = new RoomMovieDAO();

    }


    public void testCreate() throws Exception {
        myDAO.create(rm1);
        RoomMovieModel tmp = myDAO.find(rm1.getRoom(), rm1.getMovie());

        RoomModel tmpRoom = tmp.getRoom();
        MovieModel tmpMovie = tmp.getMovie();

        assertEquals("Test création 1, check room", r1.getIdRoom(), tmpRoom.getIdRoom());
        assertEquals("Test création 1, check movie", m1.getIdOmdb(), tmpMovie.getIdOmdb());

        myDAO.create(rm3);
        tmp = myDAO.find(rm3.getRoom(), rm3.getMovie());

        tmpRoom = tmp.getRoom();
        tmpMovie = tmp.getMovie();
        TechnoModel tmpTechno = tmp.getTechno();
        LocalisationModel tmpLocalisation = tmp.getLocalisation();

        assertEquals("Test création 3, check room", r3.getIdRoom(), tmpRoom.getIdRoom());
        assertEquals("Test création 3, check movie", m3.getIdOmdb(), tmpMovie.getIdOmdb());
        assertEquals("Test création 3, check techno", m3.getIdOmdb(), tmpMovie.getIdOmdb());
        assertEquals("Test création 3, check techno", rm3.getTechno().getId(), tmpTechno.getId());
        assertEquals("Test création 3, check localisation", rm3.getLocalisation().getId(), tmpLocalisation.getId());

    }

    public void testDelete() throws Exception {
        myDAO.create(rm2);
        myDAO.delete(rm2);
        assertTrue(false);
        assertEquals("Test deletion", null,
                myDAO.find(rm2.getRoom(), rm2.getMovie()));
    }

    public void testFind() throws Exception {
        myDAO.create(rm3);
        RoomMovieModel tmp = myDAO.find(r3.getIdRoom());
        assertEquals("Test find - check id movie",rm3.getMovie().getIdOmdb(), tmp.getMovie().getIdOmdb());
        assertEquals("Test find - check id room",rm3.getRoom().getIdRoom(), tmp.getRoom().getIdRoom());
    }

}