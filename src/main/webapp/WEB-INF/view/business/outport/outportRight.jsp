<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>退货单管理列表</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="${ctx }/resources/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="${ctx }/resources/css/public.css" media="all" />
</head>
<body class="childrenBody">

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>查询条件</legend>
</fieldset> 
	<form class="layui-form" method="post" id="searchForm">
		  <div class="layui-form-item">
			    <div class="layui-inline">
				      <label class="layui-form-label">商品名称</label>
				      <div class="layui-input-inline">
				        <input type="text" name="goodsname" id="goodsname" autocomplete="off" class="layui-input">
				      </div>
			    </div>
			    <div class="layui-inline">
				      <label class="layui-form-label">供应商名称</label>
				      <div class="layui-input-inline">
				        <input type="text" name="providername" id="providername"   autocomplete="off" class="layui-input">
				      </div>
			    </div>
		  </div>
		  <div class="layui-form-item">
			    <div class="layui-inline">
				      <label class="layui-form-label">起始时间</label>
				      <div class="layui-input-inline">
				        <input type="text" name="startDate" id="startDate" autocomplete="off" class="layui-input">
				      </div>
			    </div>
			    <div class="layui-inline">
				      <label class="layui-form-label">结束时间</label>
				      <div class="layui-input-inline">
				        <input type="text" name="endDate" id="endDate"   autocomplete="off" class="layui-input">
				      </div>
			    </div>
		  </div>
	    
		  <div class="layui-form-item" style="text-align: center">
	    	   <a href="javascript:void(0)" class="search_btn layui-btn" >查询</a>
	    	   <button type="reset" class="layui-btn layui-btn-warm">重置</button>
		  </div>
	</form>
	<table id="outportList" lay-filter="outportList"></table>
	

	<!--操作-->
	<script type="text/html" id="outportListBar">
		<a class="layui-btn layui-btn-xs layui-btn-warm" lay-event="update">修改</a>
		<a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
	</script>
	<!--操作-->
	<script type="text/html" id="tabletoorbar">
		<button class="layui-btn layui-btn-sm" lay-event="add">添加</button>
		<button class="layui-btn layui-btn-danger layui-btn-sm" lay-event="batchDelet">批量删除</button>
	</script>

<script type="text/javascript" src="${ctx }/resources/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/resources/zTree/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">

	var tableIns;
	function tablereload(id){
		tableIns.reload({
			  page: {
                  curr: 1 //重新从第 1 页开始
              },
              where: {
                goodsname: $("#goodsname").val() ,
                providername: $("#providername").val(),
                startDate : $("#startDate").val(),
                endDate : $("#endDate").val(),
                providerid : id,
              }
		});
	}
	
    layui.use(['form','layer','laydate','table'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        table = layui.table;

	   laydate.render({
		   elem : '#endDate'
	   });
	   laydate.render({
		   elem : '#startDate'
	   });
	    
	    //退货单列表
	    tableIns = table.render({
	        elem: '#outportList',
	        url : '${ctx}/outport/uploadAllOutport.action',
	        cellMinWidth : 95,
	        page : true,
	        height : "full-225",
	        limit : 10,
	        limits : [10,15,20,25],
			toolbar:'#tabletoorbar',
	        id : "outportList",
	        cols : [[
	            {type: "checkbox", fixed:"left", width:50},
	            {field: 'id', title: '退货单ID', width:100, align:"center"},
	            {field: 'paytype', title: '支付方式', width:100, align:"center"},
	            {field: 'goodsname', title: '商品名称', width:100, align:"center"},
	            {field: 'providername', title: '供应商', width:140, align:"center"},
	            {field: 'outportprice', title: '退货价格', align:'center'},
	            {field: 'outporttime', title: '退货时间', width:140, align:"center"},
	            {field: 'operateperson', title: '操作人',width:100, align:'center'},
	            {field: 'number', title: '退货数量', align:'center'},
	            {field: 'remark', title: '备注', align:'center'},
	            {title: '操作', width:170, templet:'#outportListBar',fixed:"right",align:"center"}
	        ]]
	    });
	
        //监听头工具栏事件
        table.on('toolbar(outportList)', function(obj){
            switch(obj.event){
                case 'batchDelet':
		            var checkStatus = table.checkStatus(obj.config.id),
		            data = checkStatus.data; //获取选中的数据
                	var ids="?a=1";
                	 if(data.length > 0) {
 	                    for (var i in data) {
 	                    	ids+="&ids="+data[i].id;
 	                    }
 	                    layer.confirm('确定删除选中的退货单？', {icon: 3, title: '提示信息'}, function (index) {
 	                         $.post("${ctx}/outport/deleteOutport.action"+ids,function(data){
 	                        	layer.msg(data.msg);
 	                        	tableIns.reload();
 	                        	layer.close(index);
 	                         })
 	                    })
 	                }else{
 	                    layer.msg("请选择需要删除的退货单");
 	                }
                    break;
                case 'add':
                	addOutport();
                	break;
            };
        });
        function addOutport(){
        	layer.open({
      		  type: 2, 
      		  title:'添加退货单',
      		  content: '${ctx}/outport/toaddOutport.action', //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
      		  area : ['800px','600px']
        	}); 
        }
        
        function updateOutport(id){
        	layer.open({
      		  type: 2, 
      		  title:'修改退货单',
      		  content: '${ctx}/outport/toupdateOutport.action?id='+id, //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
      		  area : ['800px','600px']
        	}); 
        }
	
	   
	
	    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
	    $(".search_btn").on("click",function(){
	    		tablereload();
	    });
	
	  
	    //列表操作
	    table.on('tool(outportList)', function(obj){
	        var layEvent = obj.event,
	            data = obj.data;
	        if(layEvent === 'update'){
	        	updateOutport(data.id);
	        }
			if(layEvent === 'del'){ //删除
	            layer.confirm('确定删除此退货单？',{icon:3, title:'提示信息'},function(index){
	                $.post("${ctx}/outport/deleteOutport.action",{
	                     id : data.id  //将需要删除的Id作为参数传入
	                },function(data){		         
		                tableIns.reload();
		                layer.msg(data.msg);
		                layer.close(index);
	                })
	            });
			}
	    });
	
	 })
</script>
</body>
</html>