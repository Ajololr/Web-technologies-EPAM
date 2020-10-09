package by.androsov.periodicals.dao;

import by.androsov.periodicals.bean.User;
import by.androsov.periodicals.dao.exception.DAOException;

public interface UserDAO {
    void signIn(String login, String password) throws DAOException;
    void registration(User user) throws DAOException;
}
