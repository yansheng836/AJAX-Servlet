package cn.edu.fosu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterDemo implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy……");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		//过滤器设置请求编码格式
		request.setCharacterEncoding("UTF-8");
		//过滤器过滤响应编码
		response.setContentType("text/html;charset=UTF-8");
		chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig chain) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init……");

	}

}
