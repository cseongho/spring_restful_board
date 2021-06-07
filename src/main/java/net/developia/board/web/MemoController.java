package net.developia.board.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
import net.developia.board.dto.MemoDTO;

@Slf4j
@Controller
@RequestMapping("memo")
public class MemoController {

	@RequestMapping(value = "insert", method=RequestMethod.GET)
	public void insert() {}

	@RequestMapping(value = "insert", method=RequestMethod.POST)
	public ModelAndView insert(@Valid @ModelAttribute MemoDTO memoDTO, BindingResult br) {
		log.info(memoDTO.toString());
		
		ModelAndView mav = new ModelAndView();
//		mav.addObject("memoDTO", memoDTO);
		
		if (br.hasErrors()) {
			mav.setViewName("memo/insert");
			return mav;
		} else {
			mav.setViewName("memo/insert_action");
			return mav;
		}
	}

}