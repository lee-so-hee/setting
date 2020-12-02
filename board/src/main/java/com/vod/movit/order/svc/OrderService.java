package com.vod.movit.order.svc;

import java.util.ArrayList;

import com.vod.movit.movie.vo.MovieVO;
import com.vod.movit.order.vo.CartVO;
import com.vod.movit.order.vo.PayVO;

public interface OrderService {

	void addCart(CartVO cart);

	CartVO getCart();

	ArrayList<CartVO> getCartList(String user);

	void removeCart(int cno);

	void addPay(PayVO payVO);

	ArrayList<PayVO> getPayList(String user);

	PayVO getPay(int cno);



}
