<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page language="java" import="java.util.* ,com.system.po.User,java.awt.*" errorPage="jsps/error.jsp" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%@page import="java.text.SimpleDateFormat"%>
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
</head>


<body>
	<%
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		User user=(User)request.getAttribute("user");
		String dateStr = sdf.format(user.getLastopentime());
		request.setAttribute("dateStr", dateStr);
	%>
	
	<!-- 顶栏 -->
	<jsp:include page="top.jsp"></jsp:include>
	<!-- 中间主体 -->
		<div class="container" id="content">
		<div class="row">
			
			<div class="col-md-10">
				<div class="panel panel-default">
				    <div class="panel-heading">
						<div class="row">
					    	<h1 style="text-align: center;">修改个人信息</h1>
						</div>
				    </div>
				    <div class="panel-body">
						<form class="form-horizontal" name="reset" role="form" action="${pageContext.request.contextPath}/super/editUser" id="editfrom" method="post" onsubmit="return check()>
							  <div class="form-group">
							    <label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
							    <div class="col-sm-10">
							      <input readonly="readonly" type="text" class="form-control" id="inputEmail3" name="username" placeholder="请输入用户名" 
							      <c:if test='${user!=null}'>
										 value="${user.username}"
								  </c:if>>
								 <%--readonly="readonly"  value="${user.username}">${user.username} --%>
							    </div>
							  
							  
							    <label for="inputPassword3" class="col-sm-2 control-label">用户权限</label>
							    <div class="col-sm-10">
									<label class="checkbox-inline">
										<input type="radio" name="rolename" value="superadmin" checked>超级管理员
									</label>
							    </div>
							 
							  
							    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" id="inputEmail3" name="password" placeholder="请输入密码" value="">
							    </div>
							    <label for="inputPassword3" class="col-sm-2 control-label">确认密码</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" id="inputEmail3" name="password2" placeholder="请输入密码" value="">
							    </div>
							    <label for="inputPassword3" class="col-sm-2 control-label">人脸信息录入</label>
							    <div class="col-sm-10">
							   		<!-- 此处不能使用<button />标签这样会默认提交表单 -->
							   		<input type="button" onClick="location.href='/user/userFaceEntry?username=${user.username}'" value="开始录入"/>
							      
							    </div>
							  
							    <c:if test='${user.imagepath!=null}'>
									<input style="display:none"   type="text" name="imagepath" value="${user.imagepath}"> 
								</c:if>
							    <c:if test='${user.opennum!=null}'>
									<input style="display:none"   type="text" name="opennum" value="${user.opennum}"> 
								</c:if>
							
							    <c:if test='${user.lastopentime!=null}'>
									<input style="display:none" type="text" name="lastopentime" value="${dateStr }"/> 
								</c:if>
							    <c:if test='${user.csvpath!=null}'>
									<input style="display:none"   type="text" name="csvpath" value="${user.csvpath}"/> 
								</c:if>
								
								<div class="form-group" style="text-align: center">
									<button class="btn btn-default" type="submit">提交</button>
									<button class="btn btn-default" type="reset">重置</button>
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
	        if(reset.username.value==null||reset.username.value=="")
	        {alert("请输入用户名");return false;}
	        if(reset.password.value==null||reset.password.value=="")
	        {alert("请输入重置密码");return false;}
	        if(reset.password2.value==null||reset.password2.value=="")
	        {alert("请再次输入密码");return false;}
	        if(reset.password.value != reset.password2.value)
	        {alert("两次密码不一致");return false;}
	    }

	</script>
</html>