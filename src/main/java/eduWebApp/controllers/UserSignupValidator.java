package eduWebApp.controllers;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import eduWebApp.domain.User;
import eduWebApp.repository.UserRepository;

public class UserSignupValidator implements Validator {
	UserRepository userRepo;

	public UserSignupValidator(UserRepository userRepository) {
		this.userRepo = userRepository;
	}

	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User indexDto = (User) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "", "This Field cannot be empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "", "This Field cannot be empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "", "This Field cannot be empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "", "This Field cannot be empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password2", "", "This Field cannot be empty.");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "role", "", "This Field cannot be empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "securityAnswer", "", "Field cannot be empty.");

		if (indexDto.nameFormat(indexDto.getFirstName()) == false && !indexDto.getFirstName().isEmpty()) {
			errors.rejectValue("firstName", "", "Use letters only.");
		}
		if (indexDto.nameFormat(indexDto.getLastName()) == false && !indexDto.getLastName().isEmpty()) {

			errors.rejectValue("lastName", "", "Use letters only.");

		}
		if (indexDto.getSecurityQuestion().equals("------------")) {
			errors.rejectValue("securityQuestion", "", "Please select a security question.");
		}

		if ((!indexDto.getPassword().equals(indexDto.getPassword2())) && !indexDto.getPassword().isEmpty()
				&& !indexDto.getPassword2().isEmpty()) {

			errors.rejectValue("password", "", "Passwords must match.");

		} else {

			if (indexDto.passwordFormat(indexDto.getPassword()) == false) {

				errors.rejectValue("password", "", "4-12 characters, no numbers or other symbols.");

			}

		}

		if (userRepo.findByUsername(indexDto.getUsername()) != null && !indexDto.getUsername().toLowerCase().equals("guest")) {
			errors.rejectValue("username", "","Username is Unavailable Try a different one .");
		}
		if (indexDto.getUsername().toLowerCase().equals("guest") || indexDto.getUsername().toLowerCase().contains("guest")) {
			errors.rejectValue("username", "","Username is Unavailable Try a different one "+indexDto.getUsername()+".");
		}
		if (userRepo.findByUsername(indexDto.getUsername()) != null && !indexDto.getUsername().toLowerCase().equals("admin")) {
			errors.rejectValue("username", "","Username is Unavailable Try a different one .");
		}
		if (indexDto.getUsername().toLowerCase().equals("admin") || indexDto.getUsername().toLowerCase().contains("admin")) {
			errors.rejectValue("username", ""," Username is Unavailable Try a different one. "+indexDto.getUsername()+".");
		}
		if (indexDto.usernameFormat(indexDto.getUsername()) == false) {
			errors.rejectValue("username", "","4-15 characters or numbers, no symbols");
		}

	}

}