package com.example.algorithms.leetcode.tree

import com.example.algorithms.infrastructure.ListNode
import com.example.algorithms.infrastructure.TreeNode

/**
 * 109
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */
class SortedLinkedListToBST {
    fun sortedListToBST(head: ListNode?): TreeNode? {
        if (head == null) return null
        if (head.next == null) return TreeNode(head.`val`)
        var fast = head
        var slow = head
        var prev: ListNode? = null
        while (fast?.next != null) {
            prev = slow
            slow = slow?.next
            fast = fast.next?.next
        }
        prev?.next = null
        val root = TreeNode(requireNotNull(slow).`val`)
        root.right = sortedListToBST(slow.next)
        root.left = sortedListToBST(head)
        return root
    }
}