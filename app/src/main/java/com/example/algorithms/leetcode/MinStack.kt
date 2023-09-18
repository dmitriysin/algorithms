package com.example.algorithms.leetcode

/**
 * 155
 * https://leetcode.com/problems/min-stack/
 */
class MinStack {
    private var node: Node? = null

    fun push(`val`: Int) {
        node = if (node == null) {
            Node(`val`, `val`)
        } else {
            Node(value = `val`, Math.min(`val`, node!!.min), prev = node)
        }
    }

    fun pop() {
        node = node?.prev
    }

    fun top(): Int {
        return node?.value ?: -1
    }

    fun getMin(): Int {
        return node?.min ?: -1
    }

    private class Node(val value: Int, val min: Int, var prev: Node? = null)
}