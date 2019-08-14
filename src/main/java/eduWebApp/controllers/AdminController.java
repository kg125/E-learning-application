
package eduWebApp.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import eduWebApp.EducationalGameApplication;
import eduWebApp.domain.ExamAnswers;
import eduWebApp.domain.ExamQuestion;
import eduWebApp.domain.User;
import eduWebApp.repository.QuestionRepository;
import eduWebApp.repository.UserRepository;
import eduWebApp.service.QuestionService;
import eduWebApp.service.eduWebAppService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	eduWebAppService es;

	@Autowired
	QuestionService qs;

	@Autowired
	private QuestionRepository questionRepo;

	@Autowired
	private UserRepository userRepo;
// used for when admin is adding an user
	private List<String> secQuestions = Arrays.asList("----------", "What is your favourite colour?",
			"What is your favourite sport?", "Who is your cartoon character?", "What is your favourite subject?",
			"What is your favourite food?");
// admin login 
	@RequestMapping("/")
	public String admin(ModelMap model) {
		if (EducationalGameApplication.getUser() == null && EducationalGameApplication.getUser().getRole().equals("user")) {
			return "redirect:/login";
		}
		model.addAttribute("username", EducationalGameApplication.getUser().getUsername());

		
		// arrays fir game and exam results
		String[] examResults = userRepo.getExamsResults();
		String[] gameResults = userRepo.getGameResults();
		String[] mathsResults = userRepo.getMathsResults();
		String[] englishResult = userRepo.getEnglishResults();
		
		// arrays for catergorized results
		int[] values = categorizeExamResults(examResults);
		int[] valuess = categorizeGameResults(gameResults);
		System.out.println(Arrays.toString(mathsResults));
		System.out.println(Arrays.toString(englishResult));
		System.out.println(Arrays.toString(examResults));
		System.out.println(Arrays.toString(values));
		System.out.println(Arrays.toString(gameResults));
		System.out.println(Arrays.toString(valuess));
		model.put("values", values);
		
		//getting values out of the array individually so they can be plotted for visualization 
		for(int i = 0; i < values.length; i++) {
			model.put("value"+i,values[i]);
		}
		for(int i = 0; i < valuess.length; i++) {
			model.put("values"+i,valuess[i]);
		}
		model.put("valuess", valuess);
		
		// calculating maths score average
		double sum = 0;
		for(int i = 0; i < mathsResults.length; i++) {
			model.put("mathsvalues"+i,mathsResults[i]);
			sum += Double.valueOf( mathsResults[i]); 
		}
		double average = sum/mathsResults.length;
		//model.put("mathsvalues", mathsResults);
		model.put("mathsvalues", average);
		System.out.println(average);
		
		// calculating english score average
		double sum1 = 0;
		for(int i = 0; i < englishResult.length; i++) {
			model.put("englishvalues"+i,englishResult[i]);
			sum1 += Double.valueOf( englishResult[i]); 
		}
		double average1 = sum1/englishResult.length;
		//model.put("englishvalues", englishResult);
		model.put("englishvalues", average1);
		System.out.println(average1);
		// calculating the average of exam scores
		double sum2 = 0;
		for(int i = 0; i < examResults.length; i++) {
			model.put("examvalues"+i,examResults[i]);
			sum2 += Double.valueOf( examResults[i]); 
		}
		double average2 = sum2/examResults.length;
		//model.put("englishvalues", englishResult);
		model.put("examvalues", average2);
		System.out.println(average2);
	
		return "admin";
	}
	
	// putting exam results into buckets 
	public int[] categorizeExamResults(String[] examResults) {
		int[] groups = new int[4];
		for(String s : examResults) {
			int v = Integer.parseInt(s);
			if(v <= 2) {
				groups[0]++;
			}else if(v <= 4) {
				groups[1]++;
			}else if(v <= 8) {
				groups[2]++;
			}else {
				groups[3]++;
			}
		}
		
		return groups;
	}
	//putting game results into buckets
	public int[] categorizeGameResults(String[] gameResults) {
		int[] group1 = new int[4];
		for(String s : gameResults) {
			int v = Integer.parseInt(s);
			if(v <= 5) {
				group1[0]++;
			}else if(v <= 10) {
				group1[1]++;
			}else if(v <= 20) {
				group1[2]++;
			}else {
				group1[3]++;
			}
		}
		
		return group1;
	}
	// puttig maths results into buckets 
	public int[] categorizeMathsResults(String[] mathsResults) {
		int[] group2 = new int[4];
		for(String s : mathsResults) {
			int v = Integer.parseInt(s);
			if(v <= 5) {
				group2[0]++;
			}else if(v <= 10) {
				group2[1]++;
			}else if(v <= 20) {
				group2[2]++;
			}else {
				group2[3]++;
			}
		}
		
		return group2;
	}
	
// allows admin to see results table of the users 
	@RequestMapping(value = "/results")
	public String stuResults(Model model) {

		ArrayList<String> userScore = new ArrayList<String>();
		ArrayList<String> userExamScore = new ArrayList<String>();
		ArrayList<User> users = new ArrayList<User>();
		ArrayList<User> userss = new ArrayList<User>();
		users = userRepo.findByHighestScore();
		userss = userRepo.findByExamHighScoreOrdered();
		for (User user : users) {

			userScore.add(user.getHighScore().toString());
		}

		for (User user : userss) {

			userExamScore.add(user.getExamHighScore().toString());
		}
		model.addAttribute("users", users);
		model.addAttribute("scores", userScore);
		model.addAttribute("scoress", userExamScore);

		return "studentResult";

	}
