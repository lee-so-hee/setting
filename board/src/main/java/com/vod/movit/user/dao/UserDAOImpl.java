package com.vod.movit.user.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vod.movit.mybatis.UserMapper;
import com.vod.movit.user.vo.UserVO;
@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired 
	private SqlSession sqlSession;
	@Override
	public UserVO selectByEmail(String u_email) {
		// TODO Auto-generated method stub
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		UserVO email = userMapper.selectByEmail(u_email);
		return email;
	}

	@Override
	public UserVO selectById(String u_id) {
		// TODO Auto-generated method stub
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		UserVO id = userMapper.selectById(u_id);
		return id;
	}

	@Override
	public UserVO selectByName(String u_name) {
		// TODO Auto-generated method stub
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		UserVO name = userMapper.selectByName(u_name);
		return name;
	}

	@Override
	public UserVO selectByPhone(String u_phone) {
		// TODO Auto-generated method stub
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		UserVO phone = userMapper.selectByPhone(u_phone);
		return phone;
	}

	@Override
	public void insertUser(UserVO user) {
		// TODO Auto-generated method stub
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.insertUser(user);
	}

	@Override
	public boolean loginCheck(UserVO user) {
		// TODO Auto-generated method stub
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		String name = userMapper.loginCheck(user);
		return (name==null)? false:true;
	}

	@Override
	public UserVO viewUser(UserVO user) {
		// TODO Auto-generated method stub
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		UserVO user1 = userMapper.viewUser(user);
		return user1;
	}

}
