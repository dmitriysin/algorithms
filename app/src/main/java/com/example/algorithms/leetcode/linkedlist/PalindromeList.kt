package com.example.algorithms.leetcode.linkedlist

import com.example.algorithms.infrastructure.ListNode

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 */

/**
 * 1234567
 * 1 2 3 7 7 3 2 1
 * 1+20+300
 * 300+20+1
 */
class PalindromeList {
    fun isPalindrome(head: ListNode?): Boolean {
        if (head?.next == null) return true

        var slow = head
        var fast = head
        var prev: ListNode? = null
        while (fast?.next != null) {
            val curr = slow
            slow = slow?.next
            fast = fast.next?.next

            curr?.next = prev
            prev = curr
        }

        var forward = slow.takeIf { fast == null } ?: slow?.next
        var back = prev
        while (forward != null) {
            if (forward.`val` != back?.`val`) return false
            forward = forward.next
            back = back.next
        }
        return true
    }
}
