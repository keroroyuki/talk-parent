package com.recruit.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.recruit.pojo.Enterprise;

import java.util.List;

/**
 * @author 谭嘉乐
 */
public interface EnterpriseService {
    /**
     * 查询全部列表
     * @return
     */
    List<Enterprise>findAll();
    /**
     * 分页条件查询
     * @param enterprise
     * @param page
     * @param size
     * @return
     */
    Page<Enterprise>pageSearch(Enterprise enterprise,int page,int size);

    /**
     * 条件查询
     * @param enterprise
     * @return
     */
    List<Enterprise>search(Enterprise enterprise);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Enterprise findById(String id);

    /**
     * 添加
     * @param enterprise
     */
    void add(Enterprise enterprise);

    /**
     * 更新
     * @param enterprise
     */
    void update(Enterprise enterprise);

    /**
     * 删除
     * @param id
     */
    void deleteById(String id);

    /**
     * 热门企业查询
     * @return
     */
    List<Enterprise> hotList();
}
