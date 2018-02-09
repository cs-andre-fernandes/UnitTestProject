package com.concrete.fernandes.andre.unittestesexample.chapter12

import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test

/**
 * Created by andre on 09/02/18.
 */
class  ProfileTDDTest {

    private lateinit var profile: ProfileTDD
    private lateinit var questionIsThereRelocationPackage: QuestionTDD
    private lateinit var answerThereIsRelocation: AnswerTDD
    private lateinit var answerThereIsNotRelocation: AnswerTDD

    @Before
    fun setup() {
        profile = ProfileTDD()
        questionIsThereRelocationPackage = QuestionTDD(1, "Relocation Package?")
        answerThereIsRelocation = AnswerTDD(questionIsThereRelocationPackage, true)
        answerThereIsNotRelocation = AnswerTDD(questionIsThereRelocationPackage, false)
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

    @Test
    fun doesNotMatchWhenNoMatchingAnswer() {
        profile.add(answerThereIsNotRelocation)
        val criterionTDD = CriterionTDD(AnswerTDD(questionIsThereRelocationPackage, true), WeightTDD.MustMatch)

        val result = profile.matches(criterionTDD)

        assertFalse(result)
    }

}