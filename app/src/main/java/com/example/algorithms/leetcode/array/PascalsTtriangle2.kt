package com.example.algorithms.leetcode.array

class PascalsTtriangle2 {
    fun getRow(rowIndex: Int): List<Int> {
        var i = 0
        var arr = mutableListOf(1)
        while (i < rowIndex) {
            var j = 0
            val arr1 = mutableListOf(1)
            while (j <= arr.lastIndex) {
                if (j - 1 >= 0) {
                    arr1.add(arr[j - 1] + arr[j])
                }
                j++
            }
            arr1.add(1)
            arr = arr1
            i++
        }
        return arr
    }
}