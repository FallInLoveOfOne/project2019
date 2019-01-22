define(function(require) {
	var $ = require("$");
	
	// 服务器 14:46:30
	var testData = '{"data": {"status": "recognizing", "track": 43, "timestamp": 1539758770, "face": {"image": "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", "rect": {"top": 88, "right": 1464, "bottom": 130, "left": 1422}}, "person": {"feature_id": 0, "confidence": 0, "tag": "", "id": ""}, "quality": -0.6206499934196472}, "screen": {"camera_address": "rtsp://41.213.199.240:8554/0/0/0", "allowed_subject_ids": [], "network_switcher_status": 1, "box_token": "2a3e9060-3c04-4adb-821b-0aa1176ca8a2", "description": null, "allow_all_subjects": true, "box_heartbeat": 1539757830, "network_switcher": "41.213.199.242", "camera_name": "", "camera_status": 0, "allow_visitor": true, "screen_token": "b02b24a8-4bf6-4072-8862-a0e29deb9b42", "network_switcher_token": null, "box_status": "0", "is_select": 1, "network_switcher_drive": 2, "type": 1, "id": 1, "camera_position": "\u9632\u9519\u653e", "box_address": "41.213.199.239"}, "type": "lastface"}';
	var websocket = null;
    
    //浏览器是否对websocket支持
    if ('WebSocket' in window) {
    	var IP = "http://41.213.199.239";
    	var sb_url = "ws://41.213.199.239:9000/video?url=rtsp%3a%2f%2f41.213.199.240%3a8554%2f0%2f0%2f0";// 
    	var local_url= "ws://localhost:8058/mywebsocket";			
        websocket = new WebSocket(sb_url);
    }
    else {
        alert('当前浏览器 不支持websocket');
    }

    //连接发生错误的回调方法
    websocket.onerror = function () {
        showMessage("连接错误");
    };

    //连接成功建立的回调方法
    websocket.onopen = function () {
        showMessage("连接成功");
    }

    //接收到消息的回调方法
    websocket.onmessage = function (event) {
    	websocket.onclose();
    	var datas = event.data;
    	console.info("websocket:"+datas);
    	//cleanShow();
    	//dealSBData(testData);
        showMessage(event.data);
        websocket.onopen();
    }

    //连接关闭的回调方法
    websocket.onclose = function () {
        showMessage("连接关闭");
    }

    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function () {
        closeWebSocket();
    }

    //将消息显示在网页上
    function showMessage(sendMessage) {
    	//$("#message").html("");
    	$("#message").append("<span>"+sendMessage+"</span><br/>");
        //document.getElementById('message').innerHTML += sendMessage + '<br/>';
    }

    //关闭WebSocket连接
    closeWebSocket = function closeWebSocket() {
				     	websocket.close();
				     }
    
    
    // 格式化识别结果
    function dealSBData(datas){
    	if(datas){
    		var param = {
    			url : address + "release/dealSBData",
    			type : "POST",
    			data : {json:datas},
    			async : false,
    			success : function(result) {
    				console.info(result);
    				/*if(result){
    					var type = result["type"];
    					var userType = result["userType"];
    					if("recognized"==type){// 识别成功
    						
    						if("JD"==userType){// 戒毒人员
    							showSuccessInfo(result["img"],result);
    						}else{// 其他人员
    							showOtherInfo(result["img"],result);
    						}
    						
    					}
    					if("gone"==type){
    						
    					}
    				}*/
    			},
    			error : function() {
    			}
    		};
    		$.ajax(param);
    	}
    	// screen:识别位置的信息，只有type不为gone时才会有
    	// person:和底库里相似的人，只有type为recognized时才会有
    	// open_door:是否开门，只有type为recognized时才会有
    	// error:如果open_door为false，这个字段就是不能开门的原因
    	// type:本条信息的类型，4种，lastface（识别中）、recognized、unrecognized、gone
    	// data:算法识别的底层信息，无特殊需求的话不用处理，其中track为track id。只有当type为gone的时候，这里才包含年龄性别信息。
    	/*if(datas){
    		var img_str = "";
    		var jsonObj = JSON.parse(datas);
    		//**********************************************格式化数据******************************************************
    		var type = jsonObj["type"];// 本条信息的类型，4种，lastface（识别中）、recognized、unrecognized、gone、attr（此类型直接退出处理）
    		
    		var dataObj = jsonObj["data"];// data对象一直存在，算法识别的底层信息
    		if("attr"==type){
    			img_str = dataObj["image"];
    			showMessage('处理结束');
    			return;
    		}
    		var dataObj_statusObj = dataObj["status"];
    		var dataObj_statusObj_recognize_status = dataObj_statusObj["recognize_status"];
    		var dataObj_statusObj_snapshot_status = dataObj_statusObj["snapshot_status"];
    		
    		var dataObj_track = dataObj["track"];
    		var dataObj_timestamp = dataObj["timestamp"];
    		var dataObj_faceObj = dataObj["face"];
    		var dataObj_faceObj_image = dataObj_faceObj["image"];
    		img_str = dataObj_faceObj_image;
    		var dataObj_faceObj_rectObj = dataObj_faceObj["rect"];
//    		var dataObj_faceObj_rectObj_top = dataObj_faceObj_rectObj["top"];
//    		var dataObj_faceObj_rectObj_right = dataObj_faceObj_rectObj["right"];
//    		var dataObj_faceObj_rectObj_bottom = dataObj_faceObj_rectObj["bottom"];
//    		var dataObj_faceObj_rectObj_left = dataObj_faceObj_rectObj["left"];
    		var dataObj_personObj = null;
    		// data属性中person属性：feature_id,confidence,tag,id
    		dataObj_personObj = dataObj["person"];
    		var dataObj_personObj_feature_id = dataObj_personObj["feature_id"];
    		var dataObj_personObj_confidence = dataObj_personObj["confidence"];
    		// data属性中person属性中tag的属性：subject_type,description,start_time,birthday,id
    		var dataObj_personObj_tagObj = dataObj_personObj["tag"];
    		var dataObj_personObj_id = dataObj_personObj["id"];
    		
    		
    		var dataObj_quality = dataObj["quality"];
    		
    		
    		
    		var screenObj = null;
    		var personObj = null;
    		var open_door = null;
    		var error = null;
    		if("gone"!=type){// 
    			// screen属性：camera_address,allowed_subject_ids:[],network_switcher_status,box_token,description,box_heartbeat,network_switcher,camera_name,camera_status,allow_visitor,screen_token,network_switcher_token,box_status,allow_all_subjects,type,id,camera_position,box_address
    			screenObj = jsonObj["screen"];
    		}
    		if("recognized"==type){// 
    			// person属性：src,remark,subject_type,description,title,timestamp,start_time,avatar,job_number,birthday,entry_date,department,end_time,id,name,
    			personObj = jsonObj["person"];
    			open_door = jsonObj["open_door"];
    		}
    		
    		if(false==open_door){
    			error = jsonObj["error"];
    		}
    		//**********************************************格式化数据END******************************************************
    		if(null==personObj){// 没有扫描到对应底库人员信息，当陌生人处理，显示识别照，陌生人提示
    			showStrangerInfo(img_str);
    			personObj = {};// 测试
    			personObj.src=''
    			personObj.id='775';
    			checkPerson(JSON.stringify(personObj));
    		}else{
    			var description = personObj["description"];
    			if(description&&description.indexOf("正常出所")!=-1){// 戒毒人员
    				checkPerson(JSON.stringify(personObj));
    			}else{
    				
    			}
    		}
    		
    		
    		showMessage('处理结束');
    	}*/
    }
    
    // 显示陌生人信息
    function showStrangerInfo(imgStr){
    	if(imgStr){
    		$("img.inside-img").attr("src","data:image/png;base64,"+imgStr);
    		$("#person-info").text("陌生人");
    	}
    }
    
    // 显示戒毒人员信息
    function showSuccessInfo(imgStr,jcInfoMap){
    	if(imgStr){// 显示识别图
    		$("img.inside-img").attr("src","data:image/png;base64,"+imgStr);
    	}
    	if(jcInfoMap){// 显示基本新
    		if("no"==jcInfoMap["problem"]){
    			$("#person-info").text(jcInfoMap["NAME"]+"、"+jcInfoMap["SEX_VALUE"]+"、"+jcInfoMap["HOUSE_ADDR_VALUE"]);
    		}
    		if("date"==jcInfoMap["problem"]){// 公安系统内部流程未通过
    			
    		}
    		if("doc"==jcInfoMap["problem"]){// 出所单未确认
    			
    		}
    	}
    }
    
    // 识别人员校验
    function checkPerson(personStr){
    	var datas = "";
		var param = {
			url : address + "release/checkPerson",
			type : "POST",
			data : {json:personStr},
			async : false,
			success : function(result) {
				if(result){// 戒毒人员信息
					var problem_sta = result["problem"];
					if("no"==problem_sta){// 改戒毒人员流程确认完毕
						var personObj = JSON.parse(personStr);
						personObj.NUMBER=result["NUMBER"];
						personObj.NAME=result["NAME"];
						personObj.problem=result["problem"];
						showSuccessInfo(personObj["src"],result);
						outDeal(JSON.stringify(personObj));// 出所处理
					}else{
						showSuccessInfo(personObj["src"],result);
					}
					
				}else{// 未知人员信息（民警、）
					
				}
//				$("img.inside-img").attr("src",address + "Photomsg/" + result["photoPath"]);
			},
			error : function() {
			}
		};
		$.ajax(param);
		return datas;
    }
    
    // 出所处理
    function outDeal(infoStr){
    	var datas = "";
		var param = {
			url : address + "release/sbOutDeal",//"release/sbOutDeal",识别出所操作
			type : "POST",
			data : {json:infoStr},
			async : false,
			success : function(result) {
				datas = result;
				$("#showMessage").text(result);
				alert("出所成功");
//				$("img.inside-img").attr("src",address + "Photomsg/" + result["photoPath"]);
			},
			error : function() {
			}
		};
		$.ajax(param);
		return datas;
    	
    }
    
    // 清空显示信息
    function cleanShow(){
    	$("img.inside-img").attr("src","");
    	$("#person-info").text("");
    }
    
    // 显示其他人信息（民警）
    function showOtherInfo(imgStr,otherInfo){
    	if(imgStr){// 显示识别图
    		$("img.inside-img").attr("src","data:image/png;base64,"+imgStr);
    	}
    	if(otherInfo){
    		$("#person-info").text(otherInfo["name"]+"、"+otherInfo["description"]);
    	}
    }
	
})