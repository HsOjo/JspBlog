package utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CookieUtils {
    HttpServletRequest req;
    HttpServletResponse resp;
    Cookie[] cookies;
    int max_age;

    public CookieUtils(HttpServletRequest req, HttpServletResponse resp) {
        this.req = req;
        this.resp = resp;
        this.cookies = req.getCookies();
        this.max_age = 86400;
    }

    public static CookieUtils getInstance(HttpServletRequest req, HttpServletResponse resp) {
        return new CookieUtils(req, resp);
    }

    public void setMaxAge(int age) {
        this.max_age = age;
    }

    public List<String> getNames() {
        ArrayList<String> names = new ArrayList<>();
        for (Cookie cookie : this.cookies) {
            String name = cookie.getName();
            names.add(name);
        }
        return names;
    }

    public Map<String, String> get() {
        HashMap<String, String> items = new HashMap<>();
        for (Cookie cookie : this.cookies) {
            items.put(cookie.getName(), cookie.getValue());
        }
        return items;
    }

    public Cookie getRaw(String name) {
        for (Cookie cookie : this.cookies) {
            if (cookie.getName().equals(name))
                return cookie;
        }
        return null;
    }

    public String get(String name, String default_) {
        String str = default_;
        Cookie cookie = this.getRaw(name);
        if (cookie != null)
            str = cookie.getValue();
        return str;
    }

    public String get(String name) {
        return this.get(name, "");
    }

    public void set(String name, String value, int max_age) {
        Cookie cookie = this.getRaw(name);
        if (cookie == null)
            cookie = new Cookie(name, value);
        else
            cookie.setValue(value);
        cookie.setMaxAge(max_age);
        cookie.setPath("/");
        this.resp.addCookie(cookie);
    }

    public void set(String name, String value) {
        this.set(name, value, this.max_age);
    }

    public void remove(String name) {
        this.set(name, "", 0);
    }

    public void clear() {
        for (Cookie cookie : this.cookies) {
            cookie.setValue("");
            cookie.setMaxAge(0);
            this.resp.addCookie(cookie);
        }
    }
}
