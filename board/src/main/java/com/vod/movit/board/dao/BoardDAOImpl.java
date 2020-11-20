package com.vod.movit.board.dao;

import java.util.ArrayList;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vod.movit.board.vo.BoardVO;
import com.vod.movit.mybatis.BoardMapper;
@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;
	

	@Override
	public ArrayList<BoardVO> getBoardList() {
		// TODO Auto-generated method stub
		ArrayList<BoardVO> result = new ArrayList<BoardVO>();
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		result = boardMapper.getBoardList();
		return result;
	}


	@Override
	public void updateCountBoard(int bno) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		boardMapper.updateCountBoard(bno);
	}


	@Override
	public BoardVO getBoard(int bno) {
		// TODO Auto-generated method stub
		BoardVO result = new BoardVO();
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		result = boardMapper.getBoard(bno);
		return result;
	}


	@Override
	public void updateBoard(BoardVO board) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		boardMapper.updateBoard(board);
	}


	@Override
	public void deleteBoard(int bno) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		boardMapper.deleteBoard(bno);
	}

}
