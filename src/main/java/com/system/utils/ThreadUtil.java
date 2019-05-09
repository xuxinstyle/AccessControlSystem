package com.system.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;



public class ThreadUtil {
	public static final int TSAKSIZE = 5;  
	// 创建一个线程池  
	public static ExecutorService pool = Executors.newFixedThreadPool(TSAKSIZE);  
	
}
