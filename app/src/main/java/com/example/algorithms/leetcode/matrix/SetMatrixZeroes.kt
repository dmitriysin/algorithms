package com.example.algorithms.leetcode

/**
 * 73
 * Set Matrix Zeroes
 */
class SetMatrixZeroes {
    fun setZeroes(matrix: Array<IntArray>) {
        var row = false
        var column = false
        for ((i, arr) in matrix.withIndex()) {
            for ((j, num) in arr.withIndex()) {
                if (num == 0) {
                    arr[0] = 0
                    matrix[0][j] = 0
                    if (i == 0) row = true
                    if (j == 0) column = true
                }
            }
        }

        for (i in 1..matrix[0].lastIndex) {
            if (matrix[0][i] == 0) {
                for (j in 1..matrix.lastIndex) {
                    matrix[j][i] = 0
                }
            }
        }

        for (j in 1..matrix.lastIndex) {
            if (matrix[j][0] == 0) {
                for (i in 1..matrix[j].lastIndex) {
                    matrix[j][i] = 0
                }
            }
        }

        if (row) {
            for (j in 1..matrix[0].lastIndex) {
                matrix[0][j] = 0
            }
        }

        if (column) {
            for (arr in matrix) arr[0] = 0
        }
    }
}