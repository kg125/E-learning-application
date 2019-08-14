package eduWebApp.controllers;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import eduWebApp.EducationalGameApplication;





@Controller
@RequestMapping("/main")
public class MainController {

	
// used to show usename on the main page 
	@RequestMapping("/")
	 public String main(Model model) {
		if (EducationalGameApplication.getUser() == null) {
			return "redirect:/login";
		}
		model.addAttribute("username",  EducationalGameApplication.getUser().getUsername());
        return "main";
    }
	
	// hangman game 
		@RequestMapping(value= "/start-hangman", method = RequestMethod.GET)
	    public String hangman(Model model) {
			if (EducationalGameApplication.getUser() == null) {
				return "redirect:/login";
			}
			model.addAttribute("username",  EducationalGameApplication.getUser().getUsername());

	    	
			return "hangman";
	    	
	    }
	//mathchig game 
	@RequestMapping(value="/start-english/")
	public String startEnglish(Model model,RedirectAttributes rattrs) {
		EducationalGameApplication.setAskedQuestions(new HashSet<String>());
		EducationalGameApplication.setCounter(0);
		EducationalGameApplication.setCounter2(0);
		EducationalGameApplication.setCounter3(0);
		EducationalGameApplication.setTimerRemaining(0);
		EducationalGameApplication.setEnglishScore(0);
		EducationalGameApplication.setEnglishStarted(true);
	    rattrs.addFlashAttribute("App", "question");

		return "redirect:/english/";
	}

	

	
	@RequestMapping("english")
	public String english(Model model) {
		if (EducationalGameApplication.getUser() == null) {
			return "redirect:/login";
		}
		return "redirect:/english/";

}
	// numbers game 
		@RequestMapping(value="/start-maths/")
		public String startMaths(Model model,RedirectAttributes rattrs) {
			EducationalGameApplication.setMathScore(0);
			EducationalGameApplication.setCounter(0);
			EducationalGameApplication.setCounter2(0);
			EducationalGameApplication.setCounter3(0);
			EducationalGameApplication.setTimerRemaining(0);
			EducationalGameApplication.setEnglishStarted(false);
		    rattrs.addFlashAttribute("App", "question");

			return "redirect:/maths/";
		}
	// user exam 
	@RequestMapping(value= "/start-exam/", method = RequestMethod.GET)
    public String exam(	Model model ,RedirectAttributes rattrs) {
		EducationalGameApplication.setExamStarted(true);
	    rattrs.addFlashAttribute("App", "question");

		if (EducationalGameApplication.getUser() == null) {	
			return "redirect:/login";
		}
    	

		return "redirect:/exam/";
    	
    }

  
}
