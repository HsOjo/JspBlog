package service;

import dao.ArticleDAO;

import java.util.Date;
import java.util.HashMap;

public class ArticleService {
    private final ArticleDAO dao;

    public ArticleService(ArticleDAO dao) {
        this.dao = dao;
    }

    public static ArticleService getInstance() {
        return new ArticleService(new ArticleDAO());
    }

    public int createArticle(String title, String content, int category_id, int user_id) {
        long now = new Date().getTime();

        HashMap<String, Object> article_data = new HashMap<>();
        article_data.put("title", title);
        article_data.put("content", content);
        article_data.put("category_id", category_id);
        article_data.put("user_id", user_id);
        article_data.put("create_time", now);
        article_data.put("update_time", now);
        return this.dao.data(article_data).insert();
    }
}
