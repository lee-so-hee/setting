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

}
