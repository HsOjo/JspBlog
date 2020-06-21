package utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

public class SessionUtils {
    HttpServletRequest req;
    HttpSession session;

    public SessionUtils(HttpServletRequest req) {
        this.req = req;
        this.session = req.getSession();
    }

    public static SessionUtils getInstance(HttpServletRequest req) {
        return new SessionUtils(req);
    }

    public List<String> getNames() {
        ArrayList<String> names_list = new ArrayList<>();
        Enumeration<String> names = this.session.getAttributeNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            names_list.add(name);
        }

        return names_list;
    }

    public Map<String, Object> get() {
        HashMap<String, Object> items = new HashMap<>();
        for (String name : this.getNames()) {
            items.put(name, this.session.getAttribute(name));
        }
        return items;
    }

    public Object get(String name, Object default_) {
        Object object = this.session.getAttribute(name);
        if (object == null)
            object = default_;
        return object;
    }

    public Object get(String name) {
        return this.get(name, null);
    }

    public void set(Map<String, Object> items) {
        for (Map.Entry<String, Object> entry : items.entrySet()) {
            this.session.setAttribute(entry.getKey(), entry.getValue());
        }
    }

    public void set(String name, Object object) {
        this.session.setAttribute(name, object);
    }

    public void remove(String name) {
        this.session.removeAttribute(name);
    }

    public void clear() {
        for (String name : this.getNames()) {
            this.remove(name);
        }
    }
}
