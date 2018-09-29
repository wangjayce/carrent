<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>部门管理菜单</title>
<link rel="stylesheet" href="${ctx }/resources/layui/css/layui.css" media="all" />

</head>
<body>
	<form class="layui-form" action="#" method="get" id="frm" lay-filter="frm">
		<!-- 	<form class="layui-form  layui-form-pane" action="#" method="get"> -->
		<div class="layui-form-item" style="margin-top: 10px">
			<label class="layui-form-label">公告标题</label>
			<div class="layui-input-block" style="width: 80%">
				<input type="text" readonly="readonly" name="title" id="title" value="${notice.title }" lay-verify="required" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">公告内容</label>
			<textarea id="notice" readonly="readonly" name="content" style="width: 80%;height: 300px">${notice.content }</textarea>
		</div>		
		<div class="layui-form-item">
			<div class="layui-input-block" style="text-align: center;width: 70%">
				<!--lay-submit标记当按钮是一个提交按钮   -->
				<a class="layui-btn" lay-submit="" lay-filter="noticeSubmit" style="float: right">关闭</a>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript" src="${ctx }/resources/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/resources/zTree/js/jquery-1.4.4.min.js"></script>

<script type="text/javascript">
	layui.use([ 'form','jquery','layer','layedit'], function() {
		var form=layui.form;//得到form对象
		var $=layui.jquery;
		var layedit = layui.layedit;
		var layer = parent.layer === undefined ? layui.layer : parent.layer;
		layedit.set({
			  uploadImage: {
			    url: '${ctx}/notice/uploadimage.action' //接口url
			    ,type: 'post' //默认post
			  }
			});
		var editIndex = layedit.build('notice'); //建立编辑器
		layedit.sync(editIndex);
		
		form.on("submit(noticeSubmit)",function(data){
			var index = layer.getFrameIndex(window.name);
			layer.close(index);
			parent.datareload();
		});		
	});
	


</script>
</html>