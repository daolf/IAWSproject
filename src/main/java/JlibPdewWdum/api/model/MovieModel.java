package JlibPdewWdum.api.model;

/**
 * Created by jlibert on 01/04/2015.
 */
public class MovieModel {
    private String _IdOmdb;
    private String _title;
    private int _year;

    public MovieModel(String _IdOmdb, String _title, int _year) {
        this._IdOmdb = _IdOmdb;
        this._title = _title;
        this._year = _year;
    }

    public MovieModel(String _IdOmdb, String _title) {
        this._IdOmdb = _IdOmdb;
        this._title = _title;
    }

    public MovieModel(String _IdOmdb, int _year) {
        this._IdOmdb = _IdOmdb;
        this._year = _year;
    }
}