// admin logout 
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(Model model) {

		if (EducationalGameApplication.getUser() != null
				&& EducationalGameApplication.getUser().getRole().equals("user")
				|| EducationalGameApplication.getUser().getRole().equals("admin")) {

			EducationalGameApplication.setUser(null);
			return "redirect:/";
		}

		return "redirect:/";

	}
	// allows admin to view all users 
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String allUsers(ModelMap model, @ModelAttribute("App") String App) {

		if (EducationalGameApplication.getUser() == null) {
			return "redirect:/login";
		}
		model.addAttribute("username", EducationalGameApplication.getUser().getUsername());
		model.put("users", userRepo.findAll());
		return "ShowAllUsers";
	}
	// allows admin to deleted users 
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delUsers(ModelMap model, @ModelAttribute("App") String App, @ModelAttribute("id") int id) {
		model.addAttribute("username", EducationalGameApplication.getUser().getUsername());

		userRepo.delete(id);

		// finds all of the users
		model.put("users", userRepo.findAll());
		return "ShowAllUsers";
	}
// allows admin to edit user details 
	@RequestMapping(value = "/edit/{id}")
	public ModelAndView edit(@PathVariable Integer id) {
		return new ModelAndView("edit", "user", es.findById(id));
	}

	@RequestMapping(value = "/adminEdit", method = RequestMethod.POST)
	public @ResponseBody ModelAndView editUsers(ModelMap model, @RequestParam(value = "id", required = true) Object id,
			@RequestParam(value = "firstName", required = false) Object firstName,
			@RequestParam(value = "lastName", required = false) Object lastName, HttpServletRequest req) {

		id = req.getParameter("id");
		firstName = req.getParameter("firstName");
		lastName = req.getParameter("lastName");

		System.out.println(id + "" + firstName + " " + lastName);
		userRepo.edit(id, firstName, lastName);
		model.put("users", userRepo.findAll());
		//return "/admin/all";
		return new ModelAndView("redirect:../admin/all");

	}


	// allows admin to add users 
	@RequestMapping(value = "/addUsers", method = RequestMethod.GET)
	public String addUsers(ModelMap model, @ModelAttribute("user") User user) {
		model.addAttribute("questionsList", (List<String>) this.secQuestions);

		return "adminAdd";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Valid @ModelAttribute("user") User user, BindingResult result, ModelMap model) {

		userRepo.save(user);
		model.put("users", userRepo.findAll());
		EducationalGameApplication.setUser(user);

		return "redirect:/admin/all";

	}

	// allows admin to add a comment to users profiles 
	@RequestMapping(value = "/adminComment/{id}")
	public ModelAndView adminComment(@PathVariable Integer id) {
		return new ModelAndView("adminComment", "user", es.findById(id));
	}

	@RequestMapping(value = "/addComment", method = RequestMethod.POST)
	public @ResponseBody ModelAndView editUsers(ModelMap model, @RequestParam(value = "id", required = true) Object id,
			@RequestParam(value = "adminComment", required = false) Object adminComment, HttpServletRequest req) {

		id = req.getParameter("id");
		adminComment = req.getParameter("adminComment");

		System.out.println(id + "" + adminComment);
		userRepo.updateComment(id, adminComment);
		model.put("users", userRepo.findAll());
		//return "redirect:/admin/all";
		return new ModelAndView("redirect:../admin/all");

	}

	// allows admin to see the exam question being asked to the users 
	@RequestMapping(value = "/allQuestions", method = RequestMethod.GET)
	public String examQuestion(ModelMap model) {

		if (EducationalGameApplication.getUser() == null) {
			return "redirect:/login";
		}
		// finds all of the questions from the service
		model.put("questions", qs.findAll());
		model.addAttribute("username", EducationalGameApplication.getUser().getUsername());

		return "ShowAllQuestions";
	}
// allows admin to edit exam quesions 
	@RequestMapping(value = "/editExamQuest/{id}")
	public ModelAndView editExamQuest(@PathVariable Integer id) {
		return new ModelAndView("editExam", "user", qs.findById(id));
	}

	@RequestMapping(value = "/editQuestion", method = RequestMethod.POST)
	public @ResponseBody ModelAndView editExam(ModelMap model, @RequestParam(value = "id", required = true) Object id,
			@RequestParam(value = "content", required = false) Object content, HttpServletRequest req) {
		id = req.getParameter("id");
		content = req.getParameter("content");

		System.out.println(id + "\t" + content);
		questionRepo.updateExamQuestions(id, content);
		return new ModelAndView("redirect:/editExam/");
	}
	
	@RequestMapping(value = "/editExamAnswer/{id}")
	public ModelAndView editExamAnswer(@PathVariable int id) {
		ArrayList<ExamAnswers> list = new ArrayList<>();
		Set<ExamAnswers> answers = qs.findById(id).getAnswer();
		for (Iterator<ExamAnswers> iterator = answers.iterator(); iterator.hasNext();) {
			ExamAnswers a = iterator.next();
			System.out.println(a.getContent());
			list.add(a);
		}
		return new ModelAndView("editExamAnswer", "answerlist", list);
	}

	@RequestMapping(value = "/editAnswer", method = RequestMethod.POST)
	public @ResponseBody ModelAndView editAnswer(ModelMap model, @RequestParam(value = "ansid", required = true) Object ansid,
			@RequestParam(value = "content", required = false) Object content, HttpServletRequest req) {
		
		String ids = req.getParameter("ansid");
		String updatedContent = req.getParameter("content");

		System.out.println("aaaaaa "+ ids + "\t" + updatedContent);
		questionRepo.updateExamAnswers(ids, content);
		return new ModelAndView("redirect:/editExam/");
	}
	

}
