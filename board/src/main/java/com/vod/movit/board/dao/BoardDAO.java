package com.vod.movit.board.dao;

import java.util.ArrayList;
import java.util.List;

import com.vod.movit.board.vo.BoardVO;

public interface BoardDAO {
	
	ArrayList<BoardVO> getBoardList();

	void updateCountBoard(int bno);

	BoardVO getBoard(int bno);

	void updateBoard(BoardVO board);

	void deleteBoard(int bno);

	void addBoard(BoardVO boardVO);

	
}
