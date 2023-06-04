package com.example.algorithms.leetcode

class ReverseString {


    fun reverse(s: CharArray): CharArray {

        var i = 0
        var j = s.lastIndex

        while (i < j) {
            val element = s[i]
            s[i] = s[j]
            s[j] = element
            i++
            j--
        }
        return s
    }

}