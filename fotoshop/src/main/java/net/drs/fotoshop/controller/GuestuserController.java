package net.drs.fotoshop.controller;

import net.drs.fotoshopbackend.dto.Comments;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class GuestuserController extends BaseController {
	/*@Autowired
	ICommentsService commentsService;
	*/
	@RequestMapping(value="/guest/contact",method=RequestMethod.POST)
	public ModelAndView saveFeedback(@ModelAttribute Comments comments){
		ModelAndView mv = new ModelAndView("page");
	/*	categoryService.getAllCategories();*/
		mv.addObject("title", "Home");
		mv.addObject("userClickedHome", true);
		
		comments.setComment("Comments");
		//comments.setComment("Comments");
		
	//	commentsService.saveComment(comments);
		
		
		return mv;
	}
}
