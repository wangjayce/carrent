<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>菜单管理菜单</title>
<link rel="stylesheet" href="${ctx }/resources/zTree/css/metroStyle/metroStyle.css" type="text/css">
<link rel="stylesheet" href="${ctx }/resources/css/public.css" media="all" />
<link rel="stylesheet" href="${ctx }/resources/layui/css/layui.css" media="all" />
<link rel="stylesheet" type="text/css" href="${ctx }/resources/plugin/css/index.css">

</head>
<body>
<form class="layui-form" action="#" method="get" id="frm" lay-filter="frm">
		<!-- 	<form class="layui-form  layui-form-pane" action="#" method="get"> -->
		<div class="layui-form-item" style="margin-top: 10px">
			<div class="layui-inline">
				<label class="layui-form-label">上级菜单</label>
				<div class="layui-input-inline">
					 <div id="pid" name="pid" class="select-tree layui-form-select">
           			 </div>
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">排序码</label>
				<div class="layui-input-inline">
					<input type="text" name="ordernum" id="ordernum" lay-verify="number"
						autocomplete="off" class="layui-input" value="${menu.ordernum }">
				</div>
				<input type="hidden" name="id" value="${menu.id }">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">菜单名称</label>
			<div class="layui-input-block" style="width: 80%">
				<input type="text" name="name" id="name" lay-verify="required" autocomplete="off"
					class="layui-input" value="${menu.name }">
			</div>			
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">菜单地址</label>
			<div class="layui-input-block" style="width: 80%">
				<input type="text" name="href" id="href"  autocomplete="off"
					class="layui-input" value="${menu.href }">
			</div>	
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">菜单图标</label>
			<div class="layui-input-inline">
				<input type="text" name="icon" id="icon"  autocomplete="off"
					class="layui-input" value="${menu.icon }">
			</div>
			<label class="layui-form-label">TARGET</label>
			<div class="layui-input-inline">
				<input type="text" name="target" id="target"  autocomplete="off"
					class="layui-input" value="${menu.target }">
			</div>
		</div>
			
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">是否展开</label>
				<div class="layui-input-inline">
					<input type="radio" name="open" value="1" title="是"  ${menu.open==1?"checked":""}>
					<input type="radio" name="open" value="0" title="否"  ${menu.open==0?"checked":""}> 
				</div> 
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">是否父节点</label>
				<div class="layui-input-inline">
					<input type="radio" name="parent" value="1" lay-filter="parent" title="是"  ${menu.parent==1?"checked":"" }>
					<input type="radio" name="parent" value="0" lay-filter="parent" title="否"  ${menu.parent==0?"checked":"" }> 
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">是否可用</label>
				<div class="layui-input-inline">
					<input type="radio" name="available" value="1" title="是" ${menu.available==1?"checked":"" }>
					<input type="radio" name="available" value="0" title="否" ${menu.available==0?"checked":"" }> 
				</div>
			</div>
		</div>


		<div class="layui-form-item">
			<div class="layui-input-block" style="text-align: center;">
				<!--lay-submit标记当按钮是一个提交按钮   -->
				<a class="layui-btn" lay-submit="" lay-filter="menuSubmit">提交</a>
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
		
		form.on("submit(menuSubmit)",function(data){
			var params = $('#frm').serialize();
			$.post('${ctx}/menu/updateMenu.action',params,function(data){
				layer.msg(data.msg);
				parent.tablereload();
				parent.parent.left.initTree();
				var index = layer.getFrameIndex(window.name);
				layer.close(index);
			});
		
		});		
	

	});
	
    $(document).ready(function () {	
    		initMenuTree();		    		  
    })
    
    function initMenuTree(){
   		 $.post('${ctx}/menu/loadMenuTree.action',function(zNodes){
	    	 initSelectTree("pid",zNodes,false);
	    	  var pid = ${menu.pid}
		      var treeObj = $.fn.zTree.getZTreeObj("pidTree");
		      var node = treeObj.getNodeByParam("id", pid, null);
		      treeObj.selectNode(node);
      	 	  //渲染
     		  onClick(event,"pidTree",node);
	         $(".layui-nav-item a").bind("click", function () {
	            if (!$(this).parent().hasClass("layui-nav-itemed") && !$(this).parent().parent().hasClass("layui-nav-child")) {
	                $(".layui-nav-tree").find(".layui-nav-itemed").removeClass("layui-nav-itemed")
	            }
	         })
   		 });    
    }

</script>
</html>