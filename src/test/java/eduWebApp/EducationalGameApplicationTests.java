package eduWebApp;


import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import eduWebApp.EducationalGameApplication;
import eduWebApp.domain.NumberQuestions;


@RunWith(SpringRunner.class)
public class EducationalGameApplicationTests {
	@Test
	public void settingNumbersScore() {
		EducationalGameApplication.setMathScore(1);
		assertThat(EducationalGameApplication.getMathScore()==1);
	}

	
	@Test
	public void settersAndgettersforNumberQuestions() {
		//setters
		NumberQuestions mq=new NumberQuestions();
		mq.setAnswer(1);
		EducationalGameApplication.setNumberQuestions(mq);

	}
	

}
