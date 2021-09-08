package com.recruit.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 谭嘉乐
 */
@Data
@TableName("tb_recruit")
public class Recruit {
    /**
     * ID
     */
    @ApiModelProperty(value = "ID")
    private String id;
    /**
     * 职位名称
     */
    @ApiModelProperty(value = "职位名称")
    private String jobname;
    /**
     * 薪资范围
     */
    @ApiModelProperty(value = "薪资范围")
    private String salary;
    /**
     * 经验要求
     */
    @ApiModelProperty(value = "经验要求")
    @TableField("`condition`")
    private String condition;
    /**
     * 学历要求
     */
    @ApiModelProperty(value = "学历要求")
    private String education;
    /**
     * 任职方式
     */
    @ApiModelProperty(value = "任职方式")
    private String type;
    /**
     * 办公地址
     */
    @ApiModelProperty(value = "办公地址")
    private String address;
    /**
     * 企业ID
     */
    @ApiModelProperty(value = "企业ID")
    private String eid;
    /**
     * 创建日期
     */
    @ApiModelProperty(value = "创建日期")
    private java.util.Date createtime;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private String state;
    /**
     * 网址
     */
    @ApiModelProperty(value = "网址")
    private String url;
    /**
     * 标签
     */
    @ApiModelProperty(value = "标签")
    private String label;
    /**
     * 职位描述
     */
    @ApiModelProperty(value = "职位描述")
    private String content1;
    /**
     * 职位要求
     */
    @ApiModelProperty(value = "职位要求")
    private String content2;
}
