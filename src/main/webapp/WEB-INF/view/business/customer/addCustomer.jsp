<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>供应商管理--新增供应商</title>
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
				<label class="layui-form-label">客户名称</label>
				<div class="layui-input-inline" >
						<input type="text" name="customername" id="customername" lay-verify="required" autocomplete="off"
							class="layui-input">
	   			</div>
				<label class="layui-form-label">公司电话</label>
				<div class="layui-input-inline" >
					<input type="text" name="telephone" id="telephone" lay-verify="number" autocomplete="off"
						class="layui-input">
				</div>
		</div>
		<div class="layui-form-item">
				<label class="layui-form-label">邮编</label>
				<div class="layui-input-inline">
				<input type="text" name="zip" id="zip" lay-verify="number" autocomplete="off"
					class="layui-input">
		 		</div>
		</div>
		<div class="layui-form-item">
				<label class="layui-form-label">公司地址</label>
			<div class="layui-input-block" style="width: 80%">
				<input type="text" name="address" id="address" lay-verify="required" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div class="layui-form-item" style="margin-top: 10px">
			<label class="layui-form-label">联系人</label>
			<div class="layui-input-inline" >
				<input type="text" name="connectionperson" id="connectionperson" lay-verify="required" autocomplete="off"
					class="layui-input">
			</div>
			<label class="layui-form-label">联系人电话</label>
			<div class="layui-input-inline" >
				<input type="text" name="phone" id="phone" lay-verify="number" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
				<label class="layui-form-label">邮箱</label>
				<div class="layui-input-inline">
				<input type="text" name="email" id="email" lay-verify="email" autocomplete="off"
					class="layui-input">
		 		</div>
		</div>
		
		<div class="layui-form-item" style="margin-top: 10px">
			<label class="layui-form-label">开户银行</label>
			<div class="layui-input-inline" >
				<input type="text" name="bank" id="bank" lay-verify="required" autocomplete="off"
					class="layui-input">
			</div>
			<label class="layui-form-label">银行账号</label>
			<div class="layui-input-inline" >
				<input type="text" name="account" id="account" lay-verify="number" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
				<label class="layui-form-label">传真</label>
			<div class="layui-input-inline" >
				<input type="text" name="fax" id="fax" lay-verify="number" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">是否可用</label>
				<div class="layui-input-inline">
					<input type="radio" name="available" value="1" title="是" checked="">
					<input type="radio" name="available" value="0" title="否"> 
				</div>
		</div>
		
		
		
		<div class="layui-form-item">
			<div class="layui-input-block" style="text-align: center;">
				<!--lay-submit标记当按钮是一个提交按钮   -->
				<a class="layui-btn" lay-submit="" lay-filter="customerSubmit">提交</a>
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
		
		
		form.on("submit(customerSubmit)",function(data){
			var params = $('#frm').serialize();
		    $.post('${ctx}/customer/addCustomer.action',params,function(data){
				layer.msg(data.msg);
				var index = layer.getFrameIndex(window.name);
				layer.close(index);
				window.parent.datareload();
			});
		
		});			  
	});
</script>
</html>