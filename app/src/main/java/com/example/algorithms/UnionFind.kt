package com.example.algorithms


class UnionFind(count: Int) {

    private val id: IntArray = IntArray(count)
    private val size: IntArray = IntArray(count)

    init {
        for (i in 1..count) {
            id[i] = i
            size[i] = 1
        }
    }

    private fun root(i: Int): Int {
        var j = i
        while (j != id[j]) j = id[j]
        return j
    }

    fun connected(p: Int, q: Int) = root(p) == root(q)

    fun union(p: Int, q: Int) {
        val i = root(p)
        val j = root(q)

        if (size[i] < size[j]) {
            id[i] = j
            size[j] += size[i]
        } else {
            id[j] = i
            size[i] += size[j]
        }
    }
}