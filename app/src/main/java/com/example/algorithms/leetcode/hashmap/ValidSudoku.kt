package com.example.algorithms.leetcode.hashmap

/**
 * 36. Valid Sudoku
 */
internal class ValidSudoku {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val h = HashSet<Char>()
        val v = Array<HashSet<Char>>(9) { HashSet() }
        val s = Array<HashSet<Char>>(3) { HashSet() }
        for ((index, arr) in board.withIndex()) {
            var i = 0
            while (i < arr.size) {
                if (arr[i] != '.') {
                    if (!h.contains(arr[i])) h.add(arr[i])
                    else return false

                    if (!v[i].contains(arr[i])) {
                        v[i].add(arr[i])
                    }
                    else {
                        return false
                    }

                    val squareIndex = when (i) {
                        in 0..2 -> 0
                        in 3..5 -> 1
                        else -> 2
                    }
                    if (!s[squareIndex].contains(arr[i])) s[squareIndex].add(arr[i])
                    else return false
                }
                i++
            }
            h.clear()

            if ((index + 1) % 3 == 0) {
                for (set in s) {
                    set.clear()
                }
            }
        }
        return true
    }
}

