package eduWebApp;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import org.junit.Before;
import org.junit.Test;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import eduWebApp.EducationalGameApplication;
import eduWebApp.controllers.MatchingController;
import eduWebApp.domain.MatchingQuestionPair;
import eduWebApp.repository.UserRepository;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import static org.mockito.BDDMockito.given;

@WebMvcTest(MatchingController.class)
@RunWith(SpringRunner.class)
public class TestMatching {

  @Autowired
  private MockMvc mockMvc;
  
  @MockBean
  MatchingQuestionPair match;
  
  @MockBean
  private UserRepository userRepository;

  
  
  @Before
  public void before() {
	  given(match.isCorrect("answer"))
      .willReturn(false);  
	  match=new MatchingQuestionPair("", "", "", "", "", "");
	  match.set_ans1("answer");
	  match.set_ans2("answer");
	  match.set_ans3("answer");
	  match.set_ans4("answer");
	  match.set_ans5("answer");
	  match.setCorrectAnswer("answer");    
  }
  
  @Test
  public void englishAccessedNotThroughAQuestion() throws Exception{
    mockMvc.perform(post("/english/").with(user("user").password("password")).param("App", "notAQuestion"))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/"));
  }
  
  @Test
  public void easyEnglish() throws Exception{
	  EducationalGameApplication.setEnglishStarted(false);
	  EducationalGameApplication.setCounter(1);
	  EducationalGameApplication.setCounter2(0);
	  EducationalGameApplication.setCounter3(0);
    mockMvc.perform(post("/english/").with(user("user").password("password")).param("App", "question"))
    .andExpect(status().is(200))
    .andExpect(view().name("english"));
  }
  
  @Test
  public void easyEnglishStartedWithEnglish() throws Exception{
	  EducationalGameApplication.setEnglishStarted(true);
	  EducationalGameApplication.setCounter(1);
	  EducationalGameApplication.setCounter2(0);
	  EducationalGameApplication.setCounter3(0);
    mockMvc.perform(post("/english/").with(user("user").password("password")).param("App", "question"))
    .andExpect(status().is(200))
    .andExpect(view().name("english"));
  }
  

  @Test
  public void EnglishStartedWithMaths() throws Exception{
	  EducationalGameApplication.setEnglishStarted(false);
	  EducationalGameApplication.setCounter(9);
	  EducationalGameApplication.setCounter2(3);
	  EducationalGameApplication.setCounter3(0);
	  mockMvc.perform(post("/english/").with(user("user").password("password")).param("App", "question"))
	    .andExpect(status().is(200))
	    .andExpect(view().name("english"));
  }
  
  @Test
  public void englishEndGameToProgress() throws Exception{
	  EducationalGameApplication.setEnglishStarted(true);
	  EducationalGameApplication.setCounter(10);
	  EducationalGameApplication.setCounter2(10);
	  EducationalGameApplication.setCounter3(10);
	  mockMvc.perform(post("/english/").with(user("user").password("password")).param("App", "question"))
	    .andExpect(status().is(302))
	    .andExpect(redirectedUrl("/english/progress"));
  }
  
  @Test
  public void englishEndGameRedirectToSummary() throws Exception{
	  EducationalGameApplication.setEnglishStarted(false);
	  EducationalGameApplication.setCounter(10);
	  EducationalGameApplication.setCounter2(10);
	  EducationalGameApplication.setCounter3(10);
	  mockMvc.perform(post("/english/").with(user("user").password("password")).param("App", "question"))
	    .andExpect(status().is(302))
	    .andExpect(redirectedUrl("/summary/"));
  }
  
  @Test
  public void ans1() throws Exception{
	EducationalGameApplication.setCounter2(0);
	  EducationalGameApplication.setCounter3(0);

    mockMvc.perform(post("/english/answer").with(user("user").password("password"))
    		.param("ans1", "answer")
    		.param("timer", "10")
    		.param("timerRemaining", "10"))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/english/"));
  }
  
  @Test
  public void ans2() throws Exception{
	EducationalGameApplication.setCounter2(0);
	  EducationalGameApplication.setCounter3(0);

    mockMvc.perform(post("/english/answer").with(user("user").password("password"))
    		.param("ans2", "answer")
    		.param("timer", "10")
    		.param("timerRemaining", "10"))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/english/"));
  }
  
  @Test
  public void ans3() throws Exception{
	EducationalGameApplication.setCounter2(0);
	  EducationalGameApplication.setCounter3(0);

    mockMvc.perform(post("/english/answer").with(user("user").password("password"))
    		.param("ans3", "answer")
    		.param("timer", "10")
    		.param("timerRemaining", "10"))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/english/"));
  }
  
  @Test
  public void ans4() throws Exception{
	EducationalGameApplication.setCounter2(0);
	  EducationalGameApplication.setCounter3(0);
    mockMvc.perform(post("/english/answer").with(user("user").password("password"))
    		.param("ans4", "answer")
    		.param("timer", "10")
    		.param("timerRemaining", "10"))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/english/"));
  }
  
  @Test
  public void ans5() throws Exception{
	EducationalGameApplication.setCounter2(0);
	  EducationalGameApplication.setCounter3(0);
    mockMvc.perform(post("/english/answer").with(user("user").password("password"))
    		.param("ans5", "answer")
    		.param("timer", "10")
    		.param("timerRemaining", "10"))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/english/"));
  }
  
 @Test
  public void progressAccessedNotThroughAQuestion() throws Exception{
    mockMvc.perform(post("/english/progress").with(user("user").password("password"))
    		.param("App", "notQuestion"))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/"));
  }
  
  @Test
  public void progressToSubjectTransition() throws Exception{
    mockMvc.perform(post("/english/progress").with(user("user").password("password"))
    		.param("App", "question"))
    .andExpect(status().is(200))
    .andExpect(view().name("SubjectTransition"));
  }
  
  @Test
  public void skip() throws Exception{
	EducationalGameApplication.setCounter(10);
	EducationalGameApplication.setEnglishStarted(true);
    mockMvc.perform(post("/english/skip").with(user("user").password("password"))
    		.param("App", "notQuestion"))
    .andExpect(status().is(302))
    .andExpect(redirectedUrl("/english/"));
  }
  
  
}