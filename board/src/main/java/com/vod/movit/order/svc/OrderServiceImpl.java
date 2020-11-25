package com.vod.movit.order.svc;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vod.movit.movie.dao.MovieDAO;
import com.vod.movit.movie.vo.MovieVO;
import com.vod.movit.order.dao.OrderDAO;
import com.vod.movit.order.vo.CartVO;

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
	
	

}
