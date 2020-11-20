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

}
