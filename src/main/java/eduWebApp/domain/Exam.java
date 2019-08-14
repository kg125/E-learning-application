package eduWebApp.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Exam")
@Table
public class Exam implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "User_id", unique = true, nullable = false)
	private Integer id ; 
	@Column(name = "attempts", nullable = true )
	private Integer attempts = 0;
	
	@Column(name = "question_id", nullable = false )
	private Integer question_id;
	@Column(name = "Time_completed", nullable = false )
	private Timestamp Time_completed;

	//user id 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAttempts() {
		return attempts;
	}
	public void setAttempts(Integer attempts) {
		this.attempts = attempts;
	}
	public Integer getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(Integer question_id) {
		this.question_id = question_id;
	}
	public Timestamp getTime_completed() {
		return Time_completed;
	}
	public void setTime_completed(Timestamp time_completed) {
		Time_completed = time_completed;
	}
	public Exam(){}
	public Exam(Integer id, Integer attempts, Integer question_id, Timestamp time_completed) {
		super();
		this.id = id;
		this.attempts = attempts;
		this.question_id = question_id;
		Time_completed = time_completed;
	}
	
}
