package com.base.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.base.dao.LabelDao;
import com.base.pojo.Label;
import com.base.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;
import java.util.List;

/**
 * @author 谭嘉乐
 */
@Service
public class LabelServiceImpl implements LabelService {
    @Autowired
    LabelDao labelDao;
    @Autowired
    IdWorker idWorker;
    /**
     * 查询所有标签
     * @return
     */
    @Override
    public List<Label> findAll() {
        return labelDao.selectList(null);
    }

    @Override
    public Label findById(String id) {
        return labelDao.selectById(id);
    }

    @Override
    public void add(Label label) {
        label.setId(idWorker.nextId()+"");
        labelDao.insert(label);
    }

    @Override
    public void update(Label label) {
        labelDao.updateById(label);
    }

    @Override
    public void deleteById(String id) {
        labelDao.deleteById(id);
    }

    @Override
    public List<Label> search(Label label) {
        QueryWrapper<Label> wrapper = conditionsAll(label);
        return labelDao.selectList(wrapper);
    }

    @Override
    public Page<Label> pageSearch(Label label, int page, int size) {
        QueryWrapper<Label> wrapper = conditionsAll(label);
        Page<Label> labelPage = new Page<>(page, size);
        return labelDao.selectPage(labelPage, wrapper);
    }
    private QueryWrapper<Label> conditionsAll(Label label) {
        QueryWrapper<Label> wrapper = new QueryWrapper<>();
        if (label.getLabelName()!=null && !"".equals(label.getLabelName())) {
            wrapper = wrapper.like("label_name", label.getLabelName());
        }
        if (label.getState()!=null && !"".equals(label.getState())) {
            wrapper = wrapper.eq("state", label.getState());
        }
        if (label.getRecommend()!=null && !"".equals(label.getRecommend())) {
            wrapper = wrapper.eq("recommend", label.getRecommend());
        }
        return wrapper;
    }
}
