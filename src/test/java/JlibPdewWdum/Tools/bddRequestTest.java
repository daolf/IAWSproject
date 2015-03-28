package JlibPdewWdum.Tools;

import junit.framework.TestCase;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class BddRequestTest extends TestCase {

    public void testSendRequest() throws Exception {
        System.out.print("Test avec Select * from TECHNO\n");
        ResultSet rs = BddRequest.sendRequest("Select * from TECHNO");
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
}