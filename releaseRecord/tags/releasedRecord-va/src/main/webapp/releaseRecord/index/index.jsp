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
	<title>防错放系统</title>
	<base href="<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>resources/commons/css/base.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>resources/commons/css/widget.css" />
</head>

<body>
	<div class="cover">
		<span>欢迎来到首页</span><br>
		<!-- 本地图片映射 -->
		<img style="width:100px;height:100px" alt="" src="<%=basePath%>Photomsg/20180904104943093.jpg">
		<br>
		<div>
			<span>当前账号:${result.acct}</span><br>
			<span>当前角色:${result.role}</span><br>
			<span>当前名称:${result.name}</span>
		</div>
		<br>
		<input id="ajaxBt" type="button" value="ajax请求">
	</div>
	<script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-debug.js" ></script>
    <script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-config-debug.js"></script>
   	<script>
   		var address = "<%=basePath%>";   		
   		seajs.use("<%=basePath%>releaseRecord/index/js/index.js");
   	</script>
</body>
</html>