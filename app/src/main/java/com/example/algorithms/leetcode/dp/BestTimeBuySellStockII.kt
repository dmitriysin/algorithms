package com.example.algorithms.leetcode.dp


/**
 * 122
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
class BestTimeBuySellStockII {
    fun maxProfit(prices: IntArray): Int {
        var profit = 0
        for (i in 1..prices.lastIndex) {
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1]
        }
        return profit
    }
}