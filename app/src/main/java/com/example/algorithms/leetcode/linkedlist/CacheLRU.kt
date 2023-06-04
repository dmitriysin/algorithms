package com.example.algorithms.leetcode.linkedlist

class CacheLRU(private val capacity: Int) {
    private val map = HashMap<Int, Node>()
    private var firstNode: Node? = null
    private var lastNode: Node? = null

    fun get(key: Int): Int {
        if (map.contains(key)) {
            val node = requireNotNull(map[key])

            if (map.size > 1) {
                //check for last
                if (node.next == null) {
                    lastNode = node.prev
                }

                node.prev?.next = node.next
                node.next?.prev = node.prev

                //set to first
                firstNode?.prev = node
                node.next = firstNode
                firstNode = node
                firstNode?.prev = null
            }

            return node.value
        }
        return -1
    }

    fun put(key: Int, value: Int) {
        if (map.contains(key)) {
            val oldNode = requireNotNull(map[key])
            oldNode.value = value
            if (map.size > 1) {
                if (oldNode.next == null) {
                    lastNode = oldNode.prev
                }

                oldNode.prev?.next = oldNode.next
                oldNode.next?.prev = oldNode.prev

                //set to first
                firstNode?.prev = oldNode
                oldNode.next = firstNode
                firstNode = oldNode
                firstNode?.prev = null
            }

            map[key] = oldNode
        } else {
            if (map.size == capacity) {
                map.remove(lastNode?.key)
                lastNode = lastNode?.prev
                lastNode?.next = null
            }
            val node = Node(prev = null, next = firstNode, key = key, value = value)
            firstNode?.prev = node
            firstNode = node

            if (lastNode == null) lastNode = node

            map[key] = node
        }
    }

    private class Node(
        var next: Node?,
        var prev: Node?,
        val key: Int,
        var value: Int
    )
}