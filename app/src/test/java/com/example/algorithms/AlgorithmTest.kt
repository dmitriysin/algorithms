package com.example.algorithms

import com.example.algorithms.infrastructure.RandomProblem
import com.example.algorithms.leetcode.MedianTwoSortedArrays
import com.example.algorithms.leetcode.array.PascalsTtriangle2
import com.example.algorithms.leetcode.hashmap.ThreeSum
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test

class AlgorithmTest {

    @Test
    fun getProblemNumber() {
        val number = RandomProblem().getProblemNumber()
        println("leetcode problem number is: $number")
    }

    data class Profit(var amount: Int, val index: Int)

    @Test
    fun test() {

        val s = PascalsTtriangle2().getRow(3)


        val x = 0
    }


    fun predictTheWinner(nums: IntArray): Boolean {
        var s1 = 0
        var s2 = 0
        return false
    }

}

