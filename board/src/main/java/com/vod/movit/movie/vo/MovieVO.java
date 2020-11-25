package com.vod.movit.movie.vo;

public class MovieVO  {
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
	private String m_no;
	private String m_title;
	private String m_director;
	private String m_content;
	private String m_genre;
	private String m_audience;
	private String m_company;
	private String m_nation;
	private String m_score;
	private String m_grade;
	private String m_regDate;
	
	public String getM_no() {
		return m_no;
	}
	public void setM_no(String m_no) {
		this.m_no = m_no;
	}
	public String getM_title() {
		return m_title;
	}
	public void setM_title(String m_title) {
		this.m_title = m_title;
	}
	public String getM_director() {
		return m_director;
	}
	public void setM_director(String m_director) {
		this.m_director = m_director;
	}
	public String getM_content() {
		return m_content;
	}
	public void setM_content(String m_content) {
		this.m_content = m_content;
	}
	public String getM_genre() {
		return m_genre;
	}
	public void setM_genre(String m_genre) {
		this.m_genre = m_genre;
	}
	public String getM_audience() {
		return m_audience;
	}
	public void setM_audience(String m_audience) {
		this.m_audience = m_audience;
	}
	public String getM_company() {
		return m_company;
	}
	public void setM_company(String m_company) {
		this.m_company = m_company;
	}
	public String getM_nation() {
		return m_nation;
	}
	public void setM_nation(String m_nation) {
		this.m_nation = m_nation;
	}
	public String getM_score() {
		return m_score;
	}
	public void setM_score(String m_score) {
		this.m_score = m_score;
	}
	public String getM_grade() {
		return m_grade;
	}
	public void setM_grade(String m_grade) {
		this.m_grade = m_grade;
	}
	public String getM_regDate() {
		return m_regDate;
	}
	public void setM_regDate(String m_regDate) {
		this.m_regDate = m_regDate;
	}
}
