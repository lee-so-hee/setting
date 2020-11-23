package com.vod.movit.user.svc;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vod.movit.exception.AlreadyExistingEmailException;
import com.vod.movit.exception.AlreadyExistingIdException;
import com.vod.movit.exception.AlreadyExistingNameException;
import com.vod.movit.exception.AlreadyExistingPhoneException;
import com.vod.movit.user.dao.UserDAO;
import com.vod.movit.user.vo.UserVO;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
	
	@Override
	public void addUser(UserVO user) {
		// TODO Auto-generated method stub
		UserVO email = userDAO.selectByEmail(user.getU_email());
		if(email!=null) {
			throw new AlreadyExistingEmailException(user.getU_email()+"is duplicate email.");
		}
		UserVO id = userDAO.selectById(user.getU_id());
		if(id!=null) {
			throw new AlreadyExistingIdException(user.getU_id()+"is duplicate id.");
		}
		UserVO name = userDAO.selectByName(user.getU_name());
		if(name!=null) {
			throw new AlreadyExistingNameException(user.getU_name()+"is duplicate name.");
		}
		UserVO phone= userDAO.selectByPhone(user.getU_phone());
		if(phone!=null) {
			throw new AlreadyExistingPhoneException(user.getU_phone()+"is duplicate phone.");
		}
		userDAO.insertUser(user);
	}


	@Override
	public boolean loginCheck(UserVO user, HttpSession session) {
		// TODO Auto-generated method stub
		boolean result = userDAO.loginCheck(user);
		if(result) {
			UserVO user2 = viewUser(user);
			session.setAttribute("userId", user2.getU_id());
			session.setAttribute("userName", user2.getU_name());
		}
		return result;
	}

	@Override
	public UserVO viewUser(UserVO user) {
		// TODO Auto-generated method stub
		return userDAO.viewUser(user);
	}


	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub
		session.invalidate(); // 세션 영역 초기화
	}


}
