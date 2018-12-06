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
						<form class="form-horizontal" name="reset" action="${pageContext.request.contextPath}/super/addUser" id="editfrom" method="post" onsubmit="return check()">
							 
							  <div class="form-group">
							    <label for="inputPassword3" class="col-sm-2 control-label">用户名</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" id="inputusername" name="username" placeholder="请输入用户名">
								  
							    </div>
							  
							    <label for="inputPassword3" class="col-sm-2 control-label">用户权限</label>
							    <div class="col-sm-10">
								    <label class="checkbox-inline">
									   	<input type="radio" name="rolename" value="admin" checked>管理员</input>
									</label>
									<label class="checkbox-inline">
										<input type="radio" name="rolename" value="user"/>用户
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
							    <%--  <div id="contentHolder">
								    <video id="video" width="320" height="320" autoplay></video>
								    <input type="button" id="picture" style="display:block" value="拍照"></input>
								    <canvas style="display:block" id="canvas" width="320" height="320"></canvas>
								    <input type="button" id="sc" style="display:block" value="上传"></input>
								</div> --%>

							  </div>
							 
							  <div class="form-group" style="text-align: center">
								<button class="btn btn-default" type="submit">提交</button>
								<button class="btn btn-default" >重置</button>
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
	<!-- <script>
    navigator.getUserMedia = navigator.getUserMedia ||
    navigator.webkitGetUserMedia ||
    navigator.mozGetUserMedia;
    if (navigator.getUserMedia) {
        navigator.getUserMedia({ audio: true, video: { width: 320, height: 320 } },
                function(stream) {
                    var video = document.getElementById("video");
                    video.src = window.URL.createObjectURL(stream);
                    video.onloadedmetadata = function(e) {
                        console.log('nihao44eee4aaaaddda');
                        video.play();
                    };
                },
                function(err) {
                    console.log("The following error occurred: " + err.name);
                }
        );
    } else {
        console.log("getUserMedia not supported");
    }
  
   
    document.getElementById("picture").addEventListener("click", function () {
    	  debugger;
    	 var context = document.getElementById("canvas").getContext("2d");
        context.drawImage(video, 0, 0, 320, 320);
    });
    document.getElementById("sc").addEventListener("click", function () {
        var imgData=document.getElementById("canvas").toDataURL("image/png");
        var data=imgData.substr(22);
        debugger;
        console.log(data);
        $.post('../upload/sc',{'sj':data});
    });
</script> -->
</html>