<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<title></title>

	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 引入bootstrap -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
	<!-- 引入JQuery  bootstrap.js-->
	<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<style>
	body {
		background: #ebebeb;
		font-family: "Helvetica Neue", "Hiragino Sans GB", "Microsoft YaHei",
			"\9ED1\4F53", Arial, sans-serif;
		color: #222;
		background: url("${pageContext.request.contextPath}/images/showbg1.jpg")repeat;
		/* font-size: 12px; */
	}
	</style>
	
</head>
<body>
	<!-- 顶栏 -->
	<jsp:include page="top.jsp"></jsp:include>
	<!-- 中间主体 -->
		<div class="container" id="content">
		<div class="row">
		
			<div class="col-md-10">
				<div class="panel panel-default">
				    <div class="panel-heading">
						<div class="row">
					    	<h1 style="text-align: center;">添加用户信息</h1>
						</div>
				    </div>
				    <div class="panel-body">
						<form class="form-horizontal" name="reset" action="${pageContext.request.contextPath}/admin/addUser" id="editfrom" method="post" onsubmit="return check()">
							 
							  <div class="form-group">
								  <label for="inputPassword3" class="col-sm-2 control-label">用户名</label>
								  <div class="col-sm-10">
								    <input type="text" class="form-control" id="inputusername" name="username" placeholder="请输入用户名"/>
									  
								  </div>
								  
								  
							      <label for="inputPassword3" class="col-sm-2 control-label">用户权限</label>
							      <div class="col-sm-10">
									<label class="checkbox-inline">
										<input type="radio" name="rolename" value="user" checked/>用户
									</label>
							      </div>
								 
								  
								  <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
								  <div class="col-sm-10">
								    <input type="text" class="form-control" id="inputPassword" name="password" placeholder="请输入密码"/>
									  
								  </div>

								  <label for="inputPassword3" class="col-sm-2 control-label">确认密码</label>
								  <div class="col-sm-10">
								   	 <input type="text" class="form-control" id="inputPassword2" name="password2" placeholder="请输入密码"/>
								  </div>
								  <label for="inputPassword3" class="col-sm-2 control-label">人脸信息录入</label>
							   	 <div id="contentHolder">
								    <video id="video" width="320" height="320" autoplay></video>
								    <input type="button" id="picture" style="display:block" >拍照</input>
								    <canvas style="display:block" id="canvas" width="320" height="320"></canvas>
								    <input id="sc" style="display:block" >上传</input>
								</div>
							    <div class="col-sm-10">
							   		<!-- 此处不能使用<button />标签，这样会默认提交表单 -->
							   		<button onClick="location.href='/user/userFaceEntry?username=${user.username}'" value="开始录入"/>
							     
							    </div>
								  <div class="form-group" style="text-align: center">
									<button class="btn btn-default" type="submit">提交</button>
									<button class="btn btn-default" >重置</button>
								  </div>
							  </div>
						</form>
				    </div>
				    
				</div>

			</div>
		</div>
	</div>
	<div class="container" id="footer">
	<div class="row">
		<div class="col-md-12"></div>
	</div>
	</div>
</body>
	<script type="text/javascript">
	    $("#nav li:nth-child(4)").addClass("active")
	    function check() {
	        if(reset.username.value==""||reset.username.value==null)
	        {alert("请输入账户名称");return false;}
	        if(reset.password.value==""||reset.password.value==null)
	        {alert("请输入重置密码");return false;}
	        if(reset.password2.value==""||reset.password2.value==null)
	        {alert("请再次输入密码");return false;}
	        if(reset.password.value != reset.password2.value)
	        {alert("两次密码不正确");return false;}
	    }
	</script>
</html>