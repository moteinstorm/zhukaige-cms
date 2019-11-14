package com.zhukaige.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhukaige.dao.ChannelMapper;
import com.zhukaige.entity.Channel;
import com.zhukaige.service.ChannelService;

/**
 * 
 * @author zhuzg
 *
 */

@Service
public class ChannelServiceImpl  implements ChannelService{
	
	@Autowired
	ChannelMapper channelMapper;

	@Override
	public List<Channel> list() {
		// TODO Auto-generated method stub
		return channelMapper.list();
	}

}
