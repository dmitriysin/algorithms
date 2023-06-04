package com.example.algorithms.leetcode.linkedlist

import com.example.algorithms.infrastructure.ListNode

class ReverseLinkedList {
    var previous: ListNode? = null
    fun reverseList(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        val next = head.next
        head.next = previous
        previous = head
        return if (next?.next != null) {
            reverseList(next)
        } else {
            next?.next = previous
            return next
        }
    }
}