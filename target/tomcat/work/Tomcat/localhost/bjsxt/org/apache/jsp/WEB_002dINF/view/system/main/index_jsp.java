/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-09-25 01:00:48 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.system.main;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<title>华城库存管理系统</title>\r\n");
      out.write("\t<meta name=\"renderer\" content=\"webkit\">\r\n");
      out.write("\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("\t<meta http-equiv=\"Access-Control-Allow-Origin\" content=\"*\">\r\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\r\n");
      out.write("\t<meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\">\r\n");
      out.write("\t<meta name=\"apple-mobile-web-app-capable\" content=\"yes\">\r\n");
      out.write("\t<meta name=\"format-detection\" content=\"telephone=no\">\r\n");
      out.write("\t<link rel=\"icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/favicon.ico\">\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/layui/css/layui.css\" media=\"all\" />\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/css/index.css\" media=\"all\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"main_body\">\r\n");
      out.write("\t<div class=\"layui-layout layui-layout-admin\">\r\n");
      out.write("\t\t<!-- 顶部 -->\r\n");
      out.write("\t\t<div class=\"layui-header header\">\r\n");
      out.write("\t\t\t<div class=\"layui-main mag0\">\r\n");
      out.write("\t\t\t\t<a href=\"#\" class=\"logo\">库存管理系统</a>\r\n");
      out.write("\t\t\t\t<!-- 显示/隐藏菜单 -->\r\n");
      out.write("\t\t\t\t<a href=\"javascript:;\" class=\"seraph hideMenu icon-caidan\"></a>\r\n");
      out.write("\r\n");
      out.write("\t\t\t    <!-- 顶部右侧菜单 -->\r\n");
      out.write("\t\t\t    <ul class=\"layui-nav top_menu\">\r\n");
      out.write("\t\t\t\t\t<li class=\"layui-nav-item\" pc>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:;\" class=\"clearCache\"><i class=\"layui-icon\" data-icon=\"&#xe640;\">&#xe640;</i><cite>清除缓存</cite><span class=\"layui-badge-dot\"></span></a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li class=\"layui-nav-item lockcms\" pc>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:;\"><i class=\"seraph icon-lock\"></i><cite>锁屏</cite></a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li class=\"layui-nav-item\" id=\"userInfo\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:;\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.imgpath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"layui-nav-img userAvatar\" width=\"35\" height=\"35\"><cite class=\"adminName\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.name }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</cite></a>\r\n");
      out.write("\t\t\t\t\t\t<dl class=\"layui-nav-child\">\r\n");
      out.write("\t\t\t\t\t\t\t<dd><a href=\"javascript:;\" data-url=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/page/user/userInfo.html\"><i class=\"seraph icon-ziliao\" data-icon=\"icon-ziliao\"></i><cite>个人资料</cite></a></dd>\r\n");
      out.write("\t\t\t\t\t\t\t<dd><a href=\"javascript:;\" data-url=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/page/user/changePwd.html\"><i class=\"seraph icon-xiugai\" data-icon=\"icon-xiugai\"></i><cite>修改密码</cite></a></dd>\r\n");
      out.write("\t\t\t\t\t\t\t<dd pc><a href=\"javascript:;\" class=\"functionSetting\"><i class=\"layui-icon\">&#xe620;</i><cite>功能设定</cite><span class=\"layui-badge-dot\"></span></a></dd>\r\n");
      out.write("\t\t\t\t\t\t\t<dd pc><a href=\"javascript:;\" class=\"changeSkin\"><i class=\"layui-icon\">&#xe61b;</i><cite>更换皮肤</cite></a></dd>\r\n");
      out.write("\t\t\t\t\t\t\t<dd><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/login/logout.action\" class=\"signOut\"><i class=\"seraph icon-tuichu\"></i><cite>退出</cite></a></dd>\r\n");
      out.write("\t\t\t\t\t\t</dl>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- 左侧导航 -->\r\n");
      out.write("\t\t<div class=\"layui-side layui-bg-black\">\r\n");
      out.write("\t\t\t<div class=\"user-photo\">\r\n");
      out.write("\t\t\t\t<a class=\"img\" title=\"我的头像\" ><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.imgpath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"userAvatar\"></a>\r\n");
      out.write("\t\t\t\t<p>你好！<span class=\"userName\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.name }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span>, 欢迎登录</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- 搜索 -->\r\n");
      out.write("\t\t\t<div class=\"layui-form component\">\r\n");
      out.write("\t\t\t\t<select name=\"search\" id=\"search\" lay-search lay-filter=\"searchPage\">\r\n");
      out.write("\t\t\t\t\t<option value=\"\">搜索页面或功能</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"1\">layer</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"2\">form</option>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t<i class=\"layui-icon\">&#xe615;</i>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"navBar layui-side-scroll\" id=\"navBar\">\r\n");
      out.write("\t\t\t\t<ul class=\"layui-nav layui-nav-tree\">\r\n");
      out.write("\t\t\t\t\t<li class=\"layui-nav-item layui-this\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:;\" data-url=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/desk/toDeskManager.action\"><i class=\"layui-icon\" data-icon=\"\"></i><cite>后台首页</cite></a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- 右侧内容 -->\r\n");
      out.write("\t\t<div class=\"layui-body layui-form\">\r\n");
      out.write("\t\t\t<div class=\"layui-tab mag0\" lay-filter=\"bodyTab\" id=\"top_tabs_box\">\r\n");
      out.write("\t\t\t\t<ul class=\"layui-tab-title top_tab\" id=\"top_tabs\">\r\n");
      out.write("\t\t\t\t\t<li class=\"layui-this\" lay-id=\"\"><i class=\"layui-icon\">&#xe68e;</i> <cite>后台首页</cite></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t<ul class=\"layui-nav closeBox\">\r\n");
      out.write("\t\t\t\t  <li class=\"layui-nav-item\">\r\n");
      out.write("\t\t\t\t    <a href=\"javascript:;\"><i class=\"layui-icon caozuo\">&#xe643;</i> 页面操作</a>\r\n");
      out.write("\t\t\t\t    <dl class=\"layui-nav-child\">\r\n");
      out.write("\t\t\t\t\t  <dd><a href=\"javascript:;\" class=\"refresh refreshThis\"><i class=\"layui-icon\">&#x1002;</i> 刷新当前</a></dd>\r\n");
      out.write("\t\t\t\t      <dd><a href=\"javascript:;\" class=\"closePageOther\"><i class=\"seraph icon-prohibit\"></i> 关闭其他</a></dd>\r\n");
      out.write("\t\t\t\t      <dd><a href=\"javascript:;\" class=\"closePageAll\"><i class=\"seraph icon-guanbi\"></i> 关闭全部</a></dd>\r\n");
      out.write("\t\t\t\t    </dl>\r\n");
      out.write("\t\t\t\t  </li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t<div class=\"layui-tab-content clildFrame\">\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-tab-item layui-show\">\r\n");
      out.write("\t\t\t\t\t\t<iframe src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/desk/toDeskManager.action\"></iframe>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- 底部 -->\r\n");
      out.write("\t\t<div class=\"layui-footer footer\">\r\n");
      out.write("\t\t\t<p><span>copyright @2018 驊驊龔頾</span>　　<a onclick=\"donation()\" class=\"layui-btn layui-btn-danger layui-btn-sm\">捐赠作者</a></p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<!-- 移动导航 -->\r\n");
      out.write("\t<div class=\"site-tree-mobile\"><i class=\"layui-icon\">&#xe602;</i></div>\r\n");
      out.write("\t<div class=\"site-mobile-shade\"></div>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/layui/layui.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/js/cache.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("        var $,tab,dataStr,layer;\r\n");
      out.write("        layui.config({\r\n");
      out.write("            base : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/js/\"\r\n");
      out.write("        }).extend({\r\n");
      out.write("            \"bodyTab\" : \"bodyTab\"\r\n");
      out.write("        })\r\n");
      out.write("        layui.use(['bodyTab','form','element','layer','jquery'],function(){\r\n");
      out.write("            var form = layui.form,\r\n");
      out.write("                element = layui.element;\r\n");
      out.write("            $ = layui.$;\r\n");
      out.write("            layer = parent.layer === undefined ? layui.layer : top.layer;\r\n");
      out.write("            tab = layui.bodyTab({\r\n");
      out.write("                openTabNum : \"50\",  //最大可打开窗口数量\r\n");
      out.write("                url : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/login/loadIndexTree.action\" //获取菜单json地址\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("            //通过顶部菜单获取左侧二三级菜单   注：此处只做演示之用，实际开发中通过接口传参的方式获取导航数据\r\n");
      out.write("            function getData(json){\r\n");
      out.write("                $.getJSON(tab.tabConfig.url,function(data){\r\n");
      out.write("\r\n");
      out.write("                        dataStr = data;\r\n");
      out.write("                        //重新渲染左侧菜单\r\n");
      out.write("                        tab.render();\r\n");
      out.write("                })\r\n");
      out.write("            }\r\n");
      out.write("            //页面加载时判断左侧菜单是否显示\r\n");
      out.write("            //通过顶部菜单获取左侧菜单\r\n");
      out.write("            $(\".topLevelMenus li,.mobileTopLevelMenus dd\").click(function(){\r\n");
      out.write("                if($(this).parents(\".mobileTopLevelMenus\").length != \"0\"){\r\n");
      out.write("                    $(\".topLevelMenus li\").eq($(this).index()).addClass(\"layui-this\").siblings().removeClass(\"layui-this\");\r\n");
      out.write("                }else{\r\n");
      out.write("                    $(\".mobileTopLevelMenus dd\").eq($(this).index()).addClass(\"layui-this\").siblings().removeClass(\"layui-this\");\r\n");
      out.write("                }\r\n");
      out.write("                $(\".layui-layout-admin\").removeClass(\"showMenu\");\r\n");
      out.write("                $(\"body\").addClass(\"site-mobile\");\r\n");
      out.write("                getData($(this).data(\"menu\"));\r\n");
      out.write("                //渲染顶部窗口\r\n");
      out.write("                tab.tabMove();\r\n");
      out.write("            })\r\n");
      out.write("\r\n");
      out.write("            //隐藏左侧导航\r\n");
      out.write("            $(\".hideMenu\").click(function(){\r\n");
      out.write("                if($(\".topLevelMenus li.layui-this a\").data(\"url\")){\r\n");
      out.write("                    layer.msg(\"此栏目状态下左侧菜单不可展开\");  //主要为了避免左侧显示的内容与顶部菜单不匹配\r\n");
      out.write("                    return false;\r\n");
      out.write("                }\r\n");
      out.write("                $(\".layui-layout-admin\").toggleClass(\"showMenu\");\r\n");
      out.write("                //渲染顶部窗口\r\n");
      out.write("                tab.tabMove();\r\n");
      out.write("            })\r\n");
      out.write("\r\n");
      out.write("            //通过顶部菜单获取左侧二三级菜单   注：此处只做演示之用，实际开发中通过接口传参的方式获取导航数据\r\n");
      out.write("            getData(\"contentManagement\");\r\n");
      out.write("\r\n");
      out.write("            //手机设备的简单适配\r\n");
      out.write("            $('.site-tree-mobile').on('click', function(){\r\n");
      out.write("                $('body').addClass('site-mobile');\r\n");
      out.write("            });\r\n");
      out.write("            $('.site-mobile-shade').on('click', function(){\r\n");
      out.write("                $('body').removeClass('site-mobile');\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("            // 添加新窗口\r\n");
      out.write("            $(\"body\").on(\"click\",\".layui-nav .layui-nav-item a:not('.mobileTopLevelMenus .layui-nav-item a')\",function(){\r\n");
      out.write("                //如果不存在子级\r\n");
      out.write("                if($(this).siblings().length == 0){\r\n");
      out.write("                    addTab($(this));\r\n");
      out.write("                    $('body').removeClass('site-mobile');  //移动端点击菜单关闭菜单层\r\n");
      out.write("                }\r\n");
      out.write("                $(this).parent(\"li\").siblings().removeClass(\"layui-nav-itemed\");\r\n");
      out.write("            })\r\n");
      out.write("\r\n");
      out.write("            //清除缓存\r\n");
      out.write("            $(\".clearCache\").click(function(){\r\n");
      out.write("                window.sessionStorage.clear();\r\n");
      out.write("                window.localStorage.clear();\r\n");
      out.write("                var index = layer.msg('清除缓存中，请稍候',{icon: 16,time:false,shade:0.8});\r\n");
      out.write("                setTimeout(function(){\r\n");
      out.write("                    layer.close(index);\r\n");
      out.write("                    layer.msg(\"缓存清除成功！\");\r\n");
      out.write("                },1000);\r\n");
      out.write("            })\r\n");
      out.write("\r\n");
      out.write("            //刷新后还原打开的窗口\r\n");
      out.write("            if(cacheStr == \"true\") {\r\n");
      out.write("                if (window.sessionStorage.getItem(\"menu\") != null) {\r\n");
      out.write("                    menu = JSON.parse(window.sessionStorage.getItem(\"menu\"));\r\n");
      out.write("                    curmenu = window.sessionStorage.getItem(\"curmenu\");\r\n");
      out.write("                    var openTitle = '';\r\n");
      out.write("                    for (var i = 0; i < menu.length; i++) {\r\n");
      out.write("                        openTitle = '';\r\n");
      out.write("                        if (menu[i].icon) {\r\n");
      out.write("                            if (menu[i].icon.split(\"-\")[0] == 'icon') {\r\n");
      out.write("                                openTitle += '<i class=\"seraph ' + menu[i].icon + '\"></i>';\r\n");
      out.write("                            } else {\r\n");
      out.write("                                openTitle += '<i class=\"layui-icon\">' + menu[i].icon + '</i>';\r\n");
      out.write("                            }\r\n");
      out.write("                        }\r\n");
      out.write("                        openTitle += '<cite>' + menu[i].title + '</cite>';\r\n");
      out.write("                        openTitle += '<i class=\"layui-icon layui-unselect layui-tab-close\" data-id=\"' + menu[i].layId + '\">&#x1006;</i>';\r\n");
      out.write("                        element.tabAdd(\"bodyTab\", {\r\n");
      out.write("                            title: openTitle,\r\n");
      out.write("                            content: \"<iframe src='\" + menu[i].href + \"' data-id='\" + menu[i].layId + \"'></frame>\",\r\n");
      out.write("                            id: menu[i].layId\r\n");
      out.write("                        })\r\n");
      out.write("                        //定位到刷新前的窗口\r\n");
      out.write("                        if (curmenu != \"undefined\") {\r\n");
      out.write("                            if (curmenu == '' || curmenu == \"null\") {  //定位到后台首页\r\n");
      out.write("                                element.tabChange(\"bodyTab\", '');\r\n");
      out.write("                            } else if (JSON.parse(curmenu).title == menu[i].title) {  //定位到刷新前的页面\r\n");
      out.write("                                element.tabChange(\"bodyTab\", menu[i].layId);\r\n");
      out.write("                            }\r\n");
      out.write("                        } else {\r\n");
      out.write("                            element.tabChange(\"bodyTab\", menu[menu.length - 1].layId);\r\n");
      out.write("                        }\r\n");
      out.write("                    }\r\n");
      out.write("                    //渲染顶部窗口\r\n");
      out.write("                    tab.tabMove();\r\n");
      out.write("                }\r\n");
      out.write("            }else{\r\n");
      out.write("                window.sessionStorage.removeItem(\"menu\");\r\n");
      out.write("                window.sessionStorage.removeItem(\"curmenu\");\r\n");
      out.write("            }\r\n");
      out.write("        })\r\n");
      out.write("\r\n");
      out.write("        //打开新窗口\r\n");
      out.write("        function addTab(_this){\r\n");
      out.write("            tab.tabAdd(_this);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        //捐赠弹窗\r\n");
      out.write("        function donation(){\r\n");
      out.write("            layer.tab({\r\n");
      out.write("                area : ['260px', '367px'],\r\n");
      out.write("                tab : [{\r\n");
      out.write("                    title : \"微信\",\r\n");
      out.write("                    content : \"<div style='padding:30px;overflow:hidden;background:#d2d0d0;'><img src='images/wechat.jpg'></div>\"\r\n");
      out.write("                },{\r\n");
      out.write("                    title : \"支付宝\",\r\n");
      out.write("                    content : \"<div style='padding:30px;overflow:hidden;background:#d2d0d0;'><img src='images/alipay.jpg'></div>\"\r\n");
      out.write("                }]\r\n");
      out.write("            })\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        //图片管理弹窗\r\n");
      out.write("        function showImg(){\r\n");
      out.write("            $.getJSON('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/json/images.json', function(json){\r\n");
      out.write("                var res = json;\r\n");
      out.write("                layer.photos({\r\n");
      out.write("                    photos: res,\r\n");
      out.write("                    anim: 5\r\n");
      out.write("                });\r\n");
      out.write("            });\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("\t</script>\r\n");
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
