package com.example.algorithms.leetcode

import kotlin.math.max

class BuyAndSellStockII {
    fun maxProfit(prices: IntArray): Int {
        var maxProfit = 0
        val cache = arrayOfNulls<Int>(prices.size)
        for (i in 0..prices.lastIndex) {
            var profit = 0
            for (j in i..prices.lastIndex) {
                val maxLast = findMax(j, prices.lastIndex, prices, cache)
                profit = max(findMax(i, j, prices, cache) + maxLast, profit)
            }
            maxProfit = max(profit, maxProfit)
        }
        return maxProfit
    }

    private fun findMax(start: Int, end: Int, prices: IntArray, cache: Array<Int?>): Int {
        var buy = prices[start]
        var profit = 0

        if (cache[end] != null) {
            profit = requireNotNull(cache[end]) + prices[start] - prices[end]
            return if (profit < 0) {
                0
            } else {
                profit
            }
        } else {
            for (i in start..end) {
                if (prices[i] < buy) buy = prices[i]
                else profit = max(profit, prices[i] - buy)
            }
            if (start == 0) {
                cache[end] = profit
            }
        }
        return profit
    }

    /*fun maxProfit1(prices: IntArray): Int {
        var maxProfit = 0
        val cache = arrayOfNulls<Int>(prices.lastIndex)
        for (i in 0..prices.lastIndex) {
            var profit = 0
            for (j in i + 1..prices.lastIndex) {
                val maxLast = if (cache[prices.lastIndex - j] != null) {
                    cache[prices.lastIndex - j]
                } else {
                    val max = findMax(j, prices.lastIndex, prices)
                    cache[prices.lastIndex - j] = max
                    max
                }
                profit = max(findMax(i, j, prices) + requireNotNull(maxLast), profit)
            }
            maxProfit = max(profit, maxProfit)
        }
        return maxProfit
    }*/
}