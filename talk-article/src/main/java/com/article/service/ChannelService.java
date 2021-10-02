package com.article.service;

import com.article.pojo.Channel;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * @author 谭嘉乐
 */
public interface ChannelService {
    /**
     * 查询全部列表
     * @return
     */
    List<Channel> findAll();

    /**
     * 分页条件查询
     * @param channel
     * @param page
     * @param size
     * @return
     */
    Page<Channel> pageSearch(Channel channel, int page, int size);

    /**
     * 条件查询
     * @param channel
     * @return
     */
    List<Channel>search(Channel channel);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Channel findById(String id);

    /**
     * 添加
     * @param channel
     */
    void add(Channel channel);

    /**
     * 更新
     * @param channel
     */
    void update(Channel channel);

    /**
     * 删除
     * @param id
     */
    void deleteById(String id);
}
