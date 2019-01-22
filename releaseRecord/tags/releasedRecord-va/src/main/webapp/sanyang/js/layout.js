define(function(require){
    var $ = require("$");
    var h = $('body').height(),
        w = $('body').width();
    $('.content').width(w-40);
    $('.content').height(h-40);
    $('.content-box').height(h-60)
    $('.content-box').width(w-40)
    $('.content-bottom').height(h-40);
    $('.pro-pic').width((w-144*3-160*2-40)/4)
    $('.img-box').height(h-60-100-50)
    $('.basic-info').height(($('.content-box').height()-73-34-20-2-30)*.6)
    $('.detention-info').height(($('.content-box').height()-73-34-20-2-30)*.4)
    $('.basic-content').height($('.basic-info').height()-51)
    $('.basic-img').width((w-40-26-30-40)*.17)
    $('.basic-detail').width((w-40-26-30-40)*.83)
    $('.outer-img').height($('.basic-img').height()-50)
    $('.outer-img').width($('.outer-img').height()*.75)
    $('.inside-img').height($('.outer-img').height()-20)
    $('.inside-img').width($('.outer-img').width()-20)
    $('.detail-content').height($('.basic-detail').height()-40)
    $('.detail-item').height($('.detail-content').height()*.3)
    $('.basic-city').height($('.detail-content').height()*.4)
    $('.detention-content').height($('.detention-info').height()-51)
    $(window).resize(function(){
        var h = $('body').height(),
            w = $('body').width();
        $('.content').width(w-40);
        $('.content').height(h-40);
        $('.content-box').height(h-60)
        $('.content-box').width(w-40)
        $('.content-bottom').height(h-40);
        $('.pro-pic').width((w-144*3-160*2-40)/4)
        $('.img-box').height(h-60-100-50)
        $('.basic-info').height(($('.content-box').height()-73-34-20-2-30)*.6)
        $('.detention-info').height(($('.content-box').height()-73-34-20-2-30)*.4)
        $('.basic-content').height($('.basic-info').height()-51)
        $('.basic-img').width((w-40-26-30-40)*.17)
        $('.basic-detail').width((w-40-26-30-40)*.83)
        $('.outer-img').height($('.basic-img').height()-50)
        $('.outer-img').width($('.outer-img').height()*.75)
        $('.inside-img').height($('.outer-img').height()-20)
        $('.inside-img').width($('.outer-img').width()-20)
        $('.detail-content').height($('.basic-detail').height()-40)
        $('.detail-item').height($('.detail-content').height()*.3)
        $('.basic-city').height($('.detail-content').height()*.4)
        $('.detention-content').height($('.detention-info').height()-51)
    })


})