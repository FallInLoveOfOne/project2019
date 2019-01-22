define(function (require) {
    var $ = require("$");
    var dataInterval = require("../../../../sanyang/iframe/dataInterfaceManage/js/dataInterval.js");
    var PATH = address + "dataInterfaceManage/interfaceCallStatistics";
    var myChart1 = echarts.init(document.getElementById('pie-chart'));
    var myChart2 = echarts.init(document.getElementById('line-chart'));
    var startDateLay;
    var endDateLay;
    var hasClick = true;
    var h = $('body').height();
    $('.content-bottom').height(h - 130);
    $('.manage-box').height($('.content-bottom').height() - 50);
    $(window).resize(function () {  //窗口大小改变回调函数
        var h = $('body').height();
        $('.content-bottom').height(h - 130);
        $('.manage-box').height($('.content-bottom').height() - 50);
        myChart1.resize();
        myChart2.resize();
    });

    //点击其他区域关闭td详情
    $("body").on("click",function (e) {
        var target = $(e.target);
        if(!(target.is(".layui-table-tips-main")||target.is(".layui-table-grid-down")||target.is(".layui-icon-down"))){
            $(".layui-icon-close").click();//关闭表格详情弹出框
        }
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
    });
    // 今天 本周点击切换
    $('.time-btn').on('click', function () {
        var startDate = "";
        var endDate = "";
        $("#test-out-start,#test-out-end").val(""); //清空时间控件值
        if ($(this).is(".cktimebtn")) {
            $(this).removeClass('cktimebtn');
        } else {
            $(this).addClass('cktimebtn').siblings('.time-btn').removeClass('cktimebtn');
            if ($(this).is(".today-btn")) {
                startDate = dataInterval.getTodayStartDate(); //获得今天开始日期
                endDate = dataInterval.getTodayStartDate(); //获得今天开始日期(后端添加至当天23:59:59)
            } else if ($(this).is(".week-btn")) {
                startDate = dataInterval.getWeekStartDate(); //获得本周的开始日期
                endDate = dataInterval.getWeekEndDate();  //获得本周的结束日期
            } else if ($(this).is(".mounth-btn")) {
                startDate = dataInterval.getMonthStartDate();   //获得本月的开始日期
                endDate = dataInterval.getMonthEndDate();   //获得本月的结束日期
            } else if ($(this).is(".season-btn")) {
                startDate = dataInterval.getQuarterStartDate();   //获得本季度的开始日期
                endDate = dataInterval.getQuarterEndDate();   //获得本季度的结束日期
            }
        }
        setLayDate(startDate, endDate);
        $("#test-out-start").val(startDate);    //根据快捷查询设置laydate起始值
        $("#test-out-end").val(endDate);    //根据快捷查询设置laydate截至值
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
                {field: '', width: '1%', title: ''},
                {field: 'INTERFACE_NAME', width: '17%', title: '接口名称'},
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
            }, where: {
                'queryCondition': JSON.stringify(getQueryCondition())
            }
        });
        //查询参数
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
        //查询按钮点击事件
        $('.check .check-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
            initInterfaceCallRatio();
            initDailyInterfaceCallFrequency();
        });
    });
    //起始事件控件
    layui.use('laydate', function () {
        var laydate = layui.laydate;
        startDateLay = laydate.render({  //常规用法
            elem: '#test-out-start',
            format: 'yyyy-MM-dd',
            btns: ['clear', 'confirm'],
            done: function (value, dates) {
                if (value) {
                    endDateLay.config.min = {
                        year: dates.year,
                        month: dates.month - 1, //关键
                        date: dates.date
                    };
                } else {
                    endDateLay.config.min = {
                        year: 1900,
                        month: 0, //关键
                        date: 1
                    };
                }
                removeShortcutOptions(value,$("#test-out-end").val());  //控件事件都为空时清除快捷选择
            }
        });
        //截止时间控件
        endDateLay = laydate.render({
            elem: '#test-out-end',
            format: 'yyyy-MM-dd',
            btns: ['clear', 'confirm'],
            done: function (value, dates) {
                if (value) {
                    startDateLay.config.max = {
                        year: dates.year,
                        month: dates.month - 1,//关键
                        date: dates.date
                    }
                } else {
                    startDateLay.config.max = {
                        year: 2099,
                        month: 11,//关键
                        date: 31
                    }
                }
                removeShortcutOptions($("#test-out-start").val(),value);    //控件事件都为空时清除快捷选择
            }
        });
    });
    //设置接口调用占比参数
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
                right: '2%',
                top: 'center',
                data: legendDate
            },
            series: [
                {
                    name: '性别占比',
                    type: 'pie',
                    radius: '60%',
                    center: ['30%', '50%'],
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
    //设置每日接口调用占比参数
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
            data: getQueryCondition(),
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
        queryCondition.startDate = $("#test-out-start").val(); //获取起始日期
        queryCondition.endDate = $("#test-out-end").val(); //获取截至日期
        return queryCondition;
    }

    //根据快捷选择设置控件值
    var setLayDate = function (startDateStr, endDateStr) {
        if (endDateStr) {
            var endDate = new Date(endDateStr);
            startDateLay.config.max = {
                year: endDate.getFullYear(),
                month: endDate.getMonth(),//从0开始算起
                date: endDate.getDate()
            }
        } else {
            startDateLay.config.max = {
                year: 2099,
                month: 11,//从0开始算起
                date: 31
            }
        }
        if (startDateStr) {
            var startDate = new Date(startDateStr);
            endDateLay.config.min = {
                year: startDate.getFullYear(),
                month: startDate.getMonth(),//从0开始算起
                date: startDate.getDate()
            };
        } else {
            endDateLay.config.min = {
                year: 1900,
                month: 0, //从0开始算起
                date: 1
            };
        }
    }

    //判断两个时间控件如果都为空则去除快捷选择
    var removeShortcutOptions = function(starDate,endDate){
        if(!(starDate||endDate)){
            $(".cktimebtn").removeClass('cktimebtn');
        }
    }

    // var todayStartDate = dataInterval.getTodayStartDate(); //获得今天开始日期
    // var weekStartDate = dataInterval.getWeekStartDate(); //获得本周的开始日期
    // var weekEndDate = dataInterval.getWeekEndDate();  //获得本周的结束日期
    // var monthStartDate = dataInterval.getMonthStartDate();   //获得本月的开始日期
    // var monthEndDate = dataInterval.getMonthEndDate();   //获得本月的结束日期
    // var quarterStartDate = dataInterval.getQuarterStartDate();   //获得本季度的开始日期
    // var quarterEndDate = dataInterval.getQuarterEndDate();   //获得本季度的结束日期
})
;