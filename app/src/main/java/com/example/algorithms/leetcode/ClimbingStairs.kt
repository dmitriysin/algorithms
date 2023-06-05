package com.example.algorithms.leetcode

open class ClimbingStairs {
    /**
     *
     *
     *
     *              -- 7
    -- 6
    -- 5
     *        -- 4
     *      -- 3
     *   -- 2
     * -- 1
     *
     * 1 - 1 = 1
     * 2 - 2, 1+1 = 2
     * 3 - 1+1+1, 1+2, 2+1 = 3
     * 4 - 1+1+1+1, 1+2+1, 2+1+1, 2+2, 1+1+2 = 5
     * 5 - (1+1+1+1+1, 1+2+1+1, 2+1+1+1, 2+2+1, 1+1+2+1), (1+1+1+2, 1+2+2, 2+1+2, 2+1+2, 1+1+1+2) = 4
     */

     fun climbStairs(n: Int): Int {
        var a = 0
        var result = 1
        var i = 0
        while (i < n) {
            result += a
            a = result - a
            i++
        }
        return result
    }
}