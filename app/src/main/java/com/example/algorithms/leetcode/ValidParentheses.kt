package com.example.algorithms.leetcode

import java.util.*
import kotlin.collections.HashMap

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
class ValidParentheses {

    val parenthesesMap = HashMap<Char, Char>().apply {
        put('{', '}')
        put('(', ')')
        put('[', ']')
    }

    fun isValid(s: String): Boolean {
        var stringIndex = 0
        val stack = Stack<Char>()

        while (stringIndex < s.length) {
            val parentheses = s[stringIndex]

            if (parenthesesMap[parentheses] == null) {
                if (stack.isEmpty()) return false
                if (parenthesesMap[stack.last()] == parentheses) {
                    stack.pop()
                } else {
                    return false
                }
            } else {
                stack.push(parentheses)
            }

            stringIndex++
        }
        return stack.isEmpty()
    }
}