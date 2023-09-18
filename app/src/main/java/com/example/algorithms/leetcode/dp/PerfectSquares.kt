package com.example.algorithms.leetcode.dp

/**
 * 279
 * https://leetcode.com/problems/perfect-squares/
 */
class PerfectSquares {
    fun numSquares(n: Int): Int {
        val dp = IntArray(n + 1) { Int.MAX_VALUE }
        dp[0] = 0
        for (i in 1..n) {
            var j = 1
            while (true) {
                val square = j * j
                if (i - square >= 0) {
                    dp[i] = minOf(dp[i], dp[i - square] + 1)
                    j++
                } else break
            }
        }
        return dp[n]
    }
}