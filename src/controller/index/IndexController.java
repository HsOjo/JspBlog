package controller.index;

import controller.base.HomeBaseController;
import dao.ArticleDAO;
import dao.base.Order;
import dao.base.Paginate;
import entity.Article;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@WebServlet("")
public class IndexController extends HomeBaseController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        Map<String, String> param = this.param(req);
        int page = Integer.parseInt(param.getOrDefault("page", "1"));

        Paginate<Article> paginate = ArticleDAO.getInstance().
                order(Order.by("id", Order.DESC)).paginate(3, page);

        HashMap<String, Object> values = new HashMap<>();
        values.put("paginate", paginate);
        this.fetch(req, resp, values);
    }
}
