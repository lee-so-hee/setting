package com.vod.movit.movie.svc;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vod.movit.movie.dao.MovieDAO;
import com.vod.movit.movie.vo.MovieVO;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	MovieDAO movieDAO;
	@Override
	public ArrayList<MovieVO> getMovieList() {
		// TODO Auto-generated method stub
		ArrayList<MovieVO> movieList = movieDAO.getMovieList();
		return movieList;
	}
	@Override
	public ArrayList<MovieVO> getMovieNameList() {
		// TODO Auto-generated method stub
		ArrayList<MovieVO> movieNameList = movieDAO.getMovieNameList();
		return movieNameList;
	}
	@Override
	public ArrayList<MovieVO> getScoreList() {
		// TODO Auto-generated method stub
		ArrayList<MovieVO> gradeList = movieDAO.getScoreList();
		return gradeList;
	}
	@Override
	public ArrayList<MovieVO> getAudienceList() {
		// TODO Auto-generated method stub
		ArrayList<MovieVO> audienceList = movieDAO.getAudienceList();
		return audienceList;
	}
	@Override
	public ArrayList<MovieVO> getDateList() {
		// TODO Auto-generated method stub
		ArrayList<MovieVO> dateList = movieDAO.getDateList();
		return dateList;
	}
	

}
