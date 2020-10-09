package by.androsov.periodicals.service.impl;

import by.androsov.periodicals.bean.User;
import by.androsov.periodicals.dao.UserDAO;
import by.androsov.periodicals.dao.exception.DAOException;
import by.androsov.periodicals.dao.factory.DAOFactory;
import by.androsov.periodicals.service.ClientService;
import by.androsov.periodicals.service.exception.ServiceException;

public class ClientServiceImpl implements ClientService {
    @Override
    public void singIn(String login, String password) throws ServiceException {

        if(login == null || login.isEmpty()){
            throw new ServiceException("Incorrect login");
        }
        try{
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            UserDAO userDAO = daoObjectFactory.getUserDAO();
            userDAO.signIn(login, password);
        }catch(DAOException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public void singOut(String login) throws ServiceException {

    }

    @Override
    public void registration(User user) throws ServiceException {

    }
}
