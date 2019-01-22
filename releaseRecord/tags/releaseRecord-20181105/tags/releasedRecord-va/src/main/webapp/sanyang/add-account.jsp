<%--
  Created by IntelliJ IDEA.
  User: SYY
  Date: 2018/9/11
  Time: 17:57
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
    <title>新增用户</title>
    <link rel="stylesheet" href="<%=basePath%>resources/commons/css/base.css"/>
    <link rel="stylesheet" href="<%=basePath%>resources/commons/css/widget.css"/>
    <link rel="stylesheet" href="<%=basePath%>resources/commons/js/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="<%=basePath%>sanyang/css/topbar.css"/>
    <link rel="stylesheet" href="<%=basePath%>sanyang/css/add-account.css"/>
    <style>
        .main{
            height: 300px;
        }
        .account {
            background-color: #7d7d7d;
        }
        .content{
            width: 700px;
        }
        .btn-box {
            padding: 0 0px;
        }
        .btn-box button {
            color: #fff;
        }
    </style>
</head>
<body>
<div class="main">
    <div class="title">
        <div class="detention-title">
            <div class="top-box">
                <i class="iconfont-sy tab-pic">&#xe752;</i>
                <span class="title-text">新增账号</span>
            </div>
        </div>
    </div>
    <form class="layui-form content">
        <div class="layui-inline">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input name" placeholder="-" value="${userData.USER_ACCT_CN}"/>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">编号</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input serial" placeholder="-" value="${userData.USER_SERIAL}"/>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">账号</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input account" placeholder="-" value="${userData.USER_ACCT}"
                       readonly="readonly"/>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-inline">
                <input type="password" class="layui-input password" placeholder="-" value="${userData.USER_ACCT_PWD}"/>
            </div>
        </div>
        <%--<div class="layui-form-item">--%>
            <%--<label class="layui-form-label">角色</label>--%>
            <%--<div class="layui-input-block role">--%>
                <%--<select name="interest" lay-filter="aihao">--%>
                    <%--<option value="CHAKANJIAOSE" selected>查看角色</option>--%>
                    <%--<option value="BIANJIJIAOSE">编辑角色</option>--%>
                <%--</select>--%>
            <%--</div>--%>
        <%--</div>--%>
    </form>
</div>
<!-- 底部两个按钮 -->
<div class="btn-box fr clearfix">
    <button class="layui-btn layui-btn-normal conserve_bnt">保存</button>
    <button class="layui-btn layui-btn-normal close_bnt">关闭</button>
</div>
</body>
<script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-debug.js"></script>
<script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-config-debug.js"></script>
<script type="text/javascript" src="<%=basePath%>resources/commons/js/layui/layui.js"></script>
<script>
    var type = "${type}";
    var userId = "${userData.USER_ID}";
    var role = "${userData.ROLE_SERIAL}";
    var address = "<%=basePath%>";
    seajs.use('<%=basePath%>sanyang/js/add-account.js')
</script>
</html>