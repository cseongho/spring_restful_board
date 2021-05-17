package net.developia.board.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
import net.developia.board.dto.ArticleDTO;
import net.developia.board.dto.BoardDTO;
import net.developia.board.dto.UserDTO;
import net.developia.board.service.BoardService;

@Slf4j
@Controller
@RequestMapping("board/{boa_no}/{pg}")
public class ArticleController {

	@Autowired
	private BoardService boardService;

	/*@GetMapping()
	public String list() {
		return "redirect:" ;
	} */
	
	@GetMapping("insert")
	public String insert() {
		return "board/insert";
	}
	
	@PostMapping("insert")
	public ModelAndView insert(
		@ModelAttribute ArticleDTO articleDTO, 
		HttpSession session,
		HttpServletRequest request) {
		
		articleDTO.setArt_ip(request.getRemoteAddr());
		articleDTO.setUserDTO((UserDTO)session.getAttribute("userInfo"));
		log.info(articleDTO.toString());
		try {
			boardService.insertArticle(articleDTO);
			return new ModelAndView("redirect:./");
		} catch (Exception e) {
			e.printStackTrace();
			ModelAndView mav = new ModelAndView("result");
			mav.addObject("msg","입력 실패");
			mav.addObject("url","javascript:history.back();");
			return mav;
		}
	}
	
	@GetMapping("/")
	public String list(
		@PathVariable int boa_no, 
		Model model) {
		
		try {
			BoardDTO boardDTO = boardService.getBoard(boa_no);
			
			List<ArticleDTO> list= boardService.getArticleList(boa_no);
			model.addAttribute("boardDTO", boardDTO);
			model.addAttribute("list", list);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "board/list";
	}
	

}
