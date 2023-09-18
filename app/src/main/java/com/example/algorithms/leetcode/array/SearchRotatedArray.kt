package com.example.algorithms.leetcode.array

/**
 * 33
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
class SearchRotatedArray {
    fun search(nums: IntArray, target: Int): Int {
        val peak = findPeak(nums)
        return when {
            target >= nums.first() && target <= nums[peak] -> {
                search(nums, 0, peak, target)
            }

            (peak + 1) in nums.indices && target >= nums[peak + 1] && target <= nums.last() -> {
                search(nums, peak + 1, nums.lastIndex, target)
            }

            else -> -1
        }
    }

    fun findPeak(nums: IntArray): Int {
        var start = 0
        var end = nums.lastIndex
        while (start <= end) {
            val mid = (start + end) / 2
            when {
                nums.size == 1 -> return nums.lastIndex

                mid - 1 !in nums.indices -> if (nums[mid] > nums[mid + 1]) return mid

                mid + 1 !in nums.indices -> if (nums[mid] > nums[mid - 1]) return mid

                nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1] -> return mid
            }

            when {
                nums[mid] >= nums[start] -> start = mid + 1

                nums[start] >= nums[end] -> end = mid - 1
            }
        }
        return -1
    }

    fun search(nums: IntArray, start: Int, end: Int, n: Int): Int {
        var i = start
        var j = end
        while (i <= j) {
            val mid = (i + j) / 2
            when (n.compareTo(nums[mid])) {
                0 -> return mid
                -1 -> j = mid - 1
                1 -> i = mid + 1
            }
        }
        return -1
    }
}