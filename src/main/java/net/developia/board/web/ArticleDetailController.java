package net.developia.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import net.developia.board.dto.ArticleDTO;
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
		
		log.info("게시판 번호 : " + boa_no);
		log.info("페이지 번호 : " + pg);
		log.info("게시물 번호 : " + art_no);
		
		try {
			//boardService.updateReadcnt(art_no);
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
	public void delete(long no) {}
	
}