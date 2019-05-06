package cn.edu.fosu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(this.getServletName());
		/*PrintWriter out = response.getWriter();
		out.println("hello wprld");*/
		
		/*//获得url中的数据
		String uriString = request.getRequestURI();
		System.out.println("uriString:"+uriString);
		
		String qString = request.getQueryString();
		System.out.println("qString:"+qString);
		
		//该方法也可以取get方法url中的参数和post方法中send(string)中string的参数
		String timestamp = request.getParameter("timestamp");
		System.out.println("timestamp:"+timestamp);
		*/
		
		String fname = request.getParameter("fname");
		System.out.println("fname:"+fname);
		
		String lname = request.getParameter("lname");
		System.out.println("lname:"+lname);
		
		response.getWriter().append("<br/>").append("This fname is: " +fname +"; lname is: "+lname+".");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
