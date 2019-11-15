<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
 <link href="/resource/bootstrap/css/bootstrap.css" rel="stylesheet">  
 <script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script> 
 <script type="text/javascript" src="/resource/bootstrap/js/bootstrap.js"></script>
 <script type="text/javascript" src="/resource/js/jquery.validate.js"></script>
 <script type="text/javascript" src="/resource/js/localization/messages_zh.js"></script>
 <title>用户注册</title>

</head>
<body>
	<div class="container" style="background:url(/pic/timg.jpg)">
		<div   style="boder:solid; width:400px;height:400px;">
			
<form class="form-horizontal" id="regForm" role="form" method="post">

	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">用户名</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="username" 
	      name="username" minlength="2" maxlength="8" 
	      remote="/user/checkname"
	      placeholder="请输入用户名">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="lastname" class="col-sm-2 control-label">密码</label>
	    <div class="col-sm-10">
	      <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
	    </div>
	  </div>
	
		
	
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <input type="button" class="btn btn-default" value="注册" onclick="register()" />
	    </div>
	  </div>
	</form>
	
		</div>
	</div>
	<script type="text/javascript">
		// regForm 需要校验  校验规则可以在这个函数内部 也可以直接写在 标签的属性上
		$("#regForm").validate();
		
		function register() {
			$("#regForm").submit();	
		}
	</script>
</body>
</html>