package com.concrete.fernandes.andre.unittestesexample.chapter2

/**
 * Created by andre on 07/02/18.
 */

class ProfileRefactor(name : String) {

    private val answers: HashMap<String, AnswerRefactor> = HashMap()
    var score = 0

    fun addAnswer(answer: AnswerRefactor) {
       this.answers.put(answer.questionText, answer)
    }

    fun matches(criteria: CriteriaRefactor) : Boolean {

        calculateScore(criteria)

        if(doesntMatchAnyCriteria(criteria)) return false

        return anyMatches(criteria)
    }

    private fun answerMatching(criterion: CriterionRefactor) =
            answers[criterion.answer.questionText]

    private fun anyMatches(criteria : CriteriaRefactor) : Boolean {
        var match = false
        for (criterion in criteria.criteria)
            match = criterion.matches(answerMatching(criterion)) //TODO: Usar o bitwise or. Seria o mais correto aqui

        return match
    }

    private fun doesntMatchAnyCriteria(criteria: CriteriaRefactor) : Boolean {
        for (criterion in criteria.criteria) {
            val match = criterion.matches(answerMatching(criterion))
            if(!match && criterion.weight == WeightRefactor.MustMatch) {
                return true
            }
        }
        return false
    }

    private fun  calculateScore(criteria: CriteriaRefactor) {
        criteria.criteria
                .asSequence()
                .filter { it.matches(answerMatching(it)) }
                .forEach { score += it.weight.value }
    }
}