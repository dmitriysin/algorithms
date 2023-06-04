package com.example.algorithms.leetcode


/**
 * https://leetcode.com/problems/power-of-three/
 */
class PowerOfThree {
    fun isPowerOfThree(n: Int): Boolean {
        var x = n
        while (x >= 1) {
            if (x == 1) return true
            if (x % 3 == 0) {
                x /= 3
            } else return false
        }
        return false
    }
}