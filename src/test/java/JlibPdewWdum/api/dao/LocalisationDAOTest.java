package JlibPdewWdum.api.dao;

import JlibPdewWdum.api.model.LocalisationModel;
import junit.framework.TestCase;
import org.junit.Test;

public class LocalisationDAOTest extends TestCase {
    public LocalisationModel l1;
    public LocalisationModel l2;
    public LocalisationModel l3;
    public LocalisationModel l4;
    public LocalisationDAO myDAO;

    public void setUp() throws Exception {
        super.setUp();
        DatabaseUtils.initDB(DatabaseManager.Environment.TEST, false);

        l1 = new LocalisationModel(1, "VO");
        l2 = new LocalisationModel(2, "VOSTFR");
        l3 = new LocalisationModel(3, "VF");
        l4 = new LocalisationModel(4, "VFff");

        myDAO = new LocalisationDAO();
    }

    @Test
    public void testCreate() {
        myDAO.create(l1);
        LocalisationModel tmp = myDAO.find(l1.getId());
        assertEquals("Test création", l1.getId(), tmp.getId());
    }

    @Test
    public void testDelete() {
        myDAO.delete(l2);
        LocalisationModel tmp = myDAO.find(l2.getId());
        assertEquals("Test deletion", null, tmp);
    }

    @Test
    public void testFind() {
        myDAO.create(l3);
        LocalisationModel tmp = myDAO.find(l3.getId());
        assertEquals("Test find", l3.getId(), tmp.getId());
    }

    @Test
    public void testFindByName() {
        myDAO.create(l4);
        LocalisationModel tmp = myDAO.findByName(l4.getIntitule());
        assertEquals("Test find", l4.getIntitule(), tmp.getIntitule());
    }
}