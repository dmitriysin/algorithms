package com.example.algorithms

import com.example.algorithms.infrastructure.RandomProblem
import com.example.algorithms.leetcode.HappyNumber
import com.example.algorithms.leetcode.Search2DMatrix
import com.example.algorithms.leetcode.array.FindPeakElement
import org.junit.Test

class AlgorithmTest {

    @Test
    fun getProblemNumber() {
        val number = RandomProblem().getProblemNumber()
        println("leetcode problem number is: $number")
    }

    /**
     * [9,10,9,-7,-4,-8,2,-6]
     * 10,10,9,2
     * [1,2,3,4,5,6]
     * [1,2,6,24,120,720]
     * [720,720,360,120,30,6]
     * [24,12,8,6]
     */
    @Test
    fun test() {
        val s1 = arrayOf(
            intArrayOf(2, 5, 8, 12, 19),
            intArrayOf(1, 4, 7, 11, 15),
            intArrayOf(3, 6, 9, 16, 22),
            intArrayOf(10, 13, 14, 17, 24),
            intArrayOf(18, 21, 23, 26, 30)
        )
        val arr = intArrayOf(1, 2, 3, 1)
        val x = Search2DMatrix().searchMatrix(s1,5)
        val xx = 0
    }
}

