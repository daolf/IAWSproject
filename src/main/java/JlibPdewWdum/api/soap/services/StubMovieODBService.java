package JlibPdewWdum.api.soap.services;

import org.springframework.stereotype.Service;

/**
 *
 * Created by Wladimir du Manoir, droit on 18/04/15.
 */

@Service
public class StubMovieODBService implements MovieODBService {

    @Override
    public void getMovies(String idomdb) {
        System.out.println("Idomdb=" + idomdb);
    }
}
