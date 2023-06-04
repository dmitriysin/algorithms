package com.example.algorithms

import android.util.Log

internal class GraphSearch {

    private fun createGraph() =
        Graph1(6).apply {
            addEdge(0, 2)
            addEdge(0, 1)
            addEdge(0, 5)
            addEdge(2, 1)
            addEdge(2, 3)
            addEdge(2, 4)
            addEdge(4, 3)
            addEdge(3, 5)
        }

    fun dfsSearch() {
        val graph = createGraph()
        val dfs = Dfs(graph)
        dfs.search()
    }

    fun bfsSearch() {
        val graph = createGraph()
        val bfs = Bfs(graph)
        bfs.search(0)
    }


    fun dfsPath() {
        val graph = createGraph()
        val dfs = Dfs(graph)
        val list = dfs.pathTo(0,5)
        Log.e("path", list.toString())
    }

    fun bfsPath() {
        val graph = createGraph()
        val bfs = Bfs(graph)
        val list = bfs.pathTo(0,5)
        Log.e("path", list.toString())
    }
}