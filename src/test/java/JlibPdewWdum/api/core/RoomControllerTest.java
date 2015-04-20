package JlibPdewWdum.api.core;


import JlibPdewWdum.api.dao.DatabaseManager;
import JlibPdewWdum.api.dao.DatabaseUtils;
import JlibPdewWdum.api.dao.RoomMovieDAO;
import JlibPdewWdum.api.model.RoomMovieModel;
import com.sun.jersey.api.representation.Form;
import junit.framework.Assert;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;


public class RoomControllerTest extends JerseyTest {

    public static final String path = Constants.path;

    public void setUp() throws Exception {
        super.setUp();
        DatabaseUtils.initDB(DatabaseManager.Environment.TEST, true);

    }


    @Override
    protected Application configure() {
        return new ResourceConfig(RoomController.class);
    }

    @Test
    public void testGetRooms() {
        String roomsVOTest = target("/rooms").queryParam("loc", "VO").request().get(String.class);
        String roomsVOOriginal = "[{\"room\":\"http://localhost:8080/myapp/room/1\",\"movie\":\"http://localhost:8080/myapp/movie/tt0103854\",\"nbPlaceUsed\":7,\"date\":\"2015-03-27 18:41:48.0\",\"localisation\":\"VO\",\"technologie\":\"IMAX\"}]";

        String roomsErrorTest = target("/rooms").queryParam("loc", "VOUZBEKISTAN").request().get(String.class);
        String roomsErrorOriginal = "{ \"error\": \"no association found\"}";

        String roomsIMAXTest = target("/rooms").queryParam("tech", "IMAX").request().get(String.class);
        String roomsIMAXOriginal = "[{\"room\":\"http://localhost:8080/myapp/room/4\",\"movie\":\"http://localhost:8080/myapp/movie/tt2322441\",\"nbPlaceUsed\":1,\"date\":\"2012-09-20 22:29:36.0\",\"localisation\":\"VF\",\"technologie\":\"IMAX\"},{\"room\":\"http://localhost:8080/myapp/room/1\",\"movie\":\"http://localhost:8080/myapp/movie/tt0103854\",\"nbPlaceUsed\":7,\"date\":\"2015-03-27 18:41:48.0\",\"localisation\":\"VO\",\"technologie\":\"IMAX\"}]";

        String roomsWrongParamTest = target("/rooms").queryParam("localocaloca", "VO").request().get(String.class);
        String roomsWrongParamOriginal = "{ \"error\": \"no association found\"}";

        try {
            JSONAssert.assertEquals(roomsVOOriginal, roomsVOTest, false);
            JSONAssert.assertEquals(roomsErrorTest, roomsErrorOriginal, false);
            JSONAssert.assertEquals(roomsIMAXTest, roomsIMAXOriginal, false);
            JSONAssert.assertEquals(roomsWrongParamTest, roomsWrongParamOriginal, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPostMovie() {
        RoomMovieDAO dao = new RoomMovieDAO();

        // add Bambi to Room 1
        Form form = new Form();
        form.add("id", "tt0034492");
        target("/room").path("1").path("movie").request().post(Entity.form(form));
        RoomMovieModel newAssociation = dao.find(1, "tt0034492");
        Assert.assertFalse(newAssociation == null);

        // add Se7en to Room 2
        form = new Form();
        form.add("id", "tt0114369");
        form.add("loc", "VO");
        form.add("tech", "IMAX");
        target("/room").path("2").path("movie").request().post(Entity.form(form));

        // add Interstellar to Room 3 with new Loc' & tech
        form = new Form();
        form.add("id", "tt0816692");
        form.add("loc", "testLocalisation0X000003");
        form.add("tech", "testTechno0X000003");
        target("/room").path("3").path("movie").request().post(Entity.form(form));

    }

    @Test
    public void testGetRoomById() {

        String roomWrongParam = target("/room").path("100").request().get(String.class);
        String roomWrongParamOriginal = "{ \"error\": \"this room does not exist\"}";

        String roomGoodParam = target("/room").path("1").request().get(String.class);
        String roomGoodParamOriginal = "{\"idRoom\":\"1\",\"cinema\":\"http://localhost:8080/myapp/cinema/2\",\"nbPlace\":100}";

        try {
            JSONAssert.assertEquals(roomWrongParam, roomWrongParamOriginal, false);
            JSONAssert.assertEquals(roomGoodParam, roomGoodParamOriginal, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}