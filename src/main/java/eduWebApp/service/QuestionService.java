package eduWebApp.service;

import eduWebApp.domain.ExamAnswers;
import eduWebApp.domain.ExamQuestion;
import eduWebApp.domain.User;

public interface QuestionService {
	public Iterable<ExamQuestion> findAll();
	
	public Integer findAnswerIdCorrect(int questionId);
	
	public ExamQuestion findById(Integer id);
	
//	public ExamAnswers findAnswersById(Integer id);
//	public ExamQuestion findById(int questionId);
}
