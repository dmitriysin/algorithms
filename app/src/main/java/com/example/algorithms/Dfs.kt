package com.example.algorithms

import android.util.Log
import java.util.*

internal class Dfs(private val graph: Graph1) {

    private var count = 0
    private val marked = MutableList(graph.getVerticesCount()) {
        false
    }

    private val edgeTo = IntArray(graph.getVerticesCount())

    fun search(vertex: Int = 0) {
        Log.e("vertexNumber", vertex.toString())
        Log.e("vertexMarked", vertex.toString() + ": " + marked[vertex].toString())
        marked[vertex] = true
        count++
        for (v in graph.adj(vertex)) {
            Log.e("currentEdge", "$vertex-$v")
            if (!marked[v]) {
                edgeTo[v] = vertex
                search(v)
            }
        }
    }

    fun pathTo(source: Int, vertex: Int): LinkedList<Int> {
        search(source)
        var currentVertex = vertex
        val linkedList = LinkedList<Int>().apply {
            add(vertex)
        }
        while (currentVertex != source) {
            linkedList.add(edgeTo[currentVertex])
            currentVertex = edgeTo[currentVertex]
        }
        return linkedList
    }
}