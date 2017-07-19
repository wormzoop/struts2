package com.zoop.dao;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.zoop.entity.User;

public class UserDao {

	private SqlSessionFactory sessionFactory;
	
	public UserDao(){
		String source = "mybatis-config.xml";
		try{
			Reader reader = Resources.getResourceAsReader(source);
			sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public List<User> getUserList(){
		SqlSession session = getSessionFactory().openSession();
		List<User> list = null;
		String statement = "userMapper.userlist";
		list = session.selectList(statement);
		session.commit();
		return list;
	}
	
	public SqlSessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
}
