package eduWebApp.controllers;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import eduWebApp.domain.User;
import eduWebApp.repository.UserRepository;

public class indexValidator implements Validator {

	UserRepository userRepo;
	
	public indexValidator(UserRepository userRepository) {
		this.userRepo = userRepository;
	}
	public boolean supports(Class<?> clazz) {
		return IndexFormDto.class.equals(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {

		IndexFormDto indexDto = (IndexFormDto) target;
		if (indexDto.getUsername().toLowerCase().equals("guest")) {
			errors.rejectValue("username","",indexDto.getUsername() +" is not a valid login.");
		
		}
				else {
			User validUser = userRepo.findByUsername(indexDto.getUsername());
			
			
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,"username", "" ,"Field cannot be empty.");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password", "" ,"Field cannot be empty.");
		
		
		if (validUser == null && !indexDto.getPassword().isEmpty() && !indexDto.getUsername().isEmpty()){
			errors.rejectValue("username", "", "User not found");
		} else if (!indexDto.getUsername().isEmpty() && !indexDto.getPassword().isEmpty() && (!validUser.getPassword().equals(indexDto.getPassword()))) {
			
			errors.rejectValue("username","","Wrong username or password.");
		}
		
		
	}
	}
}
