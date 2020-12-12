package dao;

import bean.Entity;
import java.util.List;

public interface Dao<T extends Entity> {
    void add(T t) throws DaoException;

    T getById(int id) throws DaoException;

    List<T> getList(Criteria criteria) throws DaoException;

    void delete(T t) throws DaoException;
}