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
        <title>存证管理</title>
        <base href="<%=basePath%>">
        <link rel="stylesheet" href="<%=basePath%>resources/commons/css/base.css" />
        <link rel="stylesheet" href="<%=basePath%>resources/commons/css/widget.css" />
        <link rel="stylesheet" href="<%=basePath%>resources/commons/js/layui/css/layui.css"  media="all" />
        <link rel="stylesheet" href="<%=basePath%>sanyang/css/management.css" />
        <style>
            .cktimebtn, .temp-btn, .check-btn {
                behavior:url('<%=basePath%>sanyang/css/PIE.htc');
                position: relative;
                z-index: 5;
                border-radius: 2px;
            }
            .content-top, .content-bottom {
                behavior:url('<%=basePath%>sanyang/css/PIE.htc');
                position: relative;
                z-index: 5;
                box-shadow: 0 0 10px 0 #eaeef2;
            }
            .id-num  {
			    width: 288px;
			}
			.id-num .layui-form-label {
			    color: #666;
			}
			.id-num input {
				height: 30px;
				line-height: 30px;
			    margin-top: 3px;
			    width: 200px;
			}
        </style>
    </head>
    <body>
        <div class="content">
            <!-- 正常待出所 iframe部分 上面查询条件一块 -->
            <div class="content-top">
                <div class="tab-bar clearfix">
                    <div class="out-normal fl">
                        <i class="iconfont-sy">&#xe739;</i><span class="tab-normal">正常出所</span>
                    </div>
                    <div class="out-temp fl ckbtn">
                        <i class="iconfont-sy">&#xe73a;</i><span class="tab-temp">临时出所</span>
                    </div>
                </div>
                <div class="conditions clearfix">
                    <div class="ipt fl">
                        <div class="ipt-people clearfix">
                            <div class="people-wait fl">
                                <label class="layui-form-label">出所人员</label>
                                <div class="layui-input-block">
                                    <input type="text" name="title" lay-verify="title" autocomplete="off"   class="layui-input ipt-placeholder" id="userName" value="${jsonQueryName.ID}">
                                </div>
                            </div>
                            <div class="people-num fl">
                                <label class="layui-form-label">人员编号</label>
                                <div class="layui-input-block">
                                    <input type="text" name="title" lay-verify="title" autocomplete="off"   class="layui-input ipt-placeholder" id="userNumber" value="${jsonQuery.ID}">
                                </div>
                            </div>                            
                        </div>
                        <div class="ipt-date clearfix">
                            <div class="fl">
                                <label class="layui-form-label">出所日期</label>
                                <div class="layui-input-inline">
                                    <i class="iconfont-sy">&#xe753;</i><input id="startDate" type="text" class="layui-input" placeholder="-"><i class="iconfont-sy">&#xe754;</i>
                                </div>
                            </div>
                            <div class="fl">
                                <label class="layui-form-label">至</label>
                                <div class="layui-input-inline">
                                    <i class="iconfont-sy">&#xe753;</i><input id="endDate" type="text" class="layui-input" placeholder="-"><i class="iconfont-sy">&#xe754;</i>
                                </div>
                            </div>
                            <div class="time-btn week-btn fr">本周</div><!-- cktimebtn -->
                            <div class="time-btn today-btn fr">今天</div>
                        </div>
                    </div>
                    <div class="check-top fl">
                    	<div class="id-num fl">
                            <label class="layui-form-label">身份证号</label><div class="layui-input-block">
                                <input type="text" name="title" lay-verify="title" autocomplete="off" class="layui-input ipt-placeholder" id="sfz" value="${jsonQuerySFZ.ID}">
                            </div>
                        </div>
                        <!-- <form class="layui-form" action="">
                            <div class="layui-form-item">
                                <label class="layui-form-label">异常类型</label>
                                <div class="layui-input-block">
                                    <input type="radio" name="outType" value="" title="不限" checked="">
                                    <input type="radio" name="outType" value="normal" title="正常出所">
                                    <input type="radio" name="outType" value="temp" title="临时出所">
                                </div>
                            </div>
                        </form> -->
                        <!-- <div class="layui-input-inline tips fl">注：当前展示最近一周存证信息</div> -->
                    </div>
                    <div class="check fr">
                        <div class="check-bottom clearfix">
                            <!-- <div class="layui-input-inline layui-btn temp-btn">立即同步</div> -->
                            <div class="layui-input-inline layui-btn check-btn">查询</div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- 列表 -->
            <div class="content-bottom">
                <div class="table-box">
                    <table class="layui-hide" id="test" lay-filter="demo"></table>
                </div>
            </div>
        </div>
    </body>
    <script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-debug.js"></script>
	<script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-config-debug.js"></script>
    <script type="text/javascript" src="<%=basePath%>resources/commons/js/layui/layui.js"></script>
    <script type="text/html" id="infoTpr">
        {{#  if(d.sex === '男'){ }}
            <i class="iconfont-sy" style="color:#43b76c">&#xe75a;</i>
        {{#  } else { }}
            <i class="iconfont-sy" style="color:#e85953">&#xe75b;</i>
        {{#  } }}
    </script>
    <script type="text/html" id="imgTpr">
        {{#  if(d.sex != '男'){ }}
            <i class="iconfont-sy" style="color:#43b76c">&#xe75a;</i>
        {{#  } else { }}
            <i class="iconfont-sy" style="color:#e85953">&#xe75b;</i>
        {{#  } }}
    </script>
    <script type="text/html" id="reportTpr">
        {{#  if(d.sex === '男'){ }}
            <i class="iconfont-sy" style="color:#43b76c">&#xe75a;</i>
        {{#  } else { }}
            <i class="iconfont-sy" style="color:#e85953">&#xe75b;</i>
        {{#  } }}
    </script>
    <script type="text/html" id="titleTpr">
        <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
		<a class="layui-btn layui-btn-xs back-office" lay-event="edit">回所</a>
    </script> 
    <script>
    	var address = "<%=basePath%>";
    	var role_ = "${role}";
        seajs.use(['<%=basePath%>sanyang/js/layout.js','<%=basePath%>sanyang/js/management-temp.js', '<%=basePath%>sanyang/js/getDate.js', '<%=basePath%>sanyang/js/setPlaceholder.js'])
    </script>
</html>