/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-09-17 12:59:17 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.business.outport;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addOutport_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>退货管理菜单</title>\r\n");
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
      out.write("\t\t<div class=\"layui-form-item\" style=\"margin-top: 20px\">\r\n");
      out.write("\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">选择供应商</label>\r\n");
      out.write("\t\t\t    <div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t      <select name=\"providerid\" id=\"providerid\" lay-filter=\"providerid\">\r\n");
      out.write("\t\t\t        <option value=\"\">请选择供应商</option>\r\n");
      out.write("\t\t\t        ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t      </select>\r\n");
      out.write("\t\t\t    </div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">商品名称</label>\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t <select name=\"goodsid\" id=\"goodsid\" lay-filter=\"aihao\">\r\n");
      out.write("\t\t\t\t\t        <option value=\"\">请选择商品</option>\r\n");
      out.write("\t\t\t\t      </select>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t<label class=\"layui-form-label\">退货数量</label>\r\n");
      out.write("\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"number\" id=\"number\" lay-verify=\"number\"\r\n");
      out.write("\t\t\t\t\t\tautocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">退货价格</label>\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"outportprice\" id=\"outportprice\" lay-verify=\"number\"\r\n");
      out.write("\t\t\t\t\t\tautocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t\t<label class=\"layui-form-label\">支付方式</label>\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"radio\" name=\"paytype\" value=\"支付宝\" title=\"支付宝\" checked=\"\"> \r\n");
      out.write("\t\t\t\t\t\t<input type=\"radio\" name=\"paytype\" value=\"微信\" title=\"微信\" >\r\n");
      out.write("\t\t\t\t\t\t<input type=\"radio\" name=\"paytype\" value=\"银联\" title=\"银联\" >\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t<label class=\"layui-form-label\">退货备注</label>\r\n");
      out.write("\t\t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t<textarea rows=\"5\" cols=\"80%\" name=\"remark\"></textarea>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t<div class=\"layui-input-block\" style=\"text-align: center;\">\r\n");
      out.write("\t\t\t\t<!--lay-submit标记当按钮是一个提交按钮   -->\r\n");
      out.write("\t\t\t\t<a class=\"layui-btn\" lay-submit=\"\" lay-filter=\"outportSubmit\">提交</a>\r\n");
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
      out.write("\tlayui.use([ 'form','jquery','layer' ], function() {\r\n");
      out.write("\t\tvar form=layui.form;//得到form对象\r\n");
      out.write("\t\tvar $=layui.jquery;\r\n");
      out.write("\t\tvar layer = parent.layer === undefined ? layui.layer : parent.layer;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tform.on(\"submit(outportSubmit)\",function(data){\r\n");
      out.write("\t\t\tvar params = $('#frm').serialize();\r\n");
      out.write("\t\t\t$.post('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/outport/addOutport.action',params,function(data){\r\n");
      out.write("\t\t\t\tlayer.msg(data.msg);\r\n");
      out.write("\t\t\t\tparent.tablereload();\r\n");
      out.write("\t\t\t\tvar index = layer.getFrameIndex(window.name);\r\n");
      out.write("\t\t\t\tlayer.close(index);\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t});\t\t\r\n");
      out.write("\r\n");
      out.write("\t   form.on('select(providerid)', function(data){\r\n");
      out.write("\t    \t  \tvar providerid = data.value;\r\n");
      out.write("\t    \t  \t$.post('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/goods/queryGoodsByPid.action',{providerid:providerid},function(data){\r\n");
      out.write("\t    \t  \t\tvar html = \"\";\r\n");
      out.write("\t    \t\t\tfor(var i=0;i<data.length;i++){\r\n");
      out.write("\t    \t\t\t\thtml += \"<option value=\"+data[i].id+\">\"+data[i].goodsname+\"</option>\";\r\n");
      out.write("\t    \t\t\t}\r\n");
      out.write("\t    \t\t\t$('#goodsid').html(html);\r\n");
      out.write("\t    \t\t\tform.render('select');\r\n");
      out.write("\t    \t  \t},'json');\r\n");
      out.write("\t    \t});\r\n");
      out.write("\t    \r\n");
      out.write("\t});\r\n");
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

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/view/business/outport/addOutport.jsp(26,11) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("sn");
    // /WEB-INF/view/business/outport/addOutport.jsp(26,11) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/view/business/outport/addOutport.jsp(26,11) '${list }'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${list }",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t        <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sn.id }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write('"');
          out.write(' ');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sn.providername }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</option>\r\n");
          out.write("\t\t\t        ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}
