package com.example.algorithms

import com.example.algorithms.sort.Insertion
import com.example.algorithms.sort.MergeSort
import com.example.algorithms.sort.QuickSort
import com.example.algorithms.sort.ShellSort
import org.junit.Test
import kotlin.random.Random
import kotlin.system.measureTimeMillis

class SortTest {

    fun initArr(size: Int): IntArray {
        val arr = IntArray(size)
        var i = 0
        while (i < size) {
            arr[i] = Random.nextInt(size)
            i++
        }
        return arr
    }


    /**
     * 34,32,31,28,30
     */
    @Test
    fun insertionSort() {
        val arr = initArr(100)
        val res = measureTimeMillis { Insertion().sort(arr) }
        val x = 0
    }

    /**
     * 92, 148, 148
     */
    @Test
    fun shellSort() {
        val arr = initArr(100)
        val res = measureTimeMillis { ShellSort().sort(arr) }

        val x = 0
    }

    @Test
    fun mergeSort() {
        val nums = initArr(100)

        val res = MergeSort().sort(nums)
        val x = 0
    }

    @Test
    fun quickSort() {
        val nums = intArrayOf(1, 7, 3, 3, 3, 3, 9, 5, 2, 2, 2, 6, 4, 8, 0)

        val res = QuickSort().sort(nums)
        val x = 0
    }

    @Test
    fun compareSorts() {
        val arr0 = initArr(50000)
        val arr1 = arr0.copyOf()
        val arr2 = arr0.copyOf()
        val arr3 = arr0.copyOf()
        val arr4 = arr0.copyOf()
        val insertion = measureTimeMillis { Insertion().sort(arr0) }
        val merge = measureTimeMillis { MergeSort().sort(arr1) }
        val shell = measureTimeMillis { ShellSort().sort(arr2) }
        val quick = measureTimeMillis { QuickSort().sort(arr3) }
        val quick3way = measureTimeMillis { QuickSort().sort3way(arr4) }

        println(
            "insertion: $insertion, shell: $shell, merge: $merge, quick: $quick, quick3way: $quick3way"
        )
    }
}