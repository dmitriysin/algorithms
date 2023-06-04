package com.example.algorithms.leetcode.linkedlist

import com.example.algorithms.infrastructure.ListNode

/**
 * 65
 * https://leetcode.com/problems/rotate-list/description/
 */
class RotateList {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head?.next == null || k == 0) return head
        var n = k
        var slow = head
        var fast = head
        var steps = 0
        while (steps != n) {
            if (fast?.next == null) {
                n = k % (steps + 1)
                if (n == 0) return head
                fast = head
                steps = 0
            } else {
                fast = fast.next
                steps++
            }
        }
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next
        }
        val res = slow?.next
        slow?.next = null
        fast?.next = head
        return res
    }
}