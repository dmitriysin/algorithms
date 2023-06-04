package com.example.algorithms.leetcode

import kotlin.math.pow

class ExcelColumnNumber {

    /**
     * 171
     * https://leetcode.com/problems/excel-sheet-column-number/
     */
    fun titleToNumber(columnTitle: String): Int {
        val base = 26.00
        var result = 0.00
        var i = 0
        while (i < columnTitle.length) {
            val number = when (columnTitle[i]) {
                'A' -> 1
                'B' -> 2
                'C' -> 3
                'D' -> 4
                'E' -> 5
                'F' -> 6
                'G' -> 7
                'H' -> 8
                'I' -> 9
                'J' -> 10
                'K' -> 11
                'L' -> 12
                'M' -> 13
                'N' -> 14
                'O' -> 15
                'P' -> 16
                'Q' -> 17
                'R' -> 18
                'S' -> 19
                'T' -> 20
                'U' -> 21
                'V' -> 22
                'W' -> 23
                'X' -> 24
                'Y' -> 25
                else -> 26
            }
            result += base.pow(columnTitle.lastIndex - i) * number
            i++
        }
        return result.toInt()
    }
}