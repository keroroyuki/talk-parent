package com.recruit.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.recruit.dao.EnterpriseDao;
import com.recruit.pojo.Enterprise;
import com.recruit.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

/**
 * @author 谭嘉乐
 */
@Service
public class EnterpriseServiceImpl implements EnterpriseService {
    @Autowired
    private EnterpriseDao enterpriseDao;
    @Autowired
    private IdWorker idWorker;

    @Override
    public List<Enterprise> findAll() {
        return enterpriseDao.selectList(null);
    }

    @Override
    public Page<Enterprise> pageSearch(Enterprise enterprise, int page, int size) {
        QueryWrapper<Enterprise> wrapper = conditionsAll(enterprise);
        Page<Enterprise> enterprisePage = new Page<>(page,size);
        return enterpriseDao.selectPage(enterprisePage, wrapper);
    }

    @Override
    public List<Enterprise> search(Enterprise enterprise) {
        QueryWrapper<Enterprise> wrapper = conditionsAll(enterprise);
        return enterpriseDao.selectList(wrapper);
    }

    @Override
    public Enterprise findById(String id) {
        return enterpriseDao.selectById(id);
    }

    @Override
    public void add(Enterprise enterprise) {
        enterprise.setId(idWorker.nextId()+"");
        enterpriseDao.insert(enterprise);
    }

    @Override
    public void update(Enterprise enterprise) {
        enterpriseDao.updateById(enterprise);
    }

    @Override
    public void deleteById(String id) {
        enterpriseDao.deleteById(id);
    }

    @Override
    public List<Enterprise> hotList() {
        QueryWrapper<Enterprise> wrapper = new QueryWrapper<>();
        wrapper.eq("ishot","1");
        return enterpriseDao.selectList(wrapper);
    }

    /**
     * 封装查找条件
     * @param enterprise
     * @return
     */
    private QueryWrapper<Enterprise> conditionsAll(Enterprise enterprise){
        QueryWrapper<Enterprise> wrapper = new QueryWrapper<>();
        if (enterprise.getName()!=null && !"".equals(enterprise.getName())) {
            wrapper = wrapper.like("name", enterprise.getName());
        }
        if (enterprise.getSummary()!=null && !"".equals(enterprise.getSummary())){
            wrapper = wrapper.like("summary", enterprise.getSummary());
        }
        if (enterprise.getAddress()!=null && !"".equals(enterprise.getAddress())) {
            wrapper = wrapper.like("address", enterprise.getAddress());
        }
        if (enterprise.getLabels()!=null && !"".equals(enterprise.getLabels())) {
            wrapper = wrapper.like("labels", enterprise.getLabels());
        }
        if (enterprise.getUrl()!=null && !"".equals(enterprise.getUrl())) {
            wrapper = wrapper.like("url", enterprise.getUrl());
        }
        if (enterprise.getLogo()!=null && !"".equals(enterprise.getLogo())) {
            wrapper = wrapper.like("logo", enterprise.getLogo());
        }
        if (enterprise.getIshot()!=null && !"".equals(enterprise.getIshot())) {
            wrapper = wrapper.eq("ishot", enterprise.getIshot());
        }
        if (enterprise.getCoordinate()!=null && !"".equals(enterprise.getCoordinate())) {
            wrapper = wrapper.eq("coordinate", enterprise.getCoordinate());
        }
        return wrapper;
    }
}
