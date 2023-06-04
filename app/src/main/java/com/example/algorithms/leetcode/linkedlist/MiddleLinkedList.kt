package com.example.algorithms.leetcode.linkedlist

import com.example.algorithms.infrastructure.ListNode

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/
 */
class MiddleLinkedList {
    fun middleNode(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        var slow = head
        var faster = head.next
        while (faster?.next?.next != null){
            slow = slow?.next
            faster = faster.next?.next
        }
        return slow?.next
    }
}