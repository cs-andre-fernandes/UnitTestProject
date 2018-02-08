package com.concrete.fernandes.andre.unittestesexample.chapter2

/**
 * Created by andre on 07/02/18.
 */
class CriterionRefactor(val answer: AnswerRefactor, val weight: WeightRefactor) {

    fun matches(answerCompared: AnswerRefactor?) =
            weight == WeightRefactor.DontCare || (answerCompared?.match(answer) != null && answerCompared.match(answer))
}