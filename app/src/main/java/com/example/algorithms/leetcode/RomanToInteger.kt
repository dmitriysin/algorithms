package com.example.algorithms.leetcode

/**
 * https://leetcode.com/problems/roman-to-integer/
 */
class RomanToInteger {
    fun romanToInt(s: String): Int {
        val romanSymbols = s.toCharArray()

        val romanMap = HashMap<Char, Int>().apply {
            put('I', 1)
            put('V', 5)
            put('X', 10)
            put('L', 50)
            put('C', 100)
            put('D', 500)
            put('M', 1000)
        }

        var left = 0
        var number = 0
        while (left < romanSymbols.size) {
            val leftSymbol = romanSymbols[left]

            if (left + 1 < romanSymbols.size) {
                val rightSymbol = romanSymbols[left + 1]

                val leftNumber = requireNotNull(romanMap[leftSymbol])
                val rightNumber = requireNotNull(romanMap[rightSymbol])

                number += if (leftNumber < rightNumber) {
                    left += 2
                    rightNumber - leftNumber
                } else {
                    left++
                    leftNumber
                }
            } else {
                val symbol = romanSymbols[left]
                number += requireNotNull(romanMap[symbol])
                left++
            }
        }
        return number
    }
}