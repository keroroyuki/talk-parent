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
@TableName("tb_channel")
@Data
@NoArgsConstructor
public class Channel implements Serializable {
    /**
     * ID
     */
    @ApiModelProperty("ID")
    @TableId
    private String id;


    /**
     * 频道名称
     */
    @ApiModelProperty("频道名称")
    private String name;

    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private String state;
}
