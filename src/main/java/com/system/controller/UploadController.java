package com.system.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UploadController {
	
	@RequestMapping(value="/upload")
	@ResponseBody
	public String upload(@RequestParam(value = "image", defaultValue = "") String data) throws IOException{
		boolean b = GenerateImage(data);
		System.out.println(b);
		if(b){
			System.out.println("跳转至：login");
			return "redirect:/facelogin";
		}
		
		return "failure";
		
	}

	public static boolean GenerateImage(String imgStr) {
		// TODO Auto-generated method stub
		if(imgStr==null){
			System.out.println("空");
			return false;
		}
		Base64 base64=new Base64();
		try {
			byte[] decode = base64.decode(imgStr);
			for (int i = 0; i < decode.length; i++) {
				
				if(decode[i]<0){// 调整异常数据
					
					decode[i]+=256;
				}
			}
			File directory = new File("");// 参数为空
	        String courseFile;
			courseFile = directory.getCanonicalPath();
			//System.out.println(courseFile);
			// 图片生成位置
			String imgPath=courseFile+"\\src\\main\\webapp\\images\\current\\current.jpg";
			
			//生成jpg图片
			OutputStream out=new FileOutputStream(imgPath);
			
			out.write(decode);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getStackTrace();
			return false;
		}
	}
}
