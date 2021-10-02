package com.article.controller;

import com.article.pojo.Article;
import com.article.service.ArticleService;
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
 * @author keroro
 */
@Api(tags = {"文章"})
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @ApiOperation(value = "文章信息", response = Article.class, notes = "查询全部文章信息")
    @GetMapping()
    public Result findAll(){
        List<Article> list = articleService.findAll();
        return new Result(true, StatusCode.OK, "查询成功", list);
    }

    @ApiOperation(value = "文章信息筛选（分页）", response = Article.class, notes = "分页条件查询文章信息")
    @PostMapping("/search/{page}/{size}")
    public Result pageSearch(@RequestBody Article article, @PathVariable("page") int page, @PathVariable("size") int size){
        Page pageData = articleService.pageSearch(article, page, size);
        PageResult<Article> pageResult = new PageResult<>(pageData.getTotal(), pageData.getRecords());
        return new Result(true, StatusCode.OK, "分页条件查询成功", pageResult);
    }

    @ApiOperation(value = "文章信息筛选", response = Article.class, notes = "条件查询文章信息")
    @PostMapping("/search")
    public Result search(@RequestBody Article article) {
        List<Article> list = articleService.search(article);
        return new Result(true, StatusCode.OK, "条件查询成功", list);
    }

    @ApiOperation(value = "单一文章信息获取", response = Article.class, notes = "id查询文章信息")
    @GetMapping("{id}")
    public Result findById(@PathVariable("id") String id) {
        Article article = articleService.findById(id);
        return new Result(true, StatusCode.OK, "id查询成功", article);
    }

    @ApiOperation(value = "添加文章信息")
    @ApiParam(name = "实体对象", value = "传入json格式", required = true)
    @PostMapping()
    public Result add(@RequestBody Article article) {
        articleService.add(article);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    @ApiOperation(value = "修改文章信息")
    @ApiParam(name = "实体对象", value = "传入id和json格式", required = true)
    @PutMapping("{id}")
    public Result update(@PathVariable("id") String id, @RequestBody Article article) {
        article.setId(id);
        articleService.update(article);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    @ApiOperation(value = "删除文章信息", response = Article.class)
    @ApiParam(name = "删除实体对象", value = "传入id", required = true)
    @DeleteMapping("{id}")
    public Result deleteById(@PathVariable("id") String id) {
        articleService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    @ApiOperation(value = "文章审核", notes = "更新文章状态")
    @ApiParam(name = "实体对象", value = "传入id", required = true)
    @PutMapping("/examine/{id}")
    public Result examine(@PathVariable String id) {
        articleService.examine(id);
        return new Result(true, StatusCode.OK, "审核成功");
    }

    @ApiOperation(value = "文章点赞", notes = "更新文章点赞数")
    @ApiParam(name = "实体对象", value = "传入id", required = true)
    @PutMapping("/like/{id}")
    public Result like(@PathVariable String id) {
        articleService.thumbUp(id);
        return new Result(true, StatusCode.OK, "点赞成功");
    }

}
