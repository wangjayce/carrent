/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-09-14 02:35:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.system.notice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class detailNotice_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>部门管理菜单</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/layui/css/layui.css\" media=\"all\" />\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<form class=\"layui-form\" action=\"#\" method=\"get\" id=\"frm\" lay-filter=\"frm\">\r\n");
      out.write("\t\t<!-- \t<form class=\"layui-form  layui-form-pane\" action=\"#\" method=\"get\"> -->\r\n");
      out.write("\t\t<div class=\"layui-form-item\" style=\"margin-top: 10px\">\r\n");
      out.write("\t\t\t<label class=\"layui-form-label\">公告标题</label>\r\n");
      out.write("\t\t\t<div class=\"layui-input-block\" style=\"width: 80%\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" readonly=\"readonly\" name=\"title\" id=\"title\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${notice.title }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" lay-verify=\"required\" autocomplete=\"off\"\r\n");
      out.write("\t\t\t\t\tclass=\"layui-input\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-form-item layui-form-text\">\r\n");
      out.write("\t\t\t<label class=\"layui-form-label\">公告内容</label>\r\n");
      out.write("\t\t\t<textarea id=\"notice\" readonly=\"readonly\" name=\"content\" style=\"width: 80%;height: 300px\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${notice.content }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\r\n");
      out.write("\t\t</div>\t\t\r\n");
      out.write("\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t<div class=\"layui-input-block\" style=\"text-align: center;width: 70%\">\r\n");
      out.write("\t\t\t\t<!--lay-submit标记当按钮是一个提交按钮   -->\r\n");
      out.write("\t\t\t\t<a class=\"layui-btn\" lay-submit=\"\" lay-filter=\"noticeSubmit\" style=\"float: right\">关闭</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</form>\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/layui/layui.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/zTree/js/jquery-1.4.4.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tlayui.use([ 'form','jquery','layer','layedit'], function() {\r\n");
      out.write("\t\tvar form=layui.form;//得到form对象\r\n");
      out.write("\t\tvar $=layui.jquery;\r\n");
      out.write("\t\tvar layedit = layui.layedit;\r\n");
      out.write("\t\tvar layer = parent.layer === undefined ? layui.layer : parent.layer;\r\n");
      out.write("\t\tlayedit.set({\r\n");
      out.write("\t\t\t  uploadImage: {\r\n");
      out.write("\t\t\t    url: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/notice/uploadimage.action' //接口url\r\n");
      out.write("\t\t\t    ,type: 'post' //默认post\r\n");
      out.write("\t\t\t  }\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\tvar editIndex = layedit.build('notice'); //建立编辑器\r\n");
      out.write("\t\tlayedit.sync(editIndex);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tform.on(\"submit(noticeSubmit)\",function(data){\r\n");
      out.write("\t\t\tvar index = layer.getFrameIndex(window.name);\r\n");
      out.write("\t\t\tlayer.close(index);\r\n");
      out.write("\t\t\tparent.datareload();\r\n");
      out.write("\t\t});\t\t\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
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
