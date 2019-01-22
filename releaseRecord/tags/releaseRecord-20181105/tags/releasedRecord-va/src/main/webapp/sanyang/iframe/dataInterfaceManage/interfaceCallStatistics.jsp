<%--
  Created by IntelliJ IDEA.
  User: SYY
  Date: 2018/9/7
  Time: 16:19
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
    <title>接口调用统计</title>
    <link rel="stylesheet" href="../../resources/commons/css/base.css" />
    <link rel="stylesheet" href="../../resources/commons/css/widget.css" />
    <link rel="stylesheet" href="../../resources/commons/js/layui/css/layui.css"  media="all" />
    <link rel="stylesheet" href="../../sanyang/iframe/dataInterfaceManage/css/interfaceCallStatistics.css" />
    <style>
        .cktimebtn, .temp-btn, .check-btn {
            behavior:url('<%=basePath%>sanyang/css/PIE.htc');
            position: relative;
            z-index: 5;
            border-radius: 2px;
        }
        .content-top, .content-bottom {
            behavior:url('<%=basePath%>sanyang/css/PIE.htc');
            position: relative;
            z-index: 5;
            box-shadow: 0 0 10px 0 #eaeef2;
        }
    </style>
</head>
<body>
<div class="content">
    <!-- 正常待出所 iframe部分 上面查询条件一块 -->
    <div class="content-top">
        <div class="conditions clearfix">
            <div class="ipt fl">
                <div class="ipt-date clearfix">
                    <div class="fl">
                        <label class="layui-form-label">调用日期</label>
                        <div class="layui-input-inline">
                            <!-- <input type="text" class="layui-input" id="test-out-start" placeholder="yyyy-MM-dd"> -->
                            <i class="iconfont-sy">&#xe753;</i><input type="text" class="layui-input" id="test-out-start"           placeholder="-"><i class="iconfont-sy">&#xe754;</i>
                        </div>
                    </div>
                    <div class="fl">
                        <label class="layui-form-label">至</label>
                        <div class="layui-input-inline">
                            <!-- <input type="text" class="layui-input" id="test-out-end" placeholder="yyyy-MM-dd"> -->
                            <i class="iconfont-sy">&#xe753;</i><input type="text" class="layui-input" id="test-out-end" placeholder="-"><i class="iconfont-sy">&#xe754;</i>
                        </div>
                    </div>
                    <div class="fr">
                        <div class="layui-inline btn-title">快捷选择:</div>
                        <div class="layui-inline time-btn today-btn">今天</div>
                        <div class="layui-inline time-btn week-btn">本周内</div>
                        <div class="layui-inline time-btn mounth-btn">本月内</div>
                        <div class="layui-inline time-btn season-btn">本季内</div>
                    </div>
                </div>
            </div>
            <div class="check fr">
                <div class="layui-input-inline check-btn fr" data-type="reload">查询</div>
            </div>
        </div>
    </div>
    <!-- 列表 -->
    <div class="content-bottom">
        <div class="tab-table clearfix">
            <div class="excel-statis table-bar fl choosen-tab">
                <i class="iconfont-sy tab-pic">&#xe73e;</i><span>表格统计</span>
            </div>
            <div class="table-analyze table-bar fl">
                <i class="iconfont-sy tab-pic">&#xe746;</i><span>图表分析</span>
            </div>
        </div>
        <div class="manage-box">
            <div class="table-box">
                <table class="layui-hide" id="contentTable" lay-filter="demo"></table>
            </div>
            <div class="chart-box">
                <div class="chart-title">各接口调用数量占比</div>
                <div class="pie-chart" id="pie-chart"></div>
                <div class="chart-title">每日接口调用频率</div>
                <div class="line-chart" id="line-chart"></div>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-debug.js"></script>
<script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-config-debug.js"></script>
<script type="text/javascript" src="<%=basePath%>resources/commons/js/layui/layui.js"></script>
<script type="text/javascript" src="<%=basePath%>resources/commons/js/echart/echarts.min.js"></script>
<script>
    var address = "<%=basePath%>";
    seajs.use(['<%=basePath%>sanyang/js/layout.js','<%=basePath%>sanyang/iframe/dataInterfaceManage/js/interfaceCallStatistics.js']);
</script>
</html>
