package service.base;

import dao.base.BaseDAO;
import dao.base.Paginate;

import java.util.List;

public abstract class BaseService<DAO extends BaseDAO<Entity>, Entity> {
    protected DAO dao;

    public DAO getDao() {
        return this.dao;
    }

    public void setDao(DAO dao) {
        this.dao = dao;
    }
}
