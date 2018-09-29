<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改角色</title>
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
			<label class="layui-form-label">角色名称</label>
			<div class="layui-input-block" style="width: 80%">
				<input type="text" name="name" value="${role.name }" id="name" lay-verify="required" autocomplete="off"
					class="layui-input">
					<input type="hidden" name="id" value="${role.id }">
			</div>
		</div>
		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">角色备注</label>
			<textarea id="remark" name="remark" style="width: 80%;height:120px" >${role.remark}</textarea>
		</div>		
		  <div class="layui-form-item">
					<label class="layui-form-label">是否可用</label>
				<div class="layui-input-inline">
					<input type="radio" name="available" value="1" title="是"  ${role.available==1?"checked":"" }>
					<input type="radio" name="available" value="0" title="否"  ${role.available==0?"checked":"" }> 
				</div>
		  </div>	
		<div class="layui-form-item" style="margin-top: 40px">
			<div class="layui-input-block" style="text-align: center;width: 70%">
				<!--lay-submit标记当按钮是一个提交按钮   -->
				<a class="layui-btn" lay-submit="" lay-filter="roleSubmit">提交</a>
				<button lay-reset="" class="layui-btn layui-btn-normal">重置</button>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript" src="${ctx }/resources/layui/layui.js"></script>
<script type="text/javascript">
	layui.use([ 'form','jquery','layer' ], function() {
		var form=layui.form;//得到form对象
		var $=layui.jquery;
		var layer = parent.layer === undefined ? layui.layer : parent.layer;		
		form.on("submit(roleSubmit)",function(data){
			var params = $('#frm').serialize();
		    $.post('${ctx}/role/updateRole.action',params,function(data){
				layer.msg(data.msg);
				var index = layer.getFrameIndex(window.name);
				layer.close(index);
				window.parent.datareload();
			});
		
		});			  
	});
</script>
</html>