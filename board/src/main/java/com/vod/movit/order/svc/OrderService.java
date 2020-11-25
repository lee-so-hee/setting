package com.vod.movit.order.svc;

import java.util.ArrayList;

import com.vod.movit.movie.vo.MovieVO;
import com.vod.movit.order.vo.CartVO;

public interface OrderService {

	void addCart(CartVO cart);

	CartVO getCart();



}
