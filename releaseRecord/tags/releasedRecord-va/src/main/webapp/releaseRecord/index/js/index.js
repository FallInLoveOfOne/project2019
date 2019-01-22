define(function(require){
	var $=require("$");
	
	
	$("#ajaxBt").click(function(){
		var userObj={name:"来自ajax"};
		var param = {
				url:address+"home/addOne",
				type:"POST",
				data:userObj,
				async:false,
				success:function(result){
					alert("SY_FCF库添加一条DEMO_USER记录成功");
				},
				error:function(){
				}
		};
		$.ajax(param);
	});
    
   
});