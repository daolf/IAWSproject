package JlibPdewWdum.api.dao;

import junit.framework.TestCase;
import org.junit.Before;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DatabaseManagerTest extends TestCase {

    // TODO INIT NEW DATABASE
    @Before
    public void setUp() throws Exception {
        super.setUp();
        DatabaseUtils.initDB(DatabaseManager.Environment.TEST, true);
    }

    public void testReadRequest() {
        System.out.print("Test avec SELECT * FROM Techno\n");
        ResultSet rs = DatabaseManager.readRequest("SELECT * FROM Techno");
        ResultSetMetaData rm = null;
        try {
            rm = rs.getMetaData();
            assertEquals("Nb colonne", 2, rm.getColumnCount());
            assertEquals("Nom colonne 1", "idTechno", rm.getColumnName(1));
            assertEquals("Nom colonne 1", "intituleTechno", rm.getColumnName(2));
            rs.next();
            assertEquals("Tuple 1", "1", rs.getObject(1).toString());
            assertEquals("Tuple 1", "3D", rs.getObject(2).toString());
            rs.next();
            assertEquals("Tuple 2", "2", rs.getObject(1).toString());
            assertEquals("Tuple 2", "IMAX", rs.getObject(2).toString());
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void testupdateRequest() {

        System.out.print("Test insertion de la Localisation d'ID 9999 et de nom \"testloc\" \n");
        String writeRequest = "INSERT INTO 'Localisation'"
                + "('idLocalisation','intituleLocalisation')"
                + " VALUES (9999, 'testloc');";
        String readRequest = "Select * from LOCALISATION "
                + "where idLocalisation = 9999";

        DatabaseManager.updateRequest(writeRequest);
        ResultSet rs = DatabaseManager.readRequest(readRequest);
        try {
            rs.next();
            rs.next();
            assertEquals(rs.getInt(1), 9999);
            assertEquals(rs.getString(2), "testloc");
            rs.close();
        } catch (SQLException e) {
        }
    }
}