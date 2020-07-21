<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
	<title>管理员信息显示</title>

	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 引入bootstrap -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
	<!-- 引入JQuery  bootstrap.js-->
	<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
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
	<!-- style="background:#C8EFFE; color:#C8EFFE" -->
	<div  class="container" id="content">
		<div class="row">
		<jsp:include page="menu.jsp"></jsp:include>
			<div class="col-md-10">
				<div class="">
				    <div class="">
						<div class="row">
					    	<h1 class="col-md-5">管理员列表</h1>
							<form class="bs-example bs-example-form col-md-5" role="form" style="margin: 20px 0 10px 0;" action="${pageContext.request.contextPath}/super/selectUser" id="form1" method="post">
								<div class="input-group">
									<input type="text" class="form-control" placeholder="请输入用户名" name="username">
									<span class="input-group-addon btn" onclick="document.getElementById('form1').submit" id="sub">搜索</span>
								</div>
							</form>
							<button class="add_button" style="height:33px;margin-top: 20px" onClick="location.href='${pageContext.request.contextPath}/super/addAdmin'">
								<span>添加管理员</span>
								
							</button>
							
						</div>
				    </div>
				    <table class="table table-bordered">
					        <thead>
					            <tr>
									<th>序号</th>
									<th>用户名</th>
									<th>权限</th>
									<th>访问次数</th>
									<th>最后一次访问时间</th>
									<th>状态</th>
									<th>操作</th>
					            </tr>
					        </thead>
					        <tbody>
							<c:forEach  items="${UserList}" var="item" varStatus="status">
								<tr>
									<td>${status.index+1 }</td>
									<td>${item.username}</td>
									<td>
										<c:choose>
											<c:when test="${item.rolename=='admin'}">
												管理员
											</c:when>
											<c:otherwise>
												用户
											</c:otherwise>
										</c:choose>
									</td>
									<td>${item.opennum}</td>
									<td><fmt:formatDate value="${item.lastopentime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
									<td>
									<c:choose>
										<c:when test="${item.csvpath != NULL}">
											<span style="font-weight:bold;color:#B7B9B8">已录入</span>
										</c:when>
										<c:otherwise>
											<span style="font-weight:bold;color:#E80000">未录入</span>
										</c:otherwise>
									</c:choose>
									</td>
									<td>
										<button class="btn btn-default btn-xs btn-info" onClick="location.href='/super/faceEntry?username=${item.username}'">人脸信息录入</button>
										<button class="btn btn-default btn-xs btn-danger btn-primary" onClick="location.href='/super/removeUser?username=${item.username}&page=${pagingVO.curentPageNo }'">删除</button>
										
									</td>
									
								</tr>
							</c:forEach>
					        </tbody>
				    </table>
				    <div class="">
						<c:if test="${pagingVO != null}">
							<nav style="text-align: center">
								<ul class="pagination">
									<li><a href="${pageContext.request.contextPath}/super/showadmin?page=1">&laquo;第一页</a></li>
									<c:if test="${pagingVO.curentPageNo-1 <= pagingVO.totalCount}">
										<li><a href="${pageContext.request.contextPath}/super/showadmin?page=${pagingVO.upPageNo}">上一页</a></li>
									</c:if>
									<li class="active"><a href="">${pagingVO.curentPageNo}</a></li>
									<c:if test="${pagingVO.curentPageNo+1 <= pagingVO.totalCount}">
										<li><a href="${pageContext.request.contextPath}/super/showadmin?page=${pagingVO.curentPageNo+1}">${pagingVO.curentPageNo+1}</a></li>
									</c:if>
									<c:if test="${pagingVO.curentPageNo+2 <= pagingVO.totalCount}">
										<li><a href="${pageContext.request.contextPath}/super/showadmin?page=${pagingVO.curentPageNo+2}">${pagingVO.curentPageNo+2}</a></li>
									</c:if>
									<c:if test="${pagingVO.curentPageNo+3 <= pagingVO.totalCount}">
										<li><a href="${pageContext.request.contextPath}/super/showadmin?page=${pagingVO.curentPageNo+3}">${pagingVO.curentPageNo+3}</a></li>
									</c:if>
									<c:if test="${pagingVO.curentPageNo+4 <= pagingVO.totalCount}">
										<li><a href="${pageContext.request.contextPath}/super/showadmin?page=${pagingVO.curentPageNo+4}">${pagingVO.curentPageNo+4}</a></li>
									</c:if>
									<c:if test="${pagingVO.curentPageNo+1 <= pagingVO.totalCount}">
										<li><a href="${pageContext.request.contextPath}/super/showadmin?page=${pagingVO.curentPageNo+1}">下一页&raquo;</a></li>
									</c:if>
									<li><a href="${pageContext.request.contextPath}/super/showadmin?page=${pagingVO.totalCount}">最后一页&raquo;</a></li>
								</ul>
							</nav>
						</c:if>
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
		<%--设置菜单中--%>
		$("#nav li:nth-child(1)").addClass("active")
        <c:if test="${pagingVO != null}">
        if (${pagingVO.curentPageNo} == ${pagingVO.totalCount}) {
            $(".pagination li:last-child").addClass("disabled")
        };

        if (${pagingVO.curentPageNo} == ${1}) {
            $(".pagination li:nth-child(1)").addClass("disabled")
        };
        </c:if>

        function confirmd() {
            var msg = "您真的确定要删除吗？！";
            if (confirm(msg)==true){
                return true;
            }else{
                return false;
            }
        }

        $("#sub").click(function () {
            $("#form1").submit();
        });
	</script>
</html>