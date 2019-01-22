<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <title>大屏</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <base href="<%=basePath%>">
</head>
<body>
	<input type="button" title="开启摄像头" value="开启摄像头" onclick="getMedia()" />
	<video id="video" width="500px" height="500px" autoplay="autoplay"></video>
	<canvas id="canvas" width="500px" height="500px"></canvas>
	<img id="img-show" alt="" src="">
	<button id="snap" onclick="takePhoto()">拍照</button>
</body>

<script>
	
	function convertImageToCanvas(image) {
		var canvas = document.createElement("canvas");
		canvas.width = image.width;
		canvas.height = image.height;
		canvas.getContext("2d").drawImage(image, 0, 0);
	
		return canvas;
	}
	
	//canvas转图片
	function convertCanvasToImage(canvas) {// base64图片
		var image = new Image();
		image.src = canvas.toDataURL("image/png");
		console.info(image.src);
		return image;
	}
	
	// 开启摄像头
	function getMedia() {
	    let constraints = {
	        video: {width: 500, height: 500},
	        audio: true
	    };
	    //获得video摄像头区域
	    let video = document.getElementById("video");
	    //这里介绍新的方法，返回一个 Promise对象
	    // 这个Promise对象返回成功后的回调函数带一个 MediaStream 对象作为其参数
	    // then()是Promise对象里的方法
	    // then()方法是异步执行，当then()前的方法执行完后再执行then()内部的程序
	    // 避免数据没有获取到
	    let promise = navigator.mediaDevices.getUserMedia(constraints);
	    promise.then(function (MediaStream) {
	        video.srcObject = MediaStream;
	        video.play();
	    });
	}
	
	// 拍照
	function takePhoto() {
		//获得Canvas对象
		let video = document.getElementById("video");
		let canvas = document.getElementById("canvas");
		let ctx = canvas.getContext('2d');
		ctx.drawImage(video, 0, 0, 500, 500);
		convertCanvasToImage(canvas);
	}
	
</script>
</html>