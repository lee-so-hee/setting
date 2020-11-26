package com.vod.movit.order.vo;

import java.util.Date;

public class PayVO  {
	/*
	CREATE TABLE tbl_movie(
			   m_id       varchar2(100)    NOT NULL,   --영화id
			   m_title      varchar2(100)    NOT NULL,   --영화제목
			   m_director   varchar2(100)   NOT NULL,   --영화감독
			   m_content   varchar2(2000)   NOT NULL,   --영화내용(줄거리)
			   m_genre      varchar2(100)   NOT NULL,   --영화장르
			   m_audience   varchar2(100)   NOT NULL,   --영화관객수
			   m_company   varchar2(100)   NOT NULL,   --영화배급사
			   m_nation   varchar2(100)   NOT NULL,   --영화제작국가
			   m_score      varchar2(100)   NOT NULL,   --영화평점
			   m_grade    varchar2(100)   NOT NULL,   --영화등급
			   m_imageUrl  varchar2(100)   NOT NULL,   --영화이미지
			   primary key(m_id)
			);
			*/
	private int p_no;
	private int c_no;
	private int m_no;
	private String u_id;
	private int p_money;
	private Date p_orderDate;
	
	private String u_email;
	private String m_title;
	private String u_name;
	private String u_phone;
	
	public int getP_no() {
		return p_no;
	}
	public void setP_no(int p_no) {
		this.p_no = p_no;
	}
	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public int getP_money() {
		return p_money;
	}
	public void setP_money(int p_money) {
		this.p_money = p_money;
	}
	public Date getP_orderDate() {
		return p_orderDate;
	}
	public void setP_orderDate(Date p_orderDate) {
		this.p_orderDate = p_orderDate;
	}
	
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public String getM_title() {
		return m_title;
	}
	public void setM_title(String m_title) {
		this.m_title = m_title;
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
	
	
}
