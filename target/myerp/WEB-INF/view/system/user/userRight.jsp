<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>用户管理列表</title>
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
				      <label class="layui-form-label">用户名称</label>
				      <div class="layui-input-inline">
				        <input type="text" name="name" id="name" autocomplete="off" class="layui-input">
				      </div>
			    </div>
			    <div class="layui-inline">
				      <label class="layui-form-label">用户地址</label>
				      <div class="layui-input-inline">
				        <input type="text" name="address" id="address"   autocomplete="off" class="layui-input">
				      </div>
			    </div>
			    <div class="layui-inline">
			      <div class="layui-input-inline">
				      <a href="javascript:void(0)" class="search_btn layui-btn" >查询</a>
	    	  		 <button type="reset" class="layui-btn layui-btn-warm">重置</button>
			      </div>
			    </div>
		  </div>
	    
		  
	</form>
	<table id="userList" lay-filter="userList"></table>
	

	<!--操作-->
	<script type="text/html" id="userListBar">
		<a class="layui-btn layui-btn-xs layui-btn-warm" lay-event="update">修改</a>
		<a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
		<a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="resetPwd">重置密码</a>
		<a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="giveRole">分配角色</a>
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
                address: $("#address").val() ,
                deptid : id
              }
		});
	}
	
    layui.use(['form','layer','laydate','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;

	    //用户列表
	    tableIns = table.render({
	        elem: '#userList',
	        url : '${ctx}/user/uploadAllUser.action',
	        cellMinWidth : 95,
	        page : true,
	        height : "full-225",
	        limit : 10,
	        limits : [10,15,20,25],
			toolbar:'#tabletoorbar',
	        id : "userList",
	        cols : [[
	        	 {type: "checkbox", fixed:"left", width:50},
	                {field: 'id', title: 'ID', width:60, align:"center"},
	                {field: 'name', title: '用户姓名', width:120, align:"center"},
	                {field: 'loginname', title: '登陆名称', width:120, align:"center"},
	                {field: 'deptname', title: '所在部门', width:150, align:"center"},
	                {field: 'leadername', title: '直接领导', width:120, align:"center"},
	                {field: 'address', title: '用户地址',align:"center", width:150},
	                {field: 'remark', title: '用户备注',align:"center", width:150},
	                {field: 'hiredate', title: '入职时间',align:"center", width:150},
	                {field: 'sex', title: '性别', align:'center',templet:function(data){
	                	return data.sex==1?"<font color=blue>男</font>":"<font color=red>女</font>"
	                }},
	                {field: 'imgpath', title: '头像', align:'center',templet:function(data){
	                	return "<img width=20px height=20px alt=无效地址  src='"+data.imgpath+"'></img>"
	                }},
	                {field: 'available', title: '是否可用',width:120, align:'center',templet:function(data){
	                	return data.parent==1?"<font color=blue>是</font>":"<font color=red>否</font>"
	                }},
	                {field: 'pwd', title: '密码', align:'center',templet:function(data){
	                	return "*****"
	                }},
	                {field: 'ordernum', title: '排序码',align:"center", width:80},
	                {title: '操作', width:300, templet:'#userListBar',fixed:"right",align:"center"}
	        ]]
	    });
	
        //监听头工具栏事件
        table.on('toolbar(userList)', function(obj){
        	
            switch(obj.event){
                case 'batchDelet':
		            var checkStatus = table.checkStatus(obj.config.id),
		            data = checkStatus.data; //获取选中的数据
                	var ids="?a=1";
                	 if(data.length > 0) {
 	                    for (var i in data) {
 	                    	ids+="&ids="+data[i].id;
 	                    }
 	                    layer.confirm('确定删除选中的用户？', {icon: 3, title: '提示信息'}, function (index) {
 	                         $.post("${ctx}/user/deleteUser.action"+ids,function(data){
 	                        	layer.msg(data.msg);
 	                        	tableIns.reload();
 	                        	layer.close(index);
 	                         })
 	                    })
 	                }else{
 	                    layer.msg("请选择需要删除的用户");
 	                }
                    break;
                case 'add':
                	addUser();
                	break;
            };
        });
        function addUser(){
        	layer.open({
      		  type: 2, 
      		  title:'添加用户',
      		  content: '${ctx}/user/toaddUser.action', //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
      		  area : ['800px','600px']
        	}); 
        }
        
        function updateUser(id){
        	layer.open({
      		  type: 2, 
      		  title:'修改用户',
      		  content: '${ctx}/user/toupdateUser.action?id='+id, //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
      		  area : ['800px','600px']
        	}); 
        }
        
        function giveRole(id){
        	layer.open({
      		  type: 2, 
      		  title:'修改用户',
      		  content: '${ctx}/user/giveUserRole.action?id='+id, //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
      		  area : ['800px','600px']
        	}); 
        }
	
	   
	
	    $(".search_btn").on("click",function(){
	    		tablereload(null);
	    });
	
	  
	    //列表操作
	    table.on('tool(userList)', function(obj){
	        var layEvent = obj.event,
	            data = obj.data;
	        if(layEvent === 'update'){
	        	updateUser(data.id);
	        }else if(layEvent === 'del'){ //删除
	            layer.confirm('确定删除此用户？',{icon:3, title:'提示信息'},function(index){
	                $.post("${ctx}/user/deleteUser.action",{
	                     id : data.id  //将需要删除的Id作为参数传入
	                },function(data){		         
		                tableIns.reload();
		                layer.msg(data.msg);
		                layer.close(index);
	                })
	            });
			}else if(layEvent ==='resetPwd'){
				  layer.confirm('确定删重置此用户密码？',{icon:3, title:'提示信息'},function(index){
						$.post('${ctx}/user/resetUserPwd.action',{id:data.id},function(obj){
				                layer.msg(obj.msg);
						},'json');
				  });
			}else if(layEvent === 'giveRole'){
				giveRole(data.id);
			}
	    });
	
	 })
</script>
</body>
</html>