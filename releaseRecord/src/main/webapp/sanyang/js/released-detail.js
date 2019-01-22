define(function(require){
    var $ = require("$");
    upload = require("fileupload");
    var w = $('body').width();
    $('.basic-detail').width(w-136-170);
    $(window).resize(function(){
        var w = $('body').width();
        $('.basic-detail').width(w-136-170);
    })
    // 调用layui的弹窗
    // layui.use('layer', function(){ //独立版的layer无需执行这一句
    //     var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句
        
    //     //触发事件
    //     var active = {
            // confirmTrans: function(){
            //     //配置一个透明的询问框
            //     layer.msg('大部分参数都是可以公用的<br>合理搭配，展示不一样的风格', {
            //         time: 20000, //20s后自动关闭
            //         shade: 0.8,
            //         height:'200px',
            //         width:'420px',
            //         btn: ['明白了', '知道了', '哦']
            //     });
            // },
            // notice: function(){
            //     //示范一个公告层
            //     layer.open({
            //         type: 1,
            //         title: false, //不显示标题栏
            //         closeBtn: false,
            //         //  ,area: '300px;'
            //         area: ['420px', '200px'],
            //         shade: 0.8,
            //         id: 'LAY_layuipro', //设定一个id，防止重复弹出
            //         btn: ['取消', '确定'],
            //         btnAlign: 'r',
            //         moveType: 1, //拖拽模式，0或者1
            //         content: '<div style="background-color: #fff; color: #333; font-size: 16px;"><i class="iconfont" style="display:inline-block; vertical-align:middle; width:30px;height:30px;background-color: #f6c748; border-radius:50%; margin-right:15px;"></i>未达到出所时间，不符合出所条件!</div>',
            //         success: function(layero){

            //         },
            //     });
            // }
    //     };
        
    //     $('.btn-box .layui-btn').on('click', function(){
    //       var othis = $(this), method = othis.data('method');
    //       active[method] ? active[method].call(this, othis) : '';
    //     });
        
    // });    

    // 调用layui的表格
    function getRecordList(){// 获取出所节点记录
    layui.use('table', function(){
        var table = layui.table;
        table.render({
            elem: '#record',
            url: 'fcfRecord/getRecordsByNumber',
            skin:'line',
            /*data:[
                {name:'李晓明',inTime:'2018-03-23  14:34',id:'66556599545',things:'准备出所'},
                {name:'李晓明',inTime:'2018-03-23  14:34',id:'66556599545',things:'信息有误，重新核对'},
                {name:'李晓明',inTime:'2018-03-23  14:34',id:'66556599545',things:'确认信息无误'},
                {name:'李晓明',inTime:'2018-03-23  14:34',id:'66556599545',things:'头像对比成功'}
            ],*/
            cols: [[
                {field:'', width:'5%', title: ''},
                //{field:'ID', width:'24%', title: '操作人员编号'},
                {field:'CREATE_USER_NAME', width:'35%', title: '操作人姓名',style:'color: #676767;'},
                {field:'CREATE_TIME', width: '35%', title: '操作时间',templet:function(d){return dateFormat(d.CREATE_TIME)}},
                {field:'ITEM', width: '35%', title: '操作事项'}
            ]],
            where:{number:personNumber_,name:userName_}
        });
    });
	}
    
    function getAccList(){// 获取附件列表
    layui.use('table', function(){
        var table = layui.table;
        table.render({
            elem: '#certificate',
            url: 'sysAcc/getSysAccsByNumber',
            skin:'line',
            /*data:[
                {name:'出所摄像拍摄照片',inTime:'2012-08-14',id:'jpg',operator:'张三丰'},
                {name:'2018年8月30日出所单',inTime:'2012-08-14',id:'mp4',operator:'张三丰'}
            ],*/
            cols: [[
                {field:'', width:'5%', title: ''},
                {field:'ACC_FILE_NAME', width:'20%', title: '附件名称'},
                {field:'ACC_SUFFIX_NAME', width:'20%', title: '附件类型',style:'color: #676767;'},
                {field:'CREATE_USER_NAME', width: '20%', title: '操作人姓名'},
                {field:'CREATE_DT', width: '20%', title: '操作时间',templet:function(d){return dateFormat(d.CREATE_DT)}},
                {field:'classify', width:'15%', title: '操作',templet:'#titleTpr'}
            ]],
            where:{personNumber:personNumber_},
        });

        //监听工具条
        table.on('tool(demo2)', function(obj){
            var data = obj.data;
            accId_ = data["ACC_ID"];// 附件ID
            // 下载按钮
            if(obj.event === 'download'){
        		downOutFiles(address + 'evidence/download/outList?id=' + accId_);
            }
        });
    });
	}
    // 附件下载函数
	function downOutFiles(url) {
		var el = document.createElement("a");
		document.body.appendChild(el);
		el.href = url;
		el.target = '_blank';
		el.click();
		document.body.removeChild(el);
	}
	
	// 数据初始化（出所记录、附件列表）
	function initData(){
		//getRecordList();// 获取出所记录
		//getAccList();// 获取附件列表
		getDetoxRecord();//2018-10-22 新增历史记录表
		initButton();//初始化处所按钮
	}
	
	initData();
	
	function initButton(){
		var param = {
				url:address+"evidence/getPersonOutDate",
				type:"POST",
				data:{personNumber:personNumber_},
				async:false,
				success:function(result){//ALREADY_OUT是否处所 Y/N
					if("N" == result){
						$(".out-office-btn").attr("style","display:block;");
					}
					if("Y" == result){
						$(".out-office-btn").attr("style","display:none;");
					}
					
				},
				error:function(){
				}
		};
		$.ajax(param);
	}
	
	// 日期格式化
    function dateFormat(date){
    	if(date){
    		var datemat = date.substring(0,4)+"-"+date.substring(4,6)+"-"+date.substring(6,8)+" "+date.substring(8,10)+":"+date.substring(10,12);
    		return datemat;
    	}
    	return "";
    }
	
    //出所类型显示字段处理
    function TypeToValue(outType){
    	var outTypeVal="";
    	if(outType){
    		if("normal"==outType){
    			outTypeVal="正常出所"; 
    		}else if("temp"==outType){
    			outTypeVal="临时出所";
    		}
    	}
    	return outTypeVal;
    }
	/*----------------------------------------------------------附件上传-----------------------------------------------------------------*/
	//判断上传的附件类型类型
	function checkFileType(filePath){
		// 限制的文件类型
		var fileStyle = 'doc,docx,pdf,jpg,png'; 
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
			alert('限制文件大小为:<span style="color:red;">'+dataFileSize+'MB</span>,当前上传文件大小超出限制大小，无法上传！');
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
	        	initData();
	        	//location.reload();
	        },  
	        error: function(){  
	        	//hideLoad();
	        	Confirmbox.alert('附件上传失败');   
	        }
	    }); 
	}
	
	// 上传附件点击事件
	$("#accUpload").click(function(){
		$("#listAccessoryFile").click();
	});
	
	/*----------------------------------------------------------附件上传-----------------------------------------------------------------*/
	
	// 点击关闭，关闭当亲页面
    $(".close-box-btn").click(function(){
    	window.opener=null;
		window.open('','_self');
		window.close();
    });
    
    function formatDate(){
    	$(".formatdate").each(function(){
    		var date = $(this).text()||'';
    		var formatdate = date.substring(0,4)+"-"+date.substring(4,6)+"-"+date.substring(6,8);
    		if(''!=date){
    			$(this).text(formatdate);
    		}
    	});
    }
    
    formatDate();
	
    function getDetoxRecord(){// 获取出所记录
    	layui.use('table', function(){
    		var table = layui.table;
    		//var historyid = "";
    		table.render({
    			elem: '#record3',
    			url: 'outHistory/outHisPage',
    			skin:'line',
    			cols: [[
    				{field:'', width:'5%', title: ''/*,templet:function(d){historyid = d.OUT_HISTORY_ID}*/},
    				{field:'CREATE_USER_NAME', width:'25%', title: '操作人姓名',style:'color: #676767;'},
    				{field:'OUT_TYPE', width:'24%', title: '出所类型',templet:function(d){return TypeToValue(d.OUT_TYPE)}},
    				{field:'OUT_TIME', width: '25%', title: '出所时间',templet:function(d){return dateFormat(d.OUT_TIME)}},
    				{field:'ITEM', width: '25%', title: '操作事项',templet:'#titleTpr1'}
    				]],
    				where:{number:personNumber_}
    		});
    		  //监听工具条
            table.on('tool(demo3)', function(obj){
            	 if(obj.event === 'detail'){// 查看按钮
            		 var data = obj.data;
            		 var historyid = data["OUT_HISTORY_ID"];// 历史记录ID
                     window.open(address+'evidence/toEviOutDetoxDetails?number='+personNumber_+'&historyid='+historyid+'&prisonId='+prisonId_);
            	 } 
             })

            		
                 
    	});
    }
    
    
    // 出所点击事件
    $(".out-office-btn").click(function(){
    	var personNumber = personNumber_;//data["NUMBER"];
        var prisonId=prisonId_;//data["DORM_CODE"];
        var userName=userName_;//data["NAME"];
        var holdEnd=outDate;//data["HOLD_END"];
        var nowDate="";// 当前日期
        var isNewOpt="";// 用于判断是否有操作记录
        var nextStep=""// 若有记录，下一步
        	
    	var userObj={number:personNumber,name:userName,outType:'normal'};
		var param = {// 判断是否有记录、下一步、当前日期
				url:address+"release/checkOutButon",
				type:"POST",
				data:userObj,
				async:false,
				success:function(result){
					var r = result;
					isNewOpt=result["optVal"];
					nextStep=result["nextStep"];
					nowDate=result["nowDate"];
				},
				error:function(){
				}
		};
		$.ajax(param);
		
		if(("old"==isNewOpt)&&("processFail"!=nextStep)){// 如果有操作记录，直接跳到原来位置
			if("processFail"==nextStep){
			}
			if("faceCheck"==nextStep){// 跳转人脸比对
//				window.open(address+"release/toFaceCheck?prisonId="+prisonId+"&number="+personNumber);
				window.open("release/toOutListUpload?prisonId="+prisonId+"&number="+personNumber);
			}
			if("listUp"==nextStep){// 跳转出所单上传
				window.open("release/toOutListUpload?prisonId="+prisonId+"&number="+personNumber);
			}
			if("outOk"==nextStep){
				
			}
			
		}else{// 没有操作记录的话
			
			if(holdEnd){
				if(parseInt(holdEnd)<=parseInt(nowDate)){
    				var requestUrl = "release/achieveTimeSureOut";
    				var jsonObj = {number:personNumber,name:userName,outType:'normal'};
    				outOpt(requestUrl,prisonId,jsonObj/*,personNumber,userName,"normal"*/);// 正常出所操作及跳转
    			}
    			
    			// 临时出所
    			if(parseInt(holdEnd)>parseInt(nowDate)){
    				layer.confirm('尚未到达规定出所时间，是否进行临时出所？', {btn: ['临时出所', '正常出所']},
    			        function(){
		        			layer.closeAll();
		        			var requestUrl = "release/temOutY";
	        				var jsonObj = {number:personNumber,name:userName,outType:'temp'};
	        				outOpt(requestUrl,prisonId,jsonObj/*,personNumber,userName,"normal"*/);// 正常出所操作及跳转
		        		},
		        		function(){
		        			layer.closeAll();
		        			var requestUrl = "release/achieveTimeSureOut";
		    				var jsonObj = {number:personNumber,name:userName,outType:'normal'};
		    				outOpt(requestUrl,prisonId,jsonObj/*,personNumber,userName,"normal"*/);// 正常出所操作及跳转
		        		}
    			      );
    			}
			}else{
				layer.confirm('是否进行临时出所？', {btn: ['临时出所', '正常出所']},
						function(){
					layer.closeAll();
					var requestUrl = "release/temOutY";
					var jsonObj = {number:personNumber,name:userName,outType:'temp'};
					outOpt(requestUrl,prisonId,jsonObj/*,personNumber,userName,"normal"*/);// 正常出所操作及跳转
				},
				function(){
					layer.closeAll();
					var requestUrl = "release/achieveTimeSureOut";
    				var jsonObj = {number:personNumber,name:userName,outType:'normal'};
    				outOpt(requestUrl,prisonId,jsonObj/*,personNumber,userName,"normal"*/);// 正常出所操作及跳转
				}
				);
				
			}
			
		}

    });
    // 出所操作--- 
    function outOpt(reqUrl,prisonId,jsonCon/*personNumber,userName,type*/){
    	var param = {
				url:address+reqUrl,//"release/achieveTimeSureOut",
				type:"POST",
				data:jsonCon,//{number:personNumber,name:userName,outType:'normal'},
				async:false,
				success:function(result){
					// 跳转到出所单确认
					window.open("release/toOutListUpload?prisonId="+prisonId+"&number="+jsonCon["number"]);
				},
				error:function(){
				}
		};
		$.ajax(param);
    }
})