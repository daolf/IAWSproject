package JlibPdewWdum.api.sdkomdb;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class MovieSDKTest extends TestCase {
    @Test
    public void testGetFromYear() throws Exception {

    }

    @Test
    public void testGetFromTitle() throws Exception {
        String r1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root response=\"True\"><movie title=\"Harry Potter and the Deathly Hallows: Part 2\" year=\"2011\" rated=\"PG-13\" released=\"15 Jul 2011\" runtime=\"130 min\" genre=\"Adventure, Fantasy, Mystery\" director=\"David Yates\" writer=\"Steve Kloves (screenplay), J.K. Rowling (novel)\" actors=\"Ralph Fiennes, Michael Gambon, Alan Rickman, Daniel Radcliffe\" plot=\"Harry, Ron and Hermione search for Voldemort's remaining Horcruxes in their effort to destroy the Dark Lord as the final battle rages on at Hogwarts.\" language=\"English\" country=\"USA, UK\" awards=\"Nominated for 3 Oscars. Another 48 wins &amp; 75 nominations.\" poster=\"http://ia.media-imdb.com/images/M/MV5BMTY2MTk3MDQ1N15BMl5BanBnXkFtZTcwMzI4NzA2NQ@@._V1_SX300.jpg\" metascore=\"87\" imdbRating=\"8.1\" imdbVotes=\"433,883\" imdbID=\"tt1201607\" type=\"movie\"/></root>";
        Assert.assertEquals("Test harry", r1, MovieSDK.get("harry"));
    }

    @Test
    public void testGetFromTitleYear() throws Exception {
        String r1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root response=\"True\"><movie title=\"Batman Returns\" year=\"1992\" rated=\"PG-13\" released=\"19 Jun 1992\" runtime=\"126 min\" genre=\"Action\" director=\"Tim Burton\" writer=\"Bob Kane (Batman characters), Daniel Waters (story), Sam Hamm (story), Daniel Waters (screenplay)\" actors=\"Michael Keaton, Danny DeVito, Michelle Pfeiffer, Christopher Walken\" plot=\"When a corrupt businessman and the grotesque Penguin plot to take control of Gotham City, only Batman can stop them, while the Catwoman has her own agenda.\" language=\"English\" country=\"USA, UK\" awards=\"Nominated for 2 Oscars. Another 2 wins &amp; 14 nominations.\" poster=\"http://ia.media-imdb.com/images/M/MV5BODM2OTc0Njg2OF5BMl5BanBnXkFtZTgwMDA4NjQxMTE@._V1_SX300.jpg\" metascore=\"N/A\" imdbRating=\"7.0\" imdbVotes=\"185,673\" imdbID=\"tt0103776\" type=\"movie\"/></root>";
        Assert.assertEquals("Test batman, 1992", r1, MovieSDK.get(1992, "batman"));
    }

}