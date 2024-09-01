package com.example.algorithms.leetcode.dp


/**
 * 123
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
 */
class BestTimeBuySellStockIII {
    fun maxProfit(prices: IntArray): Int {
        val dp = Array(prices.size) { IntArray(prices.size) { -1 }}

        var max = 0
        var i = 0
        while (i < prices.size) {
            val res = findMax(prices, 0, i,dp) + findMax(prices, i, prices.lastIndex,dp)
            if (res > max) max = res
            i++
        }
        return max
    }

    private fun findMax(arr: IntArray, start: Int, end: Int, dp: Array<IntArray>): Int {
        if(dp[end][start] !=-1) return dp[end][start]

        var sell = start
        var buy = start
        var profit = 0
        while (sell <= end) {
            if (arr[sell] > arr[buy]) {
                if (dp[sell][buy] ==-1) dp[sell][buy] = arr[sell] - arr[buy]
                profit = Math.max(profit, dp[sell][buy])
            } else {
                buy = sell
            }
            sell++
        }
        return profit
    }
}