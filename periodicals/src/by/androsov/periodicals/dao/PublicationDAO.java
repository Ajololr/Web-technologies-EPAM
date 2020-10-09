package by.androsov.periodicals.dao;

import by.androsov.periodicals.bean.Publication;
import by.androsov.periodicals.dao.exception.DAOException;

public interface PublicationDAO {
    void addPublication(Publication publication) throws DAOException;
    void deletePublication(long idPublication) throws DAOException;
    void delete(Publication publication) throws DAOException;
}
