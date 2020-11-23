package com.vod.movit.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.vod.movit.user.vo.UserVO;

public class UserValidator implements Validator {
	private static final String emailRegExp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private Pattern pattern;

	public UserValidator() {
		// TODO Auto-generated constructor stub
		pattern = Pattern.compile(emailRegExp);
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserVO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		UserVO user = (UserVO) target;

		if (user.getU_email() == null || user.getU_email().trim().isEmpty()) {
			errors.rejectValue("u_email", "required", "필수 정보 입니다.");
		} else {
			Matcher matcher = pattern.matcher(user.getU_email());
			if (!matcher.matches()) {
				errors.rejectValue("u_email", "bad", "올바르지 않는 형식입니다.");
			}
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "u_name", "required", "필수 정보 입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "u_id", "required", "필수 정보 입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "u_phone", "required", "필수 정보 입니다.");
		ValidationUtils.rejectIfEmpty(errors, "u_password", "required", "필수 정보 입니다.");
		ValidationUtils.rejectIfEmpty(errors, "checkPw", "required", "필수 정보 입니다.");
		if (!user.getU_password().isEmpty()) {
			if (!user.isPwEqualToCheckPw()) {
				errors.rejectValue("checkPw", "nomatch", "비밀번호가 일치하지 않습니다.");
			}
		}
	}
}
