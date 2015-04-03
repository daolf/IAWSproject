package JlibPdewWdum.api.dao;

import JlibPdewWdum.api.model.LocalisationModel;
import JlibPdewWdum.api.model.RoomModel;
import junit.framework.TestCase;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;

public class LocalisationDAOTest extends TestCase {
    public LocalisationModel l1;
    public LocalisationModel l2;
    public LocalisationModel l3;
    public LocalisationDAO myDAO;
    public void setUp() throws Exception {
        super.setUp();
        DatabaseManager.env = DatabaseManager.Environment.TEST;
        l1 = new LocalisationModel(1,"VO");
        l2 = new LocalisationModel(2,"VOSTFR");
        l3 = new LocalisationModel(3,"VF");
        myDAO = new LocalisationDAO();


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
        myDAO.create(l1);
        LocalisationModel tmp = myDAO.find(l1.getId());
        assertEquals("Test création",l1.getId(), tmp.getId());
    }

    @Test
    public void testDelete(){
        myDAO.delete(l2);
        LocalisationModel tmp = myDAO.find(l2.getId());
        assertEquals("Test deletion", null,tmp);
    }

    @Test
    public void testFind() {
        myDAO.create(l3);
        LocalisationModel tmp = myDAO.find(l3.getId());
        assertEquals("Test find",l3.getId(), tmp.getId());
    }
}