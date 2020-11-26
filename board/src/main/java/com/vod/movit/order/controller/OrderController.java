package com.vod.movit.order.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;
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
import com.vod.movit.order.vo.PayVO;

/**
 * Handles requests for the application home page.
 */

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/addCart")
	public ModelAndView aaddDart(CartVO cart, HttpSession session)  {
		ModelAndView result = new ModelAndView();
		if(session.getAttribute("userName")!=null) {
			result.addObject("msg", "success");
		}
		else {
			result.addObject("msg",	"failure");
			result.setViewName("login");
			return result;
		}
		ArrayList<CartVO> hasMno = orderService.getCartList();
		
		for (CartVO cartVO : hasMno) {
			int m_no = cartVO.getM_no();
			System.out.println(m_no);
			System.out.println(cart.getM_no());
			if(m_no==cart.getM_no()) {
				result.setViewName("cart");
				result.addObject("cartlist",hasMno);
				result.addObject("cartMsg", "fail");
				return result;
			}
		}
		orderService.addCart(cart);
		ArrayList<CartVO> cartList = orderService.getCartList();
		result.addObject("cartlist",cartList);
		result.addObject("cartMsg", "success");
		result.setViewName("cart");
		return result;
	}
	
	@RequestMapping(value="/cart")
	public ModelAndView cart(HttpSession session) {
		ModelAndView result = new ModelAndView();
		if(session.getAttribute("userName")!=null) {
			result.addObject("msg", "success");
		}
		else {
			result.addObject("msg",	"failure");
			result.setViewName("login");
			return result;
		}
		ArrayList<CartVO> cartList = orderService.getCartList();
		result.addObject("cartlist",cartList);
		result.setViewName("cart");
		return result;
	}
	
	@RequestMapping(value="/removeCart")
	public String removeCart(@RequestParam("c_no") int cno ) {
		orderService.removeCart(cno);
		return "redirect:/cart";
	}
	
	
	@RequestMapping(value="/addPay")
	public ModelAndView addPay(PayVO payVO,HttpSession session) {
		int cno = payVO.getC_no();
		ModelAndView result = new ModelAndView();
		orderService.addPay(payVO); // 페이 테이블에 추가
		
		PayVO pay = orderService.getPay(cno); // 결제 목록 가져오기
		//orderService.removeCart(cno); // 결제 됐으니 장바구니에서 제거s
		
		if(session.getAttribute("userName")!=null) {
			result.addObject("msg", "success");
		}
		else {
			result.addObject("msg",	"failure");
			result.setViewName("login");
			return result;
		}
		result.addObject("pay", pay);
		result.setViewName("pay");
		//페이 창에서 결제 된거 띄어주기
		return result;
	}
	
	
	@RequestMapping(value="/payList")
	public ModelAndView payList(HttpSession session) {
		ModelAndView result = new ModelAndView();
		ArrayList<PayVO> payList = orderService.getPayList(); // 결제 목록 가져오기
		
		if(session.getAttribute("userName")!=null) {
			result.addObject("msg", "success");
		}
		else {
			result.addObject("msg",	"failure");
			result.setViewName("login");
			return result;
		}
		result.addObject("payList", payList);
		result.setViewName("payList");
		//페이 창에서 결제 된거 띄어주기
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
