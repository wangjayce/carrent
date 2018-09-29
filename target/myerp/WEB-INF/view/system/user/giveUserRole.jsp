<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>用户管理-分配角色</title>
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
	
	<table id="roleList" lay-filter="roleList"></table>
	

	<!--操作-->
	<script type="text/html" id="tabletoorbar">
		<button class="layui-btn layui-btn-normal layui-btn-sm" lay-event="save">保存</button>
	</script>

<script type="text/javascript" src="${ctx }/resources/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/resources/zTree/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
	
	
    layui.use(['layer','table','jquery'],function(){
	  	  var form = layui.form,
		        layer =layui.layer,
		        $ = layui.jquery,
		        table = layui.table;		    
			    
			    //角色列表
			  var  tableIns = table.render({
			        elem: '#roleList',
			        url : '${ctx}/user/uploadAllRole.action?id=${userVo.id}',
			        cellMinWidth : 95,
			        height : "full-225",
					toolbar:'#tabletoorbar',
			        id : "roleList",
			        cols : [[
			            {type: "checkbox", fixed:"left", width:50},
			            {field: 'id', title: '角色ID', width:160, align:"center"},
			            {field: 'name', title: '角色名称', align:"center"},
			            {field: 'remark', title: '角色备注', width:350, align:"center"}
			        ]]
			    });
			
	        //监听头工具栏事件
	        table.on('toolbar(roleList)', function(obj){
	            switch(obj.event){
	                case 'save':
			            var checkStatus = table.checkStatus(obj.config.id),
			            data = checkStatus.data; //获取选中的数据
	                	var ids="?id=${userVo.id}";
	 	                    for (var i in data) {
	 	                    	ids+="&ids="+data[i].id;
	 	                    }
	 	                    layer.confirm('确定分配选中的角色？', {icon: 3, title: '提示信息'}, function (index) {
	 	                         $.post("${ctx}/user/saveUserRole.action"+ids,function(obj){
	 	                        	layer.msg(obj.msg);
	 	                         })
	 	                    })
	            };
	        });
	
	 })
</script>
</body>
</html>