package eduWebApp.repository;

import eduWebApp.domain.*;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eduWebApp.domain.ExamQuestion;
@Repository("questionRepository")
public interface QuestionRepository extends CrudRepository<ExamQuestion, Integer> {

	ExamQuestion findById(int questionId);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value= "Update exam_question SET content =:content WHERE id =:id" , nativeQuery = true)
	void updateExamQuestions(@Param("id") Object id, @Param("content") Object content);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value= "Update exam_answers SET content =:content WHERE id =:id" , nativeQuery = true)
	void updateExamAnswers(@Param("id") Object id, @Param("content") Object content);
	
	
	@Transactional
	@Query(value= "select * from exam_answers join exam_question on exam_answers.question_id = exam_question.id WHERE exam_question.id =:id" , nativeQuery = true)
	List <ExamQuestion> getAnswersForEdit(@Param("id") int id);

}
