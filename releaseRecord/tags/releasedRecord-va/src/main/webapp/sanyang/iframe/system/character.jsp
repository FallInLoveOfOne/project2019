<%--
  Created by IntelliJ IDEA.
  User: SYY
  Date: 2018/9/11
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    request.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>iframe</title>
    <link rel="stylesheet" href="<%=basePath%>resources/commons/css/base.css" />
    <link rel="stylesheet" href="<%=basePath%>resources/commons/css/widget.css" />
    <link rel="stylesheet" href="<%=basePath%>resources/commons/js/layui/css/layui.css"  media="all" />
    <link rel="stylesheet" href="<%=basePath%>sanyang/css/character.css" />
    <style>
        .content {
            behavior:url('<%=basePath%>sanyang/css/PIE.htc');
            position: relative;
            z-index: 5;
            box-shadow: 0 0 10px 0 #eaeef2;
        }
    </style>
</head>
<body>
<div class="content">
    <!-- 列表 -->
    <div class="content-bottom">
        <div class="table-box">
            <table class="layui-hide" id="test" lay-filter="demo"></table>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-debug.js"></script>
<script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-config-debug.js"></script>
<script type="text/javascript" src="<%=basePath%>resources/commons/js/layui/layui.js"></script>
<script>
    var address = "<%=basePath%>";
    seajs.use(['<%=basePath%>sanyang/js/layout.js','<%=basePath%>sanyang/js/character.js'])
</script>
</html>