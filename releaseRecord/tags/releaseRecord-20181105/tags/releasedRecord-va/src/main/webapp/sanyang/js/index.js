define(function(require) {
	var $ = require("$");
    var w = $('body').width(),
    h = $('body').height();

// $('.main').width(w).height(h - 60);
$(".main").css("cssText", "width:"+w+"px !important;width:"+(w-40)+"");
// $('.bottom-item').width(($('.main-bottom').width() - 40)/3);
$(".bottom-item").css("cssText", "width:"+(($('.main-bottom').width() - 40)/3)+"px !important;width:"+(($('.main-bottom').width() - 80)/3)+"");
// $('.main-police').width($('.bottom-item').width() + 40);
$(".main-police").css("cssText", "width:"+($('.bottom-item').width() + 40)+"px !important;width:"+($('.bottom-item').width())+"");
// $('.main-matters').width($('.main-top').width() - $('.main-police').width() - 61);
$(".main-matters").css("cssText", "width:"+($('.main-top').width() - $('.main-police').width() - 61)+"px !important;width:"+($('.main-top').width() - $('.main-police').width() - 101)+"");
$(".things-box").css("cssText", "width:"+(($('.main-matters').width() - 60)/3)+"px !important;")
$(window).resize(function() {
    var w = $('body').width(),
        h = $('body').height();

    // $('.main').width(w - 40).height(h);

    // $('.bottom-item').width(($('.main-bottom').width() - 160)/3);
    // $('.main-police').width($('.bottom-item').width());
    // $('.main-matters').width($('.main-top').width() - $('.main-police').width() - 101);

    $(".main").css("cssText", "width:"+w+"px !important;width:"+(w-40)+"");
    $(".bottom-item").css("cssText", "width:"+(($('.main-bottom').width() - 40)/3)+"px !important;width:"+(($('.main-bottom').width() - 80)/3)+"");
    $(".main-police").css("cssText", "width:"+($('.bottom-item').width() + 40)+"px !important;width:"+($('.bottom-item').width())+"");
    $(".main-matters").css("cssText", "width:"+($('.main-top').width() - $('.main-police').width() - 61)+"px !important;width:"+($('.main-top').width() - $('.main-police').width() - 101)+"");
    $(".things-box").css("cssText", "width:"+(($('.main-matters').width() - 60)/3)+"px !important;")
})

	// 调用layui表格
	layui.use('form', function(){
		var form = layui.form
		form.render()
	});
	layui.use('table', function() {
		var table = layui.table;
		// 待出所
		table.render({
			elem : '#will-out',
			height : 'full-386', // 差值，充满，并且距离底部的距离
			skin : 'line',
			url : address + 'release/normalPage',
			where : getQueryRelease(),// 查所有
			request : {
				pageName : 'curr' // 页码的参数名称，默认：page
				,
				limitName : 'nums' // 每页数据量的参数名，默认：limit
			},
			cols : [ [ {
				field : 'NUMBER',
				width : '40%',
				title : '人员编号',
				event : 'perNum_y'
			}, {
				field : 'NAME',
				width : '25%',
				title : '姓名',
				style : 'color: #676767;'
			}, {
				field : 'HOLD_END',
				width : '35%',
				title : '待出所时间',
				templet : function(d) {
					return dateFormat(d.HOLD_END)
				}
			} ] ]
		});

		/*
		 * table.on('row(will-out)', function(obj){ var data = obj.data; var
		 * personNumber = data["NUMBER"]; var prisonId=data["DORM_CODE"]; var
		 * userName=data["NAME"]; var holdEnd=data["HOLD_END"]; var
		 * nowDate="";// 当前日期 var isNewOpt="";// 用于判断是否有操作记录 var nextStep=""//
		 * 若有记录，下一步
		 * window.open(address+'release/outPersonDetails?prisonId='+prisonId+'&number='+personNumber);
		 * });
		 */
		table.on('tool(will-out)', function(obj) {// 选中单元格
			var data = obj.data;
			if (obj.event === 'perNum_y') {
				layer.confirm('确认进入待出所人员详情页面？', {
					icon : 3,
					title : '提示',
				}, function(index) {
					var personNumber = data["NUMBER"];
					var prisonId = data["DORM_CODE"];
					window.open(address + "release/outPersonDetails?prisonId="
							+ prisonId + "&number=" + personNumber);
					layer.close(index);
				});
			}
		});

		// 已出所
		table.render({
			elem : '#last-out',
			height : 'full-386', // 差值，充满，并且距离底部的距离
			skin : 'line',
			url : address + 'evidence/evidencePageList',
			where : getQuery(),// 所有已经出所
			request : {
				pageName : 'curr' // 页码的参数名称，默认：page
				,
				limitName : 'nums' // 每页数据量的参数名，默认：limit
			},
			cols : [ [ {
				field : 'NUMBER',
				width : '40%',
				title : '人员编号',
				event : 'perNum'
			}, {
				field : 'NAME',
				width : '25%',
				title : '姓名',
				style : 'color: #676767;'
			}, {
				field : 'HOLD_END',
				width : '35%',
				title : '出所时间',
				templet : function(d) {
					return dateFormat(d.HOLD_END)
				}
			} ] ]
		});

		// 日期格式化
		function dateFormat(date) {
			if (date) {
				var datemat = date.substring(0, 4) + "-" + date.substring(4, 6)
						+ "-" + date.substring(6, 8);
				return datemat;
			}
			return "";
		}
		/*
		 * table.on('row(last-out)', function(obj){ var data = obj.data; var
		 * personNumber = data["NUMBER"]; var prisonId=data["DORM_CODE"];
		 * window.open(address+"evidence/toOutDetoxDetails?prisonId="+prisonId+"&number="+personNumber);
		 * });
		 */
		table.on('tool(last-out)', function(obj) {
			var data = obj.data;
			if (obj.event === 'perNum') {
				layer.confirm('确认进入出所人员详情页面？', {
					icon : 3,
					title : '提示',
				}, function(index) {
					var personNumber = data["NUMBER"];
					var prisonId = data["DORM_CODE"];
					window.open(address
							+ "evidence/toOutDetoxDetails?prisonId=" + prisonId
							+ "&number=" + personNumber);
					layer.close(index);
				});
			}
		});

		// 报告
		table.render({
			elem : '#last-report',
			height : 'full-386', // 差值，充满，并且距离底部的距离
			skin : 'line',
			url : address + "report/getReportList",
			where : getQueryReport(),
			request : {
				pageName : 'curr' // 页码的参数名称，默认：page
				,
				limitName : 'nums' // 每页数据量的参数名，默认：limit
			},
			cols : [ [ {
				field : 'name',
				width : '65%',
				title : '报告名称',
				event : 'reportName',
				style : 'color: #676767;'
			}, {
				field : 'inTime',
				width : '35%',
				title : '生成时间',
				templet : function(d) {
					return dateFormat(d.inTime)
				}
			} ] ]
		});
		// 监听单元格事件
		table.on('tool(last-report)', function(obj) {
			var data = obj.data;
			if (obj.event === 'reportName') {
				layer.confirm('确认进入报告详情页面？', {
					icon : 3,
					title : '提示',
				}, function(index) {
					var inTime = data.inTime;
					var id = data.id;
					var name = data.name;
					var reportType = data.reportType;
					window.open(address + "report/toReleaseReport/" + inTime
							+ "/" + id + "/" + name + "/" + reportType);
					layer.close(index);
				});
			}
		});
		// 行监听
		/*
		 * table.on('row(last-report)', function(obj){ var data = obj.data; var
		 * inTime = data.inTime;var id =data.id;var name =data.name;var
		 * reportType=data.reportType;
		 * window.open(address+"report/toReleaseReport/"+inTime+"/"+id+"/"+name+"/"+reportType);
		 * });
		 */
	});

	// 获取查询条件
	function getQueryRelease() {
		var queryObj = {};
		queryObj.userName = '';
		queryObj.userNumber = '';
		queryObj.startDate = '';
		queryObj.endDate = '';
		queryObj.excepVal = '';// 异常类型，获取radio的选中值
		queryObj.waitOrFlag='';
		return queryObj;
	}

	// 获取查询条件
	function getQuery() {
		var queryObj = {};
		queryObj.userName = '';
		queryObj.userNumber = '';
		queryObj.startDate = '';
		queryObj.endDate = '';
		queryObj.outType = '';// 异常类型，获取radio的选中值
		return queryObj;
	}
	function getQueryReport() {
		var queryObj = {};
		queryObj.report_type = '';
		return queryObj;
	}
	// 退出
	$(".icon-logout").on('click', function() {
		window.location.href = address+"logout";
	});
	// 点击正常出所页面 今日待出所
	/*$('#wait-num').on('click', function() {
		var flag = $(".wait-num").attr("flag");
		// window.location.href = address+'sanyang/iframe/release/normal.jsp';
		window.location.href = address + 'home/tomain/' + flag;
	})
	// 逾期未处理 待完成----------
	$('#over-num').on('click', function() {
		var flag = $(".over-num").attr("flag");
		window.location.href = address + 'home/tomain/' + flag;
	})
	// 审核不通过的人员页面
	$('.thing1').on('click', function() {
		var flag = $("#thing1").attr("flag");
		window.location.href = address + 'home/tomain/' + flag;
	})
	// 头像对比未通过
	$('.thing2').on('click', function() {
		var flag = $("#thing2").attr("flag");
		window.location.href = address + 'home/tomain/' + flag;
	})
	// 出所单未上传
	$('.thing3').on('click', function() {
		var flag = $("#thing3").attr("flag");
		window.location.href = address + 'home/tomain/' + flag;
	})*/
	
	//处理事项-- 待出所
	$("#waitOut").on('click',function(){
		var flag = $("#checkMore").attr("flag");
		window.location.href = address + 'home/tomain/' + flag;
	})
	//未出所
	$("#notOut").on('click',function(){
		//未出所
		var flag = "notOut";
		window.location.href = address + 'home/tomain/' + flag;
	})
	//已处所
	$("#already").on('click',function(){
		var flag = $(".last-view-more").attr("flag");
		window.location.href = address + 'home/tomain/' + flag;
	})

	$('.QuickSearch').on('click', function() {
		//新增分类搜索  2018-10-10   NUMER-编号  SFZ-身份证  NAME-姓名
		var checkedType = $("input[name='serachType']:checked").val();
		var flag = $(this).attr("flag");
		var ID = $("#personID").val();
		if (ID != "" && ID != null ) {
			//var BusiStatus = initSearch(ID,checkedType);// WAIT_KEY   NO_OUT_KEY  NORMAL_KEY  TEMP_KEY
			var BusiStatus=null;
	    	$.ajax({
		    	url:address+'home/initSearch?ID='+ID+'&checkedType='+checkedType,
				type:"POST",
				async: false,
				success:function(result){// WAIT_KEY   NO_OUT_KEY  NORMAL_KEY  TEMP_KEY
					BusiStatus=result;
				},
				error:function(){
				}
	    	})
			var jsonstr = {"flag":flag,"ID":ID,"flagRedio":checkedType,"BusiStatus":BusiStatus};
			var json = JSON.stringify(jsonstr);
			
			window.location.href = address + 'home/search/' + encodeURIComponent(json,'utf-8');
		} else {
			layer.open({
				title : '友情提示',
				content : '请输入正确的人员信息！'
			});
		}
	})
	$('.will-view-more').on('click', function() {
		var flag = $(this).attr("flag");
		window.location.href = address + 'home/tomain/' + flag;
	})

	$('.last-view-more').on('click', function() {
		var flag = $(this).attr("flag");
		window.location.href = address + 'home/tomain/' + flag;
	})

	$('.report-view-more').on('click', function() {
		var flag = $(this).attr("flag");
		window.location.href = address + 'home/tomain/' + flag;
		// window.location.href = address+"sanyang/main.jsp?flag=3"
	})

	$(function() {
		// 获取处理事项的数量
		getNum();
		getLoginName();
	})
	  //获取登录人员
    function getLoginName(){
    	var params = {
	    	url:address+"home/getLoginName",
			type:"POST",
			success:function(result){
				$(".top-r-name").html(result);
			},
			error:function(){
			}
    	}
    	$.ajax(params);
    }
	var getNum = function() {
		var param = {
			url : address + 'home/getMatterNum',
			type : "POST",
			success : function(result) {
				for ( var key in result) {
					/*if (key == "todatNum") {
						$(".wait-num").html(result[key])
					}
					if (key == "overdue") {
						$(".over-num").html(result[key])
					}
					if (key == "InfoFail") {
						$("#thing1").html(result[key])
					}
					if (key == "face") {
						$("#thing2").html(result[key])
					}
					if (key == "recordUP") {
						$("#thing3").html(result[key])
					}*/
					if(key=="waitOut"){
						$("#wait-num").html(result[key]);
					}
					if(key=="notOut"){
						$("#not-num").html(result[key]);
					}
					if(key=="already"){
						$("#already-num").html(result[key]);
					}
				}
			},
			error : function() {
			}
		};
		$.ajax(param);
	}

	//单选按钮 人员编号-身份证 
	$("#searchStatus").click(function(){
		$(".personID").attr("value","");
		var checkedType = $("input[name='serachType']:checked").val();
		//人员编号
		if(checkedType=="NUMER"){
			$(".personID").attr("placeholder","请输入人员编号");
		}
		//身份证
		if(checkedType=="SFZ"){
			$(".personID").attr("placeholder","请输入人员身份证");
		}
		//姓名
		if(checkedType=="NAME"){
		$(".personID").attr("placeholder","请输入人员姓名");
		}
	});
	
	$(".bigFace").click(function(){
		window.open(address + 'release/toBigScreenFace');
	});
})