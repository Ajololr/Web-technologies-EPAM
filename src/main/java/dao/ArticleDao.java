package dao;

import bean.EntityArticle;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ArticleDao implements Dao<EntityArticle> {
    @Override
    public void add(EntityArticle entityArticle) throws DaoException {
        ConnectionPool pool = null;
        Connection connection = null;
        try {
            pool = ConnectionPool.getConnectionPool();
            connection = pool.getConnection();
            String sql = "INSERT INTO article (name, cost, description) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, entityArticle.getName());
            statement.setInt(2, entityArticle.getCost());
            statement.setString(3, entityArticle.getDescription());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            generatedKeys.next();
            entityArticle.setId(generatedKeys.getInt(1));
        } catch (SQLException | ConnectionException e) {
            throw new DaoException(e);
        } finally {
            if (pool != null)
                pool.returnConnection(connection);
        }
    }

    @Override
    public EntityArticle getById(int id) throws DaoException {
        ConnectionPool pool = null;
        Connection connection = null;
        try {
            pool = ConnectionPool.getConnectionPool();
            connection = pool.getConnection();
            String selectArticles = "SELECT * FROM article p WHERE p.id = ?";
            PreparedStatement statement = connection.prepareStatement(selectArticles);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            EntityArticle entityArticle = null;
            if (resultSet.next()) {
                int articleId = resultSet.getInt("p.id");
                String name = resultSet.getString("p.name");
                int cost = resultSet.getInt("p.cost");
                String description = resultSet.getString("p.description");
                entityArticle = new EntityArticle();
                entityArticle.setId(articleId);
                entityArticle.setName(name);
                entityArticle.setCost(cost);
                entityArticle.setDescription(description);
            }
            return entityArticle;
        } catch (SQLException | ConnectionException e) {
            throw new DaoException(e);
        } finally {
            if (pool != null)
                pool.returnConnection(connection);
        }
    }

    @Override
    public List<EntityArticle> getList(Criteria criteria) throws DaoException {
        ConnectionPool pool = null;
        Connection connection = null;
        try {
            pool = ConnectionPool.getConnectionPool();
            connection = pool.getConnection();
            PreparedStatement statement;
            if (criteria.existUserId()) {
                String sql = "SELECT * FROM article p, subscription s WHERE s.user_id = ? AND s.article_id = p.id AND s.is_paid = 0";
                statement = connection.prepareStatement(sql);
                statement.setInt(1, criteria.getUserId());
            } else {
                String sql = "SELECT * FROM article";
                statement = connection.prepareStatement(sql);
            }
            ResultSet resultSet = statement.executeQuery();
            LinkedList<EntityArticle> articles = new LinkedList<EntityArticle>();
            while (resultSet.next()) {
                int articleId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int cost = resultSet.getInt("cost");
                String description = resultSet.getString("description");
                EntityArticle article = new EntityArticle();
                article.setId(articleId);
                article.setName(name);
                article.setCost(cost);
                article.setDescription(description);
                articles.add(article);
            }
            return articles;
        } catch (SQLException | ConnectionException e) {
            throw new DaoException(e);
        } finally {
            if (pool != null)
                pool.returnConnection(connection);
        }
    }

    @Override
    public void delete(EntityArticle entityArticle) throws DaoException {
        ConnectionPool pool = null;
        Connection connection = null;
        try {
            pool = ConnectionPool.getConnectionPool();
            connection = pool.getConnection();
            String sql = "DELETE FROM article WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, entityArticle.getId());
            statement.executeUpdate();
        } catch (SQLException | ConnectionException e) {
            throw new DaoException(e);
        } finally {
            if (pool != null)
                pool.returnConnection(connection);
        }
    }
}
