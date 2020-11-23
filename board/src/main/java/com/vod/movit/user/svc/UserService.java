package com.vod.movit.user.svc;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.vod.movit.user.vo.UserVO;

public interface UserService {

	void addUser(UserVO user);
	
	UserVO viewUser(UserVO user);
	
	boolean loginCheck(UserVO user, HttpSession session);

	void logout(HttpSession session);

}
