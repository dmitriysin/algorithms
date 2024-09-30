package com.example.algorithms.leetcode.matrix

import java.util.PriorityQueue

class KWeakestRows {
    fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
        val queue = PriorityQueue<Pair<Int, Int>>(mat.size) { o1, o2 ->
            when {
                o1.first < o2.first -> -1
                o1.first > o2.first -> 1
                else -> if (o1.second < o2.second) -1 else 1
            }
        }
        mat.forEachIndexed { i, arr ->
            var start = 0
            var end = arr.lastIndex
            if(arr[0] == 0) {
                queue.add(0 to i)
            } else {
                while (start <= end) {
                    val mid = (start + end) / 2

                    if (arr[mid] == 1 && (mid == arr.lastIndex || arr[mid + 1] == 0)) {
                        queue.add(mid+1 to i)
                        break
                    } else {
                        if (arr[mid] == 0) {
                            end = mid - 1
                        } else {
                            start = mid + 1
                        }
                    }
                }
            }
        }

        return queue.getKElements(k).map { it.second }.toIntArray()
    }

    private fun <T> PriorityQueue<T>.getKElements(k: Int): List<T> {
        val arr = mutableListOf<T>()
        for (i in 0 until k) {
            arr.add(this.remove())
        }
        return arr
    }
}