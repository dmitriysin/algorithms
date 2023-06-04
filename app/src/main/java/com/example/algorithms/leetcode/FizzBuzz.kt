package com.example.algorithms.leetcode

/**
 * https://leetcode.com/problems/fizz-buzz/
 */
class FizzBuzz {
    fun fizzBuzz(n: Int): List<String> {
        val list = mutableListOf<String>()
        for (i in 1 until n + 1) {
            when {
                i % 3 == 0 -> {
                    if (i % 5 == 0) {
                        list.add("FizzBuzz")
                    } else {
                        list.add("Fizz")
                    }
                }
                i % 5 == 0 -> {
                    list.add("Buzz")
                }
                else -> {
                    list.add(i.toString())
                }
            }
        }
        return list
    }
}