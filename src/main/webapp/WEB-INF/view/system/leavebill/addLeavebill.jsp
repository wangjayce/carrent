<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加请假单</title>
<link rel="stylesheet" href="${ctx }/resources/layui/css/layui.css" media="all" />
<link rel="stylesheet" href="${ctx }/resources/css/public.css" media="all" />
</head>
<body class="childrenBody">
	<form class="layui-form" method="post" id="frm">
		<div class="layui-form-item">
			<label class="layui-form-label">请假标题</label>
			<div class="layui-input-block">
				<input type="text" name="title" lay-verify="title" value="【${user.name }】的请假单" autocomplete="off"
					placeholder="请输入请假标题" class="layui-input">
				<input type="hidden" name="state" value="0">
				<input type="hidden" name="userid" value="${user.id }">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">请假天数</label>
				<div class="layui-input-inline">
					<input type="text" name="days" placeholder="请输入请假天数" lay-verify="number" autocomplete="off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">开始时间</label>
				<div class="layui-input-inline">
					<input type="text" name="leavetime"  id="leavetime" autocomplete="off"
						class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">请假原因</label>
			<div class="layui-input-block">
				<textarea placeholder="请输入请假原因" name="content" class="layui-textarea"></textarea>
			</div>
		</div>
	  <div class="layui-form-item" style="text-align: center;">
	      <button class="layui-btn" lay-submit="" lay-filter="addLeavebill">提交</button>
	      <button type="reset" class="layui-btn layui-btn-warm">重置</button>
  	  </div>
  </form>
  <script type="text/javascript" src="${ctx }/resources/layui/layui.js"></script>
</body>
<script type="text/javascript">
	layui.use(['form','jquery','layer','laydate'],function(){
		var form=layui.form;
		var laydate=layui.laydate;
		var $=layui.jquery;
		//如果父页面有layer就使用父页的  没有就自己导入
		var layer = parent.layer === undefined ? layui.layer : top.layer;
		
		laydate.render({
			elem:'#leavetime',
	    	type : 'datetime'
		})
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