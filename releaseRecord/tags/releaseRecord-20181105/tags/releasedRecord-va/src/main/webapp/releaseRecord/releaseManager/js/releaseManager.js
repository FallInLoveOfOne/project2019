define(function(require) {
	var Dialog = require("inno/dialog/1.0.0/dialog-debug"), Select = require("inno/select/1.0.0/select-debug"), Form = require("form"), $ = require("$");
	require("easyui");

	var path = address + "release/";

	// 初始化form表单
	var form = new Form({
		trigger : ".search-form"
	});

	// 初始化查询
	initTable = function(queryCondition) {
		$("#tblResult").datagrid({
			queryParams : {
				queryCondition : queryCondition
			},
			nowrap : false, // 是否自动换行 false=换；true=不换
			autoRowHeight : true,
			striped : true,
			collapsible : true,
			url : path + "getListPage",// 为resource层地址
			idField : 'id',// 为查出数据的主键
			columns : getGridColumns(),// 为列初始化
			pagination : true,// 为分页控件
			rownumbers : false,// 为行号控制
			pageNumber : 1,
			pageList : [ 10, 30, 50, 100, 200 ],
			sortName : "name",
			sortOrder : "desc"
		});
	};

	// 显示列
	function getGridColumns() {
		return [ [ {
			field : 'ID',
			title : '主键',
			width : 300,
			align : 'center',
			sortable : true
		}, {
			field : 'NAME',
			title : '名称',
			width : 250,
			align : 'center',
			sortable : true
		}, {
			field : 'opt',
			title : '操作',
			width : 150,
			align : 'center',
			formatter : getGridOperation
		} ] ];
	}
	;

	/** ***************************点击事件和函数******************************************** */

	// 操作函数模板
	function getGridOperation(value, rec, index) {
		var a = '<a href="javascript:void(0)" onclick="check(\'' + rec.ID
				+ '\' )" >查看</a> ';
		var b = '<a href="javascript:void(0)" onclick="edit(\'' + rec.NAME
				+ '\' )" >编辑</a> ';
		return a + b;
	}

	check = function(id) {
		alert("查看:" + id);
		// var href = address+"dcda/toDaADE/"+id+"/check";
		// window.open(href);
	}

	edit = function(id) {
		alert("编辑:" + id);
		// var href = address+"dcda/toDaADE/"+id+"/edit";
		// window.open(href);
	};

	// 新增
	$(".ui-button-add").on('click', '', function() {
		var href = address + "dcda/toDaADE";
		window.open(href);
	});

	// 查询
	$(".ui-button-search").on(
			'click',
			'',
			function() {
				var dashId = $(".dashId").val();
				var dashName = $(".dashName").val();
				var queryCondition = '{"id":"' + dashId + '","userName":"'
						+ dashName + '"}';
				initTable(queryCondition);
			});

	// 重置
	$(".ui-button-reset").on('click', '', function() {
		var searchForm = form.get("eleArray");
		searchForm.map(function(i, elem) {
			$(this).val("");
		});
		var queryCondition = "";
		initTable(queryCondition);
	});

	/** **********************初始化*********************************************** */

	initFuc = function() {
		// var queryCondition ="";
		var dashId = $(".dashId").val();
		var dashName = $(".dashName").val();
		var queryCondition = '{"dashId":"' + dashId + '","dashName":"'
				+ dashName + '"}';
		initTable(queryCondition);
	};
	initFuc();

});