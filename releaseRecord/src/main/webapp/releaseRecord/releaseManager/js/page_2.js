define(function(require){
	var $ = require("$"),
		Select = require("inno/select/1.0.0/select-debug"),
		Dialog = require("inno/dialog/1.0.0/dialog-debug");
		SelectTree = require("inno/select-tree/1.0.0/select-tree-debug");
		Form = require("form"),
		require("easyui");
		Confirmbox = require("inno/dialog/1.0.0/confirmbox-debug");
	
	//翻译详细地址为null的情况
	formatAddDetail = function(str){
		if(str&&str.indexOf("xi")!=-1){
			return "已经被格式化";
		}else{
			return (str==null||str=="null" )?"":str;
		}
	}
	
	
	
	//判断是否全选
	isSelectAll = function(){
		var flag  = false;
		var checkboxes = $(".query-result-table").find('input[name="filename-child"]');
		if ($('#selectAll').is(':checked')) {
			flag = true;
			checkboxes.each(function(index, el) {
				this.checked = true;
			});
		}else{
			checkboxes.each(function(index, el) {
				this.checked = false;
			});
			
		}
		return flag;
	}
	
	//移除全选
	removeCheckBox = function(){
		$("#selectAll").attr("checked",false);
    	$('input:[name=filename-child]').each(function(){
    		$(this).attr("checked",false);
    	});
	}
	
	
	
	//获取查询条件并封装
	getQueryCondition = function(){
		var leadName = $("#leadName").val().trim();
		var leadDep = $("#leadDep").val().trim();	
		var s = {
				"rules":[],
				"groups":[],
				"op":"and"
		};
		if(leadName!=""){
			var status = {
					"field" : "id",
					"op" : "equal",
					"value" : leadName
			};
			s.rules.push(status);
		}
		if(leadDep!=""){
			var status = {
					"field" : "userName",
					"op" : "like",
					"value" : leadDep
			};
			s.rules.push(status);
		}
		
		var queryCondition = JSON.stringify(s);
		return queryCondition;
	}
	
	//简化查询条件
	getCondition = function(){
		var query={};
		query.id = $("#demo_id").val().trim();
		query.name = $("#demo_name").val().trim();	
		return query;
	}
	
	//获取每页数据
	getGridColumns = function(num,pageNumber) {
		//var queryCondition = getQueryCondition();
		var queryCondition = getCondition();
		queryCondition.page=pageNumber;
		queryCondition.rows=num;
		var result = ""
		$.ajax({				
			url: address + "release/getListPage2",
			//data:{queryCondition:queryCondition,page:pageNumber,rows:num,sort:"createDt",order:"desc"},
			data:queryCondition,
			type:"POST",
			async: false,
			success:function(res){	
				removeCheckBox();
				result = res;
			},
			error:function(result){
				layer.msg('系统查询失败');
			}						
		})
		return result;
	}
	
	//查询事件
	$(".btn-query").on('click','',function(){
		removeCheckBox();
		var table = "query-result-table";
		var num = $("#"+table+"_select").find("option:selected").text()|| 10;
		var TableObj = {
				content:table,
				dataFuc:"getGridColumns",
				pageList:num,
				pageNumber:1,
				callback:callbackOpt
		}
		getTableData(TableObj);
	});
	
	//重置事件
	$(".btn-reset").on('click','',function(){
		reset();
	});
	
	//重置方法
	reset = function(){
		$("#leadName").val('');
		leadDepSelect.selectValue("");
		leadAreaSelect.resetSelect();
		tellBuisType('selectLeadArea','-请选择初审地区-');
	    initTable();
	}
	
	//刷新
	tableRefresh = function(){
		initTable();
	}
	
	/*=====================新增Dialog==============================*/
	var addLeadDiaLog = new Dialog({
		width:'910px',
		height:'650px',
		title:'新增',
	}).before('show',function(){
    	var url = address+"leadbusi/forward/add";
    	this.set('content',url);
	});
	/*===================================================*/
	
	//新增
	$("#addButton").click(function(){ 
		layer.open({
		   type: 2,
		   title: '新增',
		   maxmin: true,
		   shadeClose: false, //点击遮罩关闭层
		   area : ['710px' , '600px'],
		   content: address+"leadbusi/forward/add"
		 });
	});
	
	//批量删除
	$("#deleteSome").click(function(){
		var idArray = [];
		$('input:checkbox[name=filename-child]:checked').each(function(){
			$(this).attr("checked",true);
			idArray.push($(this).attr("id"));
		});
		if(idArray.length <= 0){ // 判断是否选中数据
			layer.alert('请选择要删除的数据！');
			return false;
		}
		
		layer.confirm('是否确定删除这批记录',{btn:['确定','取消']},function(){
			var param = {
					url:address+"leadbusi/deletebatch/"+idArray,
					type:"POST",
					async:false,
					success:function(data){
						layer.msg('删除成功', {
						    time: 1000, //1s后自动关闭
						  });
				    	initTable();
				    	removeCheckBox();
					},
					error:function(){
						layer.msg('删除失败', {
						    time: 1000, //1s后自动关闭
						  });
					}
			};
			$.ajax(param);
		},function(){});
		
	});
	
	/*=====================查看Dialog==============================*/
	var viewLeadDiaLog = new Dialog({
		width:'910px',
		height:'650px',
		title:'部门查看',
	}).before('show',function(id){
    	var url = address + "leadbusi/forward/view/"+id
    	this.set('content',url);
	});
	/*===================================================*/
	//查看函数
	viewLead = function(id){
		layer.open({
			   type: 2,
			   title: '部门查看',
			   maxmin: true,
			   shadeClose: false, //点击遮罩关闭层
			   area : ['710px' , '600px'],
			   content: address + "leadbusi/forward/view/"+id,
			   end:function(){
				   initTable();
			   }
			 });
		//viewLeadDiaLog.show(id);
		
	}
	
	/*=====================编辑Dialog==============================*/
	var editLeadDiaLog = new Dialog({
		width:'910px',
		height:'650px',
		title:'部门编辑',
	}).before('show',function(id){
    	var url = address+"leadbusi/forward/edit/"+id;
    	this.set('content',url);
	});
	/*===================================================*/
	
	//编辑函数
	editLead = function(id){
		layer.open({
			   type: 2,
			   title: '部门编辑',
			   maxmin: true,
			   shadeClose: false, //点击遮罩关闭层
			   area : ['710px' , '600px'],
			   content: address+"leadbusi/forward/edit/"+id,
			   end:function(){
				   initTable();
			   }
			 });
		//editLeadDiaLog.show(id);
	}
	
	//删除函数
	deleLead = function(id){
		layer.confirm('是否确定删除此条记录',{btn:['确定','取消']},function(){
			var param = {
					url:address+"leadbusi/deleByKey/"+id,
					type:"POST",
					async:false,
					success:function(data){
						layer.msg('删除成功', {
						    time: 1000, //1s后自动关闭
						  });
				    	initTable();
					},
					error:function(){
						layer.msg('删除失败', {
						    time: 1000, //1s后自动关闭
						  });
					}
			};
			$.ajax(param);
		},function(){});
		
	}
	
	//回调函数
	function callbackOpt(row){
		var v = '<a href="javascript:void(0)" class="edit" value="'+row.ID+'" onclick="viewLead(\'' + row.ID + '\' )"><span class="org-table-operate operate-edit"></span><span>查看</span></a>';
		var e = '<a href="javascript:void(0)" class="edit" value="'+row.ID+'" onclick="editLead(\'' + row.ID + '\' )"><span class="org-table-operate operate-edit"></span><span>编辑</span></a>';
		var d = '<a href="javascript:void(0)" class="dele" value="'+row.ID+'" onclick="deleLead(\'' + row.ID + '\' )"><span class="org-table-operate operate-delete"></span><span>删除</span></a>';
		var opt = v+e+d;
		return opt;
	}
	
	
	//分页初始化
	initTable = function(){
		var TableObj = {
				content:"query-result-table",
				dataFuc:"getGridColumns",
				pageList:10,
				pageNumber:1,
				callback:callbackOpt
		}
		getTableData(TableObj);
	}
	
	initTable();
	
	
	
	
});