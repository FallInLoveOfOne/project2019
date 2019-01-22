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
        <title>强制隔离人员出所通知单</title>
        <base href="<%=basePath%>">
        <link rel="stylesheet" href="<%=basePath%>/resources/commons/css/base.css" />
        <link rel="stylesheet" href="<%=basePath%>/resources/commons/css/widget.css" />
        <link rel="stylesheet" href="<%=basePath%>/resources/commons/js/layui/css/layui.css" media="all" />
        <link rel="stylesheet" href="<%=basePath%>sanyang/css/topbar.css" />
        <link rel="stylesheet" href="<%=basePath%>sanyang/css/report-detail.css" />
    </head>
    <body>
        <div class="top-bar">
            <div class="top-l fl">
                <img src="sanyang/imgs/police.png" alt="">
                <span class="top-l-title">温州市三垟强制隔离戒毒所防放错智能管理系统</span>
            </div>
        </div>
        <div class="report-content clearfix">
            <div class="report-box fl">
                <div class="report-title">强制隔离戒毒人员出所通知单</div>
                <div class="report-text">
                    <div class="middle-box">
                        <div class="middle-top-box">
                            <div class="report-title-name">大队定岗台、警卫室：</div>
                            <div class="person-detail">
                                戒毒人员姓名
                                <span class="specil-word">${userObj.NAME}</span>
                                性别
                                <span class="specil-word">${userObj.SEX_VALUE}</span>
                                监室号
                                <span class="specil-word">${userObj.DORM_CODE}</span>
                            </div>
                            <div class="id-num">
                                身份证号码
                                <span class="specil-word word-id">${userObj.IDENTITY_ID}</span>
                            </div>
                            <div class="detail-text">
                                因<span class="specil-word word-reason">戒毒期限已满，正常出所</span>准予<span class="specil-word">${userObj.NAME}</span>出所。
                            </div>
                        </div>
                        <div class="person-info clearfix">
                            <div class="person-img fl">
                                <img src="<%=basePath%>Photomsg/${userObj.photoPath}" alt="">
                            </div>
                            <div class="person-detail-info fl">
                                <div class="info-name info-item">
                                    戒毒人员姓名：<span class="">${userObj.NAME}</span>
                                </div>
                                <div class="info-born info-item">
                                    出生年月：<span class="" id="perBirth">${userObj.BIRTH}</span>
                                </div>
                                <div class="in-time info-item">
                                    入所时间：<span class="">${userObj.COME_DATE}</span>
                                </div>
                                <div class="info-unit info-item">
                                    办案单位：<span class="">温州市三垟强制隔离戒毒所</span>
                                </div>
                                <div class="info-address info-item">
                                    户籍地址：<span class="">${userObj.HOUSE_ADDR_VALUE}</span>

                                </div>
                                <div class="info-now-address info-item">
                                    现住址：<span class="">${userObj.HOUSE_ADDR_VALUE}</span>
                                </div>
                            </div>
                            <div class="report-confirm-btn" style="cursor: pointer" id="closeBT">关闭</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script type="text/javascript" src="<%=basePath%>/resources/commons/js/seajs/sea-debug.js"></script>
	<script type="text/javascript" src="<%=basePath%>/resources/commons/js/seajs/sea-config-debug.js"></script>
    <script type="text/javascript" src="<%=basePath%>/resources/commons/js/layui/layui.js"></script>
    <script>
	    var address = "<%=basePath%>";
		var prisonId_ = "${prisonId}";
		var number_ = "${number}";
		var name_ = "${userObj.NAME}";
		var historyId = "${historyId}";
		var perBirth="${userObj.BIRTH}";
        seajs.use("<%=basePath%>sanyang/js/report-detail2.js")
    </script>
</html>