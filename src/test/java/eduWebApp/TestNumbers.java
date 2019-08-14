package eduWebApp;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import org.junit.Before;
import org.junit.Test;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import eduWebApp.EducationalGameApplication;
import eduWebApp.controllers.NumbersController;
import eduWebApp.domain.User;
import eduWebApp.repository.UserRepository;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(NumbersController.class)
@RunWith(SpringRunner.class)
public class TestNumbers {
	
	@MockBean
	  private UserRepository userRepository;

  @Autowired
  private MockMvc mockMvc;

  @Before
  public void before() {
	  EducationalGameApplication.getNumberQuestions().setAnswer(2);  
  }
  
  @Test
  public void mathsWithNoUserLoggedIn() throws Exception{
	  EducationalGameApplication.setUser(null);
	  mockMvc.perform(post("/maths/").with(user("user").password("password")))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/login"));
  }
  
  @Test
  public void mathsAccessedNotThroughAQuestion() throws Exception{
    mockMvc.perform(post("/maths/").with(user("user").password("password")).param("App", "notAQuestion"))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/"));
  }
  

  
  @Test
  public void easyMathsQuestionsStartedWithNumbersGameMode() throws Exception{
	  User user=new User();
	  user.setUsername("UserTest");
	  EducationalGameApplication.setUser(user);
	  EducationalGameApplication.setEnglishStarted(false);
	  EducationalGameApplication.setCounter(1);
	  EducationalGameApplication.setCounter2(0);
	  EducationalGameApplication.setCounter3(0);
    mockMvc.perform(post("/maths/").with(user("user").password("password")).param("App", "question"))
    .andExpect(status().is(200))
    .andExpect(view().name("maths"));
  }
  

  
  @Test
  public void mathsMediumStartedWithEnglish() throws Exception{
	  User user=new User();
	  user.setUsername("UserTest");
	  EducationalGameApplication.setUser(user);
	  EducationalGameApplication.setEnglishStarted(true);
	  EducationalGameApplication.setCounter(10);
	  EducationalGameApplication.setCounter2(5);
	  EducationalGameApplication.setCounter3(0);
	  mockMvc.perform(post("/maths/").with(user("user").password("password")).param("App", "question"))
	    .andExpect(status().is(200))
	    .andExpect(view().name("maths"));
  }
  
  @Test
  public void NumbersEndGameModeToSummary() throws Exception{
	  EducationalGameApplication.setEnglishStarted(true);
	  EducationalGameApplication.setCounter(10);
	  EducationalGameApplication.setCounter2(10);
	  EducationalGameApplication.setCounter3(10);
	  mockMvc.perform(post("/maths/").with(user("user").password("password")).param("App", "question"))
	  .andExpect(status().is(302))
	    .andExpect(redirectedUrl("/summary/"));
  }
  
  @Test
  public void ans1() throws Exception{
	EducationalGameApplication.getNumberQuestions().setAns1(2);
	EducationalGameApplication.setCounter2(0);
	EducationalGameApplication.setCounter3(0);
    mockMvc.perform(post("/maths/answer").with(user("user").password("password"))
    		.param("ans1", "")
    		.param("timer", "10")
    		.param("timerRemaining", "10"))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/maths/"));
  }
  @Test
  public void ans2() throws Exception{
	EducationalGameApplication.getNumberQuestions().setAns2(2);
	EducationalGameApplication.setCounter2(0);
	EducationalGameApplication.setCounter3(0);
    mockMvc.perform(post("/maths/answer").with(user("user").password("password"))
    		.param("ans2", "")
    		.param("timer", "10")
    		.param("timerRemaining", "10"))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/maths/"));
  }
  @Test
  public void ans3() throws Exception{
	  EducationalGameApplication.getNumberQuestions().setAns3(2);
	  EducationalGameApplication.setCounter2(0);
	  mockMvc.perform(post("/maths/answer").with(user("user").password("password"))
	    		.param("ans3", "")
	    		.param("timer", "10")
	    		.param("timerRemaining", "10"))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/maths/"));
  }
  @Test
  public void ans4() throws Exception{
	  EducationalGameApplication.getNumberQuestions().setAns4(2);
	  EducationalGameApplication.setCounter2(0);
	  EducationalGameApplication.setCounter3(0);

	  mockMvc.perform(post("/maths/answer").with(user("user").password("password"))
	    		.param("ans4", "")
	    		.param("timer", "10")
	    		.param("timerRemaining", "10"))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/maths/"));
  }
  
  @Test
  public void skip() throws Exception{
	  EducationalGameApplication.getNumberQuestions().setAns4(2);
	  EducationalGameApplication.setCounter2(0);
	  mockMvc.perform(post("/maths/skip").with(user("user").password("password")))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/maths/"));
  }
  
  @Test
  public void NumbersGameModeRedirect() throws Exception{
	  mockMvc.perform(post("/maths/progress").with(user("user").password("password")).param("App", "notQuestion"))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/"));
  }
  
  @Test
  public void NumbersGameModeSubjectTransition() throws Exception{
	 mockMvc.perform(post("/maths/progress").with(user("user").password("password")).param("App", "question"))
	    .andExpect(status().is(200))
	    .andExpect(view().name("SubjectTransition"));
  }
  
  
}