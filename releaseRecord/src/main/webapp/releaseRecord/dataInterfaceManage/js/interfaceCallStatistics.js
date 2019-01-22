define(function (require) {
    var $ = require("$");
    var dataInterval = require("../../../../releaseRecord/dataInterfaceManage/js/dataInterval.js");
    var PATH = address + "dataInterfaceManage/interfaceCallStatistics";
    var myChart1 = echarts.init(document.getElementById('pie-chart'));
    var myChart2 = echarts.init(document.getElementById('line-chart'));
    var hasClick = true;
    var h = $('body').height();
    $('.content-bottom').height(h - 130);
    $('.manage-box').height($('.content-bottom').height() - 50);
    $(window).resize(function () {
        var h = $('body').height();
        $('.content-bottom').height(h - 130);
        $('.manage-box').height($('.content-bottom').height() - 50);
        myChart1.resize();
        myChart2.resize();
    });
    // tab切换
    $('.table-bar').on('click', function () {
        $(this).addClass('choosen-tab').siblings().removeClass('choosen-tab');
        $('.manage-box>div').eq($(this).index()).show().siblings().hide();
        if ($(this).index() == 1 && hasClick) {
            initInterfaceCallRatio();
            initDailyInterfaceCallFrequency();
            hasClick = false;
        }
        myChart1.resize();
        myChart2.resize();
    });z
    // 今天 本周点击切换
    $('.time-btn').on('click', function () {
        $(this).addClass('cktimebtn').siblings('.time-btn').removeClass('cktimebtn');
        $("#test-out-start,#test-out-end").val("");
        $(".layui-icon-close").click();
    });
    // 调用layui表格
    layui.use('table', function () {
        var table = layui.table;
        table.render({
            elem: '#contentTable',
            url: PATH + "/pageFindInterfaceCallInfo",
            height: 'full-185', // 差值，充满，并且距离底部的距离
            skin: 'line',
            cols: [[
                {field: '', width: '2%', title: ''},
                {field: 'INTERFACE_NAME', width: '16%', title: '接口名称'},
                {field: 'URL', width: '36%', title: '请求路径', style: 'color: #676767;'},
                {field: 'CALL_TIME', width: '13%', title: '调用模块'},
                {field: 'CALL_MODULE', width: '13%', title: '日期'}
            ]],
            id: 'performReload',
            page: true,
            limit: 10,
            request: {
                pageName: 'page', //页码的参数名称，默认：page
                limitName: 'rows' //每页数据量的参数名，默认：limit
            },where: {
                'queryCondition': JSON.stringify(getQueryCondition())
            }
        });
        var active = {
            reload: function () {
                table.reload('performReload', {   //执行重载
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: {
                        'queryCondition': JSON.stringify(getQueryCondition())
                    }
                });
            }
        };
        $('.check .check-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
            initInterfaceCallRatio();
            initDailyInterfaceCallFrequency();
        });
    });
    layui.use('laydate', function () {
        var laydate = layui.laydate;
        laydate.render({  //常规用法
            elem: '#test-out-start',
            format: 'yyyy-MM-dd',
            done: function (value) {
                checkQueryMode(value);
            }
        });
        laydate.render({
            elem: '#test-out-end',
            format: 'yyyy-MM-dd',
            done: function (value) {
                checkQueryMode(value);
            }
        });
    });
    var setInterfaceCallRatioOption = function (result) {
        var legendDate = [];
        var seriesDate = [];
        if (result.length > 0) {
            for (var i = 0; i < result.length; i++) {
                var date = result[i];
                var seriesDataJson = {
                    name: '',
                    value: 0,
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
                };
                seriesDataJson.name = date["INTERFACE_NAME"];
                seriesDataJson.value = date["COUNT"];
                legendDate.push(date["INTERFACE_NAME"]);
                seriesDate.push(seriesDataJson);
            }
        }
        var option1 = {
            tooltip: {
                trigger: 'item',
                formatter: "{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                right: '5%',
                top: 'center',
                data: legendDate
            },
            series: [
                {
                    name: '性别占比',
                    type: 'pie',
                    radius: '60%',
                    center: ['40%', '50%'],
                    data: seriesDate,
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
        return option1;
    }

    var setDailyInterfaceCallFrequencyOption = function (result) {
        var xAxisData = [];
        var seriesData = [];
        if (result.length > 0) {
            for (var i = 0; i < result.length; i++) {
                var data = result[i];
                xAxisData.push(data["INTERFACE_NAME"]);
                seriesData.push(data["COUNT"]);
            }
        }
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
                data: xAxisData,
                axisLabel: {
                    interval: 0,
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
                data: seriesData,
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
        return option2;
    }

    //初始化各接口调用数量占比
    var initInterfaceCallRatio = function () {
        $.ajax({
            url: PATH + "/getInterfaceCallRatioByStartEndTime",	//请求url
            type: "POST",	//请求类型  post|get
            data: getQueryCondition(),  //返回数据的 类型 text|json|html--
            success: function (date) {	//回调函数 和 后台返回的 数据
                myChart1.setOption(setInterfaceCallRatioOption(date), true);
            }
        });
    }

    //初始化每日接口调用频率
    var initDailyInterfaceCallFrequency = function () {
        $.ajax({
            url: PATH + "/getDailyInterfaceCallFrequency",	//请求url
            type: "POST",	//请求类型  post|get
            success: function (date) {	//回调函数 和 后台返回的 数据
                myChart2.setOption(setDailyInterfaceCallFrequencyOption(date), true);
            }
        });
    }

    //获取查询条件
    var getQueryCondition = function () {
        var queryCondition = {};  //查询条件
        var startDate = $("#test-out-start").val(); //获取起始日期
        var endDate = $("#test-out-end").val(); //获取截至日期
        if (!(startDate || endDate)) {
            var timeBnt = $(".cktimebtn");
            if (timeBnt.is(".today-btn")) {
                startDate = dataInterval.getTodayStartDate(); //获得今天开始日期
                endDate = dataInterval.getTodayStartDate(); //获得今天开始日期(后端添加至当天23:59:59)
            } else if (timeBnt.is(".week-btn")) {
                startDate = dataInterval.getWeekStartDate(); //获得本周的开始日期
                endDate = dataInterval.getWeekEndDate();  //获得本周的结束日期
            } else if (timeBnt.is(".mounth-btn")) {
                startDate = dataInterval.getMonthStartDate();   //获得本月的开始日期
                endDate = dataInterval.getMonthEndDate();   //获得本月的结束日期
            } else if (timeBnt.is(".season-btn")) {
                startDate = dataInterval.getQuarterStartDate();   //获得本季度的开始日期
                endDate = dataInterval.getQuarterEndDate();   //获得本季度的结束日期
            }
        }
        queryCondition.startDate = startDate;
        queryCondition.endDate = endDate;
        return queryCondition;
    }

    //判断当前查询方式勾选默认值
    var checkQueryMode = function (value) {
        var startDate = $("#test-out-start").val(); //获取起始日期
        var endDate = $("#test-out-end").val(); //获取截至日期
        if (startDate || endDate || value) { //当前为时间段查询方式
            $('.time-btn').removeClass('cktimebtn');
        } else {
            $('.week-btn').addClass('cktimebtn');
        }
    }
    var todayStartDate = dataInterval.getTodayStartDate(); //获得今天开始日期
    var weekStartDate = dataInterval.getWeekStartDate(); //获得本周的开始日期
    var weekEndDate = dataInterval.getWeekEndDate();  //获得本周的结束日期
    var monthStartDate = dataInterval.getMonthStartDate();   //获得本月的开始日期
    var monthEndDate = dataInterval.getMonthEndDate();   //获得本月的结束日期
    var quarterStartDate = dataInterval.getQuarterStartDate();   //获得本季度的开始日期
    var quarterEndDate = dataInterval.getQuarterEndDate();   //获得本季度的结束日期
});