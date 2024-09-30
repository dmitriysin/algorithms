package com.example.algorithms.leetcode.dp

class TimeBuySellStockCooldown {
    fun maxProfit(prices: IntArray): Int {
        val dp = IntArray(prices.size)
        var profit = 0
        for (i in 0..prices.lastIndex) {
             profit += Math.max(calculate(i, prices), calculate(i + 1, prices))
        }
        return profit
    }

    private fun calculate(start: Int, prices: IntArray): Int {
        var profit = 0
        var i = start
        while (i < start+1 && i+1 in prices.indices) {
            if (prices[i+1] > prices[i]) profit += prices[i+1] - prices[i]
            i++
        }
        return profit
    }
}