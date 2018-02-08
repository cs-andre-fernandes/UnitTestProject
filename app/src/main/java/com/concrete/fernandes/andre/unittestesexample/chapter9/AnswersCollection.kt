package com.concrete.fernandes.andre.unittestesexample.chapter9

import com.concrete.fernandes.andre.unittestesexample.chapter2.Answer
import com.concrete.fernandes.andre.unittestesexample.chapter2.AnswerRefactor
import com.concrete.fernandes.andre.unittestesexample.chapter2.CriteriaRefactor
import com.concrete.fernandes.andre.unittestesexample.chapter2.CriterionRefactor

/**
 * Created by andre on 08/02/18.
 */

class AnswersCollection {

    private val answers : HashMap<String, AnswerRefactor> = HashMap()

    fun add(answer: AnswerRefactor) {
        answers.put(answer.questionText, answer)
    }

    fun answerMatching(criterion: CriterionRefactor) : AnswerRefactor?{
        return answers[criterion.answer.questionText]
    }


}