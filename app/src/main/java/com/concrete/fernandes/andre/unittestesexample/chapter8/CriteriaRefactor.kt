package com.concrete.fernandes.andre.unittestesexample.chapter2

/**
 * Created by andre on 07/02/18.
 */
class CriteriaRefactor {

    val criteria : MutableList<CriterionRefactor> = ArrayList()

    fun addCriterion(criterion: CriterionRefactor) {
       criteria.add(criterion)
    }
}