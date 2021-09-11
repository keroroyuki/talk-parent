package com.qa.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qa.dao.ProblemDao;
import com.qa.pojo.Problem;
import com.qa.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

/**
 * @author 谭嘉乐
 */
@Service
public class ProblemServiceImpl implements ProblemService {
    @Autowired
    private ProblemDao problemDao;
    @Autowired
    private IdWorker idWorker;
    @Override
    public List<Problem> findAll() {
        return problemDao.selectList(null);
    }

    @Override
    public Page<Problem> pageSearch(Problem problem, int page, int size) {
        QueryWrapper<Problem> wrapper = conditionsAll(problem);
        Page<Problem> problemPage = new Page<>(page,size);
        return problemDao.selectPage(problemPage, wrapper);
    }



    @Override
    public List<Problem> search(Problem problem) {
        QueryWrapper<Problem> wrapper = conditionsAll(problem);
        return problemDao.selectList(wrapper);
    }

    @Override
    public Problem findById(String id) {
        return problemDao.selectById(id);
    }

    @Override
    public void add(Problem problem) {
        problem.setId(idWorker.nextId()+"");
        problemDao.insert(problem);
    }

    @Override
    public void update(Problem problem) {
        problemDao.updateById(problem);
    }

    @Override
    public void deleteById(String id) {
        problemDao.deleteById(id);
    }

    @Override
    public Page<Problem> newQa(String labelid, int page, int size) {
        Page<Problem> problemPage = new Page<>(page,size);
        return problemDao.newQa(problemPage, labelid);
    }

    @Override
    public Page<Problem> hotQaList(String labelid, int page, int size) {
        Page<Problem> problemPage = new Page<>(page,size);
        return problemDao.hotQaList(problemPage, labelid);
    }

    @Override
    public Page<Problem> waitQaList(String labelid, int page, int size) {
        Page<Problem> problemPage = new Page<>(page,size);
        return problemDao.waitQaList(problemPage,labelid);
    }

    private QueryWrapper<Problem> conditionsAll(Problem problem) {
        QueryWrapper<Problem> wrapper = new QueryWrapper<>();
        if (problem.getTitle()!=null && !"".equals(problem.getTitle())) {
            wrapper = wrapper.like("title", problem.getTitle());
        }
        if (problem.getNickname()!=null && !"".equals(problem.getNickname())) {
            wrapper = wrapper.like("nickname", problem.getNickname());
        }
        if (problem.getSolve()!=null && !"".equals(problem.getSolve())) {
            wrapper = wrapper.eq("solve", problem.getSolve());
        }
        if (problem.getContent()!=null && !"".equals(problem.getContent())) {
            wrapper = wrapper.like("content", problem.getContent());
        }
        return wrapper;
    }
}
