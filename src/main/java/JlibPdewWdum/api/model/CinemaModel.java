package JlibPdewWdum.api.model;

/**
 * Created by daolf on 02/04/15.
 */
public class CinemaModel {

    private int id;
    private String title;
    private String adress;

    public CinemaModel(int id, String title, String adress) {
        this.id = id;
        this.title = title;
        this.adress = adress;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAdress() {
        return adress;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
