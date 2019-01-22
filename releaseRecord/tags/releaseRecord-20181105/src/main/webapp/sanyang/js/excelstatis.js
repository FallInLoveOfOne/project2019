define(function(require){
    var $ = require("$");
    var h = $('body').height();
        // w = $('body').width();
    // $('.content').width(w-40);
    // $('.content').height(h-40);
    $('.content-bottom').height(h-130);
    $('.manage-box').height($('.content-bottom').height() - 50)
    $(window).resize(function(){
        var h = $('body').height();
            // w = $('body').width();
        // $('.content').width(w-40);
        // $('.content').height(h-40);
        $('.content-bottom').height(h-130);
        $('.manage-box').height($('.content-bottom').height() - 50);
        myChart1.resize();
        myChart2.resize();
    })
    // $('.manage-box>div').eq(1).show().siblings().hide();
    // initEcharts()
    $('.tab-table>div').on('click', function() {
        $('.manage-box>div').eq($(this).index()).show().siblings().hide();
        var hasClick = false;
        if($(this).index() == 1 && !hasClick) {
            initEcharts()
            hasClick = true
        }
    })
    // 调用layui表格
    layui.use('table', function(){
        var table = layui.table;
        table.render({
            elem: '#test',
            height:'full-185', // 差值，充满，并且距离底部的距离
            skin:'line',
            data:[
                {name:'查询拘留所人员信息接口',src:'http://10.118.5.86:8380/jc/prisoner/findAllDetentionPeopleInfo',module:'待出所人员管理',inTime:'2018-03-23  14:34'},
                {name:'查询拘留所人员信息接口',src:'http://10.118.5.86:8380/jc/prisoner/findAllDetentionPeopleInfo',module:'待出所人员管理',inTime:'2018-03-23  14:34'},
                {name:'查询拘留所人员信息接口',src:'http://10.118.5.86:8380/jc/prisoner/findAllDetentionPeopleInfo',module:'待出所人员管理',inTime:'2018-03-23  14:34'},
                {name:'查询拘留所人员信息接口',src:'http://10.118.5.86:8380/jc/prisoner/findAllDetentionPeopleInfo',module:'待出所人员管理',inTime:'2018-03-23  14:34'},
                {name:'查询拘留所人员信息接口',src:'http://10.118.5.86:8380/jc/prisoner/findAllDetentionPeopleInfo',module:'待出所人员管理',inTime:'2018-03-23  14:34'},
                {name:'查询拘留所人员信息接口',src:'http://10.118.5.86:8380/jc/prisoner/findAllDetentionPeopleInfo',module:'待出所人员管理',inTime:'2018-03-23  14:34'},
                {name:'查询拘留所人员信息接口',src:'http://10.118.5.86:8380/jc/prisoner/findAllDetentionPeopleInfo',module:'待出所人员管理',inTime:'2018-03-23  14:34'},
                {name:'查询拘留所人员信息接口',src:'http://10.118.5.86:8380/jc/prisoner/findAllDetentionPeopleInfo',module:'待出所人员管理',inTime:'2018-03-23  14:34'},
                {name:'查询拘留所人员信息接口',src:'http://10.118.5.86:8380/jc/prisoner/findAllDetentionPeopleInfo',module:'待出所人员管理',inTime:'2018-03-23  14:34'},
                {name:'查询拘留所人员信息接口',src:'http://10.118.5.86:8380/jc/prisoner/findAllDetentionPeopleInfo',module:'待出所人员管理',inTime:'2018-03-23  14:34'},
                {name:'查询拘留所人员信息接口',src:'http://10.118.5.86:8380/jc/prisoner/findAllDetentionPeopleInfo',module:'待出所人员管理',inTime:'2018-03-23  14:34'},
                {name:'查询拘留所人员信息接口',src:'http://10.118.5.86:8380/jc/prisoner/findAllDetentionPeopleInfo',module:'待出所人员管理',inTime:'2018-03-23  14:34'},
                {name:'查询拘留所人员信息接口',src:'http://10.118.5.86:8380/jc/prisoner/findAllDetentionPeopleInfo',module:'待出所人员管理',inTime:'2018-03-23  14:34'},
                {name:'查询拘留所人员信息接口',src:'http://10.118.5.86:8380/jc/prisoner/findAllDetentionPeopleInfo',module:'待出所人员管理',inTime:'2018-03-23  14:34'},
                {name:'查询拘留所人员信息接口',src:'http://10.118.5.86:8380/jc/prisoner/findAllDetentionPeopleInfo',module:'待出所人员管理',inTime:'2018-03-23  14:34'},
                {name:'查询拘留所人员信息接口',src:'http://10.118.5.86:8380/jc/prisoner/findAllDetentionPeopleInfo',module:'待出所人员管理',inTime:'2018-03-23  14:34'},
                {name:'查询拘留所人员信息接口',src:'http://10.118.5.86:8380/jc/prisoner/findAllDetentionPeopleInfo',module:'待出所人员管理',inTime:'2018-03-23  14:34'},
                {name:'查询拘留所人员信息接口',src:'http://10.118.5.86:8380/jc/prisoner/findAllDetentionPeopleInfo',module:'待出所人员管理',inTime:'2018-03-23  14:34'},
                {name:'查询拘留所人员信息接口',src:'http://10.118.5.86:8380/jc/prisoner/findAllDetentionPeopleInfo',module:'待出所人员管理',inTime:'2018-03-23  14:34'},
                {name:'查询拘留所人员信息接口',src:'http://10.118.5.86:8380/jc/prisoner/findAllDetentionPeopleInfo',module:'待出所人员管理',inTime:'2018-03-23  14:34'},
                {name:'查询拘留所人员信息接口',src:'http://10.118.5.86:8380/jc/prisoner/findAllDetentionPeopleInfo',module:'待出所人员管理',inTime:'2018-03-23  14:34'},
                {name:'查询拘留所人员信息接口',src:'http://10.118.5.86:8380/jc/prisoner/findAllDetentionPeopleInfo',module:'待出所人员管理',inTime:'2018-03-23  14:34'}
            ],
            cols: [[
                {field:'', width:'1%', title: ''},
                {field:'name', width:'17%', title: '接口名称'},
                {field:'src', width:'36%', title: '请求路径',style:'color: #676767;'},
                {field:'module', width: '13%', title: '调用模块'},
                {field:'inTime', width: '13%', title: '日期'}
            ]],
            page: true,
            limit: 10
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
    layui.use(['form','laydate', 'jquery'],function(){
        var form = layui.form,
            laydate = layui.laydate,
            $ = layui.jquery;
        form.render();
        var start = laydate.render({
            elem: '#test-out-start',
            format: 'yyyy-MM-dd',
            done: function(value, date, endDate) {
                if(value !==''){
                    end.config.min = {
                        year: date.year,
                        month: date.month - 1,
                        date: date.date
                    }
                }else {
                    end.config.min = {
                        year: '',
                        month: '',
                        date: ''
                    }
                }
            }
        });
        var end = laydate.render({
            elem: '#test-out-end',
            format: 'yyyy-MM-dd',
            done: function(value, date, endDate) {
                if(value != ''){
                    start.config.max = {
                        year: date.year,
                        month: date.month - 1,
                        date: date.date
                    }
                }else {
                    start.config.max = {
                        year: '',
                        month: '',
                        date: ''
                    }
                }
            }
        });
        $('.time-btn').on('click', function(){
            var a = $('#test-out-start').val().split('-')
            start.config.max = {
                year: a[0], 
                month: a[1], 
                date: a[2]
            }
            end.config.min = {
                year: a[0], 
                month: a[1] -1,
                date: a[2]
            }
        })
    })
    // tab切换
    $('.table-bar').on('click',function(){
        $(this).addClass('choosen-tab').siblings().removeClass('choosen-tab')
    })
    // 今天 本周点击切换
    $('.time-btn').on('click', function(){
        $(this).addClass('cktimebtn').siblings('.time-btn').removeClass('cktimebtn')
    })

    function initEcharts() {
        var myChart1 = echarts.init(document.getElementById('pie-chart'));
    
        var option1 = {
            tooltip : {
                trigger: 'item',
                formatter: "{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                right: '20%',
                top: 'center',
                data: ['查询拘留所人员信息接口','查询拘留所人员信息接口1','查询拘留所人员信息接口2','查询拘留所人员信息接口3','查询拘留所人员信息接口4']
            },
            series : [
                {
                    name: '性别占比',
                    type: 'pie',
                    radius : '60%',
                    center: ['40%', '50%'],
                    data:[
                        {
                            value:100,
                            name:'查询拘留所人员信息接口',
                            itemStyle: {
                                color: '#94c1fa'
                            },
                            label: {
                                color: '#666',
                                fontSize: 14
                            },
                            labelLine: {
                                length: 30,
                                length2: 30,
                                lineStyle: {
                                    color: '#666'
                                }
                            }
                        },
                        {
                            value:200,
                            name:'查询拘留所人员信息接口1',
                            itemStyle: {
                                color: '#fab952'
                            },
                            label: {
                                color: '#666',
                                fontSize: 14
                            },
                            labelLine: {
                                length: 30,
                                length2: 30,
                                lineStyle: {
                                    color: '#666'
                                }
                            }
                        },
                        {
                            value:300,
                            name:'查询拘留所人员信息接口2',
                            itemStyle: {
                                color: '#c6c6c6'
                            },
                            label: {
                                color: '#666',
                                fontSize: 14
                            },
                            labelLine: {
                                length: 30,
                                length2: 30,
                                lineStyle: {
                                    color: '#666'
                                }
                            }
                        },
                        {
                            value:400,
                            name:'查询拘留所人员信息接口3',
                            itemStyle: {
                                color: '#74dcb1'
                            },
                            label: {
                                color: '#666',
                                fontSize: 14
                            },
                            labelLine: {
                                length: 30,
                                length2: 30,
                                lineStyle: {
                                    color: '#666'
                                }
                            }
                        },
                        {
                            value:500,
                            name:'查询拘留所人员信息接口4',
                            itemStyle: {
                                color: '#efefef'
                            },
                            label: {
                                color: '#666',
                                fontSize: 14
                            },
                            labelLine: {
                                length: 30,
                                length2: 30,
                                lineStyle: {
                                    color: '#666'
                                }
                            }
                        }
                    ],
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        
        myChart1.setOption(option1, true);
    
        var myChart2 = echarts.init(document.getElementById('line-chart'));
    
        var option2 = {
            tooltip: {
                trigger: 'item',
                formatter: '{b} : {c}'
            },
            grid: {
                left: 100,
                right: 100,
                height: '65%'
            },
            xAxis: {
                type: 'category',
                data: ['查询拘留所人员信息接口', '查询拘留所人员信息接口', '查询拘留所人员信息接口', '查询拘留所人员信息接口', '查询拘留所人员信息接口', '查询拘留所人员信息接口', '查询拘留所人员信息接口', '查询拘留所人员信息接口', '查询拘留所人员信息接口', '查询拘留所人员信息接口'],
                axisLabel: {
                    fontSize: 14,
                    rotate: 30
                }
            },
            yAxis: {
                type: 'value',
                axisLabel: {
                    fontSize: 14
                }
            },
            series: [{
                data: [25, 150, 100, 175, 155, 25, 150, 100, 175, 155],
                type: 'line',
                smooth: true,
                symbolSize: 14,
                lineStyle: {
                    width: 4,
                    color: '#50a2f9'
                },
                itemStyle: {
                    color: '#50a2f9',
                    borderWidth: 2
                }
            }]
        };
        
        myChart2.setOption(option2, true);
    }

})