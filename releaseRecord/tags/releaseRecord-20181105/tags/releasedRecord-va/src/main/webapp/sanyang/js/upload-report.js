define(function(require){
    var $ = require("$");
        h = $('body').height();
        // w = $('body').width();
    $('.content-box').height(h-70)
    // $('.content-box').width(w-40)
    // $('.pro-pic').width((w-144*3-160*2-40)/4)
    $('.img-box').height(h-70-100-70)
    $(window).resize(function(){
        var h = $('body').height();
    //         w = $('body').width();
        $('.content-box').height(h-70)
        // $('.content-box').width(w-40)
        // $('.pro-pic').width((w-144*3-160*2-40)/4)
        $('.img-box').height(h-70-100-70)
    }) 

    layui.use('element', function(){
        var $ = layui.jquery,
            element = layui.element;
    })
    
    $(function() {
        $("#fileuploader").uploadFile({
            url:"release/upload/mulitUpload", 
            deleteStr:'删除',//文件上传url
            abortStr:'上传中',
            fileName:"filename",               //提交到服务器的文件名
            maxFileCount: 10,                //上传文件个数（多个时修改此处
//            returnType: 'json',              //服务返回数据
            allowedTypes: 'doc,docx,pdf,jpg,png',  //允许上传的文件式
            showDone: false,                     //是否显示"Done"(完成)按钮
            showDelete: true,                  //是否显示"Delete"(删除)按钮
            onLoad: function(obj) {
                //页面加载时，onLoad回调。如果有需要在页面初始化时显示（比如：文件修改时）的文件需要在此方法中处理
                // obj.createProgress('/tmpImage.jpg');      //createProgress方法可以创建一个已上传的文件
            },
            formData: {"upType":"cs","personNumber":number_,"personName":name_},
            deleteCallback: function(data,pd) {
                //文件删除时的回调方法。
                //如：以下ajax方法为调用服务器端删除方法删除服务器端的文件
            	var acc_id = $(this).attr("id");
                $.ajax({
                    cache: false,
                    url: "release/deleteAccById",
//                    type: "DELETE",
                    dataType: "json",
                    data: {accId:acc_id,number:number_},
                    success: function(data) {
                        if(data.code===0){
                            pd.statusbar.hide();        //删除成功后隐藏进度条等
                            $('#image').val('');
                            alert("删除成功");
                        }else{
                        console.log(data.message);  //打印服务器返回的错误信息
                        }
                    }
                }); 
            },
            onSuccess: function(files,data,xhr,pd) {
                //上传成功后的回调方法。本例中是将返回的文件名保到一个hidden类开的input中，以便后期数据处理
            	pd.del.attr("id",data);// 设置附件的返回id，用于删除操作
//            	alert("上传成功");
            	$(".csSucess").addClass("bar-now");
            	$(".haveupload").show();
                /*if(data&&data.code===0){
                    $('#image').val(data.url);
                }*/
//            	$(".ajax-file-upload-container").children("div.ajax-file-upload-statusbar:last-child").find(".cs_report").attr("id",data);
            }
            
        });
    })

    function IEVersion() {
        var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串  
        var isIE = userAgent.indexOf("compatible") > -1 && userAgent.indexOf("MSIE") > -1; //判断是否IE<11浏览器
        if(isIE) {
            var reIE = new RegExp("MSIE (\\d+\\.\\d+);");
            reIE.test(userAgent);
            var fIEVersion = parseFloat(RegExp["$1"]);
            if(fIEVersion < 10) {
                $('.uploader').css({'border':'1px dashed #dddddd','text-align':'center','height':'50px','line-height':'50px'});
                $('.ajax-file-upload').css({'display':'inline-block','font-weight':'bold'})
                                        .before('<span class="upload-tip" style="color: #999;display:inline-block;vertical-align:top">请</span>')
                                        .after('<span class="upload-tip" style="color: #999;display:inline-block;vertical-align:top">文件夹选择文件</span>')
            
                // $('.ajax-file-upload>input').width('100%').height('100%')
            } 
        }  
    }

    $(function() {
        IEVersion()
    })
    
    
    // 跳过点击事件 
    $("#tiaoguo").click(function(){
    	var conJson={personNumber:number_,name:name_};
		var param = {// 判断是否有记录、下一步、当前日期
				url:address+"release/noUploadOutList",
				type:"POST",
				data:conJson,
				async:false,
				success:function(result){
//					alert("出所成功,请前往存正证页面");
					$(".csSucess").addClass("bar-now");
					$(".noupload").show();
//					window.location.href='release/toOutListUpload?prisonId='+prisonId_+"&number=number_";
				},
				error:function(){
				}
		};
		$.ajax(param);
    });
    
    // 确定
    $('.right-close i').on('click', function(){
        $('.mask-box').hide()
    })
    
    // 确定
    $('.sureBT').on('click', function(){
    	$('.mask-box').hide();
    	var flag = "CZGL";// 存在证管理
    	var ID=number_;
    	var json="{\"flag\":\""+flag+"\",\"ID\":\""+ID+"\"}";
    	window.location.href=address+'home/search/'+json;
    })
    
    // 取消
    $('.cancelBT').on('click', function(){
    	$('.mask-box').hide()
    })
    
    

})