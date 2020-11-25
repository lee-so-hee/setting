package com.vod.movit.mybatis;

import java.util.ArrayList;

import com.vod.movit.board.vo.BoardVO;
import com.vod.movit.movie.vo.MovieVO;

public interface MovieMapper {
	ArrayList<MovieVO> getMovieList();

	ArrayList<MovieVO> getMovieNameList();

	ArrayList<MovieVO> getDateList();

	ArrayList<MovieVO> getScoreList();

	ArrayList<MovieVO> getAudienceList();
}
