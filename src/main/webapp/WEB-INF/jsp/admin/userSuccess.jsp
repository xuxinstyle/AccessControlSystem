<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成功页面</title>
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
				location.href='${pageContext.request.contextPath}/admin/editUser';
			}
		}
	</script> 
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
   
	<div id="divcontent">
		<table width="850px" border="0" cellspacing="0">
			<tr>
				<td style="padding:30px; text-align:center"><table width="60%"
						border="0" cellspacing="0" style="margin-top:70px">
						<tr>
							
							<td style="padding-top:30px">
								<font style="font-weight:bold; color:#FF0000">人脸信息录入成功</font><br />	
								<br /> <a href="${pageContext.request.contextPath}/admin/editUser"><span id="second">3</span>秒后自动为您转跳上一页,或点击此处跳转</a>
							</td>
						</tr>
					</table>
					<h1>&nbsp;</h1>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
