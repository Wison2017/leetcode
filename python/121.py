import sys


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        min = sys.maxsize
        profit = 0
        for i in range(0, len(prices)):
            if prices[i] < min: min = prices[i]
            elif (prices[i] - min) > profit:
                profit = prices[i] - min
        return profit

