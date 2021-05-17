package net.developia.board.dao;

import java.sql.SQLException;
import java.util.List;

import net.developia.board.dto.BoardDTO;

public interface BoardDAO {

	List<BoardDTO> getBoardList() throws SQLException;

	void insertBoard(BoardDTO boardDTO) throws SQLException;

}
