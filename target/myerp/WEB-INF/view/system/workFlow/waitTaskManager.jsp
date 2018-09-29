<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>待办任务管理</title>
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

	<table id="taskList" lay-filter="taskList"></table>
	

	<!--操作-->
	<script type="text/html" id="taskListBar">
		<a class="layui-btn layui-btn-xs" lay-event="doTask">办理任务</a>
		<a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="viewProcessImage">查看流程图</a>
	</script>
<script type="text/javascript" src="${ctx }/resources/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/resources/zTree/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
	var tableIns;
	
    layui.use(['form','layer','laydate','table','laytpl'],function(){
	  	  var form = layui.form,
		        layer =layui.layer,
		        $ = layui.jquery,
		        table = layui.table;		    
			    
			    //任务列表
			    tableIns = table.render({
			        elem: '#taskList',
			        url : '${ctx}/workFlow/uploadAlltask.action',
			        cellMinWidth : 95,
			        page : true,
			        height : "full-125",
			        limit : 10,
			        limits : [10,15,20,25],
					toolbar:'#tabletoorbar',
			        id : "taskList",
			        cols : [[
			            {field: 'id', title: '任务ID', width:160, align:"center"},
			            {field: 'name', title: '任务名称', align:"center"},
			            {field: 'createTime', title: '创建时间', width:350, align:"center"},
			            {field: 'assignee', title: '办理人', width:350, align:"center"},
			            {title: '操作', width:200, templet:'#taskListBar',fixed:"right",align:"center"}
			        ]]
			    });
			
	    
        function doTask(id){
        	layer.open({
        		  type: 2, 
        		  title:'办理任务',
        		  content: '${ctx}/workFlow/todoTask.action?taskId='+id, //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
        		  area : ['800px','600px']
          	}); 
        }
        function viewProcessImage(id){
        	layer.open({
        		  type: 2, 
        		  title:'查看任务图',
        		  content: '${ctx}/workFlow/tocheckProcessImage.action?taskId='+id, //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
        		  area : ['1000px','600px']
          	}); 
        }
 
	    //列表操作
	    table.on('tool(taskList)', function(obj){
	        var layEvent = obj.event,
	            data = obj.data;
			if(layEvent === 'viewProcessImage'){
				viewProcessImage(data.id);
			}else if(layEvent === 'doTask'){
				doTask(data.id);
			}
	    });
	
	 })
</script>
</body>
</html>