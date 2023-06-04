package com.example.algorithms

import android.util.Log

internal class ConnectedComponents {

    private val graph = Graph1(13).apply {
        addEdge(0, 1)
        addEdge(0, 2)
        addEdge(0, 5)
        addEdge(0, 6)
        addEdge(3, 4)
        addEdge(3, 5)
        addEdge(4, 5)
        addEdge(4, 6)
        addEdge(7, 8)
        addEdge(9, 10)
        addEdge(9, 11)
        addEdge(9, 12)
        addEdge(11, 12)
    }

    private val marked = MutableList(graph.getVerticesCount()) { false }
    private val component = MutableList(graph.getVerticesCount()) { 0 }
    private var count = 0

    fun findConnectedComponents() {
        for (v in 0 until graph.getVerticesCount()) {
            if (marked[v].not()) {
                dfs(v)
                count++
            }
        }
        Log.e("findConnectedComponents", component.toString())
    }

    private fun dfs(vertex: Int) {
        for (v in graph.adj(vertex)) {
            if (marked[v].not()) {
                marked[v] = true
                component[v] = count
                dfs(v)
            }
        }
    }
}