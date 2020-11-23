package com.vod.movit.user.vo;

import java.util.Date;

public class UserVO {

	/*
	 * CREATE TABLE tbl_userinfo( u_id varchar2(50) NOT NULL, u_password
	 * varchar2(100) NOT NULL, u_name varchar2(50) NOT NULL, u_phone varchar2(50)
	 * NOT NULL, u_email varchar2(50) NOT NULL, u_regDate DATE NOT NULL, PRIMARY
	 * KEY(u_id) );
	 */
	private String u_id;
	private String u_password;
	private String checkPw;
	private String u_name;
	private String u_phone;
	private String u_email;
	private Date u_regDate;

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_password() {
		return u_password;
	}

	public void setU_password(String u_password) {
		this.u_password = u_password;
	}

	public String getCheckPw() {
		return checkPw;
	}

	public void setCheckPw(String checkPw) {
		this.checkPw = checkPw;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_phone() {
		return u_phone;
	}

	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}

	public String getU_email() {
		return u_email;
	}

	public void setU_email(String u_email) {
		this.u_email = u_email;
	}

	public Date getU_regDate() {
		return u_regDate;
	}

	public void setU_regDate(Date u_regDate) {
		this.u_regDate = u_regDate;
	}

	public boolean isPwEqualToCheckPw() {
		// TODO Auto-generated method stub
		return u_password.equals(checkPw);
	}
}
