package controller.index;

import controller.base.BaseController;
import dao.UserDAO;
import dao.base.condition.Column;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("")
public class IndexController extends BaseController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        HashMap<String, Object> values = new HashMap<>();
        values.put("test", "zxczxczxczxczxc");
        this.fetch(req, resp, values);
    }
}
