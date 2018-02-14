package com.concrete.fernandes.andre.unittestesexample.chapter12

/**
 * Created by andre on 09/02/18.
 */

class ProfileTDD {

     private val answers: MutableMap<String, AnswerTDD?> = HashMap()

    fun matches(criterion: CriterionTDD): Boolean {
        val answer: AnswerTDD? = matchingProfileAnswer(criterion)
        return criterion.answer.match(answer)
    }

    fun matches(criteria: CriteriaTDD): Boolean {
        return criteria.criterionList.any { matches(it) }
    }

    private fun matchingProfileAnswer(criterion: CriterionTDD) =
            answers.get(criterion.answer.questionTDD.questionText)

    fun add(answer: AnswerTDD) {
        this.answers[answer.questionTDD.questionText] = answer
    }

}