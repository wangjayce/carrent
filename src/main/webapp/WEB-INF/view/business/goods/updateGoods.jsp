<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>部门管理菜单</title>
<link rel="stylesheet" href="${ctx }/resources/zTree/css/metroStyle/metroStyle.css" type="text/css">
<link rel="stylesheet" href="${ctx }/resources/css/public.css" media="all" />
<link rel="stylesheet" href="${ctx }/resources/layui/css/layui.css" media="all" />
<link rel="stylesheet" type="text/css" href="${ctx }/resources/plugin/css/index.css">

</head>
<body>
		<form class="layui-form" action="#" method="get" id="frm" lay-filter="frm">
		<!-- 	<form class="layui-form  layui-form-pane" action="#" method="get"> -->
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">选择供应商</label>
			    <div class="layui-input-block">
			      <select name="providerid" id="providerid" lay-filter="providerid">
			        <option value="">请选择供应商</option>
			        <c:forEach var="sn" items="${list }">
				        <option value="${sn.id }" ${sn.id==goods.providerid?"selected":"" } >${sn.providername }</option>
			        </c:forEach>
			      </select>
			    </div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">商品名称</label>
			<div class="layui-input-inline">
				<input type="text" name="goodsname" value="${goods.goodsname }" id="goodsname" lay-verify="required"
						autocomplete="off" class="layui-input">
						<input type="hidden" name="id" value="${goods.id }">
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">商品产地</label>
				<div class="layui-input-inline">
					<input type="text" name="produceplace" value="${goods.produceplace }" id="produceplace" lay-verify="required"
						autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">商品规格</label>
			<div class="layui-input-inline">
				<input type="text" name="size" id="size" value="${goods.size }" lay-verify="required" autocomplete="off"
					class="layui-input">
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">商品包装</label>
				<div class="layui-input-inline">
					<input type="text" name="goodspackage" value="${goods.goodspackage }" id="goodspackage" lay-verify="required"
						autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">商品批号</label>
			<div class="layui-input-inline">
				<input type="text" name="productcode" value="${goods.productcode }" id="productcode" lay-verify="required" autocomplete="off"
					class="layui-input">
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">批准文号</label>
				<div class="layui-input-inline">
					<input type="text" name="promitcode" value="${goods.promitcode }" id="promitcode" lay-verify="required"
						autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">参考价格</label>
			<div class="layui-input-inline">
				<input type="text" name="price" value="${goods.price }" id="price" lay-verify="number" autocomplete="off"
					class="layui-input">
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">是否可用</label>
				<div class="layui-input-inline">
					<input type="radio" name="available" value="1" title="是" ${goods.available==1?"checked":"" }>
					<input type="radio" name="available" value="0" title="否" ${goods.available==0?"checked":"" }> 
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">库存</label>
			<div class="layui-input-inline">
				<input type="text" name="number" value="${goods.number }" id="number" lay-verify="number" autocomplete="off"
					class="layui-input">
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">预警库存</label>
				<div class="layui-input-inline">
					<input type="text" name="dangernum" value="${goods.dangernum }" id="dangernum" lay-verify="number"
						autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">商品描述</label>
			<div class="layui-input-block">
				<textarea rows="5" cols="80%" name="description">${goods.description }</textarea>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block" style="text-align: center;">
				<!--lay-submit标记当按钮是一个提交按钮   -->
				<a class="layui-btn" lay-submit="" lay-filter="goodsSubmit">提交</a>
				<button lay-reset="" class="layui-btn layui-btn-normal">重置</button>
			</div>
		</div>
		
		<div class="layui-upload">
			<button type="button" class="layui-btn" id="imgupload">更换图片</button>
			<label class="layui-form-label">图片名称</label>
			<div class="layui-input-inline">
				<input type="text" name="imgname" autocomplete="off"
					placeholder="请输入图片名称" id="imgname" class="layui-input">
				<input type="hidden" name="goodsimg" id="goodsimg">
			</div>
			<div class="layui-upload-list">
				<img class="layui-upload-img" name="imggoods" id="imggoods" width="80px" height="80px">
				<p id="errorimg"></p>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript" src="${ctx }/resources/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/resources/zTree/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${ctx }/resources/zTree/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="${ctx }/resources/plugin/js/selectTree.js"></script>

<script type="text/javascript">
	layui.use([ 'form','jquery','layer','upload' ], function() {
		var form=layui.form;//得到form对象
		var $=layui.jquery;
		var layer = parent.layer === undefined ? layui.layer : parent.layer;
		var upload = layui.upload;
		
	    $('#imggoods').attr('src', "${goods.goodsimg}");
		
		var uploadInst = upload.render({
		    elem: '#imgupload'
		    ,url: '${ctx}/upload/uploadImage.action'
		    ,before: function(obj){
		      //预读本地文件示例，不支持ie8
		      obj.preview(function(index, file, result){
		        $('#imggoods').attr('src', result); //图片链接（base64）
		      });
		    }
		    ,field:'mf'
		    ,data :{
		    	imgname : function(){
		    		return $('#imgname').val();
		    	}
		    }
		    ,done: function(res){
		      //如果上传失败
		      if(res.code > 0){
		        return layer.msg('上传失败');
		      }
		      $('#goodsimg').val(res.data.src);
		      //上传成功
		    }
		    ,error: function(){
		      //演示失败状态，并实现重传
		      var demoText = $('#errorimg');
		      errorimg.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
		      errorimg.find('.demo-reload').on('click', function(){
		        uploadInst.upload();
		      });
		    }
		  });
		
		form.on("submit(goodsSubmit)",function(data){
			var params = $('#frm').serialize();
			$.post('${ctx}/goods/updateGoods.action',params,function(data){
				layer.msg(data.msg);
				parent.tablereload();
				parent.parent.left.initTree();
				var index = layer.getFrameIndex(window.name);
				layer.close(index);
			});
		
		});		
	

	});
	


</script>
</html>