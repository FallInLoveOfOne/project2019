define(function(require){
    var $ = require("$")
        h = $('body').height(),
        w = $('body').width();
    $('.report-content').height(h-60);
    $('.report-box').width(w-40);
    $('.report-box').height(h-100);
   // screenLayOut()
    $(window).resize(function(){
        var $ = require("$")
            h = $('body').height(),
            w = $('body').width();
        $('.report-content').height(h-60);
        $('.report-box').width(w-40);
        $('.report-box').height(h-100);
     //   screenLayOut()
    })
    function screenLayOut () {
        if(screen.width == 1920 && screen.height == 900){
            $('.report-text').addClass('pt35')
            $('.report-title-name').addClass('h30')
            $('.person-detail').addClass('h35')
            $('.id-num').addClass('h35')
            $('.detail-text').addClass('h35')
            $('.person-info').addClass('h257')
            $('.person-info').addClass('mt30')
            $('.person-img').addClass('mt40')
            $('.person-detail-info').addClass('mt40')
        }else {
            $('.report-text').removeClass('pt35')
            $('.report-title-name').removeClass('h30')
            $('.person-detail').removeClass('h35')
            $('.id-num').removeClass('h35')
            $('.detail-text').removeClass('h35')
            $('.person-info').removeClass('h257')
            $('.person-info').removeClass('mt30')
            $('.person-img').removeClass('mt40')
            $('.person-detail-info').removeClass('mt40')
        }
    }
    
    
 // 点击关闭，关闭当亲页面
    $("#closeBT").click(function(){
    	window.opener=null;
		window.open('','_self');
		window.close();
    });
    
  //人员出生日期出生日期初始化
    function initPerBirth(perBirth){//19700814
    	if(perBirth){
    		var datemat = perBirth.substring(0,4)+"-"+perBirth.substring(4,6)+"-"+perBirth.substring(6,8);
    		$("#perBirth").text(datemat);
    	}else{
    		$("#perBirth").text(perBirth);
    	}
    }
    
    initPerBirth(perBirth);
})