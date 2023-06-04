package com.example.algorithms.leetcode

import java.util.*

/**
 * 227
 * https://leetcode.com/problems/basic-calculator-ii/
 */
class BasicCalculatorII {
    fun calculate(s: String): Int {
        val stack = Stack<Int>()
        var digit = 0
        var action = '+'
        for (i in 0..s.lastIndex) {
            val char = s[i]
            if (char.isDigit()) digit = digit * 10 + char.toInt() - '0'.toInt()
                                                              
            if ((char.isDigit().not() && char.isWhitespace().not()) || i == s.lastIndex) {
                when (action) {
                    '+' -> stack.add(digit)
                    '-' -> stack.add(-digit)
                    '*' -> stack.add(stack.pop() * digit)
                    '/' -> stack.add(stack.pop() / digit)
                }
                action = char
                digit = 0
            }
        }
        return stack.sum()
    }
}