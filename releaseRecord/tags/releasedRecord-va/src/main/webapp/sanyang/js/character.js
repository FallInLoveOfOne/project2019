define(function(require){
    var $ = require("$");
    // var h = $('body').height(),
    //     w = $('body').width();
    // $('.content').width(w-40);
    // $('.content').height(h-40);
    // $('.content-bottom').height(h-40);
    // $(window).resize(function(){
    //     var h = $('body').height(),
    //         w = $('body').width();
        // $('.content').width(w-40);
        // $('.content').height(h-40);
        // $('.content-bottom').height(h-40);
    // })
    // 调用layui表格
    layui.use('table', function(){
        var table = layui.table;
        table.render({
            elem: '#test',
            height:'full-45', // 差值，充满，并且距离底部的距离
            skin:'line',
            data:[
                {category:'查看角色' ,explain:'首页，待出所人员查询、详情查看，已出所人员查询、详情查看，报告查看，数据接口查询，密码修改',inTime:'2018-03-23  14:34',},
                {category:'编辑角色' ,explain:'首页，待出所人员查询、详情查看、出所操作，已出所人员查询、详情查看，报告查看，数据接口查询，密码修改，账号管理，角色管理',inTime:'2018-03-23  14:34',}
            ],
            cols: [[
                {field:'', width:'2%', title: ''},
                {field:'category', width:'10%', title: '角色类别'},
                {field:'explain', width:'72%', title: '角色权限说明'},
                {field:'inTime', width: '15%', title: '创建日期'}
            ]],
            page: true,
            limit: 10
        });
        //监听表格复选框选择
        table.on('checkbox(demo)', function(obj){
            console.log(obj)
        });
        //监听工具条
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            console.log(data)
            // 查看的提示框
            if(obj.event === 'detail'){
                // layer.msg('ID：'+ data.id + ' 的查看操作');
                // console.log(data)
                // layui.use(['layer', 'form'], function(){ //独立版的layer无需执行这一句
                //     var $ = layui.jquery, layer = layui.layer, form = layui.form; //独立版的layer无需执行这一句
                //     layer.open({
                //             type: 2
                //             ,title: ['查看信息'] //不显示标题栏
                //             ,closeBtn: 1
                //             ,area: ['400px', '500px']
                //             ,shade: 0.4
                //             ,id: 'LAY_layuipro7' //设定一个id，防止重复弹出
                //             ,btn: ['确定']
                //             ,btnAlign: 'c'
                //             ,moveType: 1 //拖拽模式，0或者1
                //             ,content:'../../../html/iframes/company/check-layer.html?'+encodeURI(JSON.stringify(data))
                //         });            
                // })  
                    
                    
                                                   
            } else if(obj.event === 'del'){
                // 删除的提示框
                layer.confirm('真的删除行么', function(index){
                    obj.del();
                    layer.close(index);
                });
                // 编辑的提示框
            } else if(obj.event === 'edit'){

                // layer.alert('编辑行：<br>'+ JSON.stringify(data))
                // layui.use(['form','layer','laydate'], function(){ //独立版的layer无需执行这一句
                //     var $ = layui.jquery, form = layui.form, layer = layui.layer, laydate = layui.laydate; //独立版的layer无需执行这一句
                //         laydate.render({
                //             elem: '#maskCalendarIn'
                //             ,lang: 'en'
                //         })
                //         laydate.render({
                //             elem: '#maskCalendarOut'
                //             ,lang: 'en'
                //         })
                //         layer.open({
                //             type: 2 // type为1content是拼接字符串，为2是页面链接
                //             ,title: ['编辑信息'] //不显示标题栏
                //             ,closeBtn: 1
                //             ,area: ['400px', '500px']
                //             ,shade: 0.4
                //             ,id: 'LAY_layuipro7' //设定一个id，防止重复弹出
                //             ,btn: ['确定']
                //             ,btnAlign: 'c'
                //             ,moveType: 1 //拖拽模式，0或者1
                //             ,content:'../../../html/iframes/company/edit-layer.html?'+encodeURI(JSON.stringify(data))
                //         });            
                // })                
            }
        });
    });
    // tab点击切换
    // 路径
    // tab样式
    $('.tab-bar div').on('click', function(){
        $(this).addClass('ckbtn').siblings().removeClass('ckbtn')
    })
    // 今天 本周点击切换
    $('.time-btn').on('click', function(){
        $(this).addClass('cktimebtn').siblings('.time-btn').removeClass('cktimebtn')
    })
})