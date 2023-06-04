package com.example.algorithms.leetcode

import com.example.algorithms.infrastructure.ListNode

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */

class MergeTwoLists {

    private var resultList: ListNode? = null
    private var lastNode: ListNode? = null
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        return when {
            list1 == null && list2 != null -> {
                addNode(list2.`val`)
                mergeTwoLists(null, list2.next)
            }
            list2 == null && list1 != null -> {
                addNode(list1.`val`)
                mergeTwoLists(list1.next, null)
            }
            list1 == null && list2 == null -> {
                resultList
            }
            else -> {
                val value1 = requireNotNull(list1).`val`
                val value2 = requireNotNull(list2).`val`

                if (value1 > value2) {
                    addNode(value2)
                    mergeTwoLists(list1, list2.next)
                } else {
                    addNode(value1)
                    mergeTwoLists(list1.next, list2)
                }
            }
        }
    }

    private fun addNode(value: Int) {
        when {
            resultList == null -> resultList = ListNode(value)
            resultList?.next == null -> {
                lastNode = ListNode(value)
                resultList?.next = lastNode
            }
            else -> {
                lastNode?.next = ListNode(value)
                lastNode = lastNode?.next
            }
        }
    }
}