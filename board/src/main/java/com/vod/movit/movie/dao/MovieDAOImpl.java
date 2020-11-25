package com.vod.movit.movie.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vod.movit.movie.vo.MovieVO;
import com.vod.movit.mybatis.MovieMapper;

@Repository
public class MovieDAOImpl implements MovieDAO {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public ArrayList<MovieVO> getMovieList() {
		// TODO Auto-generated method stub
		ArrayList<MovieVO> result = new ArrayList<MovieVO>();
		MovieMapper movieMapper = sqlSession.getMapper(MovieMapper.class);
		result = movieMapper.getMovieList();
		return result;
	}

}
