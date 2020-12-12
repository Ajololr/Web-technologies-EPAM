package bean;

public class EntitySubscription extends Entity{
    int userId;
    int paymentId;
    int articleId;
    boolean isPaid;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public boolean isPaid() { return isPaid; }

    public void setPaid(boolean paid) { isPaid = paid; }
}