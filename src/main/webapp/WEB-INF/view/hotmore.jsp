<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<c:forEach items="${hotList.list}" var="article" >
		<div class=row style="padding-bottom:1px">
			<hr width="88%" style="background-color:#D2691E;border:none;height:1px">
			<div class="col-md-2" style="text-align:right"><img height="80px" width="80px" src="/pic/${article.picture}" onerror="this.src='/resource/images/default-cat.png'" class="img-rounded"></div>
			<div class="col-md-10">
				<a href="javascript:showArticle(${article.id})">${article.title}</a>
				<br><br>
				 频道：<a>${article.channel.name}</a> &nbsp;&nbsp;
				 分类：<a>${article.category.name}</a>
				<br>
				
				${article.user.username} 发布于  <fmt:formatDate value="${article.created}" pattern="yyyy-MM-dd"/> 
			</div>
		</div>
	</c:forEach>
<script>
	currentPage = ${hotList.pageNum};
</script>	