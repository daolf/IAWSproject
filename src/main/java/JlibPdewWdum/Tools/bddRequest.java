package JlibPdewWdum.Tools;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by daolf on 28/03/15.
 */
public class bddRequest {

    private static final String sJdbc = "jdbc:sqlite";
    //TODO a changer en fonction de votre machine
    private static final String dbLocation = "/Users/daolf/Dropbox/Cour/S8/INTEROP/IAWS-JlibPdewWdum-ProjetWS/database/bdd.db";


    public static final ResultSet sendRequest(String req) {

        Connection c = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String dbUrl = sJdbc + ":" + dbLocation;
            c = DriverManager.getConnection(dbUrl);
            stmt = c.createStatement();
            rs = stmt.executeQuery(req);
            rs.close();
            stmt.close();
            c.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Request send successfully : " + req);

        return rs;
    }


    public static void main( String args[] )
    {
        sendRequest("SELECT * FROM TECHNO");
    }
}
