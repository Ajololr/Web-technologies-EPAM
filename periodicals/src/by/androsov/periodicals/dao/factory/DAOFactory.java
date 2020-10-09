package by.androsov.periodicals.dao.factory;

import by.androsov.periodicals.dao.PublicationDAO;
import by.androsov.periodicals.dao.UserDAO;
import by.androsov.periodicals.dao.impl.SQLPublicationDAO;
import by.androsov.periodicals.dao.impl.SQLUserDAO;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final PublicationDAO sqlPublicationImpl = new SQLPublicationDAO();
    private final UserDAO sqlUserImpl = new SQLUserDAO();

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return instance;
    }

    public PublicationDAO getPublicationDAO(){
        return sqlPublicationImpl;
    }

    public UserDAO getUserDAO(){
        return sqlUserImpl;
    }

}
