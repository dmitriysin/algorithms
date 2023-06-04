package com.example.algorithms.leetcode

class SqrtX {

    /**
     * [1,2,3,4,5,6,7,8]
     */

    fun mySqrt(x: Int): Int {
        var left = 0L
        var right: Long = x.toLong()
        while (left + 1 < right) {
            val number: Long = (right + left) / 2
            val square: Long = number * number
            when {
                square == x.toLong() -> return number.toInt()
                square > x -> right = number
                else -> left = number
            }
        }
        return if (right * right <= x) {
            right.toInt()
        } else {
            left.toInt()
        }
    }
}