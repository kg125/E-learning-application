package eduWebApp;

import org.junit.Before;
import org.junit.Test;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import eduWebApp.EducationalGameApplication;
import eduWebApp.controllers.SummaryController;
import eduWebApp.domain.User;
import eduWebApp.repository.UserRepository;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.HashSet;

import org.mockito.Mockito;
import static org.mockito.BDDMockito.given;

@WebMvcTest(SummaryController.class)
@RunWith(SpringRunner.class)
public class TestSummary {

  @Autowired
  private MockMvc mockMvc;
 
  @MockBean
  private UserRepository userRepository;
  
  @MockBean
  private User user;
  
  private User user2;
  
  private User highest;
  
  HashSet<User> users;
  
  @Before
  public void before() {
	  users=new HashSet<User>();
	  ArrayList<User> usersArray = new ArrayList<User>();
	 user=new User();
	 user.setUsername("User1");
	 user.setHighScore(15);
	 user.setEnglishScore(9);
	 user.setMathsScore(9);
	 users.add(user);
	 user2=new User();
	 user2.setUsername("User2");
	 user2.setHighScore(12);
	 user2.setEnglishScore(9);
	 user2.setMathsScore(9);
	 users.add(user2);
	 usersArray.add(user);
	 usersArray.add(user2);
	 highest=null;
	  
	 EducationalGameApplication.setUser(user);
	  EducationalGameApplication.setEnglishScore(12);
	  EducationalGameApplication.setMathScore(12);
	  given(userRepository.findAll()).willReturn(users);
	  given(userRepository.findByUsername(Mockito.anyString())).willReturn(user2); 
	  given(userRepository.findByHighestScore()).willReturn(usersArray);
  }
  
  @Test
  public void summaryForAUserWithNotHighestScoreEver() throws Exception{
    mockMvc.perform(post("/summary/").with(user("user").password("password")))
    .andExpect(status().is(200))
    .andExpect(view().name("Summary"));
  }
  
  @Test
  public void summaryForAUserWithBestScoreEver() throws Exception{
	  EducationalGameApplication.setEnglishScore(1);
	  EducationalGameApplication.setMathScore(1);
    mockMvc.perform(post("/summary/").with(user("user").password("password")))
    .andExpect(status().is(200))
    .andExpect(view().name("Summary"));
  }
  
  @Test
  public void summaryAsGuest() throws Exception{
	  User guest=new User();
	  guest.setUsername("Guest");
	  EducationalGameApplication.setUser(guest);
    mockMvc.perform(post("/summary/").with(user("Guest").password("password")))
    .andExpect(status().is(200))
    .andExpect(view().name("Summary"));
  }
  
  @Test
  public void signupToSaveScore() throws Exception{
    mockMvc.perform(post("/summary/signup").with(user("user").password("password")))
    .andExpect(status().is(200))
    .andExpect(view().name("signup"));
  }
}