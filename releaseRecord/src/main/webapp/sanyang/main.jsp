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
	<title>管理页</title>
	<base href="<%=basePath%>">
	<link rel="stylesheet" href="<%=basePath%>resources/commons/css/base.css" />
	<link rel="stylesheet" href="<%=basePath%>resources/commons/css/widget.css" />
	<link rel="stylesheet" href="<%=basePath%>resources/commons/js/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="<%=basePath%>sanyang/css/topbar.css" />
	<link rel="stylesheet" href="<%=basePath%>sanyang/css/main.css" />
</head>

<body class="outside">
	<div class="top-bar">
        <div class="top-l fl">
			<img src="sanyang/imgs/police.png" alt="">
			<span class="top-l-title">温州市三垟强制隔离戒毒所防放错智能管理系统</span>
		</div>
		<div class="top-r fr">
			<i class="iconfont-sy icon-user">&#xe756;</i>
			<span class="top-r-name">张小红</span>
			<span class="top-r-line"></span>
			<i class="iconfont-sy icon-logout"><!-- &#xe735; -->&#xe73b;</i>
		</div>
	</div>
	<div class="main clearfix">
		<div class="main-left fl">
			<div class="main-menu fl">
				<ul class="menus">
					<li>
						<ul>
							<li class="sub-menu cur index">
								<i class="iconfont-sy">&#xe738;</i><span>首页</span>
							</li>   
						</ul>
					</li>
					<li>
						<ul>
							<li class="sub-menu">
								<i class="iconfont-sy">&#xe754;</i><span>防错放管理</span>
							</li>   
							<li class="sub-menu2 ">
								<div class="menu-child cur now normal">
									<i class="iconfont-sy">&#xe737;</i><span>在所人员管理</span>
								</div>
								<div class="menu-child cur management">
									<i class="iconfont-sy">&#xe74d;</i><span>已出所人员管理</span>
								</div>
								<div class="menu-child cur report">
									<i class="iconfont-sy">&#xe736;</i><span>统计报告</span>
								</div>
							</li> 
						</ul>
					</li>
					<li>
						<ul>
							<li class="sub-menu">
								<i class="iconfont-sy">&#xe754;</i><span>数据接口管理</span>
							</li>
							<li class="sub-menu2">
								<div class="menu-child dataInterfaceList">
									<i class="iconfont-sy">&#xe747;</i><span>数据接口列表</span>
								</div>
								<!-- <div class="menu-child port">
									<i class="iconfont-sy">&#xe746;</i><span>接口调用统计</span>
								</div> -->
							</li>
						</ul>
					</li>
					<li>
						<ul>
							<li class="sub-menu">
								<i class="iconfont-sy">&#xe754;</i><span>系统管理</span>
							</li>
							<li class="sub-menu2">
								<div class="menu-child password">
									<i class="iconfont-sy">&#xe749;</i><span>修改密码</span>
								</div>
								<div class="menu-child account">
									<i class="iconfont-sy">&#xe748;</i><span>账号管理</span>
								</div>
							</li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
		<div class="main-right fl">
			<iframe class="fl" id="iframe" src="<%-- <%=basePath%>release/toReleaseManage?json= --%>" name="iframe" frameborder="0" style="width: 100%; height: 100%;"></iframe>
		</div>
	</div>
	<script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-debug.js"></script>
	<script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-config-debug.js"></script>
	<script type="text/javascript" src="<%=basePath%>resources/commons/js/layui/layui.js"></script>
    <script>
    	var address = "<%=basePath%>";
    	var ID = "${ID}";
    	var flag="${flag}";
    	var flagRedio="${flagRedio}";
    	var BusiStatus="${BusiStatus}";
    	//var searJson="${searJson}";
        seajs.use('<%=basePath%>sanyang/js/main.js');
    </script>
</body>
</html>