/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-09-20 04:04:49 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.business.inport;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class inportRight_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<meta charset=\"utf-8\">\r\n");
      out.write("\t<title>进货单管理列表</title>\r\n");
      out.write("\t<meta name=\"renderer\" content=\"webkit\">\r\n");
      out.write("\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\r\n");
      out.write("\t<meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\">\r\n");
      out.write("\t<meta name=\"apple-mobile-web-app-capable\" content=\"yes\">\r\n");
      out.write("\t<meta name=\"format-detection\" content=\"telephone=no\">\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/layui/css/layui.css\" media=\"all\" />\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/css/public.css\" media=\"all\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"childrenBody\">\r\n");
      out.write("\r\n");
      out.write("<fieldset class=\"layui-elem-field layui-field-title\" style=\"margin-top: 20px;\">\r\n");
      out.write("  <legend>查询条件</legend>\r\n");
      out.write("</fieldset> \r\n");
      out.write("\t<form class=\"layui-form\" method=\"post\" id=\"searchForm\">\r\n");
      out.write("\t\t  <div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t    <div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t      <label class=\"layui-form-label\">商品名称</label>\r\n");
      out.write("\t\t\t\t      <div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t        <input type=\"text\" name=\"goodsname\" id=\"goodsname\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t      </div>\r\n");
      out.write("\t\t\t    </div>\r\n");
      out.write("\t\t\t    <div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t      <label class=\"layui-form-label\">供应商名称</label>\r\n");
      out.write("\t\t\t\t      <div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t        <input type=\"text\" name=\"providername\" id=\"providername\"   autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t      </div>\r\n");
      out.write("\t\t\t    </div>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t  <div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t    <div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t      <label class=\"layui-form-label\">起始时间</label>\r\n");
      out.write("\t\t\t\t      <div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t        <input type=\"text\" name=\"startDate\" id=\"startDate\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t      </div>\r\n");
      out.write("\t\t\t    </div>\r\n");
      out.write("\t\t\t    <div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t      <label class=\"layui-form-label\">结束时间</label>\r\n");
      out.write("\t\t\t\t      <div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t        <input type=\"text\" name=\"endDate\" id=\"endDate\"   autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t      </div>\r\n");
      out.write("\t\t\t    </div>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t    \r\n");
      out.write("\t\t  <div class=\"layui-form-item\" style=\"text-align: center\">\r\n");
      out.write("\t    \t   <a href=\"javascript:void(0)\" class=\"search_btn layui-btn\" >查询</a>\r\n");
      out.write("\t    \t   <button type=\"reset\" class=\"layui-btn layui-btn-warm\">重置</button>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<table id=\"inportList\" lay-filter=\"inportList\"></table>\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\t<!--操作-->\r\n");
      out.write("\t<script type=\"text/html\" id=\"inportListBar\">\r\n");
      out.write("\t\t<a class=\"layui-btn layui-btn-xs layui-btn-warm\" lay-event=\"update\">修改</a>\r\n");
      out.write("\t\t<a class=\"layui-btn layui-btn-xs layui-btn-danger\" lay-event=\"del\">删除</a>\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<!--操作-->\r\n");
      out.write("\t<script type=\"text/html\" id=\"tabletoorbar\">\r\n");
      out.write("\t\t<button class=\"layui-btn layui-btn-sm\" lay-event=\"add\">添加</button>\r\n");
      out.write("\t\t<button class=\"layui-btn layui-btn-danger layui-btn-sm\" lay-event=\"batchDelet\">批量删除</button>\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/layui/layui.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/zTree/js/jquery-1.4.4.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\tvar tableIns;\r\n");
      out.write("\tfunction tablereload(id){\r\n");
      out.write("\t\ttableIns.reload({\r\n");
      out.write("\t\t\t  page: {\r\n");
      out.write("                  curr: 1 //重新从第 1 页开始\r\n");
      out.write("              },\r\n");
      out.write("              where: {\r\n");
      out.write("                goodsname: $(\"#goodsname\").val() ,\r\n");
      out.write("                providername: $(\"#providername\").val(),\r\n");
      out.write("                startDate : $(\"#startDate\").val(),\r\n");
      out.write("                endDate : $(\"#endDate\").val(),\r\n");
      out.write("                providerid : id,\r\n");
      out.write("              }\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("    layui.use(['form','layer','laydate','table'],function(){\r\n");
      out.write("    var form = layui.form,\r\n");
      out.write("        layer = parent.layer === undefined ? layui.layer : top.layer,\r\n");
      out.write("        $ = layui.jquery,\r\n");
      out.write("        laydate = layui.laydate,\r\n");
      out.write("        table = layui.table;\r\n");
      out.write("\r\n");
      out.write("\t   laydate.render({\r\n");
      out.write("\t\t   elem : '#endDate'\r\n");
      out.write("\t   });\r\n");
      out.write("\t   laydate.render({\r\n");
      out.write("\t\t   elem : '#startDate'\r\n");
      out.write("\t   });\r\n");
      out.write("\t    \r\n");
      out.write("\t    //进货单列表\r\n");
      out.write("\t    tableIns = table.render({\r\n");
      out.write("\t        elem: '#inportList',\r\n");
      out.write("\t        url : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/inport/uploadAllInport.action',\r\n");
      out.write("\t        cellMinWidth : 95,\r\n");
      out.write("\t        page : true,\r\n");
      out.write("\t        height : \"full-225\",\r\n");
      out.write("\t        limit : 10,\r\n");
      out.write("\t        limits : [10,15,20,25],\r\n");
      out.write("\t\t\ttoolbar:'#tabletoorbar',\r\n");
      out.write("\t        id : \"inportList\",\r\n");
      out.write("\t        cols : [[\r\n");
      out.write("\t            {type: \"checkbox\", fixed:\"left\", width:50},\r\n");
      out.write("\t            {field: 'id', title: '进货单ID', width:100, align:\"center\"},\r\n");
      out.write("\t            {field: 'paytype', title: '支付方式', width:100, align:\"center\"},\r\n");
      out.write("\t            {field: 'goodsname', title: '商品名称', width:100, align:\"center\"},\r\n");
      out.write("\t            {field: 'providername', title: '供应商', width:140, align:\"center\"},\r\n");
      out.write("\t            {field: 'inportprice', title: '进货价格', align:'center'},\r\n");
      out.write("\t            {field: 'inporttime', title: '进货时间', width:140, align:\"center\"},\r\n");
      out.write("\t            {field: 'operateperson', title: '操作人',width:100, align:'center'},\r\n");
      out.write("\t            {field: 'number', title: '进货数量', align:'center'},\r\n");
      out.write("\t            {field: 'remark', title: '备注', align:'center'},\r\n");
      out.write("\t            {title: '操作', width:170, templet:'#inportListBar',fixed:\"right\",align:\"center\"}\r\n");
      out.write("\t        ]]\r\n");
      out.write("\t    });\r\n");
      out.write("\t\r\n");
      out.write("        //监听头工具栏事件\r\n");
      out.write("        table.on('toolbar(inportList)', function(obj){\r\n");
      out.write("            switch(obj.event){\r\n");
      out.write("                case 'batchDelet':\r\n");
      out.write("\t\t            var checkStatus = table.checkStatus(obj.config.id),\r\n");
      out.write("\t\t            data = checkStatus.data; //获取选中的数据\r\n");
      out.write("                \tvar ids=\"?a=1\";\r\n");
      out.write("                \t if(data.length > 0) {\r\n");
      out.write(" \t                    for (var i in data) {\r\n");
      out.write(" \t                    \tids+=\"&ids=\"+data[i].id;\r\n");
      out.write(" \t                    }\r\n");
      out.write(" \t                    layer.confirm('确定删除选中的进货单？', {icon: 3, title: '提示信息'}, function (index) {\r\n");
      out.write(" \t                         $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/inport/deleteInport.action\"+ids,function(data){\r\n");
      out.write(" \t                        \tlayer.msg(data.msg);\r\n");
      out.write(" \t                        \ttableIns.reload();\r\n");
      out.write(" \t                        \tlayer.close(index);\r\n");
      out.write(" \t                         })\r\n");
      out.write(" \t                    })\r\n");
      out.write(" \t                }else{\r\n");
      out.write(" \t                    layer.msg(\"请选择需要删除的进货单\");\r\n");
      out.write(" \t                }\r\n");
      out.write("                    break;\r\n");
      out.write("                case 'add':\r\n");
      out.write("                \taddInport();\r\n");
      out.write("                \tbreak;\r\n");
      out.write("            };\r\n");
      out.write("        });\r\n");
      out.write("        function addInport(){\r\n");
      out.write("        \tlayer.open({\r\n");
      out.write("      \t\t  type: 2, \r\n");
      out.write("      \t\t  title:'添加进货单',\r\n");
      out.write("      \t\t  content: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/inport/toaddInport.action', //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']\r\n");
      out.write("      \t\t  area : ['800px','600px']\r\n");
      out.write("        \t}); \r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        function updateInport(id){\r\n");
      out.write("        \tlayer.open({\r\n");
      out.write("      \t\t  type: 2, \r\n");
      out.write("      \t\t  title:'修改进货单',\r\n");
      out.write("      \t\t  content: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/inport/toupdateInport.action?id='+id, //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']\r\n");
      out.write("      \t\t  area : ['800px','600px']\r\n");
      out.write("        \t}); \r\n");
      out.write("        }\r\n");
      out.write("\t\r\n");
      out.write("\t   \r\n");
      out.write("\t\r\n");
      out.write("\t    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】\r\n");
      out.write("\t    $(\".search_btn\").on(\"click\",function(){\r\n");
      out.write("\t    \t\ttablereload();\r\n");
      out.write("\t    });\r\n");
      out.write("\t\r\n");
      out.write("\t  \r\n");
      out.write("\t    //列表操作\r\n");
      out.write("\t    table.on('tool(inportList)', function(obj){\r\n");
      out.write("\t        var layEvent = obj.event,\r\n");
      out.write("\t            data = obj.data;\r\n");
      out.write("\t        if(layEvent === 'update'){\r\n");
      out.write("\t        \tupdateInport(data.id);\r\n");
      out.write("\t        }\r\n");
      out.write("\t\t\tif(layEvent === 'del'){ //删除\r\n");
      out.write("\t            layer.confirm('确定删除此进货单？',{icon:3, title:'提示信息'},function(index){\r\n");
      out.write("\t                $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/inport/deleteInport.action\",{\r\n");
      out.write("\t                     id : data.id  //将需要删除的Id作为参数传入\r\n");
      out.write("\t                },function(data){\t\t         \r\n");
      out.write("\t\t                tableIns.reload();\r\n");
      out.write("\t\t                layer.msg(data.msg);\r\n");
      out.write("\t\t                layer.close(index);\r\n");
      out.write("\t                })\r\n");
      out.write("\t            });\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t    });\r\n");
      out.write("\t\r\n");
      out.write("\t })\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
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
