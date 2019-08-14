package eduWebApp.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import eduWebApp.EducationalGameApplication;
import eduWebApp.domain.User;
import eduWebApp.repository.UserRepository;
import eduWebApp.service.QuestionService;

@Controller
@RequestMapping("/exam")
public class ExamQuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired 
	private UserRepository userRepo;
	
	
	@RequestMapping(value ="/", method = RequestMethod.GET)
	public String ExamQuestion(ModelMap model, @ModelAttribute("App") String App) {
		//int attempts = EducationalGameApplication.getExamAttemps();
		
			
		if (EducationalGameApplication.getUser() == null) {
			return "redirect:/login";
		}
		// finds all of the questions from the service 
		model.put("questions", questionService.findAll());
		model.addAttribute("username",  EducationalGameApplication.getUser().getUsername());
		
		

		
		return "exam";
	}
	
	
	@RequestMapping(value ="/submit", method = RequestMethod.POST)
	public String submit(HttpServletRequest req, ModelMap model,RedirectAttributes rattrs) {
		//int attempt =0;
		int attempts = EducationalGameApplication.getExamAttemps();
		if(EducationalGameApplication.isExamStarted()== true) {
			
			attempts++;
		}
		System.out.println(attempts);
	
		// takes a string of question ids
		// checking the questionId in a collection of questionids in 
		String[] questionIds = req.getParameterValues("questionId");
		int correctanswers = 0;
		for(String questionId : questionIds) {
			
			// getting the parameter of the question 
			String str = req.getParameter("question_"+ questionId);	
			
			// id of the correct answer
			int answerIdcorrect = questionService.findAnswerIdCorrect(new Integer(Integer.parseInt(questionId.trim())));
			
			// checking if the id of the correct answer is the same as the the question id
			if(answerIdcorrect == Integer.parseInt(str.trim())) {
				correctanswers = correctanswers+1;
				
			}
		}
		int newscore = EducationalGameApplication.getExamScore()+correctanswers;
		int newAttempts = EducationalGameApplication.getExamAttemps()+ attempts;
		User highest = null;
		
		// used when showing the user with best exam score 
		// checks if the user highscore is null, if it is null then it will replace null with the users highscore
		for (User user : userRepo.findAll()) {
			if (highest == null || highest.getExamHighScore() <= user.getExamHighScore() && (!user.getUsername().equals("Guest"))) {
				highest = user;
			}	
		}
		System.out.println(highest.getUsername()+"\t"+highest.getExamHighScore());
		
		User toUpdate = userRepo.findByUsername(EducationalGameApplication.getUser().getUsername());
		//if (toUpdate.getExamHighScore() == null || toUpdate.getExamHighScore() <= (EducationalGameApplication.getExamScore())) {
			if(EducationalGameApplication.getExamScore() < newscore) {
			toUpdate.setExamHighScore(newscore);
			userRepo.save(toUpdate);
		}
			if(EducationalGameApplication.getExamAttemps() <newAttempts ) {
				toUpdate.setExamAttempts(newAttempts);
				userRepo.save(toUpdate);
			}
		
		System.out.println(toUpdate.getUsername()+"\t"+toUpdate.getExamHighScore());
		System.out.println(toUpdate.getUsername()+"\t"+toUpdate.getExamAttempts());

		//}
		
		//req.setAttribute("score", toUpdate.getExamScore());	
		req.setAttribute("score", correctanswers);	
		return "examResults";

	//	}

	}

}

