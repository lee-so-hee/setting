package com.vod.movit.order.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vod.movit.movie.vo.MovieVO;
import com.vod.movit.mybatis.CartMapper;
import com.vod.movit.mybatis.MovieMapper;
import com.vod.movit.order.vo.CartVO;

@Repository
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	SqlSession sqlSession;

	@Override
	public void insertCart(CartVO cart) {
		// TODO Auto-generated method stub
		CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
		cartMapper.insertCart(cart);
	}

	@Override
	public CartVO getCart() {
		// TODO Auto-generated method stub
		CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
		CartVO cart = cartMapper.getCart();
		return cart;
	}



}
