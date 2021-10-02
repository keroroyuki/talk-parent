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
@TableName("tb_column")
@Data
@NoArgsConstructor
public class Column implements Serializable {
    /**
     * ID
     */
    @ApiModelProperty("ID")
    @TableId
    private String id;


    /**
     * 专栏名称
     */
    @ApiModelProperty("专栏名称")
    private String name;
    /**
     * 专栏简介
     */
    @ApiModelProperty("专栏简介")
    private String summary;
    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private String userid;
    /**
     * 申请日期
     */
    @ApiModelProperty("申请日期")
    private java.util.Date createtime;
    /**
     * 审核日期
     */
    @ApiModelProperty("审核日期")
    private java.util.Date checktime;
    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private String state;
}
