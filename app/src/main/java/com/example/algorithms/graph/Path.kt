package com.example.algorithms.graph

import java.util.Stack

class Path(private val graph: Graph) {
    val pathFrom = arrayOfNulls<Int>(graph.getSize())

    fun findPath(v: Int, w: Int): Iterable<Int> {
        val path = Stack<Int>()
        dfs(v, pathFrom)
        var vertex = w
        while (vertex != v) {
            path.push(vertex)
            vertex = requireNotNull(pathFrom[vertex])
        }
        path.push(v)
        return path
    }

    private fun dfs(v: Int, path: Array<Int?>) {
        for (vertex in graph.adj(v)) {
            if (path[vertex] == null) {
                path[vertex] = v
                dfs(vertex, path)
            }
        }
    }
}