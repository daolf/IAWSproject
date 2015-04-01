package JlibPdewWdum.api.sdkomdb;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import javax.ws.rs.core.MultivaluedMap;

/**
 * Created by daolf on 28/03/15.
 */
public class MovieSDK {


    static Client c = Client.create();
    static WebResource res = c.resource("http://www.omdbapi.com/");

    //TODO Change return type to movie when movie class fully implemented
    public static final String get(int year){

        MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
        queryParams.add("s", "");
        queryParams.add("y", "2000");
        queryParams.add("r", "xml");
        String s = res.queryParams(queryParams).get(String.class);
        return s;
    }

    //TODO Change return type to movie when movie class fully implemented

    public static final String get(String title){
        MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
        queryParams.add("t", title);
        queryParams.add("r", "xml");
        String s = res.queryParams(queryParams).get(String.class);
        return s;
    }

    //TODO Change return type to movie when movie class fully implemented
    public static final String get(int year, String title){
        MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
        queryParams.add("t", title);
        queryParams.add("y",Integer.toString(year));
        queryParams.add("r", "xml");
        String s = res.queryParams(queryParams).get(String.class);
        return s;
    }

    public static void main (String[] args){
        System.out.println(get("harry"));
        System.out.println(get(1992, "batman"));
    }

}
