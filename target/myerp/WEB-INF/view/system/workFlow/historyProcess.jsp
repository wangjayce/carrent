<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>流程管理</title>
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
				      <label class="layui-form-label">部署名称</label>
				      <div class="layui-input-inline">
				        <input type="text" name="deploymentName" id="deploymentName" autocomplete="off" class="layui-input">
				      </div>
			    </div>
			     <div class="layui-inline">
				       <a href="javascript:void(0)" class="search_btn layui-btn" >查询</a>
		    	 	  <button type="reset" class="layui-btn layui-btn-warm">重置</button>
		    	 </div>
		  </div>	    
	</form>
	<table id="deploymentList" lay-filter="deploymentList"></table>
	<table id="processDefList" lay-filter="processDefList"></table>
	

	<!--操作-->
	<script type="text/html" id="workFlowListBar">
		<a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="viewProcessImage">查看流程图</a>
		<a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
	</script>
	<!--操作-->
	<script type="text/html" id="tabletoorbar">
		<button class="layui-btn layui-btn-normal layui-btn-sm" lay-event="add">添加</button>
	</script>

<script type="text/javascript" src="${ctx }/resources/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/resources/zTree/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
	var tableDeployment;
	var tableProcess;
	
    layui.use(['form','layer','laydate','table','laytpl'],function(){
	  	  var form = layui.form,
		        layer =layui.layer,
		        $ = layui.jquery,
		        table = layui.table;		    
			    
			    //部署列表
			    tableDeployment = table.render({
			        elem: '#deploymentList',
			        url : '${ctx}/workFlow/uploadAllProcessDeployment.action',
			        cellMinWidth : 95,
			        page : true,
			        height : "full-325",
			        limit : 10,
			        limits : [10,15,20,25],
					toolbar:'#tabletoorbar',
			        id : "deploymentList",
			        cols : [[
			            {type: "checkbox", fixed:"left", width:50},
			            {field: 'id', title: '部署ID', width:160, align:"center"},
			            {field: 'name', title: '部署名称', align:"center"},
			            {field: 'deploymentTime', title: '部署时间', width:350, align:"center"},
			            {title: '操作', width:270, templet:'#workFlowListBar',fixed:"right",align:"center"}
			        ]]
			    });
			    //部署列表
			    tableProcess = table.render({
			        elem: '#processDefList',
			        url : '${ctx}/workFlow/uploadAllProcessDef.action',
			        cellMinWidth : 95,
			        page : true,
			        height : "full-325",
			        limit : 10,
			        limits : [10,15,20,25],
					toolbar:'true',
			        id : "processDefList",
			        cols : [[
			        	  {type: "checkbox", fixed:"left", width:50},
			              {field: 'id', title: '定义ID', minWidth:100, align:"center"},
			              {field: 'name', title: '定义名称', minWidth:100, align:"center"},
			              {field: 'key', title: '定义KEY', minWidth:100, align:"center"},
			              {field: 'version', title: '定义版本', minWidth:100, align:"center"},
			              {field: 'deploymentId', title: '部署ID', minWidth:100, align:"center"},
			              {field: 'resourceName', title: '资源名称[bpmn]', minWidth:100, align:"center"},
			              {field: 'diagramResourceName', title: '资源名称[png]', minWidth:100, align:"center"}
			        ]]
			    });
			
	        //监听头工具栏事件
	        table.on('toolbar(deploymentList)', function(obj){
	            switch(obj.event){
	                case 'add':
	                	addWorkFlow();
	                	break;
	            };
	        });
	
	    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
	    $(".search_btn").on("click",function(){
	    	var params=$("#searchForm").serialize();
            table.reload('deploymentList', {
                url: '${ctx }/workFlow/uploadAllProcessDeployment.action?'+params
            });
            table.reload('processDefList', {
                url: '${ctx }/workFlow/uploadAllProcessDef.action?'+params
            });
	    });
	    
        function addWorkFlow(){
        	layer.open({
        		  type: 2, 
        		  title:'部署流程',
        		  content: '${ctx}/workFlow/toaddDeployment.action', //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
        		  area : ['800px','400px']
          	}); 
        }
        
        function viewProcessImage(id){
        	layer.open({
        		  type: 2, 
        		  title:'流程图',
        		  content: '${ctx}/workFlow/toviewProcessImage.action?deploymentId='+id, //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
        		  area : ['1000px','600px']
          	}); 
        }
 
	    //列表操作
	    table.on('tool(deploymentList)', function(obj){
	        var layEvent = obj.event,
	            data = obj.data;
			if(layEvent === 'del'){ //删除
	            layer.confirm('确定删除此部署？',{icon:3, title:'提示信息'},function(index){
	                $.post("${ctx}/workFlow/deleteDeployment.action",{
	                	deploymentId : data.id  //将需要删除的Id作为参数传入
	                },function(data){		         
	                	tableDeployment.reload();
	                	tableProcess.reload();
		                layer.msg(data.msg);
		                layer.close(index);
	                })
	            });
			}else if(layEvent === 'viewProcessImage'){
				viewProcessImage(data.id);
			}
	    });
	
	 })
</script>
</body>
</html>