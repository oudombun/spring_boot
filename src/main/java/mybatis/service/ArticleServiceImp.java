package mybatis.service;

import mybatis.repository.ArticleRepository.ArticleRepository;
import mybatis.repository.model.Article;
import mybatis.repository.model.ArticleFilter;
import mybatis.repository.model.Category;
import mybatis.service.ArticleService.ArticleService;
import mybatis.utility.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Primary
@Service
public class ArticleServiceImp implements ArticleService {
    @Autowired
    ArticleRepository articleRepository;
    @Override
    public boolean add(Article article) {
        return articleRepository.add(article);
    }

    @Override
    public boolean update(Article article) {
       return articleRepository.update(article);
    }

    @Override
    public boolean delete(int id) {
        return articleRepository.delete(id);
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public Article findById(int id) {
        return articleRepository.findById(id);
    }

    @Override
    public int getLastId() {
        return articleRepository.getLastId();
    }

    @Override
    public List<Article> findAllFilter(ArticleFilter articleFilter, Paging paging) {
        paging.setTotalCount(articleRepository.countAllArticles(articleFilter));
        return articleRepository.findAllFilter(articleFilter,paging);
    }

    @Override
    public Integer countAllArticles(ArticleFilter articleFilter) {
        return articleRepository.countAllArticles(articleFilter);
    }
}
