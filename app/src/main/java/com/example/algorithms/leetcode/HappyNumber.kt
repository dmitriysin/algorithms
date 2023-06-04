package com.example.algorithms.leetcode

/**
 * 202
 * https://leetcode.com/problems/happy-number/
 */
class HappyNumber {
    fun isHappy(n: Int): Boolean {
        var num = n
        val set = HashSet<Int>()
        while (num != 1) {
            if (set.contains(num)) {
                break
            } else {
                set.add(num)
            }
            var sum = 0
            var f = num % 10
            while (num > 0) {
                sum += f * f
                num /= 10
                f = num % 10
            }
            num = sum
        }
        return num == 1
    }
}