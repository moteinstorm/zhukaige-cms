package com.zhukaige.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhukaige.entity.Article;

public interface ArticleMapper {

	/**
	 * 获取最新文章
	 * @param i 获取的个数
	 * @return
	 */
	List<Article> newList(int i);

	/**
	 * 获取热门文章
	 * @return
	 */
	List<Article> hostList();

	/**
	 * 获取文章
	 * @param id
	 * @return
	 */
	Article getById(Integer id);

	/**
	 * 根据频道获取文章
	 * @param chnId
	 * @param categoryId
	 * @return
	 */
	List<Article> listByCat(@Param("chnId") int chnId,@Param("categoryId") int categoryId);

}
