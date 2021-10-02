package com.article.controller;

import com.article.pojo.Channel;
import com.article.service.ChannelService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 谭嘉乐
 */
@Api(tags = {"频道"})
@RestController
@RequestMapping("/channel")
public class ChannelController {
    @Autowired
    private ChannelService channelService;

    @ApiOperation(value = "频道信息", response = Channel.class, notes = "查询全部频道信息")
    @GetMapping()
    public Result findAll(){
        List<Channel> list = channelService.findAll();
        return new Result(true, StatusCode.OK, "查询成功", list);
    }

    @ApiOperation(value = "频道信息筛选（分页）", response = Channel.class, notes = "分页条件查询频道信息")
    @PostMapping("/search/{page}/{size}")
    public Result pageSearch(@RequestBody Channel channel, @PathVariable("page") int page, @PathVariable("size") int size){
        Page pageData = channelService.pageSearch(channel, page, size);
        PageResult<Channel> pageResult = new PageResult<>(pageData.getTotal(), pageData.getRecords());
        return new Result(true, StatusCode.OK, "分页条件查询成功", pageResult);
    }

    @ApiOperation(value = "频道信息筛选", response = Channel.class, notes = "条件查询频道信息")
    @PostMapping("/search")
    public Result search(@RequestBody Channel channel) {
        List<Channel> list = channelService.search(channel);
        return new Result(true, StatusCode.OK, "条件查询成功", list);
    }

    @ApiOperation(value = "单一频道信息获取", response = Channel.class, notes = "id查询频道信息")
    @GetMapping("{id}")
    public Result findById(@PathVariable("id") String id) {
        Channel channel = channelService.findById(id);
        return new Result(true, StatusCode.OK, "id查询成功", channel);
    }

    @ApiOperation(value = "添加频道信息")
    @ApiParam(name = "实体对象", value = "传入json格式", required = true)
    @PostMapping()
    public Result add(@RequestBody Channel channel) {
        channelService.add(channel);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    @ApiOperation(value = "修改频道信息")
    @ApiParam(name = "实体对象", value = "传入id和json格式", required = true)
    @PutMapping("{id}")
    public Result update(@PathVariable("id") String id, @RequestBody Channel channel) {
        channel.setId(id);
        channelService.update(channel);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    @ApiOperation(value = "删除频道信息", response = Channel.class)
    @ApiParam(name = "删除实体对象", value = "传入id", required = true)
    @DeleteMapping("{id}")
    public Result deleteById(@PathVariable("id") String id) {
        channelService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
