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
    private static final String dbProductionLocation = "database/bdd.db";
    private static final String dbTestLocation = "database/test.db";

    public enum Environment {PRODUCTION, TEST};


    public static Environment env = Environment.PRODUCTION;

    public static String getDBLocation() {
        switch (env) {
            case PRODUCTION:
                return dbProductionLocation;
            default:
                return dbTestLocation;
        }
    }

    public static ResultSet readRequest(String request) {
        Connection c = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String dbUrl = sJdbc + ":" + getDBLocation();
            c = DriverManager.getConnection(dbUrl);
            stmt = c.createStatement();
            rs = stmt.executeQuery(request);
            // can't get metadata ouf of a closed resultSet
            // rs.close();
            //stmt.close();
            // c.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Read request sent successfully : " + request);
        return rs;
    }

    public static void updateRequest(String request) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String dbUrl = sJdbc + ":" + getDBLocation();
            c = DriverManager.getConnection(dbUrl);
            stmt = c.createStatement();
            stmt.executeUpdate(request);
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Read request sent successfully : " + request);
    }
}
