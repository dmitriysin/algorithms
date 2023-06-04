package com.example.algorithms

import java.util.*

internal class Graph1(verticesCount: Int) {

    private val graph: List<LinkedList<Int>> = List(verticesCount) {
        LinkedList()
    }

    fun getVerticesCount() = graph.size

    fun adj(v: Int) = graph[v]

    fun addEdge(v: Int, w: Int) {
        if (graph.size < v || graph.size < w) return
        graph[v].add(w)
        graph[w].add(v)
    }
}