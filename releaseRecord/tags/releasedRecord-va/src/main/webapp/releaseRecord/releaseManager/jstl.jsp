<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setAttribute("basePath", basePath);
%>
<%@ page import="cn.innosoft.en.util.PropsUtil"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<base href="<%=basePath%>">
	<meta charset="UTF-8">
	<title>jstl</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>resources/commons/css/base.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>resources/commons/css/widget.css" />
</head>
<body>
	<div>
		<div>
			<span>${mapEnt.zz}</span>
			<span>${mapEnt.aa}</span>
		</div>
		<div>
			<c:forEach var="oneEnt" items="${mapEnt.list2}">
				<span>${oneEnt.cc}</span>
				<span>${oneEnt.vv}</span>
			</c:forEach>	
		</div>
	</div>
    <script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-debug.js"></script>
    <script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-config-debug.js"></script>
    <script>
    	var address = "<%=basePath%>";
        seajs.use('<%=basePath%>releaseRecord/releaseManager/js/faceCheck.js');
    </script>
</body>
</html>