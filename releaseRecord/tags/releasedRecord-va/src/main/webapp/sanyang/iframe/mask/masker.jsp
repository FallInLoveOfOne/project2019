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
        <title>人脸识别</title>
        <base href="<%=basePath%>">
        <link rel="stylesheet" href="<%=basePath%>resources/commons/css/base.css" />
        <link rel="stylesheet" href="<%=basePath%>resources/commons/css/widget.css" />
        <link rel="stylesheet" href="<%=basePath%>resources/commons/js/layui/css/layui.css"  media="all" />
        <link rel="stylesheet" href="<%=basePath%>sanyang/css/masker.css" />
    </head>
    <body>
    	<!-- <button onclick="closeWebSocket()">close</button> -->
        <!-- 大图背景 -->
        <div class="container">
            <img class="full-bgi" src="<%=basePath%>sanyang/imgs/full_screen_1920.png" alt="">
            <div class="right-btn clearfix">
                <div class="btn-box fr clearfix">
                    <div class="full-screen-btn fl">
                        <i class="iconfont-sy full-screen">&#xe76a;</i>
                        <span class="full-screen-text">全屏</span>
                    </div>
                    <div class="logout-btn fl" style="display:none" >
                        <i class="iconfont-sy logout">&#xe73b;</i>
                        <span class="logout-text">退出</span>
                    </div>
                </div>
            </div>
            <div class="con-center">
                <div class="pic-text">
                    <div class="center-pic"><img src="<%=basePath%>sanyang/imgs/badge.png" alt=""></div> 
                    <div class="center-text">戒毒所防错放系统</div>
                </div>
            </div>
        </div>
        <!-- 弹窗 戒毒人员 -->
        <div class="shadow-box dpnone">
            <div class="result-box">
                <div class="mask-title clearfix">
                    <div class="title-line fl"></div>
                    <div class="title-box fl">
                        <!-- 未通过 -->
                        <i id="false-i" style="display:none;" class="iconfont-sy">&#xe751;</i> 
                        <!-- 已通过 -->
                        <i id="success-i" style="display:none;" class="iconfont-sy">&#xe750;</i> 
                        <span class="title-text">对比失败（审核流程未完成）</span>
                    </div>
                    <div class="title-line title-line-right fr"></div>
                </div>
                <ul class="person-info">
                    <div class="person-pic fl">
                        <img id="person-img" src="<%=basePath%>sanyang/imgs/compare_pic_03.jpg" alt="">
                    </div>
                    <ul class="person-detail fr">
                        <li>
                            <span class="person-name">姓名：</span><span class="name-text">邱云</span>
                        </li>
                        <li>
                            <span class="person-name">监室号：</span><span class="jsh-text"></span>
                        </li>
                        <li>
                            <span class="person-address">籍贯：</span><span class="address-text">浙江温州</span>
                        </li>
                        <li>
                            <span class="person-case">办案单位：</span><span class="case-text"></span>
                        </li>
                        <li>
                            <span class="person-type">出所类型：</span><span class="type-text">到期处所</span>
                        </li>
                        <li>
                            <span class="person-result">审批结果：</span><span class="result-text">同意</span>
                        </li>
                    </ul>
                </div>
                <!-- <div class="layui-btn police-comfirm">确&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;定</div> -->
            </div>
        </div>
        <!-- 弹窗 警务人员 -->
        <div class="police-box dpnone">
            <div class="police-info">
                <div class="police-pic">
                    <div class="pic-line">
                        <div class="pic-box">
                            <img id="police-img" src="<%=basePath%>sanyang/imgs/officer_03.png" alt="">
                        </div>
                    </div>
                </div>
                <div class="police-detail clearfix">
                    <div class="police-badge fl">
                        <img class="mj-text mj-logo" src="<%=basePath%>sanyang/imgs/badge.png" alt="">
                        <span class="police-text mj-text">民警</span>
                    </div>
                    <div class="splice-line fl"></div>
                    <div class="police-name fl">李志韬</div>
                </div>
            </div>
            <!-- <div class="layui-btn police-comfirm">确&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;定</div> -->
        </div>
        <div style="display:none;" id="message"></div>
    </body>
    <script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-debug.js"></script>
	<script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-config-debug.js"></script>
    <script type="text/javascript" src="<%=basePath%>resources/commons/js/layui/layui.js"></script>
    <script>
    	var address = "<%=basePath%>";
		var closeWebSocket;
        seajs.use(['<%=basePath%>sanyang/js/layout.js','<%=basePath%>sanyang/js/masker.js', '<%=basePath%>sanyang/js/getDate.js', '<%=basePath%>sanyang/js/setPlaceholder.js'])
    </script>
</html>