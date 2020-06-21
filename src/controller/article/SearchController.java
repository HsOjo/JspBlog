package controller.article;

import controller.base.HomeBaseController;
import dao.ArticleDAO;
import dao.base.Order;
import dao.base.Paginate;
import dao.base.condition.Column;
import dao.base.condition.Or;
import entity.Article;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/article/search")
public class SearchController extends HomeBaseController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        Map<String, String> param = this.param(req);
        String keyword = param.get("keyword");
        if (keyword.equals("")) {
            this.redirect(req, resp, "");
            return;
        }

        int page = Integer.parseInt(param.getOrDefault("page", "1"));

        ArticleDAO dao = ArticleDAO.getInstance();
        Paginate<Article> paginate = dao.where(Or.check(
                Column.check("title", "like", String.format("%%%s%%", keyword)),
                Column.check("content", "like", String.format("%%%s%%", keyword))
        )).setCheckpoint("where").order(Order.by("id", Order.DESC)).paginate(page);
        long count = (long) dao.restoreCheckpoint("where").count();

        HashMap<String, Object> values = new HashMap<>();
        values.put("keyword", keyword);
        values.put("count", count);
        values.put("paginate", paginate);
        this.fetch(req, resp, values);
    }
}
