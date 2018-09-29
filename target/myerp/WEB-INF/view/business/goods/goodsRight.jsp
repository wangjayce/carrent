<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>商品管理列表</title>
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
				      <label class="layui-form-label">生产批号</label>
				      <div class="layui-input-inline">
				        <input type="text" name="productcode" id="productcode"   autocomplete="off" class="layui-input">
				      </div>
			    </div>
			    <div class="layui-inline">
				      <label class="layui-form-label">商品规格</label>
				      <div class="layui-input-inline">
				        <input type="tel" name="size" id="size"  autocomplete="off" class="layui-input">
				      </div>
			    </div>
		  </div>
	    
		  <div class="layui-form-item" style="text-align: center">
	    	   <a href="javascript:void(0)" class="search_btn layui-btn" >查询</a>
	    	   <button type="reset" class="layui-btn layui-btn-warm">重置</button>
		  </div>
	</form>
	<table id="goodsList" lay-filter="goodsList"></table>
	

	<!--操作-->
	<script type="text/html" id="goodsListBar">
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
                productcode: $("#productcode").val(),
                size : $("#size").val(),
                id : id,
              }
		});
	}
	
    layui.use(['form','layer','laydate','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;

	   
	    
	    //商品列表
	    tableIns = table.render({
	        elem: '#goodsList',
	        url : '${ctx}/goods/uploadAllGoods.action',
	        cellMinWidth : 95,
	        page : true,
	        height : "full-225",
	        limit : 10,
	        limits : [10,15,20,25],
			toolbar:'#tabletoorbar',
	        id : "goodsList",
	        cols : [[
	            {type: "checkbox", fixed:"left", width:50},
	            {field: 'id', title: '商品ID', width:100, align:"center"},
	            {field: 'goodsname', title: '商品名称', width:160, align:"center"},
	            {field: 'providername', title: '供应商', width:160, align:"center"},
	            {field: 'produceplace', title: '产地', align:'center'},
	            {field: 'description', title: '商品备注',width:200, align:'center'},
	            {field: 'size', title: '商品规格', align:'center'},
	            {field: 'goodspackage', title: '商品包装', align:'center'},
	            {field: 'productcode', title: '生产批号', width:160,align:'center'},
	            {field: 'promitcode', title: '批准文号',width:160, align:'center'},
	            {field: 'price', title: '商品价格', align:'center'},
	            {field: 'number', title: '库存', align:'center'},
	            {field: 'dangernum', title: '预警库存', align:'center'},
	            {field: 'goodsimg', title: '商品图标', align:'center',templet:function(data){
	            	return "<img alt='图片找不到' width=25px height=25px src='"+data.goodsimg+"'/>"
	            }},
	            {field: 'available', title: '是否可用', align:'center',templet:function(data){
	            	return data.available==1?"<font color=blue>可用</font>":"<font color=red>不可用</font>"
	            }},
	            {title: '操作', width:170, templet:'#goodsListBar',fixed:"right",align:"center"}
	        ]]
	    });
	
        //监听头工具栏事件
        table.on('toolbar(goodsList)', function(obj){
            switch(obj.event){
                case 'batchDelet':
		            var checkStatus = table.checkStatus(obj.config.id),
		            data = checkStatus.data; //获取选中的数据
                	var ids="?a=1";
                	 if(data.length > 0) {
 	                    for (var i in data) {
 	                    	ids+="&ids="+data[i].id;
 	                    }
 	                    layer.confirm('确定删除选中的商品？', {icon: 3, title: '提示信息'}, function (index) {
 	                         $.post("${ctx}/goods/deleteGoods.action"+ids,function(data){
 	                        	layer.msg(data.msg);
 	                        	tableIns.reload();
 	                        	layer.close(index);
 	                         })
 	                    })
 	                }else{
 	                    layer.msg("请选择需要删除的商品");
 	                }
                    break;
                case 'add':
                	addGoods();
                	break;
            };
        });
        function addGoods(){
        	layer.open({
      		  type: 2, 
      		  title:'添加商品',
      		  content: '${ctx}/goods/toaddGoods.action', //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
      		  area : ['800px','600px']
        	}); 
        }
        
        function updateGoods(id){
        	layer.open({
      		  type: 2, 
      		  title:'修改商品',
      		  content: '${ctx}/goods/toupdateGoods.action?id='+id, //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
      		  area : ['800px','600px']
        	}); 
        }
	
	   
	
	    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
	    $(".search_btn").on("click",function(){
	    		tablereload();
	    });
	
	  
	    //列表操作
	    table.on('tool(goodsList)', function(obj){
	        var layEvent = obj.event,
	            data = obj.data;
	        if(layEvent === 'update'){
	        	updateGoods(data.id);
	        }
			if(layEvent === 'del'){ //删除
	            layer.confirm('确定删除此商品？',{icon:3, title:'提示信息'},function(index){
	                $.post("${ctx}/goods/deleteGoods.action",{
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