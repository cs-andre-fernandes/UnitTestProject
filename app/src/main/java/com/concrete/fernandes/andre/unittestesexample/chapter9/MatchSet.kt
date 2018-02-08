package com.concrete.fernandes.andre.unittestesexample.chapter9

import com.concrete.fernandes.andre.unittestesexample.chapter2.AnswerRefactor
import com.concrete.fernandes.andre.unittestesexample.chapter2.CriteriaRefactor
import com.concrete.fernandes.andre.unittestesexample.chapter2.CriterionRefactor
import com.concrete.fernandes.andre.unittestesexample.chapter2.WeightRefactor

/**
 * Created by andre on 08/02/18.
 */

class MatchSet(private val answers : AnswersCollection, private val criteria: CriteriaRefactor) {

    var score = 0

    fun calculateScore(criteria: CriteriaRefactor) : Int {
        criteria.criteriaList
                .filter { it.matches(answersMatching(it)) }
                .forEach { score += it.weight.value }

        return score
    }

    private fun answersMatching(criterion: CriterionRefactor) : AnswerRefactor? {
        return answers.answerMatching(criterion)
    }

    fun matches() : Boolean {

        if(doesntMatchAnyCriteria(criteria)) return false

        return anyMatches()
    }

    private fun doesntMatchAnyCriteria(criteria: CriteriaRefactor) : Boolean {
        for (criterion in criteria.criteriaList) {
            val match = criterion.matches(answersMatching(criterion))
            if(!match && criterion.weight == WeightRefactor.MustMatch) {
                return true
            }
        }
        return false
    }

    private fun anyMatches() : Boolean {
        var match = false
        for (criterion in criteria.criteriaList)
            match = criterion.matches(answersMatching(criterion)) //TODO: Usar o bitwise or. Seria o mais correto aqui

        return match
    }
}