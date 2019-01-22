<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="cn.innosoft.en.util.PropsUtil"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <title>历史记录详情</title>
        <base href="<%=basePath%>">
        <link rel="stylesheet" href="<%=basePath%>resources/commons/css/base.css" />
        <link rel="stylesheet" href="<%=basePath%>resources/commons/css/widget.css" />
        <link rel="stylesheet" href="<%=basePath%>resources/commons/js/layui/css/layui.css" media="all" />
        <link rel="stylesheet" href="<%=basePath%>sanyang/css/topbar.css" />
        <link rel="stylesheet" href="<%=basePath%>sanyang/css/released-detail02.css" />
    </head>
    <body>
        <div class="top-bar">
            <div class="top-l fl">
                <img src="sanyang/imgs/police.png" alt="">
                <span class="top-l-title">温州市三垟强制隔离戒毒所防放错智能管理系统</span>
            </div>
        </div>
        <div class="content-box">
            <div class="title">已释放人员详情</div>
           
            <div class="out-record">
                <div class="detention-title">
                    <i class="iconfont-sy">&#xe752;</i>
                    <span class="title-text">出所执行记录</span>
                </div>
                <div class="record-table">
                    <table class="layui-hide" id="record" lay-filter="demo1"></table>
                </div>
            </div>
            <div class="certificate-info">
                <div class="detention-title">
                    <div class="title-left fl">
                        <i class="iconfont-sy">&#xe752;</i>
                        <span class="title-text">存证信息</span>
                    </div>
                </div>
                <!-- <div class="certificate-table">
                    <table class="layui-hide" id="certificate" lay-filter="demo2"></table>
                </div> -->
                 <div class="certificate-table">
                    <table id="save-info">
                        <thead>
                            <tr>
                                <td>文件名称</td>
                                <td>出所单类型</td>
                                <td>操作时间</td>
                                <td>操作事项</td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>出所单</td>
                                <td>电子文档</td>
                                <td><span id="currTime">2018</span></td>
                                <td>
                                    <div class="check-out-btn">查看出所单</div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- 底部两个按钮 -->
            <div class="btn-box fr clearfix">
                <button class="layui-btn closeBT" data-method="notice">关闭</button>
            </div>
        </div>
        <!-- 附件上传隐藏表单 -->
		<div style="display:none;">
			 <form id="outListUploadFrm" action="<%=basePath%>release/upload/outList" enctype="multipart/form-data" method="post" >
		        <input name="oldFileMsg" id="oldFileMsg" type="hidden" value="" />
		        <input name="personNumber" type="hidden" value="${resultMap.NUMBER}" />
		        <input name="personName" type="hidden" value="${resultMap.NAME}" />
		        <input name="upType" type="hidden" value="cz" />
		        <input id="outList_name" name="outList_name" type="hidden" value="" />
				<input id="listAccessoryFile" name="filename" type="file"  onChange="accessoryUploadPhoto();"/>
				<input type="submit" value="上传附件">
			</form>
		</div>
    </body>
    <script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-debug.js"></script>
	<script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-config-debug.js"></script>
    <script type="text/javascript" src="<%=basePath%>resources/commons/js/layui/layui.js"></script>
    <script type="text/html" id="titleTpr">
        <a class="layui-btn layui-btn-xs" lay-event="download">下载</a>
    </script> 
    
    <script type="text/html" id="titleTpr3">
        <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="checkList">查看出所单</a>
    </script> 
    
      <script type="text/html" id="titleTpr1">
        <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看详情</a>
    </script> 
    <script>
    	var address = "<%=basePath%>";
    	var historyid = "${historyid}";
    	var number = "${number}";
    	var prisonId = "${prisonId}";
        seajs.use('<%=basePath%>sanyang/js/released-detail2.js');
    </script>
</html>