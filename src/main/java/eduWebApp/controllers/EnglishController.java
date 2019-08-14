package eduWebApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import eduWebApp.EducationalGameApplication;
import eduWebApp.domain.Delay;
import eduWebApp.domain.EnglishQuestionPair;
import eduWebApp.domain.EnglishQuestions;

@Controller
@RequestMapping("/english")
public class EnglishController {
	
	private EnglishQuestions englishQuestions = new EnglishQuestions();
	private EnglishQuestionPair match;
	
	@RequestMapping(value="/")
	public String english(Model model, @ModelAttribute("App") String App, RedirectAttributes rattrs) {
		if (!App.equals("question")) {
			return "redirect:/";
		}
		englishQuestions = new EnglishQuestions();
		
		if (EducationalGameApplication.isEnglishStarted() == false) {
			model.addAttribute("easyMode",false);
			
		}
		// Easy Questions
		if ((EducationalGameApplication.getCounter() < 4 & EducationalGameApplication.isEnglishStarted()) || (EducationalGameApplication.getCounter() < 8 && !EducationalGameApplication.isEnglishStarted())) {
		model.addAttribute("timerStart", "14");
			model.addAttribute("timerDisplay", "15");
			model.addAttribute("timerRemaining", EducationalGameApplication.getTimerRemaining());
			
			match = englishQuestions.getEasyQuestion();
			model.addAttribute("name",match.getName());
			model.addAttribute("ans1",match.get_ans1());
			model.addAttribute("ans2",match.get_ans2());
			model.addAttribute("ans3",match.get_ans3());
			model.addAttribute("ans4",match.get_ans4());
			model.addAttribute("answer", match.getCorrectAnswer());
			model.addAttribute("hardQuestion",false);
			//model.addAttribute("questionNum",EducationalGameApplication.getCounter()+1);
			model.addAttribute("score",EducationalGameApplication.getEnglishScore());
	
			
			if (EducationalGameApplication.isEnglishStarted() == false) {
				model.addAttribute("score",(EducationalGameApplication.getEnglishScore()+EducationalGameApplication.getMathScore()));
			}
			int questnum = EducationalGameApplication.getCounter() +1;
			if (EducationalGameApplication.isEnglishStarted() == false) {
				
				questnum -= 4;
			}
			
			model.addAttribute("questionNum",questnum);
			
			if (EducationalGameApplication.isEnglishStarted() == false) {
				
				model.addAttribute("easyMode",false);
			} else {
				
				model.addAttribute("easyMode",true);
			}
			
				model.addAttribute("title","Easy");	
			EducationalGameApplication.setCounter(EducationalGameApplication.getCounter() +1);

			return "english";
			
			} // medium Questions
		else if ((EducationalGameApplication.getCounter2() < 4 && EducationalGameApplication.isEnglishStarted()) || (EducationalGameApplication.getCounter2() < 8 && !EducationalGameApplication.isEnglishStarted())) {
				model.addAttribute("timerStart", "11");
				model.addAttribute("timerDisplay", "12");
				model.addAttribute("timerRemaining", EducationalGameApplication.getTimerRemaining());

				match = englishQuestions.getMediumQuestion();
				model.addAttribute("name",match.getName());
				model.addAttribute("ans1",match.get_ans1());
				model.addAttribute("ans2",match.get_ans2());
				model.addAttribute("ans3",match.get_ans3());
				model.addAttribute("ans4",match.get_ans4());
				model.addAttribute("ans5",match.get_ans5());
				//model.addAttribute("questionNum",EducationalGameApplication.getCounter2() +1);
				//model.addAttribute("title","Hard");
				model.addAttribute("answer", match.getCorrectAnswer());
				//model.addAttribute("easyMode",false);
				model.addAttribute("hardQuestion",true);
				model.addAttribute("score",EducationalGameApplication.getEnglishScore());
				//model.addAttribute("easyMode",false);

				
				model.addAttribute("easyMode",false);

				if (EducationalGameApplication.isEnglishStarted() == false) {
					model.addAttribute("score",(EducationalGameApplication.getEnglishScore()+EducationalGameApplication.getMathScore()));
				}
				int questnum = EducationalGameApplication.getCounter2() +1;
				if (EducationalGameApplication.isEnglishStarted() == false) {
					questnum -= 4;
				}
				
				model.addAttribute("questionNum",questnum);
				model.addAttribute("title","Medium");
			
				//model.addAttribute("questionNum",questNum);
				EducationalGameApplication.setCounter2(EducationalGameApplication.getCounter2() +1);

				return "english";
			
			}
		else if ((EducationalGameApplication.getCounter3() < 4 && EducationalGameApplication.isEnglishStarted()) || (EducationalGameApplication.getCounter3() < 8 && !EducationalGameApplication.isEnglishStarted())) {
			model.addAttribute("timerStart", "9");
			model.addAttribute("timerDisplay", "10");
			model.addAttribute("timerRemaining", EducationalGameApplication.getTimerRemaining());

			match = englishQuestions.getHardQuestion();
			model.addAttribute("name",match.getName());
			model.addAttribute("ans1",match.get_ans1());
			model.addAttribute("ans2",match.get_ans2());
			model.addAttribute("ans3",match.get_ans3());
			model.addAttribute("ans4",match.get_ans4());
			model.addAttribute("ans5",match.get_ans5());
			//model.addAttribute("questionNum",EducationalGameApplication.getCounter2() +1);
			//model.addAttribute("title","Hard");
			model.addAttribute("answer", match.getCorrectAnswer());
			//model.addAttribute("easyMode",false);
			model.addAttribute("hardQuestion",true);
			model.addAttribute("score",EducationalGameApplication.getEnglishScore());
			//model.addAttribute("easyMode",false);

			
			model.addAttribute("easyMode",false);

			if (EducationalGameApplication.isEnglishStarted() == false) {
				model.addAttribute("score",(EducationalGameApplication.getEnglishScore()+EducationalGameApplication.getMathScore()));
			}
			int questnum = EducationalGameApplication.getCounter3() +1;
			if (EducationalGameApplication.isEnglishStarted() == false) {
				questnum -= 4;
			}
			
			model.addAttribute("questionNum",questnum);
			model.addAttribute("title","Hard");
		
			//model.addAttribute("questionNum",questNum);
			EducationalGameApplication.setCounter3(EducationalGameApplication.getCounter3() +1);

			return "english";
		
		}else {
				
				if (EducationalGameApplication.isEnglishStarted()) {
				    rattrs.addFlashAttribute("App", "question");
					return "redirect:/english/progress";
				} else {
				    rattrs.addFlashAttribute("App", "question");
					return "redirect:/summary/";
				}
				
		}
			}


