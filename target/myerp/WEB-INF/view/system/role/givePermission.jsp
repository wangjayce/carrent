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
<script type="text/javascript" src="${ctx }/resources/zTree/js/jquery.ztree.excheck.min.js"></script>
</head>
<body>
	<form class="layui-form" action="#" method="get" id="frm" lay-filter="frm">
		<!-- 	<form class="layui-form  layui-form-pane" action="#" method="get"> -->
		
		<div id="treePermission" class="ztree"></div>
		
		<div class="layui-form-item">
			<div class="layui-input-block" style="text-align: center;">
				<!--lay-submit标记当按钮是一个提交按钮   -->
				<a class="layui-btn" lay-submit="" lay-filter="roleSubmit">提交</a>
				<button lay-reset="" class="layui-btn layui-btn-normal">重置</button>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript" src="${ctx }/resources/layui/layui.js"></script>
<script type="text/javascript">

	var layer;
	var form;
	var setting = {
			data: {
				simpleData: {
					enable: true
				}
			},
			check: {
				enable: true
			}				
		};
	
	function  initTree(){
		$.post('${ctx}/role/loadPermissionTree.action?id=${id}',function(zNodes){
			$.fn.zTree.init($("#treePermission"), setting, zNodes);
		});
	}
	$(document).ready(function(){
			initTree();	
	});
	
	layui.use([ 'form','layer' ], function() {
		layer = parent.layer === undefined ? layui.layer : parent.layer;
		form = layui.form;
		form.on("submit(roleSubmit)",function(data){
			var params = "?id=${roleVo.id}";
			var treeObj = $.fn.zTree.getZTreeObj("treePermission");
			var nodes = treeObj.getCheckedNodes(true);
			for(var i=0;i<nodes.length;i++){
				params +="&ids="+nodes[i].id;
			}
			//alert(params);
			$.post('${ctx}/role/savaRolePermission.action'+params,function(data){
				layer.msg(data.msg);
			});
		
		});	
	});
	
	

			


</script>
</html>