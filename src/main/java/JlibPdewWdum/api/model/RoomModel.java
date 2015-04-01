package JlibPdewWdum.api.model;

/**
 * Created by jlibert on 01/04/2015.
 */
public class RoomModel {

    private int idRoom;
    private int idCinema;
    private int nbPlaceRoom;

    public RoomModel(int idRoom, int idCinema, int nbPlaceRoom) {
        this.idRoom = idRoom;
        this.idCinema = idCinema;
        this.nbPlaceRoom = nbPlaceRoom;
    }

    public int getNbPlaceRoom() {
        return nbPlaceRoom;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public int getIdCinema() {
        return idCinema;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public void setIdCinema(int idCinema) {
        this.idCinema = idCinema;
    }

    public void setNbPlaceRoom(int nbPlaceRoom) {
        this.nbPlaceRoom = nbPlaceRoom;
    }
}
