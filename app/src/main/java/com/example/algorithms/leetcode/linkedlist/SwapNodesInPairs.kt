package com.example.algorithms.leetcode.linkedlist

import com.example.algorithms.infrastructure.ListNode

/**
 * 24
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
class SwapNodesInPairs {
    fun swapPairs(head: ListNode?): ListNode? {
        val stub = ListNode(-1)
        stub.next = head
        var node: ListNode? = stub
        while (node?.next?.next != null) {
            val nextNode = node.next
            val secondNode = node.next?.next
            nextNode?.next = secondNode?.next
            secondNode?.next = nextNode
            node.next = secondNode
            node = node.next?.next
        }
        return stub.next
    }
}