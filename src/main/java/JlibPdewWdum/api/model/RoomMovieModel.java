package JlibPdewWdum.api.model;

import org.glassfish.grizzly.http.util.TimeStamp;

import java.sql.Timestamp;
import java.time.Instant;

/**
 * Created by daolf on 02/04/15.
 */
public class RoomMovieModel {
    private RoomModel room;
    private MovieModel movie;
    private int nbPlaceUsed;
    private Timestamp date;
    private LocalisationModel localisation;
    private TechnoModel techno;

    public RoomMovieModel(RoomModel room, MovieModel movie, String date, LocalisationModel localisation, TechnoModel techno) {
        this.room = room;
        this.movie = movie;
        if(date == "")
            this.date = Timestamp.from(Instant.now());
        else
            this.date = Timestamp.from(Instant.ofEpochSecond(Long.valueOf(date)));
        this.localisation = localisation;
        this.techno = techno;
        this.nbPlaceUsed = 0;
    }

    public RoomMovieModel(RoomModel room, MovieModel movie, String date){
        this(room, movie, date, null, null);
    }
    public RoomMovieModel(RoomModel room, MovieModel movie, String date, LocalisationModel localisation) {
        this(room, movie, date, localisation, null);
    }
    public RoomMovieModel(RoomModel room, MovieModel movie, String date, TechnoModel techno) {
        this(room, movie, date, null, techno);
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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = Timestamp.from(Instant.parse(date));
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
