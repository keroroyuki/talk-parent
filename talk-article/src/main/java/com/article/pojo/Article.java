package com.article.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 谭嘉乐
 */
@TableName("tb_article")
@Data
@NoArgsConstructor
public class Article implements Serializable {
    /**
     * ID
     */
    @ApiModelProperty("ID")
    @TableId
    private String id;

    /**
     * 专栏ID
     */
    @ApiModelProperty("专栏ID")
    private String columnid;
    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private String userid;
    /**
     * 标题
     */
    @ApiModelProperty("标题")
    private String title;
    /**
     * 文章正文
     */
    @ApiModelProperty("文章正文")
    private String content;
    /**
     * 文章封面
     */
    @ApiModelProperty("文章封面")
    private String image;
    /**
     * 发表日期
     */
    @ApiModelProperty("发表日期")
    private java.util.Date createtime;
    /**
     * 修改日期
     */
    @ApiModelProperty("修改日期")
    private java.util.Date updatetime;
    /**
     * 是否公开
     */
    @ApiModelProperty("是否公开")
    private String ispublic;
    /**
     * 是否置顶
     */
    @ApiModelProperty("是否置顶")
    private String istop;
    /**
     * 浏览量
     */
    @ApiModelProperty("浏览量")
    private Integer visits;
    /**
     * 点赞数
     */
    @ApiModelProperty("点赞数")
    private Integer thumbup;
    /**
     * 评论数
     */
    @ApiModelProperty("评论数")
    private Integer comment;
    /**
     * 审核状态
     */
    @ApiModelProperty("审核状态")
    private String state;
    /**
     * 所属频道
     */
    @ApiModelProperty("所属频道")
    private String channelid;
    /**
     * URL
     */
    @ApiModelProperty("URL")
    private String url;
    /**
     * 类型
     */
    @ApiModelProperty("类型")
    private String type;
}
