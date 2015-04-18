package JlibPdewWdum.api.soap.services;

/**
 * Interface used by the Endpoint.
 *
 * Created by Wladimir du Manoir, droit on 18/04/15.
 */
public interface MovieODBService {
    void FindByMovie(String idomdb);

    void FindByTechno(String techno);

    void FindByLocalisation(String localisation);
}
