package com.example.algorithms.leetcode

import java.util.Collections
import java.util.PriorityQueue
/**
 *
 */
class LastStoneWeight {
    fun lastStoneWeight(stones: IntArray): Int {
        val priorityQueue = PriorityQueue<Int>(stones.size, Collections.reverseOrder())
        for (stone in stones) {
            priorityQueue.add(stone)
        }
        while (priorityQueue.size > 1) {
            val first = requireNotNull(priorityQueue.poll())
            val second = requireNotNull(priorityQueue.poll())
            if (first != second) priorityQueue.add(first - second)
        }
        return priorityQueue.poll() ?: 0
    }
}