package com.recruit.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.recruit.pojo.Enterprise;
import com.recruit.pojo.Recruit;

import java.util.List;

/**
 * @author 谭嘉乐
 */
public interface RecruitService {
    /**
     * 查询全部列表
     * @return
     */
    List<Recruit> findAll();
    /**
     * 分页条件查询
     * @param recruit
     * @param page
     * @param size
     * @return
     */
    Page<Recruit> pageSearch(Recruit recruit, int page, int size);

    /**
     * 条件查询
     * @param recruit
     * @return
     */
    List<Recruit>search(Recruit recruit);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Recruit findById(String id);

    /**
     * 添加
     * @param recruit
     */
    void add(Recruit recruit);

    /**
     * 更新
     * @param recruit
     */
    void update(Recruit recruit);

    /**
     * 删除
     * @param id
     */
    void deleteById(String id);

    /**
     * 查询最新职位列表(按创建日期降序排序)
     * @return
     */
    List<Recruit> recommend();

    /**
     * 查询最新职位
     * @return
     */
    List<Recruit> newList();
}
