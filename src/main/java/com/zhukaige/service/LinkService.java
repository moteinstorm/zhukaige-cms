package com.zhukaige.service;

import com.github.pagehelper.PageInfo;
import com.zhukaige.entity.Link;

public interface LinkService {

	 int add(Link link);
	PageInfo list(int page);

}
