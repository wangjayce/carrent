<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>流程图</title>
</head>
<body>
	<img alt="资源找不到" style="position: absolute;"
		src="${ctx }/workFlow/viewProcessImage.action?deploymentId=${workFlowVo.deploymentId}">
	<c:if test="${!empty area }">
		<div
			style="position: absolute; border: red solid 1px ; height: ${area.height }px; width: ${area.width }px;margin-left: ${area.x}px;margin-top: ${area.y}px"></div>
	</c:if>
</body>
</html>