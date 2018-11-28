<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
  <head>
    <title>人脸识别</title>
	<meta charset="UTF-8"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
	<meta http-equiv="X-UA-Compatible" content="ie=edge"> 
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
	<style type="text/css"> 
		html{
			width:100%;
			height:100%;
		} 
		body{
			background:#fff;
			font-size:18px;
			font-family:"Arial", "Tahoma", "微软雅黑", "雅黑";
			line-height:18px;
			padding:0px;
			margin:0px;
			text-align:center
		} 
		div{
			padding:18px
		} 
		img{
			border:0px;vertical-align:middle;
			padding:0;
			margin:0
		} 
		body{
		   background: url("${pageContext.request.contextPath}/images/a.jpg")repeat;
		}
		input, button{
			font-family:"Arial", "Tahoma", "微软雅黑", "雅黑";/* border:0;*/
			vertical-align:middle;
			margin:0px;
			line-height:18px;
			font-size:18px
		}  
		.btn{
			width:140px;
			height:36px;
			line-height:18px;
			font-size:18px;
			background:url("${pageContext.request.contextPath}/images/bg26.jpg") no-repeat left top;
			color:#FFF;
			padding-bottom:4px
		} 
		#login-box {
	
			margin:0 auto;border:1px solid #000;width:300px;height:100px
		
		}
	  </style>
  </head>
	 
  <body>
   <%--  <video id="video" style="margin-top:200px" width="320" height="320" autoplay></video>
    
	<div id="login-box" align="center" style="width: 30%;height: 20px;border: 0px ;margin-top:10px>
		<div>
			<form action="${pageContext.request.contextPath}/facelogin">
				<input align="center"type="button" class="btn"  
				onmouseover="this.style.backgroundPosition='left -36px'" 
				onmouseout="this.style.backgroundPosition='left top'" 
				onclick="location.href='${pageContext.request.contextPath}/facelogin'" value="人脸识别"/>
		  	
		  	</form>
	  	</div>
  	</div>
  <script type="text/javascript">
    navigator.getUserMedia = navigator.getUserMedia ||
    navigator.webkitGetUserMedia ||
    navigator.mozGetUserMedia;
    if (navigator.getUserMedia) {
        navigator.getUserMedia({ audio: true, video: { width: 320, height: 320 } },
                function(stream) {
                    var video = document.getElementById("video");
                    video.src = window.URL.createObjectURL(stream);
                    video.onloadedmetadata = function(e) {
                        console.log('nihao44eee4aaaaddda');
                        video.play();
                    };
                },
                function(err) {
                    console.log("The following error occurred: " + err.name);
                }
        );
    } else {
        console.log("getUserMedia not supported");
    }
  
   
    document.getElementById("picture").addEventListener("click", function () {
    	  debugger;
    	 var context = document.getElementById("canvas").getContext("2d");
        context.drawImage(video, 0, 0, 320, 320);
    });
    document.getElementById("sc").addEventListener("click", function () {
        var imgData=document.getElementById("canvas").toDataURL("image/png");
        var data=imgData.substr(22);
        debugger;
        console.log(data);
        $.post('../upload/sc',{'sj':data});
    });
</script> --%>
  
  </body>
</html>
