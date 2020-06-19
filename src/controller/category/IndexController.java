package controller.category;

import controller.base.AdminBaseController;
import dao.CategoryDAO;
import dao.base.Paginate;
import entity.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/admin/category/index")
public class IndexController extends AdminBaseController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.authentication(req, resp);
        Map<String, String> param = this.param(req);
        int page = Integer.parseInt(param.getOrDefault("page", "1"));

        Paginate<Category> paginate = CategoryDAO.getInstance().paginate(page);
        HashMap<String, Object> values = new HashMap<>();
        values.put("paginate", paginate);
        this.fetch(req, resp, values);
    }
}
