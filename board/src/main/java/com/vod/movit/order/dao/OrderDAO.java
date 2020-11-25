package com.vod.movit.order.dao;

import java.util.ArrayList;

import com.vod.movit.movie.vo.MovieVO;
import com.vod.movit.order.vo.CartVO;

public interface OrderDAO {

	void insertCart(CartVO cart);

	CartVO getCart();

	


}
