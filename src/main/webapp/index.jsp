<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">   
<html xmlns="http://www.w3.org/1999/xhtml">   
    <head>   
     <title></title>   
     <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />   
       <script type="text/javascript" src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
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
			#media {
				width: 280px;
				height: 250px;
				margin: 10px auto 0;
				border-radius: 30px;
				overflow: hidden;
				opacity: 0.7px;
			}
			#login-box {
		
				margin:0 auto;border:1px solid #000;width:300px;height:100px
			
			}
		  </style>
    </head>   
   
    <body>   
<div id="login-box" align="center" style="width: 30%;height: 20px;border: 0px ;margin-top:10px>
	<div id="media">
		    <video id="video" width="320" height="320" autoplay></video>
		    <button id="picture"  class="btn" style="display:block" >拍照</button>
		    <canvas style="display:block" id="canvas" width="320" height="320"></canvas>
		    <button  id="sc"  class="btn" style="display:block" >识别</button>
	</div>
</div>
<script>
    navigator.getUserMedia = navigator.getUserMedia ||
    navigator.webkitGetUserMedia ||
    navigator.mozGetUserMedia;
    if (navigator.getUserMedia) {
        navigator.getUserMedia({ audio: true, video: { width: 320, height: 320 } },
                function(stream) {
                    var video = document.getElementById("video");
                    video.src = window.URL.createObjectURL(stream);
                    video.onloadedmetadata = function(e) {
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
    	 
    	 var context = document.getElementById("canvas").getContext("2d");
        context.drawImage(video, 0, 0, 320, 320);
    });
    document.getElementById("sc").addEventListener("click", function () {
        var imgData=document.getElementById("canvas").toDataURL("image/jpg");
        var data=imgData.substr(22);
        //alert(imgData);

         //上傳，儲存图片  
            $.ajax({
                url: "${pageContext.request.contextPath}/upload",
                type: "post",
                //base64String
                data: { 'image':data  },
                async: true,
                success: function (htmlVal) {
                   window.location.href = "${pageContext.request.contextPath}/facelogin";
                   //alert("另存图片成功！");
                }, error: function (e) {
                	alert("另存图片失败！");
                    alert(e.responseText); //alert错误信息  
                }
            });
    });

</script>
    </body>   
</html>  