package com.example.algorithms.leetcode

import kotlin.math.max


/**
 * https://leetcode.com/problems/add-binary/
 */
class AddBinary {
    fun addBinary(a: String, b: String): String {
        var i = a.lastIndex
        var j = b.lastIndex
        val sumArray = if (i > j) {
            a.toCharArray()
        } else {
            b.toCharArray()
        }
        var cNum = 0
        while (i >= 0 || j >= 0) {
            val aNum = if (i >= 0) {
                a[i].toInt() - '0'.toInt()
            } else {
                0
            }

            val bNum = if (j >= 0) {
                b[j].toInt() - '0'.toInt()
            } else {
                0
            }

            var currentNum = '0'
            when {
                aNum + bNum + cNum == 0 -> {
                    cNum = 0
                }
                aNum + bNum + cNum == 1 -> {
                    currentNum = '1'
                    cNum = 0
                }
                aNum + bNum + cNum == 2 -> {
                    currentNum = '0'
                    cNum = 1
                }
                aNum + bNum + cNum == 3 -> {
                    currentNum = '1'
                    cNum = 1
                }
            }
            sumArray[max(i, j)] = currentNum
            i--
            j--
        }
        if (cNum == 1) return "1" + String(sumArray)

        return String(sumArray)
    }
}