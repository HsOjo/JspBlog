package dao;

import dao.base.BaseDAO;
import entity.Comment;

import java.sql.SQLException;
import java.util.Map;

public class CommentDAO extends BaseDAO<Comment> {
    public static CommentDAO getInstance() {
        return new CommentDAO();
    }

    @Override
    protected Comment parseEntity(Map<String, Object> map) {
        return new Comment(
                (int) map.get("id"),
                (int) map.get("article_id"),
                (int) map.get("user_id"),
                (String) map.get("content"),
                (int) map.get("create_time")
        );
    }
}
