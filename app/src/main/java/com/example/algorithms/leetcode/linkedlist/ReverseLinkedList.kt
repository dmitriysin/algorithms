package com.example.algorithms.leetcode.linkedlist

import com.example.algorithms.infrastructure.ListNode

class ReverseLinkedList {
    fun reverseList(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var curr = head
        while (curr != null) {
            val node = curr.next
            curr.next = prev
            prev = curr
            curr = node
        }
        return prev
    }
}