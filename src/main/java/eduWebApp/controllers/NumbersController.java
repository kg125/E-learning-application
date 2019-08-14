package eduWebApp.controllers;

import java.util.HashSet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import eduWebApp.EducationalGameApplication;
import eduWebApp.domain.Delay;
import eduWebApp.domain.NumberQuestions;

@Controller
@RequestMapping("/maths")
public class NumbersController {
	private NumberQuestions numberQuestions = new NumberQuestions();
	
	@RequestMapping("/")
    public String maths(Model model, @ModelAttribute("App") String App, @ModelAttribute("NumberQuestions") NumberQuestions numberQuestions,RedirectAttributes rattrs) {
		if (EducationalGameApplication.getUser() == null) {
			return "redirect:/login"; // change to see if easy question is selected
//			mathsQuestions.EasyAdditionQuestion();
		} // then insert else for medium and hard questions
		
		if (!App.equals("question")) {
			return "redirect:/";
		}
		 // change to see if easy question is selected
		//easy Dificulty Questions
		if (( EducationalGameApplication.getCounter() < 4 && !EducationalGameApplication.isEnglishStarted()) || (EducationalGameApplication.getCounter() < 8 && EducationalGameApplication.isEnglishStarted())) {	
		model.addAttribute("timerStart", "14");
		model.addAttribute("timerDisplay", "15");
		model.addAttribute("timerRemaining", EducationalGameApplication.getTimerRemaining());
		
		numberQuestions.EasyDifficultyQuestion();
		EducationalGameApplication.setNumberQuestions(numberQuestions);
		model.addAttribute("x", numberQuestions.getX());
		model.addAttribute("function", numberQuestions.getFunction());
		model.addAttribute("y", numberQuestions.getY());
		model.addAttribute("ans1", numberQuestions.getAns1());
		model.addAttribute("ans2", numberQuestions.getAns2());
		model.addAttribute("ans3", numberQuestions.getAns3());
		model.addAttribute("ans4", numberQuestions.getAns4());
		model.addAttribute("answer", numberQuestions.getQuestionAnswer());
		int questnum = EducationalGameApplication.getCounter() +1;
		
		if (EducationalGameApplication.isEnglishStarted()) {
			questnum -= 4;
		}
	//	model.addAttribute("questionNum",EducationalGameApplication.getCounter() +1);
		model.addAttribute("questionNum",questnum);
		model.addAttribute("title","Easy");
		model.addAttribute("score",EducationalGameApplication.getMathScore());
		
		if (EducationalGameApplication.isEnglishStarted() == true) {
			model.addAttribute("score",(EducationalGameApplication.getEnglishScore()+EducationalGameApplication.getMathScore()));
		}
		if (EducationalGameApplication.isEnglishStarted() == true) {
			model.addAttribute("easyMode",false);
		} else {
			model.addAttribute("easyMode",true);
		}
		
		
		
		EducationalGameApplication.setCounter(EducationalGameApplication.getCounter() +1);
		
		return "maths";
		
	}
		//medium difficulty questions
		else if ((EducationalGameApplication.getCounter2() < 4 && !EducationalGameApplication.isEnglishStarted()) || (EducationalGameApplication.getCounter3() < 8 && EducationalGameApplication.isEnglishStarted())){
			model.addAttribute("timerStart", "11");
			model.addAttribute("timerDisplay", "12");
			model.addAttribute("timerRemaining", EducationalGameApplication.getTimerRemaining());
			
			numberQuestions.MediumDifficultyQuestion();
			EducationalGameApplication.setNumberQuestions(numberQuestions);
			model.addAttribute("x", numberQuestions.getX());
			model.addAttribute("function", numberQuestions.getFunction());
			model.addAttribute("y", numberQuestions.getY());
			model.addAttribute("ans1", numberQuestions.getAns1());
			model.addAttribute("ans2", numberQuestions.getAns2());
			model.addAttribute("ans3", numberQuestions.getAns3());
			model.addAttribute("ans4", numberQuestions.getAns4());
			model.addAttribute("answer", numberQuestions.getQuestionAnswer());
			int questnum = EducationalGameApplication.getCounter2() +1;
			
			if (EducationalGameApplication.isEnglishStarted()) {
				questnum -= 4;
			}
			model.addAttribute("questionNum",questnum);
			model.addAttribute("title","Medium");
			model.addAttribute("score",EducationalGameApplication.getMathScore());
			
			if (EducationalGameApplication.isEnglishStarted()) {
				model.addAttribute("score",(EducationalGameApplication.getEnglishScore()+EducationalGameApplication.getMathScore()));
			}
			model.addAttribute("easyMode",false);
			
			
			
			EducationalGameApplication.setCounter2(EducationalGameApplication.getCounter2() +1);
			
			return "maths";
				
		}
// Hard Difficulty Questions
		else if ((EducationalGameApplication.getCounter3() < 4 && !EducationalGameApplication.isEnglishStarted()) || (EducationalGameApplication.getCounter3() < 8 && EducationalGameApplication.isEnglishStarted())){
		    model.addAttribute("timerStart", "9");
			model.addAttribute("timerDisplay", "10");
			model.addAttribute("timerRemaining", EducationalGameApplication.getTimerRemaining());
			
			numberQuestions.HardDifficultyQuestion();
			EducationalGameApplication.setNumberQuestions(numberQuestions);
			model.addAttribute("x", numberQuestions.getX());
			model.addAttribute("function", numberQuestions.getFunction());
			model.addAttribute("y", numberQuestions.getY());
			model.addAttribute("ans1", numberQuestions.getAns1());
			model.addAttribute("ans2", numberQuestions.getAns2());
			model.addAttribute("ans3", numberQuestions.getAns3());
			model.addAttribute("ans4", numberQuestions.getAns4());
			model.addAttribute("answer", numberQuestions.getQuestionAnswer());
			
			int questnum = EducationalGameApplication.getCounter3() +1;
			if (EducationalGameApplication.isEnglishStarted()) {
				questnum -= 4;
			}
			model.addAttribute("questionNum",questnum);
			model.addAttribute("title","Hard");
			model.addAttribute("score",EducationalGameApplication.getMathScore());
			
			if (EducationalGameApplication.isEnglishStarted()) {
				model.addAttribute("score",(EducationalGameApplication.getEnglishScore()+EducationalGameApplication.getMathScore()));
			}
			model.addAttribute("easyMode",false);

				EducationalGameApplication.setCounter3(EducationalGameApplication.getCounter3() +1);
				return "maths";
		}else {
			if (EducationalGameApplication.isEnglishStarted()) {
				rattrs.addFlashAttribute("App", "question");

				return "redirect:/summary/";
			} else {
				rattrs.addFlashAttribute("App", "question");
				return "redirect:/maths/progress";
			}

		}
		
		
    }
	@RequestMapping(value="answer", params = "ans1", method = RequestMethod.POST)
	public String opt1(Model model,RedirectAttributes rattrs,@RequestParam String timer,@RequestParam String timerRemaining) {
		this.numberQuestions = EducationalGameApplication.getNumberQuestions();

		EducationalGameApplication.setTimerRemaining(Integer.parseInt(timerRemaining));
		if (numberQuestions.isCorrect(numberQuestions.getAns1())) {
			if (EducationalGameApplication.getCounter3() == 0) {
				EducationalGameApplication.appendTimerRemaining(Integer.parseInt(timer));
			}
			EducationalGameApplication.setMathScore(EducationalGameApplication.getMathScore()+1);
		}
	    rattrs.addFlashAttribute("App", "question");
	    
		Delay.delay(400);
		return "redirect:/maths/";
	}
	
