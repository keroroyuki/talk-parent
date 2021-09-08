package com.recruit.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.recruit.pojo.Recruit;
import com.recruit.service.RecruitService;
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
@Api(tags = {"招聘"})
@RestController
@RequestMapping("/recruit")
public class RecruitController {
    @Autowired
    private RecruitService recruitService;

    @ApiOperation(value = "招聘信息", response = Recruit.class, notes = "查询全部招聘信息")
    @GetMapping()
    public Result findAll() {
        List<Recruit> list = recruitService.findAll();
        return new Result(true, StatusCode.OK, "查询成功", list);
    }

    @ApiOperation(value = "招聘信息筛选（分页）", response = Recruit.class, notes = "分页条件查询招聘信息")
    @PostMapping("/search/{page}/{size}")
    public Result pageSearch(@RequestBody Recruit recruit, @PathVariable("page") int page, @PathVariable("size") int size) {
        Page pageData = recruitService.pageSearch(recruit, page, size);
        PageResult<Recruit> pageResult = new PageResult<>(pageData.getTotal(),pageData.getRecords());
        return new Result(true, StatusCode.OK, "分页条件查询成功", pageResult);
    }

    @ApiOperation(value = "招聘信息筛选", response = Recruit.class, notes = "条件查询招聘信息")
    @PostMapping("/search")
    public Result search(@RequestBody Recruit recruit) {
        List<Recruit> list = recruitService.search(recruit);
        return new Result(true, StatusCode.OK, "条件查询成功", list);
    }

    @ApiOperation(value = "单一招聘信息获取", response = Recruit.class, notes = "id查询招聘信息")
    @GetMapping("{id}")
    public Result findById(@PathVariable("id") String id) {
        Recruit recruit = recruitService.findById(id);
        return new Result(true, StatusCode.OK, "id查询成功", recruit);
    }

    @ApiOperation(value = "添加招聘信息", response = Recruit.class, notes = "添加招聘信息")
    @PostMapping()
    public Result add(@RequestBody Recruit recruit) {
        recruitService.add(recruit);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    @ApiOperation(value = "修改招聘信息", response = Recruit.class, notes = "修改招聘信息")
    @PutMapping("{id}")
    public Result update(@PathVariable("id") String id, @RequestBody Recruit recruit) {
        recruit.setId(id);
        recruitService.update(recruit);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    @ApiOperation(value = "删除招聘信息", response = Recruit.class, notes = "删除招聘信息")
    @DeleteMapping("{id}")
    public Result deleteById(@PathVariable("id") String id) {
        recruitService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    @ApiOperation(value = "推荐的招聘信息", response = Recruit.class, notes = "查询推荐的招聘信息")
    @GetMapping("/search/recommend")
    public Result recommend() {
        List<Recruit> list = recruitService.recommend();
        return new Result(true, StatusCode.OK, "状态查询成功", list);
    }

    @ApiOperation(value = "最新的招聘信息", response = Recruit.class, notes = "查询最新的招聘信息")
    @GetMapping("/search/newList")
    public Result newList() {
        List<Recruit> list = recruitService.newList();
        return new Result(true, StatusCode.OK, "状态查询成功", list);
    }
}
