package JlibPdewWdum.api.sdkomdb;

import JlibPdewWdum.api.model.MovieModel;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import org.apache.xmlbeans.XmlException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.ws.rs.core.MultivaluedMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by daolf on 28/03/15.
 */
public class MovieSDK {

    static Client c = Client.create();
    static WebResource res = c.resource("http://www.omdbapi.com/");
    static DocumentBuilderFactory fabrique;
    static DocumentBuilder constructeur;


    public static MovieModel getMovieFromTitle(String title) throws XmlException {
        return MovieSDK.getMovieFromTitleYear(title, -1);
    }

    public static ArrayList<MovieModel> getMoviesFromTitle(String title) {
        return MovieSDK.getMoviesFromTitleYear(title, -1);
    }

    public static MovieModel getMovieFromTitleYear(String title, int year) {
        MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
        queryParams.add("t", title);
        //Pour pouvoir réutiliser le code dans getMovieFromTitle
        if (year != -1) {
            queryParams.add("y", Integer.toString(year));
        }
        queryParams.add("r", "xml");
        String s = res.queryParams(queryParams).get(String.class);
        System.out.println("String reçue:" + s);
        MovieModel m = null;
        try {
            fabrique = DocumentBuilderFactory.newInstance();
            constructeur = fabrique.newDocumentBuilder();
            Document document = constructeur.parse(new InputSource(new StringReader(s)));
            final Element racine = document.getDocumentElement();
            final Element movie = (Element) racine.getChildNodes().item(0);
            /*Normalize year attirbute*/
            int goodYear = MovieSDK.extractFirstInt(movie.getAttribute("year"));
            m = new MovieModel(movie.getAttribute("imdbID"),
                    movie.getAttribute("title"),
                    goodYear);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException se) {
            System.out.println("Erreur lors du parsing du document");
        } catch (IOException ioe) {
            System.out.println("Erreur d'entrée/sortie");
        }
        return m;
    }

    public static MovieModel getMovieFromID(String id) {
        MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
        queryParams.add("i", id);
        queryParams.add("r", "xml");
        String s = res.queryParams(queryParams).get(String.class);
        System.out.println("String reçue:" + s);
        MovieModel m = null;
        try {
            fabrique = DocumentBuilderFactory.newInstance();
            constructeur = fabrique.newDocumentBuilder();
            Document document = constructeur.parse(new InputSource(new StringReader(s)));
            final Element racine = document.getDocumentElement();
            final Element movie = (Element) racine.getChildNodes().item(0);
            /*Normalize year attirbute*/
            int goodYear = MovieSDK.extractFirstInt(movie.getAttribute("year"));
            m = new MovieModel(movie.getAttribute("imdbID"),
                    movie.getAttribute("title"),
                    goodYear);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException se) {
            System.out.println("Erreur lors du parsing du document");
        } catch (IOException ioe) {
            System.out.println("Erreur d'entrée/sortie");
        }
        return m;
    }

    public static ArrayList<MovieModel> getMoviesFromTitleYear(String title, int year) {
        MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
        queryParams.add("s", title);
        queryParams.add("r", "xml");
        //Pour pouvoir réutiliser le code dans getMoviesFromTitle
        if (year != -1) {
            queryParams.add("y", Integer.toString(year));
        }
        String s = res.queryParams(queryParams).get(String.class);
        System.out.println("String reçue:" + s);
        ArrayList<MovieModel> m = new ArrayList<MovieModel>();
        try {
            fabrique = DocumentBuilderFactory.newInstance();
            constructeur = fabrique.newDocumentBuilder();
            Document document = constructeur.parse(new InputSource(new StringReader(s)));
            final Element racine = document.getDocumentElement();
            final NodeList movies = racine.getChildNodes();
            System.out.println("Taille node list :" + movies.getLength());
            for (int i = 0; i < movies.getLength(); i++) {
                final Element movie = (Element) movies.item(i);
                int goodYear = MovieSDK.extractFirstInt(movie.getAttribute("Year"));
                System.out.println("Année bien formatée :" + goodYear);
                System.out.println("Attibuts film :" + movie.toString());
                m.add(new MovieModel(movie.getAttribute("imdbID"),
                                movie.getAttribute("Title"),
                                goodYear)
                );
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException se) {
            System.out.println("Erreur lors du parsing du document");
        } catch (IOException ioe) {
            System.out.println("Erreur d'entrée/sortie");
        }

        return m;
    }


    public static int extractFirstInt(String s) {
        Scanner in = new Scanner(s).useDelimiter("[^0-9]+");
        int goodYear = in.nextInt();
        return goodYear;
    }

}
