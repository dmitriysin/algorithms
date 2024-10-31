package com.example.algorithms.leetcode.array

class AssignCookies {
    fun findContentChildren(g: IntArray, s: IntArray): Int {
        g.sort()
        s.sort()
        var i = 0
        var j = 0
        var k = 0
        while (i < g.size && j < s.size) {
            while (j < s.size && g[i] > s[j]) j++
            if (j < s.size && g[i] <= s[j]) {
                k++
                j++
            }
            i++
        }
        return k
    }
}