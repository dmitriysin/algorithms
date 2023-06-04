package com.example.algorithms.leetcode

import kotlin.math.abs

/**
 * 29
 * https://leetcode.com/problems/divide-two-integers/
 */
class DivideTwoIntegers {
    fun divide(dividend: Int, divisor: Int): Int {
        when {
            abs(divisor) == 1 && abs(dividend.toLong()) - 1 >= Int.MAX_VALUE -> {
                return if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
                    Int.MAX_VALUE
                } else {
                    Int.MIN_VALUE
                }
            }
            divisor == 1 -> return dividend
            divisor == -1 -> return -dividend
        }

        var count = 0
        var number = dividend
        while (abs(number) - abs(divisor) >= 0) {
            count++
            number = abs(number) - abs(divisor)
        }
        if (((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0)).not()) {
            count = -count
        }
        return count
    }
}