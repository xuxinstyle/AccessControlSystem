package com.system.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.stereotype.Service;

import com.system.mapper.SuperMapper;
import com.system.po.User;
import com.system.service.UserFaceService;

@Service
public class UserFaceServiceImpl implements UserFaceService {

	@Resource
	private SuperMapper superMapper;
	/**
	 * 调用摄像头保存照片到相应目录下
	 */
	public void getFace(String id) {
		// TODO Auto-generated method stub
		
		try {
			File directory = new File("");// 参数为空
	        String courseFile;
			courseFile = directory.getCanonicalPath();
			System.out.println(courseFile);
			User user = superMapper.selectByPrimaryKey(id);
			// 若Python脚本在windows主机中 
			String root_path=courseFile+"\\src\\main\\webapp\\";
			
			String cmdStr_windows = root_path+"py\\get_face_from_camera.py"; 
			
			String DatRecourse_path=root_path+"py\\";
			String path_save = root_path+"images\\"+user.getUsername()+"\\";
			String[] args = new String[]{"python",cmdStr_windows,path_save,DatRecourse_path};
			/*for (int i = 0; i < args.length; i++) {
				String string = args[i];
				System.out.println(string);
			}*/
			// 定义缓冲区、正常结果输出流、错误信息输出流 
			byte[] buffer = new byte[1024]; 
			ByteArrayOutputStream outStream = new ByteArrayOutputStream(); 
			ByteArrayOutputStream outerrStream = new ByteArrayOutputStream(); 
			
			Process proc=Runtime.getRuntime().exec(args); 
			InputStream errStream = proc.getErrorStream(); 
			InputStream stream = proc.getInputStream(); // 流读取与写入 
			int len = -1; 
			int lag=0;
			while ((len = errStream.read(buffer)) != -1) { 
				outerrStream.write(buffer, 0, len); 
				lag=1;
			} while ((len = stream.read(buffer)) != -1) { 
				outStream.write(buffer, 0, len); 
			} 
			if(lag==0){
				user.setImagepath(path_save);
				superMapper.updateByPrimaryKey(user);
			}
			proc.waitFor();// 等待命令执行完成 
			/*// 打印流信息 
			System.out.println(outStream.toString()); 
			System.out.println(outerrStream.toString()); */
			// 将接收的输出结果转换为目标类型 
			//Integer.parseInt(outStream.toString()); 
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
	}
	/**
	 * 将保存的照片中的特征提取出来并保存在响应目录下的csv文件中
	 */
	@Override
	public void getFeatures(String id) {
		// TODO Auto-generated method stub
		try {
			File directory = new File("");// 参数为空
			String courseFile = directory.getCanonicalPath();
			System.out.println(courseFile);
			
			User user = superMapper.selectByPrimaryKey(id);
			// 若Python脚本在windows主机中 
			String root_path=courseFile+"\\src\\main\\webapp\\";
			
			String cmdStr_windows = root_path+"py\\get_features_into_CSV.py"; 
			
			String DatRecourse_path=root_path+"py\\";
			String path_image=root_path+"images\\"+user.getUsername()+"\\";
			String path_cvs = root_path+"csvs\\"+user.getUsername()+"\\";
			String[] args = new String[]{"python",cmdStr_windows,path_cvs,DatRecourse_path,path_image};
			/*for (int i = 0; i < args.length; i++) {
				String string = args[i];
				System.out.println(string);
			}*/
			// 定义缓冲区、正常结果输出流、错误信息输出流 
			byte[] buffer = new byte[1024]; 
			ByteArrayOutputStream outStream = new ByteArrayOutputStream(); 
			ByteArrayOutputStream outerrStream = new ByteArrayOutputStream(); 
			
			Process proc=Runtime.getRuntime().exec(args); 
			InputStream errStream = proc.getErrorStream(); 
			InputStream stream = proc.getInputStream(); // 流读取与写入 
			int len = -1; 
			int flag=0;
			while ((len = errStream.read(buffer)) != -1) { 
				outerrStream.write(buffer, 0, len); 
				flag=1;
			} while ((len = stream.read(buffer)) != -1) { 
				outStream.write(buffer, 0, len); 
			} 
			if(flag==0){
				user.setCsvpath(path_cvs+"default_person.csv");
				superMapper.updateByPrimaryKey(user);
				System.out.println("录入成功");
			}
			proc.waitFor();// 等待命令执行完成 
			// 打印流信息 
			System.out.println(outStream.toString()); 
			System.out.println(outerrStream.toString()); 
			// 将接收的输出结果转换为目标类型 
			//Integer.parseInt(outStream.toString()); 
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
	}

}
