package com.example.demo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import eduWebApp.controllers.IndexFormDto;
import eduWebApp.domain.EnglishQuestionPair;
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
				user.getId().equals(123)&&user.nameFormatTest("fn")&&user.passwordFormatTest("password")&&
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
				user.getId().equals(123)&&user.nameFormatTest("fn")&&user.passwordFormatTest("pw"));
	}
	
	@Test
	public void EnglishQuestionPairTest() {
		EnglishQuestionPair eqp = new EnglishQuestionPair(null, null, null, null, null,null);
		eqp.set_name("name");
		eqp.set_ans1("opt1");
		eqp.set_ans2("opt2");
		eqp.set_ans3("opt3");
		eqp.set_ans4("opt4");
		eqp.setCorrectAnswer("answer");
		assertThat(eqp.get_name().equals("name")&&eqp.get_ans1().equals("opt1")&&
				eqp.get_ans2().equals("opt2")&&
				eqp.get_ans3().equals("opt3")&&
				eqp.get_ans4().equals("opt4")&&
				eqp.isCorrect("answer"));
	}
	@Test
	public void EnglishQuestionPairSecondConstructorTest() {
		EnglishQuestionPair eqp = new EnglishQuestionPair(null, null, null, null, null,null,null);
		eqp.set_name("name");
		eqp.set_ans1("opt1");
		eqp.set_ans2("opt2");
		eqp.set_ans3("opt3");
		eqp.set_ans4("opt4");
		eqp.set_ans5("opt5");
		eqp.setCorrectAnswer("answer");
		assertThat(eqp.get_name().equals("name")&&eqp.get_ans1().equals("opt1")&&
				eqp.get_ans2().equals("opt2")&&
				eqp.get_ans3().equals("opt3")&&
				eqp.get_ans4().equals("opt4")&&
				eqp.get_ans5().equals("opt5")&&
				eqp.getCorrectAnswer().equals("answer"));
	}
	
	
}