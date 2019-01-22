define(function(require){
    var $ = require("$");
    upload = require("fileupload");
    var w = $('body').width();
    $('.basic-detail').width(w-136-170);
    $(window).resize(function(){
        var w = $('body').width();
        $('.basic-detail').width(w-136-170);
    })
    // 调用layui的弹窗
    // layui.use('layer', function(){ //独立版的layer无需执行这一句
    //     var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句
    // 调用layui的表格
    function getRecordList(){// 获取出所节点记录
    layui.use('table', function(){
        var table = layui.table;
        table.render({
            elem: '#record',
            url: 'fcfRecord/getRecordsByNumber',
            skin:'line',
            cols: [[
                {field:'', width:'5%', title: ''},
                //{field:'ID', width:'24%', title: '操作人员编号'},
                {field:'CREATE_USER_NAME', width:'35%', title: '操作人姓名',style:'color: #676767;'},
                {field:'CREATE_TIME', width: '35%', title: '操作时间',templet:function(d){return dateFormat(d.CREATE_TIME)}},
                {field:'ITEM', width: '35%', title: '操作事项'}
            ]],
            where:{number:number,name:name,historyid:historyid}
        });
    });
	}
    
    //--------------------------------------------------------------------------------------------
    function getEvidenceInfo(){// 存证信息
      /*  layui.use('table', function(){
            var table = layui.table;
            table.render({
                elem: '#certificate',
                url: 'evidence/toOutDetoxDetails1',
                skin:'line',
                cols: [[
                    {field:'', width:'5%', title: ''},
                    {field:'NAME', width: '20%', title: '姓名'},
                    {field:'HOUSE_ADDR_VALUE', width: '30%', title: '家庭住址'},
                    {field:'HOLD_END', width:'30%', title: '戒毒结束时间',templet:function(d){return dateFormat(d.HOLD_END)}},
                    {field:'classify', width:'15%', title: '操作',templet:'#titleTpr3'}
                ]],
                where:{number:number,prisonId:prisonId}
            });
          //监听工具条
            table.on('tool(demo2)', function(obj){
                var data = obj.data;
                accId_ = data["ACC_ID"];// 附件ID
                if(obj.event === 'checkList'){//查看出所单信息
                	window.open(address+'evidence/toReportDetail2');
                }
            });
        });*/
    	$(".check-out-btn").on('click', function(){
    		window.open(address+'evidence/toReportDetail2?prisonId='+prisonId+'&number='+number+'&historyid='+historyid);
    	});
    	}
  
   
	
	// 数据初始化（出所记录、附件列表）
	function initData(){
		getRecordList();// 获取出所记录
		getEvidenceInfo();//存证信息
		initTime();//存证信息出所单时间
	}
	
	initData();
	

    function initTime(){
   	 var timestamp =getNowFormatDate();
   	 $("#currTime").text(timestamp);
   }
  //获取当前时间，格式YYYY-MM-DD  HH:MM:SS
    function getNowFormatDate() {
        var date = new Date();
        var seperator1 = "-";
        var seperator2 = ":";
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        var strDate = date.getDate();
        if (month >= 1 && month <= 9) {
            month = "0" + month;
        }
        if (strDate >= 0 && strDate <= 9) {
            strDate = "0" + strDate;
        }
        var currentdate = year + seperator1 + month + seperator1 + strDate+ " " + date.getHours() + seperator2 + date.getMinutes();
        return currentdate;
    }
	// 日期格式化
    function dateFormat(date){
    	if(date){
    		var datemat = date.substring(0,4)+"-"+date.substring(4,6)+"-"+date.substring(6,8)+" "+date.substring(8,10)+":"+date.substring(10,12);
    		return datemat;
    	}
    	return "";
    }
	
	// 点击关闭，关闭当亲页面
    $(".closeBT").click(function(){
    	window.opener=null;
		window.open('','_self');
		window.close();
    });
    
   
})