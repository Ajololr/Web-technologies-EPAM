package dao;

import bean.EntityRole;
import bean.EntityUser;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserDao implements Dao<EntityUser> {

    @Override
    public void add(EntityUser entityUser) throws DaoException {
        ConnectionPool pool = null;
        Connection connection = null;
        try {
            pool = ConnectionPool.getConnectionPool();
            connection = pool.getConnection();
            String sql = "INSERT INTO user (name, password, email, role) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, entityUser.getName());
            statement.setString(2, entityUser.getPassword());
            statement.setString(3, entityUser.getEmail());
            statement.setString(4, String.valueOf(entityUser.getRole()));
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            generatedKeys.next();
            entityUser.setId(generatedKeys.getInt(1));
        } catch (SQLException | ConnectionException e) {
            throw new DaoException(e);
        }finally {
            if (pool != null)
                pool.returnConnection(connection);
        }
    }

    @Override
    public EntityUser getById(int id) throws DaoException {
        return null;
    }

    @Override
    public List<EntityUser> getList(Criteria criteria) throws DaoException {
        ConnectionPool pool = null;
        Connection connection = null;
        try {
            pool = ConnectionPool.getConnectionPool();
            connection = pool.getConnection();
            PreparedStatement statement;
            String sql = "SELECT * FROM user u WHERE email = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, criteria.getEmail());
            ResultSet resultSet = statement.executeQuery();
            LinkedList<EntityUser> users = new LinkedList<EntityUser>();
            while (resultSet.next()) {
                int id = resultSet.getInt("u.id");
                String name = resultSet.getString("u.name");
                String password = resultSet.getString("u.password");
                String email = resultSet.getString("u.email");
                String role = resultSet.getString("u.role");
                EntityUser user = new EntityUser();
                user.setId(id);
                user.setName(name);
                user.setPassword(password);
                user.setEmail(email);
                user.setRole(EntityRole.valueOf(role));
                users.add(user);
            }
            return users;
        } catch (SQLException | ConnectionException e) {
            throw new DaoException(e);
        }finally {
            if (pool != null)
                pool.returnConnection(connection);
        }
    }

    @Override
    public void delete(EntityUser userEntity) throws DaoException { }
}