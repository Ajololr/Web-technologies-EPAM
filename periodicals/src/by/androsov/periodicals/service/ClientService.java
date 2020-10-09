package by.androsov.periodicals.service;

import by.androsov.periodicals.bean.User;
import by.androsov.periodicals.service.exception.ServiceException;

public interface ClientService {
    void singIn(String login, String password) throws ServiceException;
    void singOut(String login) throws ServiceException;
    void registration(User user) throws ServiceException;
}
