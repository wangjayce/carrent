<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>菜单管理</title>
</head>
<frameset cols="250,*" border="1" frameborder="yes">
	<frame name="left" src="${ctx }/menu/toMenuLeft.action">
	<frame name="right" src="${ctx }/menu/toMenuRight.action">
</frameset>
</html>