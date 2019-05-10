package cn.edu.fosu.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.edu.fosu.sql.JDBCUtil;
import cn.edu.fosu.sql.UserBean;

public class TestGetUserBean {

	public static void main(String[] args) {
		
		String  username = "小二";
		
		// 查询数据库
		String sql = "SELECT * FROM user";
		String[] info = {};

		// 存放结果集
		ArrayList<UserBean> userList = new ArrayList<UserBean>();
		Connection ct = null;//获得连接的对象
		ResultSet rs = null;//返回的结果

		ct = JDBCUtil.getConnection();
		rs = JDBCUtil.executeQuery(sql, info);

		try {
			while (rs.next()) {
				UserBean user = new UserBean();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				userList.add(user);
			}
			// 如果list不为空
			if (!userList.isEmpty()) {
				for (UserBean user : userList) {
					 System.out.println(user.toString()); 
					if (user.getUsername().equals(username)) {//username
						 System.out.println("该用户已存在！");
						 /*break;*/
					}
				}
				System.out.println("该用户不存在！");
			} else {
				System.out.println("userList为空!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
