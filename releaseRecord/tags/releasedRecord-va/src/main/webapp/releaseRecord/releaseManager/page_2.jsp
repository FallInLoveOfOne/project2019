<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="cn.innosoft.en.util.PropsUtil"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>page_demo2</title>
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css"
	href="resources/commons/css/base.css">
<link rel="stylesheet" type="text/css"
	href="resources/commons/css/widget.css">
<!-- <link rel="stylesheet" type="text/css" href="platform/commons/css/content.css" /> -->
<link rel="stylesheet" type="text/css"
	href="commons/tableShow/layui/css/layui.css">
<script src="<%=basePath%>commons/tableShow/layer/layer.js"
	charset="utf-8"></script>
<script src="<%=basePath%>commons/tableShow/layui/layui.js"
	charset="utf-8"></script>
<script src="commons/tableShow/js/jquery-1.9.1.min.js"></script>
</head>
<body>
	<div class="content-container">
		<div class="container-block">
			<div class="query-general">
				<form id="searchFrom" class="search-form">
					<div class="fr">
						<input type="button" class="query-general-btn btn-query"
							value="查询" /> <input type="button"
							class="query-general-btn btn-reset" value="重置" />
					</div>
					<input type="text" class="ui-input query-general-input"
						style="width: 190px" id="demo_id" placeholder="id" /> <input
						type="text" class="ui-input query-general-input"
						style="width: 190px" id="demo_name" placeholder="名称" />
				</form>
			</div>
			<div class="query-result">
				<div class="query-result-header">
					<div class="block">
						<div class="operate">
						</div>
						<span class="query-result-icon"></span><span>查询结果</span>
					</div>
				</div>
				<div class="ui-datagrid" style="width: 1200px; margin: auto;">
					<table id="tblResult">
					</table>
				</div>
				<table class="query-result-table">
					<thead>
						<tr>
							<th style="width: 2%"><input type="checkbox" id="selectAll"
								class="filename-checkbox thead" name="LEAD_BUSI_ID" /></th>
							<th style="width: 20%;" name="ID" class="thead">ID</th>
							<th style="width: 17%;" name="NAME" format="formatAddDetail"
								class="thead">名称</th>
							<th style="width: 22%;">操作</th>
						</tr>
					</thead>
					<tbody id="query-result-tablebody">

					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="resources/commons/js/seajs/sea-debug.js"></script>
	<script type="text/javascript"
		src="resources/commons/js/seajs/sea-config-debug.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>commons/tableShow/js/table-debug.js"></script>
	<script>
		var address = '<%=basePath%>'; 
		seajs.use("<%=basePath%>releaseRecord/releaseManager/js/page_2.js?<%=PropsUtil.getJSTimeStamp()%>");
		
	</script>

</body>
</html>