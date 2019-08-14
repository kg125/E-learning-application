package eduWebApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HangmanController {
	//useed to display hangman game 
	@RequestMapping(value = {"hangman"} ,  method = RequestMethod.GET)
	 	public ModelAndView getHangman() {
	 		ModelAndView model = new ModelAndView();
	 		model.setViewName("hangman");
	 		return model;
	 	}
	

}
