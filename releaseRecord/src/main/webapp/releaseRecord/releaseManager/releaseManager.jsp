<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE unspecified PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>出所管理</title>
		<base href="<%=basePath%>">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>resources/commons/css/base.css">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>resources/commons/css/widget.css">
	    <link rel="stylesheet" type="text/css" href="<%=basePath%>resources/commons/css/theme.css">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>resources/commons/css/manager.css">
	</head>
	<body>
    <div class="ui-box-container ui-box-margin-top" style="width:1200px;margin:auto;">
    	<div class="ui-box-content ui-box-no-padding">
        	<div class="search-box">
        	<!-- form表单  -->
            	<form action="" class="search-form">
             		<div class="search-form-2item" style="overflow:hidden;">																						
						<div class="search-form-item-col" style="float:left;">
							<label class="ui-label">ID:</label>
							<input class="ui-input ui-input-w190 dashId" name="dashId"  value="">
						</div>	
						<div class="search-form-item-col" style="float:left;">
							<label class="ui-label">名称:</label>
							<input class="ui-input ui-input-w190 dashName" name="dashName"  data-rule-op="like"  value="">
						</div>				
					</div>
				</form>
			</div>
            <div class="search-bar">
        		<a class="ui-button ui-button-search">
       				<i class="iconfont">&#xf004c;</i>
       				查询
        		</a>
        		<a class="ui-button ui-button-reset">
       				<i class="iconfont">&#xf0059;</i>
       				重置
       			</a>      		
        	</div>
          	<div class="ui-datagrid"  style="width:1200px;margin:auto;">
          		<table id="tblResult">
         		</table>
         	</div>
		</div>
     </div>    
     	<script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-debug.js" ></script>
	    <script type="text/javascript" src="<%=basePath%>resources/commons/js/seajs/sea-config-debug.js"></script>	    
		<script>		    
			var address = "<%=basePath%>";
			seajs.use("<%=basePath%>releaseRecord/releaseManager/js/releaseManager.js");
		</script>	
	</body>
</html>