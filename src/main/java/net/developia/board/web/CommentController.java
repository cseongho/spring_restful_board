package net.developia.board.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.developia.board.dto.CommentDTO;
import net.developia.board.dto.UserDTO;
import net.developia.board.service.BoardService;

@Slf4j
@Controller
@RequestMapping("board/{boa_no}/{pg}/{art_no}/{cpg}")
public class CommentController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping(value="/", produces="application/json; charset=UTF-8")
	@ResponseBody
	public List<CommentDTO> comment_list(@ModelAttribute CommentDTO commentDTO) throws Exception {
		return boardService.getCommentList(commentDTO);
		
	}
	
	@PostMapping(value="/", produces="application/json; charset=UTF-8")
	@ResponseBody
	public List<CommentDTO> comment_insert(
		@ModelAttribute CommentDTO commentDTO, 
		HttpServletRequest request,
		HttpSession session) {
		
		commentDTO.setCom_ip(request.getRemoteAddr());
		commentDTO.setUserDTO((UserDTO) session.getAttribute("userInfo"));
		
		log.info("comment_insert() 메소드 수행");
		log.info(commentDTO.toString());
		try {
			boardService.insertComment(commentDTO);
			return boardService.getCommentList(commentDTO);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@PostMapping(value="/{com_no}", produces="application/json; charset=UTF-8")
	@ResponseBody
	public List<CommentDTO> comment_update (
			@ModelAttribute CommentDTO commentDTO, 
			HttpServletRequest request,
			HttpSession session) throws Exception {
		commentDTO.setCom_ip(request.getRemoteAddr());
		commentDTO.setUserDTO((UserDTO) session.getAttribute("userInfo"));
		
		log.info("comment_update() 메소드 수행");
		log.info(commentDTO.toString());

		boardService.updateComment(commentDTO);
		return boardService.getCommentList(commentDTO);
	}
	
	@DeleteMapping(value="/{com_no}", produces="application/json; charset=UTF-8")
	@ResponseBody
	public List<CommentDTO> comment_delete(
			@ModelAttribute CommentDTO commentDTO, 
			HttpServletRequest request,
			HttpSession session) throws Exception {
		commentDTO.setCom_ip(request.getRemoteAddr());
		commentDTO.setUserDTO((UserDTO) session.getAttribute("userInfo"));
		
		log.info("comment_delete() 메소드 수행");
		log.info(commentDTO.toString());
		
		boardService.deleteComment(commentDTO);
		return boardService.getCommentList(commentDTO);
	}
	
}
