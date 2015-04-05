package JlibPdewWdum.api.core;

import JlibPdewWdum.api.dao.DatabaseManager;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Main class.
 *
 */
public class Main {
    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost:8080/myapp/";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in JlibPdewWdum package
        final ResourceConfig rc = new ResourceConfig().packages("JlibPdewWdum");

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    /**
     * Main method.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        //Création base de données
        DatabaseManager.env = DatabaseManager.Environment.PRODUCTION;
        Connection c = null;
        String aSQLScriptFilePath1 = "database/createBDD.sql";
        String aSQLScriptFilePath2 = "database/addContent.sql";

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database/bdd.db");

            ScriptRunner sr = new ScriptRunner(c);

            Reader readerCreate = new BufferedReader(
                    new FileReader(aSQLScriptFilePath1));
            Reader readerContent = new BufferedReader(
                    new FileReader(aSQLScriptFilePath2));

            // Execute script
            sr.runScript(readerCreate);
            sr.runScript(readerContent);

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }



        final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
        System.in.read();
        server.stop();
    }
}

