package com.vod.movit.movie.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

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
	public ModelAndView home(HttpSession session) {
		ModelAndView result = new ModelAndView();
		ArrayList<MovieVO> gradeList = movieService.getScoreList();
		ArrayList<MovieVO> audienceList = movieService.getAudienceList();
		ArrayList<MovieVO> dateList = movieService.getDateList();
		result.addObject("scoreList",gradeList);
		result.addObject("audienceList",audienceList);
		result.addObject("dateList",dateList);
		result.setViewName("index");
		return result;
		
	}
	@RequestMapping(value="/index")
	public ModelAndView index(HttpSession session) {
		ModelAndView result = new ModelAndView();
		ArrayList<MovieVO> gradeList = movieService.getScoreList();
		ArrayList<MovieVO> audienceList = movieService.getAudienceList();
		ArrayList<MovieVO> dateList = movieService.getDateList();
		result.addObject("scoreList",gradeList);
		result.addObject("audienceList",audienceList);
		result.addObject("dateList",dateList);
		if(session.getAttribute("userName")!=null) {
			result.addObject("msg", "success");
		}
		else {
			result.addObject("msg",	"failure");
			result.setViewName("login");
			return result;
		}
		result.setViewName("index");
		return result;
		
	}
	
	@RequestMapping(value="/movie")
	public ModelAndView movie(HttpSession session) {
		ModelAndView result = new ModelAndView();
		ArrayList<MovieVO> movieList = movieService.getMovieList();
		result.addObject("movieList",movieList);
		if(session.getAttribute("userName")!=null) {
			result.addObject("msg", "success");
		}
		else {
			result.addObject("msg",	"failure");
			result.setViewName("login");
			return result;
		}
		result.setViewName("movie");
		return result;
		
	}
}
