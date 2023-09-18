package com.example.algorithms.leetcode

/**
 * 150
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 */
class ReversePolishNotation {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<Int>()
        for (token in tokens) {
            when (token) {
                "+" -> {
                    val (a, b) = calculationData(stack)
                    stack.add((a + b))
                }

                "-" -> {
                    val (a, b) = calculationData(stack)
                    stack.add((a - b))
                }

                "*" -> {
                    val (a, b) = calculationData(stack)
                    stack.add((a * b))
                }

                "/" -> {
                    val (a, b) = calculationData(stack)
                    stack.add((a / b))
                }

                else -> stack.add(token.toInt())
            }
        }
        return stack.last()
    }

    private fun calculationData(stack: ArrayDeque<Int>): Pair<Int, Int> {
        val a = stack.removeLast()
        val b = stack.removeLast()
        return b to a
    }
}