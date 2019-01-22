define(function(require){
    var $ = require("$");
        h = $('body').height();
        // w = $('body').width();
    $('.content-box').height(h-70)
    // $('.content-box').width(w-40)
    // $('.pro-pic').width((w-144*3-160*2-40)/4)
    $('.img-box').height(h-70-100-70)
    $(window).resize(function(){
        var h = $('body').height();
    //         w = $('body').width();
        $('.content-box').height(h-70)
        // $('.content-box').width(w-40)
        // $('.pro-pic').width((w-144*3-160*2-40)/4)
        $('.img-box').height(h-70-100-70)
    }) 


    // layui.use('element', function(){
    //     var $ = layui.jquery,
    //         element = layui.element;
    // })
    
    $('.right-close i').on('click', function(){
        $('.mask-box').hide()
    })

})