package controller.article;

import controller.base.HomeBaseController;
import dao.ArticleDAO;
import dao.CategoryDAO;
import dao.base.Order;
import dao.base.Paginate;
import dao.base.condition.Column;
import entity.Article;
import entity.Category;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/article/category")
public class CategoryController extends HomeBaseController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        Map<String, String> param = this.param(req);
        int page = Integer.parseInt(param.getOrDefault("page", "1"));
        int category_id = Integer.parseInt(param.get("id"));

        Category category = CategoryDAO.getInstance().where(Column.check("id", "=", category_id)).find();
        Paginate<Article> paginate = ArticleDAO.getInstance()
                .where(Column.check("category_id", "=", category_id))
                .order(Order.by("id", Order.DESC)).paginate(page);

        HashMap<String, Object> values = new HashMap<>();
        values.put("category", category);
        values.put("paginate", paginate);
        this.fetch(req, resp, values);
    }
}
