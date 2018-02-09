package com.concrete.fernandes.andre.unittestesexample.chapter12

/**
 * Created by andre on 09/02/18.
 */
class AnswerTDD(val questionTDD: QuestionTDD, val value: Boolean) {

    fun match(answer: AnswerTDD): Boolean {
        return this.value == answer.value
    }
}