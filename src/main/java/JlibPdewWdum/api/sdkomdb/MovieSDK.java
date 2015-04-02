package JlibPdewWdum.api.sdkomdb;

import JlibPdewWdum.api.model.MovieModel;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import javax.ws.rs.core.MultivaluedMap;
import java.util.ArrayList;

/**
 * Created by daolf on 28/03/15.
 */
public class MovieSDK {


    static Client c = Client.create();
    static WebResource res = c.resource("http://www.omdbapi.com/");




    public static MovieModel getMovieFromTitle(String title){
        MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
        queryParams.add("t", title);
        queryParams.add("s", "xml");
        String s = res.queryParams(queryParams).get(String.class);
        return null;
    }

    public static ArrayList<MovieModel> getMoviesFromTitle(String title){
        MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();

        return null;
    }

    public static MovieModel getMovieFromTitleYear(String title, int year){
        return null;
    }

    public static ArrayList<MovieModel> getMoviesFromTitleYear(String title,int year){
        MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
        return null;
    }

}
