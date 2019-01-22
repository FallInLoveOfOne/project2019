define(function(require) {
	var $ = require("$");

	$(function() {
		getData(); // 第一次加载数据
		// 开启定时任务，时间间隔为3000 ms。
		setInterval(function() {
			var datas = getData();
			if(datas){
				sleep(10000);// 有数据展示10s
			}
		}, 3000);
	});

	function getData() {
		var datas = "";
		var userObj = {
			number : "7ecaa068-ca16-4e32-93f2-a4344c50509f"
		};
		var param = {
			url : address + "message/getMessage",
			type : "POST",
			data : userObj,
			async : false,
			success : function(result) {
				datas = result;
				$("#showMessage").text(result);
				$("img.inside-img").attr("src",
						address + "Photomsg/" + result["photoPath"]);
			},
			error : function() {
			}
		};
		$.ajax(param);
		return datas;
	}
	
	// 设置休眠时间
	function sleep(d) {
		for (var t = Date.now(); Date.now() - t <= d;)
			;
	}

	$("#ajaxBt").click(function() {
		var userObj = {
			name : "来自ajax"
		};
		var param = {
			url : address + "home/addOne",
			type : "POST",
			data : userObj,
			async : false,
			success : function(result) {
				alert("SY_FCF库添加一条DEMO_USER记录成功");
			},
			error : function() {
			}
		};
		$.ajax(param);
	});

});