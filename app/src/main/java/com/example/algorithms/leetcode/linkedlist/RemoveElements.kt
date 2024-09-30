package com.example.algorithms.leetcode.linkedlist

import com.example.algorithms.infrastructure.ListNode

class RemoveElements {
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        var newHead = head
        while (newHead?.`val` == `val`) {
            newHead = newHead.next
        }

        var node = newHead
        while (node != null) {
            if (node.next?.`val` == `val`) {
                node.next = node.next?.next
            } else {
                node = node.next
            }
        }
        return newHead
    }
}