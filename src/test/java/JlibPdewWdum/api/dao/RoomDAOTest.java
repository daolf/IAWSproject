package JlibPdewWdum.api.dao;

import JlibPdewWdum.api.model.RoomModel;
import junit.framework.TestCase;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;

public class RoomDAOTest extends TestCase {
    public RoomModel r1;
    public RoomModel r2;
    public RoomModel r3;
    public RoomDAO myDAO;
    public void setUp() throws Exception {
        super.setUp();
        DatabaseManager.env = DatabaseManager.Environment.TEST;
        r1 = new RoomModel(65,1,10);
        r2 = new RoomModel(89,2,100);
        r3 = new RoomModel(673,3,150);
        myDAO = new RoomDAO();


        Connection c = null;
        String aSQLScriptFilePath1 = "database/createBDD.sql";
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database/test.db");

            ScriptRunner sr = new ScriptRunner(c);

            Reader readerCreate = new BufferedReader(
                    new FileReader(aSQLScriptFilePath1));


            // Execute script
            sr.runScript(readerCreate);

        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    @Test
    public void testCreate(){
        myDAO.create(r1);
        RoomModel tmp = myDAO.find(r1.getIdRoom());
        assertEquals("Test création",r1.getIdRoom(), tmp.getIdRoom());
    }

    @Test
    public void testDelete(){
        myDAO.create(r2);
        myDAO.delete(r2);
        assertEquals("Test deletion", null, myDAO.find(r2.getIdRoom()));
    }

    @Test
    public void testFind() {
        myDAO.create(r3);
        RoomModel tmp = myDAO.find(r3.getIdRoom());
        assertEquals("Test find",r3.getIdRoom(), tmp.getIdRoom());
    }
}