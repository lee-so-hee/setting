package com.vod.movit.mybatis;

import com.vod.movit.user.vo.UserVO;

public interface UserMapper {

	void insertUser(UserVO user);

	UserVO selectByEmail(String u_email);

	UserVO selectById(String u_id);

	UserVO selectByName(String u_name);

	UserVO selectByPhone(String u_phone);

	String loginCheck(UserVO user);

	UserVO viewUser(UserVO user);

}
