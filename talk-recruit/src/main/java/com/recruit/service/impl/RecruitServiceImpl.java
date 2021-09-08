package com.recruit.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.recruit.dao.RecruitDao;
import com.recruit.pojo.Recruit;
import com.recruit.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

/**
 * @author 谭嘉乐
 */
@Service
public class RecruitServiceImpl implements RecruitService {
    @Autowired
    private RecruitDao recruitDao;
    @Autowired
    private IdWorker idWorker;

    @Override
    public List<Recruit> findAll() {
        return recruitDao.selectList(null);
    }

    @Override
    public Page<Recruit> pageSearch(Recruit recruit, int page, int size) {
        QueryWrapper<Recruit> wrapper = conditionsAll(recruit);
        Page<Recruit> recruitPage = new Page<>(page,size);
        return recruitDao.selectPage(recruitPage, wrapper);
    }

    @Override
    public List<Recruit> search(Recruit recruit) {
        QueryWrapper<Recruit> wrapper = conditionsAll(recruit);
        return recruitDao.selectList(wrapper);
    }

    @Override
    public Recruit findById(String id) {
        return recruitDao.selectById(id);
    }

    @Override
    public void add(Recruit recruit) {
        recruit.setId(idWorker.nextId()+"");
        recruitDao.insert(recruit);
    }

    @Override
    public void update(Recruit recruit) {
        recruitDao.updateById(recruit);
    }

    @Override
    public void deleteById(String id) {
        recruitDao.deleteById(id);
    }

    @Override
    public List<Recruit> recommend() {
        QueryWrapper<Recruit> wrapper = new QueryWrapper<>();
        wrapper.eq("state", "2").orderByDesc("createtime").last("limit 4");
        return recruitDao.selectList(wrapper);
    }

    @Override
    public List<Recruit> newList() {
        QueryWrapper<Recruit> wrapper = new QueryWrapper<>();
        wrapper.ne("state", "0").orderByDesc("createtime").last("limit 12");
        return recruitDao.selectList(wrapper);
    }

    private QueryWrapper<Recruit> conditionsAll(Recruit recruit){
        QueryWrapper<Recruit> wrapper = new QueryWrapper<>();
        if (recruit.getJobname()!=null && !"".equals(recruit.getJobname())) {
            wrapper = wrapper.like("jobname", recruit.getJobname());
        }
        if (recruit.getSalary()!=null && !"".equals(recruit.getSalary())) {
            wrapper = wrapper.like("salary", recruit.getSalary());
        }
        if (recruit.getCondition()!=null && !"".equals(recruit.getCondition())) {
            wrapper = wrapper.like("condition", recruit.getCondition());
        }
        if (recruit.getEducation()!=null && !"".equals(recruit.getEducation())) {
            wrapper = wrapper.like("education", recruit.getEducation());
        }
        if (recruit.getType()!=null && !"".equals(recruit.getType())) {
            wrapper = wrapper.eq("type", recruit.getType());
        }
        if (recruit.getAddress()!=null && !"".equals(recruit.getAddress())) {
            wrapper = wrapper.like("address", recruit.getAddress());
        }
        if (recruit.getEid()!=null && !"".equals(recruit.getEid())) {
            wrapper = wrapper.eq("eid", recruit.getEid());
        }
        if (recruit.getState()!=null && !"".equals(recruit.getState())) {
            wrapper = wrapper.eq("state", recruit.getState());
        }
        if (recruit.getUrl()!=null && !"".equals(recruit.getUrl())) {
            wrapper = wrapper.like("url", recruit.getUrl());
        }
        if (recruit.getLabel()!=null && !"".equals(recruit.getLabel())) {
            wrapper = wrapper.like("label", recruit.getLabel());
        }
        if (recruit.getLabel()!=null && !"".equals(recruit.getLabel())) {
            wrapper = wrapper.like("label", recruit.getLabel());
        }
        if (recruit.getContent1()!=null && !"".equals(recruit.getContent1())) {
            wrapper = wrapper.like("content1", recruit.getContent1());
        }
        if (recruit.getContent2()!=null && !"".equals(recruit.getContent2())) {
            wrapper = wrapper.like("content2", recruit.getContent2());
        }
        return wrapper;
    }
}
