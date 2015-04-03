package JlibPdewWdum.api.model;

/**
 * Created by jlibert on 01/04/2015.
 */
public class MovieModel {
    private String _IdOmdb;
    private String _Title;
    private int _Year;


    public String getIdOmdb() {
        return _IdOmdb;
    }

    public void setIdOmdb(String IdOmdb) {
        this._IdOmdb = IdOmdb;
    }

    public String getTitle() {
        return _Title;
    }

    public void setTitle(String Title) {
        this._Title = Title;
    }

    public int getYear() {
        return _Year;
    }

    public void setYear(int Year) {
        this._Year = Year;
    }


    public MovieModel(String IdOmdb, String title, int year) {
        this._IdOmdb = IdOmdb;
        this._Title = title;
        this._Year = year;
    }

    public MovieModel(String IdOmdb, String title) {
        this._IdOmdb = IdOmdb;
        this._Title = title;
    }

    public MovieModel(String IdOmdb, int year) {
        this._IdOmdb = IdOmdb;
        this._Year = year;
    }

}
