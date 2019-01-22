define(function(require){
    var $ = require("$"),
        h = $('body').height(),
        w = $('body').width();
    $('.basic-detail').width(w-136-250)
    $('.detention-item').height($('.detention-content').height()-40)
    $(window).resize(function(){
        var h = $('body').height(),
            w = $('body').width();
        $('.basic-detail').width(w-136-250)
        $('.detention-item').height($('.detention-content').height()-40)
    })
    // 调用layui的弹窗
    layui.use('layer', function(){ //独立版的layer无需执行这一句
        var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句
        
        //触发事件
        var active = {
            // confirmTrans: function(){
            //     //配置一个透明的询问框
            //     layer.msg('大部分参数都是可以公用的<br>合理搭配，展示不一样的风格', {
            //         time: 20000, //20s后自动关闭
            //         shade: 0.8,
            //         height:'200px',
            //         width:'420px',
            //         btn: ['明白了', '知道了', '哦']
            //     });
            // },
            notice: function(){
                //示范一个公告层
                layer.open({
                    type: 1,
                    title: false, //不显示标题栏
                    closeBtn: false,
                    area: ['420px', '200px'],
                    shade: 0.8,
                    id: 'LAY_layuipro', //设定一个id，防止重复弹出
                    btn: ['取消', '确定'],
                    btnAlign: 'r',
                    moveType: 1, //拖拽模式，0或者1
                    content: '<div style="background-color: #fff; color: #333; font-size: 16px;"><i class="iconfont-sy" style="display:inline-block; vertical-align:middle; width:30px;height:30px;text-align: center;line-height: 30px;font-size:30px; border-radius:50%; margin-right:15px;">&#xe735;</i><span>未达到出所时间，不符合出所条件!</span></div>',
                    success: function(layero){
    
                    },
                });
            },
            offset: function(othis){
                var type = othis.data('type'),
                    text = '<i class="iconfont-sy" style="display:inline-block; vertical-align:middle; width:30px;height:30px;text-align: center;line-height: 30px;font-size:30px; border-radius:50%; margin-right:15px;">&#xe735;</i><span>未达到出所时间，不符合出所条件!</span>'
                layer.open({
                    type: 1,
                    offset: type, //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
                    area: ['420px', '200px'],
                    shade: 0.8,                    
                    id: 'layerDemo'+type, //防止重复弹出
                    content: '<div style="height: 102px; line-height: 102px;background-color: #fff; color: #333; font-size: 16px;">'+ text +'</div>',
                    btn: ['取消', '确定'],
                    btnAlign: 'r', //按钮居中
                    yes: function(){
                        // layer.closeAll();
                    }
                });
            }
        };
        
        /*$('.btn-box .layui-btn').on('click', function(){
          var othis = $(this), method = othis.data('method');
          active[method] ? active[method].call(this, othis) : '';
        });*/
        
    });  
    
    // 出所点击事件
    $(".layui-btn-normal").click(function(){
    	var personNumber = personNumber_;//data["NUMBER"];
        var prisonId=prisonId_;//data["DORM_CODE"];
        var userName=userName_;//data["NAME"];
        var holdEnd=outDate_;//data["HOLD_END"];
        var nowDate="";// 当前日期
        var isNewOpt="";// 用于判断是否有操作记录
        var nextStep=""// 若有记录，下一步
        	
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
				window.open("release/toOutListUpload?prisonId="+prisonId+"&number="+personNumber);// 跳转到出所单确认页面
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
				layer.confirm('是否进行临时出所？', {btn: ['是，临时出所', '否，正常出所']},
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

    });
    
    // 点击关闭，关闭当亲页面
    $(".layui-btn-primary").click(function(){
    	window.opener=null;
		window.open('','_self');
		window.close();
    });
    
    function formatDate(){
    	$(".formatdate").each(function(){
    		var date = $(this).text()||'';
    		var formatdate = date.substring(0,4)+"-"+date.substring(4,6)+"-"+date.substring(6,8);
    		if(''!=date){
    			$(this).text(formatdate);
    		}
    	});
    }
    
    formatDate();
    
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