package com.example.algorithms.leetcode

/**
 * https://leetcode.com/problems/nim-game/
 */
class NimGame {
    /**
     * 1,2,3,5,6,7,8,9
     * 4,8,
     */
    fun canWinNim(n: Int): Boolean {
        return (n % 4 == 0).not()
    }
}