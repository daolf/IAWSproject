package JlibPdewWdum.api.model;

import java.sql.Timestamp;
import java.time.Instant;

/**
 * Created by daolf on 02/04/15.
 */
public class RoomMovieModel {
    private RoomModel room;
    private String movie;
    private int nbPlaceUsed;
    private Timestamp date;
    private LocalisationModel localisation;
    private TechnoModel techno;


    public RoomMovieModel(RoomModel room, String movie, int nbPlace,String date, LocalisationModel localisation, TechnoModel techno) {
        this.room = room;
        this.movie = movie;
        if(date == "")
            this.date = Timestamp.from(Instant.now());
        else
            this.date = Timestamp.from(Instant.ofEpochSecond(Long.valueOf(date)));
        this.localisation = localisation;
        this.techno = techno;
        this.nbPlaceUsed = nbPlace;
    }

    public RoomMovieModel(RoomModel room, String movie, String date, LocalisationModel localisation, TechnoModel techno) {
        this.room = room;
        this.movie = movie;
        if(date.length() == 0)
            this.date = Timestamp.from(Instant.now());
        else
            this.date = Timestamp.from(Instant.ofEpochSecond(Long.valueOf(date)));
        this.localisation = localisation;
        this.techno = techno;
        this.nbPlaceUsed = 0;
    }

    public RoomMovieModel(RoomModel room, String movie, String date){
        this(room, movie, date, null, null);
    }
    public RoomMovieModel(RoomModel room, String movie, String date, LocalisationModel localisation) {
        this(room, movie, date, localisation, null);
    }
    public RoomMovieModel(RoomModel room, String movie, String date, TechnoModel techno) {
        this(room, movie, date, null, techno);
    }

    public RoomModel getRoom() {
        return room;
    }

    public void setRoom(RoomModel room) {
        this.room = room;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public int getNbPlaceUsed() {
        return nbPlaceUsed;
    }

    public void setNbPlaceUsed(int nbPlaceUsed) {
        this.nbPlaceUsed = nbPlaceUsed;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = Timestamp.from(Instant.ofEpochSecond(Long.parseLong(date)));
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
