package com.qa.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 谭嘉乐
 */
@TableName(value = "tb_problem")
@Data
@NoArgsConstructor
public class Problem implements Serializable {
    /**
     * ID
     */
    @TableId
    @ApiModelProperty(value = "ID")
    private String id;

    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    private String title;
    /**
     * 内容
     */
    @ApiModelProperty(value = "内容")
    private String content;
    /**
     * 创建日期
     */
    @ApiModelProperty(value = "创建日期")
    private java.util.Date createtime;
    /**
     * 修改日期
     */
    @ApiModelProperty(value = "修改日期")
    private java.util.Date updatetime;
    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    private String userid;
    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称")
    private String nickname;
    /**
     * 浏览量
     */
    @ApiModelProperty(value = "浏览量")
    private Long visits;
    /**
     * 点赞数
     */
    @ApiModelProperty(value = "点赞数")
    private Long thumbup;
    /**
     * 回复数
     */
    @ApiModelProperty(value = "回复数")
    private Long reply;
    /**
     * 是否解决
     */
    @ApiModelProperty(value = "是否解决")
    private String solve;
    /**
     * 回复人昵称
     */
    @ApiModelProperty(value = "回复人昵称")
    private String replyname;
    /**
     * 回复日期
     */
    @ApiModelProperty(value = "回复日期")
    private java.util.Date replytime;
}
