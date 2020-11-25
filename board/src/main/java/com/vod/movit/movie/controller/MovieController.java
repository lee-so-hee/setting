package com.vod.movit.movie.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vod.movit.movie.svc.MovieService;
import com.vod.movit.movie.vo.MovieVO;

/**
 * Handles requests for the application home page.
 */

@Controller
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping(value="/")
	public ModelAndView home() {
		ModelAndView result = new ModelAndView();
		ArrayList<MovieVO> movieList = movieService.getMovieList();
		result.addObject("movieList",movieList);
		result.setViewName("index");
		return result;
		
	}
}
