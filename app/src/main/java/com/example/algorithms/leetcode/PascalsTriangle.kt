package com.example.algorithms.leetcode

/**
 * https://leetcode.com/problems/pascals-triangle/
 */
class PascalsTriangle {

    /**
     * [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1],[1,5,10,10,5,1], [1,6,15,20,15,6,1]]
     * 2,6,20
     */
    fun generate(numRows: Int): List<List<Int>> {
        val res = mutableListOf<List<Int>>()

        var previousList = listOf(1)
        res.add(previousList)

        if (numRows == 2) {
            previousList = listOf(1, 1)
            res.add(previousList)
            return res
        }

        var i = 2
        while (i <= numRows) {
            val list = mutableListOf<Int>()
            list.add(1)

            var j = 1
            while (j < previousList.size) {
                list.add(previousList[j - 1] + previousList[j])
                j++
            }
            list.add(1)

            previousList = list
            res.add(list)
            i++
        }

        return res
    }
}