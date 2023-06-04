package com.example.algorithms.leetcode

import java.util.Arrays

class SlidingWindowMax {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        var i = 0
        var j = k - 1
        var maxI = maxIndex(nums, i, j)
        var resI = 0
        val res = IntArray(nums.size - k + 1)
        res[resI++] = nums[maxI]

        while (j < nums.lastIndex) {
            i++
            j++
            if (maxI < i) {
                maxI = maxIndex(nums, i, j)
            } else {
                if (nums[maxI] <= nums[j]) {
                    maxI = j
                }
            }
            res[resI++] = nums[maxI]
        }
        return res
    }

    private fun maxIndex(nums: IntArray, i: Int, j: Int): Int {
        var max = nums[i]
        var maxIndex = i
        for (index in i + 1..j) {
            val currentMax = nums[index]
            if (currentMax > max) {
                maxIndex = index
                max = currentMax
            }
        }
        return maxIndex
    }

    fun maxSlidingWindow1(nums: IntArray, k: Int): IntArray {
        val queue = ArrayDeque<Int>()
        var i = 0
        val res = IntArray(nums.size - k + 1)
        var resIndex = 0
        while (i < nums.size) {
            if (queue.isEmpty()) {
                queue.add(i++)
            } else {
                if (queue.last() <= i - k) queue.removeLast()
                while (queue.isNotEmpty() && nums[i] >= nums[queue.first()]) {
                    queue.removeFirst()
                }
                queue.addFirst(i++)
            }
            if (i > k - 1) {
                res[resIndex++] = nums[queue.last()]
            }
        }
        return res
    }
}