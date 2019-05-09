<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-md-2">
    <ul class="nav nav-pills nav-stacked" id="nav">
        <li><a href="${pageContext.request.contextPath}/super/showadmin">管理员管理<span class="badge pull-right"></span></a></li>
        <li><a href="${pageContext.request.contextPath}/super/showUser">用户管理<span class="badge pull-right"></span></a></li>
        <li><a href="${pageContext.request.contextPath}/super/showVisit">访问记录管理<span class="badge pull-right"></span></a></li>
        
        <li><a href="${pageContext.request.contextPath}/super/userPasswordRest">账号密码重置<sapn class="glyphicon glyphicon-repeat pull-right" /></a></li>
        <li><a href="${pageContext.request.contextPath}/super/editUser">修改个人信息<sapn class="glyphicon glyphicon-pencil pull-right" /></a></li>
        <li><a href="${pageContext.request.contextPath}/logout">退出系统<sapn class="glyphicon glyphicon-log-out pull-right" /></a></li>
        <li class="disabled"><a href="##">Responsive</a></li>
    </ul>
</div>