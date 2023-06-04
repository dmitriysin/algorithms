package com.example.algorithms

import com.example.algorithms.graph.Graph
import com.example.algorithms.graph.Path
import org.junit.Test

internal class GraphTest {

    @Test
    fun testDfs() {
        val graph = Graph(10)
        graph.addEdge(0, 6)
        graph.addEdge(6, 4)
        graph.addEdge(4, 5)
        graph.addEdge(5, 3)
        graph.addEdge(5, 0)
        graph.addEdge(0, 1)
        graph.addEdge(0, 2)
        val path = Path(graph)
        val dfs = path.findPath(0, 3)
        val pf = path.pathFrom
        val res = 0
    }
}