define(function(require){
    var $ = require("$");
    var now = new Date(); //当前日期 
    var nowDayOfWeek = now.getDay()==0?7:now.getDay(); //今天本周的第几天 
    var nowDay = now.getDate(); //当前日 
    var nowMonth = now.getMonth(); //当前月 
    var nowYear = now.getYear(); //当前年 
    nowYear += (nowYear < 2000) ? 1900 : 0; //
    
    var lastMonthDate = new Date(); //上月日期
    lastMonthDate.setDate(1);
    lastMonthDate.setMonth(lastMonthDate.getMonth()-1);
    var lastYear = lastMonthDate.getYear();
    var lastMonth = lastMonthDate.getMonth();
    
    //格式化日期：yyyy-MM-dd 
    function formatDate(date) { 
        var myyear = date.getFullYear(); 
        var mymonth = date.getMonth()+1; 
        var myweekday = date.getDate(); 
        
        if(mymonth < 10){
            mymonth = "0" + mymonth; 
        } 
        if(myweekday < 10){
            myweekday = "0" + myweekday; 
        } 
        return (myyear+"-"+mymonth + "-" + myweekday); 
    } 
    
    //获得某月的天数 
    function getMonthDays(myMonth){ 
        var monthStartDate = new Date(nowYear, myMonth, 1); 
        var monthEndDate = new Date(nowYear, myMonth + 1, 1); 
        var days = (monthEndDate - monthStartDate)/(1000 * 60 * 60 * 24); 
        return days; 
    } 
    
    //获得本季度的开始月份 
    function getQuarterStartMonth(){
        var quarterStartMonth = 0; 
        if(nowMonth<3){ 
            quarterStartMonth = 0; 
        } 
        if(2<nowMonth && nowMonth<6){ 
            quarterStartMonth = 3; 
        } 
        if(5<nowMonth && nowMonth<9){ 
            quarterStartMonth = 6; 
        } 
        if(nowMonth>8){ 
            quarterStartMonth = 9; 
        } 
        return quarterStartMonth; 
    } 
    //获得本周的开始日期 
    function getWeekStartDate() { 
        var weekStartDate = new Date(nowYear, nowMonth, nowDay - (nowDayOfWeek-1)); 
        return formatDate(weekStartDate); 
    } 
    
    //获得本周的结束日期 
    function getWeekEndDate() { 
        var weekEndDate = new Date(nowYear, nowMonth, nowDay + (7 - nowDayOfWeek)); 
        return formatDate(weekEndDate); 
    } 
    
    //获得本月的开始日期 
    function getMonthStartDate(){ 
        var monthStartDate = new Date(nowYear, nowMonth, 1); 
        return formatDate(monthStartDate); 
    } 
    
    //获得本月的结束日期 
    function getMonthEndDate(){ 
        var monthEndDate = new Date(nowYear, nowMonth, getMonthDays(nowMonth)); 
        return formatDate(monthEndDate); 
    }
    //获得本季度的开始日期 
    function getQuarterStartDate(){ 
        var quarterStartDate = new Date(nowYear, getQuarterStartMonth(), 1); 
        return formatDate(quarterStartDate); 
    } 
    
    //或的本季度的结束日期 
    function getQuarterEndDate(){ 
        var quarterEndMonth = getQuarterStartMonth() + 2; 
        var quarterStartDate = new Date(nowYear, quarterEndMonth, getMonthDays(quarterEndMonth)); 
        return formatDate(quarterStartDate); 
    }

     // 点击获取时间日期

    // 获取今天的日期并设置日期
    $('.today-btn').on('click', function(){
        var tdDate = '';
        tdDate = nowYear+'-'+(nowMonth+1)+'-'+nowDay
        $('#startDate').val(tdDate)
        $('#endDate').val(tdDate)
    })
     
    // 获取本周日期范围 并 设置日期
    $('.week-btn').on('click', function(){
        $('#startDate').val(getWeekStartDate())
        $('#endDate').val(getWeekEndDate())
    })
    // 获取当前月份并设置
    $('.mounth-btn').on('click', function(){
        $('#startDate').val(getMonthStartDate())
        $('#endDate').val(getMonthEndDate())
    })
    // 获取当前季度并设置
    $('.season-btn').on('click', function(){
        $('#startDate').val(getQuarterStartDate())
        $('#endDate').val(getQuarterEndDate())
    })
    
})