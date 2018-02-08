package com.concrete.fernandes.andre.unittestesexample.chapter2

import com.concrete.fernandes.andre.unittestesexample.chapter9.AnswersCollection
import com.concrete.fernandes.andre.unittestesexample.chapter9.MatchSet

/**
 * Created by andre on 07/02/18.
 */

class ProfileRefactor(name : String) {

    private val answers: AnswersCollection= AnswersCollection()

    fun addAnswer(answer: AnswerRefactor) {
       this.answers.add(answer)
    }

    fun matches(criteria: CriteriaRefactor) : MatchSet {
        return MatchSet(answers, criteria)
    }
}