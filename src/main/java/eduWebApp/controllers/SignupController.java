package eduWebApp.controllers;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import eduWebApp.EducationalGameApplication;
import eduWebApp.domain.User;
import eduWebApp.repository.UserRepository;
import eduWebApp.service.eduWebAppService;

@Controller
@RequestMapping("/signup")
public class SignupController {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private eduWebAppService service; 
	
	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(new UserSignupValidator(userRepo));
	}
	private List<String> secQuestions = Arrays.asList("----------",
			"What is your favourite colour?",
			"What is your favourite sport?",
			"Who is your cartoon character?",
			"What is your favourite subject?",
			"What is your favourite food?");
	
	@RequestMapping("/")
	public String signup(@ModelAttribute("user") User user,Model model) {
		model.addAttribute("score", "0");
		model.addAttribute("questionsList", (List<String>) this.secQuestions);
		return "signup";
	}	

	@RequestMapping(value="add", params="add", method= RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result,Model model) {
		//(Redirects back to the sign up page if there are errors or proceed to main if no errors occur)
		if (result.hasErrors()) {
			model.addAttribute("questionsList", (List<String>) this.secQuestions);
			model.addAttribute("selectedQuestion", user.getSecurityQuestion());
			return "signup";
			
		} else {

			userRepo.save(user);
			EducationalGameApplication.setUser(user);
			return "redirect:/main/";
		}
	}
	
	
	@RequestMapping(value="add", params = "cancel", method = RequestMethod.POST)
	public String cancelRegistration(@ModelAttribute("user") User user, Model model) {
		return "redirect:/";
	}

}
