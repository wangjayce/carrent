<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户管理</title>
</head>
<frameset cols="250,*" border="1" frameborder="yes">
	<frame name="left" src="${ctx }/user/toUserLeft.action">
	<frame name="right" src="${ctx }/user/toUserRight.action">
</frameset>
</html>