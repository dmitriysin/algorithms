package com.example.algorithms.sort

class MergeSort {

    fun sort(nums: IntArray) {
        val auxiliaryArray = IntArray(nums.size)
        sort(nums, auxiliaryArray, 0, nums.lastIndex)
    }

    private fun sort(nums: IntArray, aux: IntArray, lo: Int, hi: Int) {
        if (hi <= lo) return
        val mid = lo + (hi - lo) / 2
        sort(nums, aux, lo, mid)
        sort(nums, aux, mid + 1, hi)
        merge(nums, aux, lo, mid, hi)
    }

    private fun merge(nums: IntArray, aux: IntArray, lo: Int, mid: Int, hi: Int): IntArray {
        for (index in lo..hi) {
            aux[index] = nums[index]
        }
        var i = lo
        var j = mid + 1
        var k = lo
        while (i <= mid || j < hi) {
            when {
                i > mid -> {
                    nums[k] = aux[j++]
                }
                j > hi -> {
                    nums[k] = aux[i++]
                }
                aux[i] <= aux[j] -> {
                    nums[k] = aux[i++]
                }
                aux[i] > aux[j] -> {
                    nums[k] = aux[j++]
                }
            }
            k++
        }
        return nums
    }
}