package com.example.algorithms.leetcode.dp


/**
 * 123
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
 */
class BestTimeBuySellStockIV {
    fun maxProfit(k: Int, prices: IntArray): Int {
        var res = 0
        for (j in 1..k) {
            var n = prices.lastIndex / j
            var profit = 0
            var start = 0
            var end = n
            while (n > 0) {
                profit += calculateProfit(start, end, prices)
                start = end
                end *= n--
            }
            res = Math.max(res, profit)
        }
        return res
    }

    private fun calculateProfit(start: Int, end: Int, prices: IntArray): Int {
        if (end !in prices.indices) return -1
        var i = start
        var buy = start
        var profit = 0
        while (i <= end) {
            if (prices[i] > prices[buy]) profit = Math.max(profit, prices[i] - prices[buy])
            else buy = i
            i++
        }
        return profit
    }

    fun maxProfit1(k: Int, prices: IntArray): Int {
        val dp = Array(k) { IntArray(prices.size) { 0 } }
        for (n in 1..k) {
            var max = Integer.MIN_VALUE

            for (i in 1..prices.lastIndex) {
                max = Math.max(max, dp[n - 1][i - 1] - prices[i - 1])
                dp[k][i] = Math.max(dp[k][i - 1], max + prices[i])

            }
        }
        return dp[k][prices.lastIndex]
    }
}