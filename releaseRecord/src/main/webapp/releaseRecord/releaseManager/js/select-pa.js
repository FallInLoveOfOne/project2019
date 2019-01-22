define(function(require) {
	var $ = require("$");

	//定义数组，在服务端返回的数据也以该格式返回：Array[{Object},{...}]
	var tag_data = [
	    {id:1 ,name:'Chicago Bulls',desc:'芝加哥公牛'},
	    {id:2 ,name:'Cleveland Cavaliers',desc:'克里夫兰骑士'},
	    {id:3 ,name:'Detroit Pistons',desc:'底特律活塞'},
	    {id:4 ,name:'SSSS Pistons',desc:'点对点'},
	    {id:5 ,name:'FFF Pistons',desc:'大幅度'},
	    {id:6 ,name:'Indiana Pacers',desc:'印第安纳步行者'}
	];
	
	function getData(){
		var arr = [];
		var param = {
			url : address + "release/getAllJDPerson",//"release/sbOutDeal",识别出所操作
			type : "POST",
			//data : {json:infoStr},
			async : false,
			success : function(result) {
				arr = result;
				console.info(arr);
			},
			error : function() {
			}
		};
		$.ajax(param);
		return arr;
	}
	
	getData();
	
	//初始化插件
	/*$('#selectPage').selectPage({
	    showField : 'NAME',
	    keyField : 'NUMBER',
	    data : getData(),
	    eOpen : function(self){
	    	$(this).hide();
	    },
	    eSelect : function(data){
	    	console.info(data);
	    }
	});*/
	
	/*$("#selectPage_text").keyup(function(){
		  console.info($("#selectPage").val());
	});*/
	
	function checkType(val){
		if(val){
			if(/^[\u4e00-\u9fa5]+$/.test(val)){// 汉字
				return "NAME";
			}
			if(/^[0-9]*$/.test(val)){// 数字
				if(val.indexOf("330301131")!=-1){
					return "NUMBER";
				}else{
					return "IDENTITY_ID";
				}
			}
			
			if(/^[A-Za-z]+$/.test(val)){
				return "PY";
			}
		}
		return "";
	}
	
	
	$('#selectPage').selectPage({
	    showField: 'SHOW_SEL',
	    keyField: 'NAME',
	    data: address+'release/getAllJDPerson',
		pageSize: 10,
	    //向服务端提交的参数中，增加已选中的
	    //设置返回-1，意为通知服务端返回空列表，初始化时使用
	    params: function(){
			//$('#selectPage').selectPageData([]);
			console.info(this);
			console.info(this.prop.prev_value);
	        var con = $.trim(this.prop.prev_value)||'';//$('#selectPage').val();
			var type = checkType(con);
			
	        return {'queryCon': con?con:'-1','type': type};
	    },
		//inputDelay: 1,
		eAjaxSuccess : function(d){
			//$('#selectPage').selectPageData([]);
	        var result;
	        console.info(d);
	        if(d) result = d;//.values.gridResult;
	        else result = undefined;
	        return result;
	    }
	});
});