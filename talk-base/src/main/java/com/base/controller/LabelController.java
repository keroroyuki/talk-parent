package com.base.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.base.pojo.Label;
import com.base.service.LabelService;
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
@Api(tags = {"基础微服务"})
@RestController
@RequestMapping("/label")
public class LabelController {
    @Autowired
    private LabelService labelService;

    @ApiOperation(value = "全部标签", response = Label.class, notes = "查询全部标签")
    @GetMapping()
    public Result findAll() {
        return new Result(true, StatusCode.OK,"查询成功",labelService.findAll());
    }

    @ApiOperation(value = "单一标签", response = Label.class, notes = "id查询标签")
    @GetMapping("/{id}")
    public Result findById(@PathVariable("id") String id) {
        return new Result(true, StatusCode.OK,"根据id查询成功",labelService.findById(id));
    }

    @ApiOperation(value = "添加标签", response = Label.class, notes = "添加标签")
    @PostMapping()
    public Result add(@RequestBody Label label) {
        labelService.add(label);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    @ApiOperation(value = "修改标签", response = Label.class, notes = "修改标签")
    @PutMapping("/{id}")
    public Result update(@RequestBody Label label, @PathVariable("id") String id) {
        label.setId(id);
        labelService.update(label);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    @ApiOperation(value = "删除标签", response = Label.class, notes = "删除标签")
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable("id") String id) {
        labelService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    @ApiOperation(value = "筛选标签", response = Label.class, notes = "条件查询标签")
    @PostMapping("/search")
    public Result search(@RequestBody Label label) {
        List<Label> list = labelService.search(label);
        return new Result(true, StatusCode.OK, "不分页条件查询成功", list);
    }

    @ApiOperation(value = "筛选标签（分页）", response = Label.class, notes = "分页条件查询标签")
    @PostMapping("/search/{page}/{size}")
    public Result search(@RequestBody Label label, @PathVariable("page") int page, @PathVariable("size") int size) {
        Page pageData = labelService.pageSearch(label, page, size);
        PageResult<Label> pageResult = new PageResult<>(pageData.getTotal(),pageData.getRecords());
        return new Result(true, StatusCode.OK, "分页条件查询成功", pageResult);
    }
}
