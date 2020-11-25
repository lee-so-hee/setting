package com.vod.movit.board.svc;

import java.util.ArrayList;

import com.vod.movit.board.vo.BoardVO;

public interface BoardService {

	ArrayList<BoardVO> getBoardList();

	BoardVO getBoard(int bno);

	void modifyBoard(BoardVO board);

	void removeBoard(int bno);

	void addBoard(BoardVO board);

}
