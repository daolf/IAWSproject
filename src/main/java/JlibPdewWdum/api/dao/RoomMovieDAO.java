package JlibPdewWdum.api.dao;

import JlibPdewWdum.api.model.*;
import JlibPdewWdum.api.sdkomdb.MovieSDK;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by jlibert on 03/04/2015.
 */
public class RoomMovieDAO extends DAO<RoomMovieModel> {
    @Override
    public boolean create(RoomMovieModel obj) {
        String columnRequest = "(idRoom, idMovie, nbPlaceUsed, date" +
                (obj.getLocalisation() != null ? ", idLocalisation" : "") +
                (obj.getTechno() != null ? ", idTechno" : "") + ")";
        String request = "INSERT INTO RoomMovieAssociation" + columnRequest +
                "VALUES ("
                + obj.getRoom().getIdRoom() + ","
                + "'" + obj.getMovie() + "'" + ","
                + obj.getNbPlaceUsed() + ","
                + obj.getDate().toInstant().getEpochSecond()
                + (obj.getTechno() != null ? "," + obj.getLocalisation().getId() : "")
                + (obj.getLocalisation() != null ? "," + obj.getTechno().getId() : "")
                + ");";


        DatabaseManager.updateRequest(request);
        return true;

    }

    @Override
    public boolean delete(RoomMovieModel obj) {
        DatabaseManager.updateRequest("DELETE FROM RoomMovieAssociation "
                + "WHERE idRoom =" + obj.getRoom().getIdRoom()
                + " AND idMovie = " + "'" + obj.getMovie() + "'" + ";");
        return true;
    }

    @Override
    public boolean update(RoomMovieModel obj) {
        return false;
    }

    @Override
    public RoomMovieModel find(int id) {
        return null;
    }

    public RoomMovieModel find(int idRoom, String idMovie) {
        ResultSet rs = DatabaseManager.readRequest("SELECT * FROM "
                + "RoomMovieAssociation WHERE idRoom = " + idRoom
                + " AND idMovie = '" + idMovie + "';");
        RoomMovieModel tmp = null;
        ResultSetMetaData rm = null;
        try {


            rm = rs.getMetaData();
            rs.next();

            RoomDAO roomDAO = new RoomDAO();
            RoomModel roomModel = roomDAO.find(idRoom);
            MovieModel movieModel = MovieSDK.getMovieFromID(idMovie);
            TechnoDAO technoDAO = new TechnoDAO();
            TechnoModel technoModel = technoDAO.find(rs.getInt(6));
            LocalisationDAO localisationDAO = new LocalisationDAO();
            LocalisationModel localisationModel = localisationDAO.find(rs.getInt(5));
            tmp = new RoomMovieModel(roomModel, movieModel.getIdOmdb(),
                    rs.getString(4), localisationModel,technoModel );
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tmp;
    }

    public ArrayList<RoomMovieModel> findByTechLoc(String tech,String loc) {
        return findByTechLocNb(tech,loc,-1);
    }

    public ArrayList<RoomMovieModel> findByTechNb(String tech,int nb) {
        return findByTechLocNb(tech,"",0);
    }

    public ArrayList<RoomMovieModel> findByTechLoc(String loc,int nb) {
        return findByTechLocNb("",loc,nb);
    }

    public ArrayList<RoomMovieModel> findByTech(String tech) {
        return findByTechLocNb(tech,"",-1);
    }

    public ArrayList<RoomMovieModel> findByLoc(String loc) {
        return findByTechLocNb("",loc,-1);
    }

    public ArrayList<RoomMovieModel> findByTechLocNb(String tech,String loc,int nb) {
        String req = "SELECT * FROM RoomMovieAssociation as R ";
        if(tech.length() != 0){req += (" INNER JOIN Techno ON (Techno.idTechno = R.idTechno AND Techno.intituleTechno = '" + tech +"')\n");}
        if(loc .length() != 0){req += (" INNER JOIN Localisation ON (Localisation.idLocalisation = R.idLocalisation AND Localisation.intituleLocalisation = '" + loc +"')\n");}
        if(nb != -1 ){req += (" INNER JOIN Room ON (Room.idRoom = R.idRoom AND Room.nbPlaceRoom >= " + nb +")\n");}
        req+=(";");

        ResultSet rs = DatabaseManager.readRequest(req);
        ArrayList<RoomMovieModel>tmp = new ArrayList<RoomMovieModel>();
        RoomMovieModel tmp2;
        ResultSetMetaData rm = null;
        TechnoDAO technoDAO = new TechnoDAO();
        RoomDAO roomDAO = new RoomDAO();
        LocalisationDAO localisationDAO = new LocalisationDAO();


        try {
            rm = rs.getMetaData();
            while (rs.next()){
                tmp2 = new RoomMovieModel(roomDAO.find(rs.getInt(1)),
                                            rs.getString(2),
                                            rs.getInt(3),
                                            rs.getString(4),
                                            localisationDAO.find(rs.getInt(5)),
                                            technoDAO.find(rs.getInt(6))
                );
                tmp.add(tmp2);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tmp;
    }

    public ArrayList<RoomMovieModel> findByMovie(String idMovie) {

        ResultSet rs = DatabaseManager.readRequest("SELECT * FROM "
                + "RoomMovieAssociation WHERE idMovie = '" + idMovie + "';");
        ArrayList<RoomMovieModel> tmp = new ArrayList<RoomMovieModel>();
        RoomMovieModel tmp2;
        ResultSetMetaData rm = null;
        RoomDAO roomDAO = new RoomDAO();

        try {
            rm = rs.getMetaData();
            System.err.println(rm);
            while (rs.next()) {
                tmp2 = new RoomMovieModel(roomDAO.find(rs.getInt(1)),
                        rs.getString(2),
                        rs.getString(3));
                tmp.add(tmp2);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tmp;
    }
}
