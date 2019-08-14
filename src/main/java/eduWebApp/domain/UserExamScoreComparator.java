package eduWebApp.domain;

import java.util.Comparator;

public class UserExamScoreComparator implements Comparator<User> {
   
	@Override
    public int compare(User o1, User o2) {
        return -1*o1.getExamHighScore().compareTo(o2.getExamHighScore());
    } 
    
   
    	
    
   }