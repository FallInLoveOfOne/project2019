<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE unspecified PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件下载</title>
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>resources/commons/css/base.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>resources/commons/css/widget.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>resources/commons/css/theme.css">
</head>
<body>
	<div>
		<input id="downOutListFile" value="出所单附件">
		<input id="uploadOutListFileBt" value="出所单附件">
		<input id="mapBt" value="获取map">
	</div>
	
	<!-- 附件上传隐藏表单 -->
	<div style="display:none;">
		 <form id="outListUploadFrm" action="<%=basePath%>release/upload/outList" enctype="multipart/form-data" method="post" >
	        <input name="oldFileMsg" id="oldFileMsg" type="hidden" value="" />
	        <input name="personNumber" type="hidden" value="ss520" />
	        <input id="outList_name" name="outList_name" type="hidden" value="" />
			<input id="listAccessoryFile" name="filename" type="file"  onChange="accessoryUploadPhoto();"/>
			<input type="submit" value="上传附件">
		</form>
	</div>
	<script type="text/javascript"
		src="<%=basePath%>resources/commons/js/seajs/sea-debug.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>resources/commons/js/seajs/sea-config-debug.js"></script>
	<script>		    
			var address = "<%=basePath%>";
			seajs.use("<%=basePath%>releaseRecord/releaseManager/js/down.js");
		
	</script>
</body>
</html>