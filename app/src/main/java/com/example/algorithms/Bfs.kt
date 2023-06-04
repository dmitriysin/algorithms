package com.example.algorithms

import android.util.Log
import java.util.*

internal class Bfs(private val graph: Graph1) {

    private val edgeTo = IntArray(graph.getVerticesCount())
    private val marked = MutableList(graph.getVerticesCount()) {
        false
    }

    fun search(startVertex: Int) {

        val queue = LinkedList<Int>().apply {
            add(startVertex)
        }

        while (queue.isNotEmpty()) {
            Log.e("queue", queue.toString())

            val currentVertex = queue.removeFirst()
            for (v in graph.adj(currentVertex)) {
                if (marked[v].not()) {
                    marked[v] = true
                    queue.add(v)
                    edgeTo[v] = currentVertex
                }
            }
        }
    }

    fun pathTo(startVertex: Int, destinationVertex: Int): LinkedList<Int> {

        search(startVertex)

        val list = LinkedList<Int>()
        var currentVertex = destinationVertex

        list.add(currentVertex)

        while (currentVertex != startVertex) {
            list.add(edgeTo[currentVertex])
            currentVertex = edgeTo[currentVertex]
        }

        return list
    }

}