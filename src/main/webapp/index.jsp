<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
  <head>
    <title>index.jsp</title>
	<meta charset="UTF-8"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
	<meta http-equiv="X-UA-Compatible" content="ie=edge"> 
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">

  </head>
  
  <body>
    <video id="video" width="320" height="320" autoplay></video>
  <!--   <button id="picture" style="display:block" >拍照</button>
    <button id="sc" style="display:block" >上传</button> -->
	<form action="">
		<input type="button" class="btn btn-default btn-info"  onclick="location.href='${pageContext.request.contextPath}/facelogin'" value="人脸识别"/>
  	</form>
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
</script>
  
  </body>
</html>
