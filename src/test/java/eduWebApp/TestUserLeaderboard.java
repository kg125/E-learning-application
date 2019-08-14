package eduWebApp;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;

import org.junit.Test;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import eduWebApp.EducationalGameApplication;
import eduWebApp.controllers.LeaderboardController;
import eduWebApp.domain.User;
import eduWebApp.repository.UserRepository;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;

import static org.mockito.BDDMockito.given;

@WebMvcTest(LeaderboardController.class)
@RunWith(SpringRunner.class)
public class TestUserLeaderboard {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserRepository userRepository;
 

  @Test
  public void showLeaderboard() throws Exception{
	  ArrayList<User> users = new ArrayList<User>();
	  User user1=new User();
	  User user2=new User();
	  user1.setHighScore(9);
	  user2.setHighScore(8);
	  users.add(user1);
	  users.add(user2);
	  given(userRepository.findByHighestScore()).willReturn(users);
	  EducationalGameApplication.setUser(null);
	  mockMvc.perform(post("/leaderboard/").with(user("user").password("password")))
	  .andExpect(status().is(200))
      .andExpect(view().name("leaderboard"));
  }
}