package cn.edu.fosu.sql;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FindByUsername {

	// 2.重写方法，实现：输入的注册账号与数据库的账号进行对比，如果存在返回true，不存在则返回false
	public static boolean findByUsername(String username) {

		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM user WHERE username=?";
			String info[] = { username };
			rs = JDBCUtil.executeQuery(sql, info);
			if (rs.next()) {
				UserBean user = new UserBean();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				System.out.println(user.toString());
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtil.close(JDBCUtil.getCt(), JDBCUtil.getPs(), rs);
		}
		return false;
	}

}
