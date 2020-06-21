package controller.category;

import controller.base.AdminBaseController;
import dao.CategoryDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/admin/category/add")
public class AddController extends AdminBaseController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!this.authentication(req, resp)) return;
        this.fetch(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!this.authentication(req, resp)) return;
        Map<String, String> param = this.param(req);
        HashMap<String, Object> data = new HashMap<>();
        data.put("name", param.get("name"));
        int id = CategoryDAO.getInstance().data(data).insert();
        if (id > 0) {
            this.message(req, resp, "添加成功");
        } else {
            this.message(req, resp, "添加失败");
        }
        this.fetch(req, resp);
    }
}
