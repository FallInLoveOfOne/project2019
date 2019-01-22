define(function (require) {
    var $ = require("$");
    // 初次进入页面时，默认显示第一个页面
    // $('#iframe').attr('src','../../html/iframes/company/workers.html')
    // 计算设备屏幕的宽高来适应性的展示
    var h = $('body').height(), w = $('body').width();
    $('.main').height(h - 60)
    $('.main').width(w)
    $('.main-right').width(w - 220)
    // 手动更改浏览器宽高，计算自适应宽高
    $(window).resize(function () {
        var h = $('body').height(), w = $('body').width();
        $('.main').height(h - 60);
        $('.main-right').width(w - 220);
    })

    /* 侧边栏动画效果*/
    $('.sub-menu').on('click',function(){
        // if($(this).parent().find('.sub-menu3').is(":animated")){
        //     return ;
        // }
        if($(this).parent().find('.sub-menu2').hasClass('cur')){

            $(this).find('i').html('&#xe754;');
            // if($(this).parent().find('.sub-menu3').css('display') == "none"){
            //     $(this).parent().find('.sub-menu2').stop().animate({height:'toggle'}).removeClass('cur');
            // }else{
            //     $(this).parent().find('.sub-menu2').stop().animate({height:'toggle'}).removeClass('cur');
            // }
            $(this).parent().find('.sub-menu2').stop().animate({height:'toggle'}).removeClass('cur');
        }else{
            $(this).parent().find('.sub-menu2').stop().animate({height:'toggle'}).addClass('cur');
            $(this).find('i').html('&#xe74e;');
            $(this).parents('.menus').find('li:first .sub-menu2 i').html('&#xe74e;');
        }
    });

//    $('.menus>li:first .sub-menu2').on('click', function () {
//        if ($(this).parent().find('.sub-menu3').hasClass('cur')) {
//            $(this).find('i').html('&#xe735;');
//            $(this).parent().find('.sub-menu3').stop().animate({
//                height: 'toggle'
//            }).removeClass('cur');
//
//        } else {
//            $(this).parent().find('.sub-menu3').stop().animate({
//                height: 'toggle'
//            }).addClass('cur');
//            $(this).find('i').html('&#xe735;');
//        }
//    });

    // 侧边菜单 点击添加选中的样式
    $('.menu-child').on('click', function () {
        $(this).parents('.menus').find('.menu-child').removeClass('now');
        $('.sub-menu').removeClass('now')
        $(this).addClass('now');
    })
    $('.sub-menu').on('click', function () {
        $(this).parents('.menus').find('.menu-child').removeClass('now');
        $('.sub-menu').removeClass('now')
        $(this).addClass('now');
    })
    $(".icon-logout").on('click',function(){
    	 window.location.href = address+"logout";
    });
    // 侧边菜单 点击更换内容区域的地址
    $('.index').on('click', function () {
        window.location.href = address+'/sanyang/index.jsp';
    })
    $('.normal').on('click', function () {
        //if ($('#iframe').attr('src').indexOf('normal') < 0) {
            // $('#iframe').attr('src', './iframe/release/normal.html')
            $('#iframe').attr('src', 'release/toReleaseManage?json=')
       // }
    })
    $('.management').on('click', function () {
    	//待出所跳转存正并显示id
    	if(flag == "CZGL"){
    		 //var json = "{\"ID\":\"" + ID + "\"}";
    		 //$('#iframe').attr('src', 'evidence/toEvidenceManage?json='+json)
    		 
    		 var json = {"ID":ID};
 			 var jsonstr = JSON.stringify(json);
             $('#iframe').attr('src', 'evidence/toEvidenceManage?json=' + encodeURIComponent(jsonstr,'utf-8'));
    	}else{
	        if ($('#iframe').attr('src').indexOf('management') < 0) {
	            // $('#iframe').attr('src', './iframe/certificate/management.html')
	            $('#iframe').attr('src', 'evidence/toEvidenceManage?json=')
	        }
        }
    })
    $('.report').on('click', function () {
        if ($('#iframe').attr('src').indexOf('report') < 0) {
            // $('#iframe').attr('src', './iframe/report/report.html')
            $('#iframe').attr('src', 'sanyang/iframe/report/report.jsp')
        }
    })
    $('.dataInterfaceList').on('click', function () {
        if ($('#iframe').attr('src').indexOf('dataInterfaceList') < 0) {
            $('#iframe').attr('src', 'dataInterfaceManage/dataInterfaceList/toDataInterfaceList')
        }
    })
    $('.port').on('click', function () {
        if ($('#iframe').attr('src').indexOf('toInterfaceCallStatistics') < 0) {
            $('#iframe').attr('src', 'dataInterfaceManage/interfaceCallStatistics/toInterfaceCallStatistics')
        }
    })
    $('.password').on('click', function () {
        if ($('#iframe').attr('src').indexOf('password') < 0) {
            $('#iframe').attr('src', 'systemManage/changePassword/toPassword')
        }
    })
    $('.account').on('click', function () {
        if ($('#iframe').attr('src').indexOf('account') < 0) {
            $('#iframe').attr('src', 'systemManage/accountManage/toAccount')
        }
    })
    $('.character').on('click', function () {
        if ($('#iframe').attr('src').indexOf('character') < 0) {
            $('#iframe').attr('src', 'systemManage/roleManage/toCharacter')
        }
    })
    $(function () {
        ifame(flag);
        getLoginName();
    })
    //获取登录人员
    function getLoginName(){
    	var params = {
	    	url:address+"home/getLoginName",
			type:"POST",
			success:function(result){
				$(".top-r-name").html(result);
			},
			error:function(){
			}
    	}
    	$.ajax(params);
    }
    var ifame = function (flag) {
        if (flag == "CS") {// 最近待出所人员
            $('#iframe').attr('src', 'release/toReleaseManage?json=')
            $('.normal').click();
        }
        //2018-10-15  
        if (flag == "notOut") {// 出所管理  - 未出所
            $('#iframe').attr('src', 'release/toTempManage?json='+flag)
        }
        if (flag == "CZ") {// 最近出所人员
            $('#iframe').attr('src', 'evidence/toEvidenceManage/')
            $('.management').click();
        }
        if (flag == "TJ") {// 最近报告
            $('#iframe').attr('src', 'sanyang/iframe/report/report.jsp')
            $('.report').click();
        }
        if (flag == "search") {// 快速搜索
        	var json = {"ID":ID,"flagRedio":flagRedio,"BusiStatus":BusiStatus};
			var jsonstr = JSON.stringify(json);
			if(BusiStatus){
				if("WAIT"==BusiStatus){
					 $('#iframe').attr('src', 'release/toReleaseManage?json=' + encodeURIComponent(jsonstr,'utf-8'));
				}     
				if("NO_OUT"==BusiStatus){
					$('#iframe').attr('src', 'release/toTempManage?json='+ encodeURIComponent(jsonstr,'utf-8'));
				}
				if("normal"==BusiStatus){
					$('.management').click();
					$('#iframe').attr('src', 'evidence/toEvidenceManage?json='+ encodeURIComponent(jsonstr,'utf-8'));
				}
				if("temp"==BusiStatus){
					$('.management').click();
					$('#iframe').attr('src', 'evidence/toEvidenceTempMana?json='+ encodeURIComponent(jsonstr,'utf-8'));
				}
			}else{
			 $('#iframe').attr('src', 'release/toReleaseManage?json=' + encodeURIComponent(jsonstr,'utf-8'));
			}
        }
        if (flag == "TCS") {// 今日待出所
            //var json = "{\"flag\":\"" + flag + "\"}";
            var json = {"flag":flag};
			var jsonstr = JSON.stringify(json);
            $('#iframe').attr('src', 'release/toReleaseManage?json=' + encodeURIComponent(jsonstr,'utf-8'));
        }
        if (flag == "YQ") {// 逾期未处理
            //var json = "{\"flag\":\"" + flag + "\"}";
            var json = {"flag":flag};
			var jsonstr = JSON.stringify(json);
            $('#iframe').attr('src', 'release/toReleaseManage?json=' + encodeURIComponent(jsonstr,'utf-8'));
        }
        if (flag == "SH") {// 信息审核未通过
            //var json = "{\"flag\":\"" + flag + "\"}";
            var json = {"flag":flag};
			var jsonstr = JSON.stringify(json);
            $('#iframe').attr('src', 'release/toReleaseManage?json=' + encodeURIComponent(jsonstr,'utf-8'));
        }
        if (flag == "TX") {// 头像对比未通过
            //var json = "{\"flag\":\"" + flag + "\"}";
            var json = {"flag":flag};
			var jsonstr = JSON.stringify(json);
            $('#iframe').attr('src', 'release/toReleaseManage?json=' + encodeURIComponent(jsonstr,'utf-8'));
        }
        if (flag == "CSD") {// 出所单未上传
            //var json = "{\"flag\":\"" + flag + "\"}";
        	var json = {"flag":flag};
			var jsonstr = JSON.stringify(json);
            $('#iframe').attr('src', 'release/toReleaseManage?json=' + encodeURIComponent(jsonstr,'utf-8'));
        }

        if (flag == "CZGL") {// 存证管理
            //var json = "{\"ID\":\"" + ID + "\"}";
            //$('#iframe').attr('src', 'evidence/toEvidenceManage?json=' + json);
            //var json = {"ID":ID};
            var json = {"ID":ID,"flagRedio":"NUMER"};
			var jsonstr = JSON.stringify(json);
            $('.management').click();
            $('#iframe').attr('src', 'evidence/toEvidenceManage?json=' + encodeURIComponent(jsonstr,'utf-8'));
        }
    }

})