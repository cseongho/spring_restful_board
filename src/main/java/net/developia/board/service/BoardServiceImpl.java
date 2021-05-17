package net.developia.board.service;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.developia.board.dao.BoardDAO;
import net.developia.board.dto.ArticleDTO;
import net.developia.board.dto.BoardDTO;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	@Resource(name="boardDAO")
	private BoardDAO boardDAO;

	@Override
	public List<BoardDTO> getBoardList() throws Exception {
		try {
			return boardDAO.getBoardList();
		} catch (Exception e) {
			log.info(e.getMessage());
			throw e;
		}
	}

	@Override
	public void insertBoard(BoardDTO boardDTO) throws Exception {
		try {
			boardDAO.insertBoard(boardDTO);
		} catch (Exception e) {
			log.info(e.getMessage());
			throw e;
		}
	}

	@Override
	public void insertArticle(ArticleDTO articleDTO) throws Exception {
		try {
			boardDAO.insertArticle(articleDTO);
		} catch (Exception e) {
			log.info(e.getMessage());
			throw e;
		}
	}

	@Override
	public BoardDTO getBoard(int boa_no) throws Exception {
		try {
			BoardDTO boardDTO = boardDAO.getBoard(boa_no);
			if (boardDTO == null) {
				throw new RuntimeException("잘못된 게시판 번호입니다.");
			}
			return boardDTO;
		} catch (Exception e) {
			log.info(e.getMessage());
			throw e;
		}
	}

	@Override
	public List<ArticleDTO> getArticleList(int boa_no) throws Exception {
		try {
			return boardDAO.getArticleList(boa_no);
		} catch (Exception e) {
			log.info(e.getMessage());
			throw e;
		}
	}

//	@Override
//	public void updateReadcnt(long art_no) throws Exception {
//		if (boardDAO.updateReadcnt(art_no) == 0) {
//			throw new RuntimeException(art_no +"번 글이 존재하지 않습니다.");
//		}
//	}

	@Override
	public ArticleDTO getDetail(long art_no) throws Exception {
		try {
			ArticleDTO articleDTO = boardDAO.getDetail(art_no);
			if (articleDTO == null) {
				throw new RuntimeException(art_no +"번 글이 존재하지 않습니다.");
			}
			return articleDTO;
		} catch (Exception e) {
			log.info(e.getMessage());
			throw e;
		}
	}

	
}