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
        <title>已释放人员详情</title>
        <base href="<%=basePath%>">
        <link rel="stylesheet" href="<%=basePath%>resources/commons/css/base.css" />
        <link rel="stylesheet" href="<%=basePath%>resources/commons/css/widget.css" />
        <link rel="stylesheet" href="<%=basePath%>resources/commons/js/layui/css/layui.css" media="all" />
        <link rel="stylesheet" href="<%=basePath%>sanyang/css/topbar.css" />
        <link rel="stylesheet" href="<%=basePath%>sanyang/css/released-detail.css" />
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
            <!-- 中间基本信息 -->
            <div class="basic-info">
                <div class="basic-title">
                    <i class="iconfont-sy">&#xe752;</i>
                    <span class="title-text">基本信息</span>
                </div>
                <div class="basic-content clearfix">
                    <div class="basic-img fl">
                        <div class="outer-img">
                            <img class="inside-img" src="<%=basePath%>Photomsg/${resultMap.personPhoto} ">
                        </div>
                    </div>
                    <div class="basic-detail fl">
                        <div class="detail-content">
                            <div class="basic-id detail-item">
                                <ul class="clearfix">
                                    <li class="basic-id-list fl">
                                        <div>
                                            <span class="mw80">姓名：</span>
                                            <span>${resultMap.NAME}</span>                                            
                                        </div>
                                        <div>
                                            <span class="mw80">别名：</span>
                                            <span>${resultMap.OTHER_NAME}</span>
                                        </div>
                                    </li>
                                    <li class="basic-id-list fl">
                                        <div>
                                            <span class="mw80">证件类型：</span>
                                            <span>${resultMap.IDENTITY_TYPE_VALUE}</span>                                            
                                        </div>
                                        <div>
                                            <span class="mw80">证件号码：</span>
                                            <span>${resultMap.IDENTITY_ID}</span>
                                        </div>
                                    </li>
                                    <li class="basic-id-list fl">
                                        <div>
                                            <span class="mw100">性别：</span>
                                            <span>${resultMap.SEX_VALUE}</span>                                            
                                        </div>
                                        <div>
                                            <span class="mw100">出生日期：</span>
                                            <span>${resultMap.BIRTH}</span>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <div class="basic-city detail-item">
                                <ul class="clearfix">
                                    <li class="basic-city-list fl">
                                        <div>
                                            <span class="mw80">国籍：</span>
                                            <span>${resultMap.NATIONALITY_VALUE}</span>                                            
                                        </div>
                                        <div>
                                            <span class="mw80">民族：</span>
                                            <span>${resultMap.ETHNIC_GROUP_VALUE}</span>
                                        </div>
                                        <div>
                                            <span class="mw80">政治面貌：</span>
                                            <span>${resultMap.POLITICAL_STATUS_VALUE}</span>
                                        </div>
                                    </li>
                                    <li class="basic-city-list fl">
                                        <div>
                                            <span class="mw80">人员编号：</span>
                                            <span>${resultMap.NUMBER}</span>                                            
                                        </div>
                                        <div>
                                            <span class="mw80">籍贯：</span>
                                            <span>${resultMap.ORIGIN_VALUE}</span>
                                            </div>
                                        <div>
                                            <span class="mw80">人员类别：</span>
                                            <span>${resultMap.MANAGE_TYPE_VALUE}</span>
                                        </div>
                                    </li>
                                    <li class="basic-city-list fl">
                                        <div>
                                            <span class="mw100">户籍所在地：</span>
                                            <span>${resultMap.HOUSE_ADDR_VALUE}</span>                                            
                                        </div>
                                        <div>
                                            <span class="mw100">户籍详细地址：</span>
                                            <span>${resultMap.HOUSE_DETAIL_ADDR}</span>
                                        </div>
                                        <div>
                                            <span class="mw100">工作单位：</span>
                                            <span>${resultMap.WORK_ADDR}</span>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <div class="basic-job detail-item">
                                <ul class="clearfix">
                                    <li class="basic-job-list fl">
                                        <div>
                                            <span class="mw80">职业：</span>
                                            <span>${resultMap.WORK_VALUE}</span>                                            
                                        </div>
                                        <div>
                                            <span class="mw80">职务：</span>
                                            <span>${resultMap.POSITION}</span>
                                        </div>
                                    </li>
                                    <li class="basic-job-list fl">
                                        <div>
                                            <span class="mw80">文化程度：</span>
                                            <span>${resultMap.EDUCATION_VALUE}</span>                                            
                                        </div>
                                        <div>
                                            <span class="mw80">专长：</span>
                                            <span>${resultMap.SPECIALTY_VALUE}</span>
                                        </div>
                                    </li>
                                    <li class="basic-job-list fl">
                                        <div>
                                            <span class="mw100">重口人员：</span>
                                            <span>${resultMap.EMPHASIS_PERSONER_VALUE}</span>                                            
                                        </div>
                                        <div>
                                            <span class="mw100">特殊身份：</span>
                                            <span>${resultMap.SPECIAL_INDENTITY_VALUE}</span>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- 中间拘留信息 -->
            <div class="detention-info">
                <div class="detention-title">
                    <i class="iconfont-sy">&#xe752;</i>
                    <span class="title-text">拘留信息</span>
                </div>
                <div class="detention-content">
                    <ul class="list-box clearfix">
                        <li class="detention-item fl">
                            <div>
                                <span class="mw80">监室号：</span>
                                <span>${resultMap.DORM_CODE}</span>                                            
                            </div>
                            <div>
                                <span class="mw80">出所日期：</span>
                                <span class="formatdate">${resultMap.OUT_DATE}</span>
                            </div>
                            <div>
                                <span class="mw80">简要案情：</span>
                                <span>${resultMap.BRIEF}</span>
                            </div>
                        </li>
                        <li class="detention-item fl">
                            <div>
                                <span class="mw80">戒毒年限：</span>
                                <span>${resultMap.DETOX_LIMIT_VALUE}</span>                                            
                            </div>
                            <div>
                                <span class="mw80">出所流程状态：</span>
                                <span>${resultMap.PROCESS_STATE}</span>
                            </div>
                        </li>
                        <li class="detention-item fl">
                            <div>
                                <span class="mw80">开始戒毒日期：</span>
                                <span class="formatdate">${resultMap.DETOX_BEGIN}</span>                                            
                            </div>
                            <div>
                                <span class="mw80">出所原因：</span>
                                <span>${resultMap.OUT_REASON_VALUE}</span>
                            </div>
                        </li>
                        <li class="detention-item fl">
                            <div>
                                <span class="mw80">结束戒毒日期：</span>
                                <span class="formatdate">${resultMap.DETOX_END}</span>                                            
                            </div>
                            <div>
                                <span class="mw80">出所去向：</span>
                                <span>${resultMap.OUT_PLACE_VALUE}</span>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
           <!--  <div class="out-record">
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
                    <div class="title-right fr" id="accUpload">
                        <i class="iconfont-sy">&#xe74b;</i>
                        <span class="title-text">添加出所单</span>
                    </div>
                </div>
                <div class="certificate-table">
                    <table class="layui-hide" id="certificate" lay-filter="demo2"></table>
                </div>
            </div> -->
            
            <!-- 出所历史记录 -->
             <div class="out-record3">
                <div class="detention-title">
                    <i class="iconfont-sy">&#xe752;</i>
                    <span class="title-text">出所记录</span>
                </div>
                <div class="record-table">
                    <table class="layui-hide" id="record3" lay-filter="demo3"></table>
                </div>
            </div>
            <!-- 底部两个按钮 -->
            <div class="btn-box fr clearfix">
                <button class="layui-btn out-office-btn" data-method="notice">出所</NOtton>
                <button class="layui-btn close-box-btn" data-method="notice">关闭</NOtton>
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
    <script type="text/html" id="titleTpr1">
        <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看详情</a>
    </script> 
    <script>
    	var address = "<%=basePath%>";
    	var personNumber_ = "${resultMap.NUMBER}";
    	var prisonId_ = "${resultMap.DORM_CODE}";
    	var userName_ = "${resultMap.NAME}";
    	var holdEnd_ = "${resultMap.HOLD_END}";
    	var outDate ="${resultMap.OUT_DATE}";
        seajs.use('<%=basePath%>sanyang/js/released-detail.js');
    </script>
</html>