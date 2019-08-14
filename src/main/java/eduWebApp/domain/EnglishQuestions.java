package eduWebApp.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class EnglishQuestions {
	private HashMap<Integer,String> easyNames = new HashMap<Integer,String>();
	private HashMap<Integer,String> meduimNames = new HashMap<Integer,String>();
	private HashMap<Integer,String> hardNames = new HashMap<Integer,String>();
	
	public EnglishQuestions() {
		int num = 0;
		for (String i : Arrays.asList("baby.png","ball.png","bee.png","blue.png","boat.png","boy.png","bus.png","car.png","cat.png","cow.png","deer.jpeg","dog.png","egg.png","fish.png","frog.png","girl.jpg","hat.png","lamp.png","lion.jpeg","moon.png","pig.png","red.png","sea.jpeg","sun.jpeg","tree.png")) {
			easyNames.put(num, i);
			num++;
		}
		num = 0;
		for (String i : Arrays.asList("apple.png","beach.png","board.png","chair.png","clock.png","clown.png","Earth.png","glasses.png","horse.png","lemon.png","light.png","parrot.jpeg","peach.png","plane.png","puzzle.png","rainbow.png","rhino.jpeg","screen.jpeg","shark.png","table.png","tennis.png","wallet.png","watch.png","zebra.png")) {
			meduimNames.put(num, i);
			num++;
		}
		num = 0;
		for (String i : Arrays.asList("astronaut.jpg","Athletics.jpg","Broccoli.jpg","caterpillar.jpg","Computer.jpg","Daffodil.jpg","daggers.png","dragon.png","Earrings.jpg","electricGuitar.jpg","Elephant.jpg","Factory.jpg","fractions.png","giraffe.jpg","gorrilla.jpg","graffiti.jpg","Headphones.jpg","icecream.jpg","Leopard.jpg","notepad.jpeg","Reading.jpg","Spaceship.jpg","whiteboard.jpg")) {
			hardNames.put(num, i);
			num++;
		}
		
	}
	
	public EnglishQuestionPair getEasyQuestion() {
		String newName = "";
		String ans1 = "";
		String ans2 = "";
		String ans3 = "";
		String ans4 = "";
		String actAnswer ="";
		
		HashSet<String> options = new HashSet<String>();
		Random rand = new Random();
		int choice = -1;
		for (int i = 0; i<4; i++) {
			choice = rand.nextInt((easyNames.size()-1)+1);
			boolean found = false;
			while (!found) {
				try {
					options.add(easyNames.get(choice).split("\\.")[0]);
					found = true;
				} catch (Exception e) {
					choice = rand.nextInt((easyNames.size()-1)+1);
				}
			}
			
			if (i == 0) {
				// The randomly generated name is also the name in the question
				newName = "Easy/"+easyNames.get(choice);
				actAnswer = easyNames.get(choice).split("\\.")[0];
				
			}
			easyNames.remove(choice);
			
		}
		
		int i = 0;
		for (String j : options) {
			switch (i) {
			case 0:
				ans1 = j;
			case 1:
				ans2 = j;
			case 2:
				ans3 = j;
			default:
				ans4 = j;
			}
			i++;
		}
		
		return new EnglishQuestionPair(newName,ans1,ans2,ans3,ans4,actAnswer);
	}
	public EnglishQuestionPair getMediumQuestion() {
		String newName = "";
		String ans1 = "";
		String ans2 = "";
		String ans3 = "";
		String ans4 = "";
		String ans5 = "";
		String actAnswer ="";
		HashSet<String> options = new HashSet<String>();
		Random rand = new Random();
		int choice = -1;
		for (int i = 0; i<5; i++) {
			choice = rand.nextInt((meduimNames.size()-1)+1);
			boolean found = false;
			while (!found) {
				try {
					options.add(meduimNames.get(choice).split("\\.")[0]);
					found = true;
				} catch (Exception e) {
					System.out.println(meduimNames);
					System.out.println(choice);
					choice = rand.nextInt((meduimNames.size()-1)+1);
				}
			}
			
			if (i == 0) {
				// The randomly generated name is also the name in the question
				newName ="Medium/"+ meduimNames.get(choice);
				actAnswer =meduimNames.get(choice).split("\\.")[0];
			}
			meduimNames.remove(choice);
			
		}
		
		int i = 0;
		for (String j : options) {
			switch (i) {
			case 0:
				ans1 = j;
			case 1:
				ans2 = j;
			case 2:
				ans3 = j;
			case 3:
				ans4 = j;
			default:
				ans5 = j;
			}
			i++;
		}
		
		return new EnglishQuestionPair(newName,ans1,ans2,ans3,ans4,ans5,actAnswer);
	}
	public EnglishQuestionPair getHardQuestion() {
		String newName = "";
		String ans1 = "";
		String ans2 = "";
		String ans3 = "";
		String ans4 = "";
		String ans5 = "";
		String actAnswer ="";
		HashSet<String> options = new HashSet<String>();
		Random rand = new Random();
		int choice = -1;
		for (int i = 0; i<5; i++) {
			choice = rand.nextInt((hardNames.size()-1)+1);
			boolean found = false;
			while (!found) {
				try {
					options.add(hardNames.get(choice).split("\\.")[0]);
					found = true;
				} catch (Exception e) {
					System.out.println(hardNames);
					System.out.println(choice);
					choice = rand.nextInt((hardNames.size()-1)+1);
				}
			}
			
			if (i == 0) {
				// The randomly generated name is also the name in the question
				newName ="Hard/"+ hardNames.get(choice);
				actAnswer =hardNames.get(choice).split("\\.")[0];
			}
			hardNames.remove(choice);
			
		}
		
		int i = 0;
		for (String j : options) {
			switch (i) {
			case 0:
				ans1 = j;
			case 1:
				ans2 = j;
			case 2:
				ans3 = j;
			case 3:
				ans4 = j;
			default:
				ans5 = j;
			}
			i++;
		}
		
		return new EnglishQuestionPair(newName,ans1,ans2,ans3,ans4,ans5,actAnswer);
	}

	
}
