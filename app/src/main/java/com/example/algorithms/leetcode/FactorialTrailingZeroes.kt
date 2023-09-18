package com.example.algorithms.leetcode

/**
 * 172
 * https://leetcode.com/problems/factorial-trailing-zeroes/
 */
class FactorialTrailingZeroes {
    /**
     * 1,2,3,4,5,6,7,8,9,10,11
     * 1,2,6,24,120,720,
     */
    fun trailingZeroes(n: Int): Int {
        if (n / 5 == 0) return 0
        return n / 5 + trailingZeroes(n / 5)
    }
}