package JlibPdewWdum.api.dao;

/**
 * Created by jlibert on 01/04/2015.
 */
public abstract class DAO<T> {

    public abstract boolean create(T obj);

    public abstract boolean delete(T obj);

    public abstract boolean update(T obj);

    public abstract T find(int id);
}
