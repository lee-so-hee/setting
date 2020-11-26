package com.vod.movit.mybatis;

import java.util.ArrayList;

import com.vod.movit.board.vo.BoardVO;
import com.vod.movit.movie.vo.MovieVO;
import com.vod.movit.order.vo.CartVO;
import com.vod.movit.order.vo.PayVO;

public interface PayMapper {

	void insertPay(PayVO payVO);

	ArrayList<PayVO> selectPayList();

	PayVO selectPay(int cno);
	
}
