package JlibPdewWdum.Tools;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import javax.ws.rs.core.MultivaluedMap;

/**
 * Created by daolf on 28/03/15.
 */
public class OmdbClient {


    static Client c = Client.create();
    static WebResource res = c.resource("http://www.omdbapi.com/");

    //TODO Change return type to movie when movie class fully implemented
    public static final String getFromYear(int year){

        MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
        queryParams.add("s", "");
        queryParams.add("y", "2000");
        queryParams.add("r", "xml");
        String s = res.queryParams(queryParams).get(String.class);
        return s;
    }

    //TODO Change return type to movie when movie class fully implemented

    public static final String getFromTitle(String title){
        MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
        queryParams.add("t", title);
        queryParams.add("r", "xml");
        String s = res.queryParams(queryParams).get(String.class);
        return s;
    }

    //TODO Change return type to movie when movie class fully implemented
    public static final String getFromTitleYear(int year,String title){
        MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
        queryParams.add("t", title);
        queryParams.add("y",Integer.toString(year));
        queryParams.add("r", "xml");
        String s = res.queryParams(queryParams).get(String.class);
        return s;
    }

    public static void main (String[] args){
        System.out.println(getFromTitle("harry"));
        System.out.println(getFromTitleYear(1992,"batman"));
    }

}
