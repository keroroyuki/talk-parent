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
@TableName(value = "tb_pl")
@Data
@NoArgsConstructor
public class Pl implements Serializable {
    /**
     * 问题id
     */
    @TableId
    @ApiModelProperty(value = "问题id")
    private String problemid;
    /**
     * 标签id
     */
    @TableId
    @ApiModelProperty(value = "问题id")
    private String lableid;
}
