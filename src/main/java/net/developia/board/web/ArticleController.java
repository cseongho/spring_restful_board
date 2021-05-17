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
@RequestMapping("board/{boa_no}/{pg}")
public class ArticleController {

	@Autowired
	private BoardService boardService;

	/*@GetMapping()
	public String list() {
		return "redirect:" ;
	} */
	
	@GetMapping("/")
	public void list2() { }
	
	@GetMapping("insert")
	public void insert() {}
	
	@PostMapping("insert")
	public void insert(@ModelAttribute ArticleDTO articleDTO) {}

}
