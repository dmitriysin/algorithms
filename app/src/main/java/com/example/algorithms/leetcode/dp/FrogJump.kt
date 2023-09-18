package com.example.algorithms.leetcode.dp

/**
 *
 */
class FrogJump {
    var res = false

    data class Stone(val i: Int, val k: Int)

    fun canCross(stones: IntArray): Boolean {
        if (stones.size == 2) return stones[1] == 1
        val dp = HashSet<Stone>()
        crossing(stones, 1, 1, dp)
        return res
    }

    private fun crossing(stones: IntArray, i: Int, k: Int, dp: HashSet<Stone>) {
        if (dp.contains(Stone(i, k)) || res) return
        if (i == stones.lastIndex) {
            res = true
            return
        }
        val jumpIndex = findPossibleJumpIndex(stones, k, i, i, stones.lastIndex)
        if (jumpIndex == -1) {
            dp.add(Stone(i, k))
            return
        }

        when (stones[jumpIndex] - stones[i]) {
            k - 1 -> {
                safeCrossing(stones, jumpIndex + 2, i, k, dp)
                safeCrossing(stones, jumpIndex + 1, i, k, dp)
                crossing(stones, jumpIndex, stones[jumpIndex] - stones[i], dp)
            }

            k -> {
                safeCrossing(stones, jumpIndex + 1, i, k, dp)
                crossing(stones, jumpIndex, stones[jumpIndex] - stones[i], dp)
                safeCrossing(stones, jumpIndex - 1, i, k, dp)
            }

            k + 1 -> {
                crossing(stones, jumpIndex, stones[jumpIndex] - stones[i], dp)
                safeCrossing(stones, jumpIndex - 1, i, k, dp)
                safeCrossing(stones, jumpIndex - 2, i, k, dp)
            }
        }
    }

    private fun safeCrossing(stones: IntArray, j: Int, i: Int, k: Int, dp: HashSet<Stone>):Boolean {
        if (j in stones.indices && stones[j] - stones[i] in k - 1..k + 1 && j > i) {
            crossing(stones, j, stones[j] - stones[i], dp)
            return true
        } else return false
    }

    private fun findPossibleJumpIndex(stones: IntArray, k: Int, i: Int, start: Int, end: Int): Int {
        if (start > end) return -1
        val mid = (start + end) / 2
        return if (stones[mid] - stones[i] in k - 1..k + 1 && stones[mid] - stones[i] > 0) mid
        else if (stones[mid] - stones[i] <= k - 1) findPossibleJumpIndex(stones, k, i, mid + 1, end)
        else findPossibleJumpIndex(stones, k, start, i, mid - 1)
    }
}