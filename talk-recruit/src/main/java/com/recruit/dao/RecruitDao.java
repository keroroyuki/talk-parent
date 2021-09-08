package com.recruit.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.recruit.pojo.Recruit;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 谭嘉乐
 */
@Repository
@Mapper
public interface RecruitDao extends BaseMapper<Recruit> {
}
