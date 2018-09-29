<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加部署</title>
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
			<label class="layui-form-label">部署名称</label>
			<div class="layui-input-block" style="width: 80%">
				<input type="text" name="deploymentName" id="deploymentName" lay-verify="required" autocomplete="off"
					class="layui-input">
			</div>
			
		</div>
		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">流程图片</label>
			<div class="layui-upload">
 				 <button type="button" class="layui-btn layui-btn-normal" id="chooseFile">选择文件</button>
			</div>
		</div>		
		<div class="layui-form-item">
			<div class="layui-input-block" style="text-align: center;">
				<button type="button" class="layui-btn" id="deploy">部署</button>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript" src="${ctx }/resources/layui/layui.js"></script>
<script type="text/javascript">
	layui.use([ 'form','jquery','layedit','upload' ], function() {
		var form=layui.form;//得到form对象
		var $=layui.jquery;
		var layer = parent.layer === undefined ? layui.layer : parent.layer;
		var upload = layui.upload;
		
		 //选完文件后不自动上传
		  upload.render({
		    elem: '#chooseFile'
		    ,url: '${ctx}/workFlow/addDeployment.action'
		    ,auto: false
		    ,exts: 'zip'
		    ,acceptMime:'application/zip'
		    ,field: 'mf'
		    ,data :{
		    	 deploymentName : function(){
					 return $('#deploymentName').val();
		    	 }
			}
		    ,bindAction: '#deploy'
		    ,done: function(data){
		    	layer.msg(data.msg);
				var index = layer.getFrameIndex(window.name);
				layer.close(index);
				window.parent.tableDeployment.reload();
				window.parent.tableProcess.reload();
		    }
		  });
		
	});
</script>
</html>