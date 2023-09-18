package com.example.algorithms

import com.example.algorithms.infrastructure.RandomProblem
import com.example.algorithms.leetcode.backtracking.WordSearch
import com.example.algorithms.leetcode.dp.FrogJump
import com.example.algorithms.leetcode.priorityheap.KthLargestElementArray
import com.example.algorithms.sort.KthLargestElement
import org.junit.Test

class AlgorithmTest {

    @Test
    fun getProblemNumber() {
        val number = RandomProblem().getProblemNumber()
        println("leetcode problem number is: $number")
    }

    @Test
    fun test() {
        val arr = arrayOf(
            charArrayOf('A', 'B', 'C', 'E'),
            charArrayOf('S', 'F', 'E', 'S'),
            charArrayOf('A', 'D', 'E', 'E'),
        )
        val test = WordSearch().exist(arr, "ABCESEEEFS")

        val x = 0
    }

}

