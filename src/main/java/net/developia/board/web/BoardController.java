package net.developia.board.web;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
import net.developia.board.dto.BoardDTO;
import net.developia.board.dto.UserDTO;
import net.developia.board.service.BoardService;


@Slf4j
@Controller
@RequestMapping("board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping
	public String list() {
		return "redirect:board/";
	}
	
	@GetMapping("/")
	public String list(Model model) {
		try {
			List<BoardDTO> list = boardService.getBoardList();
			model.addAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "board/board_list";
	}
	
	@GetMapping("insert")
	public String insert() {
		return "board/board_insert";
	}
	
	@PostMapping("insert")
	public ModelAndView insert(@ModelAttribute BoardDTO boardDTO, HttpSession session) {
		boardDTO.setUserDTO((UserDTO)session.getAttribute("userInfo"));
		try {
			boardService.insertBoard(boardDTO);
			ModelAndView mav = new ModelAndView("result");
			mav.addObject("msg", boardDTO.getBoa_name() + "");
			mav.addObject("url", "./");
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
			ModelAndView mav = new ModelAndView("result");
			mav.addObject("msg", boardDTO.getBoa_name() + "");
			mav.addObject("url", "./");
			return mav;
		}
	}
}