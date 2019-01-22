define(function(require) {
	var $ = require("$");
	upload = require("fileupload");
	Select = require("inno/select/1.0.0/select-debug");
	var Confirmbox = require("inno/dialog/1.0.0/confirmbox-debug");
	
	// 附件下载函数
	function downOutFiles(url) {
		var el = document.createElement("a");
		document.body.appendChild(el);
		el.href = url;
		el.target = '_blank';
		el.click();
		document.body.removeChild(el);
	}

	// 出所单附件下载
	$("#downOutListFile").click(function() {
		accId_ = "xiazai";
		downOutFiles(address + 'evidence/download/outList?accId=' + accId_);
	});
	
	//判断上传的证书文件类型
	function checkFileType(filePath){
		// 限制的文件类型
		var fileStyle = 'doc，docx，pdf'; 
		var extendStr=filePath.substring(filePath.lastIndexOf(".") + 1).toLowerCase();
		if ( fileStyle.indexOf(extendStr)==-1){
			return false;
		}else
			return true;
	};
	
	function toRound(num,digit){
		if(typeof num=="string")
			num=parseFloat(num);
		with(Math){  
			return round(num*pow(10,digit))/pow(10,digit);  
		}  
	}
	
	
	// 检查并上传
	accessoryUploadPhoto = function(){
		var dataFileSize = 60;
		var elm = $("#listAccessoryFile").get(0);
		var fileName = elm.files[0].name; // 获取文件名
		var fileSize = toRound((elm.files[0].size / 1024 / 1024),2) // 将文件大小转换为MB后四舍五入到两位小数
		if(checkFileType(fileName)==false){ // 判断文件名称是否符合
			Confirmbox.alert("文件类型不匹配，请检查并上传正确格式的文件！");
			return false;
		}
		if(fileSize>dataFileSize){ // 判断文件大小，并返回相应提示
			Confirmbox.alert('限制文件大小为:<span style="color:red;">'+dataFileSize+'MB</span>,当前上传文件大小超出限制大小，无法上传！');
			return false;
		}
//		$("input[name=credentialName]").val(fileName);
		$("#outList_name").val(fileName);
		uploadOutListAjax();
	};
	
	
	//上传出所单附件调用ajax
	function uploadOutListAjax(){
		//showLoad();
		// 上传文件
		$("#outListUploadFrm").ajaxSubmit({
			type:"post",
			async:false,
	        success: function(data){
	        	//hideLoad();
	        	$("#oldFileMsg").val("");
	        	$("#fileType").val("");
	        	$("#listAccessoryFile").val("");
	        	$("#outList_name").val("");
	        	//showListAndAppName();
	        	Confirmbox.alert('附件上传成功');
	        	//location.reload();
	        },  
	        error: function(){  
	        	//hideLoad();
	        	Confirmbox.alert('附件上传失败');   
	        }
	    }); 
	}
	
	// 上传附件点击事件
	$("#uploadOutListFileBt").click(function(){
		$("#listAccessoryFile").click();
	});
	
	
	/****************************************************************************/
	// 测试map
	$("#mapBt").click(function(){
		$.ajax({				
			url: address + "evidence/getmap",
			//data:{queryCondition:queryCondition,page:pageNumber,rows:num,sort:"createDt",order:"desc"},
			data:{"id":"haha"},
			type:"POST",
			async: false,
			success:function(res){	
				alert(res["list2"][0]["vv"]);
				alert(res["qq"]);
			},
			error:function(result){
				layer.msg('系统查询失败');
			}						
		})
	});
});