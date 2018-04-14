package net.drs.fotoshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class FrontController {
	
	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("page");

	/*	categoryService.getAllCategories();*/
		
		mv.addObject("title", "Home");
		mv.addObject("userClickedHome", true);
		return mv;
	}
	
	@RequestMapping(value={"/about"})
	public ModelAndView about(){
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "About Us");
		mv.addObject("userClickedAbout", true);
		return mv;
	}
	
	@RequestMapping(value={"/contact"})
	public ModelAndView contact(){
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "Contact Us");
		mv.addObject("userClickedContact", true);
		return mv;
	}
	
	
	@RequestMapping(value={"/test"})
	public ModelAndView test(@RequestParam(value="greeting",required=false) String greeting){
		if(greeting == null) greeting="Default Greeting";
		ModelAndView  mv = new ModelAndView("page");
		mv.addObject("greeting",greeting);
		return mv;
	}

	@RequestMapping(value={"/testpathvariable/{greeting}"})
	public ModelAndView testpathvariable(@PathVariable("greeting") String greeting){
		if(greeting == null) greeting="Default Greeting";
		ModelAndView  mv = new ModelAndView("page");
		mv.addObject("greeting",greeting);
		return mv;
	}


}
