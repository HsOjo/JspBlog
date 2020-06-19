package controller.base;

import utils.CookieUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class BaseController extends HttpServlet {
    private static final String BLOG_MSG = "_blog_msg";

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

    public void fetch(HttpServletRequest req, HttpServletResponse resp, String path, HashMap<String, Object> values) {
        if (values != null)
            for (Map.Entry<String, Object> entry : values.entrySet())
                req.setAttribute(entry.getKey(), entry.getValue());

        System.out.println(String.format("fetch: %s, %s", path, values));
        RequestDispatcher rd = req.getRequestDispatcher(path);
        try {
            rd.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public void fetch(HttpServletRequest req, HttpServletResponse resp, HashMap<String, Object> values) {
        this.fetch(req, resp, this.getTemplatePath(), values);
    }

    public void fetch(HttpServletRequest req, HttpServletResponse resp, String path) {
        this.fetch(req, resp, path, null);
    }

    public void fetch(HttpServletRequest req, HttpServletResponse resp) {
        this.fetch(req, resp, this.getTemplatePath(), null);
    }

    public void redirect(HttpServletRequest req, HttpServletResponse resp, String url) {
        resp.setStatus(resp.SC_MOVED_TEMPORARILY);
        if (!url.contains("://"))
            url = String.format("%s/%s", req.getContextPath(), url);
        resp.setHeader("Location", url);
    }

    public Map<String, String> param(HttpServletRequest req) {
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        HashMap<String, String> params = new HashMap<>();
        Enumeration<String> names = req.getParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            params.put(name, req.getParameter(name));
        }
        return params;
    }

    public Map<String, Object> paramAsObject(HttpServletRequest req) {
        HashMap<String, Object> param = new HashMap<>();
        for (Map.Entry<String, String> entry : this.param(req).entrySet()) {
            param.put(entry.getKey(), entry.getValue());
        }
        return param;
    }

    public void message(HttpServletRequest req, HttpServletResponse resp, String msg) {
        System.out.println(String.format("message: %s", msg));
        CookieUtils.getInstance(req, resp).set(BLOG_MSG, msg);
    }
}
