package net.developia.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public void detail() {}
	
	@GetMapping("/update")
	public void update() {}
	
	@PostMapping("/update")
	public void update(@ModelAttribute ArticleDTO articleDTO) {}
	
	@GetMapping("/delete")
	public void delete(long no) {}
}