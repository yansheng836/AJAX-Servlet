package cn.edu.fosu.test;

import cn.edu.fosu.sql.UserBean;

public class TestUserBean {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserBean user = new UserBean();
		user.setUsername("zhangsan");
		user.setPassword("123456");
		System.out.println("username="+user.getUsername()+",password="+user.getPassword());
		System.out.println(user.toString());
	}
}
