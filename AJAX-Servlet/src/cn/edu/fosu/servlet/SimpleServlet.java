package cn.edu.fosu.servlet;

import java.io.IOException;
import java.security.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BasicServlet
 */
@WebServlet("/SimpleServlet")
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append("<br>现在的时间是：").append((new Date()).toString());
		
		
		//测试重定向到浏览器:url+timestamp
		/*long timestamp = System.currentTimeMillis();
		response.sendRedirect("./basic/ajax_1_simple0.html?timestamp="+timestamp);*/
		
		/*//获得url中的数据
		String uriString = request.getRequestURI();
		System.out.println("uriString:"+uriString);
		
		String qString = request.getQueryString();
		System.out.println("qString:"+qString);
		
		//该方法也可以取get方法url中的参数
		String timestamp = request.getParameter("timestamp");
		System.out.println("timestamp:"+timestamp);
		
		String time = request.getParameter("time");
		System.out.println("time:"+time);*/
		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
