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
	<title>三洋message</title>
	<base href="<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>resources/commons/css/base.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>resources/commons/css/widget.css" />
</head>

<body>
	<div class="cover">
		<div class="outer-img">
            <img class="inside-img" src="">
        </div>
		<div>
			<span id="showMessage"></span>
		</div>
		<input id="ajaxBt_" type="button" value="click">
	</div>
	<script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-debug.js" ></script>
    <script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-config-debug.js"></script>
   	<script>
   		var address = "<%=basePath%>";   		
   		seajs.use("<%=basePath%>releaseRecord/releaseManager/js/ajaxTime.js");
   	</script>
</body>
</html>