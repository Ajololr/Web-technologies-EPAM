package dao;

import bean.EntityPayment;
import java.sql.*;
import java.util.List;

public class PaymentDao implements Dao<EntityPayment>{
    @Override
    public void add(EntityPayment entityPayment) throws DaoException {
        ConnectionPool pool = null;
        Connection connection = null;
        try {
            pool = ConnectionPool.getConnectionPool();
            connection = pool.getConnection();
            String sql = "INSERT INTO payment (total_cost) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, entityPayment.getTotalCost());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            generatedKeys.next();
            entityPayment.setId(generatedKeys.getInt(1));
        } catch (SQLException | ConnectionException e) {
            throw new DaoException(e);
        } finally {
            if (pool != null)
                pool.returnConnection(connection);
        }
    }

    @Override
    public EntityPayment getById(int id) throws DaoException {
        return null;
    }

    @Override
    public List<EntityPayment> getList(Criteria criteria) throws DaoException {
        return null;
    }

    @Override
    public void delete(EntityPayment entityPayment) throws DaoException {}
}