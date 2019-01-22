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
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>统计报告</title>
        <link rel="stylesheet" href="<%=basePath%>resources/commons/css/base.css" />
        <link rel="stylesheet" href="<%=basePath%>resources/commons/css/widget.css" />
        <link rel="stylesheet" href="<%=basePath%>resources/commons/js/layui/css/layui.css"  media="all" />
        <link rel="stylesheet" href="<%=basePath%>sanyang/css/report.css" />
    </head>
    <body>
        <div class="content">
            <!-- 报告 tab -->
            <div class="content-top clearfix">
                <div class="mounth-report tab-report fl" flag="week">周度报告
                    <div class="bar-mounth bar-report dpblock"></div>
                </div>
                <div class="season-report tab-report fl" flag="month">月度报告
                    <div class="bar-season bar-report"></div>
                </div>
                <div class="year-report tab-report fl" flag="year">年度报告
                    <div class="bar-year bar-report"></div>
                </div>
            </div>
            <!-- 列表 -->
            <div class="content-bottom">
                <div class="bar-box"></div>
                <div class="table-box">
                    <table class="layui-hide" id="test" lay-filter="demo"></table>
                </div>
            </div>
        </div>
    </body>
    <script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-debug.js"></script>
	<script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-config-debug.js"></script>
	<script type="text/javascript" src="<%=basePath%>resources/commons/js/layui/layui.js"></script>
    <script type="text/html" id="titleTpr">
        <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
        <a class="layui-btn layui-btn-xs" lay-event="edit"><!--下载--></a>
    </script> 
    <script>
   		var address = "<%=basePath%>";   
        seajs.use(["<%=basePath%>sanyang/js/layout.js","<%=basePath%>sanyang/js/report.js"])
    </script>
</html>