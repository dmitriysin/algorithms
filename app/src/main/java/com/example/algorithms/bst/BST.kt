package com.example.algorithms.bst

internal class BST<Key : Comparable<Key>, Value> : SymbolTable<Key, Value> {
    private var root: Node<Key, Value>? = null

    override fun put(key: Key, value: Value) {
        //   root = put(root, key, value)
        put1(key, value)
    }

    override fun get(key: Key): Value? {
        return get(root, key)
    }

    private fun put(node: Node<Key, Value>?, key: Key, value: Value): Node<Key, Value> {
        if (node == null) return Node(key, value)
        val cmp = key.compareTo(node.key)
        when {
            cmp < 0 -> node.left = put(node.left, key, value)
            cmp > 0 -> node.right = put(node.right, key, value)
            else -> node.value = value
        }
        return node
    }

    private fun put1(key: Key, value: Value) {
        if (root == null) root = Node(key, value)

        var nodeToInsert = requireNotNull(root)
        while (true) {
            val cmp = key.compareTo(nodeToInsert.key)
            when {
                cmp < 0 -> {
                    if (nodeToInsert.left == null) {
                        nodeToInsert.left = Node(key, value)
                        break
                    } else {
                        nodeToInsert = requireNotNull(nodeToInsert.left)
                    }
                }
                cmp > 0 -> {
                    if (nodeToInsert.right == null) {
                        nodeToInsert.right = Node(key, value)
                        break
                    } else {
                        nodeToInsert = requireNotNull(nodeToInsert.right)
                    }
                }
                else -> break
            }
        }

    }

    private fun getRecursion(node: Node<Key, Value>?, key: Key): Value? {
        if (node == null) return null
        val cmp = key.compareTo(node.key)
        return when {
            cmp < 0 -> getRecursion(node.left, key)
            cmp > 0 -> getRecursion(node.right, key)
            else -> node.value
        }
    }

    private fun get(node: Node<Key, Value>?, key: Key): Value? {
        if (node == null) return null
        var searchNode = node
        while (searchNode != null && searchNode.key != key) {
            val cmp = key.compareTo(node.key)
            when {
                cmp < 0 -> searchNode = searchNode.left
                cmp > 0 -> searchNode = searchNode.right
            }
        }
        return searchNode?.value
    }

    private data class Node<K : Comparable<K>, V>(
        val key: K,
        var value: V,
        var left: Node<K, V>? = null,
        var right: Node<K, V>? = null
    )
}