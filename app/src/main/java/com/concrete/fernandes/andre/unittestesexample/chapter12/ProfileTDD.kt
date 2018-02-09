package com.concrete.fernandes.andre.unittestesexample.chapter12

/**
 * Created by andre on 09/02/18.
 */

class ProfileTDD {

     var answer: AnswerTDD? = null

    fun matches(criterion: CriterionTDD): Boolean {
        return answer != null
    }

    fun add(answer: AnswerTDD) {
        this.answer = answer
    }

}