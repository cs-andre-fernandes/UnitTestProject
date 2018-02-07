package com.concrete.fernandes.andre.unittestesexample.chapter2

/**
 * Created by andre on 07/02/18.
 */

class Profile(name : String) {

    private val answers: HashMap<String, Answer> = HashMap()
    var score = 0

    fun addAnswer(answer: Answer) {
       this.answers.put(answer.questionText, answer)
    }

    fun matches(criteria: Criteria) : Boolean {
        var kill = false

        for (criterion in criteria.criteria) {
            val answer = answers.get(criterion.answer.questionText)
            val match = criterion.weight == Weight.DontCare || (answer?.match(criterion.answer) != null && answer.match(criterion.answer))

            if(!match && criterion.weight == Weight.MustMatch) kill = true

            if(match) {
                score += criterion.weight.value
            }

            if(kill) return false
        }

        return true
    }
}