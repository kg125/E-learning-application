package eduWebApp;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import org.junit.Test;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import eduWebApp.EducationalGameApplication;
import eduWebApp.controllers.passwordResetController;
import eduWebApp.domain.User;
import eduWebApp.repository.UserRepository;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.mockito.Mockito;
import static org.mockito.BDDMockito.given;

@WebMvcTest(passwordResetController.class)
@RunWith(SpringRunner.class)
public class TestForgetPassword {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserRepository userRepository;

  @Test
  public void failedUserPassword() throws Exception{

    EducationalGameApplication.setPasswordResetSection(2);

    mockMvc.perform(post("/passwordReset/resetPasswordSuccess").with(user("Guest").password("password"))
        .param("password","password")
        .param("password2","aaaaa"))
        .andExpect(status().is(200))
        .andExpect(view().name("newPassword"));
  }
  
  @Test
  public void UserResetPasswordPage() throws Exception{
    mockMvc.perform(post("/passwordReset/").with(user("Guest").password("password")))
        .andExpect(status().is(200))
        .andExpect(view().name("passwordReset"));
  }
  
  @Test
  public void UserAccessToSecurityQuestionPage() throws Exception{
	  User userAns=new User();
	  userAns.setSecurityQuestion("What is your favourite colour?");
	  userAns.setUsername("UserTest");
	  
	  given(userRepository.findByUsername("UserTest")).willReturn(userAns);
	  
	  mockMvc.perform(post("/passwordReset/securityQuestion").with(user("Guest").password("password"))
				.param("firstName","rob")
				.param("lastName","fowler")
				.param("username","UserTest")
				.param("password","passw")
				.param("password2","passw")
				.param("securityQuestion","What is your favourite colour?")
				.param("securityAnswer","answer"))
        .andExpect(status().is(200))
        .andExpect(view().name("securityQuest"));
  }
  
  @Test
  public void NoUserAccessToSecurityQuestionPage() throws Exception{
      EducationalGameApplication.setPasswordResetSection(0);
	  User userAns=new User();
	  userAns.setSecurityQuestion("What is your favourite colour?");
	  userAns.setUsername("UserTest");
	  
	  given(userRepository.findByUsername("UserTest")).willReturn(null);
	  
	  mockMvc.perform(post("/passwordReset/securityQuestion").with(user("Guest").password("password"))
				.param("username","UserTest"))
        .andExpect(status().is(200))
        .andExpect(view().name("passwordReset"));
  }
  
  @Test
  public void CorrectSecurityQuestionAnswer() throws Exception{
	  User userAns=new User();
	  userAns.setSecurityQuestion("What is your favourite colour?");
	  userAns.setSecurityAnswer("red");
	  userAns.setUsername("UserTest");
	  
	  given(userRepository.findByUsername("UserTest")).willReturn(userAns);
      EducationalGameApplication.setPasswordResetSection(1);
      EducationalGameApplication.setPasswordResetUsername("UserTest");

	  mockMvc.perform(post("/passwordReset/resetPassword").with(user("Guest").password("password"))
				.param("securityAnswer","red")
				.param("username","UserTest")
				.param("securityQuestion", "What is your favourite colour?"))
        .andExpect(status().is(200))
        .andExpect(view().name("newPassword"));
  }
  @Test
  public void IncorrectSecurityQuestionAnswer() throws Exception{
	  User userAns =new User();
	  userAns.setSecurityQuestion("Who is your hero?");
	  userAns.setSecurityAnswer("suoerman");
	  userAns.setUsername("UserTest");
	  
	  given(userRepository.findByUsername("UserTest")).willReturn(userAns);
      EducationalGameApplication.setPasswordResetSection(1);
      EducationalGameApplication.setPasswordResetUsername("UserTest");

	  mockMvc.perform(post("/passwordReset/resetPassword").with(user("Guest").password("password"))
				.param("securityAnswer","batman")
				.param("username","UserTest")
				.param("securityQuestion", "What is your favourite colour?"))
        .andExpect(status().is(200))
        .andExpect(view().name("securityQuest"));
  }
  
  @Test
  public void successfulUserAnswerRedirectsToLanding() throws Exception{
	  User userAns=new User();
	  userAns.setSecurityQuestion("What is your favourite colour?");
	  userAns.setUsername("UserTest");
	  userAns.setSecurityAnswer("answer");
    given(userRepository.findByUsername(Mockito.anyString()))
                .willReturn(userAns);

    mockMvc.perform(post("/passwordReset/resetPasswordSuccess").with(user("Guest").password("password"))
			.param("firstName","rob")
			.param("lastName","fowler")
			.param("username","robbie")
			.param("password","passw")
			.param("password2","passw")
			.param("securityQuestion","Who is your hero?")
			.param("securityAnswer","answer"))
        .andExpect(status().is(302))
        .andExpect(redirectedUrl("/"));
  }


  
}