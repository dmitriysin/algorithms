package com.example.algorithms.leetcode

/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/
 */
class GuessNumber : GuessGame {
    fun guessNumber(n: Int): Int {
        var hi = n
        var lo = 1
        while (true) {
            val m = (hi - lo) / 2 + lo
            when (guess(m)) {
                -1 -> hi = m - 1
                1 -> lo = m + 1
                else -> return m
            }
        }
    }
}

interface GuessGame {
    fun guess(n: Int): Int {
        val pick = 1702766719
        return if (n > pick) {
            -1
        } else {
            if (n < pick) {
                1
            } else 0
        }
    }
}