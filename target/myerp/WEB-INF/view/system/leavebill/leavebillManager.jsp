<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>请假单管理</title>
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
		<div class="layui-form-item" style="text-align: center">
			    <div class="layui-inline">
				      <label class="layui-form-label">请假单标题</label>
				      <div class="layui-input-inline">
				        <input type="text" name="title" id="title" autocomplete="off" class="layui-input">
				      </div>
			    </div>
			    <div class="layui-inline">
				      <label class="layui-form-label">请假单内容</label>
				      <div class="layui-input-inline">
				        <input type="text" name="content" id="content" autocomplete="off" class="layui-input">
				      </div>
			    </div>
	    </div>
		<div class="layui-form-item" style="text-align: center">
			    <div class="layui-inline">
				      <label class="layui-form-label">开始时间</label>
				      <div class="layui-input-inline">
				        <input type="text" name="startDate" id="startDate"  placeholder="yyyy-MM-dd HH:mm:ss" autocomplete="off" class="layui-input">
				      </div>
			    </div>
			    <div class="layui-inline">
				      <label class="layui-form-label">结束时间</label>
				      <div class="layui-input-inline">
				        <input type="tel" name="endDate" id="endDate" placeholder="yyyy-MM-dd HH:mm:ss" autocomplete="off" class="layui-input">
				      </div>
			    </div>
		 </div>	    
		  <div class="layui-form-item" style="text-align: center">
	    	   <a href="javascript:void(0)" class="search_btn layui-btn" >查询</a>
	    	   <button type="reset" class="layui-btn layui-btn-warm">重置</button>
		  </div>
	</form>
	<table id="leavebillList" lay-filter="leavebillList"></table>
	

	<!--操作-->
	<script type="text/html" id="leavebillListBar">
		{{#  if(d.state ==0 ){ }}
  			  <a class="layui-btn layui-btn-xs" lay-event="update">编辑</a>
   			  <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
   		      <a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="submit">提交申请</a>
 	    {{#  } else if(d.state ==1) { }}
     		  <a class="layui-btn layui-btn-xs layui-btn-warm" lay-event="check">进度查询</a>
     		  <a class="layui-btn layui-btn-xs layui-btn-warm" lay-event="giveUp">放弃</a>
  	    {{#  }else if(d.state ==2) { }}
				<a class="layui-btn layui-btn-xs layui-btn-warm" lay-event="check">进度查询</a>
        {{#  }else if(d.state ==3) { }}
			  <a class="layui-btn layui-btn-xs" lay-event="update">编辑</a>
     		  <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
  		{{#  } }}	
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
           	    title: $("#title").val() ,
           	    content: $("#content").val() ,
                startDate: $("#startDate").val() ,
                endDate: $("#endDate").val()
            }
		});
	}
	
    layui.use(['form','layer','laydate','table','laytpl'],function(){
	  	  var form = layui.form,
		        layer =layui.layer,
		        $ = layui.jquery,
		        laydate = layui.laydate,
		        laytpl = layui.laytpl,
		        table = layui.table;
		    
			    laydate.render({
			    	elem : '#startDate',
			    	type : 'datetime'
			    });
			    laydate.render({
			    	elem : '#endDate',
			    	type : 'datetime'
			    });
			    
			    //日志列表
			    tableIns = table.render({
			        elem: '#leavebillList',
			        url : '${ctx}/leavebill/uploadAllLeavebill.action',
			        cellMinWidth : 95,
			        page : true,
			        height : "full-225",
			        limit : 10,
			        limits : [10,15,20,25],
					toolbar:'#tabletoorbar',
			        id : "leavebillList",
			        cols : [[
			            {type: "checkbox", fixed:"left", width:50},
			            {field: 'id', title: '请假单ID', width:100, align:"center"},
			            {field: 'title', title: '请假单标题',width:130,align:"center"},
			            {field: 'content', title: '请假单内容', width:120 , align:"center"},
			            {field: 'username', title: '请假单人', width:100 , align:"center"},
			            {field: 'leavetime', title: '请假时间', width:160, align:'center'},
			            {field: 'days', title: '请假天数', width:100,align:'center'},
			            {field: 'state', title: '请假单状态', width:100, align:'center',templet:function(data){
			            	if(data.state==0){
			            		return "<font color=red>未提交<font>";
			            	}
			            	else if(data.state==1){
			            		return "<font color=gree>审核中<font>";
			            	}
			            	else if(data.state==2){
			            		return "<font color=blue>审核完成<font>";
			            	}
			            	else if(data.state==3){
			            		return "<font color=gray>放弃<font>";
			            	}
			            }},
			            {title: '操作', width:340, templet:'#leavebillListBar',fixed:"right",align:"center"}
			        ]]
			    });
			
	        //监听头工具栏事件
	        table.on('toolbar(leavebillList)', function(obj){
	            switch(obj.event){
	                case 'batchDelet':
			            var checkStatus = table.checkStatus(obj.config.id),
			            data = checkStatus.data; //获取选中的数据
	                	var ids="?a=1";
	                	 if(data.length > 0) {
	 	                    for (var i in data) {
	 	                    	ids+="&ids="+data[i].id;
	 	                    }
	 	                    layer.confirm('确定删除选中的日志？', {icon: 3, title: '提示信息'}, function (index) {
	 	                         $.post("${ctx}/leavebill/deleteLeavebill.action"+ids,function(data){
	 	                        	layer.msg(data.msg);
	 	                        	tableIns.reload();
	 	                        	layer.close(index);
	 	                         })
	 	                    })
	 	                }else{
	 	                    layer.msg("请选择需要删除的日志");
	 	                }
	                    break;
	                case 'add':
	                	addLeavebill();
	                	break;
	            };
	        });
	
	    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
	    $(".search_btn").on("click",function(){
	    	datareload();
	    });
	    
        function addLeavebill(){
        	layer.open({
        		  type: 2, 
        		  title:'发布请假单',
        		  content: '${ctx}/leavebill/toaddLeavebill.action', //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
        		  area : ['800px','600px']
          	}); 
        }
        function updateLeavebill(id){
        	layer.open({
        		  type: 2, 
        		  title:'修改请假单',
        		  content: '${ctx}/leavebill/toupdateLeavebill.action?id='+id, //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
        		  area : ['800px','600px']
          	}); 
        }
        function checkLeavebillProcess(id){
        	layer.open({
        		  type: 2, 
        		  title:'请假单进度',
        		  content: '${ctx}/workFlow/checkLeavebillProcess.action?leavebillId='+id, //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
        		  area : ['800px','600px']
          	}); 
        }
 
	    //列表操作
	    table.on('tool(leavebillList)', function(obj){
	        var layEvent = obj.event,
	            data = obj.data;
			if(layEvent === 'del'){ //删除
	            layer.confirm('确定删除此请假单？',{icon:3, title:'提示信息'},function(index){
	                $.post("${ctx}/leavebill/deleteLeavebill.action",{
	                     id : data.id  //将需要删除的Id作为参数传入
	                },function(data){		         
		                tableIns.reload();
		                layer.msg(data.msg);
		                layer.close(index);
	                })
	            });
			}else if(layEvent === 'submit'){
				layer.confirm('确定提交此请假单？',{icon:3, title:'提示信息'},function(index){
	                $.post("${ctx}/workFlow/submitLeavebill.action?leavebillId="+data.id,function(data){		         
		                tableIns.reload();
		                layer.msg(data.msg);
		                layer.close(index);
	                },'json')
	            });
			}else if(layEvent === 'update'){
				updateLeavebill(data.id);
			}else if(layEvent === 'check'){
				checkLeavebillProcess(data.id);
			}
	    });
	
	 })
</script>
</body>
</html>