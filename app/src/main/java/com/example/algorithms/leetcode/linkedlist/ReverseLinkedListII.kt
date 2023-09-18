package com.example.algorithms.leetcode.linkedlist

import com.example.algorithms.infrastructure.ListNode


/**
 * 92
 * https://leetcode.com/problems/reverse-linked-list-ii/
 */
class ReverseLinkedListII {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        val node = ListNode(0).apply { next = head }

        var i = 0
        var start: ListNode? = node
        while (i < left - 1) {
            start = start?.next
            i++
        }

        val revTail = start?.next

        var prev: ListNode? = null
        var curr = revTail

        while (i < right) {
            val next = curr?.next
            curr?.next = prev
            prev = curr
            curr = next
            i++
        }

        revTail?.next = curr
        start?.next = prev

        return node.next
    }
}