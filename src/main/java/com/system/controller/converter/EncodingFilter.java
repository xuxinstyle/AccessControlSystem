package com.system.controller.converter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class EncodingFilter extends OncePerRequestFilter{
	private String encoding;
	
	public void setEncoding(String encoding){
		this.encoding=encoding;
	}
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置请求响应字符的编码
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		//新增加的代码
		HttpServletRequest req=new GetHttpServletRequestWrapper(request,encoding);
		chain.doFilter(req, response);
	}
	
	class GetHttpServletRequestWrapper extends HttpServletRequestWrapper{
		
		private String charset="UTF-8"; 
		
		public GetHttpServletRequestWrapper(HttpServletRequest request) {
			super(request);
			
		}
		/**
		 * 获得被装饰对象的引用和采用字符编码
		 * 
		 * @param request
		 * @param charset
		 */
		public GetHttpServletRequestWrapper(HttpServletRequest request,String charset) {
			super(request);
			this.charset=charset;
		}
		/**
		 * 获取单个参数的重写
		 */
		public String getParameter(String name){
			String value = super.getParameter(name);
				try {
					if(value!=null){
						value=new String(value.getBytes("ISO-8859-1"),charset);
					}
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return value;
		}
		
		/**
		 * Spring MVC方法参数自动注入调用的是这个方法
		 * 
		 */
		public String[] getParameterValues(String name){
			String[] values=super.getParameterValues(name);
			if(values!=null){
				for (int i = 0; i < values.length; i++) {
					try {
						System.out.println("转码前是否乱码："+values[i]);
						values[i]=new String(values[i].getBytes("UTF-8"));
						System.out.println("之后是否乱码："+values[i]);
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			return values;
		}
		
	}
	
}
