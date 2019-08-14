package eduWebApp;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.validation.BeanPropertyBindingResult;

import eduWebApp.EducationalGameApplication;
import eduWebApp.controllers.PasswordResetValidator;
import eduWebApp.domain.User;
import eduWebApp.repository.UserRepository;

import static org.mockito.BDDMockito.given;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
public class TestForgotPasswordValidator {
	@MockBean
	private UserRepository userRepository;

	@Test
	public void WhenUsernameFieldIsEmpty() {
		given(userRepository.findByUsername("Username")).willReturn(null);
		EducationalGameApplication.setPasswordResetSection(0);
		User valUser = new User();
		valUser.setUsername("");

		PasswordResetValidator v = new PasswordResetValidator(userRepository);
		BeanPropertyBindingResult errors = new BeanPropertyBindingResult(valUser, "valUser");
		v.validate(valUser, errors);
		assertTrue(errors.hasErrors());
	}

	@Test
	public void usernameNotFound() {
		given(userRepository.findByUsername("Username")).willReturn(null);

		EducationalGameApplication.setPasswordResetSection(0);
		User valUser = new User();
		valUser.setUsername("usernameDont-Exist");

		PasswordResetValidator v = new PasswordResetValidator(userRepository);
		BeanPropertyBindingResult errors = new BeanPropertyBindingResult(valUser, "valUser");
		v.validate(valUser, errors);
		assertTrue(errors.hasErrors());
	}

	@Test
	public void WhenSecurityAnswerFieldIsEmpty() {

		User user1 = new User();
		user1.setUsername("username");
		user1.setSecurityAnswer("testWrongAnswer");

		User user2 = new User();
		user2.setUsername("username");
		user2.setSecurityAnswer("answer");

		given(userRepository.findByUsername("username")).willReturn(user1);
		EducationalGameApplication.setPasswordResetSection(1);
		EducationalGameApplication.setPasswordResetUsername("username");

		PasswordResetValidator v = new PasswordResetValidator(userRepository);
		BeanPropertyBindingResult errors = new BeanPropertyBindingResult(user2, "user2");
		v.validate(user2, errors);
		assertTrue(errors.hasErrors());
	}

	@Test
	public void WhenNewPasswordsDoNotMatch() {
		EducationalGameApplication.setPasswordResetSection(2);

		User valUser = new User();
		valUser.setUsername("username");
		valUser.setPassword("password");
		valUser.setPassword2("testWrongPassword");
		valUser.setSecurityAnswer("answer");

		PasswordResetValidator v = new PasswordResetValidator(userRepository);
		BeanPropertyBindingResult errors = new BeanPropertyBindingResult(valUser, "valUser");
		v.validate(valUser, errors);
		assertTrue(errors.hasErrors());
	}

	@Test
	public void newPasswordsNotMeetingTheCriteria() {
		EducationalGameApplication.setPasswordResetSection(2);

		User valUser = new User();
		valUser.setUsername("username");
		valUser.setPassword("PasswordNotMatchingTheCriteria!!22");
		valUser.setPassword2("PasswordNotMatchingTheCriteria!!22");
		valUser.setSecurityAnswer("answer");

		PasswordResetValidator v = new PasswordResetValidator(userRepository);
		BeanPropertyBindingResult errors = new BeanPropertyBindingResult(valUser, "valUser");
		v.validate(valUser, errors);
		assertTrue(errors.hasErrors());
	}
}
