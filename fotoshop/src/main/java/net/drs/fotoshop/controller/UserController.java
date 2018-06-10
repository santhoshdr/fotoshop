package net.drs.fotoshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	
	@RequestMapping("/getAllUsers")
	public ModelAndView getAllUsers (){
		
		
		
		return null;
		
		
	}
	

}
