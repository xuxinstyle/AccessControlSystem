<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--开启el表达式--%>
<%@ page  isELIgnored="false"%>

<html>
<head>
    <title>未识别</title>
</head>
<body>
	<script type="text/javascript">
		onload=function(){
			setInterval(go, 1000);
		};
		var x=3; //利用了全局变量来执行
		function go(){
			x--;
			if(x>0){
				document.getElementById("sp").innerHTML=x; //每次设置的x的值都不一样了。
			}else{
				location.href='${pageContext.request.contextPath}/facelogin.jsp';
			}
		}
	</script> 
    <span style="size: 500px;color: red">对不起你没有开门的权限</span>
    <a href="javascript:history.back(-1)">返回上一页</a>
</body>
</html>
