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
		response.getWriter().append("Served at: ").append(this.getServletName());
		response.getWriter().append("<br/>现在的时间是：").append((new Date()).toString());
		System.out.println("访问了：SimpleServlet。");
		
		//测试重定向到浏览器:url+timestamp
		/*long timestamp = System.currentTimeMillis();
		response.sendRedirect("./basic/ajax_1_simple0.html?timestamp="+timestamp);*/

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
