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
        <title>照片信息对比</title>
        <base href="<%=basePath%>">
        <link rel="stylesheet" href="<%=basePath%>resources/commons/css/base.css" />
        <link rel="stylesheet" href="<%=basePath%>resources/commons/css/widget.css" />
        <link rel="stylesheet" href="<%=basePath%>resources/commons/js/layui/css/layui.css" media="all" />
        <link rel="stylesheet" href="<%=basePath%>sanyang/css/topbar.css" />
        <link rel="stylesheet" href="<%=basePath%>sanyang/css/compare-img.css" />
        <link rel="stylesheet" href="<%=basePath%>sanyang/css/compare-success.css" />
        <style>
            .old-img, .new-img  {
                behavior:url('<%=basePath%>sanyang/css/PIE.htc');
                position: relative;
                z-index: 5;
                box-shadow: 0 0 10px 0 #eaeef2;
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
            <!-- <div class="title clearfix">
                <div class="pro-pic basic-check fl">
                    <div class="check-top pro-top"></div>
                    <div class="check-bottom pro-bottom pro-now">基本信息审核</div>
                </div>
                <div class="pro-bar bar-now fl"></div>
                <div class="pro-pic pic-comp fl">
                    <div class="comp-top pro-top"></div>
                    <div class="comp-bottom pro-bottom pro-now">头像对比</div>
                </div>
                <div class="pro-bar fl"></div>
                <div class="pro-pic upload-bill fl">
                    <div class="bill-top pro-top"></div>
                    <div class="bill-bottom pro-bottom">出所单上传</div>
                </div>
                <div class="pro-bar fl"></div>
                <div class="pro-pic out-success fl">
                    <div class="out-top pro-top"></div>
                    <div class="out-bottom pro-bottom">出所成功</div>
                </div>
            </div> -->
            <div class="img-box">
                <div class="option-box clearfix">
                    <div class="old-img fl">
                        <div class="old-top">
                            <img src="<%=basePath%>Photomsg/${resutlMap.photoPath}">
                        </div>
                        <div class="old-bottom">原头像</div>
                    </div>
                    <div class="text-img fl">
                        <div class="text-box">
                            <div style="display:none;" id="wrongImg" class="wrong-img dbimg">
                                <i class="iconfont-sy">&#xe751;</i>
                            </div>
                            <div style="display:none;" id="successImg" class="success-img dbimg">
                                <i class="iconfont-sy">&#xe74c;</i>
                            </div>
                            <div style="display:none;" id="dbText" class="wrong-text">头像对比失败，请重新拍摄</div>
<!--                             <div class="wrong-btn"> -->
<!--                                 <button style="display:none;" class="layui-btn optBt trueBT" id="leftBT">成功，下一步</button> -->
<!--                                 <button style="display:none;" class="layui-btn optBt falseZBBT" id="leftBT">失败，暂不出所</button> -->
<!--                                 <button style="display:none;" class="layui-btn optBt falseNextBT" id="leftBT">失败，跳过</button> -->
<!--                                 <button style="display:none;" class="layui-btn optBt zcdbBT" id="leftBT">再次对比</button> -->
<!--                                 <button class="layui-btn layui-btn-primary" id="rightBT">跳过</button> -->
<!--                             </div> -->
                        </div>
                    </div>
                    <div class="new-img fl">
                        <div class="new-top">
                            <img id="sbPh" src="" alt="">
                        </div>
                        <div class="new-bottom">
                            <div class="layui-inline">摄像头拍摄</div>
                            <!-- <button style="display:none;" class="layui-inline layui-btn" id="upFace">上传头像</button> -->
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="btn-box fr clearfix">
               	  <button style="display:none;" class="layui-btn optBt trueBT" id="leftBT">下一步</button>
                  <button style="display:none;" class="layui-btn layui-btn-error optBt falseZBBT" id="leftBT">暂不出所</button>
                  <button style="display:none;" class="layui-btn layui-btn-error optBt falseNextBT" id="leftBT">跳过对比</button>
                  <button style="display:none;" class="layui-btn layui-btn-error optBt zcdbBT" id="leftBT">获取对比结果</button>
<!--                   <button class="layui-btn layui-btn-primary" id="rightBT">跳过</button> -->
            </div>
        </div>
        <!-- 附件上传隐藏表单 -->
		<div style="display:none;">
			 <form id="outListUploadFrm" action="<%=basePath%>release/upload/facePhoto" enctype="multipart/form-data" method="post" >
		        <input name="oldFileMsg" id="oldFileMsg" type="hidden" value="" />
		        <input name="personNumber" type="hidden" value="${number}" />
		        <input name="ksUserId" type="hidden" value="${resutlMap.KS_USER_ID}" />
		        <input name="personName" type="hidden" value="${resutlMap.NAME}" />
		        <input id="photo_name" name="photo_name" type="hidden" value="" />
				<input id="listAccessoryFile" name="filename" type="file"  onChange="accessoryUploadPhoto();"/>
				<input type="submit" value="上传附件">
			</form>
		</div>
    </body>
    <script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-debug.js"></script>
	<script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-config-debug.js"></script>
    <script type="text/javascript" src="<%=basePath%>resources/commons/js/layui/layui.js"></script>
    <script>
	    var address = "<%=basePath%>";
		var prisonId_ = "${prisonId}";
		var number_ = "${number}";
		var name_ = "${resutlMap.NAME}";
		var photo = "<%=basePath%>Photomsg/${resutlMap.photoPath}";
		var ksuserId_ = "${resutlMap.KS_USER_ID}";
        seajs.use(['<%=basePath%>sanyang/js/layout.js','<%=basePath%>sanyang/js/compare-img.js']);
    </script>
</html>