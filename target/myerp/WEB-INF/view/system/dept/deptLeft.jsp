<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>部门管理菜单</title>
<link rel="stylesheet" href="${ctx }/resources/zTree/css/metroStyle/metroStyle.css" type="text/css">
<script type="text/javascript" src="${ctx }/resources/zTree/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${ctx }/resources/zTree/js/jquery.ztree.core.js"></script>
</head>
<body class="childrenBody">
	<div id="treeDemo" class="ztree"></div>
<script type="text/javascript">
var setting = {
		data: {
			simpleData: {
				enable: true
			}
		},
		callback: {
			onClick: zTreeOnClick
		}
	};
	function zTreeOnClick(event, treeId, treeNode){
		window.parent.right.tablereload(treeNode.id);
	}

	function  initTree(){
		$.post('${ctx}/dept/loadDeptTree.action',function(zNodes){
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		});
	}
	$(document).ready(function(){
			initTree();	
	});
	

</script>
</body>
</html>