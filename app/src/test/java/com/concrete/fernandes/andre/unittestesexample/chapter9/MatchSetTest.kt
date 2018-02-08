package com.concrete.fernandes.andre.unittestesexample.chapter9

import com.concrete.fernandes.andre.unittestesexample.chapter2.*
import junit.framework.Assert
import org.junit.Before
import org.junit.Test

/**
 * Created by andre on 08/02/18.
 */
class MatchSetTest {

    private lateinit var criteria : CriteriaRefactor
    private lateinit var question: QuestionRefactor
    private lateinit var answers: AnswersCollection

    @Before
    fun createCriteria() {
        criteria = CriteriaRefactor()
    }
    @Before
    fun createQuestion() {
        question = QuestionRefactor(1, "Got bonuses?")
    }

    @Before
    fun createAnswers() {
        answers = AnswersCollection()
    }

    @Test
    fun matchAnswersFalseWhenMustMatchCriteriaNotMet() {
        //Arrange
        addAnswer(AnswerRefactor(question, false))
        criteria.addCriterion(CriterionRefactor(AnswerRefactor(question, true), WeightRefactor.MustMatch))

        //Act
        val matches = createMatchSet().matches()

        //Assert
        Assert.assertFalse(matches)
    }

    private fun addAnswer(answer: AnswerRefactor) {
        answers.add(answer)
    }

    private fun createMatchSet() : MatchSet {
        return MatchSet(answers, criteria)
    }

    @Test
    fun matchAnswersTrueForAny() {
        //Arrange
        addAnswer(AnswerRefactor(question, false))
        val criterion = CriterionRefactor(AnswerRefactor(question, true), WeightRefactor.DontCare)
        criteria.addCriterion(criterion)

        //Act
        val matches = createMatchSet().matches()

        //Assert
        Assert.assertTrue(matches)

    }

    @Test
    fun matchScoreWithOneQuestionAndNoCriterion() {
        //Arrange
        val criterion = CriterionRefactor(AnswerRefactor(question, true), WeightRefactor.DontCare)
        criteria.addCriterion(criterion)

        //Act )
        val scoreResult = createMatchSet().calculateScore(criteria)

        //Assert
        org.junit.Assert.assertEquals(WeightRefactor.DontCare.value, scoreResult)
    }


}