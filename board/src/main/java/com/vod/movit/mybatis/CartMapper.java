package com.vod.movit.mybatis;

import java.util.ArrayList;

import com.vod.movit.board.vo.BoardVO;
import com.vod.movit.movie.vo.MovieVO;
import com.vod.movit.order.vo.CartVO;

public interface CartMapper {

	void insertCart(CartVO cart);

	CartVO getCart();

	ArrayList<CartVO> getCartList(String user);

	void deleteCart(int cno);
	
}
