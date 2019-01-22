define(function(require){
    var $ = require("$");
    var h = $('body').height(),
        w = $('body').width();
    // $('.content').width(w-40);
    // $('.content').height(h-40);
    // $('.check-top').width(w-80-40-$('.ipt').width())
    $('.content-bottom').height(h-210);
    $(window).resize(function(){
        var h = $('body').height(),
            w = $('body').width();
        // $('.content').width(w-40);
        // $('.content').height(h-40);
        // $('.check-top').width(w-80-40-$('ipt').width())
        $('.content-bottom').height(h-210);
    })
    // 调用layui表格
    function initTable(){
    layui.use('table', function(){
        var table = layui.table;
        table.render({
            elem: '#test',
            url:'release/normalPage',//,getListPage2
            height:'full-215', // 差值，充满，并且距离底部的距离
            skin:'line',
            /*data:[
                {first:'<span style="background-color:#f37979;">天</span>', name:'李晓明',sex:'男',section:'501-2',inTime:'2018-03-23  14:34',id:'66556599545',outTime:'2018-03-23  14:34',wired: '是', reason: '审核未通过'},
                {first:'<span style="background-color:#f4c085;">周</span>', name:'李晓明',sex:'女',section:'501-2',inTime:'2018-03-23  14:34',id:'66556599545',outTime:'2018-03-23  14:34',wired: '是', reason: '审核未通过'}
            ],*/
            cols: [[
                {field:'first',width:'1%',title:'',templet: function(d){return getDaysFormat(d.DETOX_END,'')}},
                {field:'NUMBER', width:'11%', title: '人员编号'},
                {field:'IDENTITY_ID', width:'11%', title: '身份证'},
                {field:'NAME', width:'8%',minWidth:73, title: '姓名',style:'color: #676767;'},
                {field:'SEX_VALUE', width:'6%', title: '性别'},
                {field:'DORM_CODE', width:'7%', title: '监室号'},
                {field:'HOLD_END', width: '13%', title: '拘留到期日期',templet:function(d){return dateFormat(d.HOLD_END)}},//时间格式化
                {field:'DETOX_END', width:'13%', title: '戒毒到期日期',templet:function(d){return dateFormat(d.DETOX_END)}},
                //{field:'NAME', width:'9%', title: '是否异常',templet: function(d){return (d.EXCEPTION==null?'否':'是')}},// 翻译
                {field:'EXCEPTION', width:'15%', title: '异常原因'},
                {field:'classify', width:'13%', title: '操作',templet:'#titleTpr'}
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
            var userName=data["NAME"];
            var holdEnd=data["OUT_DATE"];//OUT_DATE
            var nowDate="";// 当前日期
            var isNewOpt="";// 用于判断是否有操作记录
            var nextStep=""// 若有记录，下一步
            // 查看的提示框
            if(obj.event === 'detail'){// 查看按钮
            	//window.open(address+'release/outPersonDetails?prisonId='+prisonId+'&number='+personNumber);
            	window.open("evidence/toOutDetoxDetails?prisonId="+prisonId+"&number="+personNumber);
            } else if(obj.event === 'del'){
                // 删除的提示框
                layer.confirm('真的删除行么', function(index){
                    obj.del();
                    layer.close(index);
                });
                // 编辑的提示框
            } else if(obj.event === 'edit'){// 出所按钮
            	var userObj={number:personNumber,name:userName,outType:'normal'};
        		var param = {// 判断是否有记录、下一步、当前日期
        				url:address+"release/checkOutButon",
        				type:"POST",
        				data:userObj,
        				async:false,
        				success:function(result){
        					var r = result;
        					isNewOpt=result["optVal"];
        					nextStep=result["nextStep"];
        					nowDate=result["nowDate"];
        				},
        				error:function(){
        				}
        		};
        		$.ajax(param);
        		
        		if(("old"==isNewOpt)&&("processFail"!=nextStep)){// 如果有操作记录，直接跳到原来位置
        			if("processFail"==nextStep){
        			}
        			if("faceCheck"==nextStep){// 跳转人脸比对
        				//window.open(address+"release/toFaceCheck?prisonId="+prisonId+"&number="+personNumber);
        				window.open("release/toOutListUpload?prisonId="+prisonId+"&number="+personNumber);// 跳转到出所单确认
        			}
        			if("listUp"==nextStep){// 跳转出所单上传
        				window.open("release/toOutListUpload?prisonId="+prisonId+"&number="+personNumber);
        			}
        			if("outOk"==nextStep){
        				
        			}
        			
        		}else{// 没有操作记录的话
        			
        			if(holdEnd){
        				if(parseInt(holdEnd)<=parseInt(nowDate)){
            				var requestUrl = "release/achieveTimeSureOut";
            				var jsonObj = {number:personNumber,name:userName,outType:'normal'};
            				outOpt(requestUrl,prisonId,jsonObj/*,personNumber,userName,"normal"*/);// 正常出所操作及跳转
            			}
            			
            			
            			// 临时出所
            			if(parseInt(holdEnd)>parseInt(nowDate)){
            				layer.confirm('尚未到达规定出所时间，是否进行临时出所？', {btn: ['是，临时出所', '否，正常出所']},
            			        function(){
    			        			layer.closeAll();
    			        			var requestUrl = "release/temOutY";
    		        				var jsonObj = {number:personNumber,name:userName,outType:'temp'};
    		        				outOpt(requestUrl,prisonId,jsonObj/*,personNumber,userName,"normal"*/);// 正常出所操作及跳转
    			        		},
    			        		function(){
    			        			layer.closeAll();
    			        		}
            			      );
            			}
        			}else{
        				layer.confirm('请选择要进行的出所操作？', {btn: ['临时出所', '正常出所']},
        						function(){
        					layer.closeAll();
        					var requestUrl = "release/temOutY";
        					var jsonObj = {number:personNumber,name:userName,outType:'temp'};
        					outOpt(requestUrl,prisonId,jsonObj/*,personNumber,userName,"normal"*/);// 正常出所操作及跳转
        				},
        				function(){
        					layer.closeAll();
        				}
        				);
        				
        			}
        			
        			
        			
        		}

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
    // tab点击切换
    // 路径
    // tab样式
    $('.tab-bar div').on('click', function(){
        $(this).addClass('ckbtn').siblings().removeClass('ckbtn')
    })
    // 今天 本周点击切换
    $('.time-btn').on('click', function(){
        $(this).addClass('cktimebtn').siblings('.time-btn').removeClass('cktimebtn')
    })
    // 在iframe中点击tab切换iframe的src
    $('.out-normal').on('click', function(){
        self.parent.document.getElementById("iframe").src = "release/toReleaseManage";
    })
    $('.out-temp').on('click', function(){
        self.parent.document.getElementById("iframe").src = "release/toTempManage";
    })
    
    // 日期格式化
    function dateFormat(date){
    	if(date){
    		var datemat = date.substring(0,4)+"-"+date.substring(4,6)+"-"+date.substring(6,8);
    		return datemat;
    	}
    	return "";
    }
    
    // 计算日期间隔天数
    function getDaysFormat(strDateStart,strDateEnd){
       if(""==strDateStart||null==strDateStart){
    	   return "";
       }	
       var date = strDateStart.substring(0,4)+"-"+strDateStart.substring(4,6)+"-"+strDateStart.substring(6,8);
	   /*var strSeparator = "-"; //日期分隔符
	   var oDate1;
	   var oDate2;
	   var iDays;
	   oDate1= strDateStart.split(strSeparator);
	   oDate2= strDateEnd.split(strSeparator);
	   var strDateS = new Date(oDate1[0], oDate1[1]-1, oDate1[2]);
	   var strDateE = new Date(oDate2[0], oDate2[1]-1, oDate2[2]);
	   iDays = parseInt(Math.abs(strDateS - strDateE ) / 1000 / 60 / 60 /24)//把相差的毫秒数转换为天数 */
       var s1 = date;//'2012-05-12';
       s1 = new Date(s1.replace(/-/g, "/"));
       s2 = new Date();
       var days = s2.getTime() - s1.getTime();
       var time = parseInt(days / (1000 * 60 * 60 * 24));
       
       if(time==0){// 天
    	   return '<span style="background-color:#f37979;">天</span>';
       }
       /*if(time>=7&&time<30){// 周
    	   return '<span style="background-color:#7dcfb6;">月</span>';
       }
       if(time>30&&time<120){// 月
    	   return '<span style="background-color:#7dcfb6;">月</span>';
       }
       if(time>=120){// 季
    	   return '<span style="background-color:#41bff9;">季</span>';
       }*/
	   return '<span style="background-color:#f37979;display:none;">天</span>';
	}
    
    // 获取查询条件
    function getQuery(){
    	var queryObj = {};
    	queryObj.identity = $.trim($("#sfz").val());
    	queryObj.userName = $.trim($("#userName").val());
    	queryObj.userNumber = $.trim($("#userNumber").val());
    	queryObj.startDate = $.trim($("#startDate").val())||'';
    	queryObj.endDate = $.trim($("#endDate").val())||'';
    	queryObj.excepVal=$("input[name='exceptionType']:checked").val();// 异常类型，获取radio的选中值
    	queryObj.waitOrFlag='NO_OUT';
    	return queryObj;
    }
    
    function initFlag(jsonQuery){
    	if(jsonQuery.indexOf("TCS")>0){
    		$(".today-btn").click();
    		$("input[id='startDate']").val(getToday());
    		$("input[id='endDate']").val(getToday());
    		}
    	if(jsonQuery.indexOf("YQ")>0){$("input[id='endDate']").val(getToday())}
    	if(jsonQuery.indexOf("SH")>0){$("#sh").attr("checked",true)}
    	if(jsonQuery.indexOf("TX")>0){$("#face").attr("checked",true)}
    	if(jsonQuery.indexOf("CSD")>0){$("#doc").attr("checked",true)}
    			
    		
    }
    // 获取今天的时间格式为xxxx-xx-xx
    function getToday() {
        var date = new Date();
        var seperator1 = "-";
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        var strDate = date.getDate();
        if (month >= 1 && month <= 9) {
            month = "0" + month;
        }
        if (strDate >= 0 && strDate <= 9) {
            strDate = "0" + strDate;
        }
        var currentdate = year + seperator1 + month + seperator1 + strDate;
        return currentdate;
    }
    // 初始化函数
    function initData(){
    	// 同步数据
    	// 初始化查询列表
    	initTable();
    	//初始化条件
    	initFlag(jsonQuery);
    }
    
    initData();
    
    
    // 同步点击事件
    $(".temp-btn").click(function(){
    	layui.use('layer', function(){ 
	    	var index = layer.load(2, {// 0,1,2
				  shade: [0.5,'#fff'] //0.1透明度的白色背景
				});
	    });
    	var param = {// 判断是否有记录、下一步、当前日期
				url:address+"release/synchroPersonData",
				type:"POST",
				data:{endData:'',days:''},
				//beforeSend:function(){},
				//async:false,
				success:function(result){
					layui.use('layer', function(){ 
						layer.closeAll('loading');//关闭弹出层
						initTable();
					});
					layer.msg('同步成功');
				},
				error:function(){
				}
		};
		$.ajax(param);
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
    
    function inputNnameOrNumber(val){
    	//var pattern = /^[\u4E00-\u9FA5]{1,5}$/;
    	var pattern = /^[\u4e00-\u9fa5]+$/;
    	if(val){
    		val = $.trim(val);
    		if(pattern.test(val)){
    			$("#userName").val(val);
    		}else{
    			$("#userNumber").val(val);
    		}
    	}
    }
    
    //inputNnameOrNumber(id_);
    
    // 获取出所条数
    function getDateNumber(){
    	layui.use('layer', function(){ 
	    	var index = layer.load(2, {// 0,1,2
				  shade: [0.5,'#fff'] //0.1透明度的白色背景
				});
	    });
    	var dataNum = 0;
    	var param = {// 判断是否有记录、下一步、当前日期
				url:address+"release/findOutManaTypeNum",
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
    	$(".tab-normal").text("待出所("+result["wait_num"]+")");
    	$(".tab-temp").text("未出所("+result["noout_num"]+")");
    }
    
    getDateNumber();
    
    // 出所操作--- 
    function outOpt(reqUrl,prisonId,jsonCon/*personNumber,userName,type*/){
    	var param = {
				url:address+reqUrl,//"release/achieveTimeSureOut",
				type:"POST",
				data:jsonCon,//{number:personNumber,name:userName,outType:'normal'},
				async:false,
				success:function(result){
					// 跳转到出所单确认
					window.open("release/toOutListUpload?prisonId="+prisonId+"&number="+jsonCon["number"]);
				},
				error:function(){
				}
		};
		$.ajax(param);
    }
    
})