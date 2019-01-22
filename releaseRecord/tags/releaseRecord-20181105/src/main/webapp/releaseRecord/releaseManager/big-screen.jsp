<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <title>大屏</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="<%=basePath%>resources/commons/css/base.css" />
    <link rel="stylesheet" href="<%=basePath%>resources/commons/css/widget.css" />
    <link rel="stylesheet" href="<%=basePath%>resources/commons/js/layui/css/layui.css"  media="all" />
    <link rel="stylesheet" href="<%=basePath%>sanyang/css/normal.css" />
</head>
<body>
	<div class="outer-img">
        <img class="inside-img" style="width:76px;height:100px;" src="data:image/png;base64,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">
    </div>
    <div>
    	<span id="person-info"></span>
    </div>
    <hr/>
    <button onclick="closeWebSocket()">close</button>
    <hr/>
    <div id="message"></div>
</body>

<%-- <script type="text/javascript" src="<%=basePath%>releaseRecord/releaseManager/js/jquery.js" ></script> --%>
<script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-debug.js"></script>
<script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-config-debug.js"></script>
<script type="text/javascript" src="<%=basePath%>resources/commons/js/layui/layui.js"></script>
<script>
	var address = "<%=basePath%>";
	var sb = "${sb}";
	var closeWebSocket;
    seajs.use("<%=basePath%>releaseRecord/releaseManager/js/big-screen.js")
</script>
</html>