package controller.index;

import controller.base.HomeBaseController;
import entity.Article;
import service.ArticleService;
import service.base.Paginate;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@WebServlet("")
public class IndexController extends HomeBaseController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        HashMap<String, Object> values = new HashMap<>();
        Paginate<Article> paginate = ArticleService.getInstance().paginate(1);
        values.put("paginate", paginate);
        this.fetch(req, resp, values);
    }
}
