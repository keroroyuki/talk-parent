package com.article.dao;

import com.article.pojo.Channel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 谭嘉乐
 */
@Mapper
@Repository
public interface ChannelDao extends BaseMapper<Channel> {
}
