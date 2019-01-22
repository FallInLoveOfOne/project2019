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
        <title>登录页</title>
        <base href="<%=basePath%>">
		<link rel="stylesheet" href="<%=basePath%>resources/commons/css/base.css" />
		<link rel="stylesheet" href="<%=basePath%>resources/commons/css/widget.css" />
		<link rel="stylesheet" href="<%=basePath%>resources/commons/js/layui/css/layui.css" media="all" />
		<link rel="stylesheet" href="<%=basePath%>sanyang/css/login.css" />
		<style>
			input::-ms-clear, input::-ms-reveal{ display:none; }
			.login-btn {
				behavior:url('<%=basePath%>sanyang/css/PIE.htc');
                position: relative;
                z-index: 10;
                border-radius: 23px;
			}
			/* body {
				background-image: url('./imgs/login_01.jpg');
				background-size: cover;
				background-repeat: no-repeat; 
    			background-position: center center;
				filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(
						enabled=true,
						src='./imgs/login_01.jpg',
						sizingMethod='scale');
			} */
			.top-pic {
				background-image: url('<%=basePath%>sanyang/imgs/login_02_03.png');
				background-size: 70px 70px;
				background-repeat: no-repeat; 
    			background-position: center;
				filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(
						src='./imgs/login_02_03.png',
						sizingMethod='scale');
			}
            .error{
                width: 100px;
                line-height: 15px;
                font-size: 16px;
                color: red;
                margin: 0 auto;
                cursor: pointer;
            }         
		</style>
    </head>
    <body>
		<!-- <div class="top-stand"></div> -->
		<img src="<%=basePath%>sanyang/imgs/login_01.jpg" alt="">
		<div class="login-box">
			<div class="top-pic"></div>
			<div class="top-title">温州市三垟强制隔离戒毒所防放错智能管理系统</div>
			<div class="user-name">
				<input id="acctIn" class="placeholder" type="text" placeholder="请输入账号" />
				<i class="iconfont-sy icon-account">&#xe742;</i>
			</div>
			<div class="user-passwords">
				<input id="passwordIn" class="placeholder" type="password" placeholder="请输入密码" />
				<i class="iconfont-sy icon-password">&#xe742;</i>
			</div>
			<div class="login-btn">登录</div>
			<div class="tips">建议使用谷歌浏览器访问， <span class="tips-spe">点击下载</span> 谷歌浏览器 </div>
            <div class="error">${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}</div>
<!-- 			<div class="forget-pw">忘记密码？</div> -->
		</div>
		<form style="display:none;" action="logon">
			<input name="account" type="text" class="input-style" id="accountFormIn"/>
			<input name="password" type="password" class="input-style" id="passwordFormIn"/>
		</form>
		<form name ="downGoogle" style="display:none;" action="<%=basePath%>home/downGoogle" enctype="multipart/form-data">
			<input name="chrome32or64" type="text" value=""/> 
		</form>
    </body>
	<script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-debug.js"></script>
	<script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-config-debug.js"></script>
	<script type="text/javascript" src="<%=basePath%>resources/commons/js/layui/layui.js"></script>
	<script>
		seajs.use("<%=basePath%>sanyang/js/login.js")
	</script>
</html>