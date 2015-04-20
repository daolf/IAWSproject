package JlibPdewWdum.api.dao;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by jlibert on 20/04/2015.
 */
public class DatabaseUtils {
    public static void initDB(DatabaseManager.Environment env, boolean addContent) {
        DatabaseManager.env = env;
        Connection c = null;
        String aSQLScriptFilePath1 = "database/createBDD.sql";
        String aSQLScriptFilePath2 = "database/addContent.sql";

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:" + DatabaseManager.getDBLocation());

            ScriptRunner sr = new ScriptRunner(c);

            Reader readerCreate = new BufferedReader(
                    new FileReader(aSQLScriptFilePath1));
            sr.runScript(readerCreate);
            if (addContent) {
                Reader readerContent = new BufferedReader(
                        new FileReader(aSQLScriptFilePath2));
                sr.runScript(readerContent);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
