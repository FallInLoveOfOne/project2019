<%--
  Created by IntelliJ IDEA.
  User: SYY
  Date: 2018/9/11
  Time: 17:57
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
    <link rel="stylesheet" href="<%=basePath%>sanyang/css/password.css" />
    <style>
        .layui-btn {
            behavior:url('<%=basePath%>sanyang/css/PIE.htc');
            position: relative;
            z-index: 5;
            border-radius: 2px;
        }
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
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label">原密码</label>
            <div class="layui-input-block">
                <input type="password" name="title" lay-verify="title" autocomplete="off" placeholder="请输入原密码" class="layui-input oldPassword">
                <div class="layui-inline tip-text oldPassword_text" style="display: none;color:red;">请输入原密码</div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">新密码</label>
            <div class="layui-input-block">
                <input type="password" name="title" lay-verify="title" autocomplete="off" placeholder="请输入新密码" class="layui-input newPassword">
                <div class="layui-inline tip-text newPassword_text" style="display: none;color:red;">请输入6～12位密码，包含英文和数字</div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">重复新密码</label>
            <div class="layui-input-block">
                <input type="password" name="title" lay-verify="title" autocomplete="off" placeholder="请输入新密码" class="layui-input repeatNewPassword">
                <div class="layui-inline tip-text repeatNewPassword_text" style="display: none;color:red; ">两次密码输入不一致！</div>
            </div>
        </div>
    </form>
    <div class="btn-box">
        <div class="layui-btn confirm-btn">确认修改</div>
    </div>
</div>
</body>
<script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-debug.js"></script>
<script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-config-debug.js"></script>
<script type="text/javascript" src="<%=basePath%>resources/commons/js/layui/layui.js"></script>
<script>
    var address = "<%=basePath%>";
    seajs.use(['<%=basePath%>sanyang/js/layout.js','<%=basePath%>sanyang/js/password.js'])
</script>
</html>
