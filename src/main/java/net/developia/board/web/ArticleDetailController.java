package net.developia.board.web;

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
import net.developia.board.dto.UserDTO;
import net.developia.board.service.BoardService;

@Slf4j
@Controller
@RequestMapping("board/{boa_no}/{pg}/{art_no}")
public class ArticleDetailController {
		
	@Autowired
	private BoardService boardService;

	@GetMapping("/")
	public String detail(
		@PathVariable int boa_no, 
		@PathVariable long pg, 
		@PathVariable long art_no,
		Model model) {
		
		log.info("" + boa_no);
		log.info("" + pg);
		log.info("" + art_no);
		
		try {
			boardService.updateReadcnt(art_no);
			ArticleDTO articleDTO = boardService.getDetail(art_no);
			model.addAttribute("articleDTO", articleDTO);
			return "board/detail";
		} catch (Exception e) {
			e.printStackTrace();

			model.addAttribute("msg", e.getMessage());
			model.addAttribute("url", "../");
			return "result";
		}
	}
	
	@GetMapping("/update")
	public void update() {}
	
	@PostMapping("/update")
	public void update(@ModelAttribute ArticleDTO articleDTO) {}
	
	@GetMapping("/delete")
	public ModelAndView delete(@ModelAttribute ArticleDTO articleDTO, HttpSession session) {
		articleDTO.setUserDTO((UserDTO)session.getAttribute("userInfo"));
		
		try {
			boardService.deleteArticle(articleDTO);
			ModelAndView mav = new ModelAndView("result");
			mav.addObject("msg", articleDTO.getArt_no() + "번 게시물이 삭제되었습니다.");
			mav.addObject("url", "../");
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
			ModelAndView mav = new ModelAndView("result");
			mav.addObject("msg", e.getMessage());
			mav.addObject("url", "javascript:history.back();");
			return mav;
		}
	}
	
}