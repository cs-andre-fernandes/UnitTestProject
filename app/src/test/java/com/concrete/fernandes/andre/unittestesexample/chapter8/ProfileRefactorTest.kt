package com.concrete.fernandes.andre.unittestesexample.chapter8

import com.concrete.fernandes.andre.unittestesexample.chapter2.*
import junit.framework.Assert.*
import org.junit.Before
import org.junit.Test

/**
 * Created by andre on 08/02/18.
 */

class ProfileRefactorTest {

    lateinit var criteria: CriteriaRefactor
    lateinit var profile: ProfileRefactor
    lateinit var question: QuestionRefactor

    @Before
    fun createProperties() {
        criteria = CriteriaRefactor()
        profile = ProfileRefactor("Bull Hockey, Inc")
        question = QuestionRefactor(1, "Got bonuses?")
    }


    @Test
    fun matchAnswersFalseWhenMustMatchCriteriaNotMet() {
        //Arrange
        profile.addAnswer(AnswerRefactor(question, false))

        criteria.addCriterion(CriterionRefactor(AnswerRefactor(question, true), WeightRefactor.MustMatch))

        //Act
        val matches = profile.matches(criteria)

        //Assert
        assertFalse(matches)
    }

    @Test
    fun matchAnswersTrueForAny() {
        //Arrange
        profile.addAnswer(AnswerRefactor(question, false))
        val criterion = CriterionRefactor(AnswerRefactor(question, true), WeightRefactor.DontCare)
        criteria.addCriterion(criterion)

        //Act
        val matches = profile.matches(criteria)

        //Assert
        assertTrue(matches)

    }

    @Test
    fun matchScoreWithOneQuestionAndNoCriterion() {
        //Arrange
        profile.addAnswer(AnswerRefactor(question, false))
        val criterion = CriterionRefactor(AnswerRefactor(question, true), WeightRefactor.DontCare)
        criteria.addCriterion(criterion)

        //Act
        profile.matches(criteria)
        val scoreResult = profile.score

        //Assert
        assertEquals(WeightRefactor.DontCare.value, scoreResult)
    }

}