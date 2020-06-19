package controller.article;

import controller.base.HomeBaseController;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/article/view")
public class ViewController extends HomeBaseController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        this.fetch(req, resp);
    }
}
