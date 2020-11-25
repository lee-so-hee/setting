package com.vod.movit.board.svc;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vod.movit.board.dao.BoardDAO;
import com.vod.movit.board.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public ArrayList<BoardVO> getBoardList() {
		// TODO Auto-generated method stub
		ArrayList<BoardVO> boardList = boardDAO.getBoardList();
		return boardList;
	}

	@Override
	public BoardVO getBoard(int bno) {
		// TODO Auto-generated method stub
		boardDAO.updateCountBoard(bno);
		BoardVO detail = boardDAO.getBoard(bno);
		return detail;
	}

	@Override
	public void modifyBoard(BoardVO board) {
		// TODO Auto-generated method stub
		boardDAO.updateBoard(board);
	}

	@Override
	public void removeBoard(int bno) {
		// TODO Auto-generated method stub
		boardDAO.deleteBoard(bno);
	}

	@Override
	public void addBoard(BoardVO board) {
		// TODO Auto-generated method stub
		boardDAO.addBoard(board);
	}

}
