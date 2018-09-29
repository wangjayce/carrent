<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>角色管理</title>
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
				      <label class="layui-form-label">角色名称</label>
				      <div class="layui-input-inline">
				        <input type="text" name="name" id="name" autocomplete="off" class="layui-input">
				      </div>
			    </div>
			    <div class="layui-inline">
				      <label class="layui-form-label">角色备注</label>
				      <div class="layui-input-inline">
				        <input type="text" name="remark" id="remark"  autocomplete="off" class="layui-input">
				      </div>
			    </div>
			     <div class="layui-inline">
				       <a href="javascript:void(0)" class="search_btn layui-btn" >查询</a>
		    	 	  <button type="reset" class="layui-btn layui-btn-warm">重置</button>
		    	 </div>
		  </div>	    
	</form>
	<table id="roleList" lay-filter="roleList"></table>
	

	<!--操作-->
	<script type="text/html" id="roleListBar">
		<a class="layui-btn layui-btn-xs" lay-event="update">编辑</a>
		<a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="givePermission">分配角色</a>
		<a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
	</script>
	<!--操作-->
	<script type="text/html" id="tabletoorbar">
		<button class="layui-btn layui-btn-normal layui-btn-sm" lay-event="add">添加</button>
		<button class="layui-btn layui-btn-danger layui-btn-sm" lay-event="batchDelet">批量删除</button>
	</script>

<script type="text/javascript" src="${ctx }/resources/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/resources/zTree/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
	var tableIns;
	
	function datareload(){
		tableIns.reload({
			  page: {
                curr: 1 //重新从第 1 页开始
            },
            where: {
            	name: $("#name").val() ,
                remark: $("#remark").val()
            }
		});
	}
	
    layui.use(['form','layer','laydate','table','laytpl'],function(){
	  	  var form = layui.form,
		        layer =layui.layer,
		        $ = layui.jquery,
		        table = layui.table;		    
			    
			    //角色列表
			    tableIns = table.render({
			        elem: '#roleList',
			        url : '${ctx}/role/uploadAllRole.action',
			        cellMinWidth : 95,
			        page : true,
			        height : "full-225",
			        limit : 10,
			        limits : [10,15,20,25],
					toolbar:'#tabletoorbar',
			        id : "roleList",
			        cols : [[
			            {type: "checkbox", fixed:"left", width:50},
			            {field: 'id', title: '角色ID', width:160, align:"center"},
			            {field: 'name', title: '角色名称', align:"center"},
			            {field: 'remark', title: '角色备注', width:350, align:"center"},
			            {field: 'available', title: '是否可用', align:'center',templet:function(data){
			            	return data.available==1?"<font color=blue>可用</font>":"<font color=red>不可用</font>"
			            }},
			            {title: '操作', width:170, templet:'#roleListBar',fixed:"right",align:"center"}
			        ]]
			    });
			
	        //监听头工具栏事件
	        table.on('toolbar(roleList)', function(obj){
	            switch(obj.event){
	                case 'batchDelet':
			            var checkStatus = table.checkStatus(obj.config.id),
			            data = checkStatus.data; //获取选中的数据
	                	var ids="?a=1";
	                	 if(data.length > 0) {
	 	                    for (var i in data) {
	 	                    	ids+="&ids="+data[i].id;
	 	                    }
	 	                    layer.confirm('确定删除选中的角色？', {icon: 3, title: '提示信息'}, function (index) {
	 	                         $.post("${ctx}/role/deleteRole.action"+ids,function(data){
	 	                        	layer.msg(data.msg);
	 	                        	tableIns.reload();
	 	                        	layer.close(index);
	 	                         })
	 	                    })
	 	                }else{
	 	                    layer.msg("请选择需要删除的角色");
	 	                }
	                    break;
	                case 'add':
	                	addRole();
	                	break;
	            };
	        });
	
	    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
	    $(".search_btn").on("click",function(){
	    	datareload();
	    });
	    
        function addRole(){
        	layer.open({
        		  type: 2, 
        		  title:'发布角色',
        		  content: '${ctx}/role/toaddRole.action', //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
        		  area : ['800px','600px']
          	}); 
        }
        function updateRole(id){
        	layer.open({
        		  type: 2, 
        		  title:'修改角色',
        		  content: '${ctx}/role/toupdateRole.action?id='+id, //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
        		  area : ['800px','600px']
          	}); 
        }
        function givePermission(id){
        	layer.open({
      		  type: 2, 
      		  title:'角色详情',
      		  content: '${ctx}/role/togivePermission.action?id='+id, //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
      		  area : ['300px','600px']
        	}); 
        }
 
	    //列表操作
	    table.on('tool(roleList)', function(obj){
	        var layEvent = obj.event,
	            data = obj.data;
			if(layEvent === 'del'){ //删除
	            layer.confirm('确定删除此角色？',{icon:3, title:'提示信息'},function(index){
	                $.post("${ctx}/role/deleteRole.action",{
	                     id : data.id  //将需要删除的Id作为参数传入
	                },function(data){		         
		                tableIns.reload();
		                layer.msg(data.msg);
		                layer.close(index);
	                })
	            });
			}else if(layEvent === 'givePermission'){
				givePermission(data.id);
			}else if(layEvent === 'update'){
				updateRole(data.id);
			}
	    });
	
	 })
</script>
</body>
</html>