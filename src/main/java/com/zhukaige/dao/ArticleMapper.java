package com.zhukaige.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

	/**
	 * 
	 * @param userId
	 * @return
	 */
	List<Article> listByUser(Integer userId);

	@Update(" UPDATE cms_article SET  deleted=1 WHERE id=#{value} ")
	int delete(int id);

	/** 
	 * @Title: checkExist 
	 * @Description: TODO
	 * @param id
	 * @return
	 * @return: Article
	 */
	@Select("SELECT id, title,user_id AS userId FROM cms_article WHERE id = #{value}")
	@ResultType(Article.class)
	Article checkExist(int id);

	/** 
	 * 管理员根据状态查询文章
	 * @Title: listByStatus 
	 * @Description: TODO
	 * @param status
	 * @return
	 * @return: List<Article>
	 */
	List<Article> listByStatus(int status);

}
