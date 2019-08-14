package eduWebApp;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import org.junit.Before;
import org.junit.Test;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import eduWebApp.EducationalGameApplication;
import eduWebApp.controllers.IndexController;
import eduWebApp.domain.User;
import eduWebApp.repository.UserRepository;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import static org.mockito.BDDMockito.given;

@WebMvcTest(IndexController.class)
@RunWith(SpringRunner.class)
public class TestIndex {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserRepository userRepository;
  
  @Before
  public void before() {	  
	  
	 
	  User user=new User();
	  user.setPassword("passwordTest");
	  user.setUsername("UserTest");
	  given(userRepository.findByUsername("UserTest")).willReturn(user);
	  EducationalGameApplication.setUser(user);
	  userRepository.save(user);
	  
  }

  @Test
  public void WhenNoUserHasLoggedIn() throws Exception{
	  EducationalGameApplication.setUser(null);
	  
    mockMvc.perform(post("/").with(user("user").password("password")))
    .andExpect(status().is(200))
    .andExpect(view().name("Landing"));
  }
  
  

  @Test
  public void loginWithExistingUserAndIncorrectPassword() throws Exception{
	  User valUser=new User();
	  valUser.setUsername("UserTest");
	  valUser.setPassword("passwordTest");
	  
	 given(userRepository.findByUsername("UserTest")).willReturn(valUser);
	 mockMvc.perform(post("/main").with(user("user").password("password"))
	    	.param("login","")
    		.param("username", "UserTest")
    		.param("password","wrongTestPassword"))
	    .andExpect(status().is(200)) // url status ok 
	    .andExpect(view().name("index"));
  }

  @Test
  public void signup() throws Exception{
    mockMvc.perform(post("/main").with(user("user").password("password"))
    		.param("signup",""))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/signup/"));
  }
  
  @Test
  public void loginWithGuestUser() throws Exception{
    mockMvc.perform(post("/main").with(user("user").password("password"))
    		.param("login","")
    		.param("username", "Guest")
    		.param("password","testPassword"))
    .andExpect(status().is(200))
    .andExpect(view().name("index"));
  }
  @Test
  public void loginWithAdminUser() throws Exception{
    mockMvc.perform(post("/main").with(user("user").password("password"))
    		.param("login","")
    		.param("username", "Admin")
    		.param("password","testPassword"))
    .andExpect(status().is(200))
    .andExpect(view().name("index"));
  }
  
  @Test
  public void UserloginWithErrors() throws Exception{
    mockMvc.perform(post("/main").with(user("user").password("password"))
    		.param("login","")
    		.param("username", "UserTes")
    		.param("password","passwordTest"))
    .andExpect(status().is(200))
    .andExpect(view().name("index"));
  }
  
  @Test
  public void forgotPassword() throws Exception{
    mockMvc.perform(post("/main").with(user("user").password("password"))
    		.param("passwordReset", ""))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/passwordReset/"));
  }
  

}