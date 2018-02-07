package com.concrete.fernandes.andre.unittestesexample.chapter2

/**
 * Created by andre on 07/02/18.
 */
class Criteria {

    val criteria : MutableList<Criterion> = ArrayList()

    fun addCriterion(criterion: Criterion) {
       criteria.add(criterion)
    }
}