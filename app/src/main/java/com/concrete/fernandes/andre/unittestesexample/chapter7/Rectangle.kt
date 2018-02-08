package com.concrete.fernandes.andre.unittestesexample.chapter7


/**
 * Created by andre on 08/02/18.
 */
class Rectangle{

    var width: Point
    var length: Point

    constructor(point: Point) {
        this.width = Point(point.x, point.x)
        this.length = Point(point.y, point.y)
    }

    constructor(width: Point, length: Point) {
        this.width = width
        this.length = length
    }

    fun area() : Int {
        return (width.x * length.y)
    }

    fun setOppositeCorners(widthCorner: Point) {
        width = Point(widthCorner.x - width.x, widthCorner.y - width.y)
        length = Point(widthCorner.x - length.x, widthCorner.y - length.y)
    }

}