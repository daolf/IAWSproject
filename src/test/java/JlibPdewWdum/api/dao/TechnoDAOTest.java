package JlibPdewWdum.api.dao;

import JlibPdewWdum.api.model.TechnoModel;
import JlibPdewWdum.api.model.TechnoModel;
import junit.framework.TestCase;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;

public class TechnoDAOTest extends TestCase {
    public TechnoModel l1;
    public TechnoModel l2;
    public TechnoModel l3;
    public TechnoModel l4;
    public TechnoDAO myDAO;

    public void setUp() throws Exception {
        super.setUp();
        DatabaseManager.env = DatabaseManager.Environment.TEST;
        l1 = new TechnoModel(1, "3D");
        l2 = new TechnoModel(2, "IMAX");
        l3 = new TechnoModel(3, "LEOTECHNOLOGIES");
        l4 = new TechnoModel(4, "MIX");
        myDAO = new TechnoDAO();


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

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    @Test
    public void testCreate() {
        myDAO.create(l1);
        TechnoModel tmp = myDAO.find(l1.getId());
        assertEquals("Test création", l1.getId(), tmp.getId());
    }

    @Test
    public void testDelete() {
        myDAO.delete(l2);
        TechnoModel tmp = myDAO.find(l2.getId());
        assertEquals("Test deletion", null, tmp);
    }

    @Test
    public void testFind() {
        myDAO.create(l3);
        TechnoModel tmp = myDAO.find(l3.getId());
        assertEquals("Test find", l3.getId(), tmp.getId());
    }

    @Test
    public void testFindByIntitule() {
        myDAO.create(l4);
        TechnoModel tmp = myDAO.findByIntitule(l4.getIntitule());
        assertEquals("Test find", l4.getIntitule(), tmp.getIntitule());
    }
}