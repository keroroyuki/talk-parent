package com.article.dao;

import com.article.pojo.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 谭嘉乐
 */
@Mapper
@Repository
public interface ArticleDao extends BaseMapper<Article> {
    /**
     * 点赞
     * @param id
     * @return
     */
    int thumbUp(String id);

}
