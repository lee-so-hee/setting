package com.vod.movit.movie.dao;

import java.util.ArrayList;

import com.vod.movit.movie.vo.MovieVO;

public interface MovieDAO {

	ArrayList<MovieVO> getMovieList();

	ArrayList<MovieVO> getMovieNameList();

	ArrayList<MovieVO> getAudienceList();

	ArrayList<MovieVO> getScoreList();

	ArrayList<MovieVO> getDateList();


}
