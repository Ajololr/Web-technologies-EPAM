package dao;

public class Criteria {
    private String email;
    private String name;
    private Integer userId;
    private Integer articleId;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserId(Integer userId) { this.userId = userId; }

    public Integer getUserId() { return userId; }

    public boolean existUserId() { return userId != null; }

    public void setArticleId(Integer articleId) { this.articleId = articleId; }

    public Integer getArticleId() { return articleId; }

    public boolean existPublicationId() { return articleId != null; }
}