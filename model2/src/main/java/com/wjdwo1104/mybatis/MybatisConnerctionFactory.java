package com.wjdwo1104.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConnerctionFactory {
	//factory pattern
	private static SqlSessionFactory sqlSessionFactory;
	static {
		
		InputStream inputStream;
		try {
			String resource = "com/wjdwo1104/mybatis/config.xml";
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	public static SqlSession getSqllSession() {
		return sqlSessionFactory.openSession();
	}
	
}
