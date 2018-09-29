<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>菜单管理列表</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="${ctx }/resources/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="${ctx }/resources/css/public.css" media="all" />
</head>
<body class="childrenBody">

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>查询条件</legend>
</fieldset> 
	<form class="layui-form" method="post" id="searchForm">
		<div class="layui-form-item">
			    <div class="layui-inline">
				      <label class="layui-form-label">菜单名称</label>
				      <div class="layui-input-inline">
				        <input type="text" name="name" id="name" autocomplete="off" class="layui-input">
				      </div>
			    </div>	
			     <div class="layui-inline">
			     	 <a href="javascript:void(0)" class="search_btn layui-btn" >查询</a>
	    	 		 <button type="reset" class="layui-btn layui-btn-warm">重置</button>
			     </div>		
		  </div>
	</form>
	<table id="menuList" lay-filter="menuList"></table>
	

	<!--操作-->
	<script type="text/html" id="menuListBar">
		<a class="layui-btn layui-btn-xs layui-btn-warm" lay-event="update">修改</a>
		<a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
	</script>
	<!--操作-->
	<script type="text/html" id="tabletoorbar">
		<button class="layui-btn layui-btn-sm" lay-event="add">添加</button>
		<button class="layui-btn layui-btn-danger layui-btn-sm" lay-event="batchDelet">批量删除</button>
	</script>

<script type="text/javascript" src="${ctx }/resources/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/resources/zTree/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">

	var tableIns;
	function tablereload(id){
		tableIns.reload({
			  page: {
                  curr: 1 //重新从第 1 页开始
              },
              where: {
                name: $("#name").val() ,
                id : id
              }
		});
	}
	
    layui.use(['form','layer','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;
  
	    //菜单列表
	    tableIns = table.render({
	        elem: '#menuList',
	        url : '${ctx}/menu/uploadAllMenu.action',
	        cellMinWidth : 95,
	        page : true,
	        height : "full-225",
	        limit : 10,
	        limits : [10,15,20,25],
			toolbar:'#tabletoorbar',
	        id : "menuList",
	        cols : [[
	            {type: "checkbox", fixed:"left", width:50},
	            {field: 'id', title: '菜单ID', width:150, align:"center"},
	            {field: 'pid', title: '上级菜单ID', width:150, align:"center"},
	            {field: 'name', title: '菜单名称', width:150,align:'center'},
	            {field: 'href', title: '菜单地址',width:200, align:'center'},
	            {field: 'ordernum', title: '排序码', align:'center'},
	            {field: 'icon', title: '图标', align:'center', width:150,templet:function(data){
	            	return "<i class='layui-icon'>"+data.icon+"</i>";   
	            }},
	            {field: 'open', title: '是否展开', align:'center',templet:function(data){
	            	return data.open==1?"<font color=blue>展开</font>":"<font color=red>不展开</font>"
	            }},
	            {field: 'parent', title: '是否父节点', align:'center',templet:function(data){
	            	return data.parent==1?"<font color=blue>是</font>":"<font color=red>否</font>"
	            }},
	            {field: 'available', title: '是否父节点', align:'center',templet:function(data){
	            	return data.available==1?"<font color=blue>可用</font>":"<font color=red>不可用</font>"
	            }},
	            {title: '操作', width:170, templet:'#menuListBar',fixed:"right",align:"center"}
	        ]]
	    });
	
        //监听头工具栏事件
        table.on('toolbar(menuList)', function(obj){
        	
            switch(obj.event){
                case 'batchDelet':
		            var checkStatus = table.checkStatus(obj.config.id),
		            data = checkStatus.data; //获取选中的数据
                	var ids="?a=1";
                	 if(data.length > 0) {
 	                    for (var i in data) {
 	                    	ids+="&ids="+data[i].id;
 	                    }
 	                    layer.confirm('确定删除选中的菜单？', {icon: 3, title: '提示信息'}, function (index) {
 	                         $.post("${ctx}/menu/deleteMenu.action"+ids,function(data){
 	                        	layer.msg(data.msg);
 	                        	parent.left.initTree();
 	                        	tableIns.reload();
 	                        	layer.close(index);
 	                         })
 	                    })
 	                }else{
 	                    layer.msg("请选择需要删除的菜单");
 	                }
                    break;
                case 'add':
                	addMenu();
                	break;
            };
        });
        function addMenu(){
        	layer.open({
      		  type: 2, 
      		  title:'添加菜单',
      		  content: '${ctx}/menu/toaddMenu.action', //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
      		  area : ['800px','600px']
        	}); 
        }
        
        function updateMenu(id){
        	layer.open({
      		  type: 2, 
      		  title:'修改菜单',
      		  content: '${ctx}/menu/toupdateMenu.action?id='+id, //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
      		  area : ['800px','600px']
        	}); 
        }
	
	   
	
	    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
	    $(".search_btn").on("click",function(){
	    		tablereload(null);
	    });
	
	  
	    //列表操作
	    table.on('tool(menuList)', function(obj){
	        var layEvent = obj.event,
	            data = obj.data;
	        if(layEvent === 'update'){
	        	updateMenu(data.id);
	        }
			if(layEvent === 'del'){ //删除
	            layer.confirm('确定删除此菜单？',{icon:3, title:'提示信息'},function(index){
	                $.post("${ctx}/menu/deleteMenu.action",{
	                     id : data.id  //将需要删除的Id作为参数传入
	                },function(data){		         
		                tableIns.reload();
		                parent.left.initTree();
		                layer.msg(data.msg);
		                layer.close(index);
	                })
	            });
			}
	    });
	
	 })
</script>
</body>
</html>