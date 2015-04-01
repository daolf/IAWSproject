package JlibPdewWdum.api.dao;

import java.sql.Connection;

/**
 * Created by jlibert on 01/04/2015.
 */
public abstract class DAO<T> {
    protected Connection connect = null;

    public DAO(Connection conn) {
        this.connect = conn;
    }

    public abstract boolean create(T obj);

    public abstract boolean delete(T obj);

    public abstract boolean update(T obj);

    public abstract T find(int id);
}
