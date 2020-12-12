package services;

import dao.*;
import bean.*;
import java.util.List;

public class Service {
    private final UserDao userDao = new UserDao();
    private final ArticleDao articleDao = new ArticleDao();
    private final SubscriptionDao subscriptionDao = new SubscriptionDao();
    private final PaymentDao paymentDao = new PaymentDao();

    public boolean register(EntityUser user) throws ServiceExcept {
        Criteria criteria = new Criteria();
        criteria.setEmail(user.getEmail());
        EntityUser existingUser;
        try {
            existingUser = userDao.getList(criteria).stream().findFirst().orElse(null);
            if (existingUser != null) {
                return false;
            }
            userDao.add(user);
        } catch (DaoException e) {
            throw new ServiceExcept(e);
        }
        return true;
    }

    public boolean login(EntityUser user) throws ServiceExcept {
        Criteria criteria = new Criteria();
        criteria.setEmail(user.getEmail());
        EntityUser existingUser;
        try {
            existingUser = userDao.getList(criteria).stream().findFirst().orElse(null);
        } catch (DaoException e) {
            throw new ServiceExcept(e);
        }
        if (existingUser == null || !existingUser.getPassword().equals(user.getPassword())) {
            return false;
        }
        user.setId(existingUser.getId());
        user.setEmail(existingUser.getEmail());
        user.setName(existingUser.getName());
        user.setRole(existingUser.getRole());
        return true;
    }

    public List<EntityArticle> getArticles() throws ServiceExcept {
        Criteria criteria = new Criteria();
        try {
            return articleDao.getList(criteria);
        } catch (DaoException e) {
            throw new ServiceExcept(e);
        }
    }

    public void saveArticle(EntityArticle publication) throws ServiceExcept {
        try {
            articleDao.add(publication);
        } catch (DaoException e) {
            throw new ServiceExcept(e);
        }
    }

    public void deleteArticle(int publicationId) throws ServiceExcept {
        EntityArticle publication = new EntityArticle();
        publication.setId(publicationId);
        try {
            articleDao.delete(publication);
        } catch (DaoException e) {
            throw new ServiceExcept(e);
        }
    }

    public EntityArticle getArticle(int publicationId) throws ServiceExcept {
        try {
            return articleDao.getById(publicationId);
        } catch (DaoException e) {
            throw new ServiceExcept(e);
        }
    }

    public void order(int publicationId, EntityUser user) throws ServiceExcept {
        EntitySubscription subscription = new EntitySubscription();
        subscription.setUserId(user.getId());
        subscription.setArticleId(publicationId);
        try {
            subscriptionDao.add(subscription);
        } catch (DaoException e) {
            throw new ServiceExcept(e);
        }
    }

    public List<EntityArticle> payment(int userId) throws ServiceExcept{
        Criteria criteria = new Criteria();
        criteria.setUserId(userId);
        try {
            return articleDao.getList(criteria);
        } catch (DaoException e) {
            throw new ServiceExcept(e);
        }
    }

    public void paymentSubmit(List<EntityArticle> list, int userId) throws ServiceExcept {
        try {
            EntityPayment entityPayment = new EntityPayment();
            int sum = 0;
            for (EntityArticle entity:list) {
                sum += entity.getCost();
            }
            entityPayment.setTotalCost(sum);
            paymentDao.add(entityPayment);
            Criteria criteria = new Criteria();
            for (EntityArticle entity:list) {
                criteria.setArticleId(entity.getId());
                criteria.setUserId(userId);
                EntitySubscription subscription = subscriptionDao.getList(criteria).stream().findFirst().orElse(null);
                if (subscription != null) {
                    subscriptionDao.update(subscription, entityPayment.getId());
                }
            }
        } catch (DaoException e) {
            throw new ServiceExcept(e);
        }
    }
}