	@RequestMapping(value="answer", params = "ans2", method = RequestMethod.POST)
	public String opt2(Model model,RedirectAttributes rattrs, @RequestParam String timer,@RequestParam String timerRemaining) {
		this.numberQuestions = EducationalGameApplication.getNumberQuestions();

		EducationalGameApplication.setTimerRemaining(Integer.parseInt(timerRemaining));
		if (numberQuestions.isCorrect(numberQuestions.getAns2())) {
			if (EducationalGameApplication.getCounter3() == 0) {
				EducationalGameApplication.appendTimerRemaining(Integer.parseInt(timer));
			}
			EducationalGameApplication.setMathScore(EducationalGameApplication.getMathScore()+1);
		}
	    rattrs.addFlashAttribute("App", "question");
		Delay.delay(1000);
		return "redirect:/maths/";
	}
	
	@RequestMapping(value="answer", params = "ans3", method = RequestMethod.POST)
	public String opt3(Model model,RedirectAttributes rattrs,@RequestParam String timer,@RequestParam String timerRemaining) {
		this.numberQuestions = EducationalGameApplication.getNumberQuestions();

		EducationalGameApplication.setTimerRemaining(Integer.parseInt(timerRemaining));
		if (numberQuestions.isCorrect(numberQuestions.getAns3())) {
			if (EducationalGameApplication.getCounter3() == 0) {
				EducationalGameApplication.appendTimerRemaining(Integer.parseInt(timer));
			}
			EducationalGameApplication.setMathScore(EducationalGameApplication.getMathScore()+1);
		}
	    rattrs.addFlashAttribute("App", "question");
		Delay.delay(400);
		return "redirect:/maths/";
	}
	@RequestMapping(value="answer", params = "ans4", method = RequestMethod.POST)
	public String opt4(Model model,RedirectAttributes rattrs,@RequestParam String timer,@RequestParam String timerRemaining) {
		this.numberQuestions = EducationalGameApplication.getNumberQuestions();

		EducationalGameApplication.setTimerRemaining(Integer.parseInt(timerRemaining));
		if (numberQuestions.isCorrect(numberQuestions.getAns4())) {
			if (EducationalGameApplication.getCounter3() == 0) {
				EducationalGameApplication.appendTimerRemaining(Integer.parseInt(timer));
			}
			EducationalGameApplication.setMathScore(EducationalGameApplication.getMathScore()+1);
		}
	    rattrs.addFlashAttribute("App", "question");
		Delay.delay(400);
		return "redirect:/maths/";
	}

	@RequestMapping(value="/skip")
	public String skip(Model model,RedirectAttributes rattrs) {
		if (EducationalGameApplication.getCounter3() == 0 &&(EducationalGameApplication.getCounter() <= 4 && 
				!EducationalGameApplication.isEnglishStarted()) || (EducationalGameApplication.getCounter() <= 8 &&
				EducationalGameApplication.isEnglishStarted())) {
		} else {
			EducationalGameApplication.setTimerRemaining(0);
		}
	    rattrs.addFlashAttribute("App", "question");
		return "redirect:/maths/";
	}
	
	@RequestMapping(value="/progress")
	public String progress(Model model, @ModelAttribute("App") String App) {
		if (!App.equals("question")) {
			return "redirect:/";
		}
		model.addAttribute("Destination"," Mathching Game");
		EducationalGameApplication.setAskedQuestions(new HashSet<String>());

		return "SubjectTransition";
	}
}
