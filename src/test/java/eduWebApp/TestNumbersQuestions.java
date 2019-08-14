package eduWebApp;

import static org.mockito.BDDMockito.given;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import eduWebApp.domain.NumberQuestions;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestNumbersQuestions {

	NumberQuestions numberQuestions;
	
	  @MockBean
	  private Random r;
	
	@Before
	public void before() {
		numberQuestions =new NumberQuestions();
	}
	
	@Test
	public void getSetScore() {
		numberQuestions.setScore(3);
		assertThat(numberQuestions.getScore()==3);
	}
	
	@Test
	public void getSetX() {
		numberQuestions.setX(3);
		assertThat(numberQuestions.getX()==3);
	}
	
	@Test
	public void getSetY() {
		numberQuestions.setY(3);
		assertThat(numberQuestions.getY()==3);
	}
	
	@Test
	public void getSetOperator() {
		numberQuestions.setFunction("-");
		assertThat(numberQuestions.getFunction().equals("-"));
	}
	
	@Test
	public void easyAdditionQuestion() {
		given(r.nextInt()).willReturn(0);
		numberQuestions.EasyDifficultyQuestion();
		assertThat(numberQuestions.getFunction().equals("+"));
	}
	
	@Test
	public void MediumAdditionQuestion() {
		given(r.nextInt()).willReturn(0);
		numberQuestions.MediumDifficultyQuestion();
		assertThat(numberQuestions.getFunction().equals("+"));
	}
	
	@Test
	public void HardMultiplcationQuestion() {
		given(r.nextInt()).willReturn(0);
		numberQuestions.HardDifficultyQuestion();
		assertThat(numberQuestions.getFunction().equals("x"));
	}
	
	@Test
	public void TestEasySubtractionQuestion() {
		given(r.nextInt()).willReturn(2);
		numberQuestions.EasyDifficultyQuestion();
		assertThat(numberQuestions.getFunction().equals("-"));
	}	
		
	@Test
	public void MediumSubtractionQuestion() {
		given(r.nextInt()).willReturn(2);
		numberQuestions.MediumDifficultyQuestion();
		assertThat(numberQuestions.getFunction().equals("-"));
	}
	
	@Test
	public void HardDivisonQuestion() {
		given(r.nextInt()).willReturn(2);
		numberQuestions.MediumDifficultyQuestion();
		assertThat(numberQuestions.getFunction().equals("/"));
	}
	
	@Test
	public void TestgetAnswer() {
		numberQuestions.setFunction("+");
		numberQuestions.setX(3);
		numberQuestions.setY(3);
		assertThat(numberQuestions.getQuestionAnswer()==6);
	}
	
	
}