/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-11-20 14:48:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.super_;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addUser_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<title></title>\n");
      out.write("\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("\t<!-- 引入bootstrap -->\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/bootstrap.min.css\">\n");
      out.write("\t<!-- 引入JQuery  bootstrap.js-->\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery-3.2.1.min.js\"></script>\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/bootstrap.min.js\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<!-- 顶栏 -->\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "top.jsp", out, false);
      out.write("\n");
      out.write("\t<!-- 中间主体 -->\n");
      out.write("\t\t<div class=\"container\" id=\"content\">\n");
      out.write("\t\t<div class=\"row\">\n");
      out.write("\t\t\n");
      out.write("\t\t\t<div class=\"col-md-10\">\n");
      out.write("\t\t\t\t<div class=\"panel panel-default\">\n");
      out.write("\t\t\t\t    <div class=\"panel-heading\">\n");
      out.write("\t\t\t\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t\t    \t<h1 style=\"text-align: center;\">添加用户信息</h1>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t    </div>\n");
      out.write("\t\t\t\t    <div class=\"panel-body\">\n");
      out.write("\t\t\t\t\t\t<form class=\"form-horizontal\" name=\"reset\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/super/addUser\" id=\"editfrom\" method=\"post\" onsubmit=\"return check()\">\n");
      out.write("\t\t\t\t\t\t\t \n");
      out.write("\t\t\t\t\t\t\t  <div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t\t    <label for=\"inputPassword3\" class=\"col-sm-2 control-label\">用户名</label>\n");
      out.write("\t\t\t\t\t\t\t    <div class=\"col-sm-10\">\n");
      out.write("\t\t\t\t\t\t\t      <input type=\"text\" class=\"form-control\" id=\"inputusername\" name=\"username\" placeholder=\"请输入用户名\"\n");
      out.write("\t\t\t\t\t\t\t\t  \n");
      out.write("\t\t\t\t\t\t\t    </div>\n");
      out.write("\t\t\t\t\t\t\t  </div>\n");
      out.write("\t\t\t\t\t\t\t  <div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t\t    <label for=\"inputPassword3\" class=\"col-sm-2 control-label\">用户权限</label>\n");
      out.write("\t\t\t\t\t\t\t    <div class=\"col-sm-10\">\n");
      out.write("\t\t\t\t\t\t\t\t    <label class=\"checkbox-inline\">\n");
      out.write("\t\t\t\t\t\t\t\t\t   \t<input type=\"radio\" name=\"rolename\" value=\"admin\" checked>管理员\n");
      out.write("\t\t\t\t\t\t\t\t\t</label>\n");
      out.write("\t\t\t\t\t\t\t\t\t<label class=\"checkbox-inline\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"radio\" name=\"rolename\" value=\"user\">用户\n");
      out.write("\t\t\t\t\t\t\t\t\t</label>\n");
      out.write("\t\t\t\t\t\t\t    </div>\n");
      out.write("\t\t\t\t\t\t\t  </div>\n");
      out.write("\t\t\t\t\t\t\t  <div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t\t    <label for=\"inputPassword3\" class=\"col-sm-2 control-label\">密码</label>\n");
      out.write("\t\t\t\t\t\t\t    <div class=\"col-sm-10\">\n");
      out.write("\t\t\t\t\t\t\t      <input type=\"text\" class=\"form-control\" id=\"inputPassword\" name=\"password\" placeholder=\"请输入密码\"\n");
      out.write("\t\t\t\t\t\t\t\t  \n");
      out.write("\t\t\t\t\t\t\t    </div>\n");
      out.write("\t\t\t\t\t\t\t  </div>\n");
      out.write("\t\t\t\t\t\t\t   <div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t\t    <label for=\"inputPassword3\" class=\"col-sm-2 control-label\">确认密码</label>\n");
      out.write("\t\t\t\t\t\t\t    <div class=\"col-sm-10\">\n");
      out.write("\t\t\t\t\t\t\t      <input type=\"text\" class=\"form-control\" id=\"inputPassword2\" name=\"password2\" placeholder=\"请输入密码\"\n");
      out.write("\t\t\t\t\t\t\t\t  \n");
      out.write("\t\t\t\t\t\t\t    </div>\n");
      out.write("\t\t\t\t\t\t\t  </div>\n");
      out.write("\t\t\t\t\t\t\t \n");
      out.write("\t\t\t\t\t\t\t  <div class=\"form-group\" style=\"text-align: center\">\n");
      out.write("\t\t\t\t\t\t\t\t<button class=\"btn btn-default\" type=\"submit\">提交</button>\n");
      out.write("\t\t\t\t\t\t\t\t<button class=\"btn btn-default\" >重置</button>\n");
      out.write("\t\t\t\t\t\t\t  </div>\n");
      out.write("\t\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t    </div>\n");
      out.write("\t\t\t\t    \n");
      out.write("\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"container\" id=\"footer\">\n");
      out.write("\t<div class=\"row\">\n");
      out.write("\t\t<div class=\"col-md-12\"></div>\n");
      out.write("\t</div>\n");
      out.write("\t</div>\n");
      out.write("</body>\n");
      out.write("\t<script type=\"text/javascript\">\n");
      out.write("\t    $(\"#nav li:nth-child(4)\").addClass(\"active\")\n");
      out.write("\t    function check() {\n");
      out.write("\t        if(reset.username.value==\"\"||reset.username.value==null)\n");
      out.write("\t        {alert(\"请输入账户名称\");return false;}\n");
      out.write("\t        if(reset.password.value==\"\"||reset.password.value==null)\n");
      out.write("\t        {alert(\"请输入重置密码\");return false;}\n");
      out.write("\t        if(reset.password2.value==\"\"||reset.password2.value==null)\n");
      out.write("\t        {alert(\"请再次输入密码\");return false;}\n");
      out.write("\t        if(reset.password.value != reset.password2.value)\n");
      out.write("\t        {alert(\"两次密码不正确\");return false;}\n");
      out.write("\t    }\n");
      out.write("\t</script>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
