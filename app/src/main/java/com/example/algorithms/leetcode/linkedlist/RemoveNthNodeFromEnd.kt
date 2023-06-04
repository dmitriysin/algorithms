package com.example.algorithms.leetcode.linkedlist

import com.example.algorithms.infrastructure.ListNode


/**
 * 19
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
class RemoveNthNodeFromEnd {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var steps = 0
        var sNode = head
        var prev = head
        var curr = head
        while (curr?.next != null) {
            curr = curr.next
            steps++
            if (steps == n) {
                sNode = prev
                prev = curr
                steps = 0
            }
        }

        if (sNode == head && sNode == prev && steps < n) {
            return head?.next
        }

        while (steps > 0) {
            sNode = sNode?.next
            steps--
        }
        sNode?.next = sNode?.next?.next

        return head
    }
}