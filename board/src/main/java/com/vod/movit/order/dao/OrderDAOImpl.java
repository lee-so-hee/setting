package com.vod.movit.order.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vod.movit.movie.vo.MovieVO;
import com.vod.movit.mybatis.CartMapper;
import com.vod.movit.mybatis.MovieMapper;
import com.vod.movit.mybatis.PayMapper;
import com.vod.movit.order.vo.CartVO;
import com.vod.movit.order.vo.PayVO;

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

	@Override
	public ArrayList<CartVO> getCartList(String user) {
		// TODO Auto-generated method stub
		CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
		ArrayList<CartVO> cartList = cartMapper.getCartList(user);
		return cartList;
	}

	@Override
	public void removeCart(int cno) {
		// TODO Auto-generated method stub
		CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
		cartMapper.deleteCart(cno);
	}

	@Override
	public void addPay(PayVO payVO) {
		// TODO Auto-generated method stub
		PayMapper payMapper = sqlSession.getMapper(PayMapper.class);
		payMapper.insertPay(payVO);
	}

	@Override
	public ArrayList<PayVO> getPayList(String user) {
		// TODO Auto-generated method stub
		ArrayList<PayVO> payList = new ArrayList<PayVO>();
		PayMapper payMapper = sqlSession.getMapper(PayMapper.class);
		payList = payMapper.selectPayList(user);
		return payList;
	}

	@Override
	public PayVO getPay(int cno) {
		// TODO Auto-generated method stub
		PayVO pay = new PayVO();
		PayMapper payMapper = sqlSession.getMapper(PayMapper.class);
		pay = payMapper.selectPay(cno);
		return pay;
	}



}
