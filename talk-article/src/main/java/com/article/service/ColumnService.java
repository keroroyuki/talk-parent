package com.article.service;

import com.article.pojo.Column;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * @author 谭嘉乐
 */
public interface ColumnService {
    /**
     * 查询全部列表
     * @return
     */
    List<Column> findAll();

    /**
     * 分页条件查询
     * @param column
     * @param page
     * @param size
     * @return
     */
    Page<Column> pageSearch(Column column, int page, int size);

    /**
     * 条件查询
     * @param column
     * @return
     */
    List<Column>search(Column column);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Column findById(String id);

    /**
     * 添加
     * @param column
     */
    void add(Column column);

    /**
     * 更新
     * @param column
     */
    void update(Column column);

    /**
     * 删除
     * @param id
     */
    void deleteById(String id);
}
