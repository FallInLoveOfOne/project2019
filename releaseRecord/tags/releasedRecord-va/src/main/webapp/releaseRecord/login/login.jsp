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
	<title>防错放系统</title>
	<base href="<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>resources/commons/css/base.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>resources/commons/css/widget.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>releaseRecord/login/css/login.css" />
</head>

<body>
	<div class="cover">
		<div class="content">
			<div class="left-content">
			</div>
			<div class="right-content">
				<div class="right-logo">
				</div>
				<div class="right-text">
				</div>
				<form class="" action="logon">
					<div class="right-input right-input-margin-top1">
						<i class="iconfont-wq">&#xe960;</i>
						<div class="input-line">
						</div>
						<input name="account" type=text class="input-style" id="account" placeholder="请输入用户名"/>
					</div>
					<div class="right-input right-input-margin-top2">
						<i class="iconfont-wq">&#xe961;</i>
						<div class="input-line">
						</div>
						<input name="password" type=password class="input-style" id="password" placeholder="请输入密码"/>
					</div>
				</form>
				<div class="right-checkbox">
					<input type="checkbox" name="记住密码" class="checkbox-style" id="rmbUser"/>
					<span class="remember-style">记住密码</span>
				</div>
				<!-- 登录失败显示 -->
				<span class = "error">${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}</span>
				<div class="right-login-button">
					<span class="login-button-text">登录</span>
				</div>
				<div class="no-reg">
					<!-- <span class="no-reg-text"><u>没有账号?立即注册</u></span> -->
				</div>
			</div>
			
			<div class="left-content-shadow">
				
			</div>
			<div class="right-content-shadow">
				
			</div>
			
		</div>
		
		<div class="jiutan-style">
			<span class="jiutan-text">Copyright© 2017 杭州久碳科技有限公司 版权所有</span>
		</div>
	</div>
	<script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-debug.js" ></script>
    <script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-config-debug.js"></script>
   	<script>
   		var address = "<%=basePath%>";   		
   		seajs.use("<%=basePath%>releaseRecord/login/js/login.js");
   	</script>
</body>
</html>