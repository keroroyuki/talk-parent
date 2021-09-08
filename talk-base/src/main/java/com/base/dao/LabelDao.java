package com.base.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.base.pojo.Label;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 谭嘉乐
 */
@Repository
@Mapper
public interface LabelDao extends BaseMapper<Label> {
}
