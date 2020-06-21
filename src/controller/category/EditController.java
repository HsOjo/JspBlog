package controller.category;

import controller.base.AdminBaseController;
import dao.CategoryDAO;
import dao.UserDAO;
import dao.base.condition.Column;
import entity.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/admin/category/edit")
public class EditController extends AdminBaseController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!this.authentication(req, resp)) return;
        Map<String, String> param = this.param(req);
        int id = Integer.parseInt(param.get("id"));
        Category category = CategoryDAO.getInstance().where(Column.check("id", "=", id)).find();
        HashMap<String, Object> values = new HashMap<>();
        values.put("category", category);
        this.fetch(req, resp, values);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!this.authentication(req, resp)) return;
        Map<String, Object> param = this.paramAsObject(req);
        int id = Integer.parseInt((String) param.get("id"));
        int result = UserDAO.getInstance().data(param).where(Column.check("id", "=", id)).update();
        if (result > 0) {
            this.message(req, resp, "编辑成功");
        } else {
            this.message(req, resp, "编辑失败");
        }
        this.redirect(req, resp, "admin/category/index");
    }
}
