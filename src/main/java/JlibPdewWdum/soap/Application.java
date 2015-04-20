package JlibPdewWdum.soap;

import JlibPdewWdum.api.dao.DatabaseManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by jlibert on 19/04/2015.
 */

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        DatabaseManager.env = DatabaseManager.Environment.PRODUCTION;
        SpringApplication.run(Application.class, args);
    }
}