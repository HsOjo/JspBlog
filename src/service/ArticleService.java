package service;

import dao.ArticleDAO;
import entity.Article;
import service.base.BaseService;

public class ArticleService extends BaseService<ArticleDAO, Article> {
    public static ArticleService getInstance() {
        ArticleService service = new ArticleService();
        service.setDao(ArticleDAO.getInstance());
        return service;
    }
}
