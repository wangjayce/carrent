/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-09-15 10:28:20 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.system.user;

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
      out.write("/resources/zTree/css/metroStyle/metroStyle.css\" type=\"text/css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/layui/css/layui.css\" media=\"all\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/zTree/css/metroStyle/metroStyle.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/plugin/css/index.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/zTree/js/jquery-1.4.4.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/zTree/js/jquery.ztree.core.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/plugin/js/selectTree.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<form class=\"layui-form\" action=\"#\" method=\"get\" id=\"frm\" lay-filter=\"frm\">\r\n");
      out.write("\t\t<!-- \t<form class=\"layui-form  layui-form-pane\" action=\"#\" method=\"get\"> -->\r\n");
      out.write("\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">所属部门</label>\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t <div id=\"deptid\" name=\"deptid\" class=\"select-tree layui-form-select\">\r\n");
      out.write("           \t\t\t </div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">排序码</label>\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"ordernum\" id=\"ordernum\" lay-verify=\"number\"\r\n");
      out.write("\t\t\t\t\t\tautocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">领导部门</label>\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t <div id=\"leaderdeptid\" name=\"leaderdeptid\" class=\"select-tree layui-form-select\">\r\n");
      out.write("           \t\t\t </div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">领导姓名</label>\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t\t<select name=\"mgr\"  id=\"mgr\">\r\n");
      out.write("\t\t\t\t\t\t  <option value=\"\">选择领导</option>\r\n");
      out.write("\t\t\t\t\t\t</select>   \r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">用户姓名</label>\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t <input type=\"text\" name=\"name\" id=\"name\" \r\n");
      out.write("\t\t\t\t\t\tautocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">登陆账号</label>\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"loginname\" id=\"loginname\"\r\n");
      out.write("\t\t\t\t\t\tautocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t<div class=\"layui-form-item layui-form-text\">\r\n");
      out.write("\t\t\t<label class=\"layui-form-label\">用户备注</label>\r\n");
      out.write("\t\t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t<textarea placeholder=\"请输入内容\" name=\"remark\" id=\"remark\" class=\"layui-textarea\"></textarea>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">用户地址</label>\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t <input type=\"text\" name=\"address\" id=\"address\" \r\n");
      out.write("\t\t\t\t\t\tautocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">用户性别</label>\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"sex\" value=\"1\" title=\"男\" checked=\"\">\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"sex\" value=\"0\" title=\"女\" >\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">入职时间</label>\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t <input type=\"text\" name=\"hiredate\" id=\"hiredate\" \r\n");
      out.write("\t\t\t\t\t\tautocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">是否可用</label>\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"available\" value=\"1\" title=\"是\" checked=\"\">\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"available\" value=\"0\" title=\"否\" >\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t<div class=\"layui-input-block\" style=\"text-align: center;\">\r\n");
      out.write("\t\t\t\t<!--lay-submit标记当按钮是一个提交按钮   -->\r\n");
      out.write("\t\t\t\t<a class=\"layui-btn\" lay-submit=\"\" lay-filter=\"userSubmit\">提交</a>\r\n");
      out.write("\t\t\t\t<button lay-reset=\"\" class=\"layui-btn layui-btn-normal\">重置</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</form>\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/layui/layui.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t\t\r\n");
      out.write("\tvar layer;\r\n");
      out.write("\tvar form;\r\n");
      out.write("\t\r\n");
      out.write("\tlayui.use([ 'form','jquery','layer','laydate' ], function() {\r\n");
      out.write("\t\tform=layui.form;//得到form对象\r\n");
      out.write("\t\tvar $=layui.jquery;\r\n");
      out.write("\t\tvar laydate = layui.laydate;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tlaydate.render({\r\n");
      out.write("\t\t\telem:'#hiredate'\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tlayer = parent.layer === undefined ? layui.layer : parent.layer;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tform.on(\"submit(userSubmit)\",function(data){\r\n");
      out.write("\t\t\tvar params = $('#frm').serialize();\r\n");
      out.write("\t\t\t$.post('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/addUser.action',params,function(data){\r\n");
      out.write("\t\t\t\tlayer.msg(data.msg);\r\n");
      out.write("\t\t\t\tparent.tablereload();\r\n");
      out.write("\t\t\t\tvar index = layer.getFrameIndex(window.name);\r\n");
      out.write("\t\t\t\tlayer.close(index);\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t});\t\r\n");
      out.write("\t\t$('#name').on('blur',function(){\r\n");
      out.write("\t\t\tvar name = $(this).val();\r\n");
      out.write("\t\t\t$.post('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/parseFontForPinyin.action',{name:name},function(data){\r\n");
      out.write("\t\t\t\t$('#loginname').val(data);\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\tfunction initSelect(deptid){\r\n");
      out.write("\t\t$.post('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/queryAllUserByDeptId.action',{deptid:deptid},function(data){\r\n");
      out.write("\t\t\tvar html = \"\";\r\n");
      out.write("\t\t\tfor(var i=0;i<data.length;i++){\r\n");
      out.write("\t\t\t\thtml += \"<option value=\"+data[i].id+\">\"+data[i].name+\"</option>\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t$('#mgr').html(html);\r\n");
      out.write("\t\t\tform.render('select');\r\n");
      out.write("\t\t},'json');\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("    $(document).ready(function () {\t\t   \r\n");
      out.write("    \t\tinitDeptTree();\t\t    \t\r\n");
      out.write("\t  \r\n");
      out.write("    })\r\n");
      out.write("    \r\n");
      out.write("    function initDeptTree(zNodes){\r\n");
      out.write("\t\t $.post('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/dept/loadDeptTree.action',function(zNodes){\r\n");
      out.write("\t    \t initSelectTree(\"deptid\",zNodes,false);\r\n");
      out.write("\t    \t initSelectTree(\"leaderdeptid\",zNodes,false);\r\n");
      out.write("\t         $(\".layui-nav-item a\").bind(\"click\", function () {\r\n");
      out.write("\t            if (!$(this).parent().hasClass(\"layui-nav-itemed\") && !$(this).parent().parent().hasClass(\"layui-nav-child\")) {\r\n");
      out.write("\t                $(\".layui-nav-tree\").find(\".layui-nav-itemed\").removeClass(\"layui-nav-itemed\")\r\n");
      out.write("\t            }\r\n");
      out.write("\t         })\r\n");
      out.write("\t\t  });\r\n");
      out.write("    }\r\n");
      out.write("\t\r\n");
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