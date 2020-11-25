package com.vod.movit.movie.svc;

import java.util.ArrayList;

import com.vod.movit.movie.vo.MovieVO;

public interface MovieService {

	ArrayList<MovieVO> getMovieList();

	ArrayList<MovieVO> getMovieNameList();

	ArrayList<MovieVO> getScoreList();

	ArrayList<MovieVO> getAudienceList();

	ArrayList<MovieVO> getDateList();


}
