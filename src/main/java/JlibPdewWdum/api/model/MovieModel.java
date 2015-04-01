package JlibPdewWdum.api.model;

/**
 * Created by jlibert on 01/04/2015.
 */
public class MovieModel {
    private String _IdOmdb;
    private String _title;
    private int _year;

    public MovieModel(String IdOmdb, String title, int year) {
        this._IdOmdb = IdOmdb;
        this._title = title;
        this._year = year;
    }

    public MovieModel(String IdOmdb, String title) {
        this._IdOmdb = IdOmdb;
        this._title = title;
    }

    public MovieModel(String IdOmdb, int year) {
        this._IdOmdb = IdOmdb;
        this._year = year;
    }
}
