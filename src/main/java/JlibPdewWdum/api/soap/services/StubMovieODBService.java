package JlibPdewWdum.api.soap.services;

import org.springframework.stereotype.Service;

/**
 *
 * Created by Wladimir du Manoir, droit on 18/04/15.
 */

@Service
public class StubMovieODBService implements MovieODBService {

    @Override
    public void FindByMovie(String idomdb) {
       System.out.println("Idomdb=" + idomdb);
    }

    @Override
    public void FindByTechno(String techno) {
        System.out.println("Techno=" + techno);
    }

    @Override
    public void FindByLocalisation(String localisation) {
        System.out.println("Localistion=" + localisation);
    }
}
