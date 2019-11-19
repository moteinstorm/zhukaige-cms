package com.zhukaige.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zhukaige.common.CmsAssert;
import com.zhukaige.common.ConstantClass;
import com.zhukaige.common.MsgResult;
import com.zhukaige.entity.Article;
import com.zhukaige.entity.User;
import com.zhukaige.service.ArticleService;
import com.zhukaige.service.UserService;


@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ArticleService articleService;
	
	//  httppxxxx://user/hello
	@RequestMapping(value="hello",method=RequestMethod.GET)
	public String tet(HttpServletRequest request) {
		request.setAttribute("info", "hello");
		return "user/test";
	}
	
	/**
	 * 跳转到注册页面 
	 * @param request
	 * @return
	 */
	@RequestMapping(value="register",method=RequestMethod.GET)
	public String register(HttpServletRequest request) {
		return "user/register";
	}
	
	/**
	 * 处理用户提交的注册的数据
	 * @param request
	 * @param user
	 * @return
	 */
	@RequestMapping(value="register",method=RequestMethod.POST)
	public String register(HttpServletRequest request,User user) {
		
		
		int result = userService.register(user);
		CmsAssert.AssertTrue(result>0,"用户注册失败，请稍后再试");
		
		
		return "redirect:/user/login";
	}
	
	
	
	/**
	 * 跳转到登录页面 
	 * @param request
	 * @return
	 */
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(HttpServletRequest request) {
		return "user/login";
	}
	
	/**
	 * 处理用户提交的登录的数据
	 * @param request
	 * @param user
	 * @return
	 */
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(HttpServletRequest request,User user) {
		
		
		User loginUser  = userService.login(user);
		// 用户存在 登录成功
		if(loginUser!=null) {
			request.getSession().setAttribute(ConstantClass.USER_KEY, loginUser);
			
			//return "redirect:/";
			return loginUser.getRole()==ConstantClass.USER_ROLE_ADMIN
					?"redirect:/admin/index":"redirect:/user/home";
		}else {
			request.setAttribute("errorMsg", "用户名或密码错误！！");
			request.setAttribute("user", user);
			return "user/login";
		}
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("logout")
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute(ConstantClass.USER_KEY);
		return "redirect:/";
	}
	
	@RequestMapping("checkname")
	@ResponseBody
	public boolean checkname(String username) {
		return null==userService.findByName(username);
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("home")
	public String home(HttpServletRequest request) {
		return "/user/home";
	}
	
	/**
	 * 获取文章列表
	 * @return
	 */
	@RequestMapping("myarticles")
	public String myarticles(HttpServletRequest request,
			@RequestParam(defaultValue="1") int page) {
		
		User loginUser = (User)request.getSession().getAttribute(ConstantClass.USER_KEY);
		
		PageInfo<Article> pageInfo=  articleService.listByUser(page,loginUser.getId());
		request.setAttribute("pageInfo", pageInfo);
		return "user/myarticles";
	}
	
	@RequestMapping("delArticle")
	@ResponseBody
	public MsgResult delArticle(HttpServletRequest request,int id){
		
		CmsAssert.AssertTrue(id>0, "文章id必须大于0");
		Article article =  articleService.checkExist(id);
		CmsAssert.AssertTrue(article!=null, "该文章不存在");
		
		User loginUser = (User)request.getSession().getAttribute(ConstantClass.USER_KEY);
		CmsAssert.AssertTrue(
				loginUser.getRole()==ConstantClass.USER_ROLE_ADMIN 
				|| loginUser.getId()==article.getUserId(),
				"只有管理员和文章的作者能删除文章");
		
		int result = articleService.delete(id);
		CmsAssert.AssertTrue(result>0,"文章删除失败");
		return new MsgResult(1,"删除成功",null);
		
	}
}
