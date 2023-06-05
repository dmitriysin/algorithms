package com.example.algorithms

import com.example.algorithms.infrastructure.RandomProblem
import com.example.algorithms.leetcode.graph.NumberProvinces
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
            intArrayOf(1,0,0),
            intArrayOf(0,1,0),
            intArrayOf(0,0,1),
        )
        val arr = intArrayOf(1,2,3,5,7)
        val x = NumberProvinces().findCircleNum(s1)
        val xx = 0
    }
}

