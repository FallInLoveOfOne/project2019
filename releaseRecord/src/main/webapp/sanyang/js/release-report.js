define(function(require) {
	var $ = require("$");

	/** ***************全局************************************************************ */

	// var dataValue = [];// [25, 150, 100]['审核通过人数', '头像对比成功人数', '出所单上传人数']
	// var normal_ = 1;// 正常出所人数
	// var abnormal_ = 3;
	/** **************************************************************************** */
	var myChart1;var myChart2;
	function css() {
		
		
		var h = $('body').height(), w = $('body').width();
		$('.report-main').width(w - 40).height(h - 100);
		$('.report-chart').height($('.report-main').height() - 150);
		$('.pie-chart, .line-chart').width($('.report-chart').width() / 2);
		$(window).resize(function() {
			var h = $('body').height(), w = $('body').width();
			$('.report-main').width(w - 40).height(h - 100);
			$('.report-chart').height($('.report-main').height() - 150);
			$('.pie-chart, .line-chart').width($('.report-chart').width() / 2);
			myChart1.resize();
			myChart2.resize();
		})
	}
	// 本月我戒毒所计划出所20人，实际出所犯人28名，其中正常出所18人，临时出所10人。审核通过18人，头像对比成功25人，出所单上传28人。
	// 初始化reportType值
	// $(function(){
	/*
	 * function initData() { init(); } initData();
	 */

	function init() {
		if (reportType == "月") {
			var report_type = "month"
		}
		if (reportType == "周") {
			var report_type = "week"
		}
		if (reportType == "年") {
			var report_type = "year"
		}
		var param = {
			url : address + "report/getOutDetox",
			type : "POST",
			data : {
				"report_type" : report_type
			},
			async : true,
			success : function(result) {
				var dataValue = [];
				// for(var key in result){
				var outDetoxPlanNum = result["outDetoxPlanNum"];// 计划出所
				var realOut = result["realOut"];// 实际出所
				normal = result["normal"];
				abnormal = result["abnormal"];
				reviewSucc = result["reviewSucc"];
				faceSucc = result["faceSucc"];
				upRecord = result["upRecord"];
				dataValue.push(reviewSucc);
				dataValue.push(faceSucc);
				dataValue.push(upRecord);
				normal_ = normal;
				abnormal_ = abnormal;
				var datahtml = "本" + reportType + "我戒毒所计划出所" + outDetoxPlanNum
						+ "人，实际出所犯人" + realOut + "名，其中正常出所" + normal + "人，临时出所"
						+ abnormal + "人。审核通过" + reviewSucc + "人，头像对比成功"
						+ faceSucc + "人，出所单上传" + upRecord + "人。";
				$(".report-intro").html(datahtml);
				// }
				// setMatterNum(result);//2018-01-24注释
				var option1 = echarts1(normal, abnormal);

				var option2 = echarts2(dataValue);

			},
			error : function() {
			}
		};
		$.ajax(param);
	}
	init();
	/** ***************************************************************************** */
	function echarts1(normal, abnormal) {
		css();
		var myChart1 = echarts.init(document.getElementById('pie-chart'));

		var option1 = {
			title : {
				text : '出所类型统计',
				x : 'center',
				bottom : 50
			},
			tooltip : {
				trigger : 'item',
				formatter : "{b} : {c} ({d}%)"
			},
			series : [ {
				name : '出所类型占比',
				type : 'pie',
				radius : '50%',
				center : [ '50%', '40%' ],
				data : [ {
					value : normal,
					name : '正常出所',
					itemStyle : {
						color : '#62a5ed'
					},
					label : {
						color : '#666',
						fontSize : 14
					},
					labelLine : {
						length : 30,
						length2 : 30,
						lineStyle : {
							color : '#666'
						}
					}
				}, {
					value : abnormal,
					name : '临时出所',
					itemStyle : {
						color : '#e6e4e4'
					},
					label : {
						color : '#666',
						fontSize : 14
					},
					labelLine : {
						length : 30,
						length2 : 30,
						lineStyle : {
							color : '#666'
						}
					}
				} ],
				itemStyle : {
					emphasis : {
						shadowBlur : 10,
						shadowOffsetX : 0,
						shadowColor : 'rgba(0, 0, 0, 0.5)'
					}
				}
			} ]
		};
		myChart1.setOption(option1);

	}
	/** ********************************************************************************** */
	function echarts2(dataValue) {
		css();
		var myChart2 = echarts.init(document.getElementById('line-chart'));

		var option2 = {
			title : {
				text : '各环节数量统计',
				x : 'center',
				bottom : 50
			},
			tooltip : {
				trigger : 'item',
				formatter : '{b} : {c}'
			},
			grid : {
				left : '25%',
				top : '20%',
				width : '50%',
				height : '50%'
			},
			xAxis : {
				type : 'category',
				data : [ '审核通过', '头像对比', '出所单上传' ],
				axisLabel : {
					fontSize : 14
				}
			},
			yAxis : {
				type : 'value',
				axisLabel : {
					fontSize : 14
				}
			},
			series : [ {
				data : dataValue,// [25, 150, 100]
				type : 'line',
				smooth : true,
				symbolSize : 14,
				lineStyle : {
					width : 4,
					color : '#50a2f9'
				},
				itemStyle : {
					color : '#50a2f9',
					borderWidth : 2
				}
			} ]
		};
		myChart2.setOption(option2);
		var picBase64Info = myChart2.getDataURL();
	}
	//表单提交图片码
	$(".load").click(function(){
		$("input[name='imag']").val(getFullCanvasDataURL("line-chart"));
		$("input[name='image2']").val(getFullCanvasDataURL("pie-chart"));
		$("form[name='exportReport']").submit();
	})
	
	//下载
	function downOutFiles(url) {
		var el = document.createElement("a");
		document.body.appendChild(el);
		el.href = url;
		el.target = '_blank';
		el.click();
		document.body.removeChild(el);
	}
	//echarts 生成base64url
	function getFullCanvasDataURL(divId) {
		// 将第一个画布作为基准。
		var baseCanvas = $("#" + divId).find("canvas").first()[0];
		if (!baseCanvas) {
			return false;
		}
		;
		var width = baseCanvas.width;
		var height = baseCanvas.height;
		var ctx = baseCanvas.getContext("2d");
		// 遍历，将后续的画布添加到在第一个上
		$("#" + divId).find("canvas").each(function(i, canvasObj) {
			if (i > 0) {
				var canvasTmp = $(canvasObj)[0];
				ctx.drawImage(canvasTmp, 0, 0, width, height);
			}
		});
		// 获取base64位的url
		return baseCanvas.toDataURL();
	}

})