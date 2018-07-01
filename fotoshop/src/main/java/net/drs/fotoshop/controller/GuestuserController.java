package net.drs.fotoshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class GuestuserController extends BaseController {

	
	@RequestMapping(value={"/guestUser/feedback"})
	public ModelAndView saveFeedback(){
		ModelAndView mv = new ModelAndView("page");
	/*	categoryService.getAllCategories();*/
		mv.addObject("title", "Home");
		
		System.out.println("taking you to home page....GRRRRRRRRRRRR");
		mv.addObject("userClickedHome", true);
		return mv;
	}
}
