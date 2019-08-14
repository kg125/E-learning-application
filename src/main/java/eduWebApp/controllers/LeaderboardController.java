package eduWebApp.controllers;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import eduWebApp.domain.User;
import eduWebApp.repository.UserRepository;
//import eduWebApp.EducationalGameApplication;


@Controller
@RequestMapping("/leaderboard")
public class LeaderboardController {
	
	
@Autowired
UserRepository userRepository;

/**
 * @param model
 * @return
 */
@RequestMapping("/")
public String leaderboard(Model model) {
	// arraylist to hold the users  
	ArrayList<User> allUsers = new ArrayList<User>();
	// arraylist to hold the users scores 
	ArrayList<String> allUserScore = new ArrayList<String>();
	// gets all users
	allUsers =  userRepository.findByHighestScore();
	for (User u : allUsers) {
		
		allUserScore.add(u.getHighScore().toString());
	}
	
	model.addAttribute("users",allUsers);
	model.addAttribute("scores",allUserScore);
	
	
	
    return "leaderboard";
}

}
