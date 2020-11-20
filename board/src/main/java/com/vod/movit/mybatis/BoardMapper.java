package com.vod.movit.mybatis;

import java.util.ArrayList;

import com.vod.movit.board.vo.BoardVO;

public interface BoardMapper {
	ArrayList<BoardVO> getBoardList();
	/*
	 * void insertUser(User user); void updateUser(User user); void
	 * deleteUser(String id); User getUpdateUser(String id); User viewUser(User
	 * user); String loginCheck(User user); User selectByEmail(String
	 * userinfo_email); User selectById(String userinfo_id); User
	 * selectByNickname(String userinfo_nickname);
	 */
}
