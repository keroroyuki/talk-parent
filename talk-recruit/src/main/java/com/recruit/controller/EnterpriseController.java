package com.recruit.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.recruit.pojo.Enterprise;
import com.recruit.pojo.Recruit;
import com.recruit.service.EnterpriseService;
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
@Api(tags = {"企业"})
@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {
    @Autowired
    private EnterpriseService enterpriseService;
    @ApiOperation(value = "企业信息", response = Enterprise.class, notes = "查询全部企业信息")
    @GetMapping()
    public Result findAll() {
        List<Enterprise> list = enterpriseService.findAll();
        return new Result(true, StatusCode.OK, "查询成功", list);
    }
    @ApiOperation(value = "分页条件企业信息", response = Enterprise.class, notes = "分页条件查询企业信息")
    @PostMapping("/search/{page}/{size}")
    public Result pageSearch(@RequestBody Enterprise enterprise, @PathVariable("page") int page, @PathVariable("size") int size) {
        Page pageData = enterpriseService.pageSearch(enterprise,page,size);
        PageResult<Enterprise> pageResult = new PageResult<>(pageData.getTotal(), pageData.getRecords());
        return new Result(true, StatusCode.OK, "分页条件查询成功", pageResult);
    }
    @ApiOperation(value = "特定条件企业信息", response = Enterprise.class, notes = "条件查询企业信息")
    @PostMapping("/search")
    public Result search(@RequestBody Enterprise enterprise) {
        List<Enterprise> list = enterpriseService.search(enterprise);
        return new Result(true, StatusCode.OK, "条件查询成功", list);
    }
    @ApiOperation(value = "单一企业信息", response = Enterprise.class, notes = "id查询企业信息")
    @GetMapping("{id}")
    public Result findById(@PathVariable("id") String id) {
        Enterprise enterprise = enterpriseService.findById(id);
        return new Result(true, StatusCode.OK, "id查询成功", enterprise);
    }
    @ApiOperation(value = "添加企业信息", response = Enterprise.class, notes = "添加企业信息")
    @PostMapping()
    public Result add(@RequestBody Enterprise enterprise) {
        enterpriseService.add(enterprise);
        return new Result(true, StatusCode.OK, "添加成功");
    }
    @ApiOperation(value = "修改企业信息", response = Enterprise.class, notes = "修改企业信息")
    @PutMapping("{id}")
    public Result update(@PathVariable("id") String id, @RequestBody Enterprise enterprise) {
        enterprise.setId(id);
        enterpriseService.update(enterprise);
        return new Result(true, StatusCode.OK, "修改成功");
    }
    @ApiOperation(value = "删除企业信息", response = Enterprise.class, notes = "删除企业信息")
    @DeleteMapping("{id}")
    public Result deleteById(@PathVariable("id") String id) {
        enterpriseService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
    @ApiOperation(value = "热门企业信息", response = Enterprise.class, notes = "查询热门企业信息")
    @GetMapping("/search/hotEnterprise")
    public Result hotEnterprise() {
        List<Enterprise> list = enterpriseService.hotList();
        return new Result(true, StatusCode.OK, "热门企业查询成功", list);
    }
}
