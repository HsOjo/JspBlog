package dao;

import dao.base.BaseDAO;
import entity.Category;

import java.util.HashMap;
import java.util.Map;

public class CategoryDAO extends BaseDAO<Category> {
    public static CategoryDAO getInstance() {
        return new CategoryDAO();
    }

    @Override
    protected Category parseEntity(Map<String, Object> map) {
        return new Category(
                (int) map.get("id"),
                (String) map.get("name")
        );
    }


    @Override
    public String[] fields() {
        return new String[]{"id", "name"};
    }
}
