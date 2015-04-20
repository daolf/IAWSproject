package JlibPdewWdum.soap;

import JlibPdewWdum.api.dao.DatabaseManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

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