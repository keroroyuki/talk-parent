package com.qa.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qa.pojo.Problem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 谭嘉乐
 */
@Mapper
@Repository
public interface ProblemDao extends BaseMapper<Problem> {
    /**
     * 根据标签ID查询最新问题列表
     * @param problemPage
     * @param labelid
     * @return
     */
    Page<Problem>newQa(Page<Problem> problemPage, String labelid);

    /**
     * 根据标签ID查询热门问题列表
     * @param problemPage
     * @param labelid
     * @return
     */
    Page<Problem>hotQaList(Page<Problem> problemPage, String labelid);

    /**
     * 根据标签ID查询等待回答列表
     * @param problemPage
     * @param labelid
     * @return
     */
    Page<Problem>waitQaList(Page<Problem> problemPage, String labelid);
}
