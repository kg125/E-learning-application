package eduWebApp.controllers;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import eduWebApp.EducationalGameApplication;
import eduWebApp.domain.User;
import eduWebApp.repository.UserRepository;

public class PasswordResetValidator implements Validator {
	UserRepository userRepository;
	
	
	public PasswordResetValidator(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	@Override
	public void validate(Object target, Errors errors) {
		
		User indexDto= (User) target;
		// handles all valdation messages on the first password reset screen
		if (EducationalGameApplication.getPasswordResetSection() == 0) { 
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,"username", "" ,"Field cannot be empty.");
			if (!indexDto.getUsername().isEmpty() && userRepository.findByUsername(indexDto.getUsername()) == null) {
				errors.rejectValue("username","","Username was not found.");
			}
			// handles all valdation messages on the second password reset screen
		} else if (EducationalGameApplication.getPasswordResetSection() == 1) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,"securityAnswer", "" ,"Field cannot be empty.");
			if (!indexDto.getSecurityAnswer().isEmpty() && !userRepository.findByUsername(EducationalGameApplication.getPasswordResetUsername()).getSecurityAnswer().equals(indexDto.getSecurityAnswer())) {
				errors.rejectValue("securityAnswer","","Answer was incorrect.");
			}
			// handles all valdation messages on the last password reset screen
		} else if (EducationalGameApplication.getPasswordResetSection() == 2) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password", "" ,"Field cannot be empty.");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password2", "" ,"Field cannot be empty.");
			if ((!indexDto.getPassword().equals(indexDto.getPassword2())) && 
					!indexDto.getPassword().isEmpty() && !indexDto.getPassword2().isEmpty() ) {
				
				
				errors.rejectValue("password", "","Passwords must match.");
			} else {
				if (indexDto.passwordFormat(indexDto.getPassword()) == false) {
					errors.rejectValue("password", "", "4-12 characters, no numbers or symbols.");
				}
			}
		}
		
		
		
		
		
		
	}

}
