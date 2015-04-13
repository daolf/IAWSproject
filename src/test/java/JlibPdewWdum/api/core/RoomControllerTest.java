package JlibPdewWdum.api.core;


import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import javax.ws.rs.core.Application;


public class RoomControllerTest extends JerseyTest {
    @Override
    protected Application configure() {
        return new ResourceConfig(RoomController.class);
    }

    @Test
    public void testGetRooms() {
        String roomsVOTest = target("/rooms").queryParam("loc", "VO").request().get(String.class);
        String roomsVOOriginal = "[{\"room\":{\"idRoom\":1,\"idCinema\":2,\"nbPlaceRoom\":100},\"movie\":\"tt0103854\",\"nbPlaceUsed\":7,\"date\":1427478108000,\"localisation\":{\"id\":1,\"intitule\":\"VO\"},\"techno\":{\"id\":2,\"intitule\":\"IMAX\"}}]";

        String roomsErrorTest = target("/rooms").queryParam("loc", "VOUZBEKISTAN").request().get(String.class);
        String roomsErrorOriginal = "{ \"error\": \"no association found\"}";

        String roomsIMAXTest = target("/rooms").queryParam("tech", "IMAX").request().get(String.class);
        String roomsIMAXOriginal = "[{\"room\":{\"idRoom\":4,\"idCinema\":2,\"nbPlaceRoom\":402},\"movie\":\"tt2322441\",\"nbPlaceUsed\":1,\"date\":1348172976000,\"localisation\":{\"id\":2,\"intitule\":\"VF\"},\"techno\":{\"id\":2,\"intitule\":\"IMAX\"}},{\"room\":{\"idRoom\":1,\"idCinema\":2,\"nbPlaceRoom\":100},\"movie\":\"tt0103854\",\"nbPlaceUsed\":7,\"date\":1427478108000,\"localisation\":{\"id\":1,\"intitule\":\"VO\"},\"techno\":{\"id\":2,\"intitule\":\"IMAX\"}}]";

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
}