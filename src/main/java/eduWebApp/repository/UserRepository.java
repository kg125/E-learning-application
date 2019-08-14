package eduWebApp.repository;
import java.util.ArrayList;
import java.util.Collections;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import eduWebApp.domain.User;
import eduWebApp.domain.UserExamScoreComparator;
import eduWebApp.domain.UserScoreComparator;


public interface UserRepository extends CrudRepository<User, Integer> {
	User findByUsername(String username);
	// gets all user scores from the model.
	default ArrayList<User> findByHighestScore() {
		ArrayList<User> users = new ArrayList<User>();
		for (User u : findAll()) {
			if (!u.getUsername().equals("Guest") && u.getHighScore() != null && u.getHighScore() != 0) {
				users.add(u);
			}
		}
		//
		Collections.sort(users, new UserScoreComparator());
		return users;
	}
	
	default ArrayList<User> findByExamHighScoreOrdered() {
		ArrayList<User> users = new ArrayList<User>();
		for (User user : findAll()) {
			if (!user.getUsername().equals("Guest") && user.getExamHighScore() != null && user.getExamHighScore() != 0) {
				users.add(user);
			}
		}
		Collections.sort(users, new UserExamScoreComparator());
		return users;
	}
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value= "Update user SET First_Name =:firstName, Last_Name =:lastName WHERE id =:id" , nativeQuery = true)
	void edit(@Param("id") Object id, @Param("firstName") Object firstName,@Param("lastName") Object lastName);
	
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value= "Update user SET admin_comment =:adminComment WHERE id =:id" , nativeQuery = true)
	void updateComment(@Param("id") Object id, @Param("adminComment") Object adminComment);
	
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value= "select exam_score from user" , nativeQuery = true)
	String[] getExamsResults();
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value= "select high_score from user" , nativeQuery = true)
	String[] getGameResults();
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value= "select maths_score from user" , nativeQuery = true)
	String[] getMathsResults();
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value= "select english_score from user" , nativeQuery = true)
	String[] getEnglishResults();
	
	
	
	
}