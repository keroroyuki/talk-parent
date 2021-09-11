package com.qa.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qa.pojo.Problem;

import java.util.List;

/**
 * @author 谭嘉乐
 */
public interface ProblemService {
    /**
     * 查询全部列表
     * @return
     */
    List<Problem> findAll();
    /**
     * 分页条件查询
     * @param problem
     * @param page
     * @param size
     * @return
     */
    Page<Problem> pageSearch(Problem problem, int page, int size);

    /**
     * 条件查询
     * @param problem
     * @return
     */
    List<Problem>search(Problem problem);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Problem findById(String id);

    /**
     * 添加
     * @param problem
     */
    void add(Problem problem);

    /**
     * 更新
     * @param problem
     */
    void update(Problem problem);

    /**
     * 删除
     * @param id
     */
    void deleteById(String id);

    /**
     * 根据标签ID查询最新问题列表
     * @param labelid
     * @param page
     * @param size
     * @return
     */
    Page<Problem>newQa(String labelid, int page, int size);

    /**
     * 根据标签ID查询热门问题列表
     * @param labelid
     * @param page
     * @param size
     * @return
     */
    Page<Problem>hotQaList(String labelid, int page, int size);

    /**
     * 根据标签ID查询等待回答列表
     * @param labelid
     * @param page
     * @param size
     * @return
     */
    Page<Problem>waitQaList(String labelid, int page, int size);
}
