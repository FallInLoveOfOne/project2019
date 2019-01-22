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
        <title>待出所人员详情</title>
        <base href="<%=basePath%>">
        <link rel="stylesheet" href="<%=basePath%>resources/commons/css/base.css" />
        <link rel="stylesheet" href="<%=basePath%>resources/commons/css/widget.css" />
        <link rel="stylesheet" href="<%=basePath%>resources/commons/js/layui/css/layui.css" media="all" />
        <link rel="stylesheet" href="<%=basePath%>sanyang/css/topbar.css" />
        <link rel="stylesheet" href="<%=basePath%>sanyang/css/will-release-detail.css" />
        <style>
            .basic-info, .outer-img, .detention-info, .layui-layer {
                behavior:url('<%=basePath%>sanyang/css/PIE.htc');
                position: relative;
                z-index: 5;
                box-shadow: 0 0 10px 0 #eaeef2;
                background-color: #fff;
            }
        </style>
    </head>
    <body>
        <div class="top-bar">
            <div class="top-l fl">
                <img src="sanyang/imgs/police.png" alt="">
                <span class="top-l-title">温州市三垟强制隔离戒毒所防放错智能管理系统</span>
            </div>
        </div>
        <div class="content-box">
            <div class="title">待出所人员详情</div>
            <!-- 中间基本信息 -->
            <div class="basic-info">
                <div class="basic-title">
                    <i class="iconfont-sy tab-pic">&#xe752;</i>
                    <span class="title-text">基本信息</span>
                </div>
                <div class="basic-content clearfix">
                    <div class="basic-img fl">
                        <div class="outer-img">
                            <img class="inside-img" src="<%=basePath%>Photomsg/${mapObj.photoPath}">
                        </div>
                    </div>
                    <div class="basic-detail fl">
                        <div class="detail-content">
                            <div class="basic-id detail-item">
                                <ul class="clearfix">
                                    <li class="basic-id-list fl">
                                        <div>
                                            <span class="mw80">姓名：</span>
                                            <span>${mapObj.NAME}</span>                                            
                                        </div>
                                        <div>
                                            <span class="mw80">别名：</span>
                                            <span>${mapObj.OTHER_NAME}</span>
                                        </div>
                                    </li>
                                    <li class="basic-id-list fl">
                                        <div>
                                            <span class="mw80">证件类型：</span>
                                            <span>${mapObj.IDENTITY_TYPE_VALUE}</span>                                            
                                        </div>
                                        <div>
                                            <span class="mw80">证件号码：</span>
                                            <span>${mapObj.IDENTITY_ID}</span>
                                        </div>
                                    </li>
                                    <li class="basic-id-list fl">
                                        <div>
                                            <span class="mw100">性别：</span>
                                            <span>${mapObj.SEX_VALUE}</span>                                            
                                        </div>
                                        <div>
                                            <span class="mw100">出生日期：</span>
                                            <span>${mapObj.BIRTH}</span>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <div class="basic-city detail-item">
                                <ul class="clearfix">
                                    <li class="basic-city-list fl">
                                        <div>
                                            <span class="mw80">国籍：</span>
                                            <span>${mapObj.NATIONALITY_VALUE}</span>                                            
                                        </div>
                                        <div>
                                            <span class="mw80">民族：</span>
                                            <span>${mapObj.ETHNIC_GROUP_VALUE}</span>
                                        </div>
                                        <div>
                                            <span class="mw80">政治面貌：</span>
                                            <span>${mapObj.POLITICAL_STATUS_VALUE}</span>
                                        </div>
                                    </li>
                                    <li class="basic-city-list fl">
                                        <div>
                                            <span class="mw80">人员编号：</span>
                                            <span>${mapObj.NUMBER}</span>                                            
                                        </div>
                                        <div>
                                            <span class="mw80">籍贯：</span>
                                            <span>${mapObj.ORIGIN_VALUE}</span>
                                            </div>
                                        <div>
                                            <span class="mw80">人员类别：</span>
                                            <span>${mapObj.MANAGE_TYPE_VALUE}</span>
                                        </div>
                                    </li>
                                    <li class="basic-city-list fl">
                                        <div>
                                            <span class="mw100">户籍所在地：</span>
                                            <span>${mapObj.HOUSE_ADDR_VALUE}</span>                                            
                                        </div>
                                        <div>
                                            <span class="mw100">户籍详细地址：</span>
                                            <span>${mapObj.HOUSE_DETAIL_ADDR}</span>
                                        </div>
                                        <div>
                                            <span class="mw100">工作单位：</span>
                                            <span>${mapObj.WORK_ADDR}</span>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <div class="basic-job detail-item">
                                <ul class="clearfix">
                                    <li class="basic-job-list fl">
                                        <div>
                                            <span class="mw80">职业：</span>
                                            <span>${mapObj.WORK_VALUE}</span>                                            
                                        </div>
                                        <div>
                                            <span class="mw80">职务：</span>
                                            <span>${mapObj.POSITION}</span>
                                        </div>
                                    </li>
                                    <li class="basic-job-list fl">
                                        <div>
                                            <span class="mw80">文化程度：</span>
                                            <span>${mapObj.EDUCATION_VALUE}</span>                                            
                                        </div>
                                        <div>
                                            <span class="mw80">专长：</span>
                                            <span>${mapObj.SPECIALTY_VALUE}</span>
                                        </div>
                                    </li>
                                    <li class="basic-job-list fl">
                                        <div>
                                            <span class="mw100">重口人员：</span>
                                            <span>${mapObj.EMPHASIS_PERSONER_VALUE}</span>                                            
                                        </div>
                                        <div>
                                            <span class="mw100">特殊身份：</span>
                                            <span>${mapObj.SPECIAL_INDENTITY_VALUE}</span>
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
                    <i class="iconfont-sy tab-pic">&#xe752;</i>
                    <span class="title-text">拘留信息</span>
                </div>
                <div class="detention-content">
                    <ul class="list-box clearfix">
                        <li class="detention-item fl">
                            <div>
                                <span class="mw80">监室号：</span>
                                <span>${mapObj.DORM_CODE}</span>                                            
                            </div>
                            <div>
                                <span class="mw80">出所日期：</span>
                                <span>${mapObj.OUT_DATE}</span>
                            </div>
                            <div>
                                <span class="mw80">简要案情：</span>
                                <span>${mapObj.BRIEF}</span>
                            </div>
                        </li>
                        <li class="detention-item fl">
                            <div>
                                <span class="mw80">戒赌年限：</span>
                                <span>${mapObj.DETOX_LIMIT_VALUE}</span>                                            
                            </div>
                            <div>
                                <span class="mw80">出所流程状态：</span>
                                <span>${mapObj.PROCESS_STATE}</span>
                            </div>
                        </li>
                        <li class="detention-item fl">
                            <div>
                                <span class="mw80">开始戒毒日期：</span>
                                <span class="formatdate">${mapObj.DETOX_BEGIN}</span>                                            
                            </div>
                            <div>
                                <span class="mw80">出所原因：</span>
                                <span>${mapObj.OUT_REASON_VALUE}</span>
                            </div>
                        </li>
                        <li class="detention-item fl">
                            <div>
                                <span class="mw80">结束戒毒日期：</span>
                                <span class="formatdate">${mapObj.DETOX_END}</span>                                            
                            </div>
                            <div>
                                <span class="mw80">出所去向：</span>
                                <span>${mapObj.OUT_PLACE_VALUE}</span>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
            <!-- 底部两个按钮 -->
            <div class="btn-box fr clearfix">
                <!-- <button class="layui-btn" data-method="notice">出所</button> -->
                <button data-method="offset" data-type="auto" class="layui-btn layui-btn-normal">出所</button>
                <button class="layui-btn layui-btn-primary">关闭</button>
            </div>
        </div>
    </body>
    <script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-debug.js"></script>
	<script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-config-debug.js"></script>
	<script type="text/javascript" src="<%=basePath%>resources/commons/js/layui/layui.js"></script>
    <script>
	    var address = "<%=basePath%>";
		var personNumber_ = "${mapObj.NUMBER}";
		var prisonId_ = "${mapObj.DORM_CODE}";
		var userName_ = "${mapObj.NAME}";
		var holdEnd_ = "${mapObj.HOLD_END}";
		var detoxEnd_="${mapObj.DETOX_END}";
		var imprison_lim_ = "${mapObj.IMPRISON_LIMIT}";
		var outDate_="${mapObj.OUT_DATE}";
        // seajs.use(['./js/layout.js','./js/will-release-detail.js']);
        seajs.use(['<%=basePath%>sanyang/js/will-release-detail.js']);
    </script>
</html>