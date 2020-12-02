package com.vod.movit.order.svc;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vod.movit.movie.dao.MovieDAO;
import com.vod.movit.movie.vo.MovieVO;
import com.vod.movit.order.dao.OrderDAO;
import com.vod.movit.order.vo.CartVO;
import com.vod.movit.order.vo.PayVO;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderDAO orderDAO;

	@Override
	public void addCart(CartVO cart) {
		// TODO Auto-generated method stub
		orderDAO.insertCart(cart);
	}

	@Override
	public CartVO getCart() {
		// TODO Auto-generated method stub
		CartVO cart = orderDAO.getCart();
		return cart;
	}

	@Override
	public ArrayList<CartVO> getCartList(String user) {
		// TODO Auto-generated method stub
		ArrayList<CartVO> cartList = orderDAO.getCartList(user);
		return cartList;
	}

	@Override
	public void removeCart(int cno) {
		// TODO Auto-generated method stub
		orderDAO.removeCart(cno);
	}

	@Override
	public void addPay(PayVO payVO) {
		// TODO Auto-generated method stub
		orderDAO.addPay(payVO);
	}

	@Override
	public ArrayList<PayVO> getPayList(String user) {
		// TODO Auto-generated method stub
		 ArrayList<PayVO> payList = orderDAO.getPayList(user);
		return payList;
	}

	@Override
	public PayVO getPay(int cno) {
		// TODO Auto-generated method stub
		PayVO pay = orderDAO.getPay(cno);
		return pay;
	}
	
	

}
