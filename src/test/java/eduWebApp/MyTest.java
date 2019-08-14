package eduWebApp;


import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import eduWebApp.controllers.indexValidator;
import eduWebApp.repository.UserRepository;


@RunWith(SpringRunner.class)
public class MyTest {
	
	
	@Autowired
    private UserRepository repository;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(new indexValidator(repository));
	}
	
	@Test
	  public void testLoginWithCorrectUsernameAndWrongPassword() throws Exception{
		  String username = "Admin";
		  String password = "Amin";
		  
		  assertTrue(repository.findByUsername(username).getUsername() ==  username);
		  assertTrue(repository.findByUsername(username).getPassword() ==  password);
		 
	  }
	
	
}