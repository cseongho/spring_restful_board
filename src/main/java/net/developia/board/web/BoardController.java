package net.developia.board.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import net.developia.board.service.BoardService;


@Slf4j
@Controller
@RequestMapping("board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping()
	public String list() {
		return "redirect:board/";
	}
	
	@GetMapping("/")
	public String list2() {
		return "board/board_list";
	}
	
//	@GetMapping("insert")
//	public dtoid insert() {}
//	
//	@PostMapping("insert")
//	public dtoid insert(@ModelAttribute BoardDTO boardDTO) {}
}