package com.vod.movit.board.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vod.movit.board.svc.BoardService;
import com.vod.movit.board.vo.BoardVO;
import com.vod.movit.movie.svc.MovieService;
import com.vod.movit.movie.vo.MovieVO;

/**
 * Handles requests for the application home page.
 */

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	@Autowired
	private MovieService movieService;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "index";
	} */

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/password")
	public String password() {
		return "password";
	}

	@RequestMapping(value = "/register")
	public String addCommunity() {
		return "register";
	}

	@RequestMapping(value="/boardWriteForm")
	public ModelAndView boardWriteForm() {
		ModelAndView result = new ModelAndView();
		ArrayList<MovieVO> movieNameList = movieService.getMovieNameList();
		result.addObject("movieNameList", movieNameList);
		result.setViewName("boardWriteForm");
		return result;
	}
	
	@RequestMapping(value="/boardWrite")
	public String boardWrite(BoardVO board) {
		boardService.addBoard(board);
		return "redirect:/table";
	}
	
	@RequestMapping(value = "/table")
	public ModelAndView boardList(HttpSession session) {
		ModelAndView result = new ModelAndView();
		ArrayList<BoardVO> boardList = boardService.getBoardList();
		result.addObject("boardList", boardList);
		if(session.getAttribute("userName")!=null) {
			result.addObject("msg", "success");
		}
		else {
			result.addObject("msg",	"failure");
			result.setViewName("login");
			return result;
		}
		result.setViewName("table");
		return result;
	}
	
	@RequestMapping(value = "/detailBoard")
	public ModelAndView detailBoard(@RequestParam("b_no") int bno ) {
		ModelAndView result = new ModelAndView();
		BoardVO detail = boardService.getBoard(bno);
		result.addObject("detail", detail);
		result.setViewName("detailBoard");
		return result;
	}
	
	@RequestMapping(value = "/boardModify")
	public ModelAndView updateGetCommunity(@RequestParam("b_no") int bno ) {
		ModelAndView result = new ModelAndView();
		BoardVO detail = boardService.getBoard(bno);
		result.addObject("detail", detail);
		result.setViewName("updateBoardForm");
		return result;
	}
	@RequestMapping(value = "/removeBoard")
	public String removeBoard(@RequestParam("b_no") int bno ) {
		boardService.removeBoard(bno);
		return "redirect:/table";// table함수를 실행해 현재 db의 내용도 같이 가져감
	}
	
	@RequestMapping(value = "/updateBoard")
	public ModelAndView updateBoard(BoardVO board, @RequestParam("b_no") int bno ) {
		ModelAndView result = new ModelAndView();
		boardService.modifyBoard(board);
		result.setViewName("redirect:/table"); // table함수를 실행해 현재 db의 내용도 같이 가져감
		return result;
	}
}
