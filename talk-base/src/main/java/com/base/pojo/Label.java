package com.base.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author 谭嘉乐
 */
@TableName("tb_label")
@Data
@NoArgsConstructor
public class Label {
    @TableId
    private String id;
    /**
     * 标签名称
     */
    @ApiModelProperty(value = "标签名称")
    private String labelName;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private String state;
    /**
     * 使用数量
     */
    @ApiModelProperty(value = "使用数量")
    private long count;
    /**
     * 关注数
     */
    @ApiModelProperty(value = "关注数")
    private long fans;
    /**
     * 是否推荐
     */
    @ApiModelProperty(value = "是否推荐")
    private String recommend;

}
