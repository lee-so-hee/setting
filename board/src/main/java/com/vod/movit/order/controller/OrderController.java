package com.vod.movit.order.controller;

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

import com.vod.movit.movie.svc.MovieService;
import com.vod.movit.movie.vo.MovieVO;
import com.vod.movit.order.svc.OrderService;
import com.vod.movit.order.vo.CartVO;

/**
 * Handles requests for the application home page.
 */

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/cart")
	public ModelAndView cart(CartVO cart, HttpSession session) {
		ModelAndView result = new ModelAndView();
		if(session.getAttribute("userName")!=null) {
			result.addObject("msg", "success");
		}
		else {
			result.addObject("msg",	"failure");
			result.setViewName("login");
			return result;
		}
		orderService.addCart(cart);
		CartVO cart1 = orderService.getCart();
		result.addObject("cart",cart1);
		result.setViewName("cart");
		return result;
	}
	
	/*
	@RequestMapping(value="/pay")
	public ModelAndView pay(HttpSession session) {
		ModelAndView result = new ModelAndView();
		orderService.addPay();
		if(session.getAttribute("userName")!=null) {
			result.addObject("msg", "success");
		}
		else {
			result.addObject("msg",	"failure");
			result.setViewName("login");
			return result;
		}
		result.setViewName("pay");
		return result;
		
	}*/
}
