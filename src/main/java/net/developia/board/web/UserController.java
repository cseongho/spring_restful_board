package net.developia.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
import net.developia.board.dto.UserDTO;
import net.developia.board.service.UserService;

@Slf4j
@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping()
	public String login() {
		return "user/login";
	}
	
	@PostMapping()
	public ModelAndView login(
			@ModelAttribute UserDTO userDTO) {
		log.info(userDTO.toString());
		
		return null;
	}
}