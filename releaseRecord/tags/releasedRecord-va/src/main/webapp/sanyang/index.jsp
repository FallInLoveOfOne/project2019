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
        <title>温州市三垟强制隔离戒毒所防放错智能管理系统</title>
		<link rel="stylesheet" href="<%=basePath%>resources/commons/css/base.css" />
		<link rel="stylesheet" href="<%=basePath%>resources/commons/css/widget.css" />
        <link rel="stylesheet" href="<%=basePath%>resources/commons/js/layui/css/layui.css" media="all" />
        <link rel="stylesheet" href="<%=basePath%>sanyang/css/topbar.css" />
        <link rel="stylesheet" href="<%=basePath%>sanyang/css/index.css" />
    </head>
    <body>
        <div class="top-bar">
            <div class="top-l fl">
                <img src="<%=basePath%>sanyang/imgs/police.png" alt="">
                <span class="top-l-title">温州市三垟强制隔离戒毒所防放错智能管理系统</span>
                <div class="top-m">
	           		<span class="topm-span bigFace" style="border-right: 1px solid #f5f5f5;padding: 5px 20px 5px 0px;">大屏</span>
                	<i class="iconfont-sy" style="margin-left:20px;">&#xe737;</i>
	           		<span class="topm-span will-view-more" style="border-right: 1px solid #f5f5f5;padding: 5px 20px 5px 0px;" flag="CS">在所人员管理</span>
	           		<i class="iconfont-sy" style="margin-left:20px;">&#xe74d;</i>
	           		<span class="topm-span last-view-more" style="border-right: 1px solid #f5f5f5;padding: 5px 20px 5px 0px;" flag="CZ">已出所人员管理</span>
	           		<i class="iconfont-sy" style="margin-left:20px;">&#xe736;</i>
	           		<span class="topm-span report-view-more" flag="TJ">统计报告</span>
	           	</div>
            </div>
            <div class="top-r fr">
                <i class="iconfont-sy icon-user">&#xe756;</i>
                <span class="top-r-name">张小红</span>
                <i class="iconfont-sy icon-logout">&#xe73b;</i>
            </div>
        </div>
        <div class="main">
            <div class="main-top clearfix">
                <div class="main-police fl">
                    <div class="main-top-title">
                        <i class="iconfont-sy icon-person">&#xe74f;</i>
                        <!-- <span>今日值班人员</span> -->
                        <span>快速搜索</span>
                    </div>
                    <div class="main-top-item clearfix">
                        <!-- <div class="police-man man1 fl">
                            <img src="<%=basePath%>sanyang/imgs/policeman.png" alt="">
                            <div>
                                <span class="police-name">王晶</span>
                                <span class="police-job">警官</span>
                            </div>
                        </div>
                        
                        <div class="police-man man2 fr">
                            <img src="<%=basePath%>sanyang/imgs/policeman.png" alt="">
                            <div>
                                <span class="police-name">张三丰</span>
                                <span class="police-job">警官</span>
                            </div>
                        </div> -->
                        <div class="search-item">
                        	<div class="search-contidion">
                        		<form class="layui-form" action="">
		                        	<div class="layui-form-item">
										<label class="layui-form-label">查询条件</label>
										<div class="layui-input-block" id="searchStatus">
											<input type="radio" name="serachType" value="NUMER" title="人员编号" checked="">
											<input type="radio" name="serachType" value="SFZ" title="身份证号">
											<input type="radio" name="serachType" value="NAME" title="姓名">
										</div>
									</div>
								</form>
                        	</div>
                        	<div class="search-box">
                        	    <input class="personID" type="text" name="" id="personID" placeholder="请输入人员编号">
                            	<button class="QuickSearch" flag="search">搜索</button>
                        	</div>
                        </div>
                    </div>
                </div>
                <div class="main-matters fl">
                    <div class="main-top-title">
                        <i class="iconfont-sy icon-person icon-things">&#xe738;</i>
                        <span>处理事项</span>
                    </div>
                    <div class="main-top-item things clearfix">
                       <!--  <div class="left-things fl clearfix">
                            <div class="left-things-item wait-item fl">
                                <div class="left-things-top" id="wait-num">
                                    <span class="wait-num" flag="TCS">1</span>
                                    <span class="font14">人</span>
                                </div>
                                <div class="left-things-bottom">
                                    <span class="font14">今日待出所</span>
                                </div>
                            </div>
                            <div class="left-things-item over-item fl">
                                <div class="left-things-top" id="over-num">
                                    <span class="over-num" flag="YQ">1</span>
                                    <span class="font14">人</span>
                                </div>
                                <div class="left-things-bottom ">
                                    <span class="font14">逾期未处理</span>
                                </div>
                            </div>
                        </div>
                        <div class="right-things fl">
                            <div class="right-things-item thing1">
                                <div class="things-num" id="thing1" flag="SH">1</div>
                                <img class="tip-num-bg" src="<%=basePath%>sanyang/imgs/num-bg.png" alt="">
                                <img class="tip-icon" src="<%=basePath%>sanyang/imgs/xxsh.png" alt="">
                                <div>信息审核未通过</div>
                            </div>
                            <div class="right-things-item thing2">
                                <div class="things-num" id="thing2" flag="TX">1</div>
                                <img class="tip-num-bg" src="<%=basePath%>sanyang/imgs/num-bg.png" alt="">
                                <img class="tip-icon" src="<%=basePath%>sanyang/imgs/txdb.png" alt="">
                                <div>头像对比未通过</div>
                            </div>
                            <div class="right-things-item thing3">
                                <div class="things-num" id="thing3" flag="CSD">1</div>
                                <img class="tip-num-bg" src="<%=basePath%>sanyang/imgs/num-bg.png" alt="">
                                <img class="tip-icon" src="<%=basePath%>sanyang/imgs/csd.png" alt="">
                                <div>出所单未上传</div>
                            </div>
                        </div> -->
                        <div class="will-out things-box fl clearfix">
                        	<img class="img-out" src="<%=basePath%>sanyang/imgs/will-out.png" alt="">
							<div class="img-box">
	                        	<div class="icon-box fl">
	                        		<i class="iconfont-sy thing-icon">&#xe767;</i>
	                        	</div>
	                        	<div class="thing-text fl">
	                        		<div class="thing-num" id="wait-num">84</div>
	                        		<div class="thing-title">待出所人数</div>
	                        	</div>
	                        	<div class="thing-btn fl" id="waitOut">查看</div>							
							</div>
                        </div>
                        <div class="un-out things-box fl">
                        	<img class="img-un" src="<%=basePath%>sanyang/imgs/un-out.png" alt="">
							<div class="img-box">
	                        	<div class="icon-box fl">
	                        		<i class="iconfont-sy thing-icon">&#xe766;</i>
	                        	</div>
	                        	<div class="thing-text fl">
	                        		<div class="thing-num" id="not-num">16</div>
	                        		<div class="thing-title">未出所人数</div>
	                        	</div>
	                        	<div class="thing-btn fl" id="notOut">查看</div>							
							</div>                        	
                        </div>
                        <div class="fail-compare things-box fl">
                        	<img class="img-compare" src="<%=basePath%>sanyang/imgs/fail-compare.png" alt="">
                        	<div class="img-box">
	                        	<div class="icon-box fl">
	                        		<i class="iconfont-sy thing-icon">&#xe768;</i>
	                        	</div>
	                        	<div class="thing-text fl">
	                        		<div class="thing-num" id="already-num">0</div>
	                        		<div class="thing-title">已出所人数</div>
	                        	</div>
	                        	<div class="thing-btn fl" id="already">查看</div>							
							</div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="main-bottom clearfix">
                <div class="main-b-l bottom-item fl">
                    <div class="title-top">
                        <span class="first-w item-span1"><i class="iconfont-sy">&#xe737;</i></span>
                        <span class="will-out">在所人员</span>
                        <span class="check-more fr will-view-more" id="checkMore" flag="CS">查看更多</span>
                    </div>
                    <div class="main-content">
                        <div class="table-box">
                            <table class="layui-hide" id="will-out" lay-filter="will-out"></table>
                        </div>
                    </div>
                </div>
                <div class="main-b-c bottom-item fl">
                    <div class="title-top">
                        <span class="first-w item-span2"><i class="iconfont-sy">&#xe74d;</i></span>
                        <span class="will-out">最近出所人员</span>
                        <span class="check-more fr last-view-more" flag="CZ">查看更多</span>
                    </div>
                    <div class="main-content">
                        <div class="table-box">
                            <table class="layui-hide" id="last-out" lay-filter="last-out"></table>
                        </div>
                    </div>
                </div>
                <div class="main-b-r bottom-item fl">
                    <div class="title-top clearfix">
                        <span class="first-w"><i class="iconfont-sy">&#xe736;</i></span>
                        <span class="will-out">最近报告</span>
                        <span class="check-more fr report-view-more" flag="TJ">查看更多</span>
                    </div>
                    <div class="main-content">
                        <div class="table-box">
                            <table class="layui-hide" id="last-report" lay-filter="last-report"></table>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    <script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-debug.js"></script>
	<script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-config-debug.js"></script>
	<script type="text/javascript" src="<%=basePath%>resources/commons/js/layui/layui.js"></script>
	<script>
        
		var address = "<%=basePath%>";
		var today="${today}";
        seajs.use("<%=basePath%>sanyang/js/index.js");
	</script>
</body>
</html>