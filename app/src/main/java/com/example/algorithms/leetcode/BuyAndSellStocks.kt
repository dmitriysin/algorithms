package com.example.algorithms.leetcode

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
class BuyAndSellStocks {
    fun maxProfit(prices: IntArray): Int {
        var buy = 0
        var profit = 0
        var sell = 1
        while (sell < prices.size) {
            when {
                prices[buy] >= prices[sell] -> {
                    buy = sell++
                }
                prices[buy] < prices[sell] -> {
                    profit = Math.max(prices[sell++] - prices[buy], profit)
                }
            }
        }
        return profit
    }
}