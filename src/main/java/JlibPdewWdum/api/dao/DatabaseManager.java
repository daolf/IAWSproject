package JlibPdewWdum.api.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by jlibert on 01/04/2015.
 */
public class DatabaseManager {
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

            // can't get metadata ouf of a closed resultSet
            //rs.close();
            //stmt.close();
            //c.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Request send successfully : " + req);

        return rs;
    }
}
