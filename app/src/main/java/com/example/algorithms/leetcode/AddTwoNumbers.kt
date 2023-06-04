package com.example.algorithms.leetcode

import com.example.algorithms.infrastructure.ListNode

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
class AddTwoNumbers {

    private var additionalValue = 0
    private var result: ListNode? = null
    private var nextNode: ListNode? = null

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

        val calculatedValue = (l1?.`val` ?: 0) + (l2?.`val` ?: 0) + additionalValue

        if (calculatedValue < 10) {
            additionalValue = 0
            addNode(calculatedValue)
        } else {
            additionalValue = 1
            addNode(calculatedValue - 10)
        }

        if (l1?.next != null || l2?.next != null) {
            addTwoNumbers(l1?.next, l2?.next)
        } else {
            if (additionalValue == 1) {
                addNode(additionalValue)
            }
        }

        return result
    }

    private fun addNode(value: Int) {
        when {
            result == null -> result = ListNode(value)
            result?.next == null -> {
                nextNode = ListNode(value)
                result?.next = nextNode
            }
            else -> {
                val newNode = ListNode(value)
                nextNode?.next = newNode
                nextNode = newNode
            }
        }
    }
}