package com.vod.movit.board.vo;

import java.util.Date;

public class BoardVO  {
	/* mybatis연동 테스트!!!
	 * create table tbl_board(
  bno number not null,
  title varchar(50) not null,
  writer varchar(30) not null,
  content varchar(1000) not null,
  regDate date not null,
  viewCnt number default 0,
  primary key(bno)
);
	 */
	private int bno;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int viewCnt;
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
}
	