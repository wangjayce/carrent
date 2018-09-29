<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>部门管理菜单</title>
<link rel="stylesheet" href="${ctx }/resources/zTree/css/metroStyle/metroStyle.css" type="text/css">
<link rel="stylesheet" href="${ctx }/resources/layui/css/layui.css" media="all" />
<link rel="stylesheet" type="text/css" href="${ctx }/resources/zTree/css/metroStyle/metroStyle.css">
<link rel="stylesheet" type="text/css" href="${ctx }/resources/plugin/css/index.css">
<script type="text/javascript" src="${ctx }/resources/zTree/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${ctx }/resources/zTree/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="${ctx }/resources/plugin/js/selectTree.js"></script>
</head>
<body class="childrenBody">
	<form class="layui-form" action="#" method="get" id="frm" lay-filter="frm">
		<!-- 	<form class="layui-form  layui-form-pane" action="#" method="get"> -->
		<div class="layui-form-item" style="margin-top: 10px">
			<label class="layui-form-label">公告标题</label>
			<div class="layui-input-block" style="width: 80%">
				<input type="text" name="title" id="title" lay-verify="required" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">公告内容</label>
			<textarea id="notice" name="content" ></textarea>
		</div>		
		<div class="layui-form-item">
			<div class="layui-input-block" style="text-align: center;">
				<!--lay-submit标记当按钮是一个提交按钮   -->
				<a class="layui-btn" lay-submit="" lay-filter="noticeSubmit">提交</a>
				<button lay-reset="" class="layui-btn layui-btn-normal">重置</button>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript" src="${ctx }/resources/layui/layui.js"></script>
<script type="text/javascript">
	layui.use([ 'form','jquery','layer','layedit' ], function() {
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
			var content = layedit.getContent(editIndex);
			var title = $('#title').val();
		    $.post('${ctx}/notice/addNotice.action',{title:title,content:content},function(data){
				layer.msg(data.msg);
				var index = layer.getFrameIndex(window.name);
				layer.close(index);
				window.parent.datareload();
			});
		
		});			  
	});
</script>
</html>