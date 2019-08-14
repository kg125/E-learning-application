package eduWebApp.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity(name="user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column()
    private Integer id;
	@Column(name="First_Name", nullable= false)
    private String firstName;
	@Column(name="Last_Name", nullable= false)
    private String lastName;
	@Column(name="Username", unique=true, nullable= false)
    private String username;
	@Column(name="Password", nullable= false)
    private String password;
	@Column(name = "Password2", nullable= false)
	private String password2;
	@Column(name="Security_Question", nullable = false)
	private String securityQuestion;
	@Column(name="Security_Answer", nullable = false)
	private String securityAnswer;
	@Column(name="HighScore", nullable = true)
	private Integer HighScore = 0;
	@Column(name="role", nullable = true)
	private String role;
	@Column(name="MathsScore", nullable = true)
	private Integer mathsScore = 0;
	@Column(name="EnglishScore", nullable = true)
	private Integer englishScore = 0;
	@Column(name="ExamScore", nullable = true)
	private Integer ExamScore = 0;
	

	@Column(name="ExamAttempts", nullable = true)
	private Integer ExamAttempts = 0;
	@Column(name= "AdminComment", nullable = true)
	private String adminComment;
	
//	
//	public String getAdminComment() {
//		return adminComment;
//	}
//	public void setAdminComment(String adminComment) {
//		this.adminComment = adminComment;
//	}
	
	public Integer getMathsScore() {
		return mathsScore;
	}
	public void setMathsScore(Integer mathsScore) {
		this.mathsScore = mathsScore;
	}
	public Integer getEnglishScore() {
		return englishScore;
	}
	public void setEnglishScore(Integer englishScore) {
		this.englishScore = englishScore;
	}
	public Integer getExamAttempts() {
		return ExamAttempts;
	}
	public String getAdminComment() {
		return adminComment;
	}
	public void setAdminComment(String adminComment) {
		this.adminComment = adminComment;
	}
	public void setExamAttempts(Integer examAttempts) {
		ExamAttempts = examAttempts;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
		
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getSecurityQuestion() {
		
		return securityQuestion;
	}
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	public String getSecurityAnswer() {
		return securityAnswer;
	}
	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}
	

	public Integer getHighScore() {
		return HighScore;
	}
	public void setHighScore(Integer highScore) {
		HighScore = highScore;
	}
	public Integer getExamHighScore() {
		return ExamScore;
	}
	public void setExamHighScore(Integer examScore) {
		ExamScore = examScore;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean nameFormat(String s) {
		String ch = "(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$";
		return s.matches(ch);
	}

	

	public boolean usernameFormat(String s) {
		String ch = "^[a-zA-Z0-9]{4,15}$";
		return s.matches(ch);
		
	}
	public boolean passwordFormat(String s) {
		String ch = "^[A-Za-z]{4,12}$";
		return s.matches(ch);
	}
	public User() { }
	
	public User(Integer id, String firstName, String lastName, String username, String password, String password2, String securityQuestion, String securityAnswer, String role) {
		
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.password2 = password2;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
		this.role = role;
		

	}

	
}