	@RequestMapping(value="answer", params = "ans1", method = RequestMethod.POST)
	public String opt1(Model model,RedirectAttributes rattrs, @RequestParam String timer,@RequestParam String timerRemaining) {
		
		EducationalGameApplication.setTimerRemaining(Integer.parseInt(timerRemaining));

		if (match.isCorrect(match.get_ans1())) {
			if (EducationalGameApplication.getCounter2() == 0) {
				EducationalGameApplication.appendTimerRemaining(Integer.parseInt(timer));

			}

			EducationalGameApplication.setEnglishScore(EducationalGameApplication.getEnglishScore() + 1);

		}
		rattrs.addFlashAttribute("App", "question");
	    Delay.delay(400);
		return "redirect:/english/";
	}

@RequestMapping(value="answer", params = "ans2", method = RequestMethod.POST)
public String opt2(Model model,RedirectAttributes rattrs, @RequestParam String timer,@RequestParam String timerRemaining) {
	EducationalGameApplication.setTimerRemaining(Integer.parseInt(timerRemaining));

			if (match.isCorrect(match.get_ans2())) {
				if (EducationalGameApplication.getCounter2() == 0) {

					EducationalGameApplication.appendTimerRemaining(Integer.parseInt(timer));

				}
		EducationalGameApplication.setEnglishScore(EducationalGameApplication.getEnglishScore()+1);
		
	}
			
    rattrs.addFlashAttribute("App", "question");
    Delay.delay(400);
	return "redirect:/english/";
}
@RequestMapping(value="answer", params = "ans3", method = RequestMethod.POST)
public String opt3(Model model,RedirectAttributes rattrs , @RequestParam String timer,@RequestParam String timerRemaining) {
	EducationalGameApplication.setTimerRemaining(Integer.parseInt(timerRemaining));

			if (match.isCorrect(match.get_ans3())) {
				if (EducationalGameApplication.getCounter2() == 0) {

					EducationalGameApplication.appendTimerRemaining(Integer.parseInt(timer));

				}
		EducationalGameApplication.setEnglishScore(EducationalGameApplication.getEnglishScore()+1);
		
	}
    rattrs.addFlashAttribute("App", "question");
    Delay.delay(400);
	return "redirect:/english/";
}
@RequestMapping(value="answer", params = "ans4", method = RequestMethod.POST)
public String opt4(Model model,RedirectAttributes rattrs , @RequestParam String timer,@RequestParam String timerRemaining) {
	EducationalGameApplication.setTimerRemaining(Integer.parseInt(timerRemaining));

			if (match.isCorrect(match.get_ans4())) {
				if (EducationalGameApplication.getCounter2() == 0) {

					EducationalGameApplication.appendTimerRemaining(Integer.parseInt(timer));

				}
		EducationalGameApplication.setEnglishScore(EducationalGameApplication.getEnglishScore()+1);
		
	}
    rattrs.addFlashAttribute("App", "question");
    Delay.delay(400);
	return "redirect:/english/";
}
@RequestMapping(value="answer", params = "ans5", method = RequestMethod.POST)
public String opt5(Model model,RedirectAttributes rattrs, @RequestParam String timer,@RequestParam String timerRemaining) {
	EducationalGameApplication.setTimerRemaining(Integer.parseInt(timerRemaining));

			if (match.isCorrect(match.get_ans1())) {
				if (EducationalGameApplication.getCounter2() == 0) {

					EducationalGameApplication.appendTimerRemaining(Integer.parseInt(timer));

				}
		EducationalGameApplication.setEnglishScore(EducationalGameApplication.getEnglishScore()+1);
		
	}
    rattrs.addFlashAttribute("App", "question");
    Delay.delay(400);
	return "redirect:/english/";
}

@RequestMapping(value="/skip")
public String skip(Model model,RedirectAttributes rattrs) {
	if (EducationalGameApplication.getCounter2() == 0 && ((EducationalGameApplication.getCounter() <= 4 
			&& EducationalGameApplication.isEnglishStarted()) || (EducationalGameApplication.getCounter() <= 8 
			&& !EducationalGameApplication.isEnglishStarted()))) {
	
	} else {
		EducationalGameApplication.setTimerRemaining(0);
	}
	
    rattrs.addFlashAttribute("App", "question");
	return "redirect:/english/";
}
	@RequestMapping(value="/progress")
	public String progress(Model model, @ModelAttribute("App") String App) {
		if (!App.equals("question")) {
			return "redirect:/";
		}
		model.addAttribute("Destination","Numbers Game");

		return "SubjectTransition";
	} 
	
}
