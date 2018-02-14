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
    private lateinit var questionReimbursesTuition : QuestionTDD
    private lateinit var answerThereIsRelocation: AnswerTDD
    private lateinit var answerThereIsNotRelocation: AnswerTDD
    private lateinit var answerDoesNotReimburseTuition: AnswerTDD
    private lateinit var answerThereIsRole: AnswerTDD
    private lateinit var criteria: CriteriaTDD

    @Before
    fun setup() {
        profile = ProfileTDD()
        questionIsThereRelocationPackage = QuestionTDD(1, "Relocation Package?")
        questionReimbursesTuition = QuestionTDD(1, "Reimburses tuition?")
        answerThereIsRelocation = AnswerTDD(questionIsThereRelocationPackage, true)
        answerThereIsNotRelocation = AnswerTDD(questionIsThereRelocationPackage, false)
        answerDoesNotReimburseTuition = AnswerTDD(questionReimbursesTuition, false)
        answerDoesNotReimburseTuition = AnswerTDD(questionReimbursesTuition, true)
        criteria = CriteriaTDD()
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

    @Test
    fun matchesWhenHasMultipleAnswers() {
        profile.add(answerThereIsNotRelocation)
        profile.add(answerDoesNotReimburseTuition)

        val criterionTDD = CriterionTDD(AnswerTDD(questionIsThereRelocationPackage, true), WeightTDD.MustMatch)
        val result = profile.matches(criterionTDD)

        assertTrue(result)
    }

    @Test
    fun matchAgainstNullAnswerReturnsFalse() {
        val answer = AnswerTDD(questionIsThereRelocationPackage, true)

        val result = answer.match(null)

        assertFalse(result)
    }

    @Test
    fun doesNotMatchWithAnyCriteria() {
        profile.add(answerDoesNotReimburseTuition)
        val criteria = CriteriaTDD()
        criteria.add(CriterionTDD(answerDoesNotReimburseTuition, WeightTDD.MustMatch))
        criteria.add(CriterionTDD(answerThereIsNotRelocation, WeightTDD.MustMatch))

        val result = profile.matches(criteria)

        assertFalse(result)
    }
}