package com.base.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.base.pojo.Label;

import java.util.List;

/**
 * @author 谭嘉乐
 */
public interface LabelService {
    /**
     * 查询所有标签
     * @return
     */
    List<Label> findAll();

    /**
     * 根据id查询标签
     * @param id
     * @return
     */
    Label findById(String id);

    /**
     * 添加标签
     * @param label
     */
    void add(Label label);

    /**
     * 更新标签
     * @param label
     */
    void update(Label label);

    /**
     * 删除标签
     * @param id
     */
    void deleteById(String id);

    /**
     * 不分页的条件查询
     * @param label
     * @return
     */
    List<Label> search(Label label);

    /**
     * 分页的标签条件查询
     * @param label
     * @param page
     * @param size
     * @return
     */
    Page<Label> pageSearch(Label label, int page, int size);
}
