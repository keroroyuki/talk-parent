package com.qa.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qa.pojo.Problem;
import com.qa.service.ProblemService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 谭嘉乐
 */
@Api(tags = {"问答"})
@RestController
@RequestMapping("/problem")
public class ProblemController {
    @Autowired
    private ProblemService problemService;

    @ApiOperation(value = "问答信息", response = Problem.class, notes = "查询全部问答信息")
    @GetMapping()
    public Result findAll() {
        List<Problem> list = problemService.findAll();
        return new Result(true, StatusCode.OK, "查询成功", list);
    }

    @ApiOperation(value = "问答信息筛选（分页）", response = Problem.class, notes = "分页条件查询问答信息")
    @PostMapping("/search/{page}/{size}")
    public Result pageSearch(@RequestBody Problem problem, @PathVariable("page") int page, @PathVariable("size") int size) {
        Page pageData = problemService.pageSearch(problem, page, size);
        PageResult<Problem> pageResult = new PageResult<>(pageData.getTotal(),pageData.getRecords());
        return new Result(true, StatusCode.OK, "分页条件查询成功", pageResult);
    }

    @ApiOperation(value = "问答信息筛选", response = Problem.class, notes = "条件查询问答信息")
    @PostMapping("/search")
    public Result search(@RequestBody Problem problem) {
        List<Problem> list = problemService.search(problem);
        return new Result(true, StatusCode.OK, "条件查询成功", list);
    }

    @ApiOperation(value = "单一问答信息获取", response = Problem.class, notes = "id查询问答信息")
    @GetMapping("{id}")
    public Result findById(@PathVariable("id") String id) {
        Problem problem = problemService.findById(id);
        return new Result(true, StatusCode.OK, "id查询成功", problem);
    }

    @ApiOperation(value = "添加问答信息", response = Problem.class, notes = "添加问答信息")
    @PostMapping()
    public Result add(@RequestBody Problem problem) {
        problemService.add(problem);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    @ApiOperation(value = "修改问答信息", response = Problem.class, notes = "修改问答信息")
    @PutMapping("{id}")
    public Result update(@PathVariable("id") String id, @RequestBody Problem problem) {
        problem.setId(id);
        problemService.update(problem);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    @ApiOperation(value = "删除问答信息", response = Problem.class, notes = "删除问答信息")
    @DeleteMapping("{id}")
    public Result deleteById(@PathVariable("id") String id) {
        problemService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    @ApiOperation(value = "最新回答列表", response = Problem.class, notes = "id查询最新回答列表")
    @GetMapping("/newQa/{labelid}/{page}/{size}")
    public Result newQa(@PathVariable("labelid") String labelid, @PathVariable("page") int page, @PathVariable("size") int size) {
        Page pageData = problemService.newQa(labelid, page, size);
        PageResult<Problem> pageResult = new PageResult<>(pageData.getTotal(),pageData.getRecords());
        return new Result(true, StatusCode.OK, "id分页查询最新回答列表成功", pageResult);
    }

    @ApiOperation(value = "热门回答列表", response = Problem.class, notes = "id查询热门回答列表")
    @GetMapping("/hotQa/{labelid}/{page}/{size}")
    public Result hotQa(@PathVariable("labelid") String labelid, @PathVariable("page") int page, @PathVariable("size") int size) {
        Page pageData = problemService.hotQaList(labelid, page, size);
        PageResult<Problem> pageResult = new PageResult<>(pageData.getTotal(),pageData.getRecords());
        return new Result(true, StatusCode.OK, "id分页查询热门回答列表成功", pageResult);
    }

    @ApiOperation(value = "等待回答列表", response = Problem.class, notes = "id查询等待回答列表")
    @GetMapping("/waitQa/{labelid}/{page}/{size}")
    public Result waitQa(@PathVariable("labelid") String labelid, @PathVariable("page") int page, @PathVariable("size") int size) {
        Page pageData = problemService.waitQaList(labelid, page, size);
        PageResult<Problem> pageResult = new PageResult<>(pageData.getTotal(),pageData.getRecords());
        return new Result(true, StatusCode.OK, "id分页查询等待回答列表成功", pageResult);
    }
}
