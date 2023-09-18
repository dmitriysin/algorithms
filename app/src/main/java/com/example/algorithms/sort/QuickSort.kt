package com.example.algorithms.sort

class QuickSort {

    fun sort(a: IntArray) {
        a.shuffle()
        sort(a, 0, a.lastIndex)
    }

    fun sort3way(a: IntArray) {
        a.shuffle()
        sort3way(a, 0, a.lastIndex)
    }

    private fun sort(a: IntArray, lo: Int, hi: Int) {
        if (lo >= hi) return
        val i = partition(a, lo, hi)
        sort(a, lo, i - 1)
        sort(a, i + 1, hi)
    }


    private fun partition(a: IntArray, lo: Int, hi: Int): Int {
        var i = lo + 1
        var j = hi
        while (true) {  
            while (a[i] <= a[lo]) {
                if (i == hi) break
                i++
            }
            while (a[j] > a[lo]) {
                if (j == lo) break
                j--
            }
            if (i >= j) break
            exchange(a, i, j)
        }
        exchange(a, lo, j)
        return j
    }

    private fun sort3way(a: IntArray, lo: Int, hi: Int) {
        if (lo >= hi) return
        var lt = lo
        var i = lo + 1
        var gt = hi
        while (i <= gt) {
            val cmp = a[i].compareTo(a[lt])
            when {
                cmp < 0 -> exchange(a, lt++, i++)
                cmp > 0 -> exchange(a, i, gt--)
                else -> i++
            }
        }
        sort(a, lo, lt - 1)
        sort(a, gt + 1, hi)
    }

    private fun exchange(a: IntArray, lo: Int, hi: Int) {
        val temp = a[lo]
        a[lo] = a[hi]
        a[hi] = temp
    }
}