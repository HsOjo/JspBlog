package service;

import dao.ArticleDAO;
import dao.base.condition.Column;
import entity.Article;

import java.util.Date;
import java.util.HashMap;

public class ArticleService {
    private final ArticleDAO dao;
    private HashMap<Integer, Article> article_buffer;

    public ArticleService(ArticleDAO dao) {
        this.dao = dao;
    }

    public static ArticleService getInstance() {
        return new ArticleService(new ArticleDAO());
    }

    public int createArticle(String title, String content, int category_id, int user_id) {
        int now = (int) (new Date().getTime()/1000);

        HashMap<String, Object> article_data = new HashMap<>();
        article_data.put("title", title);
        article_data.put("content", content);
        article_data.put("category_id", category_id);
        article_data.put("user_id", user_id);
        article_data.put("create_time", now);
        article_data.put("update_time", now);
        return this.dao.data(article_data).insert();
    }

    public Article getArticleById(int article_id) {
        if (this.article_buffer == null)
            this.article_buffer = new HashMap<>();
        Article article;
        if (article_buffer.containsKey(article_id)) {
            article = article_buffer.get(article_id);
        } else {
            article = this.dao.where(Column.check("id", "=", article_id)).find();
            this.article_buffer.put(article_id, article);
        }
        return article;
    }
}
