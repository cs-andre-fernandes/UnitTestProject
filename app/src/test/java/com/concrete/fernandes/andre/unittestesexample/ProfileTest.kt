package com.concrete.fernandes.andre.unittestesexample

import com.concrete.fernandes.andre.unittestesexample.chapter2.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

/**
 * Created by andre on 07/02/18.
 */
class ProfileTest {

    lateinit var criteria: Criteria
    lateinit var profile: Profile
    lateinit var question: Question

    @Before
    fun createProperties() {
        criteria = Criteria()
        profile = Profile("Bull Hockey, Inc")
        question = Question(1, "Got bonuses?")
    }


    @Test
    fun matchAnswersFalseWhenMustMatchCriteriaNotMet() {
        //Arrange
        profile.addAnswer(Answer(question, false))

        criteria.addCriterion(Criterion(Answer(question, true), Weight.MustMatch))

        //Act
        val matches = profile.matches(criteria)

        //Assert
        assertFalse(matches)
    }

    @Test
    fun matchAnswersTrueForAny() {
        //Arrange
        profile.addAnswer(Answer(question, false))
        val criterion = Criterion(Answer(question, true), Weight.DontCare)
        criteria.addCriterion(criterion)

        //Act
        val matches = profile.matches(criteria)

        //Assert
        assertTrue(matches)

    }

    @Test
    fun matchScoreWithOneQuestionAndNoCriterion() {
        //Arrange
        profile.addAnswer(Answer(question, false))
        val criterion = Criterion(Answer(question, true), Weight.DontCare)
        criteria.addCriterion(criterion)

        //Act
        profile.matches(criteria)
        val scoreResult = profile.score

        //Assert
        assertEquals(Weight.DontCare.value, scoreResult)
    }

}