package JlibPdewWdum.api.sdkomdb;

import JlibPdewWdum.api.model.MovieModel;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MovieSDKTest extends TestCase {

    private MovieModel m;
    private MovieModel m2;
    private MovieModel m3;
    private MovieModel m4;
    private MovieModel m5;
    private MovieModel m6;
    private ArrayList<MovieModel> liste ;
    private ArrayList<MovieModel> liste2 ;


    @Before
    public void setUp() throws Exception {
        super.setUp();
        m = new MovieModel("tt1201607","Harry Potter and the Deathly Hallows: Part 2",2011);
        m2 = new MovieModel("tt0119698","Princess Mononoke",1997);
        m3 = new MovieModel("tt1992935","Mononoke",2007);
        m4 = new MovieModel("tt0484454","Princess Mononoke: Making of a Masterpiece",2004);
        m5 = new MovieModel("tt1339452","James Bond: Q's Armoury",1990);
        m6 = new MovieModel("tt0100374","Plead Guilty, Get a Bond",1990);
        liste = new ArrayList<MovieModel>();
        liste.add(m2);
        liste.add(m3);
        liste.add(m4);
        liste2 = new ArrayList<MovieModel>();
        liste2.add(m5);
        liste2.add(m6);
    }

    @Test
    public void testGetMovieFromTitle() throws Exception {
        assertEquals("test getMovieFromTitle",m,MovieSDK.getMovieFromTitle("harry"));
    }

    @Test
    public void testGetMoviesFromTitle(){
        ArrayList<MovieModel> l2 = MovieSDK.getMoviesFromTitle("Mononoke");
        assertEquals("Taille getMoviesFromTitle", liste.size(), l2.size());
        for (int i = 0; i< l2.size(); i++) {
            assertTrue("test getMoviesFromTitle :" + i + "", l2.contains(liste.get(i)));
        }
    }

    @Test
    public void testGetMovieFromTitleYear(){
        assertEquals("tesGetMovieFromTitleYear",m3,MovieSDK.getMovieFromTitleyear("Mononoke",2007));
    }

    @Test
    public void testGetMoviesFromTitleYear() throws Exception {
        ArrayList<MovieModel> l3 = MovieSDK.getMoviesFromTitle("bond",1990);
        assertEquals("Taille getMoviesFromTitleYear", liste.size(), l3.size());
        for (int i = 0; i< l3.size(); i++) {
            assertTrue("test getMoviesFromTitleYear :" + i + "", l3.contains(liste.get(i)));
        }
    }

}