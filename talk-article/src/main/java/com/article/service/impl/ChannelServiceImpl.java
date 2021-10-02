package com.article.service.impl;

import com.article.dao.ChannelDao;
import com.article.pojo.Channel;
import com.article.service.ChannelService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

/**
 * @author 谭嘉乐
 */
@Service
public class ChannelServiceImpl implements ChannelService {
    @Autowired
    private ChannelDao channelDao;

    @Autowired
    private IdWorker idWorker;

    @Override
    public List<Channel> findAll() {
        return channelDao.selectList(null);
    }

    @Override
    public Page<Channel> pageSearch(Channel channel, int page, int size) {
        QueryWrapper<Channel> wrapper = conditionsAll(channel);
        Page<Channel> channelPage = new Page<>(page, size);
        return channelDao.selectPage(channelPage,wrapper);
    }

    @Override
    public List<Channel> search(Channel channel) {
        QueryWrapper<Channel> wrapper = conditionsAll(channel);
        return channelDao.selectList(wrapper);
    }

    @Override
    public Channel findById(String id) {
        return channelDao.selectById(id);
    }

    @Override
    public void add(Channel channel) {
        channel.setId(idWorker.nextId()+"");
        channelDao.insert(channel);
    }

    @Override
    public void update(Channel channel) {
        channelDao.updateById(channel);
    }

    @Override
    public void deleteById(String id) {
        channelDao.deleteById(id);
    }

    private QueryWrapper<Channel> conditionsAll(Channel channel) {
        QueryWrapper<Channel> wrapper = new QueryWrapper<>();
        if (channel.getName()!=null && !"".equals(channel.getName())) {
            wrapper = wrapper.like("name", channel.getName());
        }
        if (channel.getState()!=null && !"".equals(channel.getState())) {
            wrapper = wrapper.eq("state", channel.getState());
        }
        return wrapper;
    }
}
