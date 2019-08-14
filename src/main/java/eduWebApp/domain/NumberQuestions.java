package eduWebApp.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class NumberQuestions {
	private int x, y, answer;
	private int ans1, ans2, ans3, ans4;
	private String function;
	private int score = 0;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}public void setAnswer(int answer) {

		this.answer = answer;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public int getAns1() {
		return ans1;
	}

	public void setAns1(int ans1) {
		
		this.ans1 = ans1;
	}

	public int getAns2() {
		return ans2;
	}

	public void setAns2(int ans2) {
		this.ans2 = ans2;
	}

	public int getAns3() {
		return ans3;
	}

	public void setAns3(int ans3) {
		this.ans3 = ans3;
	}

	public int getAns4() {
		return ans4;
	}

	public void setAns4(int ans4) {
		this.ans4 = ans4;
	}
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
// this method gets the functions for the questions shown in the numbers game mode
// for example if the question is addtion then value x and value y will be added together

	public int getQuestionAnswer() {
		
		if (getFunction() == "+") {

			return getX() + getY();

		} else if (getFunction() == "-")  {

			return getX() - getY();

		} 
		
		if (getFunction() == "x") {

			return getX() * getY();

		} else  {

			return getX() / getY();

		} 
	
		
	}
	// storing the temporary value that will be displayed to the user 
	private List<Integer> toList(int[] values) {
		List<Integer> tempValues = new ArrayList<Integer>();
		for (int i : values) {
			tempValues.add(i);
		}
		return tempValues;
	}
	// method that randomise the options for the number game 
	//deals with how the questions and answers are be displayed
	
		private void getAnswers(int answer) {
		//	displaying the range of questions answers that will be displayed to the user
		// for example if the answer to the question 16. the lowest  displayed answer = 12 , highest = 21
		// lowers the risk of out of range numbers
			int lowest;
			int highest;
			
			if (answer - 4 < 0) {
				lowest = 0;
				highest = 8;
			} else {
				lowest = answer - 4;
				highest = answer + 5;
			}
			//the list of answers that will be shown
			List<Integer> options = new ArrayList<Integer>();
			// list of the range of the answer elements  
			List<Integer> values = this.toList(IntStream.range(lowest, highest).toArray());

			
			// allows there to be a new set of answers each time a question is displayed
			if (answer - 4 < 0) {
				options.add(values.get(4 + (answer - 4)));
				values.remove(4 + (answer - 4));
			} else {
				options.add(values.get(4));
				values.remove(4);
			}

			Random r = new Random();

			int index = r.nextInt(values.size() - 1);
			options.add(values.get(index));
			values.remove(index);

			index = r.nextInt(values.size() - 1);
			options.add(values.get(index));
			values.remove(index);

			index = r.nextInt(values.size() - 1);
			options.add(values.get(index));
			values.remove(index);

			index = r.nextInt(options.size() - 1);
			this.ans1 = options.get(index);
			options.remove(index);

			index = r.nextInt(options.size() - 1);
			this.ans2 = options.get(index);
			options.remove(index);

			index = r.nextInt(options.size() - 1);
			this.ans3 = options.get(index);
			options.remove(index);

			this.ans4 = options.get(0);
		}

// randomising the functions for each difficulty that will be displayed in the specififc difficulty question
// each method create a new randomise function that will allow the randomisation of operators to be shown in
// that specific question

	public void EasyDifficultyQuestion() {
		Random r = new Random();
		int opt = r.nextInt(2) + 1;
		if (opt == 1) {
			this.function = "+";
			this.EasyAdditionQuestion();
		} else {
			this.function = "-";
			this.EasySubtractionQuestion();
		}
		
	}
	public void MediumDifficultyQuestion() {
		Random r = new Random();
		int opt = r.nextInt(2) + 1;
		if (opt == 1) {
			this.function = "+";
			this.MediumAdditionQuestion();
		} else {
			this.function = "-";
			this.MediumSubtractionQuestion();
		}
	}

	 public void HardDifficultyQuestion() {
	 Random r = new Random();
	 int opt = r.nextInt(2) + 1;
	 if (opt == 1) {
			this.function = "x";
			this.hardMultiplecation();
		} else {
			this.function = "/";
			this.hardDivision();
		}
	 }

		// method that randomises the easy difficulty questions of single digit numbers 
		//randomises the value shown of x and y 
		// gets the answer for this type of quest
	 
	private void EasyAdditionQuestion() {
		Random r = new Random();
		this.x = r.nextInt(9) + 1;
		this.y = r.nextInt(9) + 1;
		this.answer = this.x + this.y;

		this.getAnswers(this.answer);
	}

	private void EasySubtractionQuestion() {
		Random r = new Random();
		this.x = r.nextInt(9) + 1;
		this.y = r.nextInt(this.x) + 1;
		this.answer = this.x - this.y;

		this.getAnswers(this.answer);
	}

	// method that randomises the medium difficulty questions of double digit numbers 
	//randomises the value shown of x and y 
	// gets the answer for this type of question
	private void MediumAdditionQuestion() {

		Random r = new Random();

		this.x = r.nextInt(99 - 10 + 1) + 10;

		this.y = r.nextInt(99 - 10 + 1) + 10;

		this.answer = this.x + this.y;

		this.getAnswers(this.answer);

	}



	private void MediumSubtractionQuestion() {

		Random r = new Random();

		this.x = r.nextInt(99 - 10 + 1) + 10;

		this.y = r.nextInt(this.x - 10 + 1) + 10;

		this.answer = this.x - this.y;

		this.getAnswers(this.answer);

	}

	// method that randomises the hard difficulty questions 
	//randomises the value shown of x and y 
	// gets the answer for this type of question
	
	private void hardMultiplecation() {
		Random rand = new Random();
		this.x = rand.nextInt(9) + 1;
		this.y = rand.nextInt(this.x) + 1;
		this.answer = this.x * this.y;

		this.getAnswers(this.answer);
		
	}
	private void hardDivision() {
		Random rand = new Random();
		this.x = rand.nextInt(9) + 1;
		this.y = rand.nextInt(this.x) + 1;
		this.answer = this.x / this.y;

		this.getAnswers(this.answer);
		
	}
	
	// checks if the answer seleced is correct
	public boolean isCorrect(int correctAnswer) {
		System.out.println(correctAnswer);
		System.out.println(this.answer);
		return (this.answer == correctAnswer);
	}

	

	


}
