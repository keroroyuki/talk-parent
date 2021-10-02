package com.article.service;

import com.article.pojo.Article;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * @author 谭嘉乐
 */
public interface ArticleService {
    /**
     * 查询全部列表
     * @return
     */
    List<Article>findAll();

    /**
     * 分页条件查询
     * @param article
     * @param page
     * @param size
     * @return
     */
    Page<Article>pageSearch(Article article, int page, int size);

    /**
     * 条件查询
     * @param article
     * @return
     */
    List<Article>search(Article article);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Article findById(String id);

    /**
     * 添加
     * @param article
     */
    void add(Article article);

    /**
     * 更新
     * @param article
     */
    void update(Article article);

    /**
     * 删除
     * @param id
     */
    void deleteById(String id);

    /**
     * 审核
     * @param id
     * @return
     */
    int examine(String id);

    /**
     * 点赞
     * @param id
     * @return
     */
    int thumbUp(String id);


}
