package com.concrete.fernandes.andre.unittestesexample.chapter12

import junit.framework.Assert.assertFalse
import org.junit.Test

/**
 * Created by andre on 09/02/18.
 */
class  ProfileTDDTest {

    @Test
    fun matchesNothingWhenProfileEmpty()  {
        val profile = ProfileTDD()
        val question = QuestionTDD(1, "Relocation Package?")
        val criterion = CriterionTDD(AnswerTDD(question, true), WeightTDD.DontCare)

        val result = profile.matches(criterion)

        assertFalse(result)
    }

}