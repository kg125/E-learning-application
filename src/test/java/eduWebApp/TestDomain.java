package eduWebApp;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import eduWebApp.controllers.IndexFormDto;
import eduWebApp.domain.MatchingQuestionPair;
import eduWebApp.domain.User;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class TestDomain {
	
	@Test
	public void IndexFormDtoTest() {
		IndexFormDto indexFormDto= new IndexFormDto();
		indexFormDto.setUsername("username");
		indexFormDto.setPassword("password");		
		assertThat(indexFormDto.getUsername().equals("username")&&indexFormDto.getPassword().equals("password"));
	}
	
	@Test
	public void IndexFormDtoEmptyTest() {
		IndexFormDto indexFormDto= new IndexFormDto();
		indexFormDto.setUsername("username");		
		indexFormDto.setUsernameEmpty();
		assertThat(indexFormDto.getUsername().equals(""));
	}
//		
	@Test
	public void UserGettersSettersTest() {
		User user = new User();
		user.setFirstName("fn");
		user.setLastName("ln");
		user.setPassword("password");
		user.setPassword2("password");
		user.setUsername("username");
		user.setRole("user");
		user.setId(123);
		assertThat(user.getUsername().equals("username")&&user.getPassword().equals("password")&&
				user.getPassword2().equals("password")&&
				user.getLastName().equals("ln")&&
				user.getFirstName().equals("fn")&&
				user.getId().equals(123)&&user.nameFormat("fn")&&user.passwordFormat("password")&&
				user.getRole().equals("user"));
	}
	
	@Test
	public void UserConstructorTest() {
		User user = new User(123,"fn","ln","un","pw","pw2","sq","sa", "user");
		assertThat(user.getUsername().equals("un")&&user.getPassword().equals("pw")&&
				user.getPassword2().equals("pw2")&&
				user.getLastName().equals("ln")&&
				user.getFirstName().equals("fn")&&
				user.getRole().equals("user")&&
				user.getId().equals(123)&&user.nameFormat("fn")&&user.passwordFormat("pw"));
	}
	@Test
	public void AdminConstructorTest() {
		User user = new User(123,"fn","ln","un","pw","pw2","sq","sa", "user");
		assertThat(user.getUsername().equals("un")&&user.getPassword().equals("pw")&&
				user.getPassword2().equals("pw2")&&
				user.getLastName().equals("ln")&&
				user.getFirstName().equals("fn")&&
				user.getRole().equals("admin")&&
				user.getId().equals(123)&&user.nameFormat("fn")&&user.passwordFormat("pw"));
	}
	
	@Test
	public void EnglishQuestionPairTest() {
		MatchingQuestionPair eqp = new MatchingQuestionPair(null, null, null, null, null,null);
		eqp.set_name("name");
		eqp.set_ans1("ans1");
		eqp.set_ans2("ans2");
		eqp.set_ans3("ans3");
		eqp.set_ans4("ans4");
		eqp.setCorrectAnswer("answer");
		assertThat(eqp.get_name().equals("name")&&eqp.get_ans1().equals("ans1")&&
				eqp.get_ans2().equals("ans2")&&
				eqp.get_ans3().equals("ans3")&&
				eqp.get_ans4().equals("ans4")&&
				eqp.isCorrect("answer"));
	}
	@Test
	public void EnglishQuestionPairDifficultyChangeTest() {
		MatchingQuestionPair eqp = new MatchingQuestionPair(null, null, null, null, null,null,null);
		eqp.set_name("name");
		eqp.set_ans1("ans1");
		eqp.set_ans2("ans2");
		eqp.set_ans3("ans3");
		eqp.set_ans4("ans4");
		eqp.set_ans5("ans5");
		eqp.setCorrectAnswer("answer");
		
		assertThat(eqp.get_name().equals("name")&&eqp.get_ans1().equals("ans1")&&
				eqp.get_ans2().equals("ans2")&&
				eqp.get_ans3().equals("ans3")&&
				eqp.get_ans4().equals("ans4")&&
				eqp.get_ans5().equals("ans5")&&
				eqp.getCorrectAnswer().equals("answer"));
	}
	
	
}