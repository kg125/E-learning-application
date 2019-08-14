package eduWebApp;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;

import org.junit.Test;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.validation.BeanPropertyBindingResult;

import eduWebApp.EducationalGameApplication;
import eduWebApp.controllers.MainController;
import eduWebApp.controllers.UserSignupValidator;
import eduWebApp.domain.User;
import eduWebApp.repository.UserRepository;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@WebMvcTest(MainController.class)
@RunWith(SpringRunner.class)
public class TestMain {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserRepository userRepository;

  @Test
  public void mainWithNoUserLoggedIn() throws Exception{
	  EducationalGameApplication.setUser(null);
	  mockMvc.perform(post("/main/").with(user("user").password("password")))
	  .andExpect(status().is(302))
      .andExpect(redirectedUrl("/login"));
  }
  
  @Test
  public void mainWithUserLoggedIn() throws Exception{
	  User user=new User();
	  user.setUsername("UserTest");
	  EducationalGameApplication.setUser(user);
	  mockMvc.perform(post("/main/").with(user("user").password("password")))
	  .andExpect(status().is(200))
      .andExpect(view().name("main"));
  }
  @Test
  public void choseNumbers() throws Exception{
	  mockMvc.perform(post("/main/start-maths/").with(user("user").password("password")))
	  .andExpect(status().is(302))
      .andExpect(redirectedUrl("/maths/"));
  }
  
  @Test
  public void choseMatching() throws Exception{
	  mockMvc.perform(post("/main/start-english/").with(user("user").password("password")))
	  .andExpect(status().is(302))
      .andExpect(redirectedUrl("/english/"));
  }
  @Test
  public void choseExam() throws Exception{
	  mockMvc.perform(post("/main/start-exam/").with(user("user").password("password")))
	  .andExpect(status().is(302))
      .andExpect(redirectedUrl("/exam/"));
  }
  @Test
  public void chosehangman() throws Exception{
	  mockMvc.perform(post("/main/start-hangman/").with(user("user").password("password")))
	  .andExpect(status().is(302))
      .andExpect(redirectedUrl("hangman"));
  }
 
}