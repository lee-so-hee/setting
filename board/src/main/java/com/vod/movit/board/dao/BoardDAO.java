package com.vod.movit.board.dao;

import java.util.List;

import com.vod.movit.board.vo.BoardVO;

public interface BoardDAO {
	
	List<BoardVO> select() throws Exception;
	
}
