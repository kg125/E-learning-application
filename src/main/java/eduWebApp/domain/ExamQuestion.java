package eduWebApp.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ExamQuestion")
public class ExamQuestion implements Serializable {
	
private static final long serialVersionUID = 1L;

private Integer id ; 
private String content ; 
private Set<ExamAnswers> answer = new HashSet<ExamAnswers>(0);

public ExamQuestion() {}
public ExamQuestion(String content) {
	this.content = content;
}

public ExamQuestion(String content, Set<ExamAnswers> answer) {
	this.content = content;
	this.answer = answer;
}

@Id
@GeneratedValue(strategy = IDENTITY)
@Column(name = "id", unique = true, nullable = false)
public Integer getId() {
	return this.id;
}

public void  setId(Integer id) {
	this.id = id;
}
@Column(name = "content", nullable = false )

public String getContent() {
	return this.content;
}

public void setContent(String content) {
	this.content = content;
}

@OneToMany(mappedBy = "examQuestion")
public Set<ExamAnswers> getAnswer(){
	return this.answer;
}

public void setAnswer(Set<ExamAnswers> answer) {

	this.answer = answer;
}


}
