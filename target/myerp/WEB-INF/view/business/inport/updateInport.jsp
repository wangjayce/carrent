<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>进货单管理菜单</title>
<link rel="stylesheet" href="${ctx }/resources/zTree/css/metroStyle/metroStyle.css" type="text/css">
<link rel="stylesheet" href="${ctx }/resources/css/public.css" media="all" />
<link rel="stylesheet" href="${ctx }/resources/layui/css/layui.css" media="all" />
<link rel="stylesheet" type="text/css" href="${ctx }/resources/plugin/css/index.css">

</head>
<body>
<form class="layui-form" action="#" method="get" id="frm" lay-filter="frm">
		<!-- 	<form class="layui-form  layui-form-pane" action="#" method="get"> -->
		<div class="layui-form-item" style="margin-top: 20px">
			<div class="layui-inline">
				<label class="layui-form-label">选择供应商</label>
			    <div class="layui-input-block">
			      <select name="providerid" id="providerid" lay-filter="providerid">
			        <option value="">请选择供应商</option>
			        <c:forEach var="sn" items="${list }">
				        <option value="${sn.id }"  ${sn.id==inport.providerid?"selected":"" } >${sn.providername }</option>
			        </c:forEach>
			      </select>
			    </div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">商品名称</label>
				<div class="layui-input-inline">
					 <select name="goodsid" value="${inport.goodsid }" id="goodsid" lay-filter="aihao">
					        <option value="">请选择商品</option>
				      </select>
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">进货数量</label>
			<div class="layui-input-inline">
				<input type="text" name="number" value="${inport.number }" id="number" lay-verify="number"
						autocomplete="off" class="layui-input">
				<input type="hidden" name="id" value="${inport.id }">
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">进货价格</label>
				<div class="layui-input-inline">
					<input type="text" name="inportprice" value="${inport.inportprice }" id="inportprice" lay-verify="number"
						autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">支付方式</label>
					<div class="layui-inline">
						<input type="radio" name="paytype" value="支付宝" title="支付宝" ${inport.paytype=="支付宝"?"checked":"" }> 
						<input type="radio" name="paytype" value="微信" title="微信" ${inport.paytype=="微信"?"checked":"" }>
						<input type="radio" name="paytype" value="银联" title="银联" ${inport.paytype=="银联"?"checked":"" }>
					</div>
				</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">进货备注</label>
			<div class="layui-input-block">
				<textarea rows="5" cols="80%" name="remark">${inport.goodsid }</textarea>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block" style="text-align: center;">
				<!--lay-submit标记当按钮是一个提交按钮   -->
				<a class="layui-btn" lay-submit="" lay-filter="inportSubmit">提交</a>
				<button lay-reset="" class="layui-btn layui-btn-normal">重置</button>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript" src="${ctx }/resources/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/resources/zTree/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${ctx }/resources/zTree/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="${ctx }/resources/plugin/js/selectTree.js"></script>

<script type="text/javascript">
	layui.use([ 'form','jquery','layer' ], function() {
		var form=layui.form;//得到form对象
		var $=layui.jquery;
		var layer = parent.layer === undefined ? layui.layer : parent.layer;
		
		form.on('select(providerid)', function(data){
    	  	providerid = data.value;
    	  	goodsid = "";
    	  	initGoods(providerid);
	    });
		var providerid="${inport.providerid}";
		var goodsid = "${inport.goodsid}";
		function initGoods(){
    	  	$.post('${ctx}/goods/queryGoodsByPid.action',{providerid:providerid},function(data){
    	  		var html = "";
    			for(var i=0;i<data.length;i++){
    				if(goodsid==data[i].id){
    					html += "<option selected value="+data[i].id+">"+data[i].goodsname+"</option>";
    				}else{
    					html += "<option value="+data[i].id+">"+data[i].goodsname+"</option>";
    				}
    			}
    			$('#goodsid').html(html);
    			form.render('select');
    	  	},'json');
		}
		initGoods();
		
		form.on("submit(inportSubmit)",function(data){
			var params = $('#frm').serialize();
			 $.post('${ctx}/inport/updateInport.action',params,function(data){
				layer.msg(data.msg);
				parent.tablereload();
				var index = layer.getFrameIndex(window.name);
				layer.close(index);
			});
		
		});		
	

	});
	


</script>
</html>