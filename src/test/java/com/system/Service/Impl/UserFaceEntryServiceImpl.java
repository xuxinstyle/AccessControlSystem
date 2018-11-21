package com.system.Service.Impl;

import java.io.File;
import java.io.IOException;

public class UserFaceEntryServiceImpl {
	public static void main(String[] args) {
		try {
			File directory = new File("");// 参数为空
	        String courseFile,courseFile1;
			courseFile1 = directory.getAbsolutePath();
	        courseFile = directory.getCanonicalPath();
	        System.out.println(courseFile1);
	        System.out.println(courseFile);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
