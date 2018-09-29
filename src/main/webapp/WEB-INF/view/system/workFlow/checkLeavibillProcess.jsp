<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>流程审批</title>
<link rel="stylesheet" href="${ctx }/resources/layui/css/layui.css" media="all" />
<link rel="stylesheet" href="${ctx }/resources/css/public.css" media="all" />
</head>
<body class="childrenBody">
	<form class="layui-form" method="post" id="frm">
		<div class="layui-form-item">
			<label class="layui-form-label">请假标题</label>
			<div class="layui-input-block">
				<input type="text" name="title" lay-verify="title" value="【${leavebill.username }】的请假单" autocomplete="off"
					placeholder="请输入请假标题" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">请假天数</label>
				<div class="layui-input-inline">
					<input type="text" name="days" value="${leavebill.days }" placeholder="请输入请假天数" lay-verify="number" autocomplete="off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">开始时间</label>
				<div class="layui-input-inline">
					<input type="text" name="leavetime" value="<fmt:formatDate 
					value="${leavebill.leavetime }" pattern="yyyy-MM-dd"/>" id="leavetime" autocomplete="off"
						class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">请假原因</label>
			<div class="layui-input-block">
				<textarea placeholder="请输入请假原因"  name="content" class="layui-textarea">${leavebill.content }</textarea>
			</div>
		</div>
  </form>
  <table id="commentList" lay-filter="commentList"></table>
  <script type="text/javascript" src="${ctx }/resources/layui/layui.js"></script>
</body>
<script type="text/javascript">
	layui.use(['form','jquery','layer','laydate','table'],function(){
		var form=layui.form;
		var laydate=layui.laydate;
		var $=layui.jquery;
		var table = layui.table;
		//如果父页面有layer就使用父页的  没有就自己导入
		var layer = parent.layer === undefined ? layui.layer : top.layer;
		
		 //任务列表
	    var tableIns = table.render({
	        elem: '#commentList',
	        url : '${ctx}/workFlow/uploadAllComments.action?leavebillId=${leavebill.id}',
	        cellMinWidth : 95,
	        page : true,
	        height : "full-275",
			toolbar:true,
	        id : "commentList",
	        cols : [[
	            {field: 'userId', title: '批注人', width:160, align:"center"},
	            {field: 'message', title: '批注内容', align:"center"},
	            {field: 'time', title: '批注时间', width:350, align:"center"},
	        ]]
	    });
		 
		laydate.render({
			elem:'#leavetime',
	    	type : 'datetime'
		})
		
		$('.mybtn').on('click',function(){
			var outcome = this.value;
			var taskId = '${workFlowVo.taskId}';
			var content = $('#content').val();
			var leavebillId = '${leavebill.id}';
			$.post('${ctx}/workFlow/completeTask.action',{
				outcome : outcome,
				taskId  :taskId,
				content : content,
				leavebillId :leavebillId
			},function(data){
				layer.msg(data.msg);
			 	var Index = parent.layer.getFrameIndex(window.name);
			 	window.parent.layer.close(Index); 
				window.parent.tableIns.reload();
			},'json');
		});
	 //监听提交
	  form.on('submit(addLeavebill)', function(data){
		 var data=$("#frm").serialize();
	    //使用ajax提交
	    $.ajax({
		    url:'${ctx }/leavebill/addLeavebill.action',
		    type:'POST',
		    async:true,    //或false,是否异步
		    data:data,
		    timeout:5000,    //超时时间
		    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
		    success:function(data){
		    	layer.msg(data.msg);
			    //关闭添加的弹出层
			 	var addIndex = parent.layer.getFrameIndex(window.name);
			 	window.parent.layer.close(addIndex); 
		    	//刷新父页面的table
				window.parent.tableIns.reload();
		    },
		    error:function(xhr,textStatus){
		    }
		})
	    return false;
	  });
	});
</script>
</html>