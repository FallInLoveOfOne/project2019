define(function(require){
    var $ = require("$")
        h = $('body').height(),
        w = $('body').width();
    $('.report-content').height(h-60);
    $('.report-box').width(w-40);
    $('.report-box').height(h-100);
    screenLayOut()
    $(window).resize(function(){
        var $ = require("$")
            h = $('body').height(),
            w = $('body').width();
        $('.report-content').height(h-60);
        $('.report-box').width(w-40);
        $('.report-box').height(h-100);
        screenLayOut()
    })
    function screenLayOut () {
        if(screen.width == 1920 && screen.height == 900){
            $('.report-text').addClass('pt35')
            $('.report-title-name').addClass('h30')
            $('.person-detail').addClass('h35')
            $('.id-num').addClass('h35')
            $('.detail-text').addClass('h35')
            $('.person-info').addClass('h257')
            $('.person-info').addClass('mt30')
            $('.person-img').addClass('mt40')
            $('.person-detail-info').addClass('mt40')
        }else {
            $('.report-text').removeClass('pt35')
            $('.report-title-name').removeClass('h30')
            $('.person-detail').removeClass('h35')
            $('.id-num').removeClass('h35')
            $('.detail-text').removeClass('h35')
            $('.person-info').removeClass('h257')
            $('.person-info').removeClass('mt30')
            $('.person-img').removeClass('mt40')
            $('.person-detail-info').removeClass('mt40')
        }
    }
    
    
    $(".report-confirm-btn").click(function(){
    	layui.use('layer', function(){ 
        	var index = layer.load(2, {
    			  shade: [0.5,'#fff'], //0.1透明度的白色背景
    			  //area:'auto',//['500px', '500px']
    			  offset:['50%','50%']
    			});
        });
    	var conJson={personNumber:number_,personName:name_};
		var param = {// 判断是否有记录、下一步、当前日期
				url:address+"release/sureOutList",
				type:"POST",
				data:conJson,
				async:false,
				success:function(result){
					layui.use('layer', function(){ 
						layer.closeAll('loading');//关闭弹出层
						//window.location.href=address+"release/toFaceCheck?prisonId="+prisonId_+"&number="+number_;
						//window.open(address+"release/toFaceCheck?prisonId="+prisonId_+"&number="+number_);
					});
					//layer.msg('同步成功');
					//var flag = "CZGL";// 存在证管理
			    	//var ID=number_;
			    	//var json="{\"flag\":\""+flag+"\",\"ID\":\""+ID+"\"}";
			    	//window.location.href=address+'home/search/'+json;
				},
				error:function(){
				}
		};
		$.ajax(param);
    });
    
    layui.use('layer', function(){ //独立版的layer无需执行这一句
        var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句
        
        //触发事件
        var active = {
          setTop: function(){
            var that = this; 
            //多窗口模式，层叠置顶
            layer.open({
              type: 2 //此处以iframe举例
              ,title: '当你选择该窗体时，即会在最顶端'
              ,area: ['390px', '260px']
              ,shade: 0
              ,maxmin: true
              ,offset: [ //为了演示，随机坐标
                Math.random()*($(window).height()-300)
                ,Math.random()*($(window).width()-390)
              ] 
              ,content: '//layer.layui.com/test/settop.html'
              ,btn: ['继续弹出', '全部关闭'] //只是为了演示
              ,yes: function(){
                $(that).click(); 
              }
              ,btn2: function(){
                layer.closeAll();
              }
              
              ,zIndex: layer.zIndex //重点1
              ,success: function(layero){
                layer.setTop(layero); //重点2
              }
            });
          },
          offset: function(othis){
            var type = othis.data('type'),
            text = othis.text();
            layer.open({
              type: 1
              ,offset: type //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
              ,id: 'layerDemo'+type //防止重复弹出
              ,content: '<div style="padding: 20px 100px;font-size: 20px;">'+ '请到人脸对比' +'</div>'
              ,btn: ['关闭']
              ,btnAlign: 'r'
              //   ,btn: '关闭全部'
              ,shade: .3 //不显示遮罩
              ,yes: function(){
                layer.closeAll();
                window.opener=null;
				window.open('','_self');
				window.close();
              },
              cancel: function(){
                layer.closeAll();
              	window.opener=null;
				window.open('','_self');
				window.close();
              }
            });
          }
        };
        
        $('.report-confirm-btn').on('click', function(){
          var othis = $(this), method = othis.data('method');
          active[method] ? active[method].call(this, othis) : '';
        });
        
      });
    
    function autoNotice(){
        layui.use('layer', function(){ //独立版的layer无需执行这一句
            var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句
            
            //触发事件
            var active = {
              offset: function(othis){
                var type = othis.data('type'),
                    text = othis.text();
                layer.open({
                    type: 1,
                    offset: type, //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset 

                    id: 'layerDemo'+type, //防止重复弹出
                    content: '<div style="padding: 20px 120px;font-size: 20px;">'+ '请到人脸对比' +'</div>',
                    btn: ['关闭'],
                    btnAlign: 'r',
//                    area: ['300px', '160px'],
                    shade: .3 ,//不显示遮罩
                    closeBtn: 1,//0有关闭按钮
                    cancel: function(){
                        layer.closeAll();
                    	window.opener=null;
    					window.open('','_self');
    					window.close();
                    },
                    yes: function(){
                        layer.closeAll();
                        window.opener=null;
    					window.open('','_self');
    					window.close();
                      }
                });
              }
            };
            
            var othis = $('.report-confirm-btn'), method = othis.data('method');
            active[method] ? active[method].call(this, othis) : '';
    
          });
      }
    
    function isOutDocConfirm(docSta){// 出所单是否确认
    	if(docSta){
    		if("true"==docSta){
    			autoNotice();
    		}
    	}
    }
    
    isOutDocConfirm(outDocSta_);
    
    function showPhoto(photo){
    	if(photo){
    		$("#personPhoto").attr("src",address+"Photomsg/"+photo);
    	}
    }
    
    showPhoto(photo_);
   
    //人员出生日期出生日期初始化
    function initPerBirth(perBirth){//19700814
    	if(perBirth){
    		var datemat = perBirth.substring(0,4)+"-"+perBirth.substring(4,6)+"-"+perBirth.substring(6,8);
    		$("#perBirth").text(datemat);
    	}else{
    		$("#perBirth").text(perBirth);
    	}
    }
    
    initPerBirth(perBirth);
})