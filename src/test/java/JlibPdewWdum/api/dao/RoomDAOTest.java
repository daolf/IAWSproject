package JlibPdewWdum.api.dao;

import JlibPdewWdum.api.model.RoomModel;
import junit.framework.TestCase;
import org.junit.Test;

public class RoomDAOTest extends TestCase {
    public RoomModel r1;
    public RoomModel r2;
    public RoomModel r3;
    public RoomDAO myDAO;

    public void setUp() throws Exception {
        super.setUp();
        DatabaseUtils.initDB(DatabaseManager.Environment.TEST, false);

        r1 = new RoomModel(65, 1, 10);
        r2 = new RoomModel(89, 2, 100);
        r3 = new RoomModel(673, 3, 150);
        myDAO = new RoomDAO();
    }

    @Test
    public void testCreate() {
        myDAO.create(r1);
        RoomModel tmp = myDAO.find(r1.getIdRoom());
        assertEquals("Test création", r1.getIdRoom(), tmp.getIdRoom());
    }

    @Test
    public void testDelete() {
        myDAO.create(r2);
        myDAO.delete(r2);
        assertEquals("Test deletion", null, myDAO.find(r2.getIdRoom()));
    }

    @Test
    public void testFind() {
        myDAO.create(r3);
        RoomModel tmp = myDAO.find(r3.getIdRoom());
        assertEquals("Test find", r3.getIdRoom(), tmp.getIdRoom());
    }
}