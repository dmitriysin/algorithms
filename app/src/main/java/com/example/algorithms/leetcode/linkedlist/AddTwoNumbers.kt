package com.example.algorithms.leetcode.linkedlist

import com.example.algorithms.infrastructure.ListNode

class AddTwoNumbers {

    private fun reverseList(l: ListNode?): ListNode? {
        var prev = l
        var curr = l?.next
        var next: ListNode?
        while (curr != null) {
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        }
        return prev
    }
}