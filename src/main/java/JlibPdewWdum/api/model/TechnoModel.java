package JlibPdewWdum.api.model;

/**
 * Created by daolf on 02/04/15.
 */
public class TechnoModel {

    private int id;
    private String intitule;

    public TechnoModel(int id, String intitule) {
        this.id = id;
        this.intitule = intitule;
    }

    public int getId() {
        return id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }
}
