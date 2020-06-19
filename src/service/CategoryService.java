package service;

import dao.CategoryDAO;
import dao.base.condition.Column;
import entity.Category;

import java.util.HashMap;

public class CategoryService {
    private final CategoryDAO dao;
    private HashMap<Integer, Category> category_buffer;

    public CategoryService() {
        this.dao = new CategoryDAO();
    }

    public static CategoryService getInstance() {
        return new CategoryService();
    }

    public Category getCategoryById(int category_id) {
        if (this.category_buffer == null)
            this.category_buffer = new HashMap<>();
        Category category;
        if (category_buffer.containsKey(category_id)) {
            category = category_buffer.get(category_id);
        } else {
            category = this.dao.where(Column.check("id", "=", category_id)).find();
            this.category_buffer.put(category_id, category);
        }
        return category;
    }
}
