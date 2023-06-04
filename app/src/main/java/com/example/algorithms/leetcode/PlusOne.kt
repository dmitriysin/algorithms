package com.example.algorithms.leetcode

/**
 * https://leetcode.com/problems/plus-one/
 */
class PlusOne {
    fun plusOne(digits: IntArray): IntArray {

        val arr = IntArray(digits.size)
        var i = digits.lastIndex
        var incrementNextValue = true
        while (i >= 0) {
            when (digits[i]) {
                9 -> {
                    if (incrementNextValue) {
                        arr[i] = 0
                        incrementNextValue = true
                    } else {
                        arr[i] = 9
                        incrementNextValue = false
                    }
                }
                else -> {
                    if (incrementNextValue) {
                        arr[i] = digits[i] + 1
                    } else {
                        arr[i] = digits[i]
                    }
                    incrementNextValue = false
                }
            }
            i--
        }
        if (incrementNextValue) {
            val arr1 = IntArray(arr.size + 1) {
                if (it == 0) 1
                else arr[it - 1]
            }
            return arr1
        }
        return arr
    }
}