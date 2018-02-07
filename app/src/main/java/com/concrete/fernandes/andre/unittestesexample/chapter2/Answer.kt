package com.concrete.fernandes.andre.unittestesexample.chapter2

/**
 * Created by andre on 07/02/18.
 */
class Answer(val question : Question, val value: Boolean) {

    val questionText = question.questionText

    fun match(answer: Answer?) : Boolean {
        return answer?.question?.questionText == this.question.questionText &&
                answer.value == this.value
    }
}