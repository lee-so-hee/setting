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
	private int c_no;
	private String m_no;
	private String u_id;
	private int c_money;
	private Date c_orderDate;
	
	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	public String getM_no() {
		return m_no;
	}
	public void setM_no(String m_no) {
		this.m_no = m_no;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public int getC_money() {
		return c_money;
	}
	public void setC_money(int c_money) {
		this.c_money = c_money;
	}
	public Date getC_orderDate() {
		return c_orderDate;
	}
	public void setC_orderDate(Date c_orderDate) {
		this.c_orderDate = c_orderDate;
	}
	
}
