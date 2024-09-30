package com.example.algorithms.leetcode.matrix

class Convert1DInto2D {
    fun construct2DArray(original: IntArray, m: Int, n: Int): Array<IntArray> {
        if (original.size != m * n) return emptyArray()

        var k = 1
        var i = 0
        var l = 0
        val res = Array(m) { intArrayOf() }
        while (k * n - 1 <= original.lastIndex) {
            val arr = IntArray(n)
            var j = 0
            while (i <= k * n - 1) {
                arr[j++] = original[i++]
            }
            k++
            res[l++] = arr
        }
        return res
    }
}