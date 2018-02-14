package com.concrete.fernandes.andre.unittestesexample.chapter12

/**
 * Created by andre on 09/02/18.
 */
class AnswerTDD(val questionTDD: QuestionTDD, val value: Boolean) {

    fun match(answer: AnswerTDD?): Boolean {
        if(answer == null) return false

        return questionTDD.match(answer)
    }
}