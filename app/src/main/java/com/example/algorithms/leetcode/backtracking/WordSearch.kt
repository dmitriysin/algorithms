package com.example.algorithms.leetcode.backtracking

/**
 * 79
 * https://leetcode.com/problems/word-search/
 */
class WordSearch {
    private var res = false
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val visitedArray = Array(board.size) { Array(board[0].size) { false } }
        for ((i, arr) in board.withIndex()) {
            for ((j, char) in arr.withIndex()) {
                if (char == word[0]) {
                    search(board, i, j, word, 0, copyOfArray(visitedArray))
                }
            }
        }
        return res
    }

    private fun search(board: Array<CharArray>, i: Int, j: Int, word: String, k: Int, visited: Array<Array<Boolean>>) {
        visited[i][j] = true
        if (k == word.lastIndex) {
            res = true
            return
        }
        if (i - 1 in board.indices && (board[i - 1][j] == word[k + 1] && !visited[i - 1][j])) {
            search(board, i - 1, j, word, k + 1, copyOfArray(visited))
        }
        if (i + 1 in board.indices && (board[i + 1][j] == word[k + 1] && !visited[i + 1][j])) {
            search(board, i + 1, j, word, k + 1, copyOfArray(visited))
        }
        if (j + 1 in board[i].indices && (board[i][j + 1] == word[k + 1] && !visited[i][j + 1])) {
            search(board, i, j + 1, word, k + 1, copyOfArray(visited))
        }
        if (j - 1 in board[i].indices && (board[i][j - 1] == word[k + 1] && !visited[i][j - 1])) {
            search(board, i, j - 1, word, k + 1, copyOfArray(visited))
        }
    }

    private fun copyOfArray(original: Array<Array<Boolean>>): Array<Array<Boolean>> {
        return Array(original.size) { original[it].copyOf() }
    }
}