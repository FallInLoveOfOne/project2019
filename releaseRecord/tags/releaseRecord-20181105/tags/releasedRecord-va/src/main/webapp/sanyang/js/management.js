define(function(require){
    var $ = require("$");
    var h = $('body').height();
        // w = $('body').width();
    // $('.content').width(w-40);
    // $('.content').height(h-40);
    $('.content-bottom').height(h-210);
    if($('.content-bottom').height()<480){
        $('.layui-table-header table').width($('.layui-table-box').width()-15)
    }else {
        $('.layui-table-header table').width($('.layui-table-box').width())
    }
    $(window).resize(function(){
        var h = $('body').height();
            // w = $('body').width();
        // $('.content').width(w-40);
        // $('.content').height(h-40);
        $('.content-bottom').height(h-210);
        if($('.content-bottom').height()<480){
            $('.layui-table-header table').width($('.layui-table-box').width()-15)
        }else {
            $('.layui-table-header table').width($('.layui-table-box').width())
        }
    })
    // tab样式
    $('.tab-bar div').on('click', function(){
        $(this).addClass('ckbtn').siblings().removeClass('ckbtn')
    })
    $('.out-normal').on('click', function(){
        self.parent.document.getElementById("iframe").src = "evidence/toEvidenceManage";
    })
    $('.out-temp').on('click', function(){
        self.parent.document.getElementById("iframe").src = "evidence/toEvidenceTempMana";
    })
    // 调用layui表格
    function initTable(){
    layui.use('table', function(){
        var table = layui.table;
        table.render({
            elem: '#test',
            url:'evidence/evidencePageList',//,getListPage2
            height:'full-215', // 差值，充满，并且距离底部的距离
            skin:'line',
            /*data:[
                {id:'66556599545',name:'李晓明',sex:'男',section:'戒毒',time:'365',room:'501-2',inTime:'2018-03-23  14:34',outTime:'2018-03-23  14:34'},
                {id:'66556599545',name:'李晓明',sex:'男',section:'戒毒',time:'24',room:'501-2',inTime:'2018-03-23  14:34',outTime:'2018-03-23  14:34'},
            ],*/
            cols: [[
                {field:'',width:'1%',title:''},
                {field:'NUMBER', width:'10%', title: '人员编号'},
                {field:'IDENTITY_ID', width:'9%', title: '身份证'},
                {field:'NAME', width:'8%', title: '姓名',style:'color: #676767;'},
                {field:'SEX_VALUE', width:'8%', title: '性别'},
                {field:'OUT_TYPE', width:'12%', title: '出所类型'},
                //{field:'HOLD_END', width: '12%', title: '拘留到期日期',templet:function(d){return dateFormat(d.HOLD_END)}},// dateFormat
                {field:'DETOX_END', width:'12%', title: '戒毒到期日期',templet:function(d){return dateFormat(d.DETOX_END)}},
                {field:'BASE_COFIRM_STA', width:'10%', title: '是否审核通过',templet:function(d){return formatSureState(d.BASE_COFIRM_STA)}},// formatState
                {field:'PICTURE_STATE', width:'10%', title: '人脸对比',templet:function(d){return formatPicState(d.PICTURE_STATE)}},
                {field:'OUT_DOC_STATE', width:'10%', title: '出所单',templet:function(d){return formatListState(d.OUT_DOC_STATE)}},
                {field:'classify', width:'15%', title: '操作',templet:'#titleTpr'}
            ]],
            page: true,
            limit: 10,
            where:getQuery(),// userName,userNumber,startDate,endDate,excepVal
            request: {
                pageName: 'curr' //页码的参数名称，默认：page
                ,limitName: 'nums' //每页数据量的参数名，默认：limit
              }
        });
        //监听工具条
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            var personNumber = data["NUMBER"];
            var prisonId=data["DORM_CODE"]||'';
            // 查看的提示框
            if(obj.event === 'detail'){
            	window.open("evidence/toOutDetoxDetails?prisonId="+prisonId+"&number="+personNumber);
                                                   
            } else if(obj.event === 'del'){
                // 删除的提示框
                layer.confirm('真的删除行么', function(index){
                    obj.del();
                    layer.close(index);
                });
                // 编辑的提示框
            } else if(obj.event === 'edit'){

            }
        });
    });
    }
    layui.use(['form','laydate'],function(){
        var form = layui.form,
        laydate = layui.laydate;
        form.render();
        //常规用法
        startDateLay = laydate.render({
          elem: '#startDate',
          format: 'yyyy-MM-dd',
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
              removeShortcutOptions(value,$("#endDate").val());  //控件事件都为空时清除快捷选择
          }
        });
        endDateLay = laydate.render({
          elem: '#endDate',
          format: 'yyyy-MM-dd',
          done: function (value, dates) {
              if (value) {
            	  startDateLay.config.max = {
                      year: dates.year,
                      month: dates.month - 1, //关键
                      date: dates.date
                  };
              } else {
            	  startDateLay.config.max = {
                      year: 1900,
                      month: 0, //关键
                      date: 1
                  };
              }
              removeShortcutOptions(value,$("#startDate").val());  //控件事件都为空时清除快捷选择
          }
        });
    })
  //判断两个时间控件如果都为空则去除快捷选择
    var removeShortcutOptions = function(starDate,endDate){
        if(!(starDate||endDate)){
            $(".cktimebtn").removeClass('cktimebtn');
        }
    }
    // 今天 本周点击切换
    $('.time-btn').on('click', function(){
        $(this).addClass('cktimebtn').siblings('.time-btn').removeClass('cktimebtn')
    })
    
    
    // 日期格式化
    function dateFormat(date){
    	if(date){
    		var datemat = date.substring(0,4)+"-"+date.substring(4,6)+"-"+date.substring(6,8);
    		return datemat;
    	}
    	return "";
    }
    
    // 翻译确认状态
    function formatSureState(data){
    	if("false"==data){
    		return '<i class="iconfont-sy" style="color:#e85953">&#xe75b;</i>';
    	}
    	if("true"==data){
    		return "<i class='iconfont-sy' style='color:#43b76c'>&#xe75a;</i>"
    	}
    	if(null==data||""==data){
    		return '';
    	}
    	return '';
    }
    
    // 翻译人脸比对
    function formatPicState(data){
    	if("false"==data){
    		return '<i class="iconfont-sy" style="color:#e85953">&#xe75b;</i>';
    	}
    	if("true"==data){
    		return '<i class="iconfont-sy" style="color:#43b76c">&#xe75a;</i>';
    	}
    	if(null==data||""==data){
    		return '';
    	}
    	return '';
    }
    
    // 翻译附件上传状态
    function formatListState(data){
    	if("false"==data){
    		return '<i class="iconfont-sy" style="color:#e85953">&#xe75b;</i>';
    	}
    	if("true"==data){
    		return '<i class="iconfont-sy" style="color:#43b76c">&#xe75a;</i>';
    	}
    	if(null==data||""==data){
    		return '';
    	}
    	return '';
    }
    
    
    // 获取查询条件
    function getQuery(){
    	var queryObj = {};
    	queryObj.identity = $.trim($("#sfz").val());
    	queryObj.userName = $.trim($("#userName").val());
    	queryObj.userNumber = $.trim($("#userNumber").val());
    	queryObj.startDate = $.trim($("#startDate").val())||'';
    	queryObj.endDate = $.trim($("#endDate").val())||'';
    	queryObj.outType="normal";//$("input[name='outType']:checked").val();// 异常类型，获取radio的选中值
    	return queryObj;
    }
    
    // 初始化函数
    function initData(){
    	// 同步数据
    	// 初始化查询列表
    	initTable();
    	
    }
    
    initData();
    
    // 同步点击事件
    $(".temp-btn").click(function(){
    	layer.msg('同步成功');
    });
    
    // 查询点击事件
    $(".check-btn").click(function(){
    	initTable();
    });
    //点击其他区域关闭td详情
    $("body").on("click",function (e) {
        var target = $(e.target);
        if(!(target.is(".layui-table-tips-main")||target.is(".layui-table-grid-down")||target.is(".layui-icon-down"))){
            $(".layui-icon-close").click();//关闭表格详情弹出框
        }
    });
    
    function getOutTypeNum(){
    	layui.use('layer', function(){ 
	    	var index = layer.load(2, {// 0,1,2
				  shade: [0.5,'#fff'] //0.1透明度的白色背景
				});
	    });
    	var dataNum = 0;
    	var param = {// 判断是否有记录、下一步、当前日期
				url:address+"evidence/findCZOutManaNum",
				type:"POST",
				//data:{endData:'',days:''},
				//beforeSend:function(){},
				//async:false,
				success:function(result){
					layui.use('layer', function(){ 
						layer.closeAll('loading');//关闭弹出层
						setOutNum(result);
					});
					//layer.msg('同步成功');
				},
				error:function(){
				}
		};
		$.ajax(param);
    }
    
    function setOutNum(result){
    	$(".tab-normal").text("正常出所("+result["normal_num"]+")");
    	$(".tab-temp").text("临时出所("+result["temp_num"]+")");
    } 
    
    getOutTypeNum();
})