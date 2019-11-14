package com.zhukaige.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhukaige.entity.Article;

public interface ArticleService {

	/**
	 * 获取最新文章
	 * @param i  获取的个数
	 * @return
	 */
	List<Article> getNewArticles(int i);

	/**
	 * 获取热门文章
	 * @param page
	 * @return
	 */
	PageInfo<Article> hotList(int page);

	/**
	 * 根据文章id 获取文章的内容
	 * @param id
	 * @return
	 */
	Article getById(Integer id);

	/**
	 * 根据频道或者分类获取文章
	 * @param chnId
	 * @param categoryId
	 * @param page
	 * @return
	 */
	PageInfo<Article> listByCat(int chnId, int categoryId, int page);
	

}
