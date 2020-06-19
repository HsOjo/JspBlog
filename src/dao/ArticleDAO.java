package dao;

import dao.base.BaseDAO;
import entity.Article;

import java.util.Map;

public class ArticleDAO extends BaseDAO<Article> {
    public static ArticleDAO getInstance() {
        return new ArticleDAO();
    }

    @Override
    protected Article parseEntity(Map<String, Object> map) {
        return new Article(
                (int) map.get("id"),
                (String) map.get("title"),
                (String) map.get("content"),
                (int) map.get("category_id"),
                (int) map.get("user_id"),
                (int) map.get("create_time"),
                (int) map.get("update_time")
        );
    }
}
