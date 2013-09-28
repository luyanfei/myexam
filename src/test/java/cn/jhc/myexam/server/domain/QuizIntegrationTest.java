package cn.jhc.myexam.server.domain;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.roo.addon.test.RooIntegrationTest;

@RooIntegrationTest(entity = Quiz.class)
public class QuizIntegrationTest {

    @Test
    public void testFindingRunningQuizs() {
    	Assert.assertNotNull("Data on demand for 'Quiz' failed to initialize correctly", dod.getRandomQuiz());
    	List<Quiz> result = quizService.findRunningQuizes(new java.util.Date());
    	assertNotNull("findRunningQuizs should not return null.", result);
    	assertTrue(result.size()>1);
    }
}
