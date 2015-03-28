package JlibPdewWdum.Tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * Created by daolf on 28/03/15.
 */
public class bddRequest {

    private static final String sJdbc = "jdbc:sqlite";
    //TODO change regarding the user
    private static final String dbLocation = "/Users/daolf/Dropbox/Cour/S8/INTEROP/IAWS-JlibPdewWdum-ProjetWS/database/bdd.db";

    public static final ResultSet sendRequest() {

        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String dbUrl = sJdbc + ":" + dbLocation;
            c = DriverManager.getConnection(dbUrl);
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        return null;
    }


    public static void main( String args[] )
    {
        sendRequest();
    }
}
