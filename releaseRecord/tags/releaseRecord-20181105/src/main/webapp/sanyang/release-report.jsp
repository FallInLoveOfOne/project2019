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
        <link rel="stylesheet" href="<%=basePath%>resources/commons/js/layui/css/layui.css" media="all" />
        <link rel="stylesheet" href="<%=basePath%>sanyang/css/topbar.css" />
        <link rel="stylesheet" href="<%=basePath%>sanyang/css/release-report.css" />
        <style>
            .report-main {
                behavior:url('<%=basePath%>sanyang/css/PIE.htc');
                position: relative;
                z-index: 9;
                box-shadow: 0px 0px 20px #f4f5f7;
            }
            .load {
			    width: 80px;
			    height: 34px;
			    line-height: 34px;
			    text-align: center;
			    border-radius: 2px;
			    background-color: #1773d0;
			    color: #f2f2f2;
			    cursor: pointer;
			    float: right;
			    }
        </style>
    </head>
    <body>
        <div class="top-bar">
            <div class="top-l fl">
                <img src="<%=basePath%>sanyang/imgs/police.png" alt="">
                <span class="top-l-title">温州市三垟强制隔离戒毒所防放错智能管理系统</span>
            </div>
        </div>
        <div class="report-main">
            <div class="report-title">
                ${titleName}
            </div>
            <div class="report-info clearfix">
                <div class="report-time fl">
                    报告时间: 
                    <span>${inTime}</span>
                </div>
                <div class="report-type fr">
                    报告类型: 
                    <span>${reportType}报告</span>
                </div>
            </div>
            <div class="report-intro">
                本月我戒毒所计划出所20人，实际出所犯人18名，其中男性18人，女性0人。执行狱警张sir出所8人，王sir出所4人，徐sir出所6人，验证信息均通过。
            </div>
            <div class="report-chart clearfix">
                <div class="pie-chart fl" id="pie-chart"></div>
                <div class="line-chart fl" id="line-chart"></div>
            </div>
            <div class="load">报告导出</div>
			<form name="exportReport" action="<%=basePath%>report/getReport" style="display: none" method="post">
				  <input name="title" type="text" value="导出"/>
				  <input name="imag" type="text" /> 
				  <input name="image2" type="text" /> 
			</form>
        </div>
    </body>
    <script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-debug.js"></script>
	<script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-config-debug.js"></script>
    <script type="text/javascript" src="<%=basePath%>resources/commons/js/echart/echarts.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>resources/commons/js/layui/layui.js"></script>
    <script>
	    var reportType="${reportType}";
		var inTime="${inTime}";
		var titleName="${titleName}";
		var id="${id}";
		var address = "<%=basePath%>";
        seajs.use('<%=basePath%>sanyang/js/release-report.js');
    </script>
</html>