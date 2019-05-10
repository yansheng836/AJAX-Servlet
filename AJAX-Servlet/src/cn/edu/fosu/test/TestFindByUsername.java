package cn.edu.fosu.test;

import cn.edu.fosu.sql.FindByUsername;

public class TestFindByUsername {

	public static void main(String[] args) {
		
		// 测试findByUsername(username)方法是否有效
		String username = "小二";
		boolean bool = FindByUsername.findByUsername(username);
		System.out.println(bool);
		
		String username1 = "小";
		boolean bool1 = FindByUsername.findByUsername(username1);
		System.out.println(bool1);
	}

}
