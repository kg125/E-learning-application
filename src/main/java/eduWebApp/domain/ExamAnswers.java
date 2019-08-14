package eduWebApp.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ExamAnswers")
public class ExamAnswers implements Serializable {
	
private static final long serialVersionUID = 1L;
private Integer id ; 
private ExamQuestion examQuestion;
private String content;
private boolean correct;

@Id
@GeneratedValue(strategy = IDENTITY)
@Column(name = "id", unique = true, nullable = false)
public Integer getId() {
	return this.id;
}

@ManyToOne
@JoinColumn(name ="question_id", nullable = false )
public ExamQuestion getExamQuestion(){
	return this.examQuestion;
}
@Column(name = "content", nullable = false)
public String getContent() {
	return this.content;
}
@Column(name ="correct", nullable = false)
public boolean isCorrect() {
	return this.correct;
}
public ExamAnswers() {}
public ExamAnswers(ExamQuestion examQuestion, String content, boolean correct) {

	this.examQuestion = examQuestion;
	this.content = content;
	this.correct = correct;
}

public void  setId(Integer id) {
	this.id = id;
}
public void setExamQuestion(ExamQuestion examQuestion) {
	this.examQuestion = examQuestion;
}
public void setContent(String content) {
	this.content = content;
}
public void setCorrect(boolean correct) {
	this.correct = correct;
}







}
