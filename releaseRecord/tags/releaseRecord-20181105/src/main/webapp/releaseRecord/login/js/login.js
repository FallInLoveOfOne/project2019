define(function(require){
	var $=require("$"),
    Position = require("position"), 
    Mask=require("mask");
	var Cookie=require("cookie");
	Mask.set('opacity', '0.5');
	
	var saveFlag = 1;
	
	//初始化页面时验证是否记住了密码
	$(document).ready(function() {
	    if (Cookie.get("rmbUser") == "true") {
	        $("#rmbUser").attr("checked", true);
	        $("#account").val(Cookie.get("userName"));
	        $("#password").val(Cookie.get("passWord"));
	        saveFlag = 2;
	    }
	});
	
	//保存用户信息
	/*function saveUserInfo() {
	    if ($("#rmbUser").attr("checked") == true) {
	        var userName = $("#account").val();
	        var passWord = $("#password").val();
	        Cookie.set("rmbUser", "true", { expires: 7 }); // 存储一个带7天期限的 cookie
	        Cookie.set("userName", userName, { expires: 7 }); // 存储一个带7天期限的 cookie
	        Cookie.set("passWord", passWord, { expires: 7 }); // 存储一个带7天期限的 cookie
	    }else {
	    	Cookie.set("rmbUser", "false", { expires: -1 });
	    	Cookie.set("userName", '', { expires: -1 });
	    	Cookie.set("passWord", '', { expires: -1 });
	    }
	    
	}*/
	
	//saveUserInfo();
	
	$("#rmbUser").click(function(){
		saveFlag = saveFlag+1;
	});
	
	//登录按钮点击事件
    $(".login-button-text").click(function(){
    	if($("#account").val()==null||$("#account").val()==""){
			$(".error").text("未填写帐号！");
			return;
		}
		if($("#password").val()==null||$("#password").val()==""){
			$(".error").text("未填写密码！");
			return;
		}
		//saveUserInfo();
		var userName = $("#account").val();
        var passWord = $("#password").val();
        if (parseInt(saveFlag)%2==0) {
		//if ($("#rmbUser").attr("checked") == false) {
	        Cookie.set("rmbUser", "true", { expires: 7 }); // 存储一个带7天期限的 cookie
	        Cookie.set("userName", userName, { expires: 7 }); // 存储一个带7天期限的 cookie
	        Cookie.set("passWord", passWord, { expires: 7 }); // 存储一个带7天期限的 cookie
	    }else {
	    	Cookie.set("rmbUser", "false", { expires: -1 });
	    	Cookie.set("userName", '', { expires: -1 });
	    	Cookie.set("passWord", '', { expires: -1 });
	    }
		document.forms[0].submit();
    });
   
});