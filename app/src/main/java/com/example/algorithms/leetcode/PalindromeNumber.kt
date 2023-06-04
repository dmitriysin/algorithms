package com.example.algorithms.leetcode



class PalindromeNumber {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false

        var reversedNumber = 0
        var restToReverse = x
        while (restToReverse != 0) {
            val lastNumber = restToReverse % 10
            reversedNumber = reversedNumber * 10 + lastNumber
            restToReverse /= 10
        }
        return (reversedNumber - x) == 0
    }
}