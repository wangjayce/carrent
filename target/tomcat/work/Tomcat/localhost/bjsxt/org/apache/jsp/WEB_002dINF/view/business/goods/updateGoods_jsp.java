/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-09-17 06:56:16 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.business.goods;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class updateGoods_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>部门管理菜单</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/zTree/css/metroStyle/metroStyle.css\" type=\"text/css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/css/public.css\" media=\"all\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/layui/css/layui.css\" media=\"all\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/plugin/css/index.css\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t\t<form class=\"layui-form\" action=\"#\" method=\"get\" id=\"frm\" lay-filter=\"frm\">\r\n");
      out.write("\t\t<!-- \t<form class=\"layui-form  layui-form-pane\" action=\"#\" method=\"get\"> -->\r\n");
      out.write("\t\t<div class=\"layui-form-item\">\r\n");
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
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t<label class=\"layui-form-label\">商品名称</label>\r\n");
      out.write("\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"goodsname\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.goodsname }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" id=\"goodsname\" lay-verify=\"required\"\r\n");
      out.write("\t\t\t\t\t\tautocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.id }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">商品产地</label>\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"produceplace\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.produceplace }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" id=\"produceplace\" lay-verify=\"required\"\r\n");
      out.write("\t\t\t\t\t\tautocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t<label class=\"layui-form-label\">商品规格</label>\r\n");
      out.write("\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"size\" id=\"size\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.size }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" lay-verify=\"required\" autocomplete=\"off\"\r\n");
      out.write("\t\t\t\t\tclass=\"layui-input\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">商品包装</label>\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"goodspackage\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.goodspackage }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" id=\"goodspackage\" lay-verify=\"required\"\r\n");
      out.write("\t\t\t\t\t\tautocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t<label class=\"layui-form-label\">商品批号</label>\r\n");
      out.write("\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"productcode\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.productcode }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" id=\"productcode\" lay-verify=\"required\" autocomplete=\"off\"\r\n");
      out.write("\t\t\t\t\tclass=\"layui-input\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">批准文号</label>\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"promitcode\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.promitcode }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" id=\"promitcode\" lay-verify=\"required\"\r\n");
      out.write("\t\t\t\t\t\tautocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t<label class=\"layui-form-label\">参考价格</label>\r\n");
      out.write("\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"price\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.price }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" id=\"price\" lay-verify=\"number\" autocomplete=\"off\"\r\n");
      out.write("\t\t\t\t\tclass=\"layui-input\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">是否可用</label>\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"available\" value=\"1\" title=\"是\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.available==1?\"checked\":\"\" }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(">\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"available\" value=\"0\" title=\"否\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.available==0?\"checked\":\"\" }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("> \r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t<label class=\"layui-form-label\">库存</label>\r\n");
      out.write("\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"number\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.number }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" id=\"number\" lay-verify=\"number\" autocomplete=\"off\"\r\n");
      out.write("\t\t\t\t\tclass=\"layui-input\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">预警库存</label>\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"dangernum\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.dangernum }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" id=\"dangernum\" lay-verify=\"number\"\r\n");
      out.write("\t\t\t\t\t\tautocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t<label class=\"layui-form-label\">商品描述</label>\r\n");
      out.write("\t\t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t<textarea rows=\"5\" cols=\"80%\" name=\"description\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.description }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t<div class=\"layui-input-block\" style=\"text-align: center;\">\r\n");
      out.write("\t\t\t\t<!--lay-submit标记当按钮是一个提交按钮   -->\r\n");
      out.write("\t\t\t\t<a class=\"layui-btn\" lay-submit=\"\" lay-filter=\"goodsSubmit\">提交</a>\r\n");
      out.write("\t\t\t\t<button lay-reset=\"\" class=\"layui-btn layui-btn-normal\">重置</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"layui-upload\">\r\n");
      out.write("\t\t\t<button type=\"button\" class=\"layui-btn\" id=\"imgupload\">更换图片</button>\r\n");
      out.write("\t\t\t<label class=\"layui-form-label\">图片名称</label>\r\n");
      out.write("\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"imgname\" autocomplete=\"off\"\r\n");
      out.write("\t\t\t\t\tplaceholder=\"请输入图片名称\" id=\"imgname\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"goodsimg\" id=\"goodsimg\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"layui-upload-list\">\r\n");
      out.write("\t\t\t\t<img class=\"layui-upload-img\" name=\"imggoods\" id=\"imggoods\" width=\"80px\" height=\"80px\">\r\n");
      out.write("\t\t\t\t<p id=\"errorimg\"></p>\r\n");
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
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/zTree/js/jquery.ztree.core.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/plugin/js/selectTree.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tlayui.use([ 'form','jquery','layer','upload' ], function() {\r\n");
      out.write("\t\tvar form=layui.form;//得到form对象\r\n");
      out.write("\t\tvar $=layui.jquery;\r\n");
      out.write("\t\tvar layer = parent.layer === undefined ? layui.layer : parent.layer;\r\n");
      out.write("\t\tvar upload = layui.upload;\r\n");
      out.write("\t\t\r\n");
      out.write("\t    $('#imggoods').attr('src', \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.goodsimg}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar uploadInst = upload.render({\r\n");
      out.write("\t\t    elem: '#imgupload'\r\n");
      out.write("\t\t    ,url: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/upload/uploadImage.action'\r\n");
      out.write("\t\t    ,before: function(obj){\r\n");
      out.write("\t\t      //预读本地文件示例，不支持ie8\r\n");
      out.write("\t\t      obj.preview(function(index, file, result){\r\n");
      out.write("\t\t        $('#imggoods').attr('src', result); //图片链接（base64）\r\n");
      out.write("\t\t      });\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t    ,field:'mf'\r\n");
      out.write("\t\t    ,data :{\r\n");
      out.write("\t\t    \timgname : function(){\r\n");
      out.write("\t\t    \t\treturn $('#imgname').val();\r\n");
      out.write("\t\t    \t}\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t    ,done: function(res){\r\n");
      out.write("\t\t      //如果上传失败\r\n");
      out.write("\t\t      if(res.code > 0){\r\n");
      out.write("\t\t        return layer.msg('上传失败');\r\n");
      out.write("\t\t      }\r\n");
      out.write("\t\t      $('#goodsimg').val(res.data.src);\r\n");
      out.write("\t\t      //上传成功\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t    ,error: function(){\r\n");
      out.write("\t\t      //演示失败状态，并实现重传\r\n");
      out.write("\t\t      var demoText = $('#errorimg');\r\n");
      out.write("\t\t      errorimg.html('<span style=\"color: #FF5722;\">上传失败</span> <a class=\"layui-btn layui-btn-xs demo-reload\">重试</a>');\r\n");
      out.write("\t\t      errorimg.find('.demo-reload').on('click', function(){\r\n");
      out.write("\t\t        uploadInst.upload();\r\n");
      out.write("\t\t      });\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t  });\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tform.on(\"submit(goodsSubmit)\",function(data){\r\n");
      out.write("\t\t\tvar params = $('#frm').serialize();\r\n");
      out.write("\t\t\t$.post('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/goods/updateGoods.action',params,function(data){\r\n");
      out.write("\t\t\t\tlayer.msg(data.msg);\r\n");
      out.write("\t\t\t\tparent.tablereload();\r\n");
      out.write("\t\t\t\tparent.parent.left.initTree();\r\n");
      out.write("\t\t\t\tvar index = layer.getFrameIndex(window.name);\r\n");
      out.write("\t\t\t\tlayer.close(index);\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t});\t\t\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/view/business/goods/updateGoods.jsp(24,11) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("sn");
    // /WEB-INF/view/business/goods/updateGoods.jsp(24,11) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/view/business/goods/updateGoods.jsp(24,11) '${list }'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${list }",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
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
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sn.id==goods.providerid?\"selected\":\"\" }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
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
