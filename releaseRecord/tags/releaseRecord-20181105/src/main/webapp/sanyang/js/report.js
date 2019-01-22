define(function(require){
    var $ = require("$");
    var h = $('body').height();
        // w = $('body').width();
    // $('.content').width(w-40);
    // $('.content').height(h-40);
    $('.content-bottom').height(h-74);
    $(window).resize(function(){
        var h = $('body').height();
            // w = $('body').width();
        // $('.content').width(w-40);
        // $('.content').height(h-40);
        $('.content-bottom').height(h-74);
    })
    
    var tableIns;
   /* var report_type=function(){
    	var type = $(".mounth-report").attr("flag");
    	return type;
    };*/
    // 调用layui表格  report_type
    layui.use('table', function(){
        var table = layui.table;
         tableIns = table.render({
            elem: '#test',
            height:'full-109', // 差值，充满，并且距离底部的距离
            skin:'line',
            limits:[10],
            url:address+"report/getReportList",
            method:'post',
            where:{"report_type":"week"},
            request: {
                pageName: 'curr' //页码的参数名称，默认：page
                ,limitName: 'nums' //每页数据量的参数名，默认：limit
              },
            cols: [[
                {field:'', width:'3%', title: ''},
                {field:'id', width:'30%', title: '报告编号'},
                {field:'name', width:'35%', title: '报告名称',style:'color: #676767;'},
                {field:'inTime', width: '10%', title: '日期',templet:function(d){return dateFormat(d.inTime)}},
                {field:'classify', width:'25%', title: '操作',templet:'#titleTpr'}
            ]],
            page: true,
            limit: 10,
            done: function(res, curr, count){
                //如果是异步请求数据方式，res即为你接口返回的信息。
                //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
                console.log(res);
                //得到当前页码
                console.log(curr); 
                //得到数据总量
                console.log(count);
              }
        });
         
         //日期转换
         function dateFormat(date){
        	 if(date){
        		 return date.substring(0,4)+"-"+date.substring(4,6)+"-"+date.substring(6,8);
        	 }
        	 return "";
         }
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
                 console.log(data)//{inTime: "2018-9-3", name: "name12", id: "12"}
               /*  layui.use(['layer', 'form'], function(){ //独立版的layer无需执行这一句
                     var $ = layui.jquery, layer = layui.layer, form = layui.form; //独立版的layer无需执行这一句
                     layer.open({
                             type: 2
                             ,title: ['查看信息'] //不显示标题栏
                             ,closeBtn: 1
                             ,area: ['400px', '500px']
                             ,shade: 0.4
                             ,id: 'LAY_layuipro7' //设定一个id，防止重复弹出
                             ,btn: ['确定']
                             ,btnAlign: 'c'
                             ,moveType: 1 //拖拽模式，0或者1
                             ,content:'../../../html/iframes/company/check-layer.html?'+encodeURI(JSON.stringify(data))
                         });            
                 }) */
                // window.location.href = address+"sanyang/html/release-report.jsp?inTime="+data.inTime+"&id="+data.id+"&name="+data.name+"&reportType="+data.reportType;
//                 window.open(address+"sanyang/html/release-report.jsp?inTime="+data.inTime+"&id="+data.id+"&name="+data.name+"&reportType="+data.reportType);
                var inTime = dateFormat(data.inTime);var id =data.id;var name =data.name;var reportType=data.reportType;
                 window.open(address+"report/toReleaseReport/"+inTime+"/"+id+"/"+name+"/"+reportType);
                                                   
            } else if(obj.event === 'del'){
                // 删除的提示框
                layer.confirm('真的删除行么', function(index){
                    obj.del();
                    layer.close(index);
                });
                // 点击下载
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
    
    // 年季月点击切换tab
    $('.tab-report').on('click',function(){
        var index = $(this).index()
        $(this).children('.bar-report').addClass('dpblock').removeClass('dpnone')
        $(this).siblings().children('.bar-report').addClass('dpnone').removeClass('dpblock')
        //重载
       report_type =  $(this).attr("flag");
        tableIns.reload({
          	  page:{ curr:1 },
          	  where:{"report_type":report_type}
        });
    })
   
})