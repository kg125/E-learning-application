package eduWebApp.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class MatchingQuestions {
	private HashMap<Integer,String> easyDifficulty = new HashMap<Integer,String>();
	private HashMap<Integer,String> meduimDifficulty = new HashMap<Integer,String>();
	private HashMap<Integer,String> hardDifficulty = new HashMap<Integer,String>();
	
	public MatchingQuestions() {
		int num = 0;
		// storing the images that correspond to the difficulties that consists in the mathcing game 
		for (String i : Arrays.asList("baby.png","ball.png","bee.png","blue.png","boat.png","boy.png","bus.png","car.png","cat.png","cow.png","deer.jpeg","dog.png","egg.png","fish.png","frog.png","girl.jpg","hat.png","lamp.png","lion.jpeg","moon.png","pig.png","red.png","sea.jpeg","sun.jpeg","tree.png")) {
			easyDifficulty.put(num, i);
			num++;
		}
		num = 0;
		for (String i : Arrays.asList("apple.png","beach.png","board.png","chair.png","clock.png","clown.png","Earth.png","glasses.png","horse.png","lemon.png","light.png","parrot.jpeg","peach.png","plane.png","puzzle.png","rainbow.png","rhino.jpeg","screen.jpeg","shark.png","table.png","tennis.png","wallet.png","watch.png","zebra.png")) {
			meduimDifficulty.put(num, i);
			num++;
		}
		num = 0;
		for (String i : Arrays.asList("astronaut.jpg","Athletics.jpg","Broccoli.jpg","caterpillar.jpg","Computer.jpg","Daffodil.jpg","daggers.png","dragon.png","Earrings.jpg","electricGuitar.jpg","Elephant.jpg","Factory.jpg","fractions.png","giraffe.jpg","gorrilla.jpg","graffiti.jpg","Headphones.jpg","icecream.jpg","Leopard.jpg","notepad.jpeg","Reading.jpg","Spaceship.jpg","whiteboard.jpg")) {
			hardDifficulty.put(num, i);
			num++;
		}
		
	}
	
	// method that randomises the easy difficulty questions 
	//randomises the pic and questions shown in this exercise 
	// gets the answer for this type of quest
	public MatchingQuestionPair getEasyDifficultyQuestion() {
		String picName = "";
		String ans1 = "";
		String ans2 = "";
		String ans3 = "";
		String ans4 = "";
		String picMatchingAnswer ="";
		
		HashSet<String> answers = new HashSet<String>();
		Random r = new Random();
		int options = -1;
		for (int i = 0; i<4; i++) {
			options = r.nextInt((easyDifficulty.size()-1)+1);
			boolean found = false;
			while (!found) {
				try {
					answers.add(easyDifficulty.get(options).split("\\.")[0]);
					found = true;
				} catch (Exception e) {
					options = r.nextInt((easyDifficulty.size()-1)+1);
				}
			}
			
			if (i == 0) {
				// The randomly generated name is also the name in the question
				picName = "Easy/"+easyDifficulty.get(options);
				picMatchingAnswer = easyDifficulty.get(options).split("\\.")[0];
				
			}
			easyDifficulty.remove(options);
			
		}
		
		int i = 0;
		for (String a : answers) {
			switch (i) {
			case 0:
				ans1 = a;
			case 1:
				ans2 = a;
			case 2:
				ans3 = a;
			default:
				ans4 = a;
			}
			i++;
		}
		
		return new MatchingQuestionPair(picName,ans1,ans2,ans3,ans4,picMatchingAnswer);
	}
	// method that randomises the easy difficulty questions 
	//randomises the pic and questions shown in this exercise 
	// gets the answer for this type of quest
	public MatchingQuestionPair getMediumDifficultyQuestion() {
		String picName = "";
		String ans1 = "";
		String ans2 = "";
		String ans3 = "";
		String ans4 = "";
		String ans5 = "";
		String picMatchingAnswer ="";
		HashSet<String> answers = new HashSet<String>();
		Random r = new Random();
		int options = -1;
		for (int i = 0; i<5; i++) {
			options = r.nextInt((meduimDifficulty.size()-1)+1);
			boolean found = false;
			while (!found) {
				try {
					answers.add(meduimDifficulty.get(options).split("\\.")[0]);
					found = true;
				} catch (Exception e) {
					System.out.println(meduimDifficulty);
					System.out.println(options);
					options = r.nextInt((meduimDifficulty.size()-1)+1);
				}
			}
			
			if (i == 0) {
				// The randomly generated name is also the name in the question
				picName ="Medium/"+ meduimDifficulty.get(options);
				picMatchingAnswer =meduimDifficulty.get(options).split("\\.")[0];
			}
			meduimDifficulty.remove(options);
			
		}
		
		int i = 0;
		for (String a : answers) {
			switch (i) {
			case 0:
				ans1 = a;
			case 1:
				ans2 = a;
			case 2:
				ans3 = a;
			case 3:
				ans4 = a;
			default:
				ans5 = a;
			}
			i++;
		}
		
		return new MatchingQuestionPair(picName,ans1,ans2,ans3,ans4,ans5,picMatchingAnswer);
	}
	// method that randomises the easy difficulty questions 
	//randomises the pic and questions shown in this exercise 
	// gets the answer for this type of quest
	public MatchingQuestionPair getHardDifficultyQuestion() {
		String picName = "";
		String ans1 = "";
		String ans2 = "";
		String ans3 = "";
		String ans4 = "";
		String ans5 = "";
		String picMatchingAnswer ="";
		HashSet<String> answers = new HashSet<String>();
		Random r = new Random();
		int options = -1;
		for (int i = 0; i<5; i++) {
			options = r.nextInt((hardDifficulty.size()-1)+1);
			boolean found = false;
			while (!found) {
				try {
					answers.add(hardDifficulty.get(options).split("\\.")[0]);
					found = true;
				} catch (Exception e) {
					System.out.println(hardDifficulty);
					System.out.println(options);
					options = r.nextInt((hardDifficulty.size()-1)+1);
				}
			}
			
			if (i == 0) {
				// The randomly generated name is also the name in the question
				picName ="Hard/"+ hardDifficulty.get(options);
				picMatchingAnswer =hardDifficulty.get(options).split("\\.")[0];
			}
			hardDifficulty.remove(options);
			
		}
		
		int i = 0;
		for (String a : answers) {
			switch (i) {
			case 0:
				ans1 = a;
			case 1:
				ans2 = a;
			case 2:
				ans3 = a;
			case 3:
				ans4 = a;
			default:
				ans5 = a;
			}
			i++;
		}
		
		return new MatchingQuestionPair(picName,ans1,ans2,ans3,ans4,ans5,picMatchingAnswer);
	}

	
}
