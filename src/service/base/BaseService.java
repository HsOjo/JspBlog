package service.base;

import dao.base.BaseDAO;

import java.util.List;

public abstract class BaseService<DAO extends BaseDAO<Entity>, Entity> {
    protected DAO dao;

    public DAO getDao() {
        return this.dao;
    }

    public void setDao(DAO dao) {
        this.dao = dao;
    }

    public Paginate<Entity> paginate(int per_page, int page) {
        int num = (int) this.dao.count();
        int max_page = num / per_page;
        if (num % per_page != 0)
            max_page++;
        List<Entity> items = this.dao.offset((page - 1) * per_page).limit(per_page).select();
        return new Paginate<>(page, max_page, per_page, items);
    }

    public Paginate<Entity> paginate(int page) {
        return this.paginate(20, page);
    }
}
