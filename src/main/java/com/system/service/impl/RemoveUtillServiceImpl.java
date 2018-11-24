package com.system.service.impl;

import java.io.File;

import org.springframework.stereotype.Component;

import com.system.service.RemoveUtilService;

@Component
public class RemoveUtillServiceImpl implements RemoveUtilService {

	
	//删除指定目录下的所有文件和文件夹，递归删除
	@Override
	public void RemoveFile(String path) {
		// TODO Auto-generated method stub
		File file=new File(path);
		if(file.exists()){
			deleteFile(file);
		}
		
	}

	private void deleteFile(File file) {
		// TODO Auto-generated method stub
		if(file.isDirectory()){
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				deleteFile(files[i]);
			}
		}
		file.delete();
	}

}
