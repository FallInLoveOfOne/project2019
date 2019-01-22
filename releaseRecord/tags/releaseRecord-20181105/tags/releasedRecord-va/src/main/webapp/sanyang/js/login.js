define(function(require){
    var $ = require("$");
    Position = require("position"), 
    Mask=require("mask");
	var Cookie=require("cookie");
	Mask.set('opacity', '0.5');
	
	var saveFlag = 1;
	
    var h = $('body').height(),
        w = $('body').width();
    $('.top-stand').height((h - 426)*.45)
    $('window').resize(function(){
        var h = $('body').height(),
            w = $('body').width();
        $('.top-stand').height((h - 426)*.45)
    })
//    var IeVersion = null;
//    if(navigator.appName == "Microsoft Internet Explorer"){
//        IeVersion = navigator.appVersion.split(";")[1].replace(/[ ]/g,"").replace('MSIE','')
//        if( IeVersion >= 8 && IeVersion < 10 ){
//            $('.login-box input').css({
//                'background-color': 'red'
//            })
//        }else {
//            $('.login-box input').css({
//                'background-color': 'transparent'
//            })
//        }
//    }
    function getBrowserVersion(){      
        var userAgent = navigator.userAgent.toLowerCase();   
        if(userAgent.match(/msie ([\d.]+)/)!=null){
            //ie6--ie9                
            uaMatch = userAgent.match(/msie ([\d.]+)/);                
            return 'IE'+uaMatch[1];        
        }else if(userAgent.match(/(trident)\/([\w.]+)/)){    
            uaMatch = userAgent.match(/trident\/([\w.]+)/);    
            switch (uaMatch[1]){                                
                case "4.0": return "8" ;
                break;                                
                case "5.0": return "9" ;
                break;                                
                case "6.0": return "10";
                break;                                
                case "7.0": return "11";
                break;                                
                default:return "undefined" ;            
            }  
        }       
        return "undefined";  
    }
    if(getBrowserVersion() < 10 && getBrowserVersion() != null){ 
        $('.login-box input').css({
            'background-color': 'red'
        })
    }else if(getBrowserVersion() >=10 || getBrowserVersion()=="undefined") {
        $('.login-box input').css({
            'background-color': 'transparent'
        })
    }
    // login页面判断ie版本为10以下就让input背景变成红色
//    var broName = 'Runing';
//    var strStart = 0;
//    var strStop = 0;
//    var temp = '';
//    var userAgent = window.navigator.userAgent;
//    //IE浏览器
//    if (userAgent.indexOf('NET') != -1 && userAgent.indexOf("rv") != -1) {
//        /*broName = 'IE浏览器'; */
//        strStart = userAgent.indexOf('rv');
//        strStop = userAgent.indexOf(')');
//        temp = userAgent.substring(strStart, strStop);
//        broName = temp.replace('rv:', '');
//        if(broName < 10){
//            $('.login-box input').css({
//                'background-color': 'red'
//            })
//        }else {
//            $('.login-box input').css({
//                'background-color': 'transparent'
//            })
//        }
//    }
    // 账号输入
    $('.user-name input').on('focus', function(){
        $('.user-name').css({
            'border-bottom': '1px solid #fff'
        })
    })
    $('.user-name input').on('blur', function(){
        $('.user-name').css({
            'border-bottom': '1px solid #0c4b7a'
        })
    })
    $('.user-name input').on('input', function(){
        if($('.user-name input').val() == ''){
            $('.user-name').css({
                'border-bottom': '1px solid #0c4b7a'
            })
            $('.icon-account').addClass('dpnone').removeClass('dpblock')
        }else {
            $('.user-name').css({
                'border-bottom': '1px solid #fff'
            })
            $('.icon-account').addClass('dpblock').removeClass('dpnone')
        }
    })
    $('.icon-account').on('click',function(){
        $(this).siblings().val('')
        $(this).addClass('dpnone')
    })
    // 密码输入
    $('.user-passwords input').on('focus', function(){
        $('.user-passwords').css({
            'border-bottom': '1px solid #fff'
        })
    })
    $('.user-passwords input').on('blur', function(){
        $('.user-passwords').css({
            'border-bottom': '1px solid #0c4b7a'
        })
    })
    $('.user-passwords input').on('input', function(){
        if($('.user-passwords input').val() == ''){
            $('.user-passwords').css({
                'border-bottom': '1px solid #0c4b7a'
            })
            $('.icon-password').addClass('dpnone').removeClass('dpblock')
        }else {
            $('.user-passwords').css({
                'border-bottom': '1px solid #fff'
            })
            $('.icon-password').addClass('dpblock').removeClass('dpnone')
        }
    })
    $('.icon-password').on('click',function(){
        $(this).siblings().val('')
        $(this).addClass('dpnone')
    })

    /*$('.login-btn').on('click',function(){
        window.location.href = './index.html'
    })*/
    // 兼容placeholder
    $(function(){
        if( !('placeholder' in document.createElement('input')) ){   
            $('input[placeholder],textarea[placeholder]').each(function(){    
                var that = $(this),    
                text= that.attr('placeholder');    
                if(that.val()===""){    
                   that.val(text).addClass('placeholder');    
                }    
                that.focus(function(){    
                   if(that.val()===text){    
                        that.val("").removeClass('placeholder');    
                    }    
                })    
                .blur(function(){    
                   if(that.val()===""){    
                        that.val(text).addClass('placeholder');    
                   }    
                })    
                .closest('form').submit(function(){    
                    if(that.val() === text){    
                        that.val('');    
                    }    
                });    
            });  
        }
    });
    
    
    /*************************************************************************************/
  //初始化页面时验证是否记住了密码
	$(document).ready(function() {
	    if (Cookie.get("rmbUser") == "true") {
	        $("#rmbUser").attr("checked", true);
	        $("#account").val(Cookie.get("userName"));
	        $("#password").val(Cookie.get("passWord"));
	        saveFlag = 2;
	    }
	});
	//登录回车
	$(document).keypress(function(e) {  
	       if((e.keyCode || e.which)==13) {  
	           $(".login-btn").click();  //login_btn登录按钮的id
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
    $(".login-btn").click(function(){
        $(".error").empty();//初始化隐藏登陆提示
    	if($("#acctIn").val()==null||$("#acctIn").val()==""){
			$(".error").text("未填写帐号！");
			return;
		}
		if($("#passwordIn").val()==null||$("#passwordIn").val()==""){
			$(".error").text("未填写密码！");
			return;
		}
		//saveUserInfo();
		$("#accountFormIn").val($("#acctIn").val());//表单赋值
		$("#passwordFormIn").val($("#passwordIn").val());//表单赋值
		var userName = $("#acctIn").val();
        var passWord = $("#passwordIn").val();
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
    
    //下载google
    $(".tips-spe").click(function(){
    	$("input[name='chrome32or64']").val('chrome64');
    	$("form[name='downGoogle']").submit();
    });
})