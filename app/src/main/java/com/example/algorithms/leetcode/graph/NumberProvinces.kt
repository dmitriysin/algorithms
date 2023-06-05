package com.example.algorithms.leetcode.graph


/**
 * 547
 * https://leetcode.com/problems/number-of-provinces/
 */
class NumberProvinces {

    var res = 0
    fun findCircleNum(isConnected: Array<IntArray>): Int {
        val marked = BooleanArray(isConnected.size) { false }
        for (i in isConnected.indices) {
            for (j in isConnected[i].indices) {
                if (isConnected[i][j] == 1 && j != i && !marked[i]) {
                    res++
                    mark(marked, isConnected, i)
                }
            }
        }
        for (element in marked) {
            if (!element) res++
        }
        return res
    }

    private fun mark(marked: BooleanArray, isConnected: Array<IntArray>, index: Int) {
        for ((i, element) in isConnected[index].withIndex()) {
            if (element == 1 && !marked[i]) {
                marked[i] = true
                if (i != index) {
                    mark(marked, isConnected, i)
                }
            }
        }
    }
}