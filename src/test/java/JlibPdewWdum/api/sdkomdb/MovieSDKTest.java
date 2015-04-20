package JlibPdewWdum.api.sdkomdb;

import JlibPdewWdum.api.model.MovieModel;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class MovieSDKTest extends TestCase {

    private MovieModel m;
    private MovieModel m2;
    private MovieModel m3;
    private MovieModel m4;
    private MovieModel m5;
    private MovieModel m6;
    private ArrayList<MovieModel> liste;
    private ArrayList<MovieModel> liste2;


    @Before
    public void setUp() throws Exception {
        super.setUp();
        m = new MovieModel("tt1201607", "Harry Potter and the Deathly Hallows: Part 2", 2011);
        m2 = new MovieModel("tt0119698", "Princess Mononoke", 1997);
        m3 = new MovieModel("tt1992935", "Mononoke", 2007);
        m4 = new MovieModel("tt0484454", "Princess Mononoke: Making of a Masterpiece", 2004);
        m5 = new MovieModel("tt1339452", "James Bond: Q's Armoury", 1990);
        m6 = new MovieModel("tt0100374", "Plead Guilty, Get a Bond", 1990);
        liste = new ArrayList<MovieModel>();
        liste.add(m2);
        liste.add(m2);
        liste.add(m3);
        liste.add(m4);
        liste2 = new ArrayList<MovieModel>();
        liste2.add(m5);
        liste2.add(m6);
    }

    @Test
    public void testGetMovieFromTitle() throws Exception {
        MovieModel buffer = MovieSDK.getMovieFromTitle("harry");
        assertEquals("test getMovieFromTitle", m.getIdOmdb(), buffer.getIdOmdb());
        assertEquals("test getMovieFromTitle", m.getTitle(), buffer.getTitle());
        assertEquals("test getMovieFromTitle", m.getYear(), buffer.getYear());

    }

    @Test
    public void testGetMovieFromID() throws Exception {
        MovieModel buffer = MovieSDK.getMovieFromID("tt1201607");
        assertEquals("test getMovieFromTitle", m.getIdOmdb(), buffer.getIdOmdb());
        assertEquals("test getMovieFromTitle", m.getTitle(), buffer.getTitle());
        assertEquals("test getMovieFromTitle", m.getYear(), buffer.getYear());

    }

    @Test
    public void testGetMoviesFromTitle() {
        ArrayList<MovieModel> l2 = MovieSDK.getMoviesFromTitle("Mononoke");
        assertEquals("Taille getMoviesFromTitle", liste.size(), l2.size());
    }

    @Test
    public void testGetMovieFromTitleYear() {
        MovieModel buffer = MovieSDK.getMovieFromTitleYear("Mononoke", 1997);
        assertEquals("tesGetMovieFromTitleYear", m2.getIdOmdb(), buffer.getIdOmdb());
        assertEquals("tesGetMovieFromTitleYear", m2.getTitle(), buffer.getTitle());
        assertEquals("tesGetMovieFromTitleYear", m2.getYear(), buffer.getYear());


    }

    @Test
    public void testGetMoviesFromTitleYear() {
        ArrayList<MovieModel> l3 = MovieSDK.getMoviesFromTitleYear("bond", 1990);
        assertEquals("Taille getMoviesFromTitleYear", liste2.size(), l3.size());
    }

}