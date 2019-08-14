package eduWebApp.controllers;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import eduWebApp.EducationalGameApplication;
import eduWebApp.domain.User;
import eduWebApp.repository.UserRepository;



@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
    private UserRepository userRepository;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(new indexValidator(userRepository));
	}
	 //user login
    @RequestMapping("/login")
    public String login(@ModelAttribute("indexFormDto") IndexFormDto indexFormDto) {
    	//System.out.println(EducationalGameApplication.getUser().getFirstName()+"***"+EducationalGameApplication.getUser().getRole());
		if (EducationalGameApplication.getUser() != null && EducationalGameApplication.getUser().getRole().equals("user")) {
			return "redirect:/main/";
		}
		else if (EducationalGameApplication.getUser() != null && EducationalGameApplication.getUser().getRole().equals("admin")) {
			return "redirect:/admin/";
		}
//
	  return "index";
    
    }
    
// when users have logged in that cannot go back to the home page unless they click log out 
	 @RequestMapping("/")
		public String index(Model model) {
			model.addAttribute("indexFormDto", new IndexFormDto());
			if (EducationalGameApplication.getUser() != null && EducationalGameApplication.getUser().getRole().equals("user")) {
				return "redirect:/main/";
			} 
			else if(EducationalGameApplication.getUser() != null && EducationalGameApplication.getUser().getRole().equals("admin") ) {
				return "redirect:/admin/";
//
			}
		    return "Landing";
		}
	 


    
   // login validation
    @RequestMapping(value = "/main",params="login", method = RequestMethod.POST)
    public String main(@Valid @ModelAttribute("indexFormDto") IndexFormDto indexFormDto,BindingResult result,Model model){
    	
    	if(result.hasErrors()) {
    		return "index";
    	}
    	else {
    		EducationalGameApplication.setUser(userRepository.findByUsername(indexFormDto.getUsername()));
    		//System.out.println("message=========="+EducationalGameApplication.getUser().getFirstName()+"***"+EducationalGameApplication.getUser().getRole());
    		if(userRepository.findByUsername(indexFormDto.getUsername()).getRole().equals("user")) {
    			
    			return "redirect:/main/";
    		}

    		else if(userRepository.findByUsername(indexFormDto.getUsername()).getRole().equals("admin")) {
    			
    			return "redirect:/admin/";
    		}
    		
    	}
    	return "index";
    }
    // admin login validation 
    @RequestMapping(value = "/admin",params="login", method = RequestMethod.POST)
    public String Adminmain(@Valid @ModelAttribute("indexFormDto") IndexFormDto indexFormDto,BindingResult result,Model model){
    	
    	if(result.hasErrors()) {
    		return "index";
    	}
    	else {
    		EducationalGameApplication.setUser(userRepository.findByUsername(indexFormDto.getUsername()));
if(userRepository.findByUsername(indexFormDto.getUsername()).getRole().equals("admin")) {
    			
	return "redirect:/admin/";
    		}
	    	return "index";
    	}
    }
    
    
    
    @RequestMapping(value = "/main",params="signup", method = RequestMethod.POST)
    public String signup(Model model){
    	
    	return "redirect:/signup/";
    }
//creating guest user 
    @RequestMapping(value = "/main", params="guest",method = RequestMethod.POST)
    public String loginGuest( @ModelAttribute("indexFormDto") IndexFormDto indexFormDto,Model model){
		if (userRepository.findByUsername("Guest") == null) {
			userRepository.save(new User(-1,"Guest","Guest","Guest","Guest","Guest","Guest","Guest","user"));
		}
		EducationalGameApplication.setUser(userRepository.findByUsername("Guest"));
	    	return "redirect:/main/";
    }
    
    @RequestMapping(value = "/guest")
    public String guest(Model model){
		if (userRepository.findByUsername("Guest") == null) {
			userRepository.save(new User(-1,"Guest","Guest","Guest","Guest","Guest","Guest","Guest","user"));
		}
		EducationalGameApplication.setUser(userRepository.findByUsername("Guest"));
	    	return "redirect:/main/";
    }
   
    //admin user 
    @RequestMapping(value = "/admin",params="admin", method = RequestMethod.POST)
    public String loginAdmin(@ModelAttribute("indexFormDto") IndexFormDto indexFormDto, Model model){
  	  if (userRepository.findByUsername("Admin") == null) {
  			userRepository.save(new User(-1,"Admin","Admin","Admin","Admin","Admin","Admin","Admin","admin"));
  		}
  	  EducationalGameApplication.setUser(userRepository.findByUsername("Admin"));
    	return "redirect:/admin/";
  	    //	model.addAttribute("username",  "admin");
  	    
    }
    @RequestMapping(value = "/admin")
    public String admin(Model model){
  		if (userRepository.findByUsername("Admin") == null) {
  			userRepository.save(new User(-1,"Admin","Admin","Admin","Admin","Admin","Admin","Admin","admin"));
  		}
  		EducationalGameApplication.setUser(userRepository.findByUsername("Admin"));
  	    	return "redirect:/admin/";
    
    }
   
    //password recovery
    @RequestMapping(value= "/main", params="passwordReset", method = RequestMethod.POST)
    public String forgotPassword(Model model){
	    	
	    	return "redirect:/passwordReset/";
    } 
    
    // user logout 
  @RequestMapping(value= "/logout", method = RequestMethod.POST)
  public String logout(Model model){
	  if (EducationalGameApplication.getUser() != null && EducationalGameApplication.getUser().getRole().equals("user")|| EducationalGameApplication.getUser().getRole().equals("admin")) {
		  EducationalGameApplication.setUser(null); 
			return "redirect:/";
		}
  		
  	
	   return "redirect:/";
	    
  }

    
    

// redirecting to matching game 
    @RequestMapping(value="/progress-english")
	public String progressEnglish(Model model,RedirectAttributes rattrs) {
		EducationalGameApplication.setEnglishScore(0);
	    rattrs.addFlashAttribute("App", "question");

		return "redirect:/english/";
	}
	// redirection to numbers game
	@RequestMapping(value="/progress-maths")
	public String progressMaths(Model model,RedirectAttributes rattrs) {
		EducationalGameApplication.setMathScore(0);
	    rattrs.addFlashAttribute("App", "question");

		return "redirect:/maths/";
    }
    
    

}