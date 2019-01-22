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
        <title>出所单上传</title>
        <base href="<%=basePath%>">
        <link rel="stylesheet" href="<%=basePath%>resources/commons/css/base.css" />
        <link rel="stylesheet" href="<%=basePath%>resources/commons/css/widget.css" />
        <link rel="stylesheet" href="<%=basePath%>resources/commons/js/layui/css/layui.css" media="all" />
        <link rel="stylesheet" href="<%=basePath%>sanyang/css/topbar.css" />
        <link rel="stylesheet" href="<%=basePath%>sanyang/css/upload-report.css" />
        <link rel="stylesheet" href="<%=basePath%>sanyang/css/uploadfile.css" />
        <link rel="stylesheet" href="<%=basePath%>sanyang/css/upload-success.css" />
    </head>
    <body>
        <div class="top-bar">
            <div class="top-l fl">
                    <img src="sanyang/imgs/police.png" alt="">
                <span class="top-l-title">温州市三垟强制隔离戒毒所防放错智能管理系统</span>
            </div>
        </div>
        <div class="content-box">
            <div class="title clearfix">
                <div class="pro-pic basic-check fl">
                    <div class="check-top pro-top"></div>
                    <div class="check-bottom pro-bottom pro-now">基本信息审核</div>
                </div>
                <div class="pro-bar bar-now fl"></div>
                <div class="pro-pic pic-comp fl">
                    <div class="comp-top pro-top"></div>
                    <div class="comp-bottom pro-bottom pro-now">头像对比</div>
                </div>
                <div class="pro-bar bar-now fl"></div>
                <div class="pro-pic upload-bill fl">
                    <div class="bill-top pro-top"></div>
                    <div class="bill-bottom pro-bottom pro-now">出所单上传</div>
                </div>
                <div class="pro-bar fl csSucess"></div>
                <div class="pro-pic out-success fl">
                    <div class="out-top pro-top"></div>
                    <div class="out-bottom pro-bottom">出所成功</div>
                </div>
            </div>
            <div class="img-box">
                <div class="upload-title">出所单上传</div>
                <div class="file-detail">文件类型支持word、pdf、jpg、png等格式</div>
                <div class="upload-area">
                    <!-- <div class="file-explain">将文件拖拽到这里，或者<span class="file-open">打开</span>文件夹</div> -->
                    
                    <div class="uploader" id="fileuploader"></div>
                </div>
                <ul class="upload-list">
                    <!-- <li class="clearfix">
                        <div class="file-pic fl">
                            <i class="iconfont-sy">&#xe743;</i>
                        </div>
                        <div class="file-progress fl">
                            <div class="file-name clearfix">
                                <span class="name-text fl">2018年9月12日关于王某某等人的临时出所报告.pdf</span>
                                <i class="iconfont-sy fr">&#xe73f;</i>
                            </div>
                            <div class="progress-bar layui-progress">
                                <div class="layui-progress-bar bg-color-pdf" lay-percent="20%"></div>
                            </div>
                            <div class="file-size">
                                <span>10.98KB</span>/<span>3.79MB</span>
                            </div>
                        </div>
                    </li>
                    <li class="clearfix">
                        <div class="file-pic fl">
                            <i class="iconfont-sy">&#xe744;</i>
                        </div>
                        <div class="file-progress fl">
                            <div class="file-name clearfix">
                                <span class="name-text fl">2018年9月12日关于王某某等人的临时出所报告.xls</span>
                                <i class="iconfont-sy fr">&#xe73f;</i>
                            </div>
                            <div class="progress-bar layui-progress">
                                <div class="layui-progress-bar bg-color-doc" lay-percent="20%"></div>
                            </div>
                            <div class="file-size">
                                <span>10.98KB</span>/<span>3.79MB</span>
                            </div>
                        </div>
                    </li> -->                    
                </ul>
                <div class="btn-box clearfix">
                    <!-- <div class="layui-btn fl">确认上传</div> -->
                    <div class="layui-btn fr" id="tiaoguo">跳过</div>
                </div>
            </div>
        </div>
        <div style='display:none;' class="mask-box haveupload">
            <div class="mask">
                <div class="right-close">
                    <i class="iconfont-sy">&#xe73f;</i>
                </div>
                <div class="mask-text clearfix">
                    <span class="fl"><i class="iconfont-sy">&#xe74c;</i></span>
                    <span class="fl">已完成出所单上传，所有操作均已记录,可在存证管理中查看。</span>
                </div>
                <div class="mask-btn clearfix">
                    <div class="layui-btn fr sureBT">确定</div>
                    <div class="layui-btn fr cancelBT">取消</div>
                </div>
            </div>
        </div>
        <div style='display:none;' class="mask-box noupload">
            <div class="mask">
                <div class="right-close">
                    <i class="iconfont-sy">&#xe73f;</i>
                </div>
                <div class="mask-text clearfix">
                    <span class="fl"><i class="iconfont-sy">&#xe74c;</i></span>
                    <span class="fl">所有操作均已记录,可在存证管理中查看。</span>
                </div>
                <div class="mask-btn clearfix">
                    <div class="layui-btn fr sureBT">确定</div>
                    <div class="layui-btn fr cancelBT">取消</div>
                </div>
            </div>
        </div>
    <script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-debug.js"></script>
	<script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-config-debug.js"></script>
	<script type="text/javascript" src="<%=basePath%>resources/commons/js/layui/layui.js"></script>
	<script type="text/javascript" src="<%=basePath%>resources/commons/js/jquery/jquery/1.10.1/jquery.js"></script>
	<!-- <script type="text/javascript" src="./js/jquery.form.js"></script> -->
    <script>
	    var address = "<%=basePath%>";
		var prisonId_ = "${prisonId}";
		var number_ = "${number}";
		var name_ = "${userObj.NAME}";
        seajs.use(['<%=basePath%>sanyang/js/layout.js','<%=basePath%>sanyang/js/jquery.uploadfile.js','<%=basePath%>sanyang/js/upload-report.js']);
    </script>
</body>
</html>