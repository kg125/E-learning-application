package eduWebApp.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import eduWebApp.EducationalGameApplication;
import eduWebApp.domain.User;
import eduWebApp.repository.UserRepository;



@Controller
@RequestMapping("/summary")
public class SummaryController {
	@Autowired 
	private UserRepository userRepo;
	
	private Integer maths = 0;
	private Integer english = 0;
	private Integer bonus = 0;

	private List<String> secQuestions = Arrays.asList("----------",
			"What is your favourite colour?",
			"What is your favourite pet?",
			"Who is your cartoon character?",
			"What is your favourite subject?",
			"What is your favourite food?");
	
	@RequestMapping("/signup")
    public String signup(@ModelAttribute("user") User user,Model model) {
		model.addAttribute("score", english+maths+bonus);
		model.addAttribute("questionsList", (List<String>) this.secQuestions);
		return "signup";
	}
	
	
	@RequestMapping("/")
    public String main(Model model, @ModelAttribute("App") String App) {
		//checking for user
		if (EducationalGameApplication.getUser() == null) {
			return "redirect:/login";
		}
		if (!App.equals("question")) {
			return "redirect:/";
		}
		
		User highest = null;
		// checks if the user highscore is null, if it is null then it will replace null with the users highscore
		for (User user : userRepo.findAll()) {
			if (highest == null || highest.getHighScore() <= user.getHighScore() && (!user.getUsername().equals("Guest"))) {
				highest = user;
			}
			
		}
		System.out.println(highest);
		
		bonus = EducationalGameApplication.getTimerRemaining()/5;
		User userToUpdate = userRepo.findByUsername(EducationalGameApplication.getUser().getUsername());
		
		if (!EducationalGameApplication.getUser().getUsername().equals("Guest")) {
			if (userToUpdate.getHighScore() == null || userToUpdate.getHighScore() <= (EducationalGameApplication.getMathScore() + EducationalGameApplication.getEnglishScore()  + bonus)) {
				userToUpdate.setHighScore(EducationalGameApplication.getMathScore() + EducationalGameApplication.getEnglishScore() + bonus);
				userRepo.save(userToUpdate);
			}
			model.addAttribute("HighestScore", userToUpdate.getHighScore());
			
			if (userToUpdate.getEnglishScore() == null || userToUpdate.getEnglishScore() <= (EducationalGameApplication.getEnglishScore())) {
				userToUpdate.setEnglishScore(EducationalGameApplication.getEnglishScore());
				userRepo.save(userToUpdate);
			}
			model.addAttribute("EnglishScore", userToUpdate.getEnglishScore());
			System.out.println(userToUpdate.getUsername()+"\t"+userToUpdate.getEnglishScore() + " english ");
			
			if (userToUpdate.getMathsScore() == null || userToUpdate.getMathsScore() <= (EducationalGameApplication.getMathScore())) {
				userToUpdate.setMathsScore(EducationalGameApplication.getMathScore());
				userRepo.save(userToUpdate);
			}
			model.addAttribute("MathsScore", userToUpdate.getMathsScore());
			System.out.println(userToUpdate.getUsername()+"\t"+userToUpdate.getMathsScore()+ " maths");

			
			if (highest.getHighScore() <= (EducationalGameApplication.getMathScore() + EducationalGameApplication.getEnglishScore() + bonus)) {
				model.addAttribute("HighestScoreEver", userToUpdate.getHighScore()+" by "+userToUpdate.getUsername());
			} else {
				model.addAttribute("HighestScoreEver", highest.getHighScore()+" by "+highest.getUsername());
			}
			
		} else {
			model.addAttribute("HighestScore", "NoHighscore");
			model.addAttribute("HighestScoreEver", highest.getHighScore()+" by "+highest.getUsername());
		}
		model.addAttribute("UserName", EducationalGameApplication.getUser().getUsername());
		model.addAttribute("EnglishScore", EducationalGameApplication.getEnglishScore());
		model.addAttribute("MathsScore", EducationalGameApplication.getMathScore());
		model.addAttribute("bonus", EducationalGameApplication.getTimerRemaining()/5);

		this.maths = EducationalGameApplication.getMathScore();
		this.english = EducationalGameApplication.getEnglishScore();
		
		EducationalGameApplication.setMathScore(0);
		EducationalGameApplication.setEnglishScore(0);
        return "Summary";
    }
	
	
}
