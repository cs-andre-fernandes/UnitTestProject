package com.concrete.fernandes.andre.unittestesexample.chapter2

/**
 * Created by andre on 07/02/18.
 */
class AnswerRefactor(val question : QuestionRefactor, val value: Boolean) {

    val questionText = question.questionText

    fun match(answer: AnswerRefactor?) : Boolean {
        return answer?.question?.questionText == this.question.questionText &&
                answer.value == this.value
    }
}