define(function(require){
    var $ = require("$"),
        h = $('body').height();
    //     w = $('body').width();
    // $('.content-box').height(h-60)
    // $('.content-box').width(w-40)
    $('.basic-info').height(($('.content-box').height()-73-34-20-2-30-28)*.6)
    $('.detention-info').height(($('.content-box').height()-73-34-20-2-30-28)*.4)
    // $('.basic-content').height($('.basic-info').height()-51)
    // $('.basic-img').width((w-40-26-30-40)*.17)
    // $('.basic-detail').width((w-40-26-30-40)*.83)
    // $('.outer-img').height($('.basic-img').height()-50)
    // $('.outer-img').width($('.outer-img').height()*.75)
    // $('.inside-img').height($('.outer-img').height()-20)
    // $('.inside-img').width($('.outer-img').width()-20)
    // $('.detail-content').height($('.basic-detail').height()-30)
    // $('.detail-item').height($('.detail-content').height()*.3)
    // $('.basic-city').height($('.detail-content').height()*.4)
    // $('.detention-content').height($('.detention-info').height()-51)
    $('.detention-item').height($('.detention-content').height()-20)
    // $('.pro-pic').width((w-144*3-160*2-40)/4)
    $(window).resize(function(){
        var h = $('body').height();
            // w = $('body').width();
        // $('.content-box').height(h-60)
        // $('.content-box').width(w-40)
        $('.basic-info').height(($('.content-box').height()-73-34-20-2-30-28)*.6)
        $('.detention-info').height(($('.content-box').height()-73-34-20-2-30-28)*.4)
        // $('.basic-content').height($('.basic-info').height()-51)
        // $('.basic-img').width((w-40-26-30-40)*.17)
        // $('.basic-detail').width((w-40-26-30-40)*.83)
        // $('.outer-img').height($('.basic-img').height()-50)
        // $('.outer-img').width($('.outer-img').height()*.75)
        // $('.inside-img').height($('.outer-img').height()-20)
        // $('.inside-img').width($('.outer-img').width()-20)
        // $('.detail-content').height($('.basic-detail').height()-30)
        // $('.detail-item').height($('.detail-content').height()*.3)
        // $('.basic-city').height($('.detail-content').height()*.4)
        // $('.detention-content').height($('.detention-info').height()-51)
        $('.detention-item').height($('.detention-content').height()-20)
        // $('.pro-pic').width((w-144*3-160*2-40)/4)
    })
    // 调用layui的弹窗
    layui.use('layer', function(){ //独立版的layer无需执行这一句
        var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句
        
        //触发事件
        var active = {
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
            notice: function(){
                //示范一个公告层
                layer.open({
                    type: 1,
                    title: false, //不显示标题栏
                    closeBtn: false,
                    //  ,area: '300px;'
                    area: ['420px', '200px'],
                    shade: 0.8,
                    id: 'LAY_layuipro', //设定一个id，防止重复弹出
                    btn: ['取消', '确定'],
                    btnAlign: 'r',
                    moveType: 1, //拖拽模式，0或者1
                    content: '<div style="background-color: #fff; color: #333; font-size: 16px;"><i class="iconfont" style="display:inline-block; vertical-align:middle; width:30px;height:30px;background-color: #f6c748; border-radius:50%; margin-right:15px;"></i>未达到出所时间，不符合出所条件!</div>',
                    success: function(layero){
                        // var btn = layero.find('.layui-layer-btn');
                        // btn.find('.layui-layer-btn0').attr({
                        // href: 'http://www.layui.com/'
                        // ,target: '_blank'
                        // });
                    },
                });
            }
        };
        
        $('.btn-box .layui-btn').on('click', function(){
          var othis = $(this), method = othis.data('method');
          active[method] ? active[method].call(this, othis) : '';
        });
        
    });    
})