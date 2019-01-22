define(function(require) {
	var $ = require("$");
	
	function sayMessage(msg){
		var msg = new SpeechSynthesisUtterance(msg);
	    window.speechSynthesis.speak(msg);
	}
	
	$("#BT").click(function(){
		sayMessage("戒毒人员，某某，审核流程未通过，人脸对比失败");
		//playVid();
	});

});