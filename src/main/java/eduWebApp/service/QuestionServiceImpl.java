package eduWebApp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eduWebApp.domain.ExamAnswers;
import eduWebApp.domain.ExamQuestion;
import eduWebApp.repository.QuestionRepository;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionRepository questionRepo;
	
	@Override
	public Iterable<ExamQuestion> findAll(){
		return questionRepo.findAll();
	}
	@Override
	public ExamQuestion findById(Integer id) {
		return questionRepo.findOne(id);
	}
	
//	@Override
//	public ExamAnswers findAnswersById(Integer questionId) {
//		return questionRepo.findOne(questionId);
//	}
	
	@Override
	public Integer findAnswerIdCorrect(int questionId) {
		ExamQuestion question = questionRepo.findById(questionId);
		// checking if the answers in question 
	for(ExamAnswers answers : question.getAnswer()) {
		if(answers.isCorrect()) {
			return answers.getId();
		}
//			return 1;
//		}else {
//			
//			return 0;
//		}
	}
	
	return -1;
	}
}
