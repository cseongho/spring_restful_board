package net.developia.board.service;

import java.util.List;

import net.developia.board.dto.BoardDTO;

public interface BoardService {
	List<BoardDTO> getBoardList() throws Exception;

		void insertBoard(BoardDTO boardDTO) throws Exception;
}
