package com.example.algorithms.leetcode

/**
 * 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/
 */
internal class ContainerMostWater {

    val arr = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)

    fun maxArea(height: IntArray): Int {
        var max = 0
        for (i in 0 until height.lastIndex) {
            val element = height[i]
            for (j in i..height.lastIndex) {
                val area = Math.min(element, height[j]) * (j - i)
                if (area > max) max = area
            }
        }
        return max
    }
}