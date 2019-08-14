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

import eduWebApp.EducationalGameApplication;
import eduWebApp.domain.User;
import eduWebApp.repository.UserRepository;


@Controller
@RequestMapping("/passwordReset")
public class passwordResetController {
	
		@Autowired
		private UserRepository userRepository;
		

		
		@InitBinder
		protected void initBinder(WebDataBinder binder) {
			binder.addValidators(new PasswordResetValidator(userRepository));
		}
		
		//forgotten password page 

		@RequestMapping("/")
		public String passRecovery(@ModelAttribute("user") User user,Model model) {
			// gets the validtion for the first forgotten password page 
			EducationalGameApplication.setPasswordResetSection(0);
			return "passwordReset";
		}	
// checks if the user is valid by checking if the user exists within the model 
	// if not a valid user they prompt with validation messages 
		// if valid then the user will be progressed to assess if their account is valid  

		@RequestMapping(value ="/securityQuestion", method= RequestMethod.POST)
		public String securityQuestion(@Valid @ModelAttribute("user") User user,BindingResult result, Model model) {
			if(!result.hasErrors()) {
				
				User userToResetPass = userRepository.findByUsername(user.getUsername());
				EducationalGameApplication.setPasswordResetUsername(user.getUsername());
				model.addAttribute("securityQuestion",userToResetPass.getSecurityQuestion());

				
				
				return "securityQuest";
			} else {

				EducationalGameApplication.setPasswordResetSection(0);
				return "passwordReset";
			}
		}
		// checks if the user is valid by checking the security question the user registered with  
		// if not a valid user they prompt with validation messages 
			// if valid then the user will be progressed reset their password and set a new password  
		@RequestMapping("/resetPassword")
		public String forgotPassword(@Valid @ModelAttribute("user") User user,BindingResult result,Model model){
			if(!result.hasErrors()) {
				EducationalGameApplication.setPasswordResetSection(2);
				return "newPassword";
				
			} else {
				EducationalGameApplication.setPasswordResetSection(1);
				User userToResetPass = userRepository.findByUsername(EducationalGameApplication.getPasswordResetUsername());
				model.addAttribute("securityQuestion",userToResetPass.getSecurityQuestion());
				
				return "securityQuest";
			}
		}
		// once the user sets a new password and confirmed the new password 
		// the passwords a validated to see if they match 
		// if the password matches then the new password will get saved to the model 
		// if they dont match then they will have to rest their password again 
		@RequestMapping("/resetPasswordSuccess")
		public String restPasswordSuccess(@Valid @ModelAttribute("user") User user,BindingResult result,Model model){
			if(!result.hasErrors()) {
				User userToResetPass = userRepository.findByUsername(EducationalGameApplication.getPasswordResetUsername());
				userToResetPass.setPassword(user.getPassword());
				userToResetPass.setPassword2(user.getPassword2());
				userRepository.save(userToResetPass);

				EducationalGameApplication.setPasswordResetSection(-1);
				return "redirect:/";
			} else {
				return "newPassword";
			}
			
	    }
		    
		    


}
