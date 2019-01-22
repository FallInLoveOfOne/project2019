<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="cn.innosoft.en.util.PropsUtil"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>search</title>
	<base href="<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>releaseRecord/releaseManager/js/select/selectpage.css" />
</head>

<body>
	<div>
		<input type="text" id="selectPage" >
	</div>
	<script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-debug.js" ></script>
    <script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-config-debug.js"></script>
    <script type="text/javascript" src="<%=basePath%>releaseRecord/releaseManager/js/select/jquery-1.9.1.min.js"></script>
    <%-- <script type="text/javascript" src="<%=basePath%>releaseRecord/releaseManager/js/select/selectpage.js"></script> --%>
   	<script>
   		var address = "<%=basePath%>"; 
   		seajs.use(['<%=basePath%>releaseRecord/releaseManager/js/select-pa.js','<%=basePath%>releaseRecord/releaseManager/js/select/selectpage.js']);
   	</script>
</body>
</html>