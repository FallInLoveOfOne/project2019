define(function(require){
    var $ = require("$");
    upload = require("fileupload");
        h = $('body').height();
        // w = $('body').width();
    $('.content-box').height(h-70)
    // $('.content-box').width(w-40)
    // $('.pro-pic').width((w-144*3-160*2-40)/4)
    $('.img-box').height(h-70-100-50)
    $(window).resize(function(){
        var h = $('body').height();
    //         w = $('body').width();
        $('.content-box').height(h-70)
        // $('.content-box').width(w-40)
        // $('.pro-pic').width((w-144*3-160*2-40)/4)
        $('.img-box').height(h-70-100-50)
    }) 
    
    /*--------------------------------------------------------------------------------------------------*/
    
    var checkTime_;// 头像对比时间
    // 调用人脸对比结果
    function faceCheckResult(flag){
    	layui.use('layer', function(){ 
        	var index = layer.load(2, {
    			  shade: [0.5,'#fff'], //0.1透明度的白色背景
    			  //area:'auto',//['500px', '500px']
    			  offset:['50%','50%']
    			});
        });
    	var userObj={prisonId:prisonId_,number:number_,ksuserId:ksuserId_};
		var param = {// 判断是否有记录、下一步、当前日期
				url:address+"release/headPhotoCheck",
				type:"POST",
				data:userObj,
				//async:false,
				success:function(result){
					layui.use('layer', function(){ 
						layer.closeAll('loading');//关闭弹出层
						var isOK = result["isOk"];// 人脸对标结果
						checkTime_ = result["checkTime"];// 对比时间
						if("true"==isOK){// 人脸对标成功
							$("#sbPh").attr("src",result["sbPhoto"]);
							$(".optBt").hide();
							$(".trueBT").show();
							$(".dbimg").hide();
							$("#successImg").show();
							$("#upFace").hide();
							$("#dbText").text("头像对比成功");
						}
						
						if("false"==isOK){// 人脸对比失败
							$("#upFace").show();
							$(".optBt").hide();
							$(".falseZBBT").show();
							$(".falseNextBT").show();
							$(".zcdbBT").show();
							$(".dbimg").hide();
							$("#upFace").show();
							$("#sbPh").attr("src","");
							if(flag){
								$("#wrongImg").show();
								$("#dbText").text("头像对比失败，请重新拍摄");
								$("#dbText").show();
							}
						}
					});
					
				},
				error:function(){
				}
		};
		$.ajax(param);
    }
    
    // 注释对比
    faceCheckResult(null);
    /*--------------------------------------------------------------------------------------------------*/

    
    
    /*-----------------------------------------头像上传---------------------------------------------------------*/
	//判断上传的附件类型类型
	function checkFileType(filePath){
		// 限制的文件类型
		var fileStyle = 'jpg，png'; 
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
			alert("文件类型不匹配，请检查并上传正确格式的文件！");
			return false;
		}
		if(fileSize>dataFileSize){ // 判断文件大小，并返回相应提示
			Confirmbox.alert('限制文件大小为:<span style="color:red;">'+dataFileSize+'MB</span>,当前上传文件大小超出限制大小，无法上传！');
			return false;
		}
//		$("input[name=credentialName]").val(fileName);
		$("#photo_name").val(fileName);
		uploadOutListAjax();
	};
	
	
	//上传出所头像调用ajax
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
	        	$("#photo_name").val("");
	        	//showListAndAppName();
	        	//location.reload();
	        	
	        	if("false"==data){
	        		$("#upFace").show();
					$(".optBt").hide();
					$(".falseZBBT").show();
					$(".falseNextBT").show();
					$(".zcdbBT").show();
					$(".dbimg").hide();
					$("#sbPh").attr("src","");//对比失败依然显示对比失败的照片: address+"Photomsg/"+data
					$("#wrongImg").show();
					$("#dbText").show();
					$("#upFace").show();
					$("#dbText").text("头像对比失败，请重新拍摄");
	        	}else{
	        		$("#sbPh").attr("src",address+"Photomsg/"+data);
					$(".optBt").hide();
					$(".trueBT").show();
					$(".dbimg").hide();
					$("#successImg").show();
					$("#upFace").hide();
					$("#dbText").text("头像对比成功");
	        	}
	        	
	        },  
	        error: function(){  
	        	//hideLoad();
	        	Confirmbox.alert('附件上传失败');   
	        }
	    }); 
	}
	
	// 上传头像点击事件
	$("#upFace").click(function(){
		$("#listAccessoryFile").click();
	});
	
    
    /*-----------------------------------------头像上传---------------------------------------------------------*/
	
	// 头像比对后的操作
	
	$(".zcdbBT").click(function(){// 再次对比
		faceCheckResult("show");
		/*var conJson={personNumber:number_,checkTime:checkTime_,name:name_,opt:''};
		var param = {// 判断是否有记录、下一步、当前日期
				url:address+"release/headTemNoCheck",
				type:"POST",
				data:conJson,
				async:false,
				success:function(result){
				},
				error:function(){
				}
		};
		$.ajax(param);*/
	});
	
	$(".trueBT").click(function(){// 头像对比成功，下一步
		var conJson={personNumber:number_,checkTime:checkTime_,name:name_,opt:''};
		var param = {// 判断是否有记录、下一步、当前日期
				url:address+"release/headCheckOk",
				type:"POST",
				data:conJson,
				async:false,
				success:function(result){
					//window.location.href='release/toOutListUpload?prisonId='+prisonId_+"&number="+number_;
					toCZGL(number_);
				},
				error:function(){
				}
		};
		$.ajax(param);
	});
	
	$(".falseZBBT").click(function(){// 头像比对失败，暂不出所
		//$(this).attr("disabled",true);//点击禁用   $(this).attr("disabled",disabled);
		var conJson={personNumber:number_,checkTime:checkTime_,name:name_,opt:''};
		var param = {// 判断是否有记录、下一步、当前日期
				url:address+"release/headCheckFalse",
				type:"POST",
				data:conJson,
				async:false,
				success:function(result){
					//$(this).attr("disabled",false);// 点击启用
					// 一下为关闭当前窗口
					window.opener=null;
					window.open('','_self');
					window.close();
				},
				error:function(){
				}
		};
		$.ajax(param);
	});
	
	$(".falseNextBT").click(function(){// 头像比对失败，继续下一步
		//$(this).attr("disabled",true);//点击禁用   $(this).attr("disabled",disabled);
		var conJson={personNumber:number_,checkTime:checkTime_,name:name_,opt:''};
		var param = {// 判断是否有记录、下一步、当前日期
				url:address+"release/headCheckSkip",
				type:"POST",
				data:conJson,
				async:false,
				success:function(result){
					//$(this).attr("disabled",false);// 点击启用
					//window.location.href='release/toOutListUpload?prisonId='+prisonId_+"&number="+number_;
					toCZGL(number_);
				},
				error:function(){
				}
		};
		$.ajax(param);
	});
	
	// 跳转到存正管理
	function toCZGL(number){
		var flag = "CZGL";// 存在证管理
    	var ID=number_;
    	var jsonstr={"flag":flag,"ID":ID,"flagRedio":"NUMER","BusiStatus":""};
    	var json = JSON.stringify(jsonstr);
    	//window.location.href=address+'home/search/'+json;
    	window.location.href=address+'home/search/'+encodeURIComponent(json,'utf-8');
	}
    
})