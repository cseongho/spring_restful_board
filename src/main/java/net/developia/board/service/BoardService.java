package net.developia.board.service;

import java.util.List;

import net.developia.board.dto.ArticleDTO;
import net.developia.board.dto.BoardDTO;
import net.developia.board.dto.CommentDTO;

public interface BoardService {
	List<BoardDTO> getBoardList() throws Exception;

	void insertBoard(BoardDTO boardDTO) throws Exception;

	void insertArticle(ArticleDTO articleDTO) throws Exception;

	BoardDTO getBoard(int boa_no) throws Exception;

	List<ArticleDTO> getArticleList(int boa_no) throws Exception;

	ArticleDTO getDetail(long art_no) throws Exception;

	void updateReadcnt(long art_no) throws Exception;

	void deleteArticle(ArticleDTO articleDTO) throws Exception;

	void updateArticle(ArticleDTO articleDTO) throws Exception;

	void insertComment(CommentDTO commentDTO) throws Exception;
	
	List<CommentDTO> getCommentList(CommentDTO commentDTO) throws Exception;
	
	void deleteComment(CommentDTO commentDTO) throws Exception;
	
	void updateComment(CommentDTO commentDTO) throws Exception;
}
