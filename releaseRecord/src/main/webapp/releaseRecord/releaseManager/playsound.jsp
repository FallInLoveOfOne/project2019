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
	<audio controls id="MyAudio2" hidden>
        <source src="<%=basePath%>releaseRecord/releaseManager/js/黄昏里.mp3" type="audio/mpeg"> 
    </audio>
	<span id="BT">点击</span>
</body>

<script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-debug.js"></script>
<script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-config-debug.js"></script>
<script type="text/javascript" src="<%=basePath%>resources/commons/js/layui/layui.js"></script>
<script>
	function playVid() {
	    MyAudio2.play(); 
	}
	var address = "<%=basePath%>";
    seajs.use("<%=basePath%>releaseRecord/releaseManager/js/playsound.js")
</script>
</html>