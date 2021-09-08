package com.recruit.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 谭嘉乐
 */
@TableName("tb_enterprise")
@Data
@NoArgsConstructor
public class Enterprise {
    /**
     * id
     */
    @TableId
    @ApiModelProperty(notes = "id")
    private String id;
    /**
     * 企业名称
     */
    @ApiModelProperty(notes = "企业名称")
    private String name;
    /**
     * 企业简介
     */
    @ApiModelProperty(notes = "企业简介")
    private String summary;
    /**
     * 企业地址
     */
    @ApiModelProperty(notes = "企业地址")
    private String address;
    /**
     * 标签列表
     */
    @ApiModelProperty(notes = "标签列表")
    private String labels;
    /**
     * 坐标
     */
    @ApiModelProperty(notes = "坐标")
    private String coordinate;
    /**
     * 是否热门
     */
    @ApiModelProperty(notes = "是否热门")
    private String ishot;
    /**
     * logo
     */
    @ApiModelProperty(notes = "logo")
    private String logo;
    /**
     * 职位数
     */
    @ApiModelProperty(notes = "职位数")
    private Integer jobcount;
    /**
     * url
     */
    @ApiModelProperty(notes = "url")
    private String url;
}
