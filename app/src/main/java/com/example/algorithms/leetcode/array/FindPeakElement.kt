package com.example.algorithms.leetcode.array

class FindPeakElement {
    fun findPeakElement(nums: IntArray): Int {
        if (nums.size == 1) return 0
        return find(0, nums.lastIndex, nums)
    }

    private fun find(start: Int, end: Int, nums: IntArray): Int {
        val mid = (start + end) / 2
        when {
            mid - 1 !in nums.indices -> {
                if (nums[mid] > nums[mid + 1]) return mid
            }

            mid + 1 in nums.indices -> {
                if (nums[mid] > nums[mid - 1]) return mid
            }

            nums[mid] > nums[(mid + 1)] && nums[mid] > nums[mid - 1] -> {
                return mid
            }
        }
        return if (nums[mid + 1] > nums[mid]) {
            find(mid + 1, end, nums)
        } else {
            find(start, mid - 1, nums)
        }
    }

    fun findPeakElement1(nums: IntArray): Int {
        if (nums.size == 1) return 0
        var i = 0
        var j = nums.lastIndex
        while (i <= j) {
            val mid = (i + j) / 2
            when {
                mid - 1 !in nums.indices -> {
                    if (nums[mid] > nums[mid + 1]) return mid
                }

                mid + 1 !in nums.indices -> {
                    if (nums[mid] > nums[mid - 1]) return mid
                }

                nums[mid] > nums[(mid + 1)] && nums[mid] > nums[mid - 1] -> {
                    return mid
                }
            }
            if (nums[mid + 1] > nums[mid]) {
                i = mid + 1
            } else {
                j = mid - 1
            }
        }
        return -1
    }
}
