package com.example.algorithms.leetcode

import java.util.*


/**
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/
 */
internal class NumberOfIslands {

    private val array1 = charArrayOf('1', '1', '0', '0', '0')
    private val array2 = charArrayOf('1', '1', '0', '0', '0')
    private val array3 = charArrayOf('0', '0', '1', '0', '0')
    private val array4 = charArrayOf('0', '0', '0', '1', '1')
    private val arr = arrayOf(array1, array2, array3, array4)

    /*private val grid = Array<CharArray>(4) {
        arr[it]
    }*/


    fun numIslands(grid: Array<CharArray>): Int {
        val numberOfElements = getNumberOfElements(grid)
        val marked = MutableList(numberOfElements) { false }
        val verticesValue = CharArray(numberOfElements)

        return findIslands(marked, grid, verticesValue, numberOfElements)
    }

    private fun getNumberOfElements(grid: Array<CharArray>): Int {
        var count = 0
        for (element in grid) {
            count += element.size
        }
        return count
    }

    private fun getGraph(
        grid: Array<CharArray>,
        verticesValue: CharArray,
        elements: Int
    ): List<LinkedList<Int>> {

        val graph = List(elements) { LinkedList<Int>() }

        var elementInGraph = 0

        for (arrayIndex in grid.indices) {
            val array = grid[arrayIndex]
            for (index in array.indices) {
                if (index != array.lastIndex) {
                    if (array[index] == '1' && array[index + 1] == '1') {
                        graph[elementInGraph].add(elementInGraph + 1)
                        graph[elementInGraph + 1].add(elementInGraph)
                    }
                }
                if (arrayIndex != grid.lastIndex) {
                    val nextArray = grid[arrayIndex + 1]
                    if (array[index] == '1' && nextArray[index] == '1') {
                        graph[elementInGraph].add(elementInGraph + array.size)
                        graph[elementInGraph + array.size].add(elementInGraph)
                    }
                }
                verticesValue[elementInGraph] = array[index]
                elementInGraph++
            }
        }
        // Log.e("getGraph", graph.toString())
        return graph
    }

    fun findIslands(
        marked: MutableList<Boolean>,
        grid: Array<CharArray>,
        verticesValue: CharArray,
        elements: Int
    ): Int {
        var islands = 0
        val graph = getGraph(grid, verticesValue, elements)
        for (vertex in graph.indices) {
            if (verticesValue[vertex] == '1' && marked[vertex].not()) {
                dfs(vertex, graph, marked)
                islands++
            }
        }
        // Log.e("findIslands", islands.toString())

        return islands
    }


    private fun dfs(vertex: Int, graph: List<LinkedList<Int>>, marked: MutableList<Boolean>) {
        marked[vertex] = true
        for (v in graph[vertex]) {
            if (marked[v].not()) {
                dfs(v, graph, marked)
            }
        }
    }
}




