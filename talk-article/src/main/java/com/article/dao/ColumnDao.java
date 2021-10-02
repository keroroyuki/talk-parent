package com.article.dao;

import com.article.pojo.Column;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 谭嘉乐
 */
@Mapper
@Repository
public interface ColumnDao extends BaseMapper<Column> {
}
