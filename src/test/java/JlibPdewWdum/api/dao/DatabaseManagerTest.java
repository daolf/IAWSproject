package JlibPdewWdum.api.dao;

import junit.framework.TestCase;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.BeforeClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class DatabaseManagerTest extends TestCase {

    // TODO INIT NEW DATABASE
    @BeforeClass
    public void initDatabase() {
        Connection c = null;
        String aSQLScriptFilePath = "../../../../../database/createBDD.sql";
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");

            ScriptRunner sr = new ScriptRunner(c, false, false);

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }

    public void testReadRequest() throws Exception {
        System.out.print("Test avec Select * from TECHNO\n");
        ResultSet rs = DatabaseManager.readRequest("Select * from TECHNO");
        ResultSetMetaData rm = rs.getMetaData();
        assertEquals("Nb colonne",2,rm.getColumnCount());
        assertEquals("Nom colonne 1","idTechno",rm.getColumnName(1));
        assertEquals("Nom colonne 1","intituleTechno",rm.getColumnName(2));
        rs.next();
        assertEquals("Tuple 1","1", rs.getObject(1).toString());
        assertEquals("Tuple 1","3D", rs.getObject(2).toString());
        rs.next();
        assertEquals("Tuple 2","2", rs.getObject(1).toString());
        assertEquals("Tuple 2","IMAX", rs.getObject(2).toString());

    }

    public void testWriteRequest() throws Exception {

        System.out.print("Test insertion de la Localisation d'ID 9999 et de nom \"testloc\" \n");
        String writeRequest = "INSERT INTO 'Localisation'"
                + "('idLocalisation','intituleLocalisation')"
                + " VALUES (9999, 'testloc');";
        String readRequest = "Select * from LOCALISATION "
                           + "where idLocalisation = 9999";

        DatabaseManager.writeRequest(writeRequest);
        ResultSet rs = DatabaseManager.readRequest(readRequest);
        rs.next();
        assertEquals(rs.getInt(1), 9999);
        assertEquals(rs.getString(2), "testloc");
    }
}