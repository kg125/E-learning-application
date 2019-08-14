package eduWebApp;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import eduWebApp.domain.Exam;
//import eduWebApp.domain.Admin;
import eduWebApp.domain.NumberQuestions;
import eduWebApp.domain.User;
import eduWebApp.repository.UserRepository;



@SpringBootApplication
public class EducationalGameApplication implements CommandLineRunner {

	private static Integer passwordResetSection = -1;
	private static String passwordResetUsername = "";
	private static User user;
	private static Integer examAttemps = 0;
	private static NumberQuestions numberQuestions = new NumberQuestions();
	private static boolean examStarted = false;
	private static boolean englishStarted = false;
	private static Integer englishScore = 0;
	private static Integer mathScore = 0; 
	private static Integer examScore = 0;
	private static Integer counter = 0;
	private static Integer counter2 = 0;
	private static Integer counter3 = 0;
	private static Integer timerRemaining = 0;
	private static HashSet<String> askedQuestions = new HashSet<String>();
	private static User admin;
//	private static List<UserAnswers> userAns;
	
	
	public static Integer getEnglishScore() {
		return englishScore;
	}
	public static void setEnglishScore(Integer englishScoreIn) {
		englishScore = englishScoreIn;
	}
	

	public static Integer getExamScore() {
		return examScore;
	}
	public static void setExamScore(Integer examScoreIn) {
		examScore = examScoreIn;
	}
	
	
//	public static List<UserAnswers> getUserAns() {
//		return userAns;
//	}
//	public static void setUserAns(List<UserAnswers> userAns) {
//		EducationalGameApplication.userAns = userAns;
//	}
	
	public static User getUser() {
		return user;
	}
	
	public static Integer getExamAttemps() {
		return examAttemps;
	}
	public static void setExamAttemps(Integer examAttemps) {
		EducationalGameApplication.examAttemps = examAttemps;
	}
	public static User getAdminUser() {
		return admin;
	}
	public static void setUser(User user) {
		EducationalGameApplication.user = user;
	}
	public static void setAdminUser(User admin) {
		EducationalGameApplication.admin = admin;
	}
	public static String getPasswordResetUsername() {
		return passwordResetUsername;
	}

	public static void setPasswordResetUsername(String passwordResetUsername) {
		EducationalGameApplication.passwordResetUsername = passwordResetUsername;
	}
	public static Integer getPasswordResetSection() {
		
		return passwordResetSection;
	}
	public static void setPasswordResetSection(Integer passwordResetSection) {
		EducationalGameApplication.passwordResetSection = passwordResetSection;
	}
	
	public static NumberQuestions getNumberQuestions() {
		return numberQuestions;
	}

	public static void setNumberQuestions(NumberQuestions numberQuestions) {
		EducationalGameApplication.numberQuestions = numberQuestions;
	}
	public static Integer getCounter() {
		return counter;
	}
	public static void setCounter(Integer counter) {
		EducationalGameApplication.counter = counter;
	}
	public static Integer getCounter2() {
		return counter2;
	}
	public static void setCounter2(Integer counter2) {
		EducationalGameApplication.counter2 = counter2;
	}

	public static Integer getCounter3() {
		return counter3;
	}
	public static void setCounter3(Integer counter3) {
		EducationalGameApplication.counter3 = counter3;
	}
	
	
	public static Integer getMathScore() {
		return mathScore;
	}
	public static void setMathScore(Integer mathScoreIn) {
		mathScore = mathScoreIn;
	}
	public static HashSet<String> getAskedQuestions() {
		return askedQuestions;
	}
	public static void setAskedQuestions(HashSet<String> askedQuestions) {
		EducationalGameApplication.askedQuestions = askedQuestions;
	}
	public static boolean isEnglishStarted() {
		return englishStarted;
	}
	public static void setEnglishStarted(boolean englishStarted) {
		EducationalGameApplication.englishStarted = englishStarted;
	}
	public static boolean isExamStarted() {
		return examStarted;
	}
	public static void setExamStarted(boolean examStarted) {
		EducationalGameApplication.examStarted = examStarted;
	}
	public static Integer getTimerRemaining() {
		return timerRemaining;
	}
	public static void setTimerRemaining(Integer timerRemainingIn) {
		timerRemaining = timerRemainingIn;
	}
	public static void appendTimerRemaining(Integer timerRemaining) {
		EducationalGameApplication.timerRemaining += timerRemaining;
	}

	public static void main(String[] args) {
		SpringApplication.run(EducationalGameApplication.class, args);
	}
	
	@Autowired
	UserRepository userRepo;
	//defualt user
	@Override
	public void run(String... args) throws Exception {
		if(userRepo.count() == 0) {
			User u= new User();
			u.setFirstName("kasey");
			u.setLastName("gords");
			u.setHighScore(0);
			u.setUsername("kg1");
			u.setPassword("aaaa");
			u.setPassword2("aaaa");
			u.setSecurityQuestion("What is your favourite colour?");
			u.setSecurityAnswer("red");
			u.setRole("user");
			userRepo.save(u);
		}
	}
	
	
}
