<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品管理--供应商列表</title>
<link rel="stylesheet" href="${ctx }/resources/zTree/css/metroStyle/metroStyle.css" type="text/css">
<script type="text/javascript" src="${ctx }/resources/zTree/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${ctx }/resources/zTree/js/jquery.ztree.core.js"></script>
</head>
<body class="childrenBody">
	<div id="goodsTree" class="ztree"></div>
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
		$.post('${ctx}/goods/loadGoodsTree.action',function(zNodes){
			$.fn.zTree.init($("#goodsTree"), setting, zNodes);
		});
	}
	$(document).ready(function(){
			initTree();	
	});
	

</script>
</body>
</html>