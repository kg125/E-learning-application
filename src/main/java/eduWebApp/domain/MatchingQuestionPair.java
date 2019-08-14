package eduWebApp.domain;


public class MatchingQuestionPair {
	private String _picName;
	private String _ans1;
	private String _ans2;
	private String _ans3;
	private String _ans4;
	private String _ans5;
	private String correctPairAns ;

	public MatchingQuestionPair(String name, String ans1, String ans2, String ans3, String ans4,String actAnswer) {
		this._picName = name;
		this._ans1 = ans1;
		this._ans2 = ans2;
		this._ans3 = ans3;
		this._ans4 = ans4;
		this.correctPairAns = actAnswer;

	}
	
	public MatchingQuestionPair(String name, String ans1, String ans2, String ans3, String ans4, String ans5, String actAnswer) {
		this._picName = name;
		this._ans1 = ans1;
		this._ans2 = ans2;
		this._ans3 = ans3;
		this._ans4 = ans4;
		this._ans5 = ans5;
		this.correctPairAns = actAnswer;

	}

	public String getName() { return _picName; }

	public String get_name() {
		return _picName;
	}

	public void set_name(String _name) {
		this._picName = _name;
	}

	public String get_ans1() {
		return _ans1;
	}

	public void set_ans1(String _ans1) {
		this._ans1 = _ans1;
	}

	public String get_ans2() {
		return _ans2;
	}

	public void set_ans2(String _ans2) {
		this._ans2 = _ans2;
	}

	public String get_ans3() {
		return _ans3;
	}

	public void set_ans3(String _ans3) {
		this._ans3 = _ans3;
	}

	public String get_ans4() {
		return _ans4;
	}

	public void set_ans4(String _ans4) {
		this._ans4 = _ans4;
	}
	public String get_ans5() {
		return _ans5;
	}

	public void set_ans5(String _ans5) {
		this._ans5 = _ans5;
	}
	public String getCorrectAnswer() {
		return correctPairAns;
	}

	public void setCorrectAnswer(String correctPairanswer) {
		this.correctPairAns = correctPairanswer;
	}
	
	public boolean isCorrect(String usersAnswer) {
		
		return (this.correctPairAns.equals(usersAnswer));
	}
}
