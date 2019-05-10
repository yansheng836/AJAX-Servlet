package cn.edu.fosu.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
	//定义驱动，数据库访问地址，用户名，密码
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/ajax_servlet?useUnicode=true&charEncoding=utf-8";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	private static Connection ct = null;//获得连接的对象

	private static PreparedStatement ps = null;//发送sql语句的对象

	private static ResultSet rs = null;//返回的结果

	//1.加载驱动，因为数据库驱动只加载一次，所以可以将加载驱动代码放到静态代码块中
	static {
		try {
			Class.forName(DRIVER);
			/* System.out.println("1.加载驱动"); */
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	//2.获得连接
	public static Connection getConnection() {
		try {
			ct = DriverManager.getConnection(URL, USER, PASSWORD);
			/* System.out.println("2.获得连接"); */
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ct;
	}

	// 3.得到发送sql语句对象statement
	// 编写一个方法返回 ResultSet
	public static ResultSet executeQuery(String sql, String[] info) {
		ct = getConnection();//得到连接

		try {
			//得到ps对象
			ps = ct.prepareStatement(sql);
			//处理占位符问题，有占位符才处理，插入语句id=4，写活，4的位置为占位符
			if (info != null) {
				//有可能有多个占位符，用for循环处理
				for (int i = 0; i < info.length; i++) {
					//将占位符设置到sql语句中
					ps.setString(1 + i, info[i]);
				}
			} //4.发送sql语句,这是发送查询sql语句
			rs = ps.executeQuery();

			//5.返回操作结果(ResultSet)
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//注意：查询方法的资源不能再这里关，因为要返回
		return null;//该语句基本上到不了
	}

	//7.关闭资源，封装一个关闭资源的方法,关闭的原则：先打开、后关闭
	public static void close(Connection ct, PreparedStatement ps, ResultSet rs) {
		try {
			if (ct != null) {
				ct.close();
			}
			ct = null;

			if (ps != null) {
				ps.close();
			}
			ps = null;

			if (rs != null) {
				rs.close();
			}
			rs = null;

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//编写两个方法，返回ps,ct
	public static Connection getCt() {
		return ct;
	}

	public static PreparedStatement getPs() {
		return ps;
	}

}
