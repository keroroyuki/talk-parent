package com.article.service.impl;

import com.article.dao.ColumnDao;
import com.article.pojo.Column;
import com.article.service.ColumnService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

/**
 * @author 谭嘉乐
 */
@Service
public class ColumnServiceImpl implements ColumnService {
    @Autowired
    private ColumnDao columnDao;
    
    @Autowired
    private IdWorker idWorker;

    @Override
    public List<Column> findAll() {
        return columnDao.selectList(null);
    }

    @Override
    public Page<Column> pageSearch(Column column, int page, int size) {
        QueryWrapper<Column> wrapper = conditionsAll(column);
        Page<Column> columnPage = new Page<>(page, size);
        return columnDao.selectPage(columnPage,wrapper);
    }

    @Override
    public List<Column> search(Column column) {
        QueryWrapper<Column> wrapper = conditionsAll(column);
        return columnDao.selectList(wrapper);
    }

    @Override
    public Column findById(String id) {
        return columnDao.selectById(id);
    }

    @Override
    public void add(Column column) {
        column.setId(idWorker.nextId()+"");
        columnDao.insert(column);
    }

    @Override
    public void update(Column column) {
        columnDao.updateById(column);
    }

    @Override
    public void deleteById(String id) {
        columnDao.deleteById(id);
    }

    private QueryWrapper<Column> conditionsAll(Column column) {
        QueryWrapper<Column> wrapper = new QueryWrapper<>();
        if (column.getName()!=null && !"".equals(column.getName())) {
            wrapper = wrapper.like("name", column.getName());
        }
        if (column.getSummary()!=null && !"".equals(column.getSummary())) {
            wrapper = wrapper.like("summary", column.getSummary());
        }
        if (column.getState()!=null && !"".equals(column.getState())) {
            wrapper = wrapper.eq("state", column.getState());
        }
        return wrapper;
    }
}
