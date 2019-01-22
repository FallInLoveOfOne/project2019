<%--
  Created by IntelliJ IDEA.
  User: SYY
  Date: 2018/9/11
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
    <link rel="stylesheet" href="<%=basePath%>resources/commons/css/base.css"/>
    <link rel="stylesheet" href="<%=basePath%>resources/commons/css/widget.css"/>
    <link rel="stylesheet" href="<%=basePath%>resources/commons/js/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="<%=basePath%>sanyang/css/account.css"/>
    <style>
        .cktimebtn, .check-bottom .new-add, .temp-btn, .check-btn {
            behavior: url('<%=basePath%>sanyang/css/PIE.htc');
            position: relative;
            z-index: 5;
            border-radius: 2px;
        }

        .check-bottom .new-add {
            box-sizing: border-box;
            border: solid 1px #999;
            font-size: 14px;
            color: #333;
            background-color: #fff;
            margin-right: 15px;
        }
        .check-bottom .add_btn{
            margin-left: 15px;
        }

        .content-top, .content-bottom {
            behavior: url('<%=basePath%>sanyang/css/PIE.htc');
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
                <div class="ipt-people clearfix">
                    <div class="people-wait fl">
                        <label class="layui-form-label">姓名</label>
                        <div class="layui-input-block">
                            <input type="text" name="title" lay-verify="title" autocomplete="off" placeholder="未填写"
                                   class="layui-input name_input">
                        </div>
                    </div>
                    <div class="people-num fl">
                        <label class="layui-form-label">人员编号</label>
                        <div class="layui-input-block">
                            <input type="text" name="title" lay-verify="title" autocomplete="off" placeholder="未填写"
                                   class="layui-input serial_input">
                        </div>
                    </div>
                </div>
            </div>
            <div class="check fr">
                <div class="check-bottom clearfix">
                    <!-- <div class="layui-input-inline temp-btn"></div> -->
                    <div class="layui-input-inline layui-btn check-btn add_btn fr">新增</div>
                    <div class="layui-input-inline layui-btn check-btn query_btn fr" data-type="reload">查询</div>
                </div>
            </div>
        </div>
    </div>
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
<script type="text/html" id="titleTpr">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-xs" lay-event="del">删除</a>
</script>
<script>
    var address = "<%=basePath%>";
    seajs.use(['<%=basePath%>sanyang/js/layout.js', '<%=basePath%>sanyang/js/account.js'])
</script>
</html>
