package JlibPdewWdum.api.model;

/**
 * Created by daolf on 02/04/15.
 */
public class RoomMovieModel {
    private RoomModel room;
    private MovieModel movie;
    private int nbPlaceUsed;
    private String date;
    private LocalisationModel localisation;
    private TechnoModel techno;

    public RoomMovieModel(RoomModel room, MovieModel movie, String date, LocalisationModel localisation, TechnoModel techno) {
        this.room = room;
        this.movie = movie;
        this.date = date;
        this.localisation = localisation;
        this.techno = techno;
        this.nbPlaceUsed = 0;
    }

    public RoomModel getRoom() {
        return room;
    }

    public void setRoom(RoomModel room) {
        this.room = room;
    }

    public MovieModel getMovie() {
        return movie;
    }

    public void setMovie(MovieModel movie) {
        this.movie = movie;
    }

    public int getNbPlaceUsed() {
        return nbPlaceUsed;
    }

    public void setNbPlaceUsed(int nbPlaceUsed) {
        this.nbPlaceUsed = nbPlaceUsed;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public LocalisationModel getLocalisation() {
        return localisation;
    }

    public void setLocalisation(LocalisationModel localisation) {
        this.localisation = localisation;
    }

    public TechnoModel getTechno() {
        return techno;
    }

    public void setTechno(TechnoModel techno) {
        this.techno = techno;
    }
}
