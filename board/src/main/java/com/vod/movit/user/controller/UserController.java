package com.vod.movit.user.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vod.movit.exception.AlreadyExistingEmailException;
import com.vod.movit.exception.AlreadyExistingIdException;
import com.vod.movit.exception.AlreadyExistingNameException;
import com.vod.movit.exception.AlreadyExistingPhoneException;
import com.vod.movit.user.svc.UserService;
import com.vod.movit.user.vo.UserVO;
import com.vod.movit.validator.UserValidator;

/**
 * Handles requests for the application home page.
 */

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/loginForm")
	public String loginForm(Locale locale) {
		return "login";
	}

	// 로그인 처리
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginCheck(@ModelAttribute("user") @Validated UserVO user, HttpSession session) {
		boolean result = userService.loginCheck(user, session);
		ModelAndView mav = new ModelAndView();
		if (result == true) {
			mav.setViewName("index");
			mav.addObject("msg", "success");
		} else {
			mav.setViewName("login");
			mav.addObject("msg", "failure");
		}
		return mav;
	}

	//로그아웃 처리
		@RequestMapping(value="/logout")
		public ModelAndView logout(HttpSession session) {
			userService.logout(session);
			ModelAndView mav = new ModelAndView();
			mav.setViewName("login");
			mav.addObject("msg","logout");
			return mav;
		}
	
	@RequestMapping("/registerForm")
	public ModelAndView registerForm() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", new UserVO());
		mv.setViewName("register");
		return mv;
	}

	@RequestMapping(value = "/insertUser", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("user") @Validated UserVO user, Errors errors) throws Exception {
		new UserValidator().validate(user, errors);
		// 오류 발생시 다시
		if (errors.hasErrors()) {
			ModelAndView mv = new ModelAndView("register");
			return mv;
		}
		try {
			userService.addUser(user);
		} catch (AlreadyExistingEmailException e) {
			errors.rejectValue("u_email", "duplicate", "이미 가입된 이메일입니다.");
			ModelAndView mv = new ModelAndView("register");
			return mv;
		} catch (AlreadyExistingIdException e) {
			errors.rejectValue("u_id", "duplicate", "이미 가입된 아이디입니다.");
			ModelAndView mv = new ModelAndView("register");
			return mv;
		} catch (AlreadyExistingNameException e) {
			errors.rejectValue("u_nickname", "duplicate", "이미 있는 이름입니다.");
			ModelAndView mv = new ModelAndView("register");
			return mv;
		} catch (AlreadyExistingPhoneException e) {
			errors.rejectValue("u_phone", "duplicate", "이미 있는 번호입니다.");
			ModelAndView mv = new ModelAndView("register");
			return mv;
		}
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

}
