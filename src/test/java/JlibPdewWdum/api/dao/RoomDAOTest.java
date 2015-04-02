package JlibPdewWdum.api.dao;

import JlibPdewWdum.api.model.RoomModel;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class RoomDAOTest extends TestCase {
    public RoomModel r1;
    public RoomModel r2;
    public RoomModel r3;
    public RoomDAO myDAO;
    @Before
    public void setUp() throws Exception {
        super.setUp();
        r1 = new RoomModel(1,1,10);
        r2 = new RoomModel(2,2,100);
        r3 = new RoomModel(3,3,150);
        myDAO = new RoomDAO();
    }

    @Test
    public void testCreate(){
        myDAO.create(r1);
        assertEquals("Test création",r1,myDAO.find(r1.getIdRoom()));
    }

    @Test
    public void testDelete(){
        myDAO.create(r2);
        myDAO.delete(r2);
        assertEquals("Test deletion", null, myDAO.find(r2.getIdRoom()));
    }

    @Test
    public void testUpdate() {
        //TODO
    }

    @Test void testFind() {
        //r3
        //assertEquals("Test find",r3,myDao.find(r3.getIdRoom()));
    }
}