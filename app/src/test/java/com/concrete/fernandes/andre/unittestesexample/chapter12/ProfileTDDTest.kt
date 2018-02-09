package com.concrete.fernandes.andre.unittestesexample.chapter12

import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test

/**
 * Created by andre on 09/02/18.
 */
class  ProfileTDDTest {

    lateinit var profile: ProfileTDD
    lateinit var questionIsThereRelocationPackage: QuestionTDD
    lateinit var answerThereIsRelocation: AnswerTDD

    @Before
    fun setup() {
        profile = ProfileTDD()
        questionIsThereRelocationPackage = QuestionTDD(1, "Relocation Package?")
        answerThereIsRelocation = AnswerTDD(questionIsThereRelocationPackage, true)
    }

    @Test
    fun matchesNothingWhenProfileEmpty()  {
        val criterion = CriterionTDD(AnswerTDD(questionIsThereRelocationPackage, true), WeightTDD.DontCare)

        val result = profile.matches(criterion)

        assertFalse(result)
    }

    @Test
    fun matchesWhenProfileContainsMatchAnswer() {
        profile.add(answerThereIsRelocation)
        val criterionTDD = CriterionTDD(AnswerTDD(questionIsThereRelocationPackage, true), WeightTDD.DontCare)

        val result = profile.matches(criterionTDD)

        assertTrue(result)
    }

}