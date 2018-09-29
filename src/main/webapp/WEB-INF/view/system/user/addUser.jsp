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
<body>
	<form class="layui-form" action="#" method="get" id="frm" lay-filter="frm">
		<!-- 	<form class="layui-form  layui-form-pane" action="#" method="get"> -->
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">所属部门</label>
				<div class="layui-input-inline">
					 <div id="deptid" name="deptid" class="select-tree layui-form-select">
           			 </div>
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">排序码</label>
				<div class="layui-input-inline">
					<input type="text" name="ordernum" id="ordernum" lay-verify="number"
						autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">领导部门</label>
				<div class="layui-input-inline">
					 <div id="leaderdeptid" name="leaderdeptid" class="select-tree layui-form-select">
           			 </div>
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">领导姓名</label>
				<div class="layui-input-inline">
						<select name="mgr"  id="mgr">
						  <option value="">选择领导</option>
						</select>   
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">用户姓名</label>
				<div class="layui-input-inline">
					 <input type="text" name="name" id="name" 
						autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">登陆账号</label>
				<div class="layui-input-inline">
					<input type="text" name="loginname" id="loginname"
						autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
				
		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">用户备注</label>
			<div class="layui-input-block">
				<textarea placeholder="请输入内容" name="remark" id="remark" class="layui-textarea"></textarea>
			</div>
		</div>
		
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">用户地址</label>
				<div class="layui-input-inline">
					 <input type="text" name="address" id="address" 
						autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">用户性别</label>
				<div class="layui-input-inline">
					<input type="radio" name="sex" value="1" title="男" checked="">
					<input type="radio" name="sex" value="0" title="女" >
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">入职时间</label>
				<div class="layui-input-inline">
					 <input type="text" name="hiredate" id="hiredate" 
						autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">是否可用</label>
				<div class="layui-input-inline">
					<input type="radio" name="available" value="1" title="是" checked="">
					<input type="radio" name="available" value="0" title="否" >
				</div>
			</div>
		</div>
		
		<div class="layui-form-item">
			<div class="layui-input-block" style="text-align: center;">
				<!--lay-submit标记当按钮是一个提交按钮   -->
				<a class="layui-btn" lay-submit="" lay-filter="userSubmit">提交</a>
				<button lay-reset="" class="layui-btn layui-btn-normal">重置</button>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript" src="${ctx }/resources/layui/layui.js"></script>

<script type="text/javascript">
		
	var layer;
	var form;
	
	layui.use([ 'form','jquery','layer','laydate' ], function() {
		form=layui.form;//得到form对象
		var $=layui.jquery;
		var laydate = layui.laydate;
		
		laydate.render({
			elem:'#hiredate'
		});
		
		layer = parent.layer === undefined ? layui.layer : parent.layer;
		
		form.on("submit(userSubmit)",function(data){
			var params = $('#frm').serialize();
			$.post('${ctx}/user/addUser.action',params,function(data){
				layer.msg(data.msg);
				parent.tablereload();
				var index = layer.getFrameIndex(window.name);
				layer.close(index);
			});
		
		});	
		$('#name').on('blur',function(){
			var name = $(this).val();
			$.post('${ctx}/user/parseFontForPinyin.action',{name:name},function(data){
				$('#loginname').val(data);
			});
		});

	});
		
	function initSelect(deptid){
		$.post('${ctx}/user/queryAllUserByDeptId.action',{deptid:deptid},function(data){
			var html = "";
			for(var i=0;i<data.length;i++){
				html += "<option value="+data[i].id+">"+data[i].name+"</option>";
			}
			$('#mgr').html(html);
			form.render('select');
		},'json');
		
	}

    $(document).ready(function () {		   
    		initDeptTree();		    	
	  
    })
    
    function initDeptTree(zNodes){
		 $.post('${ctx}/dept/loadDeptTree.action',function(zNodes){
	    	 initSelectTree("deptid",zNodes,false);
	    	 initSelectTree("leaderdeptid",zNodes,false);
	         $(".layui-nav-item a").bind("click", function () {
	            if (!$(this).parent().hasClass("layui-nav-itemed") && !$(this).parent().parent().hasClass("layui-nav-child")) {
	                $(".layui-nav-tree").find(".layui-nav-itemed").removeClass("layui-nav-itemed")
	            }
	         })
		  });
    }
	

</script>
</html>