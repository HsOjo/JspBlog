package controller.base;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BaseController extends HttpServlet {
    public String getServletPath() {
        WebServlet annotation = this.getClass().getAnnotation(WebServlet.class);
        String[] values = annotation.value();
        return values.length > 0 ? values[0] : "";
    }

    public String getTemplatePath() {
        String path = this.getServletPath();
        String[] item = path.split("/");
        String module = item.length > 1 ? item[1] : "index";
        String action = item.length > 2 ? item[2] : "index";
        return String.format("/templates/%s/%s.jsp", module, action);
    }

    public void fetch(HttpServletRequest req, HttpServletResponse resp, String path, HashMap<String, Object> values) throws ServletException, IOException {
        if (values != null)
            for (Map.Entry<String, Object> entry : values.entrySet())
                req.setAttribute(entry.getKey(), entry.getValue());

        System.out.println(String.format("fetch: %s, %s", path, values));
        RequestDispatcher rd = req.getRequestDispatcher(path);
        rd.forward(req, resp);
    }

    public void fetch(HttpServletRequest req, HttpServletResponse resp, HashMap<String, Object> values) throws ServletException, IOException {
        this.fetch(req, resp, this.getTemplatePath(), values);
    }

    public void fetch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.fetch(req, resp, this.getTemplatePath(), null);
    }
}
