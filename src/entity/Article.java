package entity;

public class Article {
    private int id;
    private String title;
    private String content;
    private int category_id;
    private int user_id;
    private int create_time;
    private int update_time;

    public Article(int id, String title, String content, int category_id, int user_id, int create_time, int update_time) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.category_id = category_id;
        this.user_id = user_id;
        this.create_time = create_time;
        this.update_time = update_time;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCategoryId() {
        return this.category_id;
    }

    public void setCategoryId(int category_id) {
        this.category_id = category_id;
    }

    public int getUserId() {
        return this.user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public int getCreateTime() {
        return this.create_time;
    }

    public void setCreateTime(int create_time) {
        this.create_time = create_time;
    }

    public int getUpdateTime() {
        return this.update_time;
    }

    public void setUpdateTime(int update_time) {
        this.update_time = update_time;
    }
}
