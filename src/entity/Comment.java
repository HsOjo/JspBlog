package entity;

public class Comment {
    private int id;
    private int article_id;
    private int user_id;
    private String content;
    private int create_time;

    public Comment(int id, int article_id, int user_id, String content, int create_time) {
        this.id = id;
        this.article_id = article_id;
        this.user_id = user_id;
        this.content = content;
        this.create_time = create_time;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArticleId() {
        return this.article_id;
    }

    public void setArticleId(int article_id) {
        this.article_id = article_id;
    }

    public int getUserId() {
        return this.user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCreateTime() {
        return this.create_time;
    }

    public void setCreateTime(int create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", article_id=" + article_id +
                ", user_id=" + user_id +
                ", content='" + content + '\'' +
                ", create_time=" + create_time +
                '}';
    }
}
