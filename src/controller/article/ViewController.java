package controller.article;

import controller.base.HomeBaseController;
import dao.ArticleDAO;
import dao.CommentDAO;
import dao.base.Order;
import dao.base.condition.Column;
import entity.Article;
import entity.Comment;
import dao.base.Paginate;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/article/view")
public class ViewController extends HomeBaseController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        Map<String, String> param = this.param(req);
        int page = Integer.parseInt(param.getOrDefault("page", "1"));
        int id = Integer.parseInt(param.get("id"));

        Article article = ArticleDAO.getInstance().where(Column.check("id", "=", id)).find();

        Paginate<Comment> paginate = CommentDAO.getInstance()
                .where(Column.check("article_id", "=", id))
                .order(Order.by("id", Order.DESC)).paginate(page);

        HashMap<String, Object> values = new HashMap<>();
        values.put("article", article);
        values.put("paginate", paginate);
        this.fetch(req, resp, values);
    }
}
