package JlibPdewWdum.api.core;

import JlibPdewWdum.api.dao.RoomMovieDAO;
import JlibPdewWdum.api.model.MovieModel;
import JlibPdewWdum.api.model.RoomModel;
import JlibPdewWdum.api.model.RoomMovieModel;
import JlibPdewWdum.api.sdkomdb.MovieSDK;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by daolf on 28/03/15.
 */
@Path("/")
public class MovieController {

    @Path("movie/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getMovie(
            @PathParam("id") String id) {
        System.out.println("---------");
        MovieModel movie = MovieSDK.getMovieFromID(id);
        ObjectMapper mapper = new ObjectMapper();
        String s = null;
        if (movie == null) {
            s = "{ \"error\": \"bad id\"}";
        } else {
            try {
                s = mapper.writeValueAsString(movie);
            } catch (JsonGenerationException e) {
                e.printStackTrace();
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("---------");
        return s;
    }

    @Path("movie/{id}/rooms")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getRoomsFromMovie(
            @PathParam("id") String id) throws IOException {
        String s = "{\"error\" : \"There is no room playing this movie, sorry !\"}";
        MovieModel movieModel = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            movieModel = MovieSDK.getMovieFromID(id);
        } catch (Exception e) {}
        if (movieModel != null) {
            RoomMovieDAO roomMovieDAO = new RoomMovieDAO();
            ArrayList<RoomMovieModel> associations = roomMovieDAO.findByMovie(id);
            if (associations != null && associations.size()!= 0) {

                ArrayList<RoomModel> list = new ArrayList<RoomModel>();
                for (RoomMovieModel association : associations) {
                    RoomModel actualRoom = association.getRoom();
                    list.add(actualRoom);
                }

                s = mapper.writeValueAsString(list);
            }
        }

        return s;
    }


    @Path("movies")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMovies(
            @QueryParam("t") @DefaultValue("") String title,
            @QueryParam("y") @DefaultValue("0") int year) {
        String s = null;
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<MovieModel> movies = new ArrayList<MovieModel>();
        System.out.println("---------");
        System.out.println("Param t:" + title + " y: " + year);
        if (title.length() == 0) {
            s = "{ \"error\" : \"bad parameter, missing title\"}";
        } else {
            if (year != 0) {
                movies = MovieSDK.getMoviesFromTitleYear(title, year);
            } else {
                movies = MovieSDK.getMoviesFromTitle(title);
            }

            if (movies == null) {
                s = "{ \"error\": \"bad values\"}";
            } else if (movies.size() == 0) {
                s = "{ \"error\": \"no movies found\"}";
            } else {
                s = "[";
                for (MovieModel movie : movies)
                    s = s + "{\"id\" :" + "\"/movie/" + movie.getIdOmdb() + "\"},";
                s = s.substring(0, s.length() - 1) + "]";
            }
        }
        System.out.println("Result : " + s);
        System.out.println("---------");
        return s;
    }
}
