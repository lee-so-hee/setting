package com.vod.movit.board.vo;

import java.util.Date;

public class BoardVO {
	/*
	 * mybatis연동 테스트!!! create table tbl_board( bno number not null, title
	 * varchar(50) not null, writer varchar(30) not null, content varchar(1000) not
	 * null, regDate date not null, viewCnt number default 0, primary key(bno) );
	 */
	private int b_no;
	private String b_title;
	private String b_writer;
	private String b_content;
	private String b_regDate;
	private int b_viewCnt;
	private int m_no;
	private String title;

	public int getB_no() {
		return b_no;
	}

	public void setB_no(int b_no) {
		this.b_no = b_no;
	}

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_writer() {
		return b_writer;
	}

	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}

	public String getB_content() {
		return b_content;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	public String getB_regDate() {
		return b_regDate;
	}

	public void setB_regDate(String b_regDate) {
		this.b_regDate = b_regDate;
	}

	public int getB_viewCnt() {
		return b_viewCnt;
	}

	public void setB_viewCnt(int b_viewCnt) {
		this.b_viewCnt = b_viewCnt;
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
