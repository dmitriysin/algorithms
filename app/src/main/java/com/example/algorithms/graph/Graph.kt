package com.example.algorithms.graph

import java.util.LinkedList

class Graph(private val size: Int) {
    private val graph = Array(size) { LinkedList<Int>() }

    fun addEdge(start: Int, end: Int) {
        if (start > size || end > size) return
        graph[start].add(end)
        graph[end].add(start)
    }

    fun adj(v: Int): Iterable<Int> {
        return graph[v]
    }

    fun getSize(): Int = size
}