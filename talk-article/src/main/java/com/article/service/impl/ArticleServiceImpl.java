package com.article.service.impl;

import com.article.dao.ArticleDao;
import com.article.pojo.Article;
import com.article.service.ArticleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import java.util.List;

/**
 * @author 谭嘉乐
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private IdWorker idWorker;

    @Override
    public List<Article> findAll() {
        return articleDao.selectList(null);
    }

    @Override
    public Page<Article> pageSearch(Article article, int page, int size) {
        QueryWrapper<Article> wrapper = conditionsAll(article);
        Page<Article> articlePage = new Page<>(page, size);
        return articleDao.selectPage(articlePage,wrapper);
    }

    @Override
    public List<Article> search(Article article) {
        QueryWrapper<Article> wrapper = conditionsAll(article);
        return articleDao.selectList(wrapper);
    }

    @Override
    public Article findById(String id) {
        return articleDao.selectById(id);
    }

    @Override
    public void add(Article article) {
        article.setId(idWorker.nextId()+"");
        articleDao.insert(article);
    }

    @Override
    public void update(Article article) {
        articleDao.updateById(article);
    }

    @Override
    public void deleteById(String id) {
        articleDao.deleteById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int examine(String id) {
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        Article article = new Article();
        article.setState("1");
        wrapper = wrapper.eq("id", id);
        return articleDao.update(article,wrapper);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int thumbUp(String id) {
        return articleDao.thumbUp(id);
    }

    private QueryWrapper<Article> conditionsAll(Article article) {
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        if (article.getTitle()!=null && !"".equals(article.getTitle())) {
            wrapper = wrapper.like("title", article.getTitle());
        }
        if (article.getContent()!=null && !"".equals(article.getContent())) {
            wrapper = wrapper.like("content", article.getContent());
        }
        if (article.getImage()!=null && !"".equals(article.getImage())) {
            wrapper = wrapper.like("image", article.getImage());
        }
        if (article.getUrl()!=null && !"".equals(article.getUrl())) {
            wrapper = wrapper.like("url", article.getUrl());
        }
        if (article.getIspublic()!=null && !"".equals(article.getIspublic())) {
            wrapper = wrapper.eq("ispublic", article.getIspublic());
        }
        if (article.getIstop()!=null && !"".equals(article.getIstop())) {
            wrapper = wrapper.eq("istop", article.getIstop());
        }
        if (article.getState()!=null && !"".equals(article.getState())) {
            wrapper = wrapper.eq("state", article.getState());
        }
        return wrapper;
    }
